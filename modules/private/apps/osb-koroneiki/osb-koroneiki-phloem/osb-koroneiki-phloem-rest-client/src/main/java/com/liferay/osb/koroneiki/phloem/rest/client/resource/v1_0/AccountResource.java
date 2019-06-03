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

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public class AccountResource {

	public static Account postAccount(Account account) throws Exception {
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
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse postAccountHttpResponse(
			Account account)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(account.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts");

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteAccount(Long accountId) throws Exception {
		HttpInvoker.HttpResponse httpResponse = deleteAccountHttpResponse(
			accountId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse deleteAccountHttpResponse(
			Long accountId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}",
			accountId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Account getAccount(Long accountId) throws Exception {
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
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse getAccountHttpResponse(
			Long accountId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}",
			accountId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Account putAccount(Long accountId, Account account)
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
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse putAccountHttpResponse(
			Long accountId, Account account)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(account.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}",
			accountId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteAccountContact(Long accountId, Long[] contactIds)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			deleteAccountContactHttpResponse(accountId, contactIds);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse deleteAccountContactHttpResponse(
			Long accountId, Long[] contactIds)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		if (contactIds != null) {
			for (int i = 0; i < contactIds.length; i++) {
				httpInvoker.parameter(
					"contactIds", String.valueOf(contactIds[i]));
			}
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}/contacts",
			accountId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void putAccountContact(Long accountId, Long[] contactIds)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = putAccountContactHttpResponse(
			accountId, contactIds);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse putAccountContactHttpResponse(
			Long accountId, Long[] contactIds)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(contactIds.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		if (contactIds != null) {
			for (int i = 0; i < contactIds.length; i++) {
				httpInvoker.parameter(
					"contactIds", String.valueOf(contactIds[i]));
			}
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}/contacts",
			accountId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteAccountContactRole(
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

	public static HttpInvoker.HttpResponse deleteAccountContactRoleHttpResponse(
			Long accountId, Long contactId, Long[] contactRoleIds)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		if (contactRoleIds != null) {
			for (int i = 0; i < contactRoleIds.length; i++) {
				httpInvoker.parameter(
					"contactRoleIds", String.valueOf(contactRoleIds[i]));
			}
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}/contacts/{contactId}/roles",
			accountId, contactId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void putAccountContactRole(
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

	public static HttpInvoker.HttpResponse putAccountContactRoleHttpResponse(
			Long accountId, Long contactId, Long[] contactRoleIds)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(contactRoleIds.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		if (contactRoleIds != null) {
			for (int i = 0; i < contactRoleIds.length; i++) {
				httpInvoker.parameter(
					"contactRoleIds", String.valueOf(contactRoleIds[i]));
			}
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}/contacts/{contactId}/roles",
			accountId, contactId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	private static final Logger _logger = Logger.getLogger(
		AccountResource.class.getName());

}