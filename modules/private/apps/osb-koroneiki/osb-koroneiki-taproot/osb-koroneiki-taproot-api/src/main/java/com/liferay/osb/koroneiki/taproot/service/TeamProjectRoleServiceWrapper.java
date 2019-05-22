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

package com.liferay.osb.koroneiki.taproot.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link TeamProjectRoleService}.
 *
 * @author Brian Wing Shun Chan
 * @see TeamProjectRoleService
 * @generated
 */
@ProviderType
public class TeamProjectRoleServiceWrapper
	implements TeamProjectRoleService, ServiceWrapper<TeamProjectRoleService> {

	public TeamProjectRoleServiceWrapper(
		TeamProjectRoleService teamProjectRoleService) {

		_teamProjectRoleService = teamProjectRoleService;
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
			addTeamProjectRole(long teamId, long projectId, long teamRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamProjectRoleService.addTeamProjectRole(
			teamId, projectId, teamRoleId);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
			deleteTeamProjectRole(long teamId, long projectId, long teamRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamProjectRoleService.deleteTeamProjectRole(
			teamId, projectId, teamRoleId);
	}

	@Override
	public void deleteTeamProjectRoles(long teamId, long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_teamProjectRoleService.deleteTeamProjectRoles(teamId, projectId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _teamProjectRoleService.getOSGiServiceIdentifier();
	}

	@Override
	public TeamProjectRoleService getWrappedService() {
		return _teamProjectRoleService;
	}

	@Override
	public void setWrappedService(
		TeamProjectRoleService teamProjectRoleService) {

		_teamProjectRoleService = teamProjectRoleService;
	}

	private TeamProjectRoleService _teamProjectRoleService;

}