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

import com.liferay.osb.koroneiki.root.util.ModelKeyGenerator;
import com.liferay.osb.koroneiki.taproot.constants.ContactRoleSystem;
import com.liferay.osb.koroneiki.taproot.constants.ContactRoleType;
import com.liferay.osb.koroneiki.taproot.exception.ContactRoleNameException;
import com.liferay.osb.koroneiki.taproot.exception.ContactRoleSystemException;
import com.liferay.osb.koroneiki.taproot.exception.ContactRoleTypeException;
import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.osb.koroneiki.taproot.service.base.ContactRoleLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.instances.service.PortalInstancesLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.taproot.model.ContactRole",
	service = AopService.class
)
public class ContactRoleLocalServiceImpl
	extends ContactRoleLocalServiceBaseImpl {

	public ContactRole addContactRole(
			long userId, String name, String description, int type)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		validate(name, type);

		long contactRoleId = counterLocalService.increment();

		ContactRole contactRole = contactRolePersistence.create(contactRoleId);

		contactRole.setCompanyId(user.getCompanyId());
		contactRole.setUserId(userId);
		contactRole.setContactRoleKey(
			ModelKeyGenerator.generate(contactRoleId));
		contactRole.setName(name);
		contactRole.setDescription(description);
		contactRole.setType(type);

		contactRolePersistence.update(contactRole);

		// Resources

		resourceLocalService.addResources(
			contactRole.getCompanyId(), 0, userId, ContactRole.class.getName(),
			contactRole.getContactRoleId(), false, false, false);

		return contactRole;
	}

	public void checkMemberRoles() throws PortalException {
		long companyId = _portalInstancesLocalService.getDefaultCompanyId();

		User user = userLocalService.getDefaultUser(companyId);

		for (int type : ContactRoleType.VALUES) {
			ContactRole contactRole = contactRolePersistence.fetchByN_T_S(
				ContactRoleSystem.NAME_MEMBER, type, true);

			if (contactRole == null) {
				String description =
					"All users assigned to a " +
						ContactRoleType.getLabel(type) + " have this role.";

				contactRole = addContactRole(
					user.getUserId(), ContactRoleSystem.NAME_MEMBER,
					description, type);

				contactRole.setSystem(true);

				contactRole = contactRolePersistence.update(contactRole);
			}

			_memberContactRoles.put(type, contactRole);
		}
	}

	@Override
	public ContactRole deleteContactRole(ContactRole contactRole)
		throws PortalException {

		if (contactRole.isSystem()) {
			throw new ContactRoleSystemException();
		}

		// Contact account roles

		contactAccountRolePersistence.removeByContactRoleId(
			contactRole.getContactRoleId());

		// Contact project roles

		contactProjectRolePersistence.removeByContactRoleId(
			contactRole.getContactRoleId());

		// Contact team roles

		contactTeamRolePersistence.removeByContactRoleId(
			contactRole.getContactRoleId());

		// Resources

		resourceLocalService.deleteResource(
			contactRole.getCompanyId(), ContactRole.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, contactRole.getContactRoleId());

		return contactRolePersistence.remove(contactRole);
	}

	@Override
	public ContactRole deleteContactRole(long contactRoleId)
		throws PortalException {

		return deleteContactRole(
			contactRoleLocalService.getContactRole(contactRoleId));
	}

	public List<ContactRole> getContactAccountContactRoles(
		long accountId, long contactId) {

		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("accountContact", new Long[] {accountId, contactId});

		return contactRoleFinder.findByName(
			null, params, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<ContactRole> getContactProjectContactRoles(
		long projectId, long contactId) {

		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("projectContact", new Long[] {projectId, contactId});

		return contactRoleFinder.findByName(
			null, params, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public ContactRole getContactRole(String contactRoleKey)
		throws PortalException {

		return contactRolePersistence.findByContactRoleKey(contactRoleKey);
	}

	public List<ContactRole> getContactRoles(int type, int start, int end) {
		return contactRolePersistence.findByType(type, start, end);
	}

	public int getContactRolesCount(int type) {
		return contactRolePersistence.countByType(type);
	}

	public List<ContactRole> getContactTeamContactRoles(
		long teamId, long contactId) {

		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("teamContact", new Long[] {teamId, contactId});

		return contactRoleFinder.findByName(
			null, params, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public ContactRole getMemberContactRole(int type) {
		return _memberContactRoles.get(type);
	}

	public ContactRole updateContactRole(
			long contactRoleId, String name, String description)
		throws PortalException {

		ContactRole contactRole = contactRolePersistence.findByPrimaryKey(
			contactRoleId);

		validate(name, contactRole.getType());

		contactRole.setName(name);
		contactRole.setDescription(description);

		return contactRolePersistence.update(contactRole);
	}

	protected void validate(String name, int type) throws PortalException {
		if (Validator.isNull(name)) {
			throw new ContactRoleNameException();
		}

		if (!ArrayUtil.contains(ContactRoleType.VALUES, type)) {
			throw new ContactRoleTypeException();
		}
	}

	private final Map<Integer, ContactRole> _memberContactRoles =
		new HashMap<>();

	@Reference
	private PortalInstancesLocalService _portalInstancesLocalService;

}