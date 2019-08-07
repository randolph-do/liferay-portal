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

package com.liferay.osb.koroneiki.phloem.rest.internal.odata.entity.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.CollectionEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Amos Fong
 */
public class ProjectEntityModel implements EntityModel {

	public static final String NAME = "Project";

	public ProjectEntityModel() {
		_entityFieldsMap = Stream.of(
			new StringEntityField("accountKey", locale -> "accountKey"),
			new EntityField(
				"code", EntityField.Type.STRING,
				locale -> Field.getSortableFieldName("code_String"),
				locale -> "code", String::valueOf),
			new CollectionEntityField(
				new StringEntityField("contactKeys", locale -> "contactKeys")),
			new CollectionEntityField(
				new StringEntityField(
					"contactProjectRoleKeys",
					locale -> "contactProjectRoleKeys")),
			new StringEntityField("name", locale -> "name"),
			new CollectionEntityField(
				new StringEntityField(
					"productKeys", locale -> "productEntryKeys"))
		).collect(
			Collectors.toMap(EntityField::getName, Function.identity())
		);
	}

	@Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}

	@Override
	public String getName() {
		return NAME;
	}

	private final Map<String, EntityField> _entityFieldsMap;

}