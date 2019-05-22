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

import com.liferay.osb.koroneiki.taproot.model.TeamRole;
import com.liferay.osb.koroneiki.taproot.service.base.TeamRoleServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=TeamRole"
	},
	service = AopService.class
)
public class TeamRoleServiceImpl extends TeamRoleServiceBaseImpl {

	public TeamRole addTeamRole(
			long userId, String name, String description, int type)
		throws PortalException {

		return teamRoleLocalService.addTeamRole(
			userId, name, description, type);
	}

	public TeamRole deleteTeamRole(long teamRoleId) throws PortalException {
		return teamRoleLocalService.deleteTeamRole(teamRoleId);
	}

	public TeamRole updateTeamRole(
			long userId, long teamRoleId, String name, String description)
		throws PortalException {

		return teamRoleLocalService.updateTeamRole(
			userId, teamRoleId, name, description);
	}

}