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

package com.liferay.osb.koroneiki.taproot.service.impl;

import com.liferay.osb.koroneiki.taproot.constants.TaprootActionKeys;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.service.base.AccountServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.service.permission.PortalPermissionUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=Account"
	},
	service = AopService.class
)
public class AccountServiceImpl extends AccountServiceBaseImpl {

	public Account addAccount(
			String name, String description, long logoId, long addressId,
			String contactEmailAddress, String profileEmailAddress,
			String phoneNumber, String faxNumber, String website, int status)
		throws PortalException {

		PortalPermissionUtil.check(
			getPermissionChecker(), TaprootActionKeys.ADD_ACCOUNT);

		return accountLocalService.addAccount(
			getUserId(), name, description, logoId, addressId,
			contactEmailAddress, profileEmailAddress, phoneNumber, faxNumber,
			website, status);
	}

	public Account deleteAccount(long accountId) throws PortalException {
		_accountModelResourcePermission.check(
			getPermissionChecker(), accountId, ActionKeys.DELETE);

		return accountLocalService.deleteAccount(accountId);
	}

	public Account getAccount(long accountId) throws PortalException {
		_accountModelResourcePermission.check(
			getPermissionChecker(), accountId, ActionKeys.VIEW);

		return accountLocalService.getAccount(accountId);
	}

	public Account updateAccount(
			long accountId, String name, String description, long logoId,
			long addressId, String contactEmailAddress,
			String profileEmailAddress, String phoneNumber, String faxNumber,
			String website, int status)
		throws PortalException {

		_accountModelResourcePermission.check(
			getPermissionChecker(), accountId, ActionKeys.UPDATE);

		return accountLocalService.updateAccount(
			getUserId(), accountId, name, description, logoId, addressId,
			contactEmailAddress, profileEmailAddress, phoneNumber, faxNumber,
			website, status);
	}

	private static volatile ModelResourcePermission<Account>
		_accountModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				AccountServiceImpl.class, "_accountModelResourcePermission",
				Account.class);

}