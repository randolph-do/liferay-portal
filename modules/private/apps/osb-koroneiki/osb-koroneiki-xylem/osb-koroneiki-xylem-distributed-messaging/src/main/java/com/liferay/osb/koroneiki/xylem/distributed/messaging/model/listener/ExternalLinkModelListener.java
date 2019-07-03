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
import com.liferay.osb.koroneiki.root.model.ExternalLink;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.service.AccountLocalService;
import com.liferay.osb.koroneiki.xylem.distributed.messaging.factory.MessageFactory;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ClassNameLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(immediate = true, service = ModelListener.class)
public class ExternalLinkModelListener extends BaseModelListener<ExternalLink> {

	@Override
	public void onAfterCreate(ExternalLink externalLink)
		throws ModelListenerException {

		publish(externalLink);
	}

	@Override
	public void onAfterRemove(ExternalLink externalLink)
		throws ModelListenerException {

		publish(externalLink);
	}

	@Override
	public void onAfterUpdate(ExternalLink externalLink)
		throws ModelListenerException {

		publish(externalLink);
	}

	protected void publish(ExternalLink externalLink)
		throws ModelListenerException {

		try {
			if (externalLink.getClassNameId() ==
					_classNameLocalService.getClassNameId(Account.class)) {

				Account account = _accountLocalService.getAccount(
					externalLink.getClassPK());

				_messagePublisher.publish(
					"koroneiki.account.update",
					_messageFactory.create(account));
			}
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new ModelListenerException(e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ExternalLinkModelListener.class);

	@Reference
	private AccountLocalService _accountLocalService;

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private MessageFactory _messageFactory;

	@Reference
	private MessagePublisher _messagePublisher;

}