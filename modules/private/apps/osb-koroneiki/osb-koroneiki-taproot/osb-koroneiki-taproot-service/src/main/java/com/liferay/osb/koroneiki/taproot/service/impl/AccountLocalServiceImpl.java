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

package com.liferay.osb.koroneiki.taproot.service.impl;

import com.liferay.osb.koroneiki.root.service.ExternalLinkLocalService;
import com.liferay.osb.koroneiki.taproot.exception.AccountNameException;
import com.liferay.osb.koroneiki.taproot.exception.RequiredAccountException;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.service.base.AccountLocalServiceBaseImpl;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.osb.koroneiki.taproot.model.Account",
	service = AopService.class
)
public class AccountLocalServiceImpl extends AccountLocalServiceBaseImpl {

	public Account addAccount(
			long userId, String name, String description, long logoId,
			long addressId, String contactEmailAddress,
			String profileEmailAddress, String phoneNumber, String faxNumber,
			String website, int status)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		validate(name);

		long accountId = counterLocalService.increment();

		Account account = accountPersistence.create(accountId);

		account.setCompanyId(user.getCompanyId());
		account.setUserId(userId);
		account.setName(name);
		account.setDescription(description);
		account.setLogoId(logoId);
		account.setAddressId(addressId);
		account.setContactEmailAddress(contactEmailAddress);
		account.setProfileEmailAddress(profileEmailAddress);
		account.setPhoneNumber(phoneNumber);
		account.setFaxNumber(faxNumber);
		account.setWebsite(website);
		account.setStatus(status);
		account.setStatusByUserId(userId);
		account.setStatusByUserName(user.getFullName());
		account.setStatusDate(new Date());
		account.setStatusMessage(StringPool.BLANK);

		accountPersistence.update(account);

		// Resources

		resourceLocalService.addResources(
			account.getCompanyId(), 0, userId, Account.class.getName(),
			account.getAccountId(), false, false, false);

		return account;
	}

	@Override
	public Account deleteAccount(long accountId) throws PortalException {
		Account account = accountLocalService.getAccount(accountId);

		if (projectPersistence.countByAccountId(accountId) > 0) {
			throw new RequiredAccountException();
		}

		// Contact account roles

		contactAccountRolePersistence.removeByAccountId(accountId);

		// External links

		long classNameId = classNameLocalService.getClassNameId(Account.class);

		_externalLinkLocalService.deleteExternalLinks(classNameId, accountId);

		// Resources

		resourceLocalService.deleteResource(
			account.getCompanyId(), Account.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, account.getAccountId());

		// Teams

		teamPersistence.removeByAccountId(accountId);

		return accountPersistence.remove(accountId);
	}

	public Account updateAccount(
			long userId, long accountId, String name, String description,
			long logoId, long addressId, String contactEmailAddress,
			String profileEmailAddress, String phoneNumber, String faxNumber,
			String website, int status)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		validate(name);

		Account account = accountPersistence.findByPrimaryKey(accountId);

		account.setName(name);
		account.setDescription(description);
		account.setLogoId(logoId);
		account.setAddressId(addressId);
		account.setContactEmailAddress(contactEmailAddress);
		account.setProfileEmailAddress(profileEmailAddress);
		account.setPhoneNumber(phoneNumber);
		account.setFaxNumber(faxNumber);
		account.setWebsite(website);
		account.setStatus(status);
		account.setStatusByUserId(userId);
		account.setStatusByUserName(user.getFullName());
		account.setStatusDate(new Date());
		account.setStatusMessage(StringPool.BLANK);

		return accountPersistence.update(account);
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new AccountNameException();
		}
	}

	@Reference
	private ExternalLinkLocalService _externalLinkLocalService;

}