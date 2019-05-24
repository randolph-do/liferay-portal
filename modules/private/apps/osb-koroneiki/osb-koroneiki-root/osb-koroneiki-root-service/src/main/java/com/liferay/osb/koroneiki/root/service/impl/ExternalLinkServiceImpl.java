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
import com.liferay.osb.koroneiki.root.service.base.ExternalLinkServiceBaseImpl;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.permission.AccountPermission;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=ExternalLink"
	},
	service = AopService.class
)
public class ExternalLinkServiceImpl extends ExternalLinkServiceBaseImpl {

	public ExternalLink addExternalLink(
			long classNameId, long classPK, String domain, String entityName,
			String entityId)
		throws PortalException {

		checkPermission(classNameId, classPK, ActionKeys.UPDATE);

		return externalLinkLocalService.addExternalLink(
			getUserId(), classNameId, classPK, domain, entityName, entityId);
	}

	public ExternalLink deleteExternalLink(long externalLinkId)
		throws PortalException {

		ExternalLink externalLink = externalLinkLocalService.getExternalLink(
			externalLinkId);

		checkPermission(
			externalLink.getClassNameId(), externalLink.getClassPK(),
			ActionKeys.UPDATE);

		return externalLinkLocalService.deleteExternalLink(externalLinkId);
	}

	public ExternalLink getExternalLink(long externalLinkId)
		throws PortalException {

		ExternalLink externalLink = externalLinkLocalService.getExternalLink(
			externalLinkId);

		checkPermission(
			externalLink.getClassNameId(), externalLink.getClassPK(),
			ActionKeys.VIEW);

		return externalLink;
	}

	public List<ExternalLink> getExternalLinks(
			long classNameId, long classPK, int start, int end)
		throws PortalException {

		checkPermission(classNameId, classPK, ActionKeys.VIEW);

		return externalLinkLocalService.getExternalLinks(
			classNameId, classPK, start, end);
	}

	public int getExternalLinksCount(long classNameId, long classPK)
		throws PortalException {

		checkPermission(classNameId, classPK, ActionKeys.VIEW);

		return externalLinkLocalService.getExternalLinksCount(
			classNameId, classPK);
	}

	public ExternalLink updateExternalLink(long externalLinkId, String entityId)
		throws PortalException {

		ExternalLink externalLink = externalLinkLocalService.getExternalLink(
			externalLinkId);

		checkPermission(
			externalLink.getClassNameId(), externalLink.getClassPK(),
			ActionKeys.UPDATE);

		return externalLinkLocalService.updateExternalLink(
			externalLinkId, entityId);
	}

	protected void checkPermission(
			long classNameId, long classPK, String action)
		throws PortalException {

		if (classNameId == classNameLocalService.getClassNameId(
				Account.class)) {

			_accountPermission.check(getPermissionChecker(), classPK, action);
		}
		else {
			throw new PrincipalException.MustHavePermission(
				getPermissionChecker(), String.valueOf(classNameId), classPK,
				action);
		}
	}

	@Reference
	private AccountPermission _accountPermission;

}