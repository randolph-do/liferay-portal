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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.Project;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Pagination;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ProjectSerDes;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public interface ProjectResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<Project> getAccountProjectsPage(
			Long accountId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getAccountProjectsPageHttpResponse(
			Long accountId, Pagination pagination)
		throws Exception;

	public Project postAccountProject(Long accountId, Project project)
		throws Exception;

	public HttpInvoker.HttpResponse postAccountProjectHttpResponse(
			Long accountId, Project project)
		throws Exception;

	public void deleteProject(Long projectId) throws Exception;

	public HttpInvoker.HttpResponse deleteProjectHttpResponse(Long projectId)
		throws Exception;

	public Project getProject(Long projectId) throws Exception;

	public HttpInvoker.HttpResponse getProjectHttpResponse(Long projectId)
		throws Exception;

	public Project putProject(Long projectId, Project project) throws Exception;

	public HttpInvoker.HttpResponse putProjectHttpResponse(
			Long projectId, Project project)
		throws Exception;

	public void deleteProjectContact(Long projectId, Long[] contactIds)
		throws Exception;

	public HttpInvoker.HttpResponse deleteProjectContactHttpResponse(
			Long projectId, Long[] contactIds)
		throws Exception;

	public void putProjectContact(Long projectId, Long[] contactIds)
		throws Exception;

	public HttpInvoker.HttpResponse putProjectContactHttpResponse(
			Long projectId, Long[] contactIds)
		throws Exception;

	public void deleteProjectContactRole(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public HttpInvoker.HttpResponse deleteProjectContactRoleHttpResponse(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public void putProjectContactRole(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public HttpInvoker.HttpResponse putProjectContactRoleHttpResponse(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public void deleteProjectTeamRole(
			Long projectId, Long teamId, Long[] teamRoleIds)
		throws Exception;

	public HttpInvoker.HttpResponse deleteProjectTeamRoleHttpResponse(
			Long projectId, Long teamId, Long[] teamRoleIds)
		throws Exception;

	public void putProjectTeamRole(
			Long projectId, Long teamId, Long[] teamRoleIds)
		throws Exception;

	public HttpInvoker.HttpResponse putProjectTeamRoleHttpResponse(
			Long projectId, Long teamId, Long[] teamRoleIds)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public ProjectResource build() {
			return new ProjectResourceImpl(this);
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

	public static class ProjectResourceImpl implements ProjectResource {

		public Page<Project> getAccountProjectsPage(
				Long accountId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getAccountProjectsPageHttpResponse(accountId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ProjectSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getAccountProjectsPageHttpResponse(
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
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/projects",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Project postAccountProject(Long accountId, Project project)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postAccountProjectHttpResponse(accountId, project);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ProjectSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse postAccountProjectHttpResponse(
				Long accountId, Project project)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(project.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/projects",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteProject(Long projectId) throws Exception {
			HttpInvoker.HttpResponse httpResponse = deleteProjectHttpResponse(
				projectId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse deleteProjectHttpResponse(
				Long projectId)
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
						"/o/koroneiki-rest/v1.0/projects/{projectId}",
				projectId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Project getProject(Long projectId) throws Exception {
			HttpInvoker.HttpResponse httpResponse = getProjectHttpResponse(
				projectId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ProjectSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse getProjectHttpResponse(Long projectId)
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
						"/o/koroneiki-rest/v1.0/projects/{projectId}",
				projectId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Project putProject(Long projectId, Project project)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse = putProjectHttpResponse(
				projectId, project);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ProjectSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse putProjectHttpResponse(
				Long projectId, Project project)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(project.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectId}",
				projectId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteProjectContact(Long projectId, Long[] contactIds)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				deleteProjectContactHttpResponse(projectId, contactIds);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse deleteProjectContactHttpResponse(
				Long projectId, Long[] contactIds)
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
						"/o/koroneiki-rest/v1.0/projects/{projectId}/contacts",
				projectId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void putProjectContact(Long projectId, Long[] contactIds)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				putProjectContactHttpResponse(projectId, contactIds);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse putProjectContactHttpResponse(
				Long projectId, Long[] contactIds)
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
						"/o/koroneiki-rest/v1.0/projects/{projectId}/contacts",
				projectId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteProjectContactRole(
				Long projectId, Long contactId, Long[] contactRoleIds)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				deleteProjectContactRoleHttpResponse(
					projectId, contactId, contactRoleIds);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse deleteProjectContactRoleHttpResponse(
				Long projectId, Long contactId, Long[] contactRoleIds)
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
						"/o/koroneiki-rest/v1.0/projects/{projectId}/contacts/{contactId}/roles",
				projectId, contactId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void putProjectContactRole(
				Long projectId, Long contactId, Long[] contactRoleIds)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				putProjectContactRoleHttpResponse(
					projectId, contactId, contactRoleIds);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse putProjectContactRoleHttpResponse(
				Long projectId, Long contactId, Long[] contactRoleIds)
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
						"/o/koroneiki-rest/v1.0/projects/{projectId}/contacts/{contactId}/roles",
				projectId, contactId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteProjectTeamRole(
				Long projectId, Long teamId, Long[] teamRoleIds)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				deleteProjectTeamRoleHttpResponse(
					projectId, teamId, teamRoleIds);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse deleteProjectTeamRoleHttpResponse(
				Long projectId, Long teamId, Long[] teamRoleIds)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

			if (teamRoleIds != null) {
				for (int i = 0; i < teamRoleIds.length; i++) {
					httpInvoker.parameter(
						"teamRoleIds", String.valueOf(teamRoleIds[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectId}/teams/{teamId}/roles",
				projectId, teamId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void putProjectTeamRole(
				Long projectId, Long teamId, Long[] teamRoleIds)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				putProjectTeamRoleHttpResponse(projectId, teamId, teamRoleIds);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse putProjectTeamRoleHttpResponse(
				Long projectId, Long teamId, Long[] teamRoleIds)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(teamRoleIds.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

			if (teamRoleIds != null) {
				for (int i = 0; i < teamRoleIds.length; i++) {
					httpInvoker.parameter(
						"teamRoleIds", String.valueOf(teamRoleIds[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectId}/teams/{teamId}/roles",
				projectId, teamId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private ProjectResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			ProjectResource.class.getName());

		private Builder _builder;

	}

}