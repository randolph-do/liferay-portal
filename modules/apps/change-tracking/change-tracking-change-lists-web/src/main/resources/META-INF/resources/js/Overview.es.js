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

import 'clay-icon';
import {PortletBase, fetch, openToast} from 'frontend-js-web';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './Overview.soy';
import {PublishChangeList} from './PublishChangeList.es';

const SPLIT_REGEX = /({\d+})/g;

/**
 * Provides the component for the Overview configuration screen.
 */
class Overview extends PortletBase {
	created() {
		this._render();

		this._fetchProductionCollection();
	}

	_checkoutCollection(ctCollectionId, production) {
		const init = {
			headers: {
				'content-type': 'application/json'
			},
			method: 'POST'
		};

		const url =
			this.urlCollectionsBase +
			'/' +
			ctCollectionId +
			'/checkout?companyId=' +
			Liferay.ThemeDisplay.getCompanyId() +
			'&userId=' +
			Liferay.ThemeDisplay.getUserId();

		fetch(url, init)
			.then(response => {
				if (response.status === 202) {
					Liferay.fire('refreshChangeTrackingIndicator');

					if (production) {
						Liferay.Util.navigate(this.urlSelectProduction);
					} else {
						this._render();
					}
				} else if (response.status === 400) {
					response.json().then(data => {
						openToast({
							message: Liferay.Util.sub(
								Liferay.Language.get(
									'an-error-occured-when-trying-to-check-x-out-x'
								),
								this.changeListName,
								data.message
							),
							title: Liferay.Language.get('error'),
							type: 'danger'
						});
					});
				}
			})
			.catch(error => {
				const message =
					typeof error === 'string'
						? error
						: Liferay.Util.sub(
								Liferay.Language.get(
									'an-error-occured-when-trying-to-check-x-out'
								),
								this.changeListName
						  );

				openToast({
					message,
					title: Liferay.Language.get('error'),
					type: 'danger'
				});
			});
	}

	_fetchProductionCollection() {
		const url =
			this.urlCollectionsBase +
			'?companyId=' +
			Liferay.ThemeDisplay.getCompanyId() +
			'&type=production';

		fetch(url)
			.then(r => r.json())
			.then(response => {
				this.productionCTCollectionId = response[0].ctCollectionId;
			});
	}

	_fetchAll(urls) {
		return Promise.all(
			urls.map(url =>
				fetch(url)
					.then(r => r.json())
					.then(data => data)
					.catch(error => {
						const message =
							typeof error === 'string'
								? error
								: Liferay.Util.sub(
										Liferay.Language.get(
											'an-error-occured-while-getting-data-from-x'
										),
										url
								  );

						openToast({
							message,
							title: Liferay.Language.get('error'),
							type: 'danger'
						});
					})
			)
		);
	}

	_fetchRecentCollections(url) {
		fetch(url)
			.then(r => r.json())
			.then(response => this._populateChangeListsDropdown(response))
			.catch(error => {
				const message =
					typeof error === 'string'
						? error
						: Liferay.Util.sub(
								Liferay.Language.get(
									'an-error-occured-while-getting-data-from-x'
								),
								url
						  );

				openToast({
					message,
					title: Liferay.Language.get('error'),
					type: 'danger'
				});
			});
	}

	_handleClickPublish() {
		new PublishChangeList({
			changeListDescription: this.descriptionActiveChangeList,
			changeListHasCollision: this.hasCollision,
			changeListName: this.headerTitleActiveChangeList,
			spritemap: themeDisplay.getPathThemeImages() + '/lexicon/icons.svg',
			urlChangeListsHistory: this.urlChangeListsHistory,
			urlCheckoutProduction:
				this.urlCollectionsBase +
				'/' +
				this.productionCTCollectionId +
				'/checkout?companyId=' +
				Liferay.ThemeDisplay.getCompanyId() +
				'&userId=' +
				Liferay.ThemeDisplay.getUserId(),
			urlPublishChangeList: this.urlActiveCollectionPublish
		});
	}

	_handleClickRecentCollections(event) {
		event.preventDefault();

		let ok = true;

		if (this.checkoutConfirmationEnabled) {
			const label = this._sub(
				Liferay.Language.get('do-you-want-to-switch-to-x-change-list'),
				[event.target.text]
			);
			ok = confirm(label);
		}

		if (ok) {
			const collectionId = event.target.getAttribute(
				'data-collection-id'
			);

			const production = event.target.getAttribute('data-production');

			this._checkoutCollection(collectionId, production);
		}
	}

