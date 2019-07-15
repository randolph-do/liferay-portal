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
import com.liferay.osb.koroneiki.taproot.permission.ContactPermission;
import com.liferay.osb.koroneiki.taproot.permission.ContactRolePermission;
import com.liferay.osb.koroneiki.taproot.permission.ProjectPermission;
import com.liferay.osb.koroneiki.taproot.service.ContactLocalService;
import com.liferay.osb.koroneiki.taproot.service.ContactRoleLocalService;
import com.liferay.osb.koroneiki.taproot.service.ProjectLocalService;
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

	public ContactProjectRole addContactProjectRole(
			String contactKey, String projectKey, String contactRoleKey)
		throws PortalException {

		Contact contact = _contactLocalService.getContactByContactKey(
			contactKey);
		Project project = _projectLocalService.getProject(projectKey);
		ContactRole contactRole = _contactRoleLocalService.getContactRole(
			contactRoleKey);

		_contactPermission.check(
			getPermissionChecker(), contact, ActionKeys.VIEW);

		_projectPermission.check(
			getPermissionChecker(), project, TaprootActionKeys.ASSIGN_CONTACT);

		_contactRolePermission.check(
			getPermissionChecker(), contactRole,
			TaprootActionKeys.ASSIGN_CONTACT);

		return contactProjectRoleLocalService.addContactProjectRole(
			contact.getContactId(), project.getProjectId(),
			contactRole.getContactRoleId());
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

	public ContactProjectRole deleteContactProjectRole(
			String contactKey, String projectKey, String contactRoleKey)
		throws PortalException {

		Contact contact = _contactLocalService.getContactByContactKey(
			contactKey);
		Project project = _projectLocalService.getProject(projectKey);
		ContactRole contactRole = _contactRoleLocalService.getContactRole(
			contactRoleKey);

		_contactPermission.check(
			getPermissionChecker(), contact, ActionKeys.VIEW);

		_projectPermission.check(
			getPermissionChecker(), project, TaprootActionKeys.ASSIGN_CONTACT);

		_contactRolePermission.check(
			getPermissionChecker(), contactRole,
			TaprootActionKeys.ASSIGN_CONTACT);

		return contactProjectRoleLocalService.deleteContactProjectRole(
			contact.getContactId(), project.getProjectId(),
			contactRole.getContactRoleId());
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

	public void deleteContactProjectRoles(String contactKey, String projectKey)
		throws PortalException {

		Contact contact = _contactLocalService.getContactByContactKey(
			contactKey);
		Project project = _projectLocalService.getProject(projectKey);

		_contactPermission.check(
			getPermissionChecker(), contact, ActionKeys.VIEW);

		_projectPermission.check(
			getPermissionChecker(), project, TaprootActionKeys.ASSIGN_CONTACT);

		List<ContactProjectRole> contactProjectRoles =
			contactProjectRolePersistence.findByC_P(
				contact.getContactId(), project.getProjectId());

		for (ContactProjectRole contactProjectRole : contactProjectRoles) {
			_contactRolePermission.check(
				getPermissionChecker(), contactProjectRole.getContactRoleId(),
				TaprootActionKeys.ASSIGN_CONTACT);
		}

		contactProjectRoleLocalService.deleteContactProjectRoles(
			contact.getContactId(), project.getProjectId());
	}

	@Reference
	private ContactLocalService _contactLocalService;

	@Reference
	private ContactPermission _contactPermission;

	@Reference
	private ContactRoleLocalService _contactRoleLocalService;

	@Reference
	private ContactRolePermission _contactRolePermission;

	@Reference
	private ProjectLocalService _projectLocalService;

	@Reference
	private ProjectPermission _projectPermission;

}