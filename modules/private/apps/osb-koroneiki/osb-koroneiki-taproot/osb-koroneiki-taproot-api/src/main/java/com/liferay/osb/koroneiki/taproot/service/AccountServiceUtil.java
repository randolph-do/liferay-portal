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

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Account. This utility wraps
 * <code>com.liferay.osb.koroneiki.taproot.service.impl.AccountServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AccountService
 * @generated
 */
@ProviderType
public class AccountServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.osb.koroneiki.taproot.service.impl.AccountServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.osb.koroneiki.taproot.model.Account addAccount(
			String name, String description, long logoId, long addressId,
			String contactEmailAddress, String profileEmailAddress,
			String phoneNumber, String faxNumber, String website, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAccount(
			name, description, logoId, addressId, contactEmailAddress,
			profileEmailAddress, phoneNumber, faxNumber, website, status);
	}

	public static com.liferay.osb.koroneiki.taproot.model.Account deleteAccount(
			long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAccount(accountId);
	}

	public static com.liferay.osb.koroneiki.taproot.model.Account getAccount(
			long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAccount(accountId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.osb.koroneiki.taproot.model.Account updateAccount(
			long accountId, String name, String description, long logoId,
			long addressId, String contactEmailAddress,
			String profileEmailAddress, String phoneNumber, String faxNumber,
			String website, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateAccount(
			accountId, name, description, logoId, addressId,
			contactEmailAddress, profileEmailAddress, phoneNumber, faxNumber,
			website, status);
	}

	public static AccountService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AccountService, AccountService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AccountService.class);

		ServiceTracker<AccountService, AccountService> serviceTracker =
			new ServiceTracker<AccountService, AccountService>(
				bundle.getBundleContext(), AccountService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}