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
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.service.base.ContactServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.service.permission.PortalPermissionUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=Contact"
	},
	service = AopService.class
)
public class ContactServiceImpl extends ContactServiceBaseImpl {

	public Contact addContact(
			String firstName, String middleName, String lastName,
			String emailAddress, String languageId)
		throws PortalException {

		PortalPermissionUtil.check(
			getPermissionChecker(), TaprootActionKeys.ADD_CONTACT);

		return contactLocalService.addContact(
			getUserId(), firstName, middleName, lastName, emailAddress,
			languageId);
	}

	public Contact deleteContact(long contactId) throws PortalException {
		_contactModelResourcePermission.check(
			getPermissionChecker(), contactId, ActionKeys.DELETE);

		return contactLocalService.deleteContact(contactId);
	}

	public List<Contact> getAccountContacts(long accountId, int start, int end)
		throws PortalException {

		_accountModelResourcePermission.check(
			getPermissionChecker(), accountId, ActionKeys.VIEW);

		return contactLocalService.getAccountContacts(accountId, start, end);
	}

	public int getAccountContactsCount(long accountId) throws PortalException {
		_accountModelResourcePermission.check(
			getPermissionChecker(), accountId, ActionKeys.VIEW);

		return contactLocalService.getAccountContactsCount(accountId);
	}

	public Contact getContact(long contactId) throws PortalException {
		_contactModelResourcePermission.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		return contactLocalService.getContact(contactId);
	}

	public List<Contact> getProjectContacts(long projectId, int start, int end)
		throws PortalException {

		_projectModelResourcePermission.check(
			getPermissionChecker(), projectId, ActionKeys.VIEW);

		return contactLocalService.getProjectContacts(projectId, start, end);
	}

	public int getProjectContactsCount(long projectId) throws PortalException {
		_projectModelResourcePermission.check(
			getPermissionChecker(), projectId, ActionKeys.VIEW);

		return contactLocalService.getProjectContactsCount(projectId);
	}

	public Contact updateContact(
			long contactId, String firstName, String middleName,
			String lastName, String emailAddress, String languageId)
		throws PortalException {

		_contactModelResourcePermission.check(
			getPermissionChecker(), contactId, ActionKeys.UPDATE);

		return contactLocalService.updateContact(
			contactId, firstName, middleName, lastName, emailAddress,
			languageId);
	}

	private static volatile ModelResourcePermission<Account>
		_accountModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				ContactServiceImpl.class, "_accountModelResourcePermission",
				Account.class);
	private static volatile ModelResourcePermission<Contact>
		_contactModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				ContactServiceImpl.class, "_contactModelResourcePermission",
				Contact.class);
	private static volatile ModelResourcePermission<Project>
		_projectModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				ContactServiceImpl.class, "_projectModelResourcePermission",
				Project.class);

}