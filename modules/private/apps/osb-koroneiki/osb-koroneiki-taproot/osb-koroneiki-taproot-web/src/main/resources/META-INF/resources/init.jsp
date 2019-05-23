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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPCreationMenu" %><%@
page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList" %><%@
page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem" %><%@
page import="com.liferay.osb.koroneiki.root.constants.RootWebKeys" %><%@
page import="com.liferay.osb.koroneiki.root.exception.ExternalLinkDomainException" %><%@
page import="com.liferay.osb.koroneiki.root.exception.ExternalLinkEntityIdException" %><%@
page import="com.liferay.osb.koroneiki.root.exception.ExternalLinkEntityNameException" %><%@
page import="com.liferay.osb.koroneiki.root.model.ExternalLink" %><%@
page import="com.liferay.osb.koroneiki.taproot.constants.ContactRoleType" %><%@
page import="com.liferay.osb.koroneiki.taproot.constants.TaprootPortletKeys" %><%@
page import="com.liferay.osb.koroneiki.taproot.constants.TaprootWebKeys" %><%@
page import="com.liferay.osb.koroneiki.taproot.exception.AccountNameException" %><%@
page import="com.liferay.osb.koroneiki.taproot.exception.ContactEmailAddressException" %><%@
page import="com.liferay.osb.koroneiki.taproot.exception.ContactRoleNameException" %><%@
page import="com.liferay.osb.koroneiki.taproot.exception.ContactRoleTypeException" %><%@
page import="com.liferay.osb.koroneiki.taproot.exception.NoSuchAccountException" %><%@
page import="com.liferay.osb.koroneiki.taproot.exception.NoSuchContactException" %><%@
page import="com.liferay.osb.koroneiki.taproot.exception.NoSuchContactRoleException" %><%@
page import="com.liferay.osb.koroneiki.taproot.exception.NoSuchProjectException" %><%@
page import="com.liferay.osb.koroneiki.taproot.exception.ProjectNameException" %><%@
page import="com.liferay.osb.koroneiki.taproot.model.Account" %><%@
page import="com.liferay.osb.koroneiki.taproot.model.Contact" %><%@
page import="com.liferay.osb.koroneiki.taproot.model.ContactRole" %><%@
page import="com.liferay.osb.koroneiki.taproot.model.Project" %><%@
page import="com.liferay.osb.koroneiki.taproot.service.AccountLocalServiceUtil" %><%@
page import="com.liferay.osb.koroneiki.taproot.service.ContactLocalServiceUtil" %><%@
page import="com.liferay.osb.koroneiki.taproot.service.ContactRoleLocalServiceUtil" %><%@
page import="com.liferay.osb.koroneiki.taproot.service.ProjectLocalServiceUtil" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.bean.BeanParamUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.servlet.SessionErrors" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.taglib.search.ResultRow" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.List" %>

<%@ page import="javax.portlet.PortletURL" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />