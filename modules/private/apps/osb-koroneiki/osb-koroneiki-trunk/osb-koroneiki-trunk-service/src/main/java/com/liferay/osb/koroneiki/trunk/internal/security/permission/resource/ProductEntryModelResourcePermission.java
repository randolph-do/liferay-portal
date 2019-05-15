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

package com.liferay.osb.koroneiki.trunk.internal.security.permission.resource;

import com.liferay.osb.koroneiki.trunk.model.ProductEntry;
import com.liferay.osb.koroneiki.trunk.permission.ProductEntryPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.osb.koroneiki.trunk.model.ProductEntry",
	service = ModelResourcePermission.class
)
public class ProductEntryModelResourcePermission
	implements ModelResourcePermission<ProductEntry> {

	@Override
	public void check(
			PermissionChecker permissionChecker, long productEntryId,
			String actionId)
		throws PortalException {

		productEntryPermission.check(
			permissionChecker, productEntryId, actionId);
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, ProductEntry productEntry,
			String actionId)
		throws PortalException {

		productEntryPermission.check(permissionChecker, productEntry, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long productEntryId,
			String actionId)
		throws PortalException {

		return productEntryPermission.contains(
			permissionChecker, productEntryId, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, ProductEntry productEntry,
			String actionId)
		throws PortalException {

		return productEntryPermission.contains(
			permissionChecker, productEntry, actionId);
	}

	@Override
	public String getModelName() {
		return ProductEntry.class.getName();
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return null;
	}

	@Reference
	protected ProductEntryPermission productEntryPermission;

}