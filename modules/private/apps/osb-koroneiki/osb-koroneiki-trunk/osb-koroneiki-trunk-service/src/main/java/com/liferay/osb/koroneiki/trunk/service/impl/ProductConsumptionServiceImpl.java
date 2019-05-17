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
import com.liferay.osb.koroneiki.trunk.internal.permission.ProductConsumptionPermissionUtil;
import com.liferay.osb.koroneiki.trunk.model.ProductConsumption;
import com.liferay.osb.koroneiki.trunk.service.base.ProductConsumptionServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=ProductConsumption"
	},
	service = AopService.class
)
public class ProductConsumptionServiceImpl
	extends ProductConsumptionServiceBaseImpl {

	public ProductConsumption addProductConsumption(
			long accountId, long projectId, long productEntryId)
		throws PortalException {

		ProductConsumptionPermissionUtil.check(
			getPermissionChecker(), 0, TrunkActionKeys.ADD_PRODUCT_CONSUMPTION);

		return productConsumptionLocalService.addProductConsumption(
			getUserId(), accountId, projectId, productEntryId);
	}

	public ProductConsumption deleteProductConsumption(
			long productConsumptionId)
		throws PortalException {

		ProductConsumptionPermissionUtil.check(
			getPermissionChecker(), productConsumptionId, ActionKeys.DELETE);

		return productConsumptionLocalService.deleteProductConsumption(
			productConsumptionId);
	}

}