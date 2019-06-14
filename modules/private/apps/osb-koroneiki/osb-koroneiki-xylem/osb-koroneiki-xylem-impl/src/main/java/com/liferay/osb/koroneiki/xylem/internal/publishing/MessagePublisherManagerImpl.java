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

package com.liferay.osb.koroneiki.xylem.internal.publishing;

import com.liferay.osb.koroneiki.xylem.publishing.Message;
import com.liferay.osb.koroneiki.xylem.publishing.MessagePublisher;
import com.liferay.osb.koroneiki.xylem.publishing.MessagePublisherManager;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerList;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerListFactory;

import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Amos Fong
 */
@Component(immediate = true, service = MessagePublisherManager.class)
public class MessagePublisherManagerImpl implements MessagePublisherManager {

	public void publish(List<Message> messages) throws Exception {
		for (MessagePublisher messagePublisher : _messagePublishers) {
			messagePublisher.publish(messages);
		}
	}

	public void publish(Message message) throws Exception {
		for (MessagePublisher messagePublisher : _messagePublishers) {
			messagePublisher.publish(message);
		}
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_messagePublishers = ServiceTrackerListFactory.open(
			bundleContext, MessagePublisher.class);
	}

	@Deactivate
	protected void deactivate() {
		_messagePublishers.close();
	}

	private static ServiceTrackerList<MessagePublisher, MessagePublisher>
		_messagePublishers;

}