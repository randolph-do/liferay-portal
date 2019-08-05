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

import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.osb.koroneiki.taproot.model.ContactRole",
	service = ModelDocumentContributor.class
)
public class ContactRoleModelDocumentContributor
	implements ModelDocumentContributor<ContactRole> {

	@Override
	public void contribute(Document document, ContactRole contactRole) {
		document.addKeyword("contactRoleKey", contactRole.getContactRoleKey());
		document.addDate("createDate", contactRole.getCreateDate());
		document.addText("description", contactRole.getDescription());
		document.addDate("modifiedDate", contactRole.getModifiedDate());
		document.addText("name", contactRole.getName());
		document.addKeyword("system", contactRole.isSystem());
		document.addKeyword("type", contactRole.getTypeLabel());

		document.addDateSortable("createDate", contactRole.getCreateDate());
		document.addDateSortable("modifiedDate", contactRole.getModifiedDate());
		document.addTextSortable("name", contactRole.getName());
	}

}