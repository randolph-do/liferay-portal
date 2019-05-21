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

import com.liferay.osb.koroneiki.taproot.service.AccountLocalService;
import com.liferay.osb.koroneiki.taproot.service.ProjectLocalService;
import com.liferay.osb.koroneiki.trunk.exception.ProductPurchaseEndDateException;
import com.liferay.osb.koroneiki.trunk.exception.ProductPurchaseQuantityException;
import com.liferay.osb.koroneiki.trunk.model.ProductField;
import com.liferay.osb.koroneiki.trunk.model.ProductPurchase;
import com.liferay.osb.koroneiki.trunk.service.ProductFieldLocalService;
import com.liferay.osb.koroneiki.trunk.service.base.ProductPurchaseLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
			Date startDate, Date endDate, int quantity,
			List<ProductField> productFields)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		validate(
			accountId, projectId, productEntryId, startDate, endDate, quantity);

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

		// Product fields

		for (ProductField productField : productFields) {
			_productFieldLocalService.addProductField(
				userId, productPurchaseId, productField.getName(),
				productField.getValue());
		}

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
			long userId, long productPurchaseId, Date startDate, Date endDate,
			int quantity, List<ProductField> productFields)
		throws PortalException {

		validate(startDate, endDate, quantity);

		ProductPurchase productPurchase =
			productPurchasePersistence.findByPrimaryKey(productPurchaseId);

		productPurchase.setStartDate(startDate);
		productPurchase.setEndDate(endDate);
		productPurchase.setQuantity(quantity);

		productPurchasePersistence.update(productPurchase);

		// Product fields

		Map<String, ProductField> productFieldsMap = getProductFieldsMap(
			productPurchaseId);

		for (ProductField productField : productFields) {
			ProductField curProductField = productFieldsMap.remove(
				productField.getName());

			if (curProductField == null) {
				_productFieldLocalService.addProductField(
					userId, productPurchaseId, productField.getName(),
					productField.getValue());
			}
			else {
				_productFieldLocalService.updateProductField(
					curProductField.getProductFieldId(),
					productField.getValue());
			}
		}

		for (ProductField productField : productFieldsMap.values()) {
			_productFieldLocalService.deleteProductField(
				productField.getProductFieldId());
		}

		return productPurchase;
	}

	protected Map<String, ProductField> getProductFieldsMap(
		long productPurchaseId) {

		Map<String, ProductField> productFieldsMap = new HashMap<>();

		List<ProductField> productFields =
			_productFieldLocalService.getProductFields(productPurchaseId);

		for (ProductField productField : productFields) {
			productFieldsMap.put(productField.getName(), productField);
		}

		return productFieldsMap;
	}

	protected void validate(Date startDate, Date endDate, int quantity)
		throws PortalException {

		if ((startDate != null) && (endDate != null) &&
			startDate.after(endDate)) {

			throw new ProductPurchaseEndDateException();
		}

		if (quantity <= 0) {
			throw new ProductPurchaseQuantityException();
		}
	}

	protected void validate(
			long accountId, long projectId, long productEntryId, Date startDate,
			Date endDate, int quantity)
		throws PortalException {

		_accountLocalService.getAccount(accountId);

		if (projectId > 0) {
			_projectLocalService.getProject(projectId);
		}

		productEntryPersistence.findByPrimaryKey(productEntryId);

		validate(startDate, endDate, quantity);
	}

	@Reference
	private AccountLocalService _accountLocalService;

	@Reference
	private ProductFieldLocalService _productFieldLocalService;

	@Reference
	private ProjectLocalService _projectLocalService;

}