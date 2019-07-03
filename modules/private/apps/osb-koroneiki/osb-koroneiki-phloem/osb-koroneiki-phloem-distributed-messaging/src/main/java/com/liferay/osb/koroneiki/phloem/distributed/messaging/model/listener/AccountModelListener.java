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

package com.liferay.osb.koroneiki.phloem.distributed.messaging.model.listener;

import com.liferay.osb.distributed.messaging.publishing.MessagePublisher;
import com.liferay.osb.koroneiki.phloem.distributed.messaging.factory.MessageFactory;
import com.liferay.osb.koroneiki.taproot.model.Account;
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
public class AccountModelListener extends BaseModelListener<Account> {

	@Override
	public void onAfterCreate(Account account) throws ModelListenerException {
		publish("koroneiki.account.create", account);
	}

	@Override
	public void onAfterRemove(Account account) throws ModelListenerException {
		publish("koroneiki.account.delete", account);
	}

	@Override
	public void onAfterUpdate(Account account) throws ModelListenerException {
		publish("koroneiki.account.update", account);
	}

	protected void publish(String topic, Account account)
		throws ModelListenerException {

		try {
			_messagePublisher.publish(topic, _messageFactory.create(account));
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new ModelListenerException(e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AccountModelListener.class);

	@Reference
	private MessageFactory _messageFactory;

	@Reference
	private MessagePublisher _messagePublisher;

}