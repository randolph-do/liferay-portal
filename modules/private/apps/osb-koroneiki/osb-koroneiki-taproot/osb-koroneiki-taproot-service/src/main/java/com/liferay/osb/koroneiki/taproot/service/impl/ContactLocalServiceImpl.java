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

import com.liferay.osb.koroneiki.root.service.ExternalLinkLocalService;
import com.liferay.osb.koroneiki.root.util.ModelKeyGenerator;
import com.liferay.osb.koroneiki.taproot.exception.ContactEmailAddressException;
import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.osb.koroneiki.taproot.service.base.ContactLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;

import java.util.LinkedHashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.taproot.model.Contact",
	service = AopService.class
)
public class ContactLocalServiceImpl extends ContactLocalServiceBaseImpl {

	public Contact addContact(
			long userId, String firstName, String middleName, String lastName,
			String emailAddress, String languageId)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		validate(0, emailAddress);

		long contactId = counterLocalService.increment();

		Contact contact = contactPersistence.create(contactId);

		contact.setCompanyId(user.getCompanyId());
		contact.setUserId(userId);
		contact.setContactKey(ModelKeyGenerator.generate(contactId));
		contact.setFirstName(firstName);
		contact.setMiddleName(middleName);
		contact.setLastName(lastName);
		contact.setEmailAddress(emailAddress);
		contact.setLanguageId(languageId);

		contactPersistence.update(contact);

		// Resources

		resourceLocalService.addResources(
			contact.getCompanyId(), 0, userId, Contact.class.getName(),
			contact.getContactId(), false, false, false);

		return contact;
	}

	@Override
	public Contact deleteContact(Contact contact) throws PortalException {

		// Contact account roles

		contactAccountRolePersistence.removeByContactId(contact.getContactId());

		// Contact project roles

		contactProjectRolePersistence.removeByContactId(contact.getContactId());

		// Contact team roles

		contactTeamRolePersistence.removeByContactId(contact.getContactId());

		// External links

		long classNameId = classNameLocalService.getClassNameId(Contact.class);

		_externalLinkLocalService.deleteExternalLinks(
			classNameId, contact.getContactId());

		// Resources

		resourceLocalService.deleteResource(
			contact.getCompanyId(), Contact.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, contact.getContactId());

		return contactPersistence.remove(contact);
	}

	@Override
	public Contact deleteContact(long contactId) throws PortalException {
		return deleteContact(contactLocalService.getContact(contactId));
	}

	public List<Contact> getAccountContacts(
		long accountId, int start, int end) {

		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("account", accountId);

		return contactFinder.findByFN_MN_LN_E(
			null, null, null, null, params, start, end);
	}

	public int getAccountContactsCount(long accountId) {
		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("account", accountId);

		return contactFinder.countByFN_MN_LN_E(null, null, null, null, params);
	}

	public Contact getContactByContactKey(String contactKey)
		throws PortalException {

		return contactPersistence.findByContactKey(contactKey);
	}

	public Contact getContactByEmailAddress(String emailAddress)
		throws PortalException {

		return contactPersistence.findByEmailAddress(emailAddress);
	}

	public List<Contact> getProjectContacts(
		long projectId, int start, int end) {

		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("project", projectId);

		return contactFinder.findByFN_MN_LN_E(
			null, null, null, null, params, start, end);
	}

	public int getProjectContactsCount(long projectId) {
		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("project", projectId);

		return contactFinder.countByFN_MN_LN_E(null, null, null, null, params);
	}

	public List<Contact> getTeamContacts(long teamId, int start, int end) {
		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("team", teamId);

		return contactFinder.findByFN_MN_LN_E(
			null, null, null, null, params, start, end);
	}

	public int getTeamContactsCount(long teamId) {
		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("team", teamId);

		return contactFinder.countByFN_MN_LN_E(null, null, null, null, params);
	}

	public Contact updateContact(
			long contactId, String firstName, String middleName,
			String lastName, String emailAddress, String languageId)
		throws PortalException {

		validate(contactId, emailAddress);

		Contact contact = contactPersistence.findByPrimaryKey(contactId);

		contact.setFirstName(firstName);
		contact.setMiddleName(middleName);
		contact.setLastName(lastName);
		contact.setEmailAddress(emailAddress);
		contact.setLanguageId(languageId);

		return contactPersistence.update(contact);
	}

	protected void validate(long contactId, String emailAddress)
		throws PortalException {

		if (Validator.isNull(emailAddress)) {
			throw new ContactEmailAddressException();
		}

		Contact contact = contactPersistence.fetchByEmailAddress(emailAddress);

		if ((contact != null) && (contact.getContactId() != contactId)) {
			if (contactId > 0) {
				throw new ContactEmailAddressException.MustNotBeDuplicate(
					contactId, emailAddress);
			}

			throw new ContactEmailAddressException.MustNotBeDuplicate(
				emailAddress);
		}
	}

	@Reference
	private ExternalLinkLocalService _externalLinkLocalService;

}