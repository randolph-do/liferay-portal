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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContactProjectRoleService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactProjectRoleService
 * @generated
 */
@ProviderType
public class ContactProjectRoleServiceWrapper
	implements ContactProjectRoleService,
			   ServiceWrapper<ContactProjectRoleService> {

	public ContactProjectRoleServiceWrapper(
		ContactProjectRoleService contactProjectRoleService) {

		_contactProjectRoleService = contactProjectRoleService;
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
			addContactProjectRole(
				long contactId, long projectId, long contactRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactProjectRoleService.addContactProjectRole(
			contactId, projectId, contactRoleId);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
			deleteContactProjectRole(
				long contactId, long projectId, long contactRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactProjectRoleService.deleteContactProjectRole(
			contactId, projectId, contactRoleId);
	}

	@Override
	public void deleteContactProjectRoles(long contactId, long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_contactProjectRoleService.deleteContactProjectRoles(
			contactId, projectId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactProjectRoleService.getOSGiServiceIdentifier();
	}

	@Override
	public ContactProjectRoleService getWrappedService() {
		return _contactProjectRoleService;
	}

	@Override
	public void setWrappedService(
		ContactProjectRoleService contactProjectRoleService) {

		_contactProjectRoleService = contactProjectRoleService;
	}

	private ContactProjectRoleService _contactProjectRoleService;

}