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

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Team;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.TeamResource;
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

import java.util.Collections;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseTeamResourceImpl implements TeamResource {

	@Override
	@GET
	@Operation(description = "Retrieves the account's teams.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "accountId"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path("/accounts/{accountId}/teams")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Team")})
	public Page<Team> getAccountTeamsPage(
			@NotNull @Parameter(hidden = true) @PathParam("accountId") Long
				accountId,
			@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@POST
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "accountId")})
	@Path("/accounts/{accountId}/teams")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Team")})
	public Team postAccountTeam(
			@NotNull @Parameter(hidden = true) @PathParam("accountId") Long
				accountId,
			Team team)
		throws Exception {

		return new Team();
	}

	@Override
	@DELETE
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "teamId")})
	@Path("/teams/{teamId}")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Team")})
	public void deleteTeam(
			@NotNull @Parameter(hidden = true) @PathParam("teamId") Long teamId)
		throws Exception {
	}

	@Override
	@GET
	@Operation(description = "Retrieves the team.")
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "teamId")})
	@Path("/teams/{teamId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Team")})
	public Team getTeam(
			@NotNull @Parameter(hidden = true) @PathParam("teamId") Long teamId)
		throws Exception {

		return new Team();
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@PUT
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "teamId")})
	@Path("/teams/{teamId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Team")})
	public Team putTeam(
			@NotNull @Parameter(hidden = true) @PathParam("teamId") Long teamId,
			Team team)
		throws Exception {

		return new Team();
	}

	public void setContextAcceptLanguage(AcceptLanguage contextAcceptLanguage) {
		this.contextAcceptLanguage = contextAcceptLanguage;
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(Team team, Team existingTeam) {
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