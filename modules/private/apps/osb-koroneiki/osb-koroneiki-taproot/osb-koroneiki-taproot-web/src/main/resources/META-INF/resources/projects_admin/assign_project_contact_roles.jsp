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
String redirect = ParamUtil.getString(request, "redirect");

Project project = (Project)request.getAttribute(TaprootWebKeys.PROJECT);
Contact koroneikiContact = (Contact)request.getAttribute(TaprootWebKeys.CONTACT);

renderResponse.setTitle(project.getName());
%>

<portlet:actionURL name="/projects_admin/assign_project_contact_roles" var="assignProjectContactRolesURL" />

<div class="main-content-body">
	<aui:form action="<%= assignProjectContactRolesURL %>" cssClass="container-fluid-1280" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm();" %>'>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="projectId" type="hidden" value="<%= project.getProjectId() %>" />
		<aui:input name="contactId" type="hidden" value="<%= koroneikiContact.getContactId() %>" />
		<aui:input name="addContactRoleIds" type="hidden" />
		<aui:input name="deleteContactRoleIds" type="hidden" />

		<h2><liferay-ui:message arguments="<%= koroneikiContact.getFullName() %>" key="assign-contact-roles-for-x" /></h2>

		<%
		List<ContactRole> contactRoles = ContactRoleLocalServiceUtil.getContactProjectContactRoles(project.getProjectId(), koroneikiContact.getContactId());
		%>

		<liferay-ui:search-container
			emptyResultsMessage="no-contact-roles-were-found"
			headerNames="name,description"
			iteratorURL="<%= renderResponse.createRenderURL() %>"
			total="<%= ContactRoleLocalServiceUtil.getContactRolesCount(ContactRoleType.PROJECT) %>"
		>
			<liferay-ui:search-container-results
				results="<%= ContactRoleLocalServiceUtil.getContactRoles(ContactRoleType.PROJECT, searchContainer.getStart(), searchContainer.getEnd()) %>"
			/>

			<liferay-ui:search-container-row
				className="com.liferay.osb.koroneiki.taproot.model.ContactRole"
				escapedModel="<%= true %>"
				keyProperty="contactRoleId"
				modelVar="contactRole"
			>
				<liferay-ui:search-container-column-text>
					<aui:input checked="<%= contactRoles.contains(contactRole) %>" disabled="<%= contactRole.isSystem() %>" label="" name="contactRoleIds" type="checkbox" value="<%= contactRole.getContactRoleId() %>" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text
					name="name"
					value="<%= contactRole.getName() %>"
				/>

				<liferay-ui:search-container-column-text
					name="description"
					value="<%= contactRole.getDescription() %>"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator
				markupView="lexicon"
			/>
		</liferay-ui:search-container>

		<aui:button-row>
			<aui:button type="submit" />

			<aui:button href="<%= redirect %>" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />submitForm() {
		var form = document.getElementById('<portlet:namespace />fm');

		var addContactRoleIdsInput = form.querySelector('#<portlet:namespace />addContactRoleIds');
		var deleteContactRoleIdsInput = form.querySelector('#<portlet:namespace />deleteContactRoleIds');

		addContactRoleIdsInput.setAttribute('value', Liferay.Util.listCheckedExcept(form));
		deleteContactRoleIdsInput.setAttribute('value', Liferay.Util.listUncheckedExcept(form));

		form.submit();
	}
</aui:script>