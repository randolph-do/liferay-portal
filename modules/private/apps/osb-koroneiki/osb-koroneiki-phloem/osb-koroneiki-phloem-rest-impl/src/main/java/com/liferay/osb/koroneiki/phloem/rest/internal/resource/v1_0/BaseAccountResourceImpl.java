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
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.AccountResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.util.TransformUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.List;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseAccountResourceImpl implements AccountResource {

	@Override
	@Consumes({"application/json", "application/xml"})
	@POST
	@Path("/accounts")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Account")})
	public Account postAccount(Account account) throws Exception {
		return new Account();
	}

	@Override
	@DELETE
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "accountId")})
	@Path("/accounts/{accountId}")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Account")})
	public void deleteAccount(
			@NotNull @Parameter(hidden = true) @PathParam("accountId") Long
				accountId)
		throws Exception {
	}

	@Override
	@GET
	@Operation(description = "Retrieves the account.")
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "accountId")})
	@Path("/accounts/{accountId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Account")})
	public Account getAccount(
			@NotNull @Parameter(hidden = true) @PathParam("accountId") Long
				accountId)
		throws Exception {

		return new Account();
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@PUT
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "accountId")})
	@Path("/accounts/{accountId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Account")})
	public Account putAccount(
			@NotNull @Parameter(hidden = true) @PathParam("accountId") Long
				accountId,
			Account account)
		throws Exception {

		return new Account();
	}

	@Override
	@DELETE
	@Operation(description = "Unassigns contacts from the account.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "accountId"),
			@Parameter(in = ParameterIn.QUERY, name = "contactIds")
		}
	)
	@Path("/accounts/{accountId}/contacts")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Account")})
	public void deleteAccountContact(
			@NotNull @Parameter(hidden = true) @PathParam("accountId") Long
				accountId,
			@NotNull @Parameter(hidden = true) @QueryParam("contactIds") Long[]
				contactIds)
		throws Exception {
	}

	@Override
	@Operation(description = "Assigns contacts to the account.")
	@PUT
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "accountId"),
			@Parameter(in = ParameterIn.QUERY, name = "contactIds")
		}
	)
	@Path("/accounts/{accountId}/contacts")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Account")})
	public void putAccountContact(
			@NotNull @Parameter(hidden = true) @PathParam("accountId") Long
				accountId,
			@NotNull @Parameter(hidden = true) @QueryParam("contactIds") Long[]
				contactIds)
		throws Exception {
	}

	@Override
	@DELETE
	@Operation(
		description = "Unassigns roles from the contact for the account."
	)
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "accountId"),
			@Parameter(in = ParameterIn.PATH, name = "contactId"),
			@Parameter(in = ParameterIn.QUERY, name = "contactRoleIds")
		}
	)
	@Path("/accounts/{accountId}/contacts/{contactId}/roles")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Account")})
	public void deleteAccountContactRole(
			@NotNull @Parameter(hidden = true) @PathParam("accountId") Long
				accountId,
			@NotNull @Parameter(hidden = true) @PathParam("contactId") Long
				contactId,
			@NotNull @Parameter(hidden = true) @QueryParam("contactRoleIds")
				Long[] contactRoleIds)
		throws Exception {
	}

	@Override
	@Operation(description = "Assigns roles to the contact for the account.")
	@PUT
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "accountId"),
			@Parameter(in = ParameterIn.PATH, name = "contactId"),
			@Parameter(in = ParameterIn.QUERY, name = "contactRoleIds")
		}
	)
	@Path("/accounts/{accountId}/contacts/{contactId}/roles")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Account")})
	public void putAccountContactRole(
			@NotNull @Parameter(hidden = true) @PathParam("accountId") Long
				accountId,
			@NotNull @Parameter(hidden = true) @PathParam("contactId") Long
				contactId,
			@NotNull @Parameter(hidden = true) @QueryParam("contactRoleIds")
				Long[] contactRoleIds)
		throws Exception {
	}

	public void setContextAcceptLanguage(AcceptLanguage contextAcceptLanguage) {
		this.contextAcceptLanguage = contextAcceptLanguage;
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(Account account, Account existingAccount) {
	}

	protected <T, R> List<R> transform(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		java.util.Collection<T> collection,
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