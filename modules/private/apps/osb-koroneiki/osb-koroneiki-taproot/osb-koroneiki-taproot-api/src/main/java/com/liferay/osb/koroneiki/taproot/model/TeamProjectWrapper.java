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
 * This class is a wrapper for {@link TeamProject}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamProject
 * @generated
 */
@ProviderType
public class TeamProjectWrapper
	extends BaseModelWrapper<TeamProject>
	implements TeamProject, ModelWrapper<TeamProject> {

	public TeamProjectWrapper(TeamProject teamProject) {
		super(teamProject);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("teamId", getTeamId());
		attributes.put("projectId", getProjectId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long teamId = (Long)attributes.get("teamId");

		if (teamId != null) {
			setTeamId(teamId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}
	}

	/**
	 * Returns the primary key of this team project.
	 *
	 * @return the primary key of this team project
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this team project.
	 *
	 * @return the project ID of this team project
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the team ID of this team project.
	 *
	 * @return the team ID of this team project
	 */
	@Override
	public long getTeamId() {
		return model.getTeamId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this team project.
	 *
	 * @param primaryKey the primary key of this team project
	 */
	@Override
	public void setPrimaryKey(
		com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this team project.
	 *
	 * @param projectId the project ID of this team project
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the team ID of this team project.
	 *
	 * @param teamId the team ID of this team project
	 */
	@Override
	public void setTeamId(long teamId) {
		model.setTeamId(teamId);
	}

	@Override
	protected TeamProjectWrapper wrap(TeamProject teamProject) {
		return new TeamProjectWrapper(teamProject);
	}

}