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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.ExternalLink;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Pagination;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ExternalLinkSerDes;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public interface ExternalLinkResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<ExternalLink> getAccountExternalLinksPage(
			Long accountId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getAccountExternalLinksPageHttpResponse(
			Long accountId, Pagination pagination)
		throws Exception;

	public ExternalLink postAccountExternalLink(
			Long accountId, ExternalLink externalLink)
		throws Exception;

	public HttpInvoker.HttpResponse postAccountExternalLinkHttpResponse(
			Long accountId, ExternalLink externalLink)
		throws Exception;

	public Page<ExternalLink> getContactExternalLinksPage(
			Long contactId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getContactExternalLinksPageHttpResponse(
			Long contactId, Pagination pagination)
		throws Exception;

	public ExternalLink postContactExternalLink(
			Long contactId, ExternalLink externalLink)
		throws Exception;

	public HttpInvoker.HttpResponse postContactExternalLinkHttpResponse(
			Long contactId, ExternalLink externalLink)
		throws Exception;

	public void deleteExternalLink(Long externalLinkId) throws Exception;

	public HttpInvoker.HttpResponse deleteExternalLinkHttpResponse(
			Long externalLinkId)
		throws Exception;

	public ExternalLink getExternalLink(Long externalLinkId) throws Exception;

	public HttpInvoker.HttpResponse getExternalLinkHttpResponse(
			Long externalLinkId)
		throws Exception;

	public Page<ExternalLink> getProductConsumptionExternalLinksPage(
			Long productConsumptionId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse
			getProductConsumptionExternalLinksPageHttpResponse(
				Long productConsumptionId, Pagination pagination)
		throws Exception;

	public ExternalLink postProductConsumptionExternalLink(
			Long productConsumptionId, ExternalLink externalLink)
		throws Exception;

	public HttpInvoker.HttpResponse
			postProductConsumptionExternalLinkHttpResponse(
				Long productConsumptionId, ExternalLink externalLink)
		throws Exception;

	public Page<ExternalLink> getProductPurchaseExternalLinksPage(
			Long productPurchaseId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse
			getProductPurchaseExternalLinksPageHttpResponse(
				Long productPurchaseId, Pagination pagination)
		throws Exception;

	public ExternalLink postProductPurchaseExternalLink(
			Long productPurchaseId, ExternalLink externalLink)
		throws Exception;

	public HttpInvoker.HttpResponse postProductPurchaseExternalLinkHttpResponse(
			Long productPurchaseId, ExternalLink externalLink)
		throws Exception;

	public Page<ExternalLink> getProductExternalLinksPage(
			Long productId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getProductExternalLinksPageHttpResponse(
			Long productId, Pagination pagination)
		throws Exception;

	public ExternalLink postProductExternalLink(
			Long productId, ExternalLink externalLink)
		throws Exception;

	public HttpInvoker.HttpResponse postProductExternalLinkHttpResponse(
			Long productId, ExternalLink externalLink)
		throws Exception;

	public Page<ExternalLink> getProjectExternalLinksPage(
			Long projectId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getProjectExternalLinksPageHttpResponse(
			Long projectId, Pagination pagination)
		throws Exception;

	public ExternalLink postProjectExternalLink(
			Long projectId, ExternalLink externalLink)
		throws Exception;

	public HttpInvoker.HttpResponse postProjectExternalLinkHttpResponse(
			Long projectId, ExternalLink externalLink)
		throws Exception;

	public Page<ExternalLink> getTeamExternalLinksPage(
			Long teamId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getTeamExternalLinksPageHttpResponse(
			Long teamId, Pagination pagination)
		throws Exception;

	public ExternalLink postTeamExternalLink(
			Long teamId, ExternalLink externalLink)
		throws Exception;

	public HttpInvoker.HttpResponse postTeamExternalLinkHttpResponse(
			Long teamId, ExternalLink externalLink)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public ExternalLinkResource build() {
			return new ExternalLinkResourceImpl(this);
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

	public static class ExternalLinkResourceImpl
		implements ExternalLinkResource {

		public Page<ExternalLink> getAccountExternalLinksPage(
				Long accountId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getAccountExternalLinksPageHttpResponse(accountId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ExternalLinkSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getAccountExternalLinksPageHttpResponse(
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
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/external-links",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public ExternalLink postAccountExternalLink(
				Long accountId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postAccountExternalLinkHttpResponse(accountId, externalLink);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ExternalLinkSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse postAccountExternalLinkHttpResponse(
				Long accountId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(externalLink.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/external-links",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<ExternalLink> getContactExternalLinksPage(
				Long contactId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getContactExternalLinksPageHttpResponse(contactId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ExternalLinkSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getContactExternalLinksPageHttpResponse(
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
						"/o/koroneiki-rest/v1.0/contacts/{contactId}/external-links",
				contactId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public ExternalLink postContactExternalLink(
				Long contactId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postContactExternalLinkHttpResponse(contactId, externalLink);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ExternalLinkSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse postContactExternalLinkHttpResponse(
				Long contactId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(externalLink.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/contacts/{contactId}/external-links",
				contactId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteExternalLink(Long externalLinkId) throws Exception {
			HttpInvoker.HttpResponse httpResponse =
				deleteExternalLinkHttpResponse(externalLinkId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse deleteExternalLinkHttpResponse(
				Long externalLinkId)
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
						"/o/koroneiki-rest/v1.0/external-links/{externalLinkId}",
				externalLinkId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public ExternalLink getExternalLink(Long externalLinkId)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse = getExternalLinkHttpResponse(
				externalLinkId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ExternalLinkSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse getExternalLinkHttpResponse(
				Long externalLinkId)
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
						"/o/koroneiki-rest/v1.0/external-links/{externalLinkId}",
				externalLinkId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<ExternalLink> getProductConsumptionExternalLinksPage(
				Long productConsumptionId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getProductConsumptionExternalLinksPageHttpResponse(
					productConsumptionId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ExternalLinkSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse
				getProductConsumptionExternalLinksPageHttpResponse(
					Long productConsumptionId, Pagination pagination)
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
						"/o/koroneiki-rest/v1.0/product-consumptions/{productConsumptionId}/external-links",
				productConsumptionId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public ExternalLink postProductConsumptionExternalLink(
				Long productConsumptionId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postProductConsumptionExternalLinkHttpResponse(
					productConsumptionId, externalLink);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ExternalLinkSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse
				postProductConsumptionExternalLinkHttpResponse(
					Long productConsumptionId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(externalLink.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/product-consumptions/{productConsumptionId}/external-links",
				productConsumptionId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<ExternalLink> getProductPurchaseExternalLinksPage(
				Long productPurchaseId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getProductPurchaseExternalLinksPageHttpResponse(
					productPurchaseId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ExternalLinkSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse
				getProductPurchaseExternalLinksPageHttpResponse(
					Long productPurchaseId, Pagination pagination)
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
						"/o/koroneiki-rest/v1.0/product-purchases/{productPurchaseId}/external-links",
				productPurchaseId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public ExternalLink postProductPurchaseExternalLink(
				Long productPurchaseId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postProductPurchaseExternalLinkHttpResponse(
					productPurchaseId, externalLink);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ExternalLinkSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse
				postProductPurchaseExternalLinkHttpResponse(
					Long productPurchaseId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(externalLink.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/product-purchases/{productPurchaseId}/external-links",
				productPurchaseId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<ExternalLink> getProductExternalLinksPage(
				Long productId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getProductExternalLinksPageHttpResponse(productId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ExternalLinkSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getProductExternalLinksPageHttpResponse(
				Long productId, Pagination pagination)
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
						"/o/koroneiki-rest/v1.0/products/{productId}/external-links",
				productId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public ExternalLink postProductExternalLink(
				Long productId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postProductExternalLinkHttpResponse(productId, externalLink);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ExternalLinkSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse postProductExternalLinkHttpResponse(
				Long productId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(externalLink.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/products/{productId}/external-links",
				productId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<ExternalLink> getProjectExternalLinksPage(
				Long projectId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getProjectExternalLinksPageHttpResponse(projectId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ExternalLinkSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getProjectExternalLinksPageHttpResponse(
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
						"/o/koroneiki-rest/v1.0/projects/{projectId}/external-links",
				projectId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public ExternalLink postProjectExternalLink(
				Long projectId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postProjectExternalLinkHttpResponse(projectId, externalLink);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ExternalLinkSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse postProjectExternalLinkHttpResponse(
				Long projectId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(externalLink.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectId}/external-links",
				projectId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<ExternalLink> getTeamExternalLinksPage(
				Long teamId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getTeamExternalLinksPageHttpResponse(teamId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ExternalLinkSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse getTeamExternalLinksPageHttpResponse(
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
						"/o/koroneiki-rest/v1.0/teams/{teamId}/external-links",
				teamId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public ExternalLink postTeamExternalLink(
				Long teamId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postTeamExternalLinkHttpResponse(teamId, externalLink);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ExternalLinkSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse postTeamExternalLinkHttpResponse(
				Long teamId, ExternalLink externalLink)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(externalLink.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/teams/{teamId}/external-links",
				teamId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private ExternalLinkResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			ExternalLinkResource.class.getName());

		private Builder _builder;

	}

}