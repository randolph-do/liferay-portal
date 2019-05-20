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
Project project = (Project)request.getAttribute(TaprootWebKeys.PROJECT);

renderResponse.setTitle(project.getName());
%>

<liferay-util:include page="/projects_admin/edit_project_tabs.jsp" servletContext="<%= application %>" />

<clay:management-toolbar
	componentId="contactsManagementToolbar"
	creationMenu='<%=
		new JSPCreationMenu(pageContext) {
			{
				addDropdownItem(
					dropdownItem -> {
						dropdownItem.setLabel(LanguageUtil.get(request, "assign-contact"));
					});
			}
		}
	%>'
	selectable="<%= false %>"
	showCreationMenu="<%= true %>"
	showSearch="<%= false %>"
/>

<div class="container-fluid-1280">
	<liferay-ui:search-container
		emptyResultsMessage="no-contacts-were-found"
		headerNames="full-name,email-address"
		total="<%= ContactLocalServiceUtil.getProjectContactsCount(project.getProjectId()) %>"
	>
		<liferay-ui:search-container-results
			results="<%= ContactLocalServiceUtil.getProjectContacts(project.getProjectId(), searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.osb.koroneiki.taproot.model.Contact"
			escapedModel="<%= true %>"
			keyProperty="contactId"
			modelVar="koroneikiContact"
		>
			<liferay-portlet:renderURL portletName="<%= TaprootPortletKeys.CONTACTS_ADMIN %>" var="rowURL">
				<portlet:param name="mvcRenderCommandName" value="/contacts_admin/edit_contact" />
				<portlet:param name="contactId" value="<%= String.valueOf(koroneikiContact.getContactId()) %>" />
			</liferay-portlet:renderURL>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="full-name"
				value="<%= koroneikiContact.getFullName() %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="email-address"
				value="<%= koroneikiContact.getEmailAddress() %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="roles"
			>

				<%
				List<ContactRole> contactRoles = ContactRoleLocalServiceUtil.getContactProjectContactRoles(project.getProjectId(), koroneikiContact.getContactId());
				%>

				<%= ListUtil.toString(contactRoles, ContactRole.NAME_ACCESSOR, StringPool.COMMA_AND_SPACE) %>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-jsp
				align="right"
				path="/projects_admin/project_contact_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>

<aui:script require="metal-dom/src/all/dom as dom,frontend-js-web/liferay/modal/commands/OpenSimpleInputModal.es as modalCommands">
	function handleAddClick(event) {
		event.preventDefault();

		<portlet:actionURL name="/projects_admin/assign_project_contact" var="assignProjectContactURL">
			<portlet:param name="projectId" value="<%= String.valueOf(project.getProjectId()) %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:actionURL>

		modalCommands.openSimpleInputModal(
			{
				dialogTitle: '<liferay-ui:message key="assign-contact-to-this-project" />',
				formSubmitURL: '<%= assignProjectContactURL %>',
				mainFieldLabel: '<liferay-ui:message key="email-address" />',
				mainFieldName: 'emailAddress',
				mainFieldPlaceholder: '<liferay-ui:message key="email-address" />',
				namespace: '<portlet:namespace />',
				spritemap: '<%= themeDisplay.getPathThemeImages() %>/lexicon/icons.svg'
			}
		);
	}

	Liferay.componentReady('contactsManagementToolbar').then(
		function(managementToolbar) {
			managementToolbar.on('creationButtonClicked', handleAddClick);
		}
	);
</aui:script>