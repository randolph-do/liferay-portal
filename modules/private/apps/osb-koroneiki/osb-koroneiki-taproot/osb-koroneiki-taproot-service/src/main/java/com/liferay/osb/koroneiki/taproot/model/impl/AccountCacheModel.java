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

import com.liferay.osb.koroneiki.taproot.model.Account;
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
 * The cache model class for representing Account in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AccountCacheModel implements CacheModel<Account>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AccountCacheModel)) {
			return false;
		}

		AccountCacheModel accountCacheModel = (AccountCacheModel)obj;

		if (accountId == accountCacheModel.accountId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, accountId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", accountKey=");
		sb.append(accountKey);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", logoId=");
		sb.append(logoId);
		sb.append(", contactEmailAddress=");
		sb.append(contactEmailAddress);
		sb.append(", profileEmailAddress=");
		sb.append(profileEmailAddress);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", faxNumber=");
		sb.append(faxNumber);
		sb.append(", website=");
		sb.append(website);
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
	public Account toEntityModel() {
		AccountImpl accountImpl = new AccountImpl();

		if (uuid == null) {
			accountImpl.setUuid("");
		}
		else {
			accountImpl.setUuid(uuid);
		}

		accountImpl.setAccountId(accountId);
		accountImpl.setCompanyId(companyId);
		accountImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			accountImpl.setCreateDate(null);
		}
		else {
			accountImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			accountImpl.setModifiedDate(null);
		}
		else {
			accountImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (accountKey == null) {
			accountImpl.setAccountKey("");
		}
		else {
			accountImpl.setAccountKey(accountKey);
		}

		if (name == null) {
			accountImpl.setName("");
		}
		else {
			accountImpl.setName(name);
		}

		if (description == null) {
			accountImpl.setDescription("");
		}
		else {
			accountImpl.setDescription(description);
		}

		accountImpl.setLogoId(logoId);

		if (contactEmailAddress == null) {
			accountImpl.setContactEmailAddress("");
		}
		else {
			accountImpl.setContactEmailAddress(contactEmailAddress);
		}

		if (profileEmailAddress == null) {
			accountImpl.setProfileEmailAddress("");
		}
		else {
			accountImpl.setProfileEmailAddress(profileEmailAddress);
		}

		if (phoneNumber == null) {
			accountImpl.setPhoneNumber("");
		}
		else {
			accountImpl.setPhoneNumber(phoneNumber);
		}

		if (faxNumber == null) {
			accountImpl.setFaxNumber("");
		}
		else {
			accountImpl.setFaxNumber(faxNumber);
		}

		if (website == null) {
			accountImpl.setWebsite("");
		}
		else {
			accountImpl.setWebsite(website);
		}

		accountImpl.setStatus(status);
		accountImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			accountImpl.setStatusByUserName("");
		}
		else {
			accountImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			accountImpl.setStatusDate(null);
		}
		else {
			accountImpl.setStatusDate(new Date(statusDate));
		}

		if (statusMessage == null) {
			accountImpl.setStatusMessage("");
		}
		else {
			accountImpl.setStatusMessage(statusMessage);
		}

		accountImpl.resetOriginalValues();

		return accountImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		accountId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		accountKey = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		logoId = objectInput.readLong();
		contactEmailAddress = objectInput.readUTF();
		profileEmailAddress = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		faxNumber = objectInput.readUTF();
		website = objectInput.readUTF();

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

		objectOutput.writeLong(accountId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (accountKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountKey);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(logoId);

		if (contactEmailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactEmailAddress);
		}

		if (profileEmailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(profileEmailAddress);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (faxNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(faxNumber);
		}

		if (website == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(website);
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
	public long accountId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String accountKey;
	public String name;
	public String description;
	public long logoId;
	public String contactEmailAddress;
	public String profileEmailAddress;
	public String phoneNumber;
	public String faxNumber;
	public String website;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String statusMessage;

}