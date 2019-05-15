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
 * Provides a wrapper for {@link ContactAccountRoleService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactAccountRoleService
 * @generated
 */
@ProviderType
public class ContactAccountRoleServiceWrapper
	implements ContactAccountRoleService,
			   ServiceWrapper<ContactAccountRoleService> {

	public ContactAccountRoleServiceWrapper(
		ContactAccountRoleService contactAccountRoleService) {

		_contactAccountRoleService = contactAccountRoleService;
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.ContactAccountRole
			addContactAccountRole(
				long contactId, long accountId, long contactRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactAccountRoleService.addContactAccountRole(
			contactId, accountId, contactRoleId);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.ContactAccountRole
			deleteContactAccountRole(
				long contactId, long accountId, long contactRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactAccountRoleService.deleteContactAccountRole(
			contactId, accountId, contactRoleId);
	}

	@Override
	public void deleteContactAccountRoles(long contactId, long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_contactAccountRoleService.deleteContactAccountRoles(
			contactId, accountId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactAccountRoleService.getOSGiServiceIdentifier();
	}

	@Override
	public ContactAccountRoleService getWrappedService() {
		return _contactAccountRoleService;
	}

	@Override
	public void setWrappedService(
		ContactAccountRoleService contactAccountRoleService) {

		_contactAccountRoleService = contactAccountRoleService;
	}

	private ContactAccountRoleService _contactAccountRoleService;

}