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
import com.liferay.osb.koroneiki.taproot.model.ContactAccountRole;
import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.osb.koroneiki.taproot.service.base.ContactAccountRoleServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=ContactAccountRole"
	},
	service = AopService.class
)
public class ContactAccountRoleServiceImpl
	extends ContactAccountRoleServiceBaseImpl {

	public ContactAccountRole addContactAccountRole(
			long contactId, long accountId, long contactRoleId)
		throws PortalException {

		_contactModelResourcePermission.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		_accountModelResourcePermission.check(
			getPermissionChecker(), accountId,
			TaprootActionKeys.ASSIGN_CONTACT);

		_contactRoleModelResourcePermission.check(
			getPermissionChecker(), contactRoleId,
			TaprootActionKeys.ASSIGN_CONTACT);

		return contactAccountRoleLocalService.addContactAccountRole(
			contactId, accountId, contactRoleId);
	}

	public ContactAccountRole deleteContactAccountRole(
			long contactId, long accountId, long contactRoleId)
		throws PortalException {

		_contactModelResourcePermission.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		_accountModelResourcePermission.check(
			getPermissionChecker(), accountId,
			TaprootActionKeys.ASSIGN_CONTACT);

		_contactRoleModelResourcePermission.check(
			getPermissionChecker(), contactRoleId,
			TaprootActionKeys.ASSIGN_CONTACT);

		return contactAccountRoleLocalService.deleteContactAccountRole(
			contactId, accountId, contactRoleId);
	}

	public void deleteContactAccountRoles(long contactId, long accountId)
		throws PortalException {

		_contactModelResourcePermission.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		_accountModelResourcePermission.check(
			getPermissionChecker(), accountId,
			TaprootActionKeys.ASSIGN_CONTACT);

		List<ContactAccountRole> contactAccountRoles =
			contactAccountRolePersistence.findByC_A(contactId, accountId);

		for (ContactAccountRole contactAccountRole : contactAccountRoles) {
			_contactRoleModelResourcePermission.check(
				getPermissionChecker(), contactAccountRole.getContactRoleId(),
				TaprootActionKeys.ASSIGN_CONTACT);
		}

		contactAccountRoleLocalService.deleteContactAccountRoles(
			contactId, accountId);
	}

	private static volatile ModelResourcePermission<Account>
		_accountModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				ContactAccountRoleServiceImpl.class,
				"_accountModelResourcePermission", Account.class);
	private static volatile ModelResourcePermission<Contact>
		_contactModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				ContactAccountRoleServiceImpl.class,
				"_contactModelResourcePermission", Contact.class);
	private static volatile ModelResourcePermission<ContactRole>
		_contactRoleModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				ContactAccountRoleServiceImpl.class,
				"_contactRoleModelResourcePermission", ContactRole.class);

}