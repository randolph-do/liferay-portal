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
import com.liferay.osb.koroneiki.taproot.internal.permission.AccountPermissionUtil;
import com.liferay.osb.koroneiki.taproot.internal.permission.ContactPermissionUtil;
import com.liferay.osb.koroneiki.taproot.internal.permission.ContactRolePermissionUtil;
import com.liferay.osb.koroneiki.taproot.model.ContactAccountRole;
import com.liferay.osb.koroneiki.taproot.service.base.ContactAccountRoleServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;

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

		ContactPermissionUtil.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		AccountPermissionUtil.check(
			getPermissionChecker(), accountId,
			TaprootActionKeys.ASSIGN_CONTACT);

		ContactRolePermissionUtil.check(
			getPermissionChecker(), contactRoleId,
			TaprootActionKeys.ASSIGN_CONTACT);

		return contactAccountRoleLocalService.addContactAccountRole(
			contactId, accountId, contactRoleId);
	}

	public ContactAccountRole deleteContactAccountRole(
			long contactId, long accountId, long contactRoleId)
		throws PortalException {

		ContactPermissionUtil.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		AccountPermissionUtil.check(
			getPermissionChecker(), accountId,
			TaprootActionKeys.ASSIGN_CONTACT);

		ContactRolePermissionUtil.check(
			getPermissionChecker(), contactRoleId,
			TaprootActionKeys.ASSIGN_CONTACT);

		return contactAccountRoleLocalService.deleteContactAccountRole(
			contactId, accountId, contactRoleId);
	}

	public void deleteContactAccountRoles(long contactId, long accountId)
		throws PortalException {

		ContactPermissionUtil.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		AccountPermissionUtil.check(
			getPermissionChecker(), accountId,
			TaprootActionKeys.ASSIGN_CONTACT);

		List<ContactAccountRole> contactAccountRoles =
			contactAccountRolePersistence.findByC_A(contactId, accountId);

		for (ContactAccountRole contactAccountRole : contactAccountRoles) {
			ContactRolePermissionUtil.check(
				getPermissionChecker(), contactAccountRole.getContactRoleId(),
				TaprootActionKeys.ASSIGN_CONTACT);
		}

		contactAccountRoleLocalService.deleteContactAccountRoles(
			contactId, accountId);
	}

}