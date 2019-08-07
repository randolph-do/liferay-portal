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

import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.osb.koroneiki.taproot.service.ContactLocalService;
import com.liferay.osb.koroneiki.trunk.model.ProductPurchase;
import com.liferay.osb.koroneiki.trunk.service.ProductPurchaseLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.osb.koroneiki.taproot.model.Account",
	service = ModelDocumentContributor.class
)
public class AccountModelDocumentContributor
	implements ModelDocumentContributor<Account> {

	@Override
	public void contribute(Document document, Account account) {
		document.addKeyword("accountKey", account.getAccountKey());
		document.addKeyword(
			"contactEmailAddress", account.getContactEmailAddress());
		document.addDate("createDate", account.getCreateDate());
		document.addText("description", account.getDescription());
		document.addKeyword("faxNumber", account.getFaxNumber());
		document.addDate("modifiedDate", account.getModifiedDate());
		document.addText("name", account.getName());
		document.addKeyword("phoneNumber", account.getPhoneNumber());
		document.addKeyword(
			"profileEmailAddress", account.getProfileEmailAddress());
		document.addKeyword("status", account.getStatus());
		document.addKeyword("userId", account.getUserId());
		document.addKeyword("website", account.getWebsite());

		document.addDateSortable("createDate", account.getCreateDate());
		document.addDateSortable("modifiedDate", account.getModifiedDate());
		document.addTextSortable("name", account.getName());

		_contributeContacts(document, account.getAccountId());
		_contributeProductEntries(document, account.getAccountId());
	}

	private void _contributeContacts(Document document, long accountId) {
		List<String> contactKeys = new ArrayList<>();

		List<Contact> contacts = _contactLocalService.getAccountContacts(
			accountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (Contact contact : contacts) {
			contactKeys.add(contact.getContactKey());
		}

		document.addKeyword(
			"contactKeys", ArrayUtil.toStringArray(contactKeys.toArray()));
	}

	private void _contributeProductEntries(Document document, long accountId) {
		List<String> productEntryKeys = new ArrayList<>();

		List<ProductPurchase> productPurchases =
			_productPurchaseLocalService.getAccountProductPurchases(
				accountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (ProductPurchase productPurchase : productPurchases) {
			try {
				productEntryKeys.add(productPurchase.getProductEntryKey());
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}

		document.addKeyword(
			"productEntryKeys",
			ArrayUtil.toStringArray(productEntryKeys.toArray()));
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AccountModelDocumentContributor.class);

	@Reference
	private ContactLocalService _contactLocalService;

	@Reference
	private ProductPurchaseLocalService _productPurchaseLocalService;

}