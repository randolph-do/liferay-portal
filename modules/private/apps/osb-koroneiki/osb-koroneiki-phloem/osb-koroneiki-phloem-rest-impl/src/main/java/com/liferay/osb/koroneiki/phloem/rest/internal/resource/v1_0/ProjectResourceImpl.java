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

package com.liferay.osb.koroneiki.phloem.rest.internal.resource.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Project;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.util.ProjectUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProjectResource;
import com.liferay.osb.koroneiki.taproot.constants.ContactRoleType;
import com.liferay.osb.koroneiki.taproot.constants.WorkflowConstants;
import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.osb.koroneiki.taproot.service.ContactProjectRoleService;
import com.liferay.osb.koroneiki.taproot.service.ContactRoleLocalService;
import com.liferay.osb.koroneiki.taproot.service.ContactService;
import com.liferay.osb.koroneiki.taproot.service.ProjectService;
import com.liferay.osb.koroneiki.taproot.service.TeamProjectRoleService;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Amos Fong
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/project.properties",
	scope = ServiceScope.PROTOTYPE, service = ProjectResource.class
)
public class ProjectResourceImpl extends BaseProjectResourceImpl {

	@Override
	public void deleteProject(String projectKey) throws Exception {
		_projectService.deleteProject(projectKey);
	}

	@Override
	public void deleteProjectContact(String projectKey, String[] contactKeys)
		throws Exception {

		for (String contactKey : contactKeys) {
			_contactProjectRoleService.deleteContactProjectRoles(
				contactKey, projectKey);
		}
	}

	@Override
	public void deleteProjectContactContactKeyRole(
			String projectKey, String contactKey, String[] contactRoleKeys)
		throws Exception {

		for (String contactRoleKey : contactRoleKeys) {
			_contactProjectRoleService.deleteContactProjectRole(
				contactKey, projectKey, contactRoleKey);
		}
	}

	@Override
	public void deleteProjectTeamTeamKeyRole(
			String projectKey, String teamKey, String[] teamRoleKeys)
		throws Exception {

		for (String teamRoleKey : teamRoleKeys) {
			_teamProjectRoleService.deleteTeamProjectRole(
				teamKey, projectKey, teamRoleKey);
		}
	}

	@Override
	public Page<Project> getAccountAccountKeyProjectsPage(
			String accountKey, Pagination pagination)
		throws Exception {

		return Page.of(
			transform(
				_projectService.getProjects(
					accountKey, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ProjectUtil::toProject),
			pagination, _projectService.getProjectsCount(accountKey));
	}

	@Override
	public Project getProject(String projectKey) throws Exception {
		return ProjectUtil.toProject(_projectService.getProject(projectKey));
	}

	@Override
	public Project postAccountAccountKeyProject(
			String accountKey, Project project)
		throws Exception {

		Project.Industry projectIndustry = project.getIndustry();

		Project.Status projectStatus = project.getStatus();

		int status = WorkflowConstants.getLabelStatus(projectStatus.toString());

		Project.Tier projectTier = project.getTier();

		return ProjectUtil.toProject(
			_projectService.addProject(
				accountKey, project.getName(), project.getCode(),
				projectTier.toString(), projectIndustry.toString(),
				project.getNotes(), project.getSoldBy(), status));
	}

	@Override
	public Project putProject(String projectKey, Project project)
		throws Exception {

		Project.Industry projectIndustry = project.getIndustry();

		Project.Status projectStatus = project.getStatus();

		int status = WorkflowConstants.getLabelStatus(projectStatus.toString());

		Project.Tier projectTier = project.getTier();

		return ProjectUtil.toProject(
			_projectService.updateProject(
				projectKey, project.getName(), project.getCode(),
				projectTier.toString(), projectIndustry.toString(),
				project.getNotes(), project.getSoldBy(), status));
	}

	@Override
	public void putProjectContact(String projectKey, String[] contactKeys)
		throws Exception {

		ContactRole contactRole = _contactRoleLocalService.getMemberContactRole(
			ContactRoleType.PROJECT);

		for (String contactKey : contactKeys) {
			_contactProjectRoleService.addContactProjectRole(
				contactKey, projectKey, contactRole.getContactRoleKey());
		}
	}

	@Override
	public void putProjectContactContactKeyRole(
			String projectKey, String contactKey, String[] contactRoleKeys)
		throws Exception {

		for (String contactRoleKey : contactRoleKeys) {
			_contactProjectRoleService.addContactProjectRole(
				contactKey, projectKey, contactRoleKey);
		}
	}

	@Override
	public void putProjectTeamTeamKeyRole(
			String projectKey, String teamKey, String[] teamRoleKeys)
		throws Exception {

		for (String teamRoleKey : teamRoleKeys) {
			_teamProjectRoleService.addTeamProjectRole(
				teamKey, projectKey, teamRoleKey);
		}
	}

	@Reference
	private ContactProjectRoleService _contactProjectRoleService;

	@Reference
	private ContactRoleLocalService _contactRoleLocalService;

	@Reference
	private ContactService _contactService;

	@Reference
	private ProjectService _projectService;

	@Reference
	private TeamProjectRoleService _teamProjectRoleService;

}