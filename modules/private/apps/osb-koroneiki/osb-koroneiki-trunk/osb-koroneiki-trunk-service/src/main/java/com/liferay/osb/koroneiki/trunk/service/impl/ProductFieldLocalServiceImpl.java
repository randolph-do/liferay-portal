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

import com.liferay.osb.koroneiki.trunk.model.ProductField;
import com.liferay.osb.koroneiki.trunk.service.base.ProductFieldLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.trunk.model.ProductField",
	service = AopService.class
)
public class ProductFieldLocalServiceImpl
	extends ProductFieldLocalServiceBaseImpl {

	public ProductField addProductField(
			long userId, long productPurchaseId, String name, String value)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		long productFieldId = counterLocalService.increment();

		ProductField productField = productFieldPersistence.create(
			productFieldId);

		productField.setCompanyId(user.getCompanyId());
		productField.setUserId(userId);
		productField.setProductPurchaseId(productPurchaseId);
		productField.setName(name);
		productField.setValue(value);

		productFieldPersistence.update(productField);

		// Resources

		resourceLocalService.addResources(
			productField.getCompanyId(), 0, userId,
			ProductField.class.getName(), productField.getProductFieldId(),
			false, false, false);

		return productField;
	}

	@Override
	public ProductField deleteProductField(long productFieldId)
		throws PortalException {

		ProductField productField = productFieldLocalService.getProductField(
			productFieldId);

		// Resources

		resourceLocalService.deleteResource(
			productField.getCompanyId(), ProductField.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL,
			productField.getProductFieldId());

		return productFieldPersistence.remove(productFieldId);
	}

	public ProductField updateProductField(long productFieldId, String value)
		throws PortalException {

		ProductField productField = productFieldPersistence.findByPrimaryKey(
			productFieldId);

		productField.setValue(value);

		return productFieldPersistence.update(productField);
	}

}