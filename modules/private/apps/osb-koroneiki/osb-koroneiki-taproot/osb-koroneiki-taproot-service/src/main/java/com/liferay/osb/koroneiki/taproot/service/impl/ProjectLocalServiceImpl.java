/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.osb.koroneiki.taproot.service.impl;

import com.liferay.osb.koroneiki.root.service.ExternalLinkLocalService;
import com.liferay.osb.koroneiki.taproot.exception.ProjectNameException;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.service.base.ProjectLocalServiceBaseImpl;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.taproot.model.Project",
	service = AopService.class
)
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {

	public Project addProject(
			long userId, long accountId, String name, String code,
			String industry, String tier, String notes, String soldBy,
			int status)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		accountPersistence.findByPrimaryKey(accountId);

		validate(name);

		long projectId = counterLocalService.increment();

		Project project = projectPersistence.create(projectId);

		project.setCompanyId(user.getCompanyId());
		project.setUserId(userId);
		project.setAccountId(accountId);
		project.setName(name);
		project.setCode(code);
		project.setIndustry(industry);
		project.setTier(tier);
		project.setNotes(notes);
		project.setSoldBy(soldBy);
		project.setStatus(status);
		project.setStatusByUserId(userId);
		project.setStatusByUserName(user.getFullName());
		project.setStatusDate(new Date());
		project.setStatusMessage(StringPool.BLANK);

		projectPersistence.update(project);

		// Resources

		resourceLocalService.addResources(
			project.getCompanyId(), 0, userId, Project.class.getName(),
			project.getProjectId(), false, false, false);

		return project;
	}

	@Override
	public Project deleteProject(long projectId) throws PortalException {
		Project project = projectLocalService.getProject(projectId);

		// Contact project roles

		contactProjectRolePersistence.removeByProjectId(projectId);

		// External links

		long classNameId = classNameLocalService.getClassNameId(Project.class);

		_externalLinkLocalService.deleteExternalLinks(classNameId, projectId);

		// Resources

		resourceLocalService.deleteResource(
			project.getCompanyId(), Project.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, project.getProjectId());

		// Team project roles

		teamProjectRolePersistence.removeByProjectId(projectId);

		return projectPersistence.remove(projectId);
	}

	public List<Project> getProjects(long accountId, int start, int end) {
		return projectPersistence.findByAccountId(accountId, start, end);
	}

	public int getProjectsCount(long accountId) {
		return projectPersistence.countByAccountId(accountId);
	}

	public Project updateProject(
			long userId, long projectId, String name, String code,
			String industry, String tier, String notes, String soldBy,
			int status)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		validate(name);

		Project project = projectPersistence.findByPrimaryKey(projectId);

		project.setName(name);
		project.setCode(code);
		project.setIndustry(industry);
		project.setTier(tier);
		project.setNotes(notes);
		project.setSoldBy(soldBy);
		project.setStatus(status);
		project.setStatusByUserId(userId);
		project.setStatusByUserName(user.getFullName());
		project.setStatusDate(new Date());
		project.setStatusMessage(StringPool.BLANK);

		return projectPersistence.update(project);
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new ProjectNameException();
		}
	}

	@Reference
	private ExternalLinkLocalService _externalLinkLocalService;

}