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

import com.liferay.osb.koroneiki.taproot.model.TeamProjectRole;
import com.liferay.osb.koroneiki.taproot.service.base.TeamProjectRoleLocalServiceBaseImpl;
import com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectRolePK;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.taproot.model.TeamProjectRole",
	service = AopService.class
)
public class TeamProjectRoleLocalServiceImpl
	extends TeamProjectRoleLocalServiceBaseImpl {

	public TeamProjectRole addTeamProjectRole(
			long teamId, long projectId, long teamRoleId)
		throws PortalException {

		validate(teamId, projectId);

		TeamProjectRolePK teamProjectRolePK = new TeamProjectRolePK(
			teamId, projectId, teamRoleId);

		TeamProjectRole teamProjectRole =
			teamProjectRolePersistence.fetchByPrimaryKey(teamProjectRolePK);

		if (teamProjectRole == null) {
			teamProjectRole = teamProjectRolePersistence.create(
				teamProjectRolePK);

			teamProjectRolePersistence.update(teamProjectRole);
		}

		return teamProjectRole;
	}

	public TeamProjectRole deleteTeamProjectRole(
		long teamId, long projectId, long teamRoleId) {

		TeamProjectRolePK teamProjectRolePK = new TeamProjectRolePK(
			teamId, projectId, teamRoleId);

		TeamProjectRole teamProjectRole =
			teamProjectRolePersistence.fetchByPrimaryKey(teamProjectRolePK);

		if (teamProjectRole != null) {
			deleteTeamProjectRole(teamProjectRole);
		}

		return teamProjectRole;
	}

	public void deleteTeamProjectRoles(long teamId, long projectId) {
		teamProjectRolePersistence.removeByT_P(teamId, projectId);
	}

	protected void validate(long teamId, long projectId)
		throws PortalException {

		teamPersistence.findByPrimaryKey(teamId);

		projectPersistence.findByPrimaryKey(projectId);
	}

}