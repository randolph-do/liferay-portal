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

package com.liferay.osb.distributed.messaging.subscribing.router.base;

import com.liferay.osb.distributed.messaging.Message;
import com.liferay.osb.distributed.messaging.subscribing.MessageSubscriber;
import com.liferay.osb.distributed.messaging.subscribing.router.MessageRouter;
import com.liferay.osgi.util.StringPlus;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Amos Fong
 */
public abstract class BaseMessageRouter implements MessageRouter {

	public void route(Message message) {
		List<MessageSubscriber> messageSubscribers = _messageSubscriberMap.get(
			message.getTopic());

		route(messageSubscribers, message);

		List<MessageSubscriber> globalMessageSubscribers =
			_messageSubscriberMap.get(StringPool.STAR);

		route(globalMessageSubscribers, message);

		if (_log.isDebugEnabled() && ListUtil.isEmpty(messageSubscribers) &&
			ListUtil.isEmpty(globalMessageSubscribers)) {

			_log.debug(
				"No subscribers were found for topic " + message.getTopic());
		}
	}

	protected void addRoute(
			MessageSubscriber messageSubscriber, Map<String, Object> properties)
		throws Exception {

		List<String> topics = StringPlus.asList(properties.get("topic"));

		if (topics.isEmpty()) {
			throw new Exception("Topic is empty");
		}

		for (String topic : topics) {
			List<MessageSubscriber> messageSubscribers =
				_messageSubscriberMap.get(topic);

			if (messageSubscribers == null) {
				messageSubscribers = new ArrayList<>();

				_messageSubscriberMap.put(topic, messageSubscribers);
			}

			messageSubscribers.add(messageSubscriber);
		}
	}

	protected void route(
		List<MessageSubscriber> messageSubscribers, Message message) {

		if (messageSubscribers == null) {
			return;
		}

		for (MessageSubscriber messageSubscriber : messageSubscribers) {
			if (_log.isDebugEnabled()) {
				Class<?> messageSubscriberClass = messageSubscriber.getClass();

				_log.debug(
					"Routing message to " + messageSubscriberClass.getName());
			}

			messageSubscriber.receive(message);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseMessageRouter.class);

	private final Map<String, List<MessageSubscriber>> _messageSubscriberMap =
		new ConcurrentHashMap<>();

}