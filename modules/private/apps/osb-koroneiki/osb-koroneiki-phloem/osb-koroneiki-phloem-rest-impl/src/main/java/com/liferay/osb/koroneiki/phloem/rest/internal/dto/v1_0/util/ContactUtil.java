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

package com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Contact;

/**
 * @author Amos Fong
 */
public class ContactUtil {

	public static Contact toContact(
			com.liferay.osb.koroneiki.taproot.model.Contact contact)
		throws Exception {

		return new Contact() {
			{
				dateCreated = contact.getCreateDate();
				dateModified = contact.getModifiedDate();
				emailAddress = contact.getEmailAddress();
				firstName = contact.getFirstName();
				id = contact.getContactId();
				languageId = contact.getLanguageId();
				lastName = contact.getLastName();
			}
		};
	}

}