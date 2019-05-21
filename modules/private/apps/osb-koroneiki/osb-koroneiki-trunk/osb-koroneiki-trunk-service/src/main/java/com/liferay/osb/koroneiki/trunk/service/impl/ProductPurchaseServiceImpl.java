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

package com.liferay.osb.koroneiki.trunk.service.impl;

import com.liferay.osb.koroneiki.trunk.constants.TrunkActionKeys;
import com.liferay.osb.koroneiki.trunk.model.ProductField;
import com.liferay.osb.koroneiki.trunk.model.ProductPurchase;
import com.liferay.osb.koroneiki.trunk.permission.ProductPurchasePermission;
import com.liferay.osb.koroneiki.trunk.service.base.ProductPurchaseServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=ProductPurchase"
	},
	service = AopService.class
)
public class ProductPurchaseServiceImpl extends ProductPurchaseServiceBaseImpl {

	public ProductPurchase addProductPurchase(
			long accountId, long projectId, long productEntryId, Date startDate,
			Date endDate, int quantity, List<ProductField> productFields)
		throws PortalException {

		_productPurchasePermission.check(
			getPermissionChecker(), TrunkActionKeys.ADD_PRODUCT_PURCHASE);

		return productPurchaseLocalService.addProductPurchase(
			getUserId(), accountId, projectId, productEntryId, startDate,
			endDate, quantity, productFields);
	}

	public ProductPurchase deleteProductPurchase(long productPurchaseId)
		throws PortalException {

		_productPurchasePermission.check(
			getPermissionChecker(), productPurchaseId, ActionKeys.DELETE);

		return productPurchaseLocalService.deleteProductPurchase(
			productPurchaseId);
	}

	public ProductPurchase updateProductPurchase(
			long productPurchaseId, Date startDate, Date endDate, int quantity,
			List<ProductField> productFields)
		throws PortalException {

		_productPurchasePermission.check(
			getPermissionChecker(), productPurchaseId, ActionKeys.UPDATE);

		return productPurchaseLocalService.updateProductPurchase(
			getUserId(), productPurchaseId, startDate, endDate, quantity,
			productFields);
	}

	@Reference
	private ProductPurchasePermission _productPurchasePermission;

}