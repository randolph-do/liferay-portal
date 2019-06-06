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

package com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.ProductPurchase;
import com.liferay.osb.koroneiki.phloem.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public class ProductPurchaseSerDes {

	public static ProductPurchase toDTO(String json) {
		ProductPurchaseJSONParser productPurchaseJSONParser =
			new ProductPurchaseJSONParser();

		return productPurchaseJSONParser.parseToDTO(json);
	}

	public static ProductPurchase[] toDTOs(String json) {
		ProductPurchaseJSONParser productPurchaseJSONParser =
			new ProductPurchaseJSONParser();

		return productPurchaseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ProductPurchase productPurchase) {
		if (productPurchase == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (productPurchase.getAccountId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountId\": ");

			sb.append(productPurchase.getAccountId());
		}

		if (productPurchase.getDateCreated() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateCreated\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					productPurchase.getDateCreated()));

			sb.append("\"");
		}

		if (productPurchase.getEndDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"endDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(productPurchase.getEndDate()));

			sb.append("\"");
		}

		if (productPurchase.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(productPurchase.getId());
		}

		if (productPurchase.getProductId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"productId\": ");

			sb.append(productPurchase.getProductId());
		}

		if (productPurchase.getProjectId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectId\": ");

			sb.append(productPurchase.getProjectId());
		}

		if (productPurchase.getProperties() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"properties\": ");

			sb.append(_toJSON(productPurchase.getProperties()));
		}

		if (productPurchase.getQuantity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"quantity\": ");

			sb.append(productPurchase.getQuantity());
		}

		if (productPurchase.getStartDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(productPurchase.getStartDate()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProductPurchaseJSONParser productPurchaseJSONParser =
			new ProductPurchaseJSONParser();

		return productPurchaseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ProductPurchase productPurchase) {
		if (productPurchase == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (productPurchase.getAccountId() == null) {
			map.put("accountId", null);
		}
		else {
			map.put(
				"accountId", String.valueOf(productPurchase.getAccountId()));
		}

		map.put(
			"dateCreated",
			liferayToJSONDateFormat.format(productPurchase.getDateCreated()));

		map.put(
			"endDate",
			liferayToJSONDateFormat.format(productPurchase.getEndDate()));

		if (productPurchase.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(productPurchase.getId()));
		}

		if (productPurchase.getProductId() == null) {
			map.put("productId", null);
		}
		else {
			map.put(
				"productId", String.valueOf(productPurchase.getProductId()));
		}

		if (productPurchase.getProjectId() == null) {
			map.put("projectId", null);
		}
		else {
			map.put(
				"projectId", String.valueOf(productPurchase.getProjectId()));
		}

		if (productPurchase.getProperties() == null) {
			map.put("properties", null);
		}
		else {
			map.put(
				"properties", String.valueOf(productPurchase.getProperties()));
		}

		if (productPurchase.getQuantity() == null) {
			map.put("quantity", null);
		}
		else {
			map.put("quantity", String.valueOf(productPurchase.getQuantity()));
		}

		map.put(
			"startDate",
			liferayToJSONDateFormat.format(productPurchase.getStartDate()));

		return map;
	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		string = string.replace("\\", "\\\\");

		return string.replace("\"", "\\\"");
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static class ProductPurchaseJSONParser
		extends BaseJSONParser<ProductPurchase> {

		@Override
		protected ProductPurchase createDTO() {
			return new ProductPurchase();
		}

		@Override
		protected ProductPurchase[] createDTOArray(int size) {
			return new ProductPurchase[size];
		}

		@Override
		protected void setField(
			ProductPurchase productPurchase, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "accountId")) {
				if (jsonParserFieldValue != null) {
					productPurchase.setAccountId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateCreated")) {
				if (jsonParserFieldValue != null) {
					productPurchase.setDateCreated(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "endDate")) {
				if (jsonParserFieldValue != null) {
					productPurchase.setEndDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					productPurchase.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "productId")) {
				if (jsonParserFieldValue != null) {
					productPurchase.setProductId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectId")) {
				if (jsonParserFieldValue != null) {
					productPurchase.setProjectId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "properties")) {
				if (jsonParserFieldValue != null) {
					productPurchase.setProperties(
						(Map)ProductPurchaseSerDes.toMap(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "quantity")) {
				if (jsonParserFieldValue != null) {
					productPurchase.setQuantity(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "startDate")) {
				if (jsonParserFieldValue != null) {
					productPurchase.setStartDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}