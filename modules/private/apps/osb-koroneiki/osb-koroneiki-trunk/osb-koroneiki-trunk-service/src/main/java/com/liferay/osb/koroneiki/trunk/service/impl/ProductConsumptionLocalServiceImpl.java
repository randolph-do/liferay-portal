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

import com.liferay.osb.koroneiki.trunk.model.ProductConsumption;
import com.liferay.osb.koroneiki.trunk.service.base.ProductConsumptionLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.trunk.model.ProductConsumption",
	service = AopService.class
)
public class ProductConsumptionLocalServiceImpl
	extends ProductConsumptionLocalServiceBaseImpl {

	public ProductConsumption addProductConsumption(
			long userId, long accountId, long projectId, long productEntryId)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		long productConsumptionId = counterLocalService.increment();

		ProductConsumption productConsumption =
			productConsumptionPersistence.create(productConsumptionId);

		productConsumption.setCompanyId(user.getCompanyId());
		productConsumption.setUserId(userId);
		productConsumption.setAccountId(accountId);
		productConsumption.setProjectId(projectId);
		productConsumption.setProductEntryId(productEntryId);

		productConsumptionPersistence.update(productConsumption);

		// Resources

		resourceLocalService.addResources(
			productConsumption.getCompanyId(), 0, userId,
			ProductConsumption.class.getName(),
			productConsumption.getProductConsumptionId(), false, false, false);

		return productConsumption;
	}

	@Override
	public ProductConsumption deleteProductConsumption(
			long productConsumptionId)
		throws PortalException {

		ProductConsumption productConsumption =
			productConsumptionLocalService.getProductConsumption(
				productConsumptionId);

		// Resources

		resourceLocalService.deleteResource(
			productConsumption.getCompanyId(),
			ProductConsumption.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL,
			productConsumption.getProductConsumptionId());

		return productConsumptionPersistence.remove(productConsumptionId);
	}

}