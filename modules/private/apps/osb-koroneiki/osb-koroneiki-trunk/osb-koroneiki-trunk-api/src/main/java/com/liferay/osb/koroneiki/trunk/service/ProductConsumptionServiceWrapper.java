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

package com.liferay.osb.koroneiki.trunk.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductConsumptionService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductConsumptionService
 * @generated
 */
@ProviderType
public class ProductConsumptionServiceWrapper
	implements ProductConsumptionService,
			   ServiceWrapper<ProductConsumptionService> {

	public ProductConsumptionServiceWrapper(
		ProductConsumptionService productConsumptionService) {

		_productConsumptionService = productConsumptionService;
	}

	@Override
	public com.liferay.osb.koroneiki.trunk.model.ProductConsumption
			addProductConsumption(
				long accountId, long projectId, long productEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productConsumptionService.addProductConsumption(
			accountId, projectId, productEntryId);
	}

	@Override
	public com.liferay.osb.koroneiki.trunk.model.ProductConsumption
			deleteProductConsumption(long productConsumptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productConsumptionService.deleteProductConsumption(
			productConsumptionId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productConsumptionService.getOSGiServiceIdentifier();
	}

	@Override
	public ProductConsumptionService getWrappedService() {
		return _productConsumptionService;
	}

	@Override
	public void setWrappedService(
		ProductConsumptionService productConsumptionService) {

		_productConsumptionService = productConsumptionService;
	}

	private ProductConsumptionService _productConsumptionService;

}