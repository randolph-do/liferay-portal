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

ProductPurchase productPurchase = (ProductPurchase)request.getAttribute(TrunkWebKeys.PRODUCT_PURCHASE);

long productPurchaseId = BeanParamUtil.getLong(productPurchase, request, "productPurchaseId");
int quantity = BeanParamUtil.getInteger(productPurchase, request, "quantity", 1);

long accountId = ParamUtil.getLong(request, "accountId");
long projectId = ParamUtil.getLong(request, "projectId");

boolean defaultPerpetual = true;

if ((productPurchase != null) && (productPurchase.getStartDate() != null)) {
	defaultPerpetual = false;
}

boolean perpetual = ParamUtil.getBoolean(request, "perpetual", defaultPerpetual);

renderResponse.setTitle((productPurchase == null) ? LanguageUtil.get(request, "new-purchase") : LanguageUtil.get(request, "edit-purchase"));
%>

<portlet:actionURL name="/products_admin/edit_product_purchase" var="editProductPurchaseURL" />

<aui:form action="<%= editProductPurchaseURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="productPurchaseId" type="hidden" value="<%= productPurchaseId %>" />

	<liferay-ui:error exception="<%= NoSuchAccountException.class %>" message="please-select-a-valid-account" />
	<liferay-ui:error exception="<%= NoSuchProductEntryException.class %>" message="please-select-a-valid-product" />
	<liferay-ui:error exception="<%= NoSuchProjectException.class %>" message="please-select-a-valid-project" />
	<liferay-ui:error exception="<%= ProductPurchaseEndDateException.class %>" message="please-enter-a-valid-end-date" />
	<liferay-ui:error exception="<%= ProductPurchaseQuantityException.class %>" message="please-enter-a-valid-quantity" />

	<aui:model-context bean="<%= productPurchase %>" model="<%= ProductPurchase.class %>" />

	<aui:fieldset-group>
		<aui:fieldset>
			<c:choose>
				<c:when test="<%= productPurchase != null %>">
					<aui:input label="uuid" name="uuidLabel" type="resource" value="<%= productPurchase.getUuid() %>" />

					<%
					Account koroneikiAccount = productPurchase.getAccount();
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
					Project project = productPurchase.getProject();
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
					ProductEntry productEntry = productPurchase.getProductEntry();
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

			<%
			String taglibOnClick = renderResponse.getNamespace() + "toggleDate(this.checked, 'startDate');" + renderResponse.getNamespace() + "toggleDate(this.checked, 'endDate');";
			%>

			<aui:input checked="<%= perpetual %>" name="perpetual" onClick="<%= taglibOnClick %>" type="checkbox" />

			<aui:input disabled="<%= perpetual %>" name="startDate" showTime="<%= false %>" />

			<aui:input disabled="<%= perpetual %>" name="endDate" showTime="<%= false %>" />

			<aui:input name="quantity" value="<%= String.valueOf(quantity) %>" />
		</aui:fieldset>

		<div class="form-group">
			<h3 class="sheet-subtitle"><liferay-ui:message key="product-fields" /></h3>

			<aui:fieldset id='<%= renderResponse.getNamespace() + "productFields" %>'>

				<%
				List<ProductField> productFields = new ArrayList<>();

				if (productPurchase != null) {
					productFields.addAll(productPurchase.getProductFields());
				}

				if (productFields.isEmpty()) {
					productFields.add(ProductFieldLocalServiceUtil.createProductField(0));
				}

				int[] productFieldIndexes = new int[productFields.size()];

				for (int i = 0; i < productFields.size(); i++) {
					ProductField productField = productFields.get(i);

					productFieldIndexes[i] = i;
				%>

					<div class="lfr-form-row lfr-form-row-inline">
						<div class="row-fields">
							<aui:row>
								<aui:col md="5">
									<aui:input label="name" name='<%= "productFieldName_" + i %>' type="text" value="<%= productField.getName() %>" />
								</aui:col>

								<aui:col md="5">
									<aui:input label="value" name='<%= "productFieldValue_" + i %>' type="text" value="<%= productField.getValue() %>" />
								</aui:col>
							</aui:row>
						</div>
					</div>

				<%
				}
				%>

				<aui:input name="productFieldIndexes" type="hidden" value="<%= StringUtil.merge(productFieldIndexes) %>" />
			</aui:fieldset>
		</div>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button type="submit" />

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

	Liferay.provide(
		window,
		'<portlet:namespace />toggleDate',
		function(checked, dateParam) {
			var A = AUI();

			var dayField = A.one('#<portlet:namespace />' + dateParam + 'Day');

			if (dayField) {
				dayField.attr('disabled', checked);
			}

			var inputDateField = A.one('#<portlet:namespace />' + dateParam);

			if (inputDateField) {
				inputDateField.attr('disabled', checked);
			}

			var monthField = A.one('#<portlet:namespace />' + dateParam + 'Month');

			if (monthField) {
				monthField.attr('disabled', checked);
			}

			var yearField = A.one('#<portlet:namespace />' + dateParam + 'Year');

			if (yearField) {
				yearField.attr('disabled', checked);
			}
		},
		['aui-base']
	);
</aui:script>

<aui:script use="liferay-auto-fields">
	var autoFields = new Liferay.AutoFields(
		{
			contentBox: 'fieldset#<portlet:namespace />productFields',
			fieldIndexes: '<portlet:namespace />productFieldIndexes',
			namespace: '<portlet:namespace />'
		}
	).render();
</aui:script>