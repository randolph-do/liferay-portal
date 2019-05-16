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
 * Provides a wrapper for {@link TeamProjectService}.
 *
 * @author Brian Wing Shun Chan
 * @see TeamProjectService
 * @generated
 */
@ProviderType
public class TeamProjectServiceWrapper
	implements TeamProjectService, ServiceWrapper<TeamProjectService> {

	public TeamProjectServiceWrapper(TeamProjectService teamProjectService) {
		_teamProjectService = teamProjectService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _teamProjectService.getOSGiServiceIdentifier();
	}

	@Override
	public TeamProjectService getWrappedService() {
		return _teamProjectService;
	}

	@Override
	public void setWrappedService(TeamProjectService teamProjectService) {
		_teamProjectService = teamProjectService;
	}

	private TeamProjectService _teamProjectService;

}