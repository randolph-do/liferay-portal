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

package com.liferay.osb.koroneiki.trunk.internal.permission;

import com.liferay.osb.koroneiki.trunk.model.ProductEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = {})
public class ProductEntryPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long productEntryId,
			String actionId)
		throws PortalException {

		getProductEntryPermission().check(
			permissionChecker, productEntryId, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, ProductEntry productEntry,
			String actionId)
		throws PortalException {

		getProductEntryPermission().check(
			permissionChecker, productEntry, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long productEntryId,
			String actionId)
		throws PortalException {

		return getProductEntryPermission().contains(
			permissionChecker, productEntryId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, ProductEntry productEntry,
			String actionId)
		throws PortalException {

		return getProductEntryPermission().contains(
			permissionChecker, productEntry, actionId);
	}

	public static ProductEntryPermission getProductEntryPermission() {
		return _productEntryPermission;
	}

	@Reference(unbind = "-")
	public void setProductEntryPermission(
		ProductEntryPermission productEntryPermission) {

		_productEntryPermission = productEntryPermission;
	}

	private static ProductEntryPermission _productEntryPermission;

}