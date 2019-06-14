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

long projectId = BeanParamUtil.getLong(project, request, "projectId");

renderResponse.setTitle((project == null) ? LanguageUtil.get(request, "new-project") : project.getName());
%>

<liferay-util:include page="/projects_admin/edit_project_tabs.jsp" servletContext="<%= application %>" />

<portlet:actionURL name="/projects_admin/edit_project" var="editProjectURL" />

<aui:form action="<%= editProjectURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="projectId" type="hidden" value="<%= projectId %>" />

	<liferay-ui:error exception="<%= NoSuchAccountException.class %>" message="please-select-an-account" />
	<liferay-ui:error exception="<%= ProjectNameException.class %>" message="please-enter-a-valid-name" />

	<aui:model-context bean="<%= project %>" model="<%= Project.class %>" />

	<aui:fieldset-group>
		<aui:fieldset>
			<c:choose>
				<c:when test="<%= project == null %>">
					<aui:select label="account" name="accountId">
						<aui:option value="" />

						<%
						for (Account koroneikiAccount : AccountLocalServiceUtil.getAccounts(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
						%>

							<aui:option label="<%= koroneikiAccount.getName() %>" value="<%= koroneikiAccount.getAccountId() %>" />

						<%
						}
						%>

					</aui:select>
				</c:when>
				<c:otherwise>
					<aui:input label="uuid" name="uuidLabel" type="resource" value="<%= project.getUuid() %>" />

					<h5><liferay-ui:message key="account" /></h5>

					<p>

						<%
						Account koroneikiAccount = project.getAccount();
						%>

						<liferay-portlet:renderURL portletName="<%= TaprootPortletKeys.ACCOUNTS_ADMIN %>" var="accountURL">
							<portlet:param name="mvcRenderCommandName" value="/accounts_admin/edit_account" />
							<portlet:param name="accountId" value="<%= String.valueOf(koroneikiAccount.getAccountId()) %>" />
						</liferay-portlet:renderURL>

						<a href="<%= accountURL %>"><%= HtmlUtil.escape(koroneikiAccount.getName()) %></a>
					</p>
				</c:otherwise>
			</c:choose>

			<aui:input name="name" />

			<aui:input name="code" />

			<aui:select name="status">
				<aui:option value="" />

				<%
				for (int status : WorkflowConstants.VALUES) {
				%>

					<aui:option label="<%= WorkflowConstants.getStatusLabel(status) %>" value="<%= status %>" />

				<%
				}
				%>

			</aui:select>

			<aui:select name="industry">
				<aui:option value="" />

				<%
				for (String industry : ProjectIndustry.INDUSTRIES) {
				%>

					<aui:option label="<%= industry %>" value="<%= industry %>" />

				<%
				}
				%>

			</aui:select>

			<aui:select name="tier">
				<aui:option value="" />

				<%
				for (String tier : ProjectTier.TIERS) {
				%>

					<aui:option label="<%= tier %>" value="<%= tier %>" />

				<%
				}
				%>

			</aui:select>

			<aui:input name="soldBy" />

			<aui:input name="notes" type="textarea" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>