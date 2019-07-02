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

package com.liferay.osb.distributed.messaging.rabbitmq.connector.broker;

import com.liferay.osb.distributed.messaging.Message;
import com.liferay.osb.distributed.messaging.publishing.broker.MessageBroker;
import com.liferay.osb.distributed.messaging.rabbitmq.connector.Connection;
import com.liferay.osb.distributed.messaging.rabbitmq.connector.message.AttributeTranslator;
import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;

import com.rabbitmq.client.Channel;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Amos Fong
 */
public abstract class BaseMessageBroker implements MessageBroker {

	@Override
	public void publish(String topic, List<Message> messages)
		throws IOException {

		Channel channel = getChannel();

		for (Message message : messages) {
			String payload = String.valueOf(message.getPayload());

			channel.basicPublish(
				_exchange, topic,
				AttributeTranslator.toProperties(message.getAttributes()),
				payload.getBytes());
		}
	}

	@Override
	public void publish(String topic, Message message) throws IOException {
		Channel channel = getChannel();

		String payload = String.valueOf(message.getPayload());

		channel.basicPublish(
			_exchange, topic,
			AttributeTranslator.toProperties(message.getAttributes()),
			payload.getBytes());
	}

	@Activate
	protected void activate(Map<String, Object> properties) {
		_exchange = GetterUtil.getString(properties.get("exchange"));
	}

	@Deactivate
	protected void deactivate() {
		_channelThreadLocal.remove();
	}

	protected Channel getChannel() throws IOException {
		Channel channel = _channelThreadLocal.get();

		if ((channel == null) || !channel.isOpen()) {
			Connection connection = getConnection();

			channel = connection.createChannel();

			_channelThreadLocal.set(channel);
		}

		return channel;
	}

	protected abstract Connection getConnection();

	private static final ThreadLocal<Channel> _channelThreadLocal =
		new CentralizedThreadLocal<>(false);

	private String _exchange;

}