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

package com.liferay.osb.koroneiki.phloem.rest.resource.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Account;
import com.liferay.portal.kernel.model.Company;

import javax.annotation.Generated;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/koroneiki-rest/v1.0
 *
 * @author Amos Fong
 * @generated
 */
@Generated("")
public interface AccountResource {

	public Account postAccount(Account account) throws Exception;

	public void deleteAccount(Long accountId) throws Exception;

	public Account getAccount(Long accountId) throws Exception;

	public Account putAccount(Long accountId, Account account) throws Exception;

	public void deleteAccountContact(Long accountId, Long[] contactIds)
		throws Exception;

	public void putAccountContact(Long accountId, Long[] contactIds)
		throws Exception;

	public void deleteAccountContactRole(
			Long accountId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public void putAccountContactRole(
			Long accountId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}