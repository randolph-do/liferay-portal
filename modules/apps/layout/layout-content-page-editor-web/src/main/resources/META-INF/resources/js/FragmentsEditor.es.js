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

import Component from 'metal-component';
import dom from 'metal-dom';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import './components/mapping_type/SelectMappingDialog.es';
import './components/mapping_type/SelectMappingTypeDialog.es';
import './components/fragment_entry_link/FragmentEntryLinkList.es';
import './components/sidebar/FragmentsEditorSidebar.es';
import './components/toolbar/FragmentsEditorToolbar.es';
import {
	CLEAR_ACTIVE_ITEM,
	CLEAR_HOVERED_ITEM,
	UPDATE_ACTIVE_ITEM,
	UPDATE_HOVERED_ITEM
} from './actions/actions.es';
import {INITIAL_STATE} from './store/state.es';
import {
	startListeningWidgetConfigurationChange,
	stopListeningWidgetConfigurationChange
} from './utils/FragmentsEditorDialogUtils';
import {Store} from './store/store.es';
import templates from './FragmentsEditor.soy';

/**
 * FragmentsEditor
 * @review
 */
class FragmentsEditor extends Component {
	/**
	 * @param {KeyboardEvent|MouseEvent} event
	 * @return {{fragmentsEditorItemId: string|null, fragmentsEditorItemType: string|null}}
	 * @private
	 * @review
	 */
	static _getItemTarget(event) {
		let {fragmentsEditorItemId = null, fragmentsEditorItemType = null} =
			event.target.dataset || {};

		if (!fragmentsEditorItemId || !fragmentsEditorItemType) {
			const parent = dom.closest(
				event.target,
				'[data-fragments-editor-item-id]'
			);

			if (parent) {
				fragmentsEditorItemId = parent.dataset.fragmentsEditorItemId;
				fragmentsEditorItemType =
					parent.dataset.fragmentsEditorItemType;
			}
		}

		return {
			fragmentsEditorItemId,
			fragmentsEditorItemType
		};
	}

	/**
	 * @inheritdoc
	 * @review
	 */
	created() {
		this._handleDocumentClick = this._handleDocumentClick.bind(this);
		this._handleDocumentKeyDown = this._handleDocumentKeyDown.bind(this);
		this._handleDocumentKeyUp = this._handleDocumentKeyUp.bind(this);
		this._handleDocumentMouseOver = this._handleDocumentMouseOver.bind(
			this
		);

		document.addEventListener('click', this._handleDocumentClick, true);
		document.addEventListener('keydown', this._handleDocumentKeyDown);
		document.addEventListener('keyup', this._handleDocumentKeyUp);
		document.addEventListener('mouseover', this._handleDocumentMouseOver);
	}

	/**
	 * @inheritdoc
	 * @review
	 */
	disposed() {
		document.removeEventListener('click', this._handleDocumentClick, true);
		document.removeEventListener('keyup', this._handleDocumentKeyUp);
		document.removeEventListener(
			'mouseover',
			this._handleDocumentMouseOver
		);

		stopListeningWidgetConfigurationChange();
	}

	/**
	 * @inheritdoc
	 * @review
	 */
	syncStore() {
		if (this.store) {
			startListeningWidgetConfigurationChange(this.store);
		}
	}

	/**
	 * @param {MouseEvent} event
	 * @private
	 * @review
	 */
	_handleDocumentClick(event) {
		this._updateActiveItem(event);
	}

	/**
	 * @param {KeyboardEvent} event
	 * @private
	 * @review
	 */
	_handleDocumentKeyDown(event) {
		this._shiftPressed = event.shiftKey;
	}

	/**
	 * @param {KeyboardEvent} event
	 * @private
	 * @review
	 */
	_handleDocumentKeyUp(event) {
		this._shiftPressed = event.shiftKey;

		if (event.key !== 'Shift') {
			this._updateActiveItem(event);
		}
	}

	/**
	 * @param {MouseEvent} event
	 * @private
	 * @review
	 */
	_handleDocumentMouseOver(event) {
		const {
			fragmentsEditorItemId,
			fragmentsEditorItemType
		} = FragmentsEditor._getItemTarget(event);

		if (fragmentsEditorItemId && fragmentsEditorItemType && this.store) {
			this.store.dispatch({
				hoveredItemId: fragmentsEditorItemId,
				hoveredItemType: fragmentsEditorItemType,
				type: UPDATE_HOVERED_ITEM
			});
		} else if (this.store) {
			this.store.dispatch({
				type: CLEAR_HOVERED_ITEM
			});
		}
	}

	/**
	 * @param {KeyboardEvent|MouseEvent} event
	 * @private
	 * @review
	 */
	_updateActiveItem(event) {
		const {
			fragmentsEditorItemId,
			fragmentsEditorItemType
		} = FragmentsEditor._getItemTarget(event);

		if (fragmentsEditorItemId && fragmentsEditorItemType) {
			this.store.dispatch({
				activeItemId: fragmentsEditorItemId,
				activeItemType: fragmentsEditorItemType,
				appendItem: this._shiftPressed,
				type: UPDATE_ACTIVE_ITEM
			});
		} else if (dom.closest(event.target, '.fragment-entry-link-list')) {
			this.store.dispatch({
				type: CLEAR_ACTIVE_ITEM
			});
		}
	}
}

/**
 * State definition.
 * @review
 * @static
 * @type {object}
 */
FragmentsEditor.STATE = Object.assign(
	{
		/**
		 * @default false
		 * @instance
		 * @memberOf FragmentsEditor
		 * @private
		 * @review
		 * @type {boolean}
		 */
		_shiftPressed: Config.bool()
			.internal()
			.value(false),

		/**
		 * Store instance
		 * @default undefined
		 * @instance
		 * @memberOf FragmentsEditor
		 * @review
		 * @type {Store}
		 */
		store: Config.instanceOf(Store)
	},
	INITIAL_STATE
);

Soy.register(FragmentsEditor, templates);

export {FragmentsEditor};
export default FragmentsEditor;
