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

package com.liferay.osb.distributed.messaging.rabbitmq.connector;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Amos Fong
 */
public class BaseConnection implements Connection {

	@Override
	public void connect() {
		ConnectionFactory connectionFactory = new ConnectionFactory();

		connectionFactory.setAutomaticRecoveryEnabled(true);
		connectionFactory.setHost(_host);
		connectionFactory.setPassword(_password);
		connectionFactory.setPort(_port);
		connectionFactory.setUsername(_username);

		try {
			if (_log.isInfoEnabled()) {
				_log.info("Connecting to RabbitMQ at " + _host + ":" + _port);
			}

			_connection = connectionFactory.newConnection();

			if (_log.isInfoEnabled()) {
				_log.info("Connection successful");
			}
		}
		catch (Exception e) {
			_log.error(e, e);

			disconnect();
		}
	}

	@Override
	public Channel createChannel() throws IOException {
		return createChannel(0);
	}

	@Override
	public Channel createChannel(int prefetchCount) throws IOException {
		if (!isConnected()) {
			connect();
		}

		Channel channel = _connection.createChannel();

		if (prefetchCount > 0) {
			channel.basicQos(prefetchCount);
		}

		return channel;
	}

	@Deactivate
	@Override
	public void disconnect() {
		try {
			if (_connection != null) {
				_connection.close();
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		if (_log.isInfoEnabled()) {
			_log.info("Disconnected from RabbitMQ");
		}
	}

	@Activate
	protected void activate(Map<String, Object> properties) {
		_host = GetterUtil.getString(properties.get("host"));
		_password = GetterUtil.getString(properties.get("password"));
		_port = GetterUtil.getInteger(properties.get("port"));
		_username = GetterUtil.getString(properties.get("username"));

		connect();
	}

	protected boolean isConnected() {
		if (_connection == null) {
			return false;
		}

		if (!_connection.isOpen()) {
			_log.error(
				"Connection is unexpectedly closed",
				_connection.getCloseReason());

			return false;
		}

		return true;
	}

	private static final Log _log = LogFactoryUtil.getLog(BaseConnection.class);

	private com.rabbitmq.client.Connection _connection;
	private String _host;
	private String _password;
	private int _port;
	private String _username;

}