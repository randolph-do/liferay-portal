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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.ProductConsumption;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Pagination;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ProductConsumptionSerDes;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public interface ProductConsumptionResource {

	public static Builder builder() {
		return new Builder();
	}

	public void deleteAccountProductConsumption(Long accountId, Long productId)
		throws Exception;

	public HttpInvoker.HttpResponse deleteAccountProductConsumptionHttpResponse(
			Long accountId, Long productId)
		throws Exception;

	public Page<ProductConsumption> getAccountProductConsumptionsPage(
			Long accountId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse
			getAccountProductConsumptionsPageHttpResponse(
				Long accountId, Pagination pagination)
		throws Exception;

	public ProductConsumption postAccountProductConsumption(
			Long accountId, Long productId)
		throws Exception;

	public HttpInvoker.HttpResponse postAccountProductConsumptionHttpResponse(
			Long accountId, Long productId)
		throws Exception;

	public void deleteProductConsumption(Long productConsumptionId)
		throws Exception;

	public HttpInvoker.HttpResponse deleteProductConsumptionHttpResponse(
			Long productConsumptionId)
		throws Exception;

	public ProductConsumption getProductConsumption(Long productConsumptionId)
		throws Exception;

	public HttpInvoker.HttpResponse getProductConsumptionHttpResponse(
			Long productConsumptionId)
		throws Exception;

	public void deleteProjectProductConsumption(Long projectId, Long productId)
		throws Exception;

	public HttpInvoker.HttpResponse deleteProjectProductConsumptionHttpResponse(
			Long projectId, Long productId)
		throws Exception;

	public Page<ProductConsumption> getProjectProductConsumptionsPage(
			Long projectId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse
			getProjectProductConsumptionsPageHttpResponse(
				Long projectId, Pagination pagination)
		throws Exception;

	public ProductConsumption postProjectProductConsumption(
			Long projectId, Long productId)
		throws Exception;

	public HttpInvoker.HttpResponse postProjectProductConsumptionHttpResponse(
			Long projectId, Long productId)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public ProductConsumptionResource build() {
			return new ProductConsumptionResourceImpl(this);
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

	public static class ProductConsumptionResourceImpl
		implements ProductConsumptionResource {

		public void deleteAccountProductConsumption(
				Long accountId, Long productId)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				deleteAccountProductConsumptionHttpResponse(
					accountId, productId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse
				deleteAccountProductConsumptionHttpResponse(
					Long accountId, Long productId)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

			if (productId != null) {
				httpInvoker.parameter("productId", String.valueOf(productId));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/product-consumptions",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<ProductConsumption> getAccountProductConsumptionsPage(
				Long accountId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getAccountProductConsumptionsPageHttpResponse(
					accountId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ProductConsumptionSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse
				getAccountProductConsumptionsPageHttpResponse(
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
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/product-consumptions",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public ProductConsumption postAccountProductConsumption(
				Long accountId, Long productId)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postAccountProductConsumptionHttpResponse(accountId, productId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ProductConsumptionSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse
				postAccountProductConsumptionHttpResponse(
					Long accountId, Long productId)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(productId.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			if (productId != null) {
				httpInvoker.parameter("productId", String.valueOf(productId));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/accounts/{accountId}/product-consumptions",
				accountId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteProductConsumption(Long productConsumptionId)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				deleteProductConsumptionHttpResponse(productConsumptionId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse deleteProductConsumptionHttpResponse(
				Long productConsumptionId)
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
						"/o/koroneiki-rest/v1.0/product-consumptions/{productConsumptionId}",
				productConsumptionId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public ProductConsumption getProductConsumption(
				Long productConsumptionId)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getProductConsumptionHttpResponse(productConsumptionId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ProductConsumptionSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse getProductConsumptionHttpResponse(
				Long productConsumptionId)
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
						"/o/koroneiki-rest/v1.0/product-consumptions/{productConsumptionId}",
				productConsumptionId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void deleteProjectProductConsumption(
				Long projectId, Long productId)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				deleteProjectProductConsumptionHttpResponse(
					projectId, productId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());
		}

		public HttpInvoker.HttpResponse
				deleteProjectProductConsumptionHttpResponse(
					Long projectId, Long productId)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

			if (productId != null) {
				httpInvoker.parameter("productId", String.valueOf(productId));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectId}/product-consumptions",
				projectId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<ProductConsumption> getProjectProductConsumptionsPage(
				Long projectId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getProjectProductConsumptionsPageHttpResponse(
					projectId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			return Page.of(content, ProductConsumptionSerDes::toDTO);
		}

		public HttpInvoker.HttpResponse
				getProjectProductConsumptionsPageHttpResponse(
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
						"/o/koroneiki-rest/v1.0/projects/{projectId}/product-consumptions",
				projectId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public ProductConsumption postProjectProductConsumption(
				Long projectId, Long productId)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postProjectProductConsumptionHttpResponse(projectId, productId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return ProductConsumptionSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse
				postProjectProductConsumptionHttpResponse(
					Long projectId, Long productId)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(productId.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			if (productId != null) {
				httpInvoker.parameter("productId", String.valueOf(productId));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/koroneiki-rest/v1.0/projects/{projectId}/product-consumptions",
				projectId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private ProductConsumptionResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			ProductConsumptionResource.class.getName());

		private Builder _builder;

	}

}