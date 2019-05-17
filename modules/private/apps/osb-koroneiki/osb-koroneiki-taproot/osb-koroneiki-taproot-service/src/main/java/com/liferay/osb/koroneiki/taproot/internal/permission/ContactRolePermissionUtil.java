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

import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.osb.koroneiki.taproot.permission.ContactRolePermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = {})
public class ContactRolePermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, ContactRole contactRole,
			String actionId)
		throws PortalException {

		getContactRolePermission().check(
			permissionChecker, contactRole, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long contactRoleId,
			String actionId)
		throws PortalException {

		getContactRolePermission().check(
			permissionChecker, contactRoleId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, ContactRole contactRole,
			String actionId)
		throws PortalException {

		return getContactRolePermission().contains(
			permissionChecker, contactRole, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long contactRoleId,
			String actionId)
		throws PortalException {

		return getContactRolePermission().contains(
			permissionChecker, contactRoleId, actionId);
	}

	public static ContactRolePermission getContactRolePermission() {
		return _contactRolePermission;
	}

	@Reference(unbind = "-")
	public void setContactRolePermission(
		ContactRolePermission contactRolePermission) {

		_contactRolePermission = contactRolePermission;
	}

	private static ContactRolePermission _contactRolePermission;

}