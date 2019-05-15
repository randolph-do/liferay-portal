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

import com.liferay.osb.koroneiki.trunk.model.ProductPurchase;
import com.liferay.osb.koroneiki.trunk.service.base.ProductPurchaseLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.trunk.model.ProductPurchase",
	service = AopService.class
)
public class ProductPurchaseLocalServiceImpl
	extends ProductPurchaseLocalServiceBaseImpl {

	public ProductPurchase addProductPurchase(
			long userId, long accountId, long projectId, long productEntryId,
			Date startDate, Date endDate, int quantity)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		long productPurchaseId = counterLocalService.increment();

		ProductPurchase productPurchase = productPurchasePersistence.create(
			productPurchaseId);

		productPurchase.setCompanyId(user.getCompanyId());
		productPurchase.setUserId(userId);
		productPurchase.setAccountId(accountId);
		productPurchase.setProjectId(projectId);
		productPurchase.setProductEntryId(productEntryId);
		productPurchase.setStartDate(startDate);
		productPurchase.setEndDate(endDate);
		productPurchase.setQuantity(quantity);

		productPurchasePersistence.update(productPurchase);

		// Resources

		resourceLocalService.addResources(
			productPurchase.getCompanyId(), 0, userId,
			ProductPurchase.class.getName(),
			productPurchase.getProductPurchaseId(), false, false, false);

		return productPurchase;
	}

	@Override
	public ProductPurchase deleteProductPurchase(long productPurchaseId)
		throws PortalException {

		ProductPurchase productPurchase =
			productPurchaseLocalService.getProductPurchase(productPurchaseId);

		// Resources

		resourceLocalService.deleteResource(
			productPurchase.getCompanyId(), ProductPurchase.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL,
			productPurchase.getProductPurchaseId());

		return productPurchasePersistence.remove(productPurchaseId);
	}

	public ProductPurchase updateProductPurchase(
			long productPurchaseId, Date startDate, Date endDate, int quantity)
		throws PortalException {

		ProductPurchase productPurchase =
			productPurchasePersistence.findByPrimaryKey(productPurchaseId);

		productPurchase.setStartDate(startDate);
		productPurchase.setEndDate(endDate);
		productPurchase.setQuantity(quantity);

		return productPurchasePersistence.update(productPurchase);
	}

}