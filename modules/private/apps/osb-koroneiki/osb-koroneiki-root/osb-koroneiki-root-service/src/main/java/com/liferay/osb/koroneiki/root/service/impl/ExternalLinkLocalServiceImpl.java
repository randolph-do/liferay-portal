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

import com.liferay.osb.koroneiki.root.model.ExternalLink;
import com.liferay.osb.koroneiki.root.service.base.ExternalLinkLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.root.model.ExternalLink",
	service = AopService.class
)
public class ExternalLinkLocalServiceImpl
	extends ExternalLinkLocalServiceBaseImpl {

	public ExternalLink addExternalLink(
			long userId, long classNameId, long classPK, String domain,
			String entityName, String entityId)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		long externalLinkId = counterLocalService.increment();

		ExternalLink externalLink = externalLinkPersistence.create(
			externalLinkId);

		externalLink.setCompanyId(user.getUserId());
		externalLink.setClassNameId(classNameId);
		externalLink.setClassPK(classPK);
		externalLink.setDomain(domain);
		externalLink.setEntityName(entityName);
		externalLink.setEntityId(entityId);

		return externalLinkPersistence.update(externalLink);
	}

	public List<ExternalLink> getExternalLinks(long classNameId, long classPK) {
		return externalLinkPersistence.findByC_C(classNameId, classPK);
	}

	public ExternalLink updateExternalLink(long externalLinkId, String entityId)
		throws PortalException {

		ExternalLink externalLink = externalLinkPersistence.findByPrimaryKey(
			externalLinkId);

		externalLink.setEntityId(entityId);

		return externalLinkPersistence.update(externalLink);
	}

}