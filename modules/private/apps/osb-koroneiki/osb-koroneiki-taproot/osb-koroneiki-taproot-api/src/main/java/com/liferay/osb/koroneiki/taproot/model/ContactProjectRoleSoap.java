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

import com.liferay.osb.koroneiki.taproot.service.persistence.ContactProjectRolePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.koroneiki.taproot.service.http.ContactProjectRoleServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ContactProjectRoleSoap implements Serializable {

	public static ContactProjectRoleSoap toSoapModel(ContactProjectRole model) {
		ContactProjectRoleSoap soapModel = new ContactProjectRoleSoap();

		soapModel.setContactId(model.getContactId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setContactRoleId(model.getContactRoleId());

		return soapModel;
	}

	public static ContactProjectRoleSoap[] toSoapModels(
		ContactProjectRole[] models) {

		ContactProjectRoleSoap[] soapModels =
			new ContactProjectRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactProjectRoleSoap[][] toSoapModels(
		ContactProjectRole[][] models) {

		ContactProjectRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ContactProjectRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactProjectRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactProjectRoleSoap[] toSoapModels(
		List<ContactProjectRole> models) {

		List<ContactProjectRoleSoap> soapModels =
			new ArrayList<ContactProjectRoleSoap>(models.size());

		for (ContactProjectRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ContactProjectRoleSoap[soapModels.size()]);
	}

	public ContactProjectRoleSoap() {
	}

	public ContactProjectRolePK getPrimaryKey() {
		return new ContactProjectRolePK(_contactId, _projectId, _contactRoleId);
	}

	public void setPrimaryKey(ContactProjectRolePK pk) {
		setContactId(pk.contactId);
		setProjectId(pk.projectId);
		setContactRoleId(pk.contactRoleId);
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getContactRoleId() {
		return _contactRoleId;
	}

	public void setContactRoleId(long contactRoleId) {
		_contactRoleId = contactRoleId;
	}

	private long _contactId;
	private long _projectId;
	private long _contactRoleId;

}