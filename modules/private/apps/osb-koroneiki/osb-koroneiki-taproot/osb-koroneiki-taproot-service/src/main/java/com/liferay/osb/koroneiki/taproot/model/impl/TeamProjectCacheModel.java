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

import com.liferay.osb.koroneiki.taproot.model.TeamProject;
import com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectPK;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TeamProject in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TeamProjectCacheModel
	implements CacheModel<TeamProject>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TeamProjectCacheModel)) {
			return false;
		}

		TeamProjectCacheModel teamProjectCacheModel =
			(TeamProjectCacheModel)obj;

		if (teamProjectPK.equals(teamProjectCacheModel.teamProjectPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, teamProjectPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{teamId=");
		sb.append(teamId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TeamProject toEntityModel() {
		TeamProjectImpl teamProjectImpl = new TeamProjectImpl();

		teamProjectImpl.setTeamId(teamId);
		teamProjectImpl.setProjectId(projectId);

		teamProjectImpl.resetOriginalValues();

		return teamProjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		teamId = objectInput.readLong();

		projectId = objectInput.readLong();

		teamProjectPK = new TeamProjectPK(teamId, projectId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(teamId);

		objectOutput.writeLong(projectId);
	}

	public long teamId;
	public long projectId;
	public transient TeamProjectPK teamProjectPK;

}