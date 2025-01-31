<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
long ctCollectionId = ParamUtil.getLong(request, "ctCollectionId");

CTCollection ctCollection = CTCollectionLocalServiceUtil.fetchCTCollection(ctCollectionId);

String changeListName = ParamUtil.getString(request, "changeListName");
String changeListDescription = ParamUtil.getString(request, "changeListDescription");

if (ctCollection != null) {
	changeListName = ctCollection.getName();
	changeListDescription = ctCollection.getDescription();
}
%>

<section class="modal-body">
	<liferay-portlet:actionURL name="/change_lists/publish_ct_collection" var="publishCollectionURL">
		<portlet:param name="ctCollectionId" value="<%= String.valueOf(ctCollectionId) %>" />
	</liferay-portlet:actionURL>

	<aui:form action="<%= publishCollectionURL.toString() %>" method="POST" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm()" %>'>
		<h4><liferay-ui:message key="change-list-name" />:</h4>

		<div class="sheet-text">
			<%= HtmlUtil.escape(changeListName) %>
		</div>

		<h4><liferay-ui:message key="description" />:</h4>

		<div class="sheet-text">
			<%= HtmlUtil.escape(changeListDescription) %>
		</div>

		<div class="form-group">
			<label class="toggle-switch">
				<input class="toggle-switch-check" data-qa-id="ignorecollision-toggle" id="<%= renderResponse.getNamespace() + "ignoreCollision" %>" name="<%= renderResponse.getNamespace() + "ignoreCollision" %>" onclick="<%= renderResponse.getNamespace() + "ignoreCheck();" %>" type="checkbox" />

				<span aria-hidden="true" class="toggle-switch-bar">
					<span class="toggle-switch-handle"></span>
				</span>
				<span class="toggle-label-text">
					<span class="custom-control-label-text">
						<liferay-ui:message key="ignore-collision" />
					</span>
				</span>
				<span class="toggle-switch-text toggle-switch-text-right">
					<liferay-ui:icon-help message="force-overwrite-the-colliding-entries-in-the-production-view-with-this-change-list" />
				</span>
			</label>
		</div>
	</aui:form>
</section>

<footer class="modal-footer publish-modal-footer">
	<aui:button onClick='<%= renderResponse.getNamespace() + "closeModal(true);" %>' value="cancel" />
	<aui:button type="submit" value="publish-to-live" />
</section>

<script>
	function <portlet:namespace/>closeModal(destroy) {
		Liferay.Util.getWindow('<portlet:namespace/>publishIconDialog').hide();

		if (destroy) {
			Liferay.Util.getWindow('<portlet:namespace/>publishIconDialog').destroy();
		}
	}

	function <portlet:namespace/>ignoreCheck() {
		let btn = document.querySelector('button[type="submit"]');

		btn.disabled = !event.target.checked;

		if (event.target.checked) {
			btn.classList.remove('disabled');
		}
		else {
			btn.classList.add('disabled');
		}
	}

	function <portlet:namespace/>submitForm(event) {
		var form = AUI().one('#<portlet:namespace/>fm');

		Liferay.Util.getOpener().Liferay.fire('<portlet:namespace/>refreshChangeListHistory');

		Liferay.Util.submitForm(form);

		<portlet:namespace/>closeModal(false);
	}
</script>