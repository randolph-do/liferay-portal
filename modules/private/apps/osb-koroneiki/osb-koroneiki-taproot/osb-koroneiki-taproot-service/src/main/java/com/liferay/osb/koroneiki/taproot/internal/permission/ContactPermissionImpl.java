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

package com.liferay.osb.koroneiki.taproot.internal.permission;

import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.osb.koroneiki.taproot.permission.ContactPermission;
import com.liferay.osb.koroneiki.taproot.service.ContactLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.ArrayUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = ContactPermission.class)
public class ContactPermissionImpl implements ContactPermission {

	@Override
	public void check(
			PermissionChecker permissionChecker, Contact contact,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, contact, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, Contact.class.getName(),
				contact.getContactId(), actionId);
		}
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, long contactId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, contactId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, Contact.class.getName(), contactId,
				actionId);
		}
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, Contact contact,
			String actionId)
		throws PortalException {

		if (contains(permissionChecker, contact.getContactId(), actionId)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long contactId,
			String actionId)
		throws PortalException {

		if (permissionChecker.isOmniadmin()) {
			return true;
		}

		return permissionChecker.hasPermission(
			0, Contact.class.getName(), contactId, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long[] contactIds,
			String actionId)
		throws PortalException {

		if (ArrayUtil.isEmpty(contactIds)) {
			return false;
		}

		for (long contactId : contactIds) {
			if (!contains(permissionChecker, contactId, actionId)) {
				return false;
			}
		}

		return true;
	}

	@Reference
	private ContactLocalService _contactLocalService;

}