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

import {destroy, init} from './EditableRichTextFragmentProcessor.es';
import {FLOATING_TOOLBAR_BUTTONS} from '../../utils/constants';

/**
 * @param {object} editableValues
 * @return {object[]} Floating toolbar panels
 */
function getFloatingToolbarButtons(editableValues) {
	const buttons = [];

	if (editableValues.mappedField || editableValues.fieldId) {
		const textPropertiesButton = FLOATING_TOOLBAR_BUTTONS.textProperties;

		textPropertiesButton.cssClass =
			'fragments-editor__floating-toolbar--mapped-field';

		buttons.push(textPropertiesButton);
	} else {
		buttons.push(FLOATING_TOOLBAR_BUTTONS.edit);
	}

	const linkButton = Object.assign({}, FLOATING_TOOLBAR_BUTTONS.link);

	if (
		editableValues.config &&
		(editableValues.config.fieldId ||
			editableValues.config.href ||
			editableValues.config.mappedField)
	) {
		linkButton.cssClass =
			'fragments-editor__floating-toolbar--linked-field';
	}

	buttons.push(linkButton);

	const mapButton = Object.assign({}, FLOATING_TOOLBAR_BUTTONS.map);

	if (editableValues.fieldId || editableValues.mappedField) {
		mapButton.cssClass = 'fragments-editor__floating-toolbar--mapped-field';
	}

	buttons.push(mapButton);

	return buttons;
}

/**
 * @param {string} content editableField's original HTML
 * @param {string} value Translated/segmented value
 * @return {string} Transformed content
 */
function render(content, value, editableValues) {
	if (editableValues && editableValues.config && editableValues.config.href) {
		const link = document.createElement('a');
		const {config} = editableValues;

		link.innerHTML = value;

		link.href = config.href;

		if (config.target) {
			link.target = config.target;
		}

		return link.outerHTML;
	}

	return value;
}

export {getFloatingToolbarButtons, render};

export default {
	destroy,
	getFloatingToolbarButtons,
	init,
	render
};
