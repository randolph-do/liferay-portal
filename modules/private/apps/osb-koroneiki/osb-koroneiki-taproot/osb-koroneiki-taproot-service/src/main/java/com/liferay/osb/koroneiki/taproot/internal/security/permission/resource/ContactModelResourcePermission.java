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

package com.liferay.osb.koroneiki.taproot.internal.security.permission.resource;

import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.osb.koroneiki.taproot.permission.ContactPermission;
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
	property = "model.class.name=com.liferay.osb.koroneiki.taproot.model.Contact",
	service = ModelResourcePermission.class
)
public class ContactModelResourcePermission
	implements ModelResourcePermission<Contact> {

	@Override
	public void check(
			PermissionChecker permissionChecker, Contact contact,
			String actionId)
		throws PortalException {

		contactPermission.check(permissionChecker, contact, actionId);
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, long contactId,
			String actionId)
		throws PortalException {

		contactPermission.check(permissionChecker, contactId, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, Contact contact,
			String actionId)
		throws PortalException {

		return contactPermission.contains(permissionChecker, contact, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long contactId,
			String actionId)
		throws PortalException {

		return contactPermission.contains(
			permissionChecker, contactId, actionId);
	}

	@Override
	public String getModelName() {
		return Contact.class.getName();
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return null;
	}

	@Reference
	protected ContactPermission contactPermission;

}