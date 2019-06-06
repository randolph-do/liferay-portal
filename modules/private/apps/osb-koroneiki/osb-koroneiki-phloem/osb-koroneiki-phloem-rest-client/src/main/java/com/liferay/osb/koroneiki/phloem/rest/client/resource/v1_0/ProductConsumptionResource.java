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

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public class ProductConsumptionResource {

	public static void deleteAccountProductConsumption(
			Long accountId, Long productId)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			deleteAccountProductConsumptionHttpResponse(accountId, productId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse
			deleteAccountProductConsumptionHttpResponse(
				Long accountId, Long productId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		if (productId != null) {
			httpInvoker.parameter("productId", String.valueOf(productId));
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}/product-consumptions",
			accountId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Page<ProductConsumption> getAccountProductConsumptionsPage(
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

	public static HttpInvoker.HttpResponse
			getAccountProductConsumptionsPageHttpResponse(
				Long accountId, Pagination pagination)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		if (pagination != null) {
			httpInvoker.parameter("page", String.valueOf(pagination.getPage()));
			httpInvoker.parameter(
				"pageSize", String.valueOf(pagination.getPageSize()));
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}/product-consumptions",
			accountId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static ProductConsumption postAccountProductConsumption(
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
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse
			postAccountProductConsumptionHttpResponse(
				Long accountId, Long productId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(productId.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		if (productId != null) {
			httpInvoker.parameter("productId", String.valueOf(productId));
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}/product-consumptions",
			accountId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteProductConsumption(Long productConsumptionId)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			deleteProductConsumptionHttpResponse(productConsumptionId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse deleteProductConsumptionHttpResponse(
			Long productConsumptionId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/product-consumptions/{productConsumptionId}",
			productConsumptionId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static ProductConsumption getProductConsumption(
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
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse getProductConsumptionHttpResponse(
			Long productConsumptionId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/product-consumptions/{productConsumptionId}",
			productConsumptionId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteProjectProductConsumption(
			Long projectId, Long productId)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			deleteProjectProductConsumptionHttpResponse(projectId, productId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse
			deleteProjectProductConsumptionHttpResponse(
				Long projectId, Long productId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		if (productId != null) {
			httpInvoker.parameter("productId", String.valueOf(productId));
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/projects/{projectId}/product-consumptions",
			projectId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Page<ProductConsumption> getProjectProductConsumptionsPage(
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

	public static HttpInvoker.HttpResponse
			getProjectProductConsumptionsPageHttpResponse(
				Long projectId, Pagination pagination)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		if (pagination != null) {
			httpInvoker.parameter("page", String.valueOf(pagination.getPage()));
			httpInvoker.parameter(
				"pageSize", String.valueOf(pagination.getPageSize()));
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/projects/{projectId}/product-consumptions",
			projectId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static ProductConsumption postProjectProductConsumption(
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
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse
			postProjectProductConsumptionHttpResponse(
				Long projectId, Long productId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(productId.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		if (productId != null) {
			httpInvoker.parameter("productId", String.valueOf(productId));
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/projects/{projectId}/product-consumptions",
			projectId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	private static final Logger _logger = Logger.getLogger(
		ProductConsumptionResource.class.getName());

}