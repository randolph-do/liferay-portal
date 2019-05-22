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

Project project = (Project)request.getAttribute(TaprootWebKeys.PROJECT);

long projectId = BeanParamUtil.getLong(project, request, "projectId");
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("details"));
						navigationItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/projects_admin/edit_project", "tabs1", "details", "projectId", projectId);
						navigationItem.setLabel(LanguageUtil.get(request, "details"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("contact-roles"));

						if (project != null) {
							navigationItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/projects_admin/edit_project", "tabs1", "contact-roles", "projectId", projectId);
						}

						navigationItem.setLabel(LanguageUtil.get(request, "contact-roles"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("team-roles"));

						if (project != null) {
							navigationItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/projects_admin/edit_project", "tabs1", "team-roles", "projectId", projectId);
						}

						navigationItem.setLabel(LanguageUtil.get(request, "team-roles"));
					});
			}
		}
	%>"
/>