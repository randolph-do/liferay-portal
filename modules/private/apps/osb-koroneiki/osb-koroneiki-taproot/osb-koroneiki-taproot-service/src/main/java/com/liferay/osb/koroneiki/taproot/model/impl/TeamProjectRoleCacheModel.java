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

import com.liferay.osb.koroneiki.taproot.model.TeamProjectRole;
import com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectRolePK;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing TeamProjectRole in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TeamProjectRoleCacheModel
	implements CacheModel<TeamProjectRole>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TeamProjectRoleCacheModel)) {
			return false;
		}

		TeamProjectRoleCacheModel teamProjectRoleCacheModel =
			(TeamProjectRoleCacheModel)obj;

		if (teamProjectRolePK.equals(
				teamProjectRoleCacheModel.teamProjectRolePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, teamProjectRolePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{teamId=");
		sb.append(teamId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", teamRoleId=");
		sb.append(teamRoleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TeamProjectRole toEntityModel() {
		TeamProjectRoleImpl teamProjectRoleImpl = new TeamProjectRoleImpl();

		teamProjectRoleImpl.setTeamId(teamId);
		teamProjectRoleImpl.setProjectId(projectId);
		teamProjectRoleImpl.setTeamRoleId(teamRoleId);

		teamProjectRoleImpl.resetOriginalValues();

		return teamProjectRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		teamId = objectInput.readLong();

		projectId = objectInput.readLong();

		teamRoleId = objectInput.readLong();

		teamProjectRolePK = new TeamProjectRolePK(
			teamId, projectId, teamRoleId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(teamId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(teamRoleId);
	}

	public long teamId;
	public long projectId;
	public long teamRoleId;
	public transient TeamProjectRolePK teamProjectRolePK;

}