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
String tabs1 = ParamUtil.getString(request, "tabs1", "account-contact-roles");
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("account-contact-roles"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs1", "account-contact-roles");
						navigationItem.setLabel(LanguageUtil.get(request, "account-contact-roles"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("project-contact-roles"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs1", "project-contact-roles");
						navigationItem.setLabel(LanguageUtil.get(request, "project-contact-roles"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("team-contact-roles"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs1", "team-contact-roles");
						navigationItem.setLabel(LanguageUtil.get(request, "team-contact-roles"));
					});
			}
		}
	%>"
/>

<clay:management-toolbar
	creationMenu='<%=
		new JSPCreationMenu(pageContext) {
			{
				if (tabs1.equals("project-contact-roles")) {
					addDropdownItem(
						dropdownItem -> {
							dropdownItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/contact_roles_admin/edit_contact_role", "redirect", PortalUtil.getCurrentURL(request), "type", ContactRoleType.PROJECT);
							dropdownItem.setLabel(LanguageUtil.get(request, "add"));
						});
				}
				else if (tabs1.equals("team-contact-roles")) {
					addDropdownItem(
						dropdownItem -> {
							dropdownItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/contact_roles_admin/edit_contact_role", "redirect", PortalUtil.getCurrentURL(request), "type", ContactRoleType.TEAM);
							dropdownItem.setLabel(LanguageUtil.get(request, "add"));
						});
				}
				else {
					addDropdownItem(
						dropdownItem -> {
							dropdownItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/contact_roles_admin/edit_contact_role", "redirect", PortalUtil.getCurrentURL(request), "type", ContactRoleType.ACCOUNT);
							dropdownItem.setLabel(LanguageUtil.get(request, "add"));
						});
				}
			}
		}
	%>'
	selectable="<%= false %>"
	showSearch="<%= false %>"
/>

<%
int type = 0;

if (tabs1.equals("project-contact-roles")) {
	type = ContactRoleType.PROJECT;
}
else if (tabs1.equals("team-contact-roles")) {
	type = ContactRoleType.TEAM;
}
else {
	type = ContactRoleType.ACCOUNT;
}
%>

<div class="container-fluid-1280">
	<liferay-ui:search-container
		emptyResultsMessage="no-contact-roles-were-found"
		headerNames="name,description,"
		iteratorURL="<%= renderResponse.createRenderURL() %>"
		total="<%= ContactRoleLocalServiceUtil.getContactRolesCount(type) %>"
	>
		<liferay-ui:search-container-results
			results="<%= ContactRoleLocalServiceUtil.getContactRoles(type, searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.osb.koroneiki.taproot.model.ContactRole"
			escapedModel="<%= true %>"
			keyProperty="contactRoleId"
			modelVar="contactRole"
		>
			<portlet:renderURL var="rowURL">
				<portlet:param name="mvcRenderCommandName" value="/contact_roles_admin/edit_contact_role" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="contactRoleId" value="<%= String.valueOf(contactRole.getContactRoleId()) %>" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="name"
				value="<%= contactRole.getName() %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="description"
				value="<%= contactRole.getDescription() %>"
			/>

			<liferay-ui:search-container-column-jsp
				align="right"
				path="/contact_roles_admin/contact_role_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>