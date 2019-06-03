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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.Account;
import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.ExternalLink;
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
public class AccountSerDes {

	public static Account toDTO(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToDTO(json);
	}

	public static Account[] toDTOs(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Account account) {
		if (account == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (account.getDateCreated() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateCreated\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(account.getDateCreated()));

			sb.append("\"");
		}

		if (account.getDateModified() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateModified\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(account.getDateModified()));

			sb.append("\"");
		}

		if (account.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(account.getDescription()));

			sb.append("\"");
		}

		if (account.getExternalLinks() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalLinks\": ");

			sb.append("[");

			for (int i = 0; i < account.getExternalLinks().length; i++) {
				sb.append(String.valueOf(account.getExternalLinks()[i]));

				if ((i + 1) < account.getExternalLinks().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (account.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(account.getId());
		}

		if (account.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(account.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Account account) {
		if (account == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		map.put(
			"dateCreated",
			liferayToJSONDateFormat.format(account.getDateCreated()));

		map.put(
			"dateModified",
			liferayToJSONDateFormat.format(account.getDateModified()));

		if (account.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(account.getDescription()));
		}

		if (account.getExternalLinks() == null) {
			map.put("externalLinks", null);
		}
		else {
			map.put(
				"externalLinks", String.valueOf(account.getExternalLinks()));
		}

		if (account.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(account.getId()));
		}

		if (account.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(account.getName()));
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

	private static class AccountJSONParser extends BaseJSONParser<Account> {

		@Override
		protected Account createDTO() {
			return new Account();
		}

		@Override
		protected Account[] createDTOArray(int size) {
			return new Account[size];
		}

		@Override
		protected void setField(
			Account account, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "dateCreated")) {
				if (jsonParserFieldValue != null) {
					account.setDateCreated(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateModified")) {
				if (jsonParserFieldValue != null) {
					account.setDateModified(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					account.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "externalLinks")) {
				if (jsonParserFieldValue != null) {
					account.setExternalLinks(
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
					account.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					account.setName((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}