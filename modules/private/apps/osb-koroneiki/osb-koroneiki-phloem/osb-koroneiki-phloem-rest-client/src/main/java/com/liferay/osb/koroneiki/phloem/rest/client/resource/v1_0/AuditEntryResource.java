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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.AuditEntry;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Pagination;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.AuditEntrySerDes;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public interface AuditEntryResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<AuditEntry> getAccountAuditEntriesPage(
			Long accountId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getAccountAuditEntriesPageHttpResponse(
			Long accountId, Pagination pagination)
		throws Exception;

	public AuditEntry getAuditEntry(Long auditEntryId) throws Exception;

	public HttpInvoker.HttpResponse getAuditEntryHttpResponse(Long auditEntryId)
		throws Exception;

	public Page<AuditEntry> getContactRoleAuditEntriesPage(
			Long contactRoleId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getContactRoleAuditEntriesPageHttpResponse(
			Long contactRoleId, Pagination pagination)
		throws Exception;

	public Page<AuditEntry> getContactAuditEntriesPage(
			Long contactId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getContactAuditEntriesPageHttpResponse(
			Long contactId, Pagination pagination)
		throws Exception;

	public Page<AuditEntry> getProjectAuditEntriesPage(
			Long projectId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getProjectAuditEntriesPageHttpResponse(
			Long projectId, Pagination pagination)
		throws Exception;

	public Page<AuditEntry> getTeamRoleAuditEntriesPage(
			Long teamRoleId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getTeamRoleAuditEntriesPageHttpResponse(
			Long teamRoleId, Pagination pagination)
		throws Exception;

	public Page<AuditEntry> getTeamAuditEntriesPage(
			Long teamId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getTeamAuditEntriesPageHttpResponse(
			Long teamId, Pagination pagination)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public AuditEntryResource build() {
			return new AuditEntryResourceImpl(this);
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

	public static class AuditEntryResourceImpl implements AuditEntryResource {

		public Page<AuditEntry> getAccountAuditEntriesPage(
				Long accountId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getAccountAuditEntriesPageHttpResponse(accountId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, AuditEntrySerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getAccountAuditEntriesPageHttpResponse(
				Long accountId, Pagination pagination)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (pagination != null) {
				httpInvoker.parameter(
					"page", String.valueOf(pagination.getPage()));
				httpInvoker.parameter(
					"pageSize", String.valueOf(pagination.getPageSize()));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/audit-entries",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public AuditEntry getAuditEntry(Long auditEntryId) throws Exception {
			HttpInvoker.HttpResponse httpResponse = getAuditEntryHttpResponse(
				auditEntryId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return AuditEntrySerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse getAuditEntryHttpResponse(
				Long auditEntryId)
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
						"/o/koroneiki-rest/v1.0/audit-entries/{auditEntryId}",
				auditEntryId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<AuditEntry> getContactRoleAuditEntriesPage(
				Long contactRoleId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getContactRoleAuditEntriesPageHttpResponse(
					contactRoleId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, AuditEntrySerDes::toDTO);
		}

		public HttpInvoker.HttpResponse
				getContactRoleAuditEntriesPageHttpResponse(
					Long contactRoleId, Pagination pagination)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (pagination != null) {
				httpInvoker.parameter(
					"page", String.valueOf(pagination.getPage()));
				httpInvoker.parameter(
					"pageSize", String.valueOf(pagination.getPageSize()));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/contact-roles/{contactRoleId}/audit-entries",
				contactRoleId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<AuditEntry> getContactAuditEntriesPage(
				Long contactId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getContactAuditEntriesPageHttpResponse(contactId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, AuditEntrySerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getContactAuditEntriesPageHttpResponse(
				Long contactId, Pagination pagination)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (pagination != null) {
				httpInvoker.parameter(
					"page", String.valueOf(pagination.getPage()));
				httpInvoker.parameter(
					"pageSize", String.valueOf(pagination.getPageSize()));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/contacts/{contactId}/audit-entries",
				contactId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<AuditEntry> getProjectAuditEntriesPage(
				Long projectId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getProjectAuditEntriesPageHttpResponse(projectId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, AuditEntrySerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getProjectAuditEntriesPageHttpResponse(
				Long projectId, Pagination pagination)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (pagination != null) {
				httpInvoker.parameter(
					"page", String.valueOf(pagination.getPage()));
				httpInvoker.parameter(
					"pageSize", String.valueOf(pagination.getPageSize()));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectId}/audit-entries",
				projectId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<AuditEntry> getTeamRoleAuditEntriesPage(
				Long teamRoleId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getTeamRoleAuditEntriesPageHttpResponse(teamRoleId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, AuditEntrySerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getTeamRoleAuditEntriesPageHttpResponse(
				Long teamRoleId, Pagination pagination)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (pagination != null) {
				httpInvoker.parameter(
					"page", String.valueOf(pagination.getPage()));
				httpInvoker.parameter(
					"pageSize", String.valueOf(pagination.getPageSize()));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/team-roles/{teamRoleId}/audit-entries",
				teamRoleId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<AuditEntry> getTeamAuditEntriesPage(
				Long teamId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getTeamAuditEntriesPageHttpResponse(teamId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, AuditEntrySerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getTeamAuditEntriesPageHttpResponse(
				Long teamId, Pagination pagination)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (pagination != null) {
				httpInvoker.parameter(
					"page", String.valueOf(pagination.getPage()));
				httpInvoker.parameter(
					"pageSize", String.valueOf(pagination.getPageSize()));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/teams/{teamId}/audit-entries",
				teamId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private AuditEntryResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			AuditEntryResource.class.getName());

		private Builder _builder;

	}

}