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

AUI.add(
	'liferay-portlet-url',
	function(A) {
		var Lang = A.Lang;

		var PortletURL = function(lifecycle, params, basePortletURL) {
			var instance = this;

			instance.params = {};

			instance.reservedParams = {
				doAsGroupId: null,
				doAsUserId: null,
				doAsUserLanguageId: null,
				p_auth: null,
				p_auth_secret: null,
				p_f_id: null,
				p_j_a_id: null,
				p_l_id: null,
				p_l_reset: null,
				p_p_auth: null,
				p_p_cacheability: null,
				p_p_i_id: null,
				p_p_id: null,
				p_p_isolated: null,
				p_p_lifecycle: null,
				p_p_mode: null,
				p_p_resource_id: null,
				p_p_state: null,
				p_p_state_rcv: null,
				p_p_static: null,
				p_p_url_type: null,
				p_p_width: null,
				p_t_lifecycle: null,
				p_v_l_s_g_id: null,
				refererGroupId: null,
				refererPlid: null,
				saveLastPath: null,
				scroll: null
			};

			if (!basePortletURL) {
				basePortletURL =
					themeDisplay.getPortalURL() +
					themeDisplay.getPathMain() +
					'/portal/layout?p_l_id=' +
					themeDisplay.getPlid();
			}

			instance.options = {
				basePortletURL: basePortletURL,
				escapeXML: null,
				secure: null
			};

			A.each(params, function(item, index) {
				if (Lang.isValue(item)) {
					if (instance._isReservedParam(index)) {
						instance.reservedParams[index] = item;
					} else {
						instance.params[index] = item;
					}
				}
			});

			if (lifecycle) {
				instance.setLifecycle(lifecycle);
			}
		};

		PortletURL.prototype = {
			/*
			 * @deprecated
			 */

			setCopyCurrentRenderParameters: function() {
				var instance = this;

				return instance;
			},

			setDoAsGroupId: function(doAsGroupId) {
				var instance = this;

				instance.reservedParams.doAsGroupId = doAsGroupId;

				return instance;
			},

			setDoAsUserId: function(doAsUserId) {
				var instance = this;

				instance.reservedParams.doAsUserId = doAsUserId;

				return instance;
			},

			/*
			 * @deprecated
			 */

			setEncrypt: function() {
				var instance = this;

				return instance;
			},

			setEscapeXML: function(escapeXML) {
				var instance = this;

				instance.options.escapeXML = escapeXML;

				return instance;
			},

			setLifecycle: function(lifecycle) {
				var instance = this;

				var reservedParams = instance.reservedParams;

				if (lifecycle === PortletURL.ACTION_PHASE) {
					reservedParams.p_auth = Liferay.authToken;
					reservedParams.p_p_lifecycle = PortletURL.ACTION_PHASE;
				} else if (lifecycle === PortletURL.RENDER_PHASE) {
					reservedParams.p_p_lifecycle = PortletURL.RENDER_PHASE;
				} else if (lifecycle === PortletURL.RESOURCE_PHASE) {
					reservedParams.p_p_lifecycle = PortletURL.RESOURCE_PHASE;
					reservedParams.p_p_cacheability = 'cacheLevelPage';
				}

				return instance;
			},

			setName: function(name) {
				var instance = this;

				instance.setParameter('javax.portlet.action', name);

				return instance;
			},

			setParameter: function(key, value) {
				var instance = this;

				if (instance._isReservedParam(key)) {
					instance.reservedParams[key] = value;
				} else {
					instance.params[key] = value;
				}

				return instance;
			},

			setParameters: function(parameters) {
				var instance = this;

				A.each(parameters, function(item, index) {
					instance.setParameter(index, item);
				});

				return instance;
			},

			setPlid: function(plid) {
				var instance = this;

				instance.reservedParams.p_l_id = plid;

				return instance;
			},

			/*
			 * @deprecated
			 */

			setPortletConfiguration: function() {
				var instance = this;

				return instance;
			},

			setPortletId: function(portletId) {
				var instance = this;

				instance.reservedParams.p_p_id = portletId;

				return instance;
			},

			setPortletMode: function(portletMode) {
				var instance = this;

				instance.reservedParams.p_p_mode = portletMode;

				return instance;
			},

			setResourceId: function(resourceId) {
				var instance = this;

				instance.reservedParams.p_p_resource_id = resourceId;

				return instance;
			},

			/*
			 * @deprecated since 7.2, unused
			 */
			setSecure: function(secure) {
				var instance = this;

				instance.options.secure = secure;

				return instance;
			},

			setWindowState: function(windowState) {
				var instance = this;

				instance.reservedParams.p_p_state = windowState;

				return instance;
			},

			toString: function() {
				var instance = this;

				var options = instance.options;

				var reservedParameters = {};

				Object.entries(instance.reservedParams).forEach(function([
					key,
					value
				]) {
					if (value != null) {
						reservedParameters[key] = value;
					}
				});

				var parameters = Object.assign(
					{},
					instance.params,
					reservedParameters
				);

				var portletURL = Liferay.Util.PortletURL.createURL(
					options.basePortletURL,
					parameters
				);

				if (options.secure) {
					portletURL.protocol = 'https:';
				}

				if (options.escapeXML) {
					portletURL.href = Lang.String.escapeHTML(portletURL.href);
				}

				return portletURL.toString();
			},

			_isReservedParam: function(paramName) {
				var instance = this;

				var result = false;

				A.each(instance.reservedParams, function(item, index) {
					if (index === paramName) {
						result = true;
					}
				});

				return result;
			}
		};

		A.mix(PortletURL, {
			ACTION_PHASE: '1',

			RENDER_PHASE: '0',

			RESOURCE_PHASE: '2',

			createActionURL: function() {
				return new PortletURL(PortletURL.ACTION_PHASE);
			},

			createRenderURL: function() {
				return new PortletURL(PortletURL.RENDER_PHASE);
			},

			createResourceURL: function() {
				return new PortletURL(PortletURL.RESOURCE_PHASE);
			},

			createURL: function(basePortletURL, params) {
				return new PortletURL(null, params, basePortletURL);
			}
		});

		Liferay.PortletURL = PortletURL;
	},
	'',
	{
		requires: ['aui-base']
	}
);
