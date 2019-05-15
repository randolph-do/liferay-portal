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
Account koroneikiAccount = (Account)request.getAttribute(TaprootWebKeys.ACCOUNT);

renderResponse.setTitle(koroneikiAccount.getName());
%>

<liferay-util:include page="/accounts_admin/edit_account_tabs.jsp" servletContext="<%= application %>" />

<div class="main-content-body">

	<%
	List<Project> projects = koroneikiAccount.getProjects();
	%>

	<div class="container-fluid-1280">
		<liferay-ui:search-container
			emptyResultsMessage="no-projects-were-found"
			headerNames="name,code,status"
			total="<%= projects.size() %>"
		>
			<liferay-ui:search-container-results
				results="<%= projects %>"
			/>

			<liferay-ui:search-container-row
				className="com.liferay.osb.koroneiki.taproot.model.Project"
				escapedModel="<%= true %>"
				keyProperty="projectId"
				modelVar="project"
			>
				<liferay-portlet:renderURL portletName="<%= TaprootPortletKeys.PROJECTS_ADMIN %>" var="rowURL">
					<portlet:param name="mvcRenderCommandName" value="/projects_admin/edit_project" />
					<portlet:param name="projectId" value="<%= String.valueOf(project.getProjectId()) %>" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="name"
					value="<%= project.getName() %>"
				/>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="code"
					value="<%= project.getCode() %>"
				/>

				<liferay-ui:search-container-column-status
					href="<%= rowURL %>"
					name="status"
					status="<%= project.getStatus() %>"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator
				markupView="lexicon"
				paginate="<%= false %>"
			/>
		</liferay-ui:search-container>
	</div>
</div>