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

import com.liferay.osb.koroneiki.trunk.model.ProductField;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = {})
public class ProductFieldPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long productFieldId,
			String actionId)
		throws PortalException {

		getProductFieldPermission().check(
			permissionChecker, productFieldId, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, ProductField productField,
			String actionId)
		throws PortalException {

		getProductFieldPermission().check(
			permissionChecker, productField, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long productFieldId,
			String actionId)
		throws PortalException {

		return getProductFieldPermission().contains(
			permissionChecker, productFieldId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, ProductField productField,
			String actionId)
		throws PortalException {

		return getProductFieldPermission().contains(
			permissionChecker, productField, actionId);
	}

	public static ProductFieldPermission getProductFieldPermission() {
		return _productFieldPermission;
	}

	@Reference(unbind = "-")
	public void setProductFieldPermission(
		ProductFieldPermission productFieldPermission) {

		_productFieldPermission = productFieldPermission;
	}

	private static ProductFieldPermission _productFieldPermission;

}