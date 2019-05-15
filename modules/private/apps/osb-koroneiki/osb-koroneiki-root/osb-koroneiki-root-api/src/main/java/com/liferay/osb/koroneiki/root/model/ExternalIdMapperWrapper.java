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

package com.liferay.osb.koroneiki.root.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ExternalIdMapper}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExternalIdMapper
 * @generated
 */
@ProviderType
public class ExternalIdMapperWrapper
	extends BaseModelWrapper<ExternalIdMapper>
	implements ExternalIdMapper, ModelWrapper<ExternalIdMapper> {

	public ExternalIdMapperWrapper(ExternalIdMapper externalIdMapper) {
		super(externalIdMapper);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("externalIdMapperId", getExternalIdMapperId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("externalSource", getExternalSource());
		attributes.put("externalId", getExternalId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long externalIdMapperId = (Long)attributes.get("externalIdMapperId");

		if (externalIdMapperId != null) {
			setExternalIdMapperId(externalIdMapperId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Integer externalSource = (Integer)attributes.get("externalSource");

		if (externalSource != null) {
			setExternalSource(externalSource);
		}

		String externalId = (String)attributes.get("externalId");

		if (externalId != null) {
			setExternalId(externalId);
		}
	}

	/**
	 * Returns the fully qualified class name of this external ID mapper.
	 *
	 * @return the fully qualified class name of this external ID mapper
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class name ID of this external ID mapper.
	 *
	 * @return the class name ID of this external ID mapper
	 */
	@Override
	public long getClassNameId() {
		return model.getClassNameId();
	}

	/**
	 * Returns the class pk of this external ID mapper.
	 *
	 * @return the class pk of this external ID mapper
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the company ID of this external ID mapper.
	 *
	 * @return the company ID of this external ID mapper
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this external ID mapper.
	 *
	 * @return the create date of this external ID mapper
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external ID of this external ID mapper.
	 *
	 * @return the external ID of this external ID mapper
	 */
	@Override
	public String getExternalId() {
		return model.getExternalId();
	}

	/**
	 * Returns the external ID mapper ID of this external ID mapper.
	 *
	 * @return the external ID mapper ID of this external ID mapper
	 */
	@Override
	public long getExternalIdMapperId() {
		return model.getExternalIdMapperId();
	}

	/**
	 * Returns the external source of this external ID mapper.
	 *
	 * @return the external source of this external ID mapper
	 */
	@Override
	public int getExternalSource() {
		return model.getExternalSource();
	}

	/**
	 * Returns the modified date of this external ID mapper.
	 *
	 * @return the modified date of this external ID mapper
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this external ID mapper.
	 *
	 * @return the primary key of this external ID mapper
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class name ID of this external ID mapper.
	 *
	 * @param classNameId the class name ID of this external ID mapper
	 */
	@Override
	public void setClassNameId(long classNameId) {
		model.setClassNameId(classNameId);
	}

	/**
	 * Sets the class pk of this external ID mapper.
	 *
	 * @param classPK the class pk of this external ID mapper
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the company ID of this external ID mapper.
	 *
	 * @param companyId the company ID of this external ID mapper
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this external ID mapper.
	 *
	 * @param createDate the create date of this external ID mapper
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external ID of this external ID mapper.
	 *
	 * @param externalId the external ID of this external ID mapper
	 */
	@Override
	public void setExternalId(String externalId) {
		model.setExternalId(externalId);
	}

	/**
	 * Sets the external ID mapper ID of this external ID mapper.
	 *
	 * @param externalIdMapperId the external ID mapper ID of this external ID mapper
	 */
	@Override
	public void setExternalIdMapperId(long externalIdMapperId) {
		model.setExternalIdMapperId(externalIdMapperId);
	}

	/**
	 * Sets the external source of this external ID mapper.
	 *
	 * @param externalSource the external source of this external ID mapper
	 */
	@Override
	public void setExternalSource(int externalSource) {
		model.setExternalSource(externalSource);
	}

	/**
	 * Sets the modified date of this external ID mapper.
	 *
	 * @param modifiedDate the modified date of this external ID mapper
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this external ID mapper.
	 *
	 * @param primaryKey the primary key of this external ID mapper
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ExternalIdMapperWrapper wrap(ExternalIdMapper externalIdMapper) {
		return new ExternalIdMapperWrapper(externalIdMapper);
	}

}