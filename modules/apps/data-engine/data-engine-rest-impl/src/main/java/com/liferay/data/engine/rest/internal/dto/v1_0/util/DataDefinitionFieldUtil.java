/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.data.engine.rest.internal.dto.v1_0.util;

import com.liferay.data.engine.rest.dto.v1_0.DataDefinitionField;
import com.liferay.data.engine.spi.dto.SPIDataDefinitionField;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.vulcan.util.TransformUtil;

/**
 * @author Leonardo Barros
 */
public class DataDefinitionFieldUtil {

	public static DataDefinitionField toDataDefinitionField(
		SPIDataDefinitionField spiDataDefinitionField) {

		return new DataDefinitionField() {
			{
				customProperties = spiDataDefinitionField.getCustomProperties();
				defaultValue = spiDataDefinitionField.getDefaultValue();
				fieldType = spiDataDefinitionField.getFieldType();
				id = spiDataDefinitionField.getId();
				indexable = spiDataDefinitionField.getIndexable();
				label = spiDataDefinitionField.getLabel();
				localizable = spiDataDefinitionField.getLocalizable();
				name = spiDataDefinitionField.getName();
				nestedDataDefinitionFields = TransformUtil.transform(
					spiDataDefinitionField.getNestedSPIDataDefinitionFields(),
					DataDefinitionFieldUtil::toDataDefinitionField,
					SPIDataDefinitionField.class);
				repeatable = spiDataDefinitionField.getRepeatable();
				tip = spiDataDefinitionField.getTip();
			}
		};
	}

	public static SPIDataDefinitionField toSPIDataDefinitionField(
		DataDefinitionField dataDefinitionField) {

		SPIDataDefinitionField spiDataDefinitionField =
			new SPIDataDefinitionField();

		spiDataDefinitionField.setCustomProperties(
			dataDefinitionField.getCustomProperties());
		spiDataDefinitionField.setDefaultValue(
			dataDefinitionField.getDefaultValue());
		spiDataDefinitionField.setFieldType(dataDefinitionField.getFieldType());
		spiDataDefinitionField.setId(
			GetterUtil.getLong(dataDefinitionField.getId()));
		spiDataDefinitionField.setIndexable(
			GetterUtil.getBoolean(dataDefinitionField.getIndexable()));
		spiDataDefinitionField.setLabel(dataDefinitionField.getLabel());
		spiDataDefinitionField.setLocalizable(
			GetterUtil.getBoolean(dataDefinitionField.getLocalizable()));
		spiDataDefinitionField.setName(dataDefinitionField.getName());
		spiDataDefinitionField.setNestedSPIDataDefinitionFields(
			TransformUtil.transform(
				dataDefinitionField.getNestedDataDefinitionFields(),
				DataDefinitionFieldUtil::toSPIDataDefinitionField,
				DataDefinitionField.class));
		spiDataDefinitionField.setRepeatable(
			GetterUtil.getBoolean(dataDefinitionField.getRepeatable()));
		spiDataDefinitionField.setTip(dataDefinitionField.getTip());

		return spiDataDefinitionField;
	}

}