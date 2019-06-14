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
import com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util.ProjectUtil;
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
	public void deleteProject(Long projectId) throws Exception {
		_projectService.deleteProject(projectId);
	}

	@Override
	public void deleteProjectContact(Long projectId, Long[] contactIds)
		throws Exception {

		for (Long contactId : contactIds) {
			_contactProjectRoleService.deleteContactProjectRoles(
				contactId, projectId);
		}
	}

	@Override
	public void deleteProjectContactRole(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception {

		for (Long contactRoleId : contactRoleIds) {
			_contactProjectRoleService.deleteContactProjectRole(
				contactId, projectId, contactRoleId);
		}
	}

	@Override
	public void deleteProjectTeamRole(
			Long projectId, Long teamId, Long[] teamRoleIds)
		throws Exception {

		for (long teamRoleId : teamRoleIds) {
			_teamProjectRoleService.deleteTeamProjectRole(
				teamId, projectId, teamRoleId);
		}
	}

	@Override
	public Page<Project> getAccountProjectsPage(
			Long accountId, Pagination pagination)
		throws Exception {

		return Page.of(
			transform(
				_projectService.getProjects(
					accountId, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ProjectUtil::toProject),
			pagination, _projectService.getProjectsCount(accountId));
	}

	@Override
	public Project getProject(Long projectId) throws Exception {
		return ProjectUtil.toProject(_projectService.getProject(projectId));
	}

	@Override
	public Project postAccountProject(Long accountId, Project project)
		throws Exception {

		int status = WorkflowConstants.getLabelStatus(project.getStatus());

		return ProjectUtil.toProject(
			_projectService.addProject(
				accountId, project.getName(), project.getCode(),
				project.getTier(), project.getIndustry(), project.getNotes(),
				project.getSoldBy(), status));
	}

	@Override
	public Project putProject(Long projectId, Project project)
		throws Exception {

		int status = WorkflowConstants.getLabelStatus(project.getStatus());

		return ProjectUtil.toProject(
			_projectService.updateProject(
				projectId, project.getName(), project.getCode(),
				project.getTier(), project.getIndustry(), project.getNotes(),
				project.getSoldBy(), status));
	}

	@Override
	public void putProjectContact(Long projectId, Long[] contactIds)
		throws Exception {

		ContactRole contactRole = _contactRoleLocalService.getMemberContactRole(
			ContactRoleType.PROJECT);

		for (Long contactId : contactIds) {
			_contactProjectRoleService.addContactProjectRole(
				contactId, projectId, contactRole.getContactRoleId());
		}
	}

	@Override
	public void putProjectContactRole(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception {

		for (Long contactRoleId : contactRoleIds) {
			_contactProjectRoleService.addContactProjectRole(
				contactId, projectId, contactRoleId);
		}
	}

	@Override
	public void putProjectTeamRole(
			Long projectId, Long teamId, Long[] teamRoleIds)
		throws Exception {

		for (long teamRoleId : teamRoleIds) {
			_teamProjectRoleService.addTeamProjectRole(
				teamId, projectId, teamRoleId);
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