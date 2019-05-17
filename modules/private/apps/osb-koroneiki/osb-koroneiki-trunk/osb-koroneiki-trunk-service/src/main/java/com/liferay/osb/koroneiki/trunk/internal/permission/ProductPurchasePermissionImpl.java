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
import com.liferay.osb.koroneiki.trunk.permission.ProductPurchasePermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.ArrayUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = ProductPurchasePermission.class)
public class ProductPurchasePermissionImpl
	implements ProductPurchasePermission {

	@Override
	public void check(
			PermissionChecker permissionChecker, long productPurchaseId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, productPurchaseId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, ProductPurchase.class.getName(),
				productPurchaseId, actionId);
		}
	}

	@Override
	public void check(
			PermissionChecker permissionChecker,
			ProductPurchase productPurchase, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, productPurchase, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, ProductPurchase.class.getName(),
				productPurchase.getProductPurchaseId(), actionId);
		}
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long productPurchaseId,
			String actionId)
		throws PortalException {

		if (permissionChecker.isOmniadmin()) {
			return true;
		}

		return false;
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long[] productPurchaseIds,
			String actionId)
		throws PortalException {

		if (ArrayUtil.isEmpty(productPurchaseIds)) {
			return false;
		}

		for (long productPurchaseId : productPurchaseIds) {
			if (!contains(permissionChecker, productPurchaseId, actionId)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker,
			ProductPurchase productPurchase, String actionId)
		throws PortalException {

		if (contains(
				permissionChecker, productPurchase.getProductPurchaseId(),
				actionId)) {

			return true;
		}

		return false;
	}

}