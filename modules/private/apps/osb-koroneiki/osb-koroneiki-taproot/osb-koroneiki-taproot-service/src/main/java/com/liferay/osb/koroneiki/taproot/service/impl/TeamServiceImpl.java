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
import com.liferay.osb.koroneiki.taproot.model.Team;
import com.liferay.osb.koroneiki.taproot.permission.AccountPermission;
import com.liferay.osb.koroneiki.taproot.permission.TeamPermission;
import com.liferay.osb.koroneiki.taproot.service.base.TeamServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=Team"
	},
	service = AopService.class
)
public class TeamServiceImpl extends TeamServiceBaseImpl {

	public Team addTeam(long accountId, String name) throws PortalException {
		_teamPermission.check(
			getPermissionChecker(), TaprootActionKeys.ADD_TEAM);

		return teamLocalService.addTeam(getUserId(), accountId, name);
	}

	public Team deleteTeam(long teamId) throws PortalException {
		_teamPermission.check(
			getPermissionChecker(), teamId, ActionKeys.DELETE);

		return teamLocalService.deleteTeam(teamId);
	}

	public List<Team> getAccountTeams(long accountId, int start, int end)
		throws PortalException {

		_accountPermission.check(
			getPermissionChecker(), accountId, ActionKeys.VIEW);

		return teamLocalService.getAccountTeams(accountId, start, end);
	}

	public int getAccountTeamsCount(long accountId) throws PortalException {
		_accountPermission.check(
			getPermissionChecker(), accountId, ActionKeys.VIEW);

		return teamLocalService.getAccountTeamsCount(accountId);
	}

	public Team getTeam(long teamId) throws PortalException {
		_teamPermission.check(getPermissionChecker(), teamId, ActionKeys.VIEW);

		return teamLocalService.getTeam(teamId);
	}

	public Team updateTeam(long teamId, String name) throws PortalException {
		_teamPermission.check(
			getPermissionChecker(), teamId, ActionKeys.UPDATE);

		return teamLocalService.updateTeam(teamId, name);
	}

	@Reference
	private AccountPermission _accountPermission;

	@Reference
	private TeamPermission _teamPermission;

}