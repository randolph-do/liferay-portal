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

package com.liferay.osb.koroneiki.phloem.rest.internal.graphql.query.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Account;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.AuditEntry;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Contact;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ContactRole;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ExternalLink;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Project;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Team;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.TeamRole;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.AccountResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.AuditEntryResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ContactResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ContactRoleResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ExternalLinkResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProjectResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.TeamResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.TeamRoleResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Collection;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public class Query {

	public static void setAccountResourceComponentServiceObjects(
		ComponentServiceObjects<AccountResource>
			accountResourceComponentServiceObjects) {

		_accountResourceComponentServiceObjects =
			accountResourceComponentServiceObjects;
	}

	public static void setAuditEntryResourceComponentServiceObjects(
		ComponentServiceObjects<AuditEntryResource>
			auditEntryResourceComponentServiceObjects) {

		_auditEntryResourceComponentServiceObjects =
			auditEntryResourceComponentServiceObjects;
	}

	public static void setContactResourceComponentServiceObjects(
		ComponentServiceObjects<ContactResource>
			contactResourceComponentServiceObjects) {

		_contactResourceComponentServiceObjects =
			contactResourceComponentServiceObjects;
	}

	public static void setContactRoleResourceComponentServiceObjects(
		ComponentServiceObjects<ContactRoleResource>
			contactRoleResourceComponentServiceObjects) {

		_contactRoleResourceComponentServiceObjects =
			contactRoleResourceComponentServiceObjects;
	}

	public static void setExternalLinkResourceComponentServiceObjects(
		ComponentServiceObjects<ExternalLinkResource>
			externalLinkResourceComponentServiceObjects) {

		_externalLinkResourceComponentServiceObjects =
			externalLinkResourceComponentServiceObjects;
	}

	public static void setProjectResourceComponentServiceObjects(
		ComponentServiceObjects<ProjectResource>
			projectResourceComponentServiceObjects) {

		_projectResourceComponentServiceObjects =
			projectResourceComponentServiceObjects;
	}

	public static void setTeamResourceComponentServiceObjects(
		ComponentServiceObjects<TeamResource>
			teamResourceComponentServiceObjects) {

		_teamResourceComponentServiceObjects =
			teamResourceComponentServiceObjects;
	}

	public static void setTeamRoleResourceComponentServiceObjects(
		ComponentServiceObjects<TeamRoleResource>
			teamRoleResourceComponentServiceObjects) {

		_teamRoleResourceComponentServiceObjects =
			teamRoleResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Account getAccount(@GraphQLName("accountId") Long accountId)
		throws Exception {

		return _applyComponentServiceObjects(
			_accountResourceComponentServiceObjects,
			this::_populateResourceContext,
			accountResource -> accountResource.getAccount(accountId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<AuditEntry> getAccountAuditEntriesPage(
			@GraphQLName("accountId") Long accountId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_auditEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			auditEntryResource -> {
				Page paginationPage =
					auditEntryResource.getAccountAuditEntriesPage(
						accountId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public AuditEntry getAuditEntry(
			@GraphQLName("auditEntryId") Long auditEntryId)
		throws Exception {

		return _applyComponentServiceObjects(
			_auditEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			auditEntryResource -> auditEntryResource.getAuditEntry(
				auditEntryId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<AuditEntry> getContactRoleAuditEntriesPage(
			@GraphQLName("contactRoleId") Long contactRoleId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_auditEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			auditEntryResource -> {
				Page paginationPage =
					auditEntryResource.getContactRoleAuditEntriesPage(
						contactRoleId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<AuditEntry> getContactAuditEntriesPage(
			@GraphQLName("contactId") Long contactId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_auditEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			auditEntryResource -> {
				Page paginationPage =
					auditEntryResource.getContactAuditEntriesPage(
						contactId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<AuditEntry> getProjectAuditEntriesPage(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_auditEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			auditEntryResource -> {
				Page paginationPage =
					auditEntryResource.getProjectAuditEntriesPage(
						projectId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<AuditEntry> getTeamRoleAuditEntriesPage(
			@GraphQLName("teamRoleId") Long teamRoleId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_auditEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			auditEntryResource -> {
				Page paginationPage =
					auditEntryResource.getTeamRoleAuditEntriesPage(
						teamRoleId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<AuditEntry> getTeamAuditEntriesPage(
			@GraphQLName("teamId") Long teamId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_auditEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			auditEntryResource -> {
				Page paginationPage =
					auditEntryResource.getTeamAuditEntriesPage(
						teamId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Contact> getAccountContactsPage(
			@GraphQLName("accountId") Long accountId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactResource -> {
				Page paginationPage = contactResource.getAccountContactsPage(
					accountId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Contact getContact(@GraphQLName("contactId") Long contactId)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactResource -> contactResource.getContact(contactId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Contact> getProjectContactsPage(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactResource -> {
				Page paginationPage = contactResource.getProjectContactsPage(
					projectId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public ContactRole getContactRole(
			@GraphQLName("contactRoleId") Long contactRoleId)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactRoleResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactRoleResource -> contactRoleResource.getContactRole(
				contactRoleId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<ExternalLink> getAccountExternalLinksPage(
			@GraphQLName("accountId") Long accountId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_externalLinkResourceComponentServiceObjects,
			this::_populateResourceContext,
			externalLinkResource -> {
				Page paginationPage =
					externalLinkResource.getAccountExternalLinksPage(
						accountId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<ExternalLink> getContactExternalLinksPage(
			@GraphQLName("contactId") Long contactId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_externalLinkResourceComponentServiceObjects,
			this::_populateResourceContext,
			externalLinkResource -> {
				Page paginationPage =
					externalLinkResource.getContactExternalLinksPage(
						contactId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public ExternalLink getExternalLink(
			@GraphQLName("externalLinkId") Long externalLinkId)
		throws Exception {

		return _applyComponentServiceObjects(
			_externalLinkResourceComponentServiceObjects,
			this::_populateResourceContext,
			externalLinkResource -> externalLinkResource.getExternalLink(
				externalLinkId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<ExternalLink> getProjectExternalLinksPage(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_externalLinkResourceComponentServiceObjects,
			this::_populateResourceContext,
			externalLinkResource -> {
				Page paginationPage =
					externalLinkResource.getProjectExternalLinksPage(
						projectId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<ExternalLink> getTeamExternalLinksPage(
			@GraphQLName("teamId") Long teamId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_externalLinkResourceComponentServiceObjects,
			this::_populateResourceContext,
			externalLinkResource -> {
				Page paginationPage =
					externalLinkResource.getTeamExternalLinksPage(
						teamId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Project> getAccountProjectsPage(
			@GraphQLName("accountId") Long accountId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> {
				Page paginationPage = projectResource.getAccountProjectsPage(
					accountId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Project getProject(@GraphQLName("projectId") Long projectId)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.getProject(projectId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Team> getAccountTeamsPage(
			@GraphQLName("accountId") Long accountId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_teamResourceComponentServiceObjects,
			this::_populateResourceContext,
			teamResource -> {
				Page paginationPage = teamResource.getAccountTeamsPage(
					accountId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Team getTeam(@GraphQLName("teamId") Long teamId) throws Exception {
		return _applyComponentServiceObjects(
			_teamResourceComponentServiceObjects,
			this::_populateResourceContext,
			teamResource -> teamResource.getTeam(teamId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public TeamRole getTeamRole(@GraphQLName("teamRoleId") Long teamRoleId)
		throws Exception {

		return _applyComponentServiceObjects(
			_teamRoleResourceComponentServiceObjects,
			this::_populateResourceContext,
			teamRoleResource -> teamRoleResource.getTeamRole(teamRoleId));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(AccountResource accountResource)
		throws Exception {

		accountResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(AuditEntryResource auditEntryResource)
		throws Exception {

		auditEntryResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(ContactResource contactResource)
		throws Exception {

		contactResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(
			ContactRoleResource contactRoleResource)
		throws Exception {

		contactRoleResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(
			ExternalLinkResource externalLinkResource)
		throws Exception {

		externalLinkResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(ProjectResource projectResource)
		throws Exception {

		projectResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(TeamResource teamResource)
		throws Exception {

		teamResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(TeamRoleResource teamRoleResource)
		throws Exception {

		teamRoleResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<AccountResource>
		_accountResourceComponentServiceObjects;
	private static ComponentServiceObjects<AuditEntryResource>
		_auditEntryResourceComponentServiceObjects;
	private static ComponentServiceObjects<ContactResource>
		_contactResourceComponentServiceObjects;
	private static ComponentServiceObjects<ContactRoleResource>
		_contactRoleResourceComponentServiceObjects;
	private static ComponentServiceObjects<ExternalLinkResource>
		_externalLinkResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProjectResource>
		_projectResourceComponentServiceObjects;
	private static ComponentServiceObjects<TeamResource>
		_teamResourceComponentServiceObjects;
	private static ComponentServiceObjects<TeamRoleResource>
		_teamRoleResourceComponentServiceObjects;

}