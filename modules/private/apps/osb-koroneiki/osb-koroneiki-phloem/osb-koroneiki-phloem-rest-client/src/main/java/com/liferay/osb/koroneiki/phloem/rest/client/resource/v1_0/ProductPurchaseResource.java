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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.ProductPurchase;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Pagination;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ProductPurchaseSerDes;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public class ProductPurchaseResource {

	public static Page<ProductPurchase> getAccountProductPurchasesPage(
			Long accountId, Pagination pagination)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			getAccountProductPurchasesPageHttpResponse(accountId, pagination);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		return Page.of(content, ProductPurchaseSerDes::toDTO);
	}

	public static HttpInvoker.HttpResponse
			getAccountProductPurchasesPageHttpResponse(
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
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}/product-purchases",
			accountId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static ProductPurchase postAccountProductPurchase(
			Long accountId, Long productId, ProductPurchase productPurchase)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			postAccountProductPurchaseHttpResponse(
				accountId, productId, productPurchase);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return ProductPurchaseSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse
			postAccountProductPurchaseHttpResponse(
				Long accountId, Long productId, ProductPurchase productPurchase)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(productPurchase.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		if (productId != null) {
			httpInvoker.parameter("productId", String.valueOf(productId));
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/accounts/{accountId}/product-purchases",
			accountId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteProductPurchase(Long productPurchaseId)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			deleteProductPurchaseHttpResponse(productPurchaseId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse deleteProductPurchaseHttpResponse(
			Long productPurchaseId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/product-purchases/{productPurchaseId}",
			productPurchaseId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static ProductPurchase getProductPurchase(Long productPurchaseId)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = getProductPurchaseHttpResponse(
			productPurchaseId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return ProductPurchaseSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse getProductPurchaseHttpResponse(
			Long productPurchaseId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/product-purchases/{productPurchaseId}",
			productPurchaseId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static ProductPurchase putProductPurchase(
			Long productPurchaseId, ProductPurchase productPurchase)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = putProductPurchaseHttpResponse(
			productPurchaseId, productPurchase);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return ProductPurchaseSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse putProductPurchaseHttpResponse(
			Long productPurchaseId, ProductPurchase productPurchase)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(productPurchase.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/product-purchases/{productPurchaseId}",
			productPurchaseId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Page<ProductPurchase> getProjectProductPurchasesPage(
			Long projectId, Pagination pagination)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			getProjectProductPurchasesPageHttpResponse(projectId, pagination);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		return Page.of(content, ProductPurchaseSerDes::toDTO);
	}

	public static HttpInvoker.HttpResponse
			getProjectProductPurchasesPageHttpResponse(
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
			"http://localhost:8080/o/koroneiki-rest/v1.0/projects/{projectId}/product-purchases",
			projectId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static ProductPurchase postProjectProductPurchase(
			Long projectId, Long productId, ProductPurchase productPurchase)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			postProjectProductPurchaseHttpResponse(
				projectId, productId, productPurchase);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return ProductPurchaseSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse
			postProjectProductPurchaseHttpResponse(
				Long projectId, Long productId, ProductPurchase productPurchase)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(productPurchase.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		if (productId != null) {
			httpInvoker.parameter("productId", String.valueOf(productId));
		}

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/projects/{projectId}/product-purchases",
			projectId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	private static final Logger _logger = Logger.getLogger(
		ProductPurchaseResource.class.getName());

}