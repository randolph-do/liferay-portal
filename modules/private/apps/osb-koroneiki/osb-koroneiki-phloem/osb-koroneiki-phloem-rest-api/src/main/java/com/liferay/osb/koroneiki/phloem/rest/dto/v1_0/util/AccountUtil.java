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

package com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.util;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Account;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ExternalLink;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.PostalAddress;
import com.liferay.portal.vulcan.util.TransformUtil;

import java.util.Locale;

/**
 * @author Amos Fong
 */
public class AccountUtil {

	public static Account toAccount(
			com.liferay.osb.koroneiki.taproot.model.Account account,
			Locale locale)
		throws Exception {

		return new Account() {
			{
				addresses = TransformUtil.transformToArray(
					account.getAddresses(),
					address -> PostalAddressUtil.toPostalAddress(
						address, locale),
					PostalAddress.class);
				contactEmailAddress = account.getContactEmailAddress();
				dateCreated = account.getCreateDate();
				dateModified = account.getModifiedDate();
				description = account.getDescription();
				externalLinks = TransformUtil.transformToArray(
					account.getExternalLinks(),
					ExternalLinkUtil::toExternalLink, ExternalLink.class);
				faxNumber = account.getFaxNumber();
				key = account.getAccountKey();
				name = account.getName();
				phoneNumber = account.getPhoneNumber();
				profileEmailAddress = account.getProfileEmailAddress();
				status = Status.create(account.getStatusLabel());
				website = account.getWebsite();
			}
		};
	}

}