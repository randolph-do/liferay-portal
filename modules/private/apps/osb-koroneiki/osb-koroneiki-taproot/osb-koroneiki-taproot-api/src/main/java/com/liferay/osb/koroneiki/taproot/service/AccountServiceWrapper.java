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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link AccountService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountService
 * @generated
 */
@ProviderType
public class AccountServiceWrapper
	implements AccountService, ServiceWrapper<AccountService> {

	public AccountServiceWrapper(AccountService accountService) {
		_accountService = accountService;
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Account addAccount(
			String name, String description, long logoId, long addressId,
			String contactEmailAddress, String profileEmailAddress,
			String phoneNumber, String faxNumber, String website, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountService.addAccount(
			name, description, logoId, addressId, contactEmailAddress,
			profileEmailAddress, phoneNumber, faxNumber, website, status);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Account deleteAccount(
			long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountService.deleteAccount(accountId);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Account getAccount(
			long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountService.getAccount(accountId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Account updateAccount(
			long accountId, String name, String description, long logoId,
			long addressId, String contactEmailAddress,
			String profileEmailAddress, String phoneNumber, String faxNumber,
			String website, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountService.updateAccount(
			accountId, name, description, logoId, addressId,
			contactEmailAddress, profileEmailAddress, phoneNumber, faxNumber,
			website, status);
	}

	@Override
	public AccountService getWrappedService() {
		return _accountService;
	}

	@Override
	public void setWrappedService(AccountService accountService) {
		_accountService = accountService;
	}

	private AccountService _accountService;

}