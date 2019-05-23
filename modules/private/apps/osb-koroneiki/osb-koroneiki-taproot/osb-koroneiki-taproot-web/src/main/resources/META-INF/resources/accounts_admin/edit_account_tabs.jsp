<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "details");

Account koroneikiAccount = (Account)request.getAttribute(TaprootWebKeys.ACCOUNT);

long accountId = BeanParamUtil.getLong(koroneikiAccount, request, "accountId");
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("details"));
						navigationItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/accounts_admin/edit_account", "tabs1", "details", "accountId", accountId);
						navigationItem.setLabel(LanguageUtil.get(request, "details"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("projects"));

						if (koroneikiAccount != null) {
							navigationItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/accounts_admin/edit_account", "tabs1", "projects", "accountId", accountId);
						}

						navigationItem.setLabel(LanguageUtil.get(request, "projects"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("contact-roles"));

						if (koroneikiAccount != null) {
							navigationItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/accounts_admin/edit_account", "tabs1", "contact-roles", "accountId", accountId);
						}

						navigationItem.setLabel(LanguageUtil.get(request, "contact-roles"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("external-links"));

						if (koroneikiAccount != null) {
							navigationItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/accounts_admin/edit_account", "tabs1", "external-links", "accountId", accountId);
						}

						navigationItem.setLabel(LanguageUtil.get(request, "external-links"));
					});
			}
		}
	%>"
/>