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
import com.liferay.osb.koroneiki.root.util.ModelKeyGenerator;
import com.liferay.osb.koroneiki.taproot.exception.ProjectNameException;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.service.base.ProjectLocalServiceBaseImpl;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Indexable(type = IndexableType.REINDEX)
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
		project.setProjectKey(ModelKeyGenerator.generate(projectId));
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
		return deleteProject(getProject(projectId));
	}

	@Override
	public Project deleteProject(Project project) throws PortalException {

		// Contact project roles

		contactProjectRolePersistence.removeByProjectId(project.getProjectId());

		// External links

		long classNameId = classNameLocalService.getClassNameId(Project.class);

		_externalLinkLocalService.deleteExternalLinks(
			classNameId, project.getProjectId());

		// Resources

		resourceLocalService.deleteResource(
			project.getCompanyId(), Project.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, project.getProjectId());

		// Team project roles

		teamProjectRolePersistence.removeByProjectId(project.getProjectId());

		return projectPersistence.remove(project);
	}

	public Project getProject(String projectKey) throws PortalException {
		return projectPersistence.findByProjectKey(projectKey);
	}

	public List<Project> getProjects(long accountId, int start, int end) {
		return projectPersistence.findByAccountId(accountId, start, end);
	}

	public int getProjectsCount(long accountId) {
		return projectPersistence.countByAccountId(accountId);
	}

	@Indexable(type = IndexableType.REINDEX)
	public Project reindex(long projectId) throws PortalException {
		return projectPersistence.findByPrimaryKey(projectId);
	}

	public Hits search(
			long companyId, String keywords, int start, int end, Sort sort)
		throws PortalException {

		try {
			Indexer<Project> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				Project.class);

			SearchContext searchContext = new SearchContext();

			searchContext.setAndSearch(false);

			Map<String, Serializable> attributes = new HashMap<>();

			attributes.put("code", keywords);
			attributes.put("contactKeys", keywords);
			attributes.put("name", keywords);
			attributes.put("notes", keywords);
			attributes.put("productEntryKeys", keywords);

			searchContext.setAttributes(attributes);

			searchContext.setCompanyId(companyId);
			searchContext.setEnd(end);

			if (sort != null) {
				searchContext.setSorts(sort);
			}

			searchContext.setStart(start);

			QueryConfig queryConfig = searchContext.getQueryConfig();

			queryConfig.setHighlightEnabled(false);
			queryConfig.setScoreEnabled(false);

			return indexer.search(searchContext);
		}
		catch (Exception e) {
			throw new PortalException(e);
		}
	}

	@Indexable(type = IndexableType.REINDEX)
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