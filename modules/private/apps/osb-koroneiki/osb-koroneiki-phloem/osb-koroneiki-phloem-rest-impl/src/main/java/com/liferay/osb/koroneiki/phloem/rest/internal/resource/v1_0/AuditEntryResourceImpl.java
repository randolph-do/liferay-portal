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

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.AuditEntry;
import com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util.AuditEntryUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.AuditEntryResource;
import com.liferay.osb.koroneiki.root.service.AuditEntryService;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.osb.koroneiki.taproot.model.ContactRole;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.model.Team;
import com.liferay.osb.koroneiki.taproot.model.TeamRole;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Amos Fong
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/audit-entry.properties",
	scope = ServiceScope.PROTOTYPE, service = AuditEntryResource.class
)
public class AuditEntryResourceImpl extends BaseAuditEntryResourceImpl {

	@Override
	public Page<AuditEntry> getAccountAuditEntriesPage(
			Long accountId, Pagination pagination)
		throws Exception {

		return getAuditEntriesPage(Account.class, accountId, pagination);
	}

	@Override
	public AuditEntry getAuditEntry(Long auditEntryId) throws Exception {
		return AuditEntryUtil.toAuditEntry(
			_auditEntryService.getAuditEntry(auditEntryId));
	}

	@Override
	public Page<AuditEntry> getContactAuditEntriesPage(
			Long contactId, Pagination pagination)
		throws Exception {

		return getAuditEntriesPage(Contact.class, contactId, pagination);
	}

	@Override
	public Page<AuditEntry> getContactRoleAuditEntriesPage(
			Long contactRoleId, Pagination pagination)
		throws Exception {

		return getAuditEntriesPage(
			ContactRole.class, contactRoleId, pagination);
	}

	@Override
	public Page<AuditEntry> getProjectAuditEntriesPage(
			Long projectId, Pagination pagination)
		throws Exception {

		return getAuditEntriesPage(Project.class, projectId, pagination);
	}

	@Override
	public Page<AuditEntry> getTeamAuditEntriesPage(
			Long teamId, Pagination pagination)
		throws Exception {

		return getAuditEntriesPage(Team.class, teamId, pagination);
	}

	@Override
	public Page<AuditEntry> getTeamRoleAuditEntriesPage(
			Long teamRoleId, Pagination pagination)
		throws Exception {

		return getAuditEntriesPage(TeamRole.class, teamRoleId, pagination);
	}

	protected Page<AuditEntry> getAuditEntriesPage(
			Class<?> clazz, long classPK, Pagination pagination)
		throws Exception {

		long classNameId = _classNameLocalService.getClassNameId(clazz);

		return Page.of(
			transform(
				_auditEntryService.getAuditEntries(
					classNameId, classPK, pagination.getStartPosition(),
					pagination.getEndPosition()),
				AuditEntryUtil::toAuditEntry),
			pagination,
			_auditEntryService.getAuditEntriesCount(classNameId, classPK));
	}

	@Reference
	private AuditEntryService _auditEntryService;

	@Reference
	private ClassNameLocalService _classNameLocalService;

}