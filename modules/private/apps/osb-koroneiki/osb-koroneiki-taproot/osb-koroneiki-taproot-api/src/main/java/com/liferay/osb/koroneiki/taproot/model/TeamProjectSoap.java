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

import com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.koroneiki.taproot.service.http.TeamProjectServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TeamProjectSoap implements Serializable {

	public static TeamProjectSoap toSoapModel(TeamProject model) {
		TeamProjectSoap soapModel = new TeamProjectSoap();

		soapModel.setTeamId(model.getTeamId());
		soapModel.setProjectId(model.getProjectId());

		return soapModel;
	}

	public static TeamProjectSoap[] toSoapModels(TeamProject[] models) {
		TeamProjectSoap[] soapModels = new TeamProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TeamProjectSoap[][] toSoapModels(TeamProject[][] models) {
		TeamProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TeamProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TeamProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TeamProjectSoap[] toSoapModels(List<TeamProject> models) {
		List<TeamProjectSoap> soapModels = new ArrayList<TeamProjectSoap>(
			models.size());

		for (TeamProject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TeamProjectSoap[soapModels.size()]);
	}

	public TeamProjectSoap() {
	}

	public TeamProjectPK getPrimaryKey() {
		return new TeamProjectPK(_teamId, _projectId);
	}

	public void setPrimaryKey(TeamProjectPK pk) {
		setTeamId(pk.teamId);
		setProjectId(pk.projectId);
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

	private long _teamId;
	private long _projectId;

}