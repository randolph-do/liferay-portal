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

import com.liferay.osb.koroneiki.trunk.model.ProductField;
import com.liferay.osb.koroneiki.trunk.permission.ProductFieldPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.ArrayUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = ProductFieldPermission.class)
public class ProductFieldPermissionImpl implements ProductFieldPermission {

	@Override
	public void check(
			PermissionChecker permissionChecker, long productFieldId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, productFieldId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, ProductField.class.getName(), productFieldId,
				actionId);
		}
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, ProductField productField,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, productField, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, ProductField.class.getName(),
				productField.getProductFieldId(), actionId);
		}
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long productFieldId,
			String actionId)
		throws PortalException {

		if (permissionChecker.isOmniadmin()) {
			return true;
		}

		return false;
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long[] productFieldIds,
			String actionId)
		throws PortalException {

		if (ArrayUtil.isEmpty(productFieldIds)) {
			return false;
		}

		for (long productFieldId : productFieldIds) {
			if (!contains(permissionChecker, productFieldId, actionId)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, ProductField productField,
			String actionId)
		throws PortalException {

		if (contains(
				permissionChecker, productField.getProductFieldId(),
				actionId)) {

			return true;
		}

		return false;
	}

}