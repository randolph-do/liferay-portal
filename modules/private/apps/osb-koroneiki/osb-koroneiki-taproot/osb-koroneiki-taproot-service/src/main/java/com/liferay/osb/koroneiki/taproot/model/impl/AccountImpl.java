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

import com.liferay.osb.koroneiki.root.model.ExternalLink;
import com.liferay.osb.koroneiki.root.service.ExternalLinkLocalServiceUtil;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.service.ProjectLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * @author Kyle Bischof
 */
@ProviderType
public class AccountImpl extends AccountBaseImpl {

	public AccountImpl() {
	}

	public List<ExternalLink> getExternalLinks() {
		return ExternalLinkLocalServiceUtil.getExternalLinks(
			Account.class.getName(), getAccountId(), QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<Project> getProjects() throws PortalException {
		return ProjectLocalServiceUtil.getProjects(
			getAccountId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

}