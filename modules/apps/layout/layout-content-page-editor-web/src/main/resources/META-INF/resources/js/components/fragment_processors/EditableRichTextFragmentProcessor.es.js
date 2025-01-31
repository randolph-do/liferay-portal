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

import {EventHandler} from 'metal-events';
import {FLOATING_TOOLBAR_BUTTONS} from '../../utils/constants';
import {object} from 'metal';

const KEY_ENTER = 13;

let _destroyedCallback = null;
let _editableElement = null;
let _editor = null;
let _editorEventHandler = null;

/**
 * Destroys, if any, an existing instance of AlloyEditor.
 */
function destroy() {
	if (_editor) {
		_editorEventHandler.removeAllListeners();
		_editorEventHandler.dispose();

		const editorData = _editor.get('nativeEditor').getData();

		_editableElement.innerHTML = editorData;

		_editor.destroy();

		_editableElement = null;
		_editor = null;
		_editorEventHandler = null;

		_destroyedCallback();
		_destroyedCallback = null;
	}
}

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

	const mapButton = Object.assign({}, FLOATING_TOOLBAR_BUTTONS.map);

	if (editableValues.fieldId || editableValues.mappedField) {
		mapButton.cssClass = 'fragments-editor__floating-toolbar--mapped-field';
	}

	buttons.push(mapButton);

	return buttons;
}

/**
 * Returns the existing editable element or null.
 * @returns {HTMLElement|null}
 */
function getActiveEditableElement() {
	return _editableElement;
}

/**
 * Creates an instance of AlloyEditor and destroys the existing one if any.
 * @param {HTMLElement} editableElement
 * @param {string} fragmentEntryLinkId
 * @param {string} portletNamespace
 * @param {Object} options
 * @param {function} changedCallback
 * @param {function} destroyedCallback
 */
function init(
	editableElement,
	fragmentEntryLinkId,
	portletNamespace,
	options,
	changedCallback,
	destroyedCallback
) {
	destroy();

	const {defaultEditorConfiguration} = options;
	const editableContent = editableElement.innerHTML;
	const wrapper = document.createElement('div');

	wrapper.dataset.lfrEditableId = editableElement.id;
	wrapper.innerHTML = editableContent;

	const editorName = `${portletNamespace}FragmentEntryLinkEditable_${editableElement.id}`;

	wrapper.setAttribute('id', editorName);
	wrapper.setAttribute('name', editorName);

	editableElement.innerHTML = '';
	editableElement.appendChild(wrapper);

	_editableElement = editableElement;
	_editorEventHandler = new EventHandler();
	_destroyedCallback = destroyedCallback;

	_editor = AlloyEditor.editable(
		wrapper,
		_getEditorConfiguration(
			editableElement,
			portletNamespace,
			fragmentEntryLinkId,
			defaultEditorConfiguration,
			editorName
		)
	);

	const nativeEditor = _editor.get('nativeEditor');

	_editorEventHandler.add(nativeEditor.on('key', _handleNativeEditorKey));

	_editorEventHandler.add(
		nativeEditor.on('change', () => changedCallback(nativeEditor.getData()))
	);

	_editorEventHandler.add(
		nativeEditor.on('actionPerformed', () =>
			changedCallback(nativeEditor.getData())
		)
	);

	_editorEventHandler.add(
		nativeEditor.on('blur', () => {
			if (_editor._mainUI.state.hidden) {
				requestAnimationFrame(destroy);
			}
		})
	);

	_editorEventHandler.add(
		nativeEditor.on('instanceReady', () => nativeEditor.focus())
	);
}

/**
 * @param {string} content editableField's original HTML
 * @param {string} value Translated/segmented value
 * @return {string} Transformed content
 */
function render(content, value) {
	return value;
}

/**
 * Returns a configuration object for a AlloyEditor instance.
 * @param {HTMLElement} editableElement
 * @param {string} portletNamespace
 * @param {string} fragmentEntryLinkId
 * @param {object} defaultEditorConfiguration
 * @param {string} editorName
 * @return {object}
 */
function _getEditorConfiguration(
	editableElement,
	portletNamespace,
	fragmentEntryLinkId,
	defaultEditorConfiguration,
	editorName
) {
	return object.mixin({}, defaultEditorConfiguration.editorConfig || {}, {
		filebrowserImageBrowseLinkUrl: defaultEditorConfiguration.editorConfig.filebrowserImageBrowseLinkUrl.replace(
			'_EDITOR_NAME_',
			editorName
		),

		filebrowserImageBrowseUrl: defaultEditorConfiguration.editorConfig.filebrowserImageBrowseUrl.replace(
			'_EDITOR_NAME_',
			editorName
		),

		title: editorName
	});
}

/**
 * Handle native editor key presses.
 * It avoids including line breaks on text editors.
 * @param {Event} event
 * @private
 * @review
 */
function _handleNativeEditorKey(event) {
	if (
		event.data.keyCode === KEY_ENTER &&
		_editableElement &&
		_editableElement.getAttribute('type') === 'text'
	) {
		event.cancel();
	}
}

export {
	destroy,
	getActiveEditableElement,
	getFloatingToolbarButtons,
	init,
	render
};

export default {
	destroy,
	getActiveEditableElement,
	getFloatingToolbarButtons,
	init,
	render
};
