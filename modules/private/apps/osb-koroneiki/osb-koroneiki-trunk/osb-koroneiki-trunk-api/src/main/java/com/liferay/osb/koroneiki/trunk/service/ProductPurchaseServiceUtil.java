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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for ProductPurchase. This utility wraps
 * <code>com.liferay.osb.koroneiki.trunk.service.impl.ProductPurchaseServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ProductPurchaseService
 * @generated
 */
@ProviderType
public class ProductPurchaseServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.osb.koroneiki.trunk.service.impl.ProductPurchaseServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.osb.koroneiki.trunk.model.ProductPurchase
			addProductPurchase(
				long accountId, long projectId, long productEntryId,
				java.util.Date startDate, java.util.Date endDate, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addProductPurchase(
			accountId, projectId, productEntryId, startDate, endDate, quantity);
	}

	public static com.liferay.osb.koroneiki.trunk.model.ProductPurchase
			deleteProductPurchase(long productPurchaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteProductPurchase(productPurchaseId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.osb.koroneiki.trunk.model.ProductPurchase
			updateProductPurchase(
				long productPurchaseId, java.util.Date startDate,
				java.util.Date endDate, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateProductPurchase(
			productPurchaseId, startDate, endDate, quantity);
	}

	public static ProductPurchaseService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProductPurchaseService, ProductPurchaseService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProductPurchaseService.class);

		ServiceTracker<ProductPurchaseService, ProductPurchaseService>
			serviceTracker =
				new ServiceTracker
					<ProductPurchaseService, ProductPurchaseService>(
						bundle.getBundleContext(), ProductPurchaseService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}