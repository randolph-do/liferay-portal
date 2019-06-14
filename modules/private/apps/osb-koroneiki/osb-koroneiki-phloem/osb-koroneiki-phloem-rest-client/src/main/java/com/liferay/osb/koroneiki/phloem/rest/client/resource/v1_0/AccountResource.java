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

package com.liferay.osb.koroneiki.phloem.rest.client.resource.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.Account;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public interface AccountResource {

	public static Builder builder() {
		return new Builder();
	}

	public Account postAccount(Account account) throws Exception;

	public HttpInvoker.HttpResponse postAccountHttpResponse(Account account)
		throws Exception;

	public void deleteAccount(Long accountId) throws Exception;

	public HttpInvoker.HttpResponse deleteAccountHttpResponse(Long accountId)
		throws Exception;

	public Account getAccount(Long accountId) throws Exception;

	public HttpInvoker.HttpResponse getAccountHttpResponse(Long accountId)
		throws Exception;

	public Account putAccount(Long accountId, Account account) throws Exception;

	public HttpInvoker.HttpResponse putAccountHttpResponse(
			Long accountId, Account account)
		throws Exception;

	public void deleteAccountContact(Long accountId, Long[] contactIds)
		throws Exception;

	public HttpInvoker.HttpResponse deleteAccountContactHttpResponse(
			Long accountId, Long[] contactIds)
		throws Exception;

	public void putAccountContact(Long accountId, Long[] contactIds)
		throws Exception;

	public HttpInvoker.HttpResponse putAccountContactHttpResponse(
			Long accountId, Long[] contactIds)
		throws Exception;

	public void deleteAccountContactRole(
			Long accountId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public HttpInvoker.HttpResponse deleteAccountContactRoleHttpResponse(
			Long accountId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public void putAccountContactRole(
			Long accountId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public HttpInvoker.HttpResponse putAccountContactRoleHttpResponse(
			Long accountId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public AccountResource build() {
			return new AccountResourceImpl(this);
		}

		public Builder endpoint(String host, int port, String scheme) {
			_host = host;
			_port = port;
			_scheme = scheme;

			return this;
		}

		public Builder locale(Locale locale) {
			_locale = locale;

			return this;
		}

		private Builder() {
		}

		private String _host = "localhost";
		private Locale _locale;
		private String _login = "test@liferay.com";
		private String _password = "test";
		private int _port = 8080;
		private String _scheme = "http";

	}

	public static class AccountResourceImpl implements AccountResource {

		public Account postAccount(Account account) throws Exception {
			HttpInvoker.HttpResponse httpResponse = postAccountHttpResponse(
				account);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.
					AccountSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse postAccountHttpResponse(Account account)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(account.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port + "/o/koroneiki-rest/v1.0/accounts");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteAccount(Long accountId) throws Exception {
			HttpInvoker.HttpResponse httpResponse = deleteAccountHttpResponse(
				accountId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse deleteAccountHttpResponse(
				Long accountId)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Account getAccount(Long accountId) throws Exception {
			HttpInvoker.HttpResponse httpResponse = getAccountHttpResponse(
				accountId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.
					AccountSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse getAccountHttpResponse(Long accountId)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Account putAccount(Long accountId, Account account)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse = putAccountHttpResponse(
				accountId, account);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.
					AccountSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse putAccountHttpResponse(
				Long accountId, Account account)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(account.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteAccountContact(Long accountId, Long[] contactIds)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				deleteAccountContactHttpResponse(accountId, contactIds);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse deleteAccountContactHttpResponse(
				Long accountId, Long[] contactIds)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

			if (contactIds != null) {
				for (int i = 0; i < contactIds.length; i++) {
					httpInvoker.parameter(
						"contactIds", String.valueOf(contactIds[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/contacts",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void putAccountContact(Long accountId, Long[] contactIds)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				putAccountContactHttpResponse(accountId, contactIds);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse putAccountContactHttpResponse(
				Long accountId, Long[] contactIds)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(contactIds.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

			if (contactIds != null) {
				for (int i = 0; i < contactIds.length; i++) {
					httpInvoker.parameter(
						"contactIds", String.valueOf(contactIds[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/contacts",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteAccountContactRole(
				Long accountId, Long contactId, Long[] contactRoleIds)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				deleteAccountContactRoleHttpResponse(
					accountId, contactId, contactRoleIds);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse deleteAccountContactRoleHttpResponse(
				Long accountId, Long contactId, Long[] contactRoleIds)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

			if (contactRoleIds != null) {
				for (int i = 0; i < contactRoleIds.length; i++) {
					httpInvoker.parameter(
						"contactRoleIds", String.valueOf(contactRoleIds[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/contacts/{contactId}/roles",
				accountId, contactId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void putAccountContactRole(
				Long accountId, Long contactId, Long[] contactRoleIds)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				putAccountContactRoleHttpResponse(
					accountId, contactId, contactRoleIds);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse putAccountContactRoleHttpResponse(
				Long accountId, Long contactId, Long[] contactRoleIds)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(contactRoleIds.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

			if (contactRoleIds != null) {
				for (int i = 0; i < contactRoleIds.length; i++) {
					httpInvoker.parameter(
						"contactRoleIds", String.valueOf(contactRoleIds[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/contacts/{contactId}/roles",
				accountId, contactId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private AccountResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			AccountResource.class.getName());

		private Builder _builder;

	}

}