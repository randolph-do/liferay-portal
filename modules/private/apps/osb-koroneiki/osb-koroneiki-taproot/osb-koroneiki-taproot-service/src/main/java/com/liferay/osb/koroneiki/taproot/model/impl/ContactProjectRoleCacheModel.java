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

package com.liferay.osb.koroneiki.taproot.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.koroneiki.taproot.model.ContactProjectRole;
import com.liferay.osb.koroneiki.taproot.service.persistence.ContactProjectRolePK;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ContactProjectRole in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ContactProjectRoleCacheModel
	implements CacheModel<ContactProjectRole>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactProjectRoleCacheModel)) {
			return false;
		}

		ContactProjectRoleCacheModel contactProjectRoleCacheModel =
			(ContactProjectRoleCacheModel)obj;

		if (contactProjectRolePK.equals(
				contactProjectRoleCacheModel.contactProjectRolePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, contactProjectRolePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{contactId=");
		sb.append(contactId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", contactRoleId=");
		sb.append(contactRoleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactProjectRole toEntityModel() {
		ContactProjectRoleImpl contactProjectRoleImpl =
			new ContactProjectRoleImpl();

		contactProjectRoleImpl.setContactId(contactId);
		contactProjectRoleImpl.setProjectId(projectId);
		contactProjectRoleImpl.setContactRoleId(contactRoleId);

		contactProjectRoleImpl.resetOriginalValues();

		return contactProjectRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactId = objectInput.readLong();

		projectId = objectInput.readLong();

		contactRoleId = objectInput.readLong();

		contactProjectRolePK = new ContactProjectRolePK(
			contactId, projectId, contactRoleId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(contactId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(contactRoleId);
	}

	public long contactId;
	public long projectId;
	public long contactRoleId;
	public transient ContactProjectRolePK contactProjectRolePK;

}