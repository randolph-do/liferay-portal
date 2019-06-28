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

package com.liferay.osb.distributed.messaging.publishing;

import com.liferay.osb.distributed.messaging.Message;
import com.liferay.osb.distributed.messaging.publishing.broker.MessageBroker;
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
public class BaseMessagePublisher implements MessagePublisher {

	public void publish(String topic, List<Message> messages) throws Exception {
		List<MessageBroker> messageBrokers = getMessageBrokers(topic);

		for (MessageBroker messageBroker : messageBrokers) {
			messageBroker.publish(topic, messages);
		}

		if (_log.isDebugEnabled() && messageBrokers.isEmpty()) {
			_log.debug("No brokers were found for topic " + topic);
		}
	}

	public void publish(String topic, Message message) throws Exception {
		List<MessageBroker> messageBrokers = getMessageBrokers(topic);

		for (MessageBroker messageBroker : messageBrokers) {
			messageBroker.publish(topic, message);
		}

		if (_log.isDebugEnabled() && messageBrokers.isEmpty()) {
			_log.debug("No brokers were found for topic " + topic);
		}
	}

	protected void addMessageBroker(
		MessageBroker messageBroker, Map<String, Object> properties) {

		List<String> publishingTopicPatterns = StringPlus.asList(
			properties.get("publishing.topic.pattern"));

		if (publishingTopicPatterns.isEmpty()) {
			_log.error("Publishing topic patterns are empty");
		}

		_messageBrokersMap.put(messageBroker, publishingTopicPatterns);

		_cachedMessageBrokersMap.clear();
	}

	protected List<MessageBroker> getMessageBrokers(String topic) {
		List<MessageBroker> messageBrokers = _cachedMessageBrokersMap.get(
			topic);

		if (messageBrokers != null) {
			return messageBrokers;
		}

		messageBrokers = new ArrayList<>();

		for (Map.Entry<MessageBroker, List<String>> entry :
				_messageBrokersMap.entrySet()) {

			for (String topicPattern : entry.getValue()) {
				if (topic.matches(topicPattern)) {
					messageBrokers.add(entry.getKey());

					break;
				}
			}
		}

		_cachedMessageBrokersMap.put(topic, messageBrokers);

		return messageBrokers;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseMessagePublisher.class);

	private final Map<String, List<MessageBroker>> _cachedMessageBrokersMap =
		new ConcurrentHashMap<>();
	private final Map<MessageBroker, List<String>> _messageBrokersMap =
		new ConcurrentHashMap<>();

}