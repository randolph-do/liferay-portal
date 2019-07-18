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

	public Page<Project> getAccountAccountKeyProjectsPage(
			String accountKey, String[] includes, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse
			getAccountAccountKeyProjectsPageHttpResponse(
				String accountKey, String[] includes, Pagination pagination)
		throws Exception;

	public Project postAccountAccountKeyProject(
			String accountKey, Project project)
		throws Exception;

	public HttpInvoker.HttpResponse postAccountAccountKeyProjectHttpResponse(
			String accountKey, Project project)
		throws Exception;

	public Page<Project> getProjectsPage(
			String search, String filterString, Pagination pagination,
			String sortString)
		throws Exception;

	public HttpInvoker.HttpResponse getProjectsPageHttpResponse(
			String search, String filterString, Pagination pagination,
			String sortString)
		throws Exception;

	public void deleteProject(String projectKey) throws Exception;

	public HttpInvoker.HttpResponse deleteProjectHttpResponse(String projectKey)
		throws Exception;

	public Project getProject(String projectKey, String[] includes)
		throws Exception;

	public HttpInvoker.HttpResponse getProjectHttpResponse(
			String projectKey, String[] includes)
		throws Exception;

	public Project putProject(String projectKey, Project project)
		throws Exception;

	public HttpInvoker.HttpResponse putProjectHttpResponse(
			String projectKey, Project project)
		throws Exception;

	public void deleteProjectContact(String projectKey, String[] contactKeys)
		throws Exception;

	public HttpInvoker.HttpResponse deleteProjectContactHttpResponse(
			String projectKey, String[] contactKeys)
		throws Exception;

	public void putProjectContact(String projectKey, String[] contactKeys)
		throws Exception;

	public HttpInvoker.HttpResponse putProjectContactHttpResponse(
			String projectKey, String[] contactKeys)
		throws Exception;

	public void deleteProjectContactContactKeyRole(
			String projectKey, String contactKey, String[] contactRoleKeys)
		throws Exception;

	public HttpInvoker.HttpResponse
			deleteProjectContactContactKeyRoleHttpResponse(
				String projectKey, String contactKey, String[] contactRoleKeys)
		throws Exception;

	public void putProjectContactContactKeyRole(
			String projectKey, String contactKey, String[] contactRoleKeys)
		throws Exception;

	public HttpInvoker.HttpResponse putProjectContactContactKeyRoleHttpResponse(
			String projectKey, String contactKey, String[] contactRoleKeys)
		throws Exception;

	public void deleteProjectTeamTeamKeyRole(
			String projectKey, String teamKey, String[] teamRoleKeys)
		throws Exception;

	public HttpInvoker.HttpResponse deleteProjectTeamTeamKeyRoleHttpResponse(
			String projectKey, String teamKey, String[] teamRoleKeys)
		throws Exception;

	public void putProjectTeamTeamKeyRole(
			String projectKey, String teamKey, String[] teamRoleKeys)
		throws Exception;

	public HttpInvoker.HttpResponse putProjectTeamTeamKeyRoleHttpResponse(
			String projectKey, String teamKey, String[] teamRoleKeys)
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

		public Page<Project> getAccountAccountKeyProjectsPage(
				String accountKey, String[] includes, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getAccountAccountKeyProjectsPageHttpResponse(
					accountKey, includes, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ProjectSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse
				getAccountAccountKeyProjectsPageHttpResponse(
					String accountKey, String[] includes, Pagination pagination)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (includes != null) {
				for (int i = 0; i < includes.length; i++) {
					httpInvoker.parameter(
						"includes", String.valueOf(includes[i]));
				}
			}

			if (pagination != null) {
				httpInvoker.parameter(
					"page", String.valueOf(pagination.getPage()));
				httpInvoker.parameter(
					"pageSize", String.valueOf(pagination.getPageSize()));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountKey}/projects",
				accountKey);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Project postAccountAccountKeyProject(
				String accountKey, Project project)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postAccountAccountKeyProjectHttpResponse(accountKey, project);

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

		public HttpInvoker.HttpResponse
				postAccountAccountKeyProjectHttpResponse(
					String accountKey, Project project)
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
						"/o/koroneiki-rest/v1.0/accounts/{accountKey}/projects",
				accountKey);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<Project> getProjectsPage(
				String search, String filterString, Pagination pagination,
				String sortString)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse = getProjectsPageHttpResponse(
				search, filterString, pagination, sortString);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ProjectSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getProjectsPageHttpResponse(
				String search, String filterString, Pagination pagination,
				String sortString)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (search != null) {
				httpInvoker.parameter("search", String.valueOf(search));
			}

			if (filterString != null) {
				httpInvoker.parameter("filter", filterString);
			}

			if (pagination != null) {
				httpInvoker.parameter(
					"page", String.valueOf(pagination.getPage()));
				httpInvoker.parameter(
					"pageSize", String.valueOf(pagination.getPageSize()));
			}

			if (sortString != null) {
				httpInvoker.parameter("sort", sortString);
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port + "/o/koroneiki-rest/v1.0/projects");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteProject(String projectKey) throws Exception {
			HttpInvoker.HttpResponse httpResponse = deleteProjectHttpResponse(
				projectKey);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse deleteProjectHttpResponse(
				String projectKey)
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
						"/o/koroneiki-rest/v1.0/projects/{projectKey}",
				projectKey);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Project getProject(String projectKey, String[] includes)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse = getProjectHttpResponse(
				projectKey, includes);

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

		public HttpInvoker.HttpResponse getProjectHttpResponse(
				String projectKey, String[] includes)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (includes != null) {
				for (int i = 0; i < includes.length; i++) {
					httpInvoker.parameter(
						"includes", String.valueOf(includes[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectKey}",
				projectKey);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Project putProject(String projectKey, Project project)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse = putProjectHttpResponse(
				projectKey, project);

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
				String projectKey, Project project)
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
						"/o/koroneiki-rest/v1.0/projects/{projectKey}",
				projectKey);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteProjectContact(
				String projectKey, String[] contactKeys)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				deleteProjectContactHttpResponse(projectKey, contactKeys);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse deleteProjectContactHttpResponse(
				String projectKey, String[] contactKeys)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

			if (contactKeys != null) {
				for (int i = 0; i < contactKeys.length; i++) {
					httpInvoker.parameter(
						"contactKeys", String.valueOf(contactKeys[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectKey}/contacts",
				projectKey);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void putProjectContact(String projectKey, String[] contactKeys)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				putProjectContactHttpResponse(projectKey, contactKeys);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse putProjectContactHttpResponse(
				String projectKey, String[] contactKeys)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(contactKeys.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

			if (contactKeys != null) {
				for (int i = 0; i < contactKeys.length; i++) {
					httpInvoker.parameter(
						"contactKeys", String.valueOf(contactKeys[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectKey}/contacts",
				projectKey);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteProjectContactContactKeyRole(
				String projectKey, String contactKey, String[] contactRoleKeys)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				deleteProjectContactContactKeyRoleHttpResponse(
					projectKey, contactKey, contactRoleKeys);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse
				deleteProjectContactContactKeyRoleHttpResponse(
					String projectKey, String contactKey,
					String[] contactRoleKeys)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

			if (contactRoleKeys != null) {
				for (int i = 0; i < contactRoleKeys.length; i++) {
					httpInvoker.parameter(
						"contactRoleKeys", String.valueOf(contactRoleKeys[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectKey}/contacts/{contactKey}/roles",
				projectKey, contactKey);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void putProjectContactContactKeyRole(
				String projectKey, String contactKey, String[] contactRoleKeys)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				putProjectContactContactKeyRoleHttpResponse(
					projectKey, contactKey, contactRoleKeys);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse
				putProjectContactContactKeyRoleHttpResponse(
					String projectKey, String contactKey,
					String[] contactRoleKeys)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(contactRoleKeys.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

			if (contactRoleKeys != null) {
				for (int i = 0; i < contactRoleKeys.length; i++) {
					httpInvoker.parameter(
						"contactRoleKeys", String.valueOf(contactRoleKeys[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectKey}/contacts/{contactKey}/roles",
				projectKey, contactKey);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteProjectTeamTeamKeyRole(
				String projectKey, String teamKey, String[] teamRoleKeys)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				deleteProjectTeamTeamKeyRoleHttpResponse(
					projectKey, teamKey, teamRoleKeys);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse
				deleteProjectTeamTeamKeyRoleHttpResponse(
					String projectKey, String teamKey, String[] teamRoleKeys)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

			if (teamRoleKeys != null) {
				for (int i = 0; i < teamRoleKeys.length; i++) {
					httpInvoker.parameter(
						"teamRoleKeys", String.valueOf(teamRoleKeys[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectKey}/teams/{teamKey}/roles",
				projectKey, teamKey);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void putProjectTeamTeamKeyRole(
				String projectKey, String teamKey, String[] teamRoleKeys)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				putProjectTeamTeamKeyRoleHttpResponse(
					projectKey, teamKey, teamRoleKeys);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse putProjectTeamTeamKeyRoleHttpResponse(
				String projectKey, String teamKey, String[] teamRoleKeys)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(teamRoleKeys.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

			if (teamRoleKeys != null) {
				for (int i = 0; i < teamRoleKeys.length; i++) {
					httpInvoker.parameter(
						"teamRoleKeys", String.valueOf(teamRoleKeys[i]));
				}
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectKey}/teams/{teamKey}/roles",
				projectKey, teamKey);

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