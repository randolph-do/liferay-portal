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

package com.liferay.osb.koroneiki.taproot.internal.permission;

import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.permission.AccountPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = {})
public class AccountPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, Account account,
			String actionId)
		throws PortalException {

		getAccountPermission().check(permissionChecker, account, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long accountId,
			String actionId)
		throws PortalException {

		getAccountPermission().check(permissionChecker, accountId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, Account account,
			String actionId)
		throws PortalException {

		return getAccountPermission().contains(
			permissionChecker, account, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long accountId,
			String actionId)
		throws PortalException {

		return getAccountPermission().contains(
			permissionChecker, accountId, actionId);
	}

	public static AccountPermission getAccountPermission() {
		return _accountPermission;
	}

	@Reference(unbind = "-")
	public void setAccocuntPermission(AccountPermission accountPermission) {
		_accountPermission = accountPermission;
	}

	private static AccountPermission _accountPermission;

}