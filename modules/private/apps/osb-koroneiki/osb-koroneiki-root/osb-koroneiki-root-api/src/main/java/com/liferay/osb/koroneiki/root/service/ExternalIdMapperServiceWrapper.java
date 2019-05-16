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

package com.liferay.osb.koroneiki.root.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link ExternalIdMapperService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExternalIdMapperService
 * @generated
 */
@ProviderType
public class ExternalIdMapperServiceWrapper
	implements ExternalIdMapperService,
			   ServiceWrapper<ExternalIdMapperService> {

	public ExternalIdMapperServiceWrapper(
		ExternalIdMapperService externalIdMapperService) {

		_externalIdMapperService = externalIdMapperService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _externalIdMapperService.getOSGiServiceIdentifier();
	}

	@Override
	public ExternalIdMapperService getWrappedService() {
		return _externalIdMapperService;
	}

	@Override
	public void setWrappedService(
		ExternalIdMapperService externalIdMapperService) {

		_externalIdMapperService = externalIdMapperService;
	}

	private ExternalIdMapperService _externalIdMapperService;

}