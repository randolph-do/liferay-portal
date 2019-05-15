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
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Contact;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Project;
import com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util.AccountUtil;
import com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util.ContactUtil;
import com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util.ProjectUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.AccountResource;
import com.liferay.osb.koroneiki.taproot.constants.ContactRoleType;
import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.osb.koroneiki.taproot.service.AccountService;
import com.liferay.osb.koroneiki.taproot.service.ContactAccountRoleService;
import com.liferay.osb.koroneiki.taproot.service.ContactRoleLocalService;
import com.liferay.osb.koroneiki.taproot.service.ContactService;
import com.liferay.osb.koroneiki.taproot.service.ProjectService;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

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
	public void deleteAccount(Long accountId) throws Exception {
		_accountService.deleteAccount(accountId);
	}

	@Override
	public void deleteAccountContact(Long accountId, Long[] contactIds)
		throws Exception {

		for (Long contactId : contactIds) {
			_contactAccountRoleService.deleteContactAccountRoles(
				contactId, accountId);
		}
	}

	@Override
	public void deleteAccountContactRole(
			Long accountId, Long contactId, Long[] contactRoleIds)
		throws Exception {

		for (Long contactRoleId : contactRoleIds) {
			_contactAccountRoleService.deleteContactAccountRole(
				contactId, accountId, contactRoleId);
		}
	}

	@Override
	public Account getAccount(Long accountId) throws Exception {
		return AccountUtil.toAccount(_accountService.getAccount(accountId));
	}

	@Override
	public Page<Contact> getAccountContactsPage(
			Long accountId, Pagination pagination)
		throws Exception {

		return Page.of(
			transform(
				_contactService.getAccountContacts(
					accountId, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ContactUtil::toContact),
			pagination, _contactService.getAccountContactsCount(accountId));
	}

	@Override
	public Page<Project> getAccountProjectsPage(
			Long accountId, Pagination pagination)
		throws Exception {

		return Page.of(
			transform(
				_projectService.getProjects(
					accountId, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ProjectUtil::toProject),
			pagination, _projectService.getProjectsCount(accountId));
	}

	@Override
	public Account postAccount(Account account) throws Exception {
		return AccountUtil.toAccount(
			_accountService.addAccount(
				account.getName(), account.getDescription(), 0, 0,
				StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
				StringPool.BLANK, StringPool.BLANK,
				WorkflowConstants.STATUS_APPROVED));
	}

	@Override
	public Account putAccount(Long accountId, Account account)
		throws Exception {

		return AccountUtil.toAccount(
			_accountService.updateAccount(
				accountId, account.getName(), account.getDescription(), 0, 0,
				StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
				StringPool.BLANK, StringPool.BLANK,
				WorkflowConstants.STATUS_APPROVED));
	}

	@Override
	public void putAccountContact(Long accountId, Long[] contactIds)
		throws Exception {

		ContactRole contactRole = _contactRoleLocalService.getMemberContactRole(
			ContactRoleType.ACCOUNT);

		for (Long contactId : contactIds) {
			_contactAccountRoleService.addContactAccountRole(
				contactId, accountId, contactRole.getContactRoleId());
		}
	}

	@Override
	public void putAccountContactRole(
			Long accountId, Long contactId, Long[] contactRoleIds)
		throws Exception {

		for (Long contactRoleId : contactRoleIds) {
			_contactAccountRoleService.addContactAccountRole(
				contactId, accountId, contactRoleId);
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