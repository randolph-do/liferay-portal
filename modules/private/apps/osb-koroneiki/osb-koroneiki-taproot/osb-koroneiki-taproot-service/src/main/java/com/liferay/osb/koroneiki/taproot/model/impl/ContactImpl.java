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
import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.security.auth.FullNameGenerator;
import com.liferay.portal.kernel.security.auth.FullNameGeneratorFactory;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.List;
import java.util.Locale;

/**
 * @author Kyle Bischof
 */
@ProviderType
public class ContactImpl extends ContactBaseImpl {

	public ContactImpl() {
	}

	public List<ExternalLink> getExternalLinks() {
		return ExternalLinkLocalServiceUtil.getExternalLinks(
			Contact.class.getName(), getContactId(), QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public String getFullName() {
		FullNameGenerator fullNameGenerator =
			FullNameGeneratorFactory.getInstance();

		Locale locale = LocaleUtil.fromLanguageId(getLanguageId());

		return fullNameGenerator.getLocalizedFullName(
			getFirstName(), getMiddleName(), getLastName(), locale, 0, 0);
	}

}