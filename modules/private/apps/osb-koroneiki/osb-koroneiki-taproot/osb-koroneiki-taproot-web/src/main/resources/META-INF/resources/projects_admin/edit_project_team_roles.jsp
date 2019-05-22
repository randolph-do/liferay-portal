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
	creationMenu='<%=
		new JSPCreationMenu(pageContext) {
			{
				addDropdownItem(
					dropdownItem -> {
						dropdownItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/projects_admin/assign_project_team", "redirect", PortalUtil.getCurrentURL(request), "projectId", String.valueOf(project.getProjectId()));
						dropdownItem.setLabel(LanguageUtil.get(request, "assign-team"));
					});
			}
		}
	%>'
	selectable="<%= false %>"
	showSearch="<%= false %>"
/>

<div class="container-fluid-1280">
	<liferay-ui:search-container
		emptyResultsMessage="no-teams-were-found"
		headerNames="name,type"
		total="<%= TeamLocalServiceUtil.getProjectTeamsCount(project.getProjectId()) %>"
	>
		<liferay-ui:search-container-results
			results="<%= TeamLocalServiceUtil.getProjectTeams(project.getProjectId(), searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.osb.koroneiki.taproot.model.Team"
			escapedModel="<%= true %>"
			keyProperty="teamId"
			modelVar="team"
		>
			<liferay-portlet:renderURL portletName="<%= TaprootPortletKeys.TEAMS_ADMIN %>" var="rowURL">
				<portlet:param name="mvcRenderCommandName" value="/teams_admin/edit_team" />
				<portlet:param name="teamId" value="<%= String.valueOf(team.getTeamId()) %>" />
			</liferay-portlet:renderURL>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="name"
				value="<%= team.getName() %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="roles"
			>

				<%
				List<TeamRole> teamRoles = TeamRoleLocalServiceUtil.getTeamProjectTeamRoles(project.getProjectId(), team.getTeamId());
				%>

				<%= ListUtil.toString(teamRoles, TeamRole.NAME_ACCESSOR, StringPool.COMMA_AND_SPACE) %>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-jsp
				align="right"
				path="/projects_admin/project_team_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>