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

import com.liferay.osb.koroneiki.taproot.exception.TeamNameException;
import com.liferay.osb.koroneiki.taproot.model.Team;
import com.liferay.osb.koroneiki.taproot.service.base.TeamLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;

import java.util.LinkedHashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.taproot.model.Team",
	service = AopService.class
)
public class TeamLocalServiceImpl extends TeamLocalServiceBaseImpl {

	public Team addTeam(long userId, long accountId, String name)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		validate(name);

		long teamId = counterLocalService.increment();

		Team team = teamPersistence.create(teamId);

		team.setCompanyId(user.getCompanyId());
		team.setUserId(userId);
		team.setAccountId(accountId);
		team.setName(name);

		teamPersistence.update(team);

		// Resources

		resourceLocalService.addResources(
			team.getCompanyId(), 0, userId, Team.class.getName(),
			team.getTeamId(), false, false, false);

		return team;
	}

	@Override
	public Team deleteTeam(long teamId) throws PortalException {
		Team team = teamLocalService.getTeam(teamId);

		// Resources

		resourceLocalService.deleteResource(
			team.getCompanyId(), Team.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, team.getTeamId());

		return teamPersistence.remove(teamId);
	}

	public List<Team> getProjectTeams(long projectId, int start, int end) {
		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("project", projectId);

		return teamFinder.findByName(null, params, start, end);
	}

	public int getProjectTeamsCount(long projectId) {
		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("project", projectId);

		return teamFinder.countByName(null, params);
	}

	public List<Team> getTeams(String name) throws PortalException {
		return teamPersistence.findByName(name);
	}

	public Team updateTeam(long teamId, String name) throws PortalException {
		validate(name);

		Team team = teamPersistence.findByPrimaryKey(teamId);

		team.setName(name);

		return teamPersistence.update(team);
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new TeamNameException();
		}
	}

}