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
import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.osb.koroneiki.taproot.model.ContactProjectRole;
import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.service.base.ContactProjectRoleServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;

import java.util.List;

import org.osgi.service.component.annotations.Component;

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

		_contactModelResourcePermission.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		_projectModelResourcePermission.check(
			getPermissionChecker(), projectId,
			TaprootActionKeys.ASSIGN_CONTACT);

		_contactRoleModelResourcePermission.check(
			getPermissionChecker(), contactRoleId,
			TaprootActionKeys.ASSIGN_CONTACT);

		return contactProjectRoleLocalService.addContactProjectRole(
			contactId, projectId, contactRoleId);
	}

	public ContactProjectRole deleteContactProjectRole(
			long contactId, long projectId, long contactRoleId)
		throws PortalException {

		_contactModelResourcePermission.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		_projectModelResourcePermission.check(
			getPermissionChecker(), projectId,
			TaprootActionKeys.ASSIGN_CONTACT);

		_contactRoleModelResourcePermission.check(
			getPermissionChecker(), contactRoleId,
			TaprootActionKeys.ASSIGN_CONTACT);

		return contactProjectRoleLocalService.deleteContactProjectRole(
			contactId, projectId, contactRoleId);
	}

	public void deleteContactProjectRoles(long contactId, long projectId)
		throws PortalException {

		_contactModelResourcePermission.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		_projectModelResourcePermission.check(
			getPermissionChecker(), projectId,
			TaprootActionKeys.ASSIGN_CONTACT);

		List<ContactProjectRole> contactProjectRoles =
			contactProjectRolePersistence.findByC_P(contactId, projectId);

		for (ContactProjectRole contactProjectRole : contactProjectRoles) {
			_contactRoleModelResourcePermission.check(
				getPermissionChecker(), contactProjectRole.getContactRoleId(),
				TaprootActionKeys.ASSIGN_CONTACT);
		}

		contactProjectRoleLocalService.deleteContactProjectRoles(
			contactId, projectId);
	}

	private static volatile ModelResourcePermission<Contact>
		_contactModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				ContactProjectRoleServiceImpl.class,
				"_contactModelResourcePermission", Contact.class);
	private static volatile ModelResourcePermission<ContactRole>
		_contactRoleModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				ContactProjectRoleServiceImpl.class,
				"_contactRoleModelResourcePermission", ContactRole.class);
	private static volatile ModelResourcePermission<Project>
		_projectModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				ContactProjectRoleServiceImpl.class,
				"_projectModelResourcePermission", Project.class);

}