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
String tabs1 = ParamUtil.getString(request, "tabs1", "products");
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("products"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs1", "products");
						navigationItem.setLabel(LanguageUtil.get(request, "products"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("purchases"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs1", "purchases");
						navigationItem.setLabel(LanguageUtil.get(request, "purchases"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("consumption"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs1", "consumption");
						navigationItem.setLabel(LanguageUtil.get(request, "consumption"));
					});
			}
		}
	%>"
/>

<clay:management-toolbar
	creationMenu='<%=
		new JSPCreationMenu(pageContext) {
			{
				if (tabs1.equals("consumption")) {
					addDropdownItem(
						dropdownItem -> {
							dropdownItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/products_admin/edit_product_consumption", "redirect", PortalUtil.getCurrentURL(request));
							dropdownItem.setLabel(LanguageUtil.get(request, "add"));
						});
				}
				else if (tabs1.equals("purchases")) {
					addDropdownItem(
						dropdownItem -> {
							dropdownItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/products_admin/edit_product_purchase", "redirect", PortalUtil.getCurrentURL(request));
							dropdownItem.setLabel(LanguageUtil.get(request, "add"));
						});
				}
				else {
					addDropdownItem(
						dropdownItem -> {
							dropdownItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/products_admin/edit_product_entry", "redirect", PortalUtil.getCurrentURL(request));
							dropdownItem.setLabel(LanguageUtil.get(request, "add"));
						});
				}
			}
		}
	%>'
	selectable="<%= false %>"
	showSearch="<%= false %>"
/>

<div class="container-fluid-1280">
	<c:choose>
		<c:when test='<%= tabs1.equals("consumption") %>'>
			<liferay-util:include page="/products_admin/view_product_consumption.jsp" servletContext="<%= application %>" />
		</c:when>
		<c:when test='<%= tabs1.equals("purchases") %>'>
			<liferay-util:include page="/products_admin/view_product_purchases.jsp" servletContext="<%= application %>" />
		</c:when>
		<c:otherwise>
			<liferay-util:include page="/products_admin/view_product_entries.jsp" servletContext="<%= application %>" />
		</c:otherwise>
	</c:choose>
</div>