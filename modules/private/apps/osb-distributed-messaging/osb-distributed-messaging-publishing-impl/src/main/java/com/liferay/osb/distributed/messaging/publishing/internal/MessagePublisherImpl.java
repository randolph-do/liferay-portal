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

package com.liferay.osb.distributed.messaging.publishing.internal;

import com.liferay.osb.distributed.messaging.Message;
import com.liferay.osb.distributed.messaging.publishing.MessagePublisher;
import com.liferay.osb.distributed.messaging.publishing.broker.MessageBroker;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerList;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerListFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Amos Fong
 */
@Component(immediate = true, service = MessagePublisher.class)
public class MessagePublisherImpl implements MessagePublisher {

	public void publish(List<Message> messages) throws Exception {
		if (_messageBrokers.size() == 0) {
			if (_log.isWarnEnabled()) {
				_log.warn("No message brokers are configured");
			}
		}

		for (MessageBroker messageBroker : _messageBrokers) {
			messageBroker.publish(messages);
		}
	}

	public void publish(Message message) throws Exception {
		if (_messageBrokers.size() == 0) {
			if (_log.isWarnEnabled()) {
				_log.warn("No message brokers are configured");
			}
		}

		for (MessageBroker messageBroker : _messageBrokers) {
			messageBroker.publish(message);
		}
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_messageBrokers = ServiceTrackerListFactory.open(
			bundleContext, MessageBroker.class);
	}

	@Deactivate
	protected void deactivate() {
		_messageBrokers.close();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		MessagePublisherImpl.class);

	private static ServiceTrackerList<MessageBroker, MessageBroker>
		_messageBrokers;

}