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

import com.liferay.osb.koroneiki.trunk.model.ProductField;
import com.liferay.osb.koroneiki.trunk.permission.ProductFieldPermission;
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
	property = "model.class.name=com.liferay.osb.koroneiki.trunk.model.ProductField",
	service = ModelResourcePermission.class
)
public class ProductFieldModelResourcePermission
	implements ModelResourcePermission<ProductField> {

	@Override
	public void check(
			PermissionChecker permissionChecker, long productFieldId,
			String actionId)
		throws PortalException {

		productFieldPermission.check(
			permissionChecker, productFieldId, actionId);
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, ProductField productField,
			String actionId)
		throws PortalException {

		productFieldPermission.check(permissionChecker, productField, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long productFieldId,
			String actionId)
		throws PortalException {

		return productFieldPermission.contains(
			permissionChecker, productFieldId, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, ProductField productField,
			String actionId)
		throws PortalException {

		return productFieldPermission.contains(
			permissionChecker, productField, actionId);
	}

	@Override
	public String getModelName() {
		return ProductField.class.getName();
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return null;
	}

	@Reference
	protected ProductFieldPermission productFieldPermission;

}