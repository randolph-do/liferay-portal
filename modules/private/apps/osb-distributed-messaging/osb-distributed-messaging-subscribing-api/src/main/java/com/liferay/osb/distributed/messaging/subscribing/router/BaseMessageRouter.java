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

package com.liferay.osb.distributed.messaging.subscribing.router;

import com.liferay.osb.distributed.messaging.Message;
import com.liferay.osb.distributed.messaging.subscribing.MessageSubscriber;
import com.liferay.osgi.util.StringPlus;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Amos Fong
 */
public class BaseMessageRouter implements MessageRouter {

	public void route(String topic, Message message) {
		List<MessageSubscriber> messageSubscribers = getMessageSubscribers(
			topic);

		for (MessageSubscriber messageSubscriber : messageSubscribers) {
			if (_log.isDebugEnabled()) {
				Class<?> messageSubscriberClass = messageSubscriber.getClass();

				_log.debug(
					"Routing " + topic + " to " +
						messageSubscriberClass.getName());

				_log.debug("Message: " + message.toString());
			}

			messageSubscriber.receive(message);
		}

		if (_log.isDebugEnabled() && messageSubscribers.isEmpty()) {
			_log.debug("No subscribers were found for topic " + topic);
		}
	}

	protected void addRoute(
			MessageSubscriber messageSubscriber, Map<String, Object> properties)
		throws Exception {

		List<String> topicPatterns = StringPlus.asList(
			properties.get("topic.pattern"));

		if (topicPatterns.isEmpty()) {
			_log.error("Topic patterns are empty");
		}

		_messageSubscriberMap.put(messageSubscriber, topicPatterns);
	}

	protected List<MessageSubscriber> getMessageSubscribers(String topic) {
		List<MessageSubscriber> messageSubscribers =
			_cachedMessageSubscriberMap.get(topic);

		if (messageSubscribers != null) {
			return messageSubscribers;
		}

		messageSubscribers = new ArrayList<>();

		for (Map.Entry<MessageSubscriber, List<String>> entry :
				_messageSubscriberMap.entrySet()) {

			for (String topicPattern : entry.getValue()) {
				if (topic.matches(topicPattern)) {
					messageSubscribers.add(entry.getKey());

					break;
				}
			}
		}

		_cachedMessageSubscriberMap.put(topic, messageSubscribers);

		return messageSubscribers;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseMessageRouter.class);

	private final Map<String, List<MessageSubscriber>>
		_cachedMessageSubscriberMap = new ConcurrentHashMap<>();
	private final Map<MessageSubscriber, List<String>> _messageSubscriberMap =
		new ConcurrentHashMap<>();

}