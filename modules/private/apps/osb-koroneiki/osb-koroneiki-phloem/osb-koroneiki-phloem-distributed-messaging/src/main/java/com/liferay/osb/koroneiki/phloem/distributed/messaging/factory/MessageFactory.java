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

package com.liferay.osb.koroneiki.phloem.distributed.messaging.factory;

import com.liferay.osb.distributed.messaging.Message;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.util.AccountUtil;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.util.ContactRoleUtil;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.util.ContactUtil;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.osb.koroneiki.taproot.model.ContactAccountRole;
import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(immediate = true, service = MessageFactory.class)
public class MessageFactory {

	public Message create(Account account) throws Exception {
		com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Account dtoAccount =
			AccountUtil.toAccount(account, LocaleUtil.US);

		return new Message(dtoAccount.toString());
	}

	public Message create(Account account, Contact contact) throws Exception {
		JSONObject jsonObject = JSONUtil.put(
			"account", toJSONObject(account)
		).put(
			"contact", toJSONObject(contact)
		);

		return new Message(jsonObject.toString());
	}

	public Message create(ContactAccountRole contactAccountRole)
		throws Exception {

		JSONObject jsonObject = JSONUtil.put(
			"account", toJSONObject(contactAccountRole.getAccount())
		).put(
			"contact", toJSONObject(contactAccountRole.getContact())
		).put(
			"contactRole", toJSONObject(contactAccountRole.getContactRole())
		);

		return new Message(jsonObject.toString());
	}

	protected JSONObject toJSONObject(Account account) throws Exception {
		com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Account dtoAccount =
			AccountUtil.toAccount(account, LocaleUtil.US);

		return _jsonFactory.createJSONObject(dtoAccount.toString());
	}

	protected JSONObject toJSONObject(Contact contact) throws Exception {
		com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Contact dtoContact =
			ContactUtil.toContact(contact);

		return _jsonFactory.createJSONObject(dtoContact.toString());
	}

	protected JSONObject toJSONObject(ContactRole contactRole)
		throws Exception {

		com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ContactRole
			dtoContactRole = ContactRoleUtil.toContactRole(contactRole);

		return _jsonFactory.createJSONObject(dtoContactRole.toString());
	}

	@Reference
	private JSONFactory _jsonFactory;

}