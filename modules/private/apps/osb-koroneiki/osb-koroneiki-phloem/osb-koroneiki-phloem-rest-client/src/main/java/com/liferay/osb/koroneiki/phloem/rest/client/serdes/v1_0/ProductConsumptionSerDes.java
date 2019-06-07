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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.ExternalLink;
import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.ProductConsumption;
import com.liferay.osb.koroneiki.phloem.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public class ProductConsumptionSerDes {

	public static ProductConsumption toDTO(String json) {
		ProductConsumptionJSONParser productConsumptionJSONParser =
			new ProductConsumptionJSONParser();

		return productConsumptionJSONParser.parseToDTO(json);
	}

	public static ProductConsumption[] toDTOs(String json) {
		ProductConsumptionJSONParser productConsumptionJSONParser =
			new ProductConsumptionJSONParser();

		return productConsumptionJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ProductConsumption productConsumption) {
		if (productConsumption == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (productConsumption.getAccountId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountId\": ");

			sb.append(productConsumption.getAccountId());
		}

		if (productConsumption.getDateCreated() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateCreated\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					productConsumption.getDateCreated()));

			sb.append("\"");
		}

		if (productConsumption.getExternalLinks() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalLinks\": ");

			sb.append("[");

			for (int i = 0; i < productConsumption.getExternalLinks().length;
				 i++) {

				sb.append(
					String.valueOf(productConsumption.getExternalLinks()[i]));

				if ((i + 1) < productConsumption.getExternalLinks().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (productConsumption.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(productConsumption.getId());
		}

		if (productConsumption.getProductId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"productId\": ");

			sb.append(productConsumption.getProductId());
		}

		if (productConsumption.getProjectId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectId\": ");

			sb.append(productConsumption.getProjectId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProductConsumptionJSONParser productConsumptionJSONParser =
			new ProductConsumptionJSONParser();

		return productConsumptionJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ProductConsumption productConsumption) {

		if (productConsumption == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (productConsumption.getAccountId() == null) {
			map.put("accountId", null);
		}
		else {
			map.put(
				"accountId", String.valueOf(productConsumption.getAccountId()));
		}

		map.put(
			"dateCreated",
			liferayToJSONDateFormat.format(
				productConsumption.getDateCreated()));

		if (productConsumption.getExternalLinks() == null) {
			map.put("externalLinks", null);
		}
		else {
			map.put(
				"externalLinks",
				String.valueOf(productConsumption.getExternalLinks()));
		}

		if (productConsumption.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(productConsumption.getId()));
		}

		if (productConsumption.getProductId() == null) {
			map.put("productId", null);
		}
		else {
			map.put(
				"productId", String.valueOf(productConsumption.getProductId()));
		}

		if (productConsumption.getProjectId() == null) {
			map.put("projectId", null);
		}
		else {
			map.put(
				"projectId", String.valueOf(productConsumption.getProjectId()));
		}

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

	private static class ProductConsumptionJSONParser
		extends BaseJSONParser<ProductConsumption> {

		@Override
		protected ProductConsumption createDTO() {
			return new ProductConsumption();
		}

		@Override
		protected ProductConsumption[] createDTOArray(int size) {
			return new ProductConsumption[size];
		}

		@Override
		protected void setField(
			ProductConsumption productConsumption, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "accountId")) {
				if (jsonParserFieldValue != null) {
					productConsumption.setAccountId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateCreated")) {
				if (jsonParserFieldValue != null) {
					productConsumption.setDateCreated(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "externalLinks")) {
				if (jsonParserFieldValue != null) {
					productConsumption.setExternalLinks(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ExternalLinkSerDes.toDTO((String)object)
						).toArray(
							size -> new ExternalLink[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					productConsumption.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "productId")) {
				if (jsonParserFieldValue != null) {
					productConsumption.setProductId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectId")) {
				if (jsonParserFieldValue != null) {
					productConsumption.setProjectId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}