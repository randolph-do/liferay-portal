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

package com.liferay.osb.koroneiki.taproot.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Address. This utility wraps
 * <code>com.liferay.osb.koroneiki.taproot.service.impl.AddressServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AddressService
 * @generated
 */
@ProviderType
public class AddressServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.osb.koroneiki.taproot.service.impl.AddressServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.Address addAddress(
			String className, long classPK, String street1, String street2,
			String street3, String city, String zip, long regionId,
			long countryId, long typeId, boolean mailing, boolean primary,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAddress(
			className, classPK, street1, street2, street3, city, zip, regionId,
			countryId, typeId, mailing, primary, serviceContext);
	}

	public static void deleteAddress(long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteAddress(addressId);
	}

	public static com.liferay.portal.kernel.model.Address getAddress(
			long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAddress(addressId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.Address updateAddress(
			long addressId, String street1, String street2, String street3,
			String city, String zip, long regionId, long countryId, long typeId,
			boolean mailing, boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateAddress(
			addressId, street1, street2, street3, city, zip, regionId,
			countryId, typeId, mailing, primary);
	}

	public static AddressService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AddressService, AddressService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AddressService.class);

		ServiceTracker<AddressService, AddressService> serviceTracker =
			new ServiceTracker<AddressService, AddressService>(
				bundle.getBundleContext(), AddressService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}