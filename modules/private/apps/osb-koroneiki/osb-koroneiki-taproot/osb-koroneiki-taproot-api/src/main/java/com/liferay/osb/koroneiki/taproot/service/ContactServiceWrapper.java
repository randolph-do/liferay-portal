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
 * Provides a wrapper for {@link ContactService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactService
 * @generated
 */
@ProviderType
public class ContactServiceWrapper
	implements ContactService, ServiceWrapper<ContactService> {

	public ContactServiceWrapper(ContactService contactService) {
		_contactService = contactService;
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Contact addContact(
			String firstName, String middleName, String lastName,
			String emailAddress, String languageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.addContact(
			firstName, middleName, lastName, emailAddress, languageId);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Contact deleteContact(
			long contactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.deleteContact(contactId);
	}

	@Override
	public java.util.List<com.liferay.osb.koroneiki.taproot.model.Contact>
			getAccountContacts(long accountId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getAccountContacts(accountId, start, end);
	}

	@Override
	public int getAccountContactsCount(long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getAccountContactsCount(accountId);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Contact getContact(
			long contactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getContact(contactId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.osb.koroneiki.taproot.model.Contact>
			getProjectContacts(long projectId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getProjectContacts(projectId, start, end);
	}

	@Override
	public int getProjectContactsCount(long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getProjectContactsCount(projectId);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Contact updateContact(
			long contactId, String firstName, String middleName,
			String lastName, String emailAddress, String languageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.updateContact(
			contactId, firstName, middleName, lastName, emailAddress,
			languageId);
	}

	@Override
	public ContactService getWrappedService() {
		return _contactService;
	}

	@Override
	public void setWrappedService(ContactService contactService) {
		_contactService = contactService;
	}

	private ContactService _contactService;

}