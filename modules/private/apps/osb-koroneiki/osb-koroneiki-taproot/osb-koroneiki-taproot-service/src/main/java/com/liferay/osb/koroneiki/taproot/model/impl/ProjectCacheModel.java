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

import com.liferay.osb.koroneiki.taproot.model.Project;
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
 * The cache model class for representing Project in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectCacheModel)) {
			return false;
		}

		ProjectCacheModel projectCacheModel = (ProjectCacheModel)obj;

		if (projectId == projectCacheModel.projectId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", projectKey=");
		sb.append(projectKey);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append(", industry=");
		sb.append(industry);
		sb.append(", tier=");
		sb.append(tier);
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", soldBy=");
		sb.append(soldBy);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", statusMessage=");
		sb.append(statusMessage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project toEntityModel() {
		ProjectImpl projectImpl = new ProjectImpl();

		if (uuid == null) {
			projectImpl.setUuid("");
		}
		else {
			projectImpl.setUuid(uuid);
		}

		projectImpl.setProjectId(projectId);
		projectImpl.setCompanyId(companyId);
		projectImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			projectImpl.setCreateDate(null);
		}
		else {
			projectImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectImpl.setModifiedDate(null);
		}
		else {
			projectImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (projectKey == null) {
			projectImpl.setProjectKey("");
		}
		else {
			projectImpl.setProjectKey(projectKey);
		}

		projectImpl.setAccountId(accountId);

		if (name == null) {
			projectImpl.setName("");
		}
		else {
			projectImpl.setName(name);
		}

		if (code == null) {
			projectImpl.setCode("");
		}
		else {
			projectImpl.setCode(code);
		}

		if (industry == null) {
			projectImpl.setIndustry("");
		}
		else {
			projectImpl.setIndustry(industry);
		}

		if (tier == null) {
			projectImpl.setTier("");
		}
		else {
			projectImpl.setTier(tier);
		}

		if (notes == null) {
			projectImpl.setNotes("");
		}
		else {
			projectImpl.setNotes(notes);
		}

		if (soldBy == null) {
			projectImpl.setSoldBy("");
		}
		else {
			projectImpl.setSoldBy(soldBy);
		}

		projectImpl.setStatus(status);
		projectImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			projectImpl.setStatusByUserName("");
		}
		else {
			projectImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			projectImpl.setStatusDate(null);
		}
		else {
			projectImpl.setStatusDate(new Date(statusDate));
		}

		if (statusMessage == null) {
			projectImpl.setStatusMessage("");
		}
		else {
			projectImpl.setStatusMessage(statusMessage);
		}

		projectImpl.resetOriginalValues();

		return projectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		projectId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		projectKey = objectInput.readUTF();

		accountId = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();
		industry = objectInput.readUTF();
		tier = objectInput.readUTF();
		notes = objectInput.readUTF();
		soldBy = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		statusMessage = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (projectKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectKey);
		}

		objectOutput.writeLong(accountId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (industry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(industry);
		}

		if (tier == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tier);
		}

		if (notes == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(notes);
		}

		if (soldBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(soldBy);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (statusMessage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusMessage);
		}
	}

	public String uuid;
	public long projectId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String projectKey;
	public long accountId;
	public String name;
	public String code;
	public String industry;
	public String tier;
	public String notes;
	public String soldBy;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String statusMessage;

}