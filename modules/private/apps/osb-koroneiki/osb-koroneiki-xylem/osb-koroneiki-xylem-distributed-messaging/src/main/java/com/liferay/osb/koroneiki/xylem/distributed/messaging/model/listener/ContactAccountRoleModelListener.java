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

package com.liferay.osb.koroneiki.xylem.distributed.messaging.model.listener;

import com.liferay.osb.distributed.messaging.publishing.MessagePublisher;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.osb.koroneiki.taproot.model.ContactAccountRole;
import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.osb.koroneiki.xylem.distributed.messaging.factory.MessageFactory;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(immediate = true, service = ModelListener.class)
public class ContactAccountRoleModelListener
	extends BaseModelListener<ContactAccountRole> {

	@Override
	public void onAfterCreate(ContactAccountRole contactAccountRole)
		throws ModelListenerException {

		try {
			ContactRole contactRole = contactAccountRole.getContactRole();

			if (contactRole.isMember()) {
				publish(
					"koroneiki.account.assigned.contact",
					contactAccountRole.getAccount(),
					contactAccountRole.getContact());
			}
			else {
				publish(
					"koroneiki.account.assigned.contactrole",
					contactAccountRole);
			}
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new ModelListenerException(e);
		}
	}

	@Override
	public void onAfterRemove(ContactAccountRole contactAccountRole)
		throws ModelListenerException {

		try {
			ContactRole contactRole = contactAccountRole.getContactRole();

			if (contactRole.isMember()) {
				publish(
					"koroneiki.account.unassigned.contact",
					contactAccountRole.getAccount(),
					contactAccountRole.getContact());
			}
			else {
				publish(
					"koroneiki.account.unassigned.contactrole",
					contactAccountRole);
			}
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new ModelListenerException(e);
		}
	}

	protected void publish(String topic, Account account, Contact contact)
		throws Exception {

		_messagePublisher.publish(
			topic, _messageFactory.create(account, contact));
	}

	protected void publish(String topic, ContactAccountRole contactAccountRole)
		throws Exception {

		_messagePublisher.publish(
			topic, _messageFactory.create(contactAccountRole));
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ContactAccountRoleModelListener.class);

	@Reference
	private MessageFactory _messageFactory;

	@Reference
	private MessagePublisher _messagePublisher;

}