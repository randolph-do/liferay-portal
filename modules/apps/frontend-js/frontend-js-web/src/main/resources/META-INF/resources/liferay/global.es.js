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

import {
	component,
	componentReady,
	destroyComponent,
	destroyComponents,
	destroyUnfulfilledPromises,
	getComponentCache,
	initComponentCache
} from './component.es';
import createURL from './util/portlet_url/create_url.es';
import createActionURL from './util/portlet_url/create_action_url.es';
import createRenderURL from './util/portlet_url/create_render_url.es';
import createResourceURL from './util/portlet_url/create_resource_url.es';
import escape from 'lodash.escape';
import fetch from './util/fetch.es';
import formatStorage from './util/format_storage.es';
import formatXML from './util/format_xml.es';
import getCountries from './util/address/get_countries.es';
import getCropRegion from './util/get_crop_region.es';
import getFormElement from './util/form/get_form_element.es';
import getPortletNamespace from './util/get_portlet_namespace.es';
import getRegions from './util/address/get_regions.es';
import groupBy from 'lodash.groupby';
import isEqual from 'lodash.isequal';
import portlet from './portlet/portlet.es';
import navigate from './util/navigate.es';
import ns from './util/ns.es';
import objectToFormData from './util/form/object_to_form_data.es';
import objectToURLSearchParams from './util/object_to_url_search_params.es';
import postForm from './util/form/post_form.es';
import setFormValues from './util/form/set_form_values.es';
import SideNavigation from './side_navigation.es';
import toCharCode from './util/to_char_code.es';
import unescape from 'lodash.unescape';

Liferay.component = component;
Liferay.componentReady = componentReady;
Liferay.destroyComponent = destroyComponent;
Liferay.destroyComponents = destroyComponents;
Liferay.destroyUnfulfilledPromises = destroyUnfulfilledPromises;
Liferay.getComponentCache = getComponentCache;
Liferay.initComponentCache = initComponentCache;

Liferay.Address = {
	getCountries,
	getRegions
};

Liferay.SideNavigation = SideNavigation;

Liferay.Util.escape = escape;
Liferay.Util.fetch = fetch;
Liferay.Util.formatStorage = formatStorage;
Liferay.Util.formatXML = formatXML;
Liferay.Util.getCropRegion = getCropRegion;
Liferay.Util.getFormElement = getFormElement;
Liferay.Util.getPortletNamespace = getPortletNamespace;
Liferay.Util.groupBy = groupBy;
Liferay.Util.isEqual = isEqual;
Liferay.Util.navigate = navigate;
Liferay.Util.ns = ns;
Liferay.Util.objectToFormData = objectToFormData;
Liferay.Util.objectToURLSearchParams = objectToURLSearchParams;

Liferay.Util.PortletURL = {
	createActionURL,
	createRenderURL,
	createResourceURL,
	createURL
};

Liferay.Util.postForm = postForm;
Liferay.Util.setFormValues = setFormValues;
Liferay.Util.toCharCode = toCharCode;

Liferay.Util.openToast = (...args) => {
	Liferay.Loader.require(
		'frontend-js-web/liferay/toast/commands/OpenToast.es',
		commands => {
			commands.openToast(...args);
		}
	);
};

Liferay.Util.unescape = unescape;

export {portlet};
