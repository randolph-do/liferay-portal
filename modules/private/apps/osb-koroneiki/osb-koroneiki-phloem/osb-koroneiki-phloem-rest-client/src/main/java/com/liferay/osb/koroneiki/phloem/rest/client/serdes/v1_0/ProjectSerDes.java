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
import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.Project;
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
public class ProjectSerDes {

	public static Project toDTO(String json) {
		ProjectJSONParser projectJSONParser = new ProjectJSONParser();

		return projectJSONParser.parseToDTO(json);
	}

	public static Project[] toDTOs(String json) {
		ProjectJSONParser projectJSONParser = new ProjectJSONParser();

		return projectJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Project project) {
		if (project == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (project.getAccountId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountId\": ");

			sb.append(project.getAccountId());
		}

		if (project.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(project.getCode()));

			sb.append("\"");
		}

		if (project.getDateCreated() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateCreated\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(project.getDateCreated()));

			sb.append("\"");
		}

		if (project.getDateModified() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateModified\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(project.getDateModified()));

			sb.append("\"");
		}

		if (project.getExternalLinks() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalLinks\": ");

			sb.append("[");

			for (int i = 0; i < project.getExternalLinks().length; i++) {
				sb.append(String.valueOf(project.getExternalLinks()[i]));

				if ((i + 1) < project.getExternalLinks().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (project.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(project.getId());
		}

		if (project.getIndustry() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"industry\": ");

			sb.append("\"");

			sb.append(_escape(project.getIndustry()));

			sb.append("\"");
		}

		if (project.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(project.getName()));

			sb.append("\"");
		}

		if (project.getNotes() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"notes\": ");

			sb.append("\"");

			sb.append(_escape(project.getNotes()));

			sb.append("\"");
		}

		if (project.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(project.getStatus()));

			sb.append("\"");
		}

		if (project.getTier() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tier\": ");

			sb.append("\"");

			sb.append(_escape(project.getTier()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProjectJSONParser projectJSONParser = new ProjectJSONParser();

		return projectJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Project project) {
		if (project == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (project.getAccountId() == null) {
			map.put("accountId", null);
		}
		else {
			map.put("accountId", String.valueOf(project.getAccountId()));
		}

		if (project.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(project.getCode()));
		}

		map.put(
			"dateCreated",
			liferayToJSONDateFormat.format(project.getDateCreated()));

		map.put(
			"dateModified",
			liferayToJSONDateFormat.format(project.getDateModified()));

		if (project.getExternalLinks() == null) {
			map.put("externalLinks", null);
		}
		else {
			map.put(
				"externalLinks", String.valueOf(project.getExternalLinks()));
		}

		if (project.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(project.getId()));
		}

		if (project.getIndustry() == null) {
			map.put("industry", null);
		}
		else {
			map.put("industry", String.valueOf(project.getIndustry()));
		}

		if (project.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(project.getName()));
		}

		if (project.getNotes() == null) {
			map.put("notes", null);
		}
		else {
			map.put("notes", String.valueOf(project.getNotes()));
		}

		if (project.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(project.getStatus()));
		}

		if (project.getTier() == null) {
			map.put("tier", null);
		}
		else {
			map.put("tier", String.valueOf(project.getTier()));
		}

		return map;
	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
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

	private static class ProjectJSONParser extends BaseJSONParser<Project> {

		@Override
		protected Project createDTO() {
			return new Project();
		}

		@Override
		protected Project[] createDTOArray(int size) {
			return new Project[size];
		}

		@Override
		protected void setField(
			Project project, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "accountId")) {
				if (jsonParserFieldValue != null) {
					project.setAccountId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					project.setCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateCreated")) {
				if (jsonParserFieldValue != null) {
					project.setDateCreated(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateModified")) {
				if (jsonParserFieldValue != null) {
					project.setDateModified(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "externalLinks")) {
				if (jsonParserFieldValue != null) {
					project.setExternalLinks(
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
					project.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "industry")) {
				if (jsonParserFieldValue != null) {
					project.setIndustry((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					project.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "notes")) {
				if (jsonParserFieldValue != null) {
					project.setNotes((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					project.setStatus((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tier")) {
				if (jsonParserFieldValue != null) {
					project.setTier((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}