	_handleClickTrash() {
		let ok = false;

		const label = this._sub(
			Liferay.Language.get(
				'are-you-sure-you-want-to-delete-x-change-list'
			),
			[this.headerTitleActiveChangeList]
		);

		ok = confirm(label);

		if (ok) {
			const init = {
				method: 'DELETE'
			};

			const url =
				this.urlCollectionsBase + '/' + this.activeCTCollectionId;

			fetch(url, init)
				.then(response => {
					if (response.status === 204) {
						Liferay.Util.navigate(this.urlSelectProduction);
					} else if (response.status === 404) {
						openToast({
							message: this._sub(
								Liferay.Language.get(
									'unable-to-delete-change-list-x-because-it-could-not-be-found'
								),
								[this.headerTitleActiveChangeList]
							),
							title: Liferay.Language.get('error'),
							type: 'danger'
						});
					}
				})
				.catch(error => {
					const message =
						typeof error === 'string'
							? error
							: this._sub(
									Liferay.Language.get(
										'an-error-occured-when-trying-to-delete-x'
									),
									[this.headerTitleActiveChangeList]
							  );

					openToast({
						message,
						title: Liferay.Language.get('error'),
						type: 'danger'
					});
				});
		}
	}

	_populateChangeListsDropdown(collectionResults) {
		this.changeListsDropdownMenu = [];

		collectionResults.forEach(ctCollection => {
			this.changeListsDropdownMenu.push({
				ctCollectionId: ctCollection.ctCollectionId,
				label: ctCollection.name
			});
		});
	}

	_populateFields(requestResult) {
		let activeCollection = requestResult[0];
		let productionInformation = requestResult[1];
		const userSettings = requestResult[2];

		this.activeCTCollectionId = activeCollection[0].ctCollectionId;

		if (activeCollection !== undefined && activeCollection.length == 1) {
			activeCollection = activeCollection[0];
		}

		if (activeCollection !== undefined) {
			this.urlActiveCollectionPublish = activeCollection.links.find(
				function(link) {
					return link.rel === 'publish';
				}
			);

			// Changes

			this.changes = {
				added: activeCollection.additionCount,
				deleted: activeCollection.deletionCount,
				modified: activeCollection.modificationCount
			};

			// Active Change List Description

			this.descriptionActiveChangeList = activeCollection.description;

			// Change Lists dropdown Menu

			const urlRecentCollections =
				this.urlCollectionsBase +
				'?companyId=' +
				Liferay.ThemeDisplay.getCompanyId() +
				'&userId=' +
				Liferay.ThemeDisplay.getUserId() +
				'&type=recent&limit=5&sort=modifiedDate:desc';

			this._fetchRecentCollections(urlRecentCollections);

			// Active Change List Header Title

			this.headerTitleActiveChangeList = activeCollection.name;

			// Initial Fetch

			this.initialFetch = true;
		}

		if (
			productionInformation !== undefined &&
			productionInformation.length == 1
		) {
			productionInformation = productionInformation[0];
		}

		if (
			productionInformation !== undefined &&
			productionInformation.ctcollection !== undefined &&
			productionInformation.ctcollection.name !== undefined
		) {
			this.descriptionProductionInformation =
				productionInformation.ctcollection.description;
			this.headerTitleProductionInformation =
				productionInformation.ctcollection.name;

			const publishDate = new Date(productionInformation.date);

			this.publishedBy = {
				dateTime: new Intl.DateTimeFormat(
					Liferay.ThemeDisplay.getBCP47LanguageId(),
					{
						day: 'numeric',
						hour: 'numeric',
						minute: 'numeric',
						month: 'numeric',
						year: 'numeric'
					}
				).format(publishDate),
				userInitials: productionInformation.userInitials,
				userName: productionInformation.userName,
				userPortraitURL: productionInformation.userPortraitURL
			};

			this.productionFound = true;
		} else {
			this.productionFound = false;
		}

		if (userSettings) {
			this.checkoutConfirmationEnabled =
				userSettings.checkoutCTCollectionConfirmationEnabled;
		}
	}

	_render() {
		const urlActiveCollection =
			this.urlCollectionsBase +
			'?companyId=' +
			Liferay.ThemeDisplay.getCompanyId() +
			'&userId=' +
			Liferay.ThemeDisplay.getUserId() +
			'&type=active';

		const urls = [
			urlActiveCollection,
			this.urlProductionInformation,
			this.urlUserSettings
		];

		this.initialFetch = false;

		this.headerButtonDisabled = false;

		if (this.changeEntries.length === 0) {
			this.headerButtonDisabled = true;
		}

		this._fetchAll(urls)
			.then(result => this._populateFields(result))
			.catch(error => {
				const message =
					typeof error === 'string'
						? error
						: Liferay.Language.get(
								'an-error-occured-while-parsing-data'
						  );

				openToast({
					message,
					title: Liferay.Language.get('error'),
					type: 'danger'
				});
			});
	}

	_sub(langKey, args) {
		const keyArray = langKey
			.split(SPLIT_REGEX)
			.filter(val => val.length !== 0);

		for (let i = 0; i < args.length; i++) {
			const arg = args[i];

			const indexKey = `{${i}}`;

			let argIndex = keyArray.indexOf(indexKey);

			while (argIndex >= 0) {
				keyArray.splice(argIndex, 1, arg);

				argIndex = keyArray.indexOf(indexKey);
			}
		}

		return keyArray.join('');
	}
}

