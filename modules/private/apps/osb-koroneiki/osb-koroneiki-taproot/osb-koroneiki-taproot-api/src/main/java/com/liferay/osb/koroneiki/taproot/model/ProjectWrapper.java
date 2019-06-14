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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @generated
 */
@ProviderType
public class ProjectWrapper
	extends BaseModelWrapper<Project>
	implements Project, ModelWrapper<Project> {

	public ProjectWrapper(Project project) {
		super(project);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectId", getProjectId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("accountId", getAccountId());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("industry", getIndustry());
		attributes.put("tier", getTier());
		attributes.put("notes", getNotes());
		attributes.put("soldBy", getSoldBy());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("statusMessage", getStatusMessage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String industry = (String)attributes.get("industry");

		if (industry != null) {
			setIndustry(industry);
		}

		String tier = (String)attributes.get("tier");

		if (tier != null) {
			setTier(tier);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		String soldBy = (String)attributes.get("soldBy");

		if (soldBy != null) {
			setSoldBy(soldBy);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String statusMessage = (String)attributes.get("statusMessage");

		if (statusMessage != null) {
			setStatusMessage(statusMessage);
		}
	}

	@Override
	public Account getAccount()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getAccount();
	}

	/**
	 * Returns the account ID of this project.
	 *
	 * @return the account ID of this project
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the code of this project.
	 *
	 * @return the code of this project
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this project.
	 *
	 * @return the company ID of this project
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this project.
	 *
	 * @return the create date of this project
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public java.util.List<com.liferay.osb.koroneiki.root.model.ExternalLink>
		getExternalLinks() {

		return model.getExternalLinks();
	}

	/**
	 * Returns the industry of this project.
	 *
	 * @return the industry of this project
	 */
	@Override
	public String getIndustry() {
		return model.getIndustry();
	}

	/**
	 * Returns the modified date of this project.
	 *
	 * @return the modified date of this project
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this project.
	 *
	 * @return the name of this project
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the notes of this project.
	 *
	 * @return the notes of this project
	 */
	@Override
	public String getNotes() {
		return model.getNotes();
	}

	/**
	 * Returns the primary key of this project.
	 *
	 * @return the primary key of this project
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this project.
	 *
	 * @return the project ID of this project
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the sold by of this project.
	 *
	 * @return the sold by of this project
	 */
	@Override
	public String getSoldBy() {
		return model.getSoldBy();
	}

	/**
	 * Returns the status of this project.
	 *
	 * @return the status of this project
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this project.
	 *
	 * @return the status by user ID of this project
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this project.
	 *
	 * @return the status by user name of this project
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this project.
	 *
	 * @return the status by user uuid of this project
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this project.
	 *
	 * @return the status date of this project
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	@Override
	public String getStatusLabel() {
		return model.getStatusLabel();
	}

	/**
	 * Returns the status message of this project.
	 *
	 * @return the status message of this project
	 */
	@Override
	public String getStatusMessage() {
		return model.getStatusMessage();
	}

	/**
	 * Returns the tier of this project.
	 *
	 * @return the tier of this project
	 */
	@Override
	public String getTier() {
		return model.getTier();
	}

	/**
	 * Returns the user ID of this project.
	 *
	 * @return the user ID of this project
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this project.
	 *
	 * @return the user uuid of this project
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this project.
	 *
	 * @return the uuid of this project
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this project is approved.
	 *
	 * @return <code>true</code> if this project is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this project is denied.
	 *
	 * @return <code>true</code> if this project is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this project is a draft.
	 *
	 * @return <code>true</code> if this project is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this project is expired.
	 *
	 * @return <code>true</code> if this project is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this project is inactive.
	 *
	 * @return <code>true</code> if this project is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this project is incomplete.
	 *
	 * @return <code>true</code> if this project is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this project is pending.
	 *
	 * @return <code>true</code> if this project is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this project is scheduled.
	 *
	 * @return <code>true</code> if this project is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the account ID of this project.
	 *
	 * @param accountId the account ID of this project
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the code of this project.
	 *
	 * @param code the code of this project
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this project.
	 *
	 * @param companyId the company ID of this project
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this project.
	 *
	 * @param createDate the create date of this project
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the industry of this project.
	 *
	 * @param industry the industry of this project
	 */
	@Override
	public void setIndustry(String industry) {
		model.setIndustry(industry);
	}

	/**
	 * Sets the modified date of this project.
	 *
	 * @param modifiedDate the modified date of this project
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this project.
	 *
	 * @param name the name of this project
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the notes of this project.
	 *
	 * @param notes the notes of this project
	 */
	@Override
	public void setNotes(String notes) {
		model.setNotes(notes);
	}

	/**
	 * Sets the primary key of this project.
	 *
	 * @param primaryKey the primary key of this project
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this project.
	 *
	 * @param projectId the project ID of this project
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the sold by of this project.
	 *
	 * @param soldBy the sold by of this project
	 */
	@Override
	public void setSoldBy(String soldBy) {
		model.setSoldBy(soldBy);
	}

	/**
	 * Sets the status of this project.
	 *
	 * @param status the status of this project
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this project.
	 *
	 * @param statusByUserId the status by user ID of this project
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this project.
	 *
	 * @param statusByUserName the status by user name of this project
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this project.
	 *
	 * @param statusByUserUuid the status by user uuid of this project
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this project.
	 *
	 * @param statusDate the status date of this project
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the status message of this project.
	 *
	 * @param statusMessage the status message of this project
	 */
	@Override
	public void setStatusMessage(String statusMessage) {
		model.setStatusMessage(statusMessage);
	}

	/**
	 * Sets the tier of this project.
	 *
	 * @param tier the tier of this project
	 */
	@Override
	public void setTier(String tier) {
		model.setTier(tier);
	}

	/**
	 * Sets the user ID of this project.
	 *
	 * @param userId the user ID of this project
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this project.
	 *
	 * @param userUuid the user uuid of this project
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this project.
	 *
	 * @param uuid the uuid of this project
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ProjectWrapper wrap(Project project) {
		return new ProjectWrapper(project);
	}

}