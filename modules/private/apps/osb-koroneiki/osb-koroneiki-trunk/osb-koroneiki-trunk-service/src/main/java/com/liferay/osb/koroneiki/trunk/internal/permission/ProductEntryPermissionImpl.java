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

package com.liferay.osb.koroneiki.trunk.internal.permission;

import com.liferay.osb.koroneiki.trunk.model.ProductEntry;
import com.liferay.osb.koroneiki.trunk.permission.ProductEntryPermission;
import com.liferay.osb.koroneiki.trunk.service.ProductEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.ArrayUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = ProductEntryPermission.class)
public class ProductEntryPermissionImpl implements ProductEntryPermission {

	@Override
	public void check(
			PermissionChecker permissionChecker, long productEntryId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, productEntryId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, ProductEntry.class.getName(), productEntryId,
				actionId);
		}
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, ProductEntry productEntry,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, productEntry, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, ProductEntry.class.getName(),
				productEntry.getProductEntryId(), actionId);
		}
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long productEntryId,
			String actionId)
		throws PortalException {

		if (permissionChecker.isOmniadmin()) {
			return true;
		}

		return false;
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long[] productEntryIds,
			String actionId)
		throws PortalException {

		if (ArrayUtil.isEmpty(productEntryIds)) {
			return false;
		}

		for (long productEntryId : productEntryIds) {
			if (!contains(permissionChecker, productEntryId, actionId)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, ProductEntry productEntry,
			String actionId)
		throws PortalException {

		if (contains(
				permissionChecker, productEntry.getProductEntryId(),
				actionId)) {

			return true;
		}

		return false;
	}

	@Reference
	private ProductEntryLocalService _productEntryLocalService;

}