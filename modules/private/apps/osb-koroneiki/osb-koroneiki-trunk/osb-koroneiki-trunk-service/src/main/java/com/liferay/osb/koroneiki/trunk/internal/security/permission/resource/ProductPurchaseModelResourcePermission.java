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

package com.liferay.osb.koroneiki.trunk.internal.security.permission.resource;

import com.liferay.osb.koroneiki.trunk.model.ProductPurchase;
import com.liferay.osb.koroneiki.trunk.permission.ProductPurchasePermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.osb.koroneiki.trunk.model.ProductPurchase",
	service = ModelResourcePermission.class
)
public class ProductPurchaseModelResourcePermission
	implements ModelResourcePermission<ProductPurchase> {

	@Override
	public void check(
			PermissionChecker permissionChecker, long productPurchaseId,
			String actionId)
		throws PortalException {

		productPurchasePermission.check(
			permissionChecker, productPurchaseId, actionId);
	}

	@Override
	public void check(
			PermissionChecker permissionChecker,
			ProductPurchase productPurchase, String actionId)
		throws PortalException {

		productPurchasePermission.check(
			permissionChecker, productPurchase, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long productPurchaseId,
			String actionId)
		throws PortalException {

		return productPurchasePermission.contains(
			permissionChecker, productPurchaseId, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker,
			ProductPurchase productPurchase, String actionId)
		throws PortalException {

		return productPurchasePermission.contains(
			permissionChecker, productPurchase, actionId);
	}

	@Override
	public String getModelName() {
		return ProductPurchase.class.getName();
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return null;
	}

	@Reference
	protected ProductPurchasePermission productPurchasePermission;

}