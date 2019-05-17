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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = {})
public class ContactPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, Contact contact,
			String actionId)
		throws PortalException {

		getContactPermission().check(permissionChecker, contact, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long contactId,
			String actionId)
		throws PortalException {

		getContactPermission().check(permissionChecker, contactId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, Contact contact,
			String actionId)
		throws PortalException {

		return getContactPermission().contains(
			permissionChecker, contact, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long contactId,
			String actionId)
		throws PortalException {

		return getContactPermission().contains(
			permissionChecker, contactId, actionId);
	}

	public static ContactPermission getContactPermission() {
		return _contactPermission;
	}

	@Reference(unbind = "-")
	public void setContactPermission(ContactPermission contactPermission) {
		_contactPermission = contactPermission;
	}

	private static ContactPermission _contactPermission;

}