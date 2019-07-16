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

package com.liferay.osb.koroneiki.phloem.rest.internal.resource.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Contact;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.util.ContactUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ContactResource;
import com.liferay.osb.koroneiki.taproot.service.ContactService;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Amos Fong
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/contact.properties",
	scope = ServiceScope.PROTOTYPE, service = ContactResource.class
)
public class ContactResourceImpl extends BaseContactResourceImpl {

	@Override
	public void deleteContact(String contactKey) throws Exception {
		_contactService.deleteContact(contactKey);
	}

	@Override
	public Page<Contact> getAccountAccountKeyContactsPage(
			String accountKey, String[] includes, Pagination pagination)
		throws Exception {

		return Page.of(
			transform(
				_contactService.getAccountContacts(
					accountKey, pagination.getStartPosition(),
					pagination.getEndPosition()),
				contact -> ContactUtil.toContact(contact, includes)),
			pagination, _contactService.getAccountContactsCount(accountKey));
	}

	@Override
	public Contact getContact(String contactKey) throws Exception {
		return ContactUtil.toContact(
			_contactService.getContactByContactKey(contactKey), null);
	}

	@Override
	public Page<Contact> getProjectProjectKeyContactsPage(
			String projectKey, Pagination pagination)
		throws Exception {

		return Page.of(
			transform(
				_contactService.getProjectContacts(
					projectKey, pagination.getStartPosition(),
					pagination.getEndPosition()),
				contact -> ContactUtil.toContact(contact, null)),
			pagination, _contactService.getAccountContactsCount(projectKey));
	}

	@Override
	public Contact postContact(Contact contact) throws Exception {
		return ContactUtil.toContact(
			_contactService.addContact(
				contact.getFirstName(), contact.getMiddleName(),
				contact.getLastName(), contact.getEmailAddress(),
				contact.getLanguageId()),
			null);
	}

	@Reference
	private ContactService _contactService;

}