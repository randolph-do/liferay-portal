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

ProductConsumption productConsumption = (ProductConsumption)request.getAttribute(TrunkWebKeys.PRODUCT_CONSUMPTION);

long accountId = ParamUtil.getLong(request, "accountId");
long projectId = ParamUtil.getLong(request, "projectId");

renderResponse.setTitle((productConsumption == null) ? LanguageUtil.get(request, "new-consumption") : "consumption");
%>

<portlet:actionURL name="/products_admin/edit_product_consumption" var="editProductConsumptionURL" />

<aui:form action="<%= editProductConsumptionURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<liferay-ui:error exception="<%= NoSuchAccountException.class %>" message="please-select-a-valid-account" />
	<liferay-ui:error exception="<%= NoSuchProductEntryException.class %>" message="please-select-a-valid-product" />
	<liferay-ui:error exception="<%= NoSuchProjectException.class %>" message="please-select-a-valid-project" />

	<aui:model-context bean="<%= productConsumption %>" model="<%= ProductConsumption.class %>" />

	<aui:fieldset-group>
		<aui:fieldset>
			<c:choose>
				<c:when test="<%= productConsumption != null %>">
					<aui:input label="uuid" name="uuidLabel" type="resource" value="<%= productConsumption.getUuid() %>" />

					<%
					Account koroneikiAccount = productConsumption.getAccount();
					%>

					<h5><liferay-ui:message key="account" /></h5>

					<p>
						<liferay-portlet:renderURL portletName="<%= TaprootPortletKeys.ACCOUNTS_ADMIN %>" var="accountURL">
							<portlet:param name="mvcRenderCommandName" value="/accounts_admin/edit_account" />
							<portlet:param name="accountId" value="<%= String.valueOf(koroneikiAccount.getAccountId()) %>" />
						</liferay-portlet:renderURL>

						<a href="<%= accountURL %>"><%= HtmlUtil.escape(koroneikiAccount.getName()) %></a>
					</p>

					<%
					Project project = productConsumption.getProject();
					%>

					<h5><liferay-ui:message key="project" /></h5>

					<p>
						<c:choose>
							<c:when test="<%= project != null %>">
								<liferay-portlet:renderURL portletName="<%= TaprootPortletKeys.PROJECTS_ADMIN %>" var="projectURL">
									<portlet:param name="mvcRenderCommandName" value="/projects_admin/edit_project" />
									<portlet:param name="projectId" value="<%= String.valueOf(project.getProjectId()) %>" />
								</liferay-portlet:renderURL>

								<a href="<%= projectURL %>"><%= HtmlUtil.escape(project.getName()) %></a>
							</c:when>
							<c:otherwise>
								N/A
							</c:otherwise>
						</c:choose>
					</p>

					<%
					ProductEntry productEntry = productConsumption.getProductEntry();
					%>

					<h5><liferay-ui:message key="product" /></h5>

					<p>
						<liferay-portlet:renderURL var="productEntryURL">
							<portlet:param name="mvcRenderCommandName" value="/products_admin/edit_product_entry" />
							<portlet:param name="productEntryId" value="<%= String.valueOf(productEntry.getProductEntryId()) %>" />
						</liferay-portlet:renderURL>

						<a href="<%= productEntryURL %>"><%= HtmlUtil.escape(productEntry.getName()) %></a>
					</p>
				</c:when>
				<c:otherwise>
					<aui:select label="account" name="accountId" onChange='<%= renderResponse.getNamespace() + "selectAccount(this.value, 0);" %>'>
						<aui:option value="" />

						<%
						for (Account koroneikiAccount : AccountLocalServiceUtil.getAccounts(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
						%>

							<aui:option label="<%= koroneikiAccount.getName() %>" select="<%= koroneikiAccount.getAccountId() == accountId %>" value="<%= koroneikiAccount.getAccountId() %>" />

						<%
						}
						%>

					</aui:select>

					<aui:select label="project" name="projectId" />

					<aui:select label="product" name="productEntryId">
						<aui:option value="" />

						<%
						for (ProductEntry productEntry : ProductEntryLocalServiceUtil.getProductEntries(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
						%>

							<aui:option label="<%= productEntry.getName() %>" value="<%= productEntry.getProductEntryId() %>" />

						<%
						}
						%>

					</aui:select>
				</c:otherwise>
			</c:choose>
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<c:if test="<%= productConsumption == null %>">
			<aui:button type="submit" />
		</c:if>

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script>
	<c:if test="<%= accountId > 0 %>">
		AUI().ready(
			function() {
				<portlet:namespace />selectAccount('<%= accountId %>', '<%= projectId %>');
			}
		);
	</c:if>

	Liferay.provide(
		window,
		'<portlet:namespace />selectAccount',
		function(accountId, projectId) {
			var A = AUI();

			A.io.request(
				'/o/koroneiki-rest/v1.0/accounts/' + accountId + '/projects',
				{
					method: 'GET',
					on: {
						success: function(event, id, obj) {
							var responseText = obj.responseText;

							var responseData = A.JSON.parse(responseText);

							var projectSelect = A.one('#<portlet:namespace />projectId');

							projectSelect.empty();

							var itemsJSONArray = responseData.items;

							if (itemsJSONArray) {
								var emptyOption = A.Node.create('<option value=""></option>');

								projectSelect.append(emptyOption);

								for (var i = 0; i < itemsJSONArray.length; i++) {
									var item = itemsJSONArray[i];

									var projectOption = A.Node.create('<option value="' + item.id + '">' + item.name + '</option>');

									projectSelect.append(projectOption);
								}

								if (projectId > 0) {
									projectSelect.val(projectId);
								}
							}
						}
					}
				}
			);
		},
		['aui-io-request']
	);
</aui:script>