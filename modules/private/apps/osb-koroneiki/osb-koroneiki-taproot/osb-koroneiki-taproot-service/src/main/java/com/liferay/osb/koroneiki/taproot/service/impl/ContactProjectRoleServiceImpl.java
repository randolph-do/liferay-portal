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
import com.liferay.osb.koroneiki.taproot.model.ContactProjectRole;
import com.liferay.osb.koroneiki.taproot.permission.ContactPermission;
import com.liferay.osb.koroneiki.taproot.permission.ContactRolePermission;
import com.liferay.osb.koroneiki.taproot.permission.ProjectPermission;
import com.liferay.osb.koroneiki.taproot.service.base.ContactProjectRoleServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=ContactProjectRole"
	},
	service = AopService.class
)
public class ContactProjectRoleServiceImpl
	extends ContactProjectRoleServiceBaseImpl {

	public ContactProjectRole addContactProjectRole(
			long contactId, long projectId, long contactRoleId)
		throws PortalException {

		_contactPermission.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		_projectPermission.check(
			getPermissionChecker(), projectId,
			TaprootActionKeys.ASSIGN_CONTACT);

		_contactRolePermission.check(
			getPermissionChecker(), contactRoleId,
			TaprootActionKeys.ASSIGN_CONTACT);

		return contactProjectRoleLocalService.addContactProjectRole(
			contactId, projectId, contactRoleId);
	}

	public ContactProjectRole deleteContactProjectRole(
			long contactId, long projectId, long contactRoleId)
		throws PortalException {

		_contactPermission.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		_projectPermission.check(
			getPermissionChecker(), projectId,
			TaprootActionKeys.ASSIGN_CONTACT);

		_contactRolePermission.check(
			getPermissionChecker(), contactRoleId,
			TaprootActionKeys.ASSIGN_CONTACT);

		return contactProjectRoleLocalService.deleteContactProjectRole(
			contactId, projectId, contactRoleId);
	}

	public void deleteContactProjectRoles(long contactId, long projectId)
		throws PortalException {

		_contactPermission.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		_projectPermission.check(
			getPermissionChecker(), projectId,
			TaprootActionKeys.ASSIGN_CONTACT);

		List<ContactProjectRole> contactProjectRoles =
			contactProjectRolePersistence.findByC_P(contactId, projectId);

		for (ContactProjectRole contactProjectRole : contactProjectRoles) {
			_contactRolePermission.check(
				getPermissionChecker(), contactProjectRole.getContactRoleId(),
				TaprootActionKeys.ASSIGN_CONTACT);
		}

		contactProjectRoleLocalService.deleteContactProjectRoles(
			contactId, projectId);
	}

	@Reference
	private ContactPermission _contactPermission;

	@Reference
	private ContactRolePermission _contactRolePermission;

	@Reference
	private ProjectPermission _projectPermission;

}