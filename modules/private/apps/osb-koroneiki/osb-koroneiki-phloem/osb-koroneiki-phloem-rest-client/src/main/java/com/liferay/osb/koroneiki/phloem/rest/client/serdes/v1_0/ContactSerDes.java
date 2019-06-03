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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.Contact;
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
public class ContactSerDes {

	public static Contact toDTO(String json) {
		ContactJSONParser contactJSONParser = new ContactJSONParser();

		return contactJSONParser.parseToDTO(json);
	}

	public static Contact[] toDTOs(String json) {
		ContactJSONParser contactJSONParser = new ContactJSONParser();

		return contactJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Contact contact) {
		if (contact == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (contact.getDateCreated() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateCreated\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(contact.getDateCreated()));

			sb.append("\"");
		}

		if (contact.getDateModified() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateModified\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(contact.getDateModified()));

			sb.append("\"");
		}

		if (contact.getEmailAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emailAddress\": ");

			sb.append("\"");

			sb.append(_escape(contact.getEmailAddress()));

			sb.append("\"");
		}

		if (contact.getExternalLinks() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalLinks\": ");

			sb.append("[");

			for (int i = 0; i < contact.getExternalLinks().length; i++) {
				sb.append(String.valueOf(contact.getExternalLinks()[i]));

				if ((i + 1) < contact.getExternalLinks().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (contact.getFirstName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstName\": ");

			sb.append("\"");

			sb.append(_escape(contact.getFirstName()));

			sb.append("\"");
		}

		if (contact.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(contact.getId());
		}

		if (contact.getLanguageId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"languageId\": ");

			sb.append("\"");

			sb.append(_escape(contact.getLanguageId()));

			sb.append("\"");
		}

		if (contact.getLastName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastName\": ");

			sb.append("\"");

			sb.append(_escape(contact.getLastName()));

			sb.append("\"");
		}

		if (contact.getMiddleName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"middleName\": ");

			sb.append("\"");

			sb.append(_escape(contact.getMiddleName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ContactJSONParser contactJSONParser = new ContactJSONParser();

		return contactJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Contact contact) {
		if (contact == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		map.put(
			"dateCreated",
			liferayToJSONDateFormat.format(contact.getDateCreated()));

		map.put(
			"dateModified",
			liferayToJSONDateFormat.format(contact.getDateModified()));

		if (contact.getEmailAddress() == null) {
			map.put("emailAddress", null);
		}
		else {
			map.put("emailAddress", String.valueOf(contact.getEmailAddress()));
		}

		if (contact.getExternalLinks() == null) {
			map.put("externalLinks", null);
		}
		else {
			map.put(
				"externalLinks", String.valueOf(contact.getExternalLinks()));
		}

		if (contact.getFirstName() == null) {
			map.put("firstName", null);
		}
		else {
			map.put("firstName", String.valueOf(contact.getFirstName()));
		}

		if (contact.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(contact.getId()));
		}

		if (contact.getLanguageId() == null) {
			map.put("languageId", null);
		}
		else {
			map.put("languageId", String.valueOf(contact.getLanguageId()));
		}

		if (contact.getLastName() == null) {
			map.put("lastName", null);
		}
		else {
			map.put("lastName", String.valueOf(contact.getLastName()));
		}

		if (contact.getMiddleName() == null) {
			map.put("middleName", null);
		}
		else {
			map.put("middleName", String.valueOf(contact.getMiddleName()));
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

	private static class ContactJSONParser extends BaseJSONParser<Contact> {

		@Override
		protected Contact createDTO() {
			return new Contact();
		}

		@Override
		protected Contact[] createDTOArray(int size) {
			return new Contact[size];
		}

		@Override
		protected void setField(
			Contact contact, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "dateCreated")) {
				if (jsonParserFieldValue != null) {
					contact.setDateCreated(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateModified")) {
				if (jsonParserFieldValue != null) {
					contact.setDateModified(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "emailAddress")) {
				if (jsonParserFieldValue != null) {
					contact.setEmailAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "externalLinks")) {
				if (jsonParserFieldValue != null) {
					contact.setExternalLinks(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ExternalLinkSerDes.toDTO((String)object)
						).toArray(
							size -> new ExternalLink[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "firstName")) {
				if (jsonParserFieldValue != null) {
					contact.setFirstName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					contact.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "languageId")) {
				if (jsonParserFieldValue != null) {
					contact.setLanguageId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lastName")) {
				if (jsonParserFieldValue != null) {
					contact.setLastName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "middleName")) {
				if (jsonParserFieldValue != null) {
					contact.setMiddleName((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}