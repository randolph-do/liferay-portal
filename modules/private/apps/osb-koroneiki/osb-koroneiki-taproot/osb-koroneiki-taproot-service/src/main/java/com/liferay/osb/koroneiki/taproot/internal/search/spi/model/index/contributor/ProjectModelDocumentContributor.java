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

package com.liferay.osb.koroneiki.taproot.internal.search.spi.model.index.contributor;

import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.osb.koroneiki.taproot.model.ContactProjectRole;
import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.service.ContactLocalService;
import com.liferay.osb.koroneiki.taproot.service.ContactProjectRoleLocalService;
import com.liferay.osb.koroneiki.taproot.service.ContactRoleLocalService;
import com.liferay.osb.koroneiki.trunk.model.ProductPurchase;
import com.liferay.osb.koroneiki.trunk.service.ProductPurchaseLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.osb.koroneiki.taproot.model.Project",
	service = ModelDocumentContributor.class
)
public class ProjectModelDocumentContributor
	implements ModelDocumentContributor<Project> {

	@Override
	public void contribute(Document document, Project project) {
		try {
			doContribute(document, project);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	public void doContribute(Document document, Project project)
		throws PortalException {

		document.addKeyword("accountKey", project.getAccountKey());
		document.addText("code", project.getCode());
		document.addDate("createDate", project.getCreateDate());
		document.addKeyword("industry", project.getIndustry());
		document.addDate("modifiedDate", project.getModifiedDate());
		document.addText("name", project.getName());
		document.addText("notes", project.getNotes());
		document.addKeyword("projectKey", project.getProjectKey());
		document.addKeyword("soldBy", project.getStatus());
		document.addKeyword("status", project.getStatus());
		document.addKeyword("tier", project.getTier());
		document.addKeyword("userId", project.getUserId());

		document.addTextSortable("code", project.getCode());
		document.addDateSortable("createDate", project.getCreateDate());
		document.addDateSortable("modifiedDate", project.getModifiedDate());
		document.addTextSortable("name", project.getName());

		contributeContacts(document, project.getProjectId());
		contributeProductEntries(document, project.getProjectId());
	}

	protected void contributeContacts(Document document, long projectId)
		throws PortalException {

		Set<String> contactKeys = new HashSet<>();
		Set<String> contactProjectRoleKeys = new HashSet<>();

		List<ContactProjectRole> contactProjectRoles =
			contactProjectRoleLocalService.getContactProjectRolesByProjectId(
				projectId);

		for (ContactProjectRole contactProjectRole : contactProjectRoles) {
			Contact contact = contactLocalService.getContact(
				contactProjectRole.getContactId());
			ContactRole contactRole = contactRoleLocalService.getContactRole(
				contactProjectRole.getContactRoleId());

			contactKeys.add(contact.getContactKey());
			contactProjectRoleKeys.add(
				contact.getContactKey() + StringPool.UNDERLINE +
					contactRole.getContactRoleKey());
		}

		document.addKeyword(
			"contactKeys", ArrayUtil.toStringArray(contactKeys.toArray()));
		document.addKeyword(
			"contactProjectRoleKeys",
			ArrayUtil.toStringArray(contactProjectRoleKeys.toArray()));
	}

	protected void contributeProductEntries(Document document, long projectId)
		throws PortalException {

		List<String> productEntryKeys = new ArrayList<>();

		List<ProductPurchase> productPurchases =
			productPurchaseLocalService.getProjectProductPurchases(
				projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (ProductPurchase productPurchase : productPurchases) {
			productEntryKeys.add(productPurchase.getProductEntryKey());
		}

		document.addKeyword(
			"productEntryKeys",
			ArrayUtil.toStringArray(productEntryKeys.toArray()));
	}

	@Reference
	protected ContactLocalService contactLocalService;

	@Reference
	protected ContactProjectRoleLocalService contactProjectRoleLocalService;

	@Reference
	protected ContactRoleLocalService contactRoleLocalService;

	@Reference
	protected ProductPurchaseLocalService productPurchaseLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		ProjectModelDocumentContributor.class);

}