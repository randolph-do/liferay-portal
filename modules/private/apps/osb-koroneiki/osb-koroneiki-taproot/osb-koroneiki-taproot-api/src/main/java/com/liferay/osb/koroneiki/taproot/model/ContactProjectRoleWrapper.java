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

package com.liferay.osb.koroneiki.taproot.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ContactProjectRole}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactProjectRole
 * @generated
 */
@ProviderType
public class ContactProjectRoleWrapper
	extends BaseModelWrapper<ContactProjectRole>
	implements ContactProjectRole, ModelWrapper<ContactProjectRole> {

	public ContactProjectRoleWrapper(ContactProjectRole contactProjectRole) {
		super(contactProjectRole);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("projectId", getProjectId());
		attributes.put("contactRoleId", getContactRoleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long contactRoleId = (Long)attributes.get("contactRoleId");

		if (contactRoleId != null) {
			setContactRoleId(contactRoleId);
		}
	}

	/**
	 * Returns the contact ID of this contact project role.
	 *
	 * @return the contact ID of this contact project role
	 */
	@Override
	public long getContactId() {
		return model.getContactId();
	}

	/**
	 * Returns the contact role ID of this contact project role.
	 *
	 * @return the contact role ID of this contact project role
	 */
	@Override
	public long getContactRoleId() {
		return model.getContactRoleId();
	}

	/**
	 * Returns the primary key of this contact project role.
	 *
	 * @return the primary key of this contact project role
	 */
	@Override
	public
		com.liferay.osb.koroneiki.taproot.service.persistence.
			ContactProjectRolePK getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this contact project role.
	 *
	 * @return the project ID of this contact project role
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the contact ID of this contact project role.
	 *
	 * @param contactId the contact ID of this contact project role
	 */
	@Override
	public void setContactId(long contactId) {
		model.setContactId(contactId);
	}

	/**
	 * Sets the contact role ID of this contact project role.
	 *
	 * @param contactRoleId the contact role ID of this contact project role
	 */
	@Override
	public void setContactRoleId(long contactRoleId) {
		model.setContactRoleId(contactRoleId);
	}

	/**
	 * Sets the primary key of this contact project role.
	 *
	 * @param primaryKey the primary key of this contact project role
	 */
	@Override
	public void setPrimaryKey(
		com.liferay.osb.koroneiki.taproot.service.persistence.
			ContactProjectRolePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this contact project role.
	 *
	 * @param projectId the project ID of this contact project role
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	@Override
	protected ContactProjectRoleWrapper wrap(
		ContactProjectRole contactProjectRole) {

		return new ContactProjectRoleWrapper(contactProjectRole);
	}

}