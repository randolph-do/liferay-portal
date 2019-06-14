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
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Product;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ProductConsumption;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ProductPurchase;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Project;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Team;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.TeamRole;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.AccountResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.AuditEntryResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ContactResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ContactRoleResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ExternalLinkResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProductConsumptionResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProductPurchaseResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProductResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProjectResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.TeamResource;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.TeamRoleResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

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

	public static void setProductResourceComponentServiceObjects(
		ComponentServiceObjects<ProductResource>
			productResourceComponentServiceObjects) {

		_productResourceComponentServiceObjects =
			productResourceComponentServiceObjects;
	}

	public static void setProductConsumptionResourceComponentServiceObjects(
		ComponentServiceObjects<ProductConsumptionResource>
			productConsumptionResourceComponentServiceObjects) {

		_productConsumptionResourceComponentServiceObjects =
			productConsumptionResourceComponentServiceObjects;
	}

	public static void setProductPurchaseResourceComponentServiceObjects(
		ComponentServiceObjects<ProductPurchaseResource>
			productPurchaseResourceComponentServiceObjects) {

		_productPurchaseResourceComponentServiceObjects =
			productPurchaseResourceComponentServiceObjects;
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
	public java.util.Collection<AuditEntry> getAccountAuditEntriesPage(
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
	public java.util.Collection<AuditEntry> getContactRoleAuditEntriesPage(
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
	public java.util.Collection<AuditEntry> getContactAuditEntriesPage(
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
	public java.util.Collection<AuditEntry> getProjectAuditEntriesPage(
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
	public java.util.Collection<AuditEntry> getTeamRoleAuditEntriesPage(
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
	public java.util.Collection<AuditEntry> getTeamAuditEntriesPage(
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
	public java.util.Collection<Contact> getAccountContactsPage(
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
	public java.util.Collection<Contact> getProjectContactsPage(
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
	public java.util.Collection<ExternalLink> getAccountExternalLinksPage(
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
	public java.util.Collection<ExternalLink> getContactExternalLinksPage(
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
	public java.util.Collection<ExternalLink>
			getProductConsumptionExternalLinksPage(
				@GraphQLName("productConsumptionId") Long productConsumptionId,
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_externalLinkResourceComponentServiceObjects,
			this::_populateResourceContext,
			externalLinkResource -> {
				Page paginationPage =
					externalLinkResource.getProductConsumptionExternalLinksPage(
						productConsumptionId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public java.util.Collection<ExternalLink>
			getProductPurchaseExternalLinksPage(
				@GraphQLName("productPurchaseId") Long productPurchaseId,
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_externalLinkResourceComponentServiceObjects,
			this::_populateResourceContext,
			externalLinkResource -> {
				Page paginationPage =
					externalLinkResource.getProductPurchaseExternalLinksPage(
						productPurchaseId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public java.util.Collection<ExternalLink> getProductExternalLinksPage(
			@GraphQLName("productId") Long productId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_externalLinkResourceComponentServiceObjects,
			this::_populateResourceContext,
			externalLinkResource -> {
				Page paginationPage =
					externalLinkResource.getProductExternalLinksPage(
						productId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public java.util.Collection<ExternalLink> getProjectExternalLinksPage(
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
	public java.util.Collection<ExternalLink> getTeamExternalLinksPage(
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
	public java.util.Collection<Product> getProductsPage(
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_productResourceComponentServiceObjects,
			this::_populateResourceContext,
			productResource -> {
				Page paginationPage = productResource.getProductsPage(
					Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Product getProduct(@GraphQLName("productId") Long productId)
		throws Exception {

		return _applyComponentServiceObjects(
			_productResourceComponentServiceObjects,
			this::_populateResourceContext,
			productResource -> productResource.getProduct(productId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public java.util.Collection<ProductConsumption>
			getAccountProductConsumptionsPage(
				@GraphQLName("accountId") Long accountId,
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_productConsumptionResourceComponentServiceObjects,
			this::_populateResourceContext,
			productConsumptionResource -> {
				Page paginationPage =
					productConsumptionResource.
						getAccountProductConsumptionsPage(
							accountId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public ProductConsumption getProductConsumption(
			@GraphQLName("productConsumptionId") Long productConsumptionId)
		throws Exception {

		return _applyComponentServiceObjects(
			_productConsumptionResourceComponentServiceObjects,
			this::_populateResourceContext,
			productConsumptionResource ->
				productConsumptionResource.getProductConsumption(
					productConsumptionId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public java.util.Collection<ProductConsumption>
			getProjectProductConsumptionsPage(
				@GraphQLName("projectId") Long projectId,
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_productConsumptionResourceComponentServiceObjects,
			this::_populateResourceContext,
			productConsumptionResource -> {
				Page paginationPage =
					productConsumptionResource.
						getProjectProductConsumptionsPage(
							projectId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public java.util.Collection<ProductPurchase> getAccountProductPurchasesPage(
			@GraphQLName("accountId") Long accountId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_productPurchaseResourceComponentServiceObjects,
			this::_populateResourceContext,
			productPurchaseResource -> {
				Page paginationPage =
					productPurchaseResource.getAccountProductPurchasesPage(
						accountId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public ProductPurchase getProductPurchase(
			@GraphQLName("productPurchaseId") Long productPurchaseId)
		throws Exception {

		return _applyComponentServiceObjects(
			_productPurchaseResourceComponentServiceObjects,
			this::_populateResourceContext,
			productPurchaseResource ->
				productPurchaseResource.getProductPurchase(productPurchaseId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public java.util.Collection<ProductPurchase> getProjectProductPurchasesPage(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_productPurchaseResourceComponentServiceObjects,
			this::_populateResourceContext,
			productPurchaseResource -> {
				Page paginationPage =
					productPurchaseResource.getProjectProductPurchasesPage(
						projectId, Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public java.util.Collection<Project> getAccountProjectsPage(
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
	public java.util.Collection<Team> getAccountTeamsPage(
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

		accountResource.setContextAcceptLanguage(_acceptLanguage);
		accountResource.setContextCompany(_company);
	}

	private void _populateResourceContext(AuditEntryResource auditEntryResource)
		throws Exception {

		auditEntryResource.setContextAcceptLanguage(_acceptLanguage);
		auditEntryResource.setContextCompany(_company);
	}

	private void _populateResourceContext(ContactResource contactResource)
		throws Exception {

		contactResource.setContextAcceptLanguage(_acceptLanguage);
		contactResource.setContextCompany(_company);
	}

	private void _populateResourceContext(
			ContactRoleResource contactRoleResource)
		throws Exception {

		contactRoleResource.setContextAcceptLanguage(_acceptLanguage);
		contactRoleResource.setContextCompany(_company);
	}

	private void _populateResourceContext(
			ExternalLinkResource externalLinkResource)
		throws Exception {

		externalLinkResource.setContextAcceptLanguage(_acceptLanguage);
		externalLinkResource.setContextCompany(_company);
	}

	private void _populateResourceContext(ProductResource productResource)
		throws Exception {

		productResource.setContextAcceptLanguage(_acceptLanguage);
		productResource.setContextCompany(_company);
	}

	private void _populateResourceContext(
			ProductConsumptionResource productConsumptionResource)
		throws Exception {

		productConsumptionResource.setContextAcceptLanguage(_acceptLanguage);
		productConsumptionResource.setContextCompany(_company);
	}

	private void _populateResourceContext(
			ProductPurchaseResource productPurchaseResource)
		throws Exception {

		productPurchaseResource.setContextAcceptLanguage(_acceptLanguage);
		productPurchaseResource.setContextCompany(_company);
	}

	private void _populateResourceContext(ProjectResource projectResource)
		throws Exception {

		projectResource.setContextAcceptLanguage(_acceptLanguage);
		projectResource.setContextCompany(_company);
	}

	private void _populateResourceContext(TeamResource teamResource)
		throws Exception {

		teamResource.setContextAcceptLanguage(_acceptLanguage);
		teamResource.setContextCompany(_company);
	}

	private void _populateResourceContext(TeamRoleResource teamRoleResource)
		throws Exception {

		teamRoleResource.setContextAcceptLanguage(_acceptLanguage);
		teamRoleResource.setContextCompany(_company);
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
	private static ComponentServiceObjects<ProductResource>
		_productResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductConsumptionResource>
		_productConsumptionResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductPurchaseResource>
		_productPurchaseResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProjectResource>
		_projectResourceComponentServiceObjects;
	private static ComponentServiceObjects<TeamResource>
		_teamResourceComponentServiceObjects;
	private static ComponentServiceObjects<TeamRoleResource>
		_teamRoleResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private Company _company;

}