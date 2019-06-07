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

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ExternalLink;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ExternalLinkResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseExternalLinkResourceImpl
	implements ExternalLinkResource {

	@Override
	@GET
	@Operation(description = "Retrieves the account's external links.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "accountId"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path("/accounts/{accountId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public Page<ExternalLink> getAccountExternalLinksPage(
			@NotNull @Parameter(hidden = true) @PathParam("accountId") Long
				accountId,
			@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Adds an external link to the account.")
	@POST
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "accountId")})
	@Path("/accounts/{accountId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public ExternalLink postAccountExternalLink(
			@NotNull @Parameter(hidden = true) @PathParam("accountId") Long
				accountId,
			ExternalLink externalLink)
		throws Exception {

		return new ExternalLink();
	}

	@Override
	@GET
	@Operation(description = "Retrieves the contact's external links.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "contactId"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path("/contacts/{contactId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public Page<ExternalLink> getContactExternalLinksPage(
			@NotNull @Parameter(hidden = true) @PathParam("contactId") Long
				contactId,
			@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Adds an external link to the contact.")
	@POST
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "contactId")})
	@Path("/contacts/{contactId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public ExternalLink postContactExternalLink(
			@NotNull @Parameter(hidden = true) @PathParam("contactId") Long
				contactId,
			ExternalLink externalLink)
		throws Exception {

		return new ExternalLink();
	}

	@Override
	@DELETE
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "externalLinkId")}
	)
	@Path("/external-links/{externalLinkId}")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "ExternalLink")})
	public void deleteExternalLink(
			@NotNull @Parameter(hidden = true) @PathParam("externalLinkId") Long
				externalLinkId)
		throws Exception {
	}

	@Override
	@GET
	@Operation(description = "Retrieves the external link.")
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "externalLinkId")}
	)
	@Path("/external-links/{externalLinkId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public ExternalLink getExternalLink(
			@NotNull @Parameter(hidden = true) @PathParam("externalLinkId") Long
				externalLinkId)
		throws Exception {

		return new ExternalLink();
	}

	@Override
	@GET
	@Operation(description = "Retrieves the product purchase's external links.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "productConsumptionId"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path("/product-consumptions/{productConsumptionId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public Page<ExternalLink> getProductConsumptionExternalLinksPage(
			@NotNull @Parameter(hidden = true)
			@PathParam("productConsumptionId") Long productConsumptionId,
			@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(
		description = "Adds an external link to the product consumption."
	)
	@POST
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "productConsumptionId")
		}
	)
	@Path("/product-consumptions/{productConsumptionId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public ExternalLink postProductConsumptionExternalLink(
			@NotNull @Parameter(hidden = true)
			@PathParam("productConsumptionId") Long productConsumptionId,
			ExternalLink externalLink)
		throws Exception {

		return new ExternalLink();
	}

	@Override
	@GET
	@Operation(description = "Retrieves the product purchase's external links.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "productPurchaseId"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path("/product-purchases/{productPurchaseId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public Page<ExternalLink> getProductPurchaseExternalLinksPage(
			@NotNull @Parameter(hidden = true) @PathParam("productPurchaseId")
				Long productPurchaseId,
			@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Adds an external link to the product purchase.")
	@POST
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "productPurchaseId")}
	)
	@Path("/product-purchases/{productPurchaseId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public ExternalLink postProductPurchaseExternalLink(
			@NotNull @Parameter(hidden = true) @PathParam("productPurchaseId")
				Long productPurchaseId,
			ExternalLink externalLink)
		throws Exception {

		return new ExternalLink();
	}

	@Override
	@GET
	@Operation(description = "Retrieves the product's external links.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "productId"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path("/products/{productId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public Page<ExternalLink> getProductExternalLinksPage(
			@NotNull @Parameter(hidden = true) @PathParam("productId") Long
				productId,
			@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Adds an external link to the product.")
	@POST
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "productId")})
	@Path("/products/{productId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public ExternalLink postProductExternalLink(
			@NotNull @Parameter(hidden = true) @PathParam("productId") Long
				productId,
			ExternalLink externalLink)
		throws Exception {

		return new ExternalLink();
	}

	@Override
	@GET
	@Operation(description = "Retrieves the project's external links.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "projectId"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path("/projects/{projectId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public Page<ExternalLink> getProjectExternalLinksPage(
			@NotNull @Parameter(hidden = true) @PathParam("projectId") Long
				projectId,
			@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Adds an external link to the project.")
	@POST
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "projectId")})
	@Path("/projects/{projectId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public ExternalLink postProjectExternalLink(
			@NotNull @Parameter(hidden = true) @PathParam("projectId") Long
				projectId,
			ExternalLink externalLink)
		throws Exception {

		return new ExternalLink();
	}

	@Override
	@GET
	@Operation(description = "Retrieves the team's external links.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "teamId"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path("/teams/{teamId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public Page<ExternalLink> getTeamExternalLinksPage(
			@NotNull @Parameter(hidden = true) @PathParam("teamId") Long teamId,
			@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Adds an external link to the team.")
	@POST
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "teamId")})
	@Path("/teams/{teamId}/external-links")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ExternalLink")})
	public ExternalLink postTeamExternalLink(
			@NotNull @Parameter(hidden = true) @PathParam("teamId") Long teamId,
			ExternalLink externalLink)
		throws Exception {

		return new ExternalLink();
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(
		ExternalLink externalLink, ExternalLink existingExternalLink) {
	}

	protected <T, R> List<R> transform(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	@Context
	protected AcceptLanguage contextAcceptLanguage;

	@Context
	protected Company contextCompany;

	@Context
	protected UriInfo contextUriInfo;

}