/**
 * State definition.
 *
 * @static
 * @type {!Object}
 */
Overview.STATE = {
	/**
	 * Active change tracking collection ID retrieved from the REST service.
	 *
	 * @default 0
	 * @instance
	 * @memberOf Overview
	 * @type {number}
	 */
	activeCTCollectionId: Config.number().value(0),

	/**
	 * Change entries for the currently selected change tracking collection.
	 *
	 * @default undefined
	 * @instance
	 * @memberOf Overview
	 * @type {object}
	 */
	changeEntries: Config.arrayOf(
		Config.shapeOf({
			changeType: Config.string(),
			contentType: Config.string(),
			lastEdited: Config.string(),
			site: Config.string(),
			title: Config.string(),
			userName: Config.string(),
			version: Config.string()
		})
	).required(),

	/**
	 * List of drop down menu items.
	 *
	 * @default []
	 * @instance
	 * @memberOf Overview
	 * @type {array}
	 */
	changeListsDropdownMenu: Config.arrayOf(
		Config.shapeOf({
			ctCollectionId: Config.string(),
			label: Config.string()
		})
	),

	/**
	 * Number of changes for the active change list.
	 *
	 * @default
	 * @instance
	 * @memberOf Overview
	 * @type {object}
	 */
	changes: Config.shapeOf({
		added: Config.number().value(0),
		deleted: Config.number().value(0),
		modified: Config.number().value(0)
	}),

	/**
	 * Checkout confirmation is enabled.
	 *
	 * @default true
	 * @instance
	 * @memberOf Overview
	 * @type {boolean}
	 */
	checkoutConfirmationEnabled: Config.bool().value(true),

	/**
	 * Active change list card description.
	 *
	 * @default undefined
	 * @instance
	 * @memberOf Overview
	 * @type {string}
	 */
	descriptionActiveChangeList: Config.string(),

	/**
	 * Production card description.
	 *
	 * @default
	 * @instance
	 * @memberOf Overview
	 * @type {string}
	 */
	descriptionProductionInformation: Config.string(),

	hasCollision: Config.bool().value(false),

	/**
	 * If <code>true</code>, head button is disabled.
	 *
	 * @default false
	 * @instance
	 * @memberOf Overview
	 * @type {boolean}
	 */
	headerButtonDisabled: Config.bool().value(false),

	/**
	 * Active change list's card header title.
	 *
	 * @default undefined
	 * @instance
	 * @memberOf Overview
	 * @type {string}
	 */
	headerTitleActiveChangeList: Config.string(),

	/**
	 * Production's card header title.
	 *
	 * @default
	 * @instance
	 * @memberOf Overview
	 * @type {string}
	 */
	headerTitleProductionInformation: Config.string(),

	/**
	 * If <code>true</code>, an initial fetch has already occurred.
	 *
	 * @default false
	 * @instance
	 * @memberOf Overview
	 * @type {boolean}
	 */
	initialFetch: Config.bool().value(false),

	productionCTCollectionId: Config.number(),

	productionFound: Config.bool().value(false),

	/**
	 * Information of who published to production.
	 *
	 * @instance
	 * @memberOf Overview
	 * @type {object}
	 */
	publisedBy: Config.shapeOf({
		dateTime: Config.string(),
		userInitials: Config.string(),
		userName: Config.string(),
		userPortraitURL: Config.string()
	}),

	/**
	 * Path of the available icons.
	 *
	 * @default undefined
	 * @instance
	 * @memberOf Overview
	 * @type {!string}
	 */
	spritemap: Config.string().required(),

	urlActiveCollectionPublish: Config.object(),

	/**
	 * The URL for the REST service to the change entries.
	 * @default
	 * @instance
	 * @memberOf Overview
	 * @type {string}
	 */
	urlChangeEntries: Config.string(),

	urlChangeListsHistory: Config.string().required(),

	/**
	 * Base REST API URL to the collection resource.
	 *
	 * @default
	 * @instance
	 * @memberOf Overview
	 * @type {string}
	 */
	urlCollectionsBase: Config.string(),

	/**
	 * URL for the REST service to the change tracking production information.
	 *
	 * @default undefined
	 * @instance
	 * @memberOf Overview
	 * @type {!string}
	 */
	urlProductionInformation: Config.string().required(),

	/**
	 * URL for the production view.
	 *
	 * @default undefined
	 * @instance
	 * @memberOf Overview
	 * @type {!string}
	 */
	urlProductionView: Config.string().required(),

	/**
	 * URL for the list view with production checked out.
	 *
	 * @default undefined
	 * @instance
	 * @memberOf Overview
	 * @type {string}
	 */
	urlSelectProduction: Config.string(),

	/**
	 * URL for the REST service to the user settings.
	 *
	 * @default undefined
	 * @instance
	 * @memberOf Overview
	 * @type {string}
	 */
	urlUserSettings: Config.string()
};

Soy.register(Overview, templates);

export {Overview};
export default Overview;
