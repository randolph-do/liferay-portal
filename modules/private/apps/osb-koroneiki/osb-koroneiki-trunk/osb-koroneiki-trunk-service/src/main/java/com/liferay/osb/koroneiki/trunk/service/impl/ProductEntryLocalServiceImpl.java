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

import com.liferay.osb.koroneiki.trunk.model.ProductEntry;
import com.liferay.osb.koroneiki.trunk.service.base.ProductEntryLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.trunk.model.ProductEntry",
	service = AopService.class
)
public class ProductEntryLocalServiceImpl
	extends ProductEntryLocalServiceBaseImpl {

	public ProductEntry addProductEntry(long userId, String name)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		long productEntryId = counterLocalService.increment();

		ProductEntry productEntry = productEntryPersistence.create(
			productEntryId);

		productEntry.setCompanyId(user.getCompanyId());
		productEntry.setUserId(userId);
		productEntry.setName(name);

		productEntryPersistence.update(productEntry);

		// Resources

		resourceLocalService.addResources(
			productEntry.getCompanyId(), 0, userId,
			ProductEntry.class.getName(), productEntry.getProductEntryId(),
			false, false, false);

		return productEntry;
	}

	@Override
	public ProductEntry deleteProductEntry(long productEntryId)
		throws PortalException {

		ProductEntry productEntry = productEntryLocalService.getProductEntry(
			productEntryId);

		// Resources

		resourceLocalService.deleteResource(
			productEntry.getCompanyId(), ProductEntry.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL,
			productEntry.getProductEntryId());

		return productEntryPersistence.remove(productEntryId);
	}

	public ProductEntry updateProductEntry(long productEntryId, String name)
		throws PortalException {

		ProductEntry productEntry = productEntryPersistence.findByPrimaryKey(
			productEntryId);

		productEntry.setName(name);

		return productEntryPersistence.update(productEntry);
	}

}