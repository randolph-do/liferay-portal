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

package com.liferay.osb.koroneiki.root.service.impl;

import com.liferay.osb.koroneiki.root.model.ExternalIdMapper;
import com.liferay.osb.koroneiki.root.service.base.ExternalIdMapperLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.root.model.ExternalIdMapper",
	service = AopService.class
)
public class ExternalIdMapperLocalServiceImpl
	extends ExternalIdMapperLocalServiceBaseImpl {

	public ExternalIdMapper addExternalIdMapper(
			long userId, long classNameId, long classPK, int externalSource,
			String externalId)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		long externalIdMapperId = counterLocalService.increment();

		ExternalIdMapper externalIdMapper = externalIdMapperPersistence.create(
			externalIdMapperId);

		externalIdMapper.setCompanyId(user.getUserId());
		externalIdMapper.setClassNameId(classNameId);
		externalIdMapper.setClassPK(classPK);
		externalIdMapper.setExternalSource(externalSource);
		externalIdMapper.setExternalId(externalId);

		return externalIdMapperPersistence.update(externalIdMapper);
	}

	public ExternalIdMapper updateExternalIdMapper(
			long externalIdMapperId, String externalId)
		throws PortalException {

		ExternalIdMapper externalIdMapper =
			externalIdMapperPersistence.findByPrimaryKey(externalIdMapperId);

		externalIdMapper.setExternalId(externalId);

		return externalIdMapperPersistence.update(externalIdMapper);
	}

}