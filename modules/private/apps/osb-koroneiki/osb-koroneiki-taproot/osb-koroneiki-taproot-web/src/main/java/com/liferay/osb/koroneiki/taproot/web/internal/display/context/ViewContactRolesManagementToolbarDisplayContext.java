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

package com.liferay.osb.koroneiki.taproot.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemList;
import com.liferay.osb.koroneiki.taproot.constants.ContactRoleType;
import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.osb.koroneiki.taproot.service.ContactRoleLocalServiceUtil;
import com.liferay.osb.koroneiki.taproot.web.internal.search.ContactRoleSearch;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Amos Fong
 */
public class ViewContactRolesManagementToolbarDisplayContext {

	public ViewContactRolesManagementToolbarDisplayContext(
		HttpServletRequest httpServletRequest, RenderRequest renderRequest,
		RenderResponse renderResponse) {

		_httpServletRequest = httpServletRequest;
		_renderRequest = renderRequest;
		_renderResponse = renderResponse;

		_currentURLObj = PortletURLUtil.getCurrent(
			_renderRequest, _renderResponse);
	}

	public String getClearResultsURL() {
		PortletURL clearResultsURL = getPortletURL();

		clearResultsURL.setParameter("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}

	public CreationMenu getCreationMenu() throws PortalException {
		String tabs1 = ParamUtil.getString(_renderRequest, "tabs1");

		return new CreationMenu() {
			{
				if (tabs1.equals("project-contact-roles")) {
					addDropdownItem(
						dropdownItem -> {
							dropdownItem.setHref(
								_renderResponse.createRenderURL(),
								"mvcRenderCommandName",
								"/contact_roles_admin/edit_contact_role",
								"redirect", _currentURLObj.toString(), "type",
								ContactRoleType.PROJECT);
							dropdownItem.setLabel(
								LanguageUtil.get(_httpServletRequest, "add"));
						});
				}
				else if (tabs1.equals("team-contact-roles")) {
					addDropdownItem(
						dropdownItem -> {
							dropdownItem.setHref(
								_renderResponse.createRenderURL(),
								"mvcRenderCommandName",
								"/contact_roles_admin/edit_contact_role",
								"redirect", _currentURLObj.toString(), "type",
								ContactRoleType.TEAM);
							dropdownItem.setLabel(
								LanguageUtil.get(_httpServletRequest, "add"));
						});
				}
				else {
					addDropdownItem(
						dropdownItem -> {
							dropdownItem.setHref(
								_renderResponse.createRenderURL(),
								"mvcRenderCommandName",
								"/contact_roles_admin/edit_contact_role",
								"redirect", _currentURLObj.toString(), "type",
								ContactRoleType.ACCOUNT);
							dropdownItem.setLabel(
								LanguageUtil.get(_httpServletRequest, "add"));
						});
				}
			}
		};
	}

	public List<DropdownItem> getFilterDropdownItems() {
		return new DropdownItemList() {
			{
				addGroup(
					dropdownGroupItem -> {
						dropdownGroupItem.setDropdownItems(
							_getOrderByDropdownItems());
						dropdownGroupItem.setLabel(
							LanguageUtil.get(_httpServletRequest, "order-by"));
					});
			}
		};
	}

	public String getKeywords() {
		if (Validator.isNull(_keywords)) {
			_keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		}

		return _keywords;
	}

	public List<NavigationItem> getNavigationItems() {
		String tabs1 = ParamUtil.getString(_renderRequest, "tabs1");

		return new NavigationItemList() {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(
							tabs1.equals("account-contact-roles"));
						navigationItem.setHref(
							_renderResponse.createRenderURL(), "tabs1",
							"account-contact-roles");
						navigationItem.setLabel(
							LanguageUtil.get(
								_httpServletRequest, "account-contact-roles"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(
							tabs1.equals("project-contact-roles"));
						navigationItem.setHref(
							_renderResponse.createRenderURL(), "tabs1",
							"project-contact-roles");
						navigationItem.setLabel(
							LanguageUtil.get(
								_httpServletRequest, "project-contact-roles"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(
							tabs1.equals("team-contact-roles"));
						navigationItem.setHref(
							_renderResponse.createRenderURL(), "tabs1",
							"team-contact-roles");
						navigationItem.setLabel(
							LanguageUtil.get(
								_httpServletRequest, "team-contact-roles"));
					});
			}
		};
	}

	public String getOrderByCol() {
		if (Validator.isNull(_orderByCol)) {
			_orderByCol = ParamUtil.getString(
				_httpServletRequest, "orderByCol", "name");
		}

		return _orderByCol;
	}

	public String getOrderByType() {
		if (Validator.isNull(_orderByType)) {
			_orderByType = ParamUtil.getString(
				_httpServletRequest, "orderByType", "asc");
		}

		return _orderByType;
	}

	public PortletURL getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		if (Validator.isNotNull(getKeywords())) {
			portletURL.setParameter("keywords", getKeywords());
		}

		portletURL.setParameter("orderByCol", getOrderByCol());
		portletURL.setParameter("orderByType", getOrderByType());
		portletURL.setParameter(
			"tabs1", ParamUtil.getString(_renderRequest, "tabs1"));

		if (_contactRoleSearch != null) {
			portletURL.setParameter(
				_contactRoleSearch.getCurParam(),
				String.valueOf(_contactRoleSearch.getCur()));
			portletURL.setParameter(
				_contactRoleSearch.getDeltaParam(),
				String.valueOf(_contactRoleSearch.getDelta()));
		}

		return portletURL;
	}

	public String getSearchActionURL() {
		PortletURL searchActionURL = getPortletURL();

		return searchActionURL.toString();
	}

	public SearchContainer getSearchContainer() throws Exception {
		if (_contactRoleSearch != null) {
			return _contactRoleSearch;
		}

		ContactRoleSearch contactRoleSearch = new ContactRoleSearch(
			_renderRequest, getPortletURL());

		ThemeDisplay themeDisplay =
			(ThemeDisplay)_httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		int type = 0;

		String tabs1 = ParamUtil.getString(_renderRequest, "tabs1");

		if (tabs1.equals("project-contact-roles")) {
			type = ContactRoleType.PROJECT;
		}
		else if (tabs1.equals("team-contact-roles")) {
			type = ContactRoleType.TEAM;
		}
		else {
			type = ContactRoleType.ACCOUNT;
		}

		String keywords = ParamUtil.getString(_renderRequest, "keywords");

		Sort sort = SortFactoryUtil.getSort(
			ContactRole.class, Sort.STRING_TYPE, getOrderByCol(),
			getOrderByType());

		Hits hits = ContactRoleLocalServiceUtil.search(
			themeDisplay.getCompanyId(), type, keywords,
			contactRoleSearch.getStart(), contactRoleSearch.getEnd(), sort);

		List<ContactRole> results = new ArrayList<>();

		for (Document document : hits.getDocs()) {
			long contactRoleId = GetterUtil.getLong(
				document.get(Field.ENTRY_CLASS_PK));

			results.add(
				ContactRoleLocalServiceUtil.getContactRole(contactRoleId));
		}

		contactRoleSearch.setResults(results);
		contactRoleSearch.setTotal(hits.getLength());

		_contactRoleSearch = contactRoleSearch;

		return _contactRoleSearch;
	}

	public String getSortingURL() {
		PortletURL sortingURL = getPortletURL();

		sortingURL.setParameter(
			"orderByType",
			Objects.equals(getOrderByType(), "asc") ? "desc" : "asc");

		return sortingURL.toString();
	}

	private List<DropdownItem> _getOrderByDropdownItems() {
		return new DropdownItemList() {
			{
				add(
					dropdownItem -> {
						dropdownItem.setActive(
							Objects.equals(getOrderByCol(), "name"));
						dropdownItem.setHref(
							getPortletURL(), "orderByCol", "name");
						dropdownItem.setLabel(
							LanguageUtil.get(_httpServletRequest, "name"));
					});
			}
		};
	}

	private ContactRoleSearch _contactRoleSearch;
	private final PortletURL _currentURLObj;
	private final HttpServletRequest _httpServletRequest;
	private String _keywords;
	private String _orderByCol;
	private String _orderByType;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;

}