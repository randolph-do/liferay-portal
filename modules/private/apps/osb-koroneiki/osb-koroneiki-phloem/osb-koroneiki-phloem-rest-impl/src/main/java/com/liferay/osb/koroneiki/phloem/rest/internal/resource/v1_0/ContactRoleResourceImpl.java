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

package com.liferay.osb.koroneiki.phloem.rest.internal.resource.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ContactRole;
import com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util.ContactRoleUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ContactRoleResource;
import com.liferay.osb.koroneiki.taproot.constants.ContactRoleType;
import com.liferay.osb.koroneiki.taproot.service.ContactRoleService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Amos Fong
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/contact-role.properties",
	scope = ServiceScope.PROTOTYPE, service = ContactRoleResource.class
)
public class ContactRoleResourceImpl extends BaseContactRoleResourceImpl {

	@Override
	public void deleteContactRole(Long contactRoleId) throws Exception {
		_contactRoleService.deleteContactRole(contactRoleId);
	}

	@Override
	public ContactRole getContactRole(Long contactRoleId) throws Exception {
		return ContactRoleUtil.toContactRole(
			_contactRoleService.getContactRole(contactRoleId));
	}

	@Override
	public ContactRole postContactRole(ContactRole contactRole)
		throws Exception {

		int type = ContactRoleType.fromLabel(contactRole.getType());

		return ContactRoleUtil.toContactRole(
			_contactRoleService.addContactRole(
				contactRole.getName(), contactRole.getDescription(), type));
	}

	@Override
	public ContactRole putContactRole(
			Long contactRoleId, ContactRole contactRole)
		throws Exception {

		return ContactRoleUtil.toContactRole(
			_contactRoleService.updateContactRole(
				contactRoleId, contactRole.getName(),
				contactRole.getDescription()));
	}

	@Reference
	private ContactRoleService _contactRoleService;

}