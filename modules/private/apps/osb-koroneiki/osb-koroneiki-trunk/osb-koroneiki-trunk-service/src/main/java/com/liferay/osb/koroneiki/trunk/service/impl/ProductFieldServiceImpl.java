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
import com.liferay.osb.koroneiki.trunk.service.base.ProductFieldServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.service.permission.PortalPermissionUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=ProductField"
	},
	service = AopService.class
)
public class ProductFieldServiceImpl extends ProductFieldServiceBaseImpl {

	public ProductField addProductField(
			long productPurchaseId, String name, String value)
		throws PortalException {

		PortalPermissionUtil.check(
			getPermissionChecker(), TrunkActionKeys.ADD_PRODUCT_FIELD);

		return productFieldLocalService.addProductField(
			getUserId(), productPurchaseId, name, value);
	}

	public ProductField deleteProductField(long productFieldId)
		throws PortalException {

		_productFieldModelResourcePermission.check(
			getPermissionChecker(), productFieldId, ActionKeys.DELETE);

		return productFieldLocalService.deleteProductField(productFieldId);
	}

	public ProductField updateProductField(long productFieldId, String value)
		throws PortalException {

		_productFieldModelResourcePermission.check(
			getPermissionChecker(), productFieldId, ActionKeys.UPDATE);

		return productFieldLocalService.updateProductField(
			productFieldId, value);
	}

	private static volatile ModelResourcePermission<ProductField>
		_productFieldModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				ProductFieldServiceImpl.class,
				"_productFieldModelResourcePermission", ProductField.class);

}