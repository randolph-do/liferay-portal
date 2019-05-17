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

import com.liferay.osb.koroneiki.trunk.model.ProductPurchase;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = {})
public class ProductPurchasePermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long productPurchaseId,
			String actionId)
		throws PortalException {

		getProductPurchasePermission().check(
			permissionChecker, productPurchaseId, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker,
			ProductPurchase productPurchase, String actionId)
		throws PortalException {

		getProductPurchasePermission().check(
			permissionChecker, productPurchase, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long productPurchaseId,
			String actionId)
		throws PortalException {

		return getProductPurchasePermission().contains(
			permissionChecker, productPurchaseId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker,
			ProductPurchase productPurchase, String actionId)
		throws PortalException {

		return getProductPurchasePermission().contains(
			permissionChecker, productPurchase, actionId);
	}

	public static ProductPurchasePermission getProductPurchasePermission() {
		return _productPurchasePermission;
	}

	@Reference(unbind = "-")
	public void setProductPurchasePermission(
		ProductPurchasePermission productPurchasePermission) {

		_productPurchasePermission = productPurchasePermission;
	}

	private static ProductPurchasePermission _productPurchasePermission;

}