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

package com.liferay.osb.koroneiki.root.model.impl;

import com.liferay.osb.koroneiki.root.model.ExternalIdMapper;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing ExternalIdMapper in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ExternalIdMapperCacheModel
	implements CacheModel<ExternalIdMapper>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExternalIdMapperCacheModel)) {
			return false;
		}

		ExternalIdMapperCacheModel externalIdMapperCacheModel =
			(ExternalIdMapperCacheModel)obj;

		if (externalIdMapperId ==
				externalIdMapperCacheModel.externalIdMapperId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, externalIdMapperId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{externalIdMapperId=");
		sb.append(externalIdMapperId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", externalSource=");
		sb.append(externalSource);
		sb.append(", externalId=");
		sb.append(externalId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExternalIdMapper toEntityModel() {
		ExternalIdMapperImpl externalIdMapperImpl = new ExternalIdMapperImpl();

		externalIdMapperImpl.setExternalIdMapperId(externalIdMapperId);
		externalIdMapperImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			externalIdMapperImpl.setCreateDate(null);
		}
		else {
			externalIdMapperImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			externalIdMapperImpl.setModifiedDate(null);
		}
		else {
			externalIdMapperImpl.setModifiedDate(new Date(modifiedDate));
		}

		externalIdMapperImpl.setClassNameId(classNameId);
		externalIdMapperImpl.setClassPK(classPK);
		externalIdMapperImpl.setExternalSource(externalSource);

		if (externalId == null) {
			externalIdMapperImpl.setExternalId("");
		}
		else {
			externalIdMapperImpl.setExternalId(externalId);
		}

		externalIdMapperImpl.resetOriginalValues();

		return externalIdMapperImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		externalIdMapperId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		classNameId = objectInput.readLong();

		classPK = objectInput.readLong();

		externalSource = objectInput.readInt();
		externalId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(externalIdMapperId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(classNameId);

		objectOutput.writeLong(classPK);

		objectOutput.writeInt(externalSource);

		if (externalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalId);
		}
	}

	public long externalIdMapperId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public int externalSource;
	public String externalId;

}