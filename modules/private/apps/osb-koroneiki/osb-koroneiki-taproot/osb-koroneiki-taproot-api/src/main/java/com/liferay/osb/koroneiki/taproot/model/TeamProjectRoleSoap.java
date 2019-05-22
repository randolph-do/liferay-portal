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

import com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectRolePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.koroneiki.taproot.service.http.TeamProjectRoleServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TeamProjectRoleSoap implements Serializable {

	public static TeamProjectRoleSoap toSoapModel(TeamProjectRole model) {
		TeamProjectRoleSoap soapModel = new TeamProjectRoleSoap();

		soapModel.setTeamId(model.getTeamId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setTeamRoleId(model.getTeamRoleId());

		return soapModel;
	}

	public static TeamProjectRoleSoap[] toSoapModels(TeamProjectRole[] models) {
		TeamProjectRoleSoap[] soapModels =
			new TeamProjectRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TeamProjectRoleSoap[][] toSoapModels(
		TeamProjectRole[][] models) {

		TeamProjectRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TeamProjectRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TeamProjectRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TeamProjectRoleSoap[] toSoapModels(
		List<TeamProjectRole> models) {

		List<TeamProjectRoleSoap> soapModels =
			new ArrayList<TeamProjectRoleSoap>(models.size());

		for (TeamProjectRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TeamProjectRoleSoap[soapModels.size()]);
	}

	public TeamProjectRoleSoap() {
	}

	public TeamProjectRolePK getPrimaryKey() {
		return new TeamProjectRolePK(_teamId, _projectId, _teamRoleId);
	}

	public void setPrimaryKey(TeamProjectRolePK pk) {
		setTeamId(pk.teamId);
		setProjectId(pk.projectId);
		setTeamRoleId(pk.teamRoleId);
	}

	public long getTeamId() {
		return _teamId;
	}

	public void setTeamId(long teamId) {
		_teamId = teamId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getTeamRoleId() {
		return _teamRoleId;
	}

	public void setTeamRoleId(long teamRoleId) {
		_teamRoleId = teamRoleId;
	}

	private long _teamId;
	private long _projectId;
	private long _teamRoleId;

}