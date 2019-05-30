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

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.AuditEntry;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

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
public interface AuditEntryResource {

	public Page<AuditEntry> getAccountAuditEntriesPage(
			Long accountId, Pagination pagination)
		throws Exception;

	public AuditEntry getAuditEntry(Long auditEntryId) throws Exception;

	public Page<AuditEntry> getContactRoleAuditEntriesPage(
			Long contactRoleId, Pagination pagination)
		throws Exception;

	public Page<AuditEntry> getContactAuditEntriesPage(
			Long contactId, Pagination pagination)
		throws Exception;

	public Page<AuditEntry> getProjectAuditEntriesPage(
			Long projectId, Pagination pagination)
		throws Exception;

	public Page<AuditEntry> getTeamRoleAuditEntriesPage(
			Long teamRoleId, Pagination pagination)
		throws Exception;

	public Page<AuditEntry> getTeamAuditEntriesPage(
			Long teamId, Pagination pagination)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}