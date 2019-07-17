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
ViewAccountsManagementToolbarDisplayContext viewAccountsManagementToolbarDisplayContext = new ViewAccountsManagementToolbarDisplayContext(request, renderRequest, renderResponse);

SearchContainer searchContainer = viewAccountsManagementToolbarDisplayContext.getSearchContainer();
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%= viewAccountsManagementToolbarDisplayContext.getNavigationItems() %>"
/>

<clay:management-toolbar
	clearResultsURL="<%= viewAccountsManagementToolbarDisplayContext.getClearResultsURL() %>"
	creationMenu="<%= viewAccountsManagementToolbarDisplayContext.getCreationMenu() %>"
	filterDropdownItems="<%= viewAccountsManagementToolbarDisplayContext.getFilterDropdownItems() %>"
	itemsTotal="<%= searchContainer.getTotal() %>"
	searchActionURL="<%= viewAccountsManagementToolbarDisplayContext.getSearchActionURL() %>"
	searchContainerId="accountSearch"
	searchFormName="searchFm"
	selectable="<%= false %>"
	showSearch="<%= true %>"
	sortingOrder="<%= searchContainer.getOrderByType() %>"
	sortingURL="<%= viewAccountsManagementToolbarDisplayContext.getSortingURL() %>"
/>

<liferay-ui:error exception="<%= RequiredAccountException.class %>" message="you-cannot-delete-accounts-that-have-projects" />

<div class="container-fluid-1280">
	<liferay-ui:search-container
		searchContainer="<%= searchContainer %>"
		var="accountSearch"
	>
		<liferay-ui:search-container-row
			className="com.liferay.osb.koroneiki.taproot.model.Account"
			escapedModel="<%= true %>"
			keyProperty="accountId"
			modelVar="koroneikiAccount"
		>
			<portlet:renderURL var="rowURL">
				<portlet:param name="mvcRenderCommandName" value="/accounts_admin/edit_account" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="accountId" value="<%= String.valueOf(koroneikiAccount.getAccountId()) %>" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="name"
			>
				<span class="lfr-portal-tooltip" data-title="<liferay-ui:message key="account" />">
					<aui:icon cssClass="icon-monospaced" image="users" markupView="lexicon" />
				</span>

				<%= koroneikiAccount.getName() %>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="description"
				value="<%= koroneikiAccount.getDescription() %>"
			/>

			<liferay-ui:search-container-column-status
				href="<%= rowURL %>"
				name="status"
				status="<%= koroneikiAccount.getStatus() %>"
			/>

			<liferay-ui:search-container-column-jsp
				align="right"
				path="/accounts_admin/account_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>