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

import com.liferay.osb.koroneiki.taproot.model.ContactProjectRole;
import com.liferay.osb.koroneiki.taproot.service.ProjectLocalService;
import com.liferay.osb.koroneiki.taproot.service.base.ContactProjectRoleLocalServiceBaseImpl;
import com.liferay.osb.koroneiki.taproot.service.persistence.ContactProjectRolePK;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.taproot.model.ContactProjectRole",
	service = AopService.class
)
public class ContactProjectRoleLocalServiceImpl
	extends ContactProjectRoleLocalServiceBaseImpl {

	public ContactProjectRole addContactProjectRole(
			long contactId, long projectId, long contactRoleId)
		throws PortalException {

		validate(contactId, projectId);

		ContactProjectRolePK contactProjectRolePK = new ContactProjectRolePK(
			contactId, projectId, contactRoleId);

		ContactProjectRole contactProjectRole =
			contactProjectRolePersistence.fetchByPrimaryKey(
				contactProjectRolePK);

		if (contactProjectRole == null) {
			contactProjectRole = contactProjectRolePersistence.create(
				contactProjectRolePK);

			contactProjectRolePersistence.update(contactProjectRole);

			_projectLocalService.reindex(projectId);
		}

		return contactProjectRole;
	}

	public ContactProjectRole deleteContactProjectRole(
			long contactId, long projectId, long contactRoleId)
		throws PortalException {

		ContactProjectRolePK contactProjectRolePK = new ContactProjectRolePK(
			contactId, projectId, contactRoleId);

		ContactProjectRole contactProjectRole =
			contactProjectRolePersistence.fetchByPrimaryKey(
				contactProjectRolePK);

		if (contactProjectRole != null) {
			deleteContactProjectRole(contactProjectRole);

			_projectLocalService.reindex(projectId);
		}

		return contactProjectRole;
	}

	public void deleteContactProjectRoles(long contactId, long projectId)
		throws PortalException {

		contactProjectRolePersistence.removeByC_P(contactId, projectId);

		_projectLocalService.reindex(projectId);
	}

	public List<ContactProjectRole> getContactProjectRolesByProjectId(
		long projectId) {

		return contactProjectRolePersistence.findByProjectId(projectId);
	}

	protected void validate(long contactId, long projectId)
		throws PortalException {

		contactPersistence.findByPrimaryKey(contactId);

		projectPersistence.findByPrimaryKey(projectId);
	}

	@Reference
	private ProjectLocalService _projectLocalService;

}