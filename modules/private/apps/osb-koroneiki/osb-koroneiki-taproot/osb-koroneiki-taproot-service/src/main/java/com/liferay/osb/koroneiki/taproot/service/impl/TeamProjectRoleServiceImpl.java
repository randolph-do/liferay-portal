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

import com.liferay.osb.koroneiki.taproot.constants.TaprootActionKeys;
import com.liferay.osb.koroneiki.taproot.model.TeamProjectRole;
import com.liferay.osb.koroneiki.taproot.permission.ProjectPermission;
import com.liferay.osb.koroneiki.taproot.service.base.TeamProjectRoleServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=TeamProjectRole"
	},
	service = AopService.class
)
public class TeamProjectRoleServiceImpl extends TeamProjectRoleServiceBaseImpl {

	public TeamProjectRole addTeamProjectRole(
			long teamId, long projectId, long teamRoleId)
		throws PortalException {

		_projectPermission.check(
			getPermissionChecker(), projectId, TaprootActionKeys.ASSIGN_TEAM);

		return teamProjectRoleLocalService.addTeamProjectRole(
			teamId, projectId, teamRoleId);
	}

	public TeamProjectRole deleteTeamProjectRole(
			long teamId, long projectId, long teamRoleId)
		throws PortalException {

		_projectPermission.check(
			getPermissionChecker(), projectId, TaprootActionKeys.ASSIGN_TEAM);

		return teamProjectRoleLocalService.deleteTeamProjectRole(
			teamId, projectId, teamRoleId);
	}

	public void deleteTeamProjectRoles(long teamId, long projectId)
		throws PortalException {

		_projectPermission.check(
			getPermissionChecker(), projectId, TaprootActionKeys.ASSIGN_TEAM);

		teamProjectRoleLocalService.deleteTeamProjectRoles(teamId, projectId);
	}

	@Reference
	private ProjectPermission _projectPermission;

}