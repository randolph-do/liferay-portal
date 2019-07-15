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

package com.liferay.osb.koroneiki.phloem.rest.internal.resource.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Account;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.util.AccountUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.AccountResource;
import com.liferay.osb.koroneiki.taproot.constants.ContactRoleType;
import com.liferay.osb.koroneiki.taproot.constants.WorkflowConstants;
import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.osb.koroneiki.taproot.service.AccountService;
import com.liferay.osb.koroneiki.taproot.service.ContactAccountRoleService;
import com.liferay.osb.koroneiki.taproot.service.ContactRoleLocalService;
import com.liferay.osb.koroneiki.taproot.service.ContactService;
import com.liferay.osb.koroneiki.taproot.service.ProjectService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Amos Fong
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/account.properties",
	scope = ServiceScope.PROTOTYPE, service = AccountResource.class
)
public class AccountResourceImpl extends BaseAccountResourceImpl {

	@Override
	public void deleteAccount(String accountKey) throws Exception {
		_accountService.deleteAccount(accountKey);
	}

	@Override
	public void deleteAccountContact(String accountKey, String[] contactKeys)
		throws Exception {

		for (String contactKey : contactKeys) {
			_contactAccountRoleService.deleteContactAccountRoles(
				contactKey, accountKey);
		}
	}

	@Override
	public void deleteAccountContactContactKeyRole(
			String accountKey, String contactKey, String[] contactRoleKeys)
		throws Exception {

		for (String contactRoleKey : contactRoleKeys) {
			_contactAccountRoleService.deleteContactAccountRole(
				contactKey, accountKey, contactRoleKey);
		}
	}

	@Override
	public Account getAccount(String accountKey) throws Exception {
		return AccountUtil.toAccount(
			_accountService.getAccount(accountKey),
			contextAcceptLanguage.getPreferredLocale());
	}

	@Override
	public Account postAccount(Account account) throws Exception {
		Account.Status accountStatus = account.getStatus();

		int status = WorkflowConstants.getLabelStatus(accountStatus.toString());

		return AccountUtil.toAccount(
			_accountService.addAccount(
				account.getName(), account.getDescription(), 0,
				account.getContactEmailAddress(),
				account.getProfileEmailAddress(), account.getPhoneNumber(),
				account.getFaxNumber(), account.getWebsite(), status),
			contextAcceptLanguage.getPreferredLocale());
	}

	@Override
	public Account putAccount(String accountKey, Account account)
		throws Exception {

		Account.Status accountStatus = account.getStatus();

		int status = WorkflowConstants.getLabelStatus(accountStatus.toString());

		return AccountUtil.toAccount(
			_accountService.updateAccount(
				accountKey, account.getName(), account.getDescription(), 0,
				account.getContactEmailAddress(),
				account.getProfileEmailAddress(), account.getPhoneNumber(),
				account.getFaxNumber(), account.getWebsite(), status),
			contextAcceptLanguage.getPreferredLocale());
	}

	@Override
	public void putAccountContact(String accountKey, String[] contactKeys)
		throws Exception {

		ContactRole contactRole = _contactRoleLocalService.getMemberContactRole(
			ContactRoleType.ACCOUNT);

		for (String contactKey : contactKeys) {
			_contactAccountRoleService.addContactAccountRole(
				contactKey, accountKey, contactRole.getContactRoleKey());
		}
	}

	@Override
	public void putAccountContactContactKeyRole(
			String accountKey, String contactKey, String[] contactRoleKeys)
		throws Exception {

		for (String contactRoleKey : contactRoleKeys) {
			_contactAccountRoleService.addContactAccountRole(
				contactKey, accountKey, contactRoleKey);
		}
	}

	@Reference
	private AccountService _accountService;

	@Reference
	private ContactAccountRoleService _contactAccountRoleService;

	@Reference
	private ContactRoleLocalService _contactRoleLocalService;

	@Reference
	private ContactService _contactService;

	@Reference
	private ProjectService _projectService;

}