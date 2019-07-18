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

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Project;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProjectResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseProjectResourceImpl implements ProjectResource {

	@Override
	@GET
	@Operation(description = "Retrieves the account's projects.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "accountKey"),
			@Parameter(in = ParameterIn.QUERY, name = "includes"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path("/accounts/{accountKey}/projects")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Project")})
	public Page<Project> getAccountAccountKeyProjectsPage(
			@NotNull @Parameter(hidden = true) @PathParam("accountKey") String
				accountKey,
			@Parameter(hidden = true) @QueryParam("includes") String[] includes,
			@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@POST
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "accountKey")}
	)
	@Path("/accounts/{accountKey}/projects")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Project")})
	public Project postAccountAccountKeyProject(
			@NotNull @Parameter(hidden = true) @PathParam("accountKey") String
				accountKey,
			Project project)
		throws Exception {

		return new Project();
	}

	@Override
	@GET
	@Operation(
		description = "Retrieves the projects. Results can be paginated, filtered, searched, and sorted."
	)
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.QUERY, name = "search"),
			@Parameter(in = ParameterIn.QUERY, name = "filter"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize"),
			@Parameter(in = ParameterIn.QUERY, name = "sort")
		}
	)
	@Path("/projects")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Project")})
	public Page<Project> getProjectsPage(
			@Parameter(hidden = true) @QueryParam("search") String search,
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@DELETE
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "projectKey")}
	)
	@Path("/projects/{projectKey}")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Project")})
	public void deleteProject(
			@NotNull @Parameter(hidden = true) @PathParam("projectKey") String
				projectKey)
		throws Exception {
	}

	@Override
	@GET
	@Operation(description = "Retrieves the project.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "projectKey"),
			@Parameter(in = ParameterIn.QUERY, name = "includes")
		}
	)
	@Path("/projects/{projectKey}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Project")})
	public Project getProject(
			@NotNull @Parameter(hidden = true) @PathParam("projectKey") String
				projectKey,
			@Parameter(hidden = true) @QueryParam("includes") String[] includes)
		throws Exception {

		return new Project();
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@PUT
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "projectKey")}
	)
	@Path("/projects/{projectKey}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Project")})
	public Project putProject(
			@NotNull @Parameter(hidden = true) @PathParam("projectKey") String
				projectKey,
			Project project)
		throws Exception {

		return new Project();
	}

	@Override
	@DELETE
	@Operation(description = "Unassigns contacts from the project.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "projectKey"),
			@Parameter(in = ParameterIn.QUERY, name = "contactKeys")
		}
	)
	@Path("/projects/{projectKey}/contacts")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Project")})
	public void deleteProjectContact(
			@NotNull @Parameter(hidden = true) @PathParam("projectKey") String
				projectKey,
			@NotNull @Parameter(hidden = true) @QueryParam("contactKeys")
				String[] contactKeys)
		throws Exception {
	}

	@Override
	@Operation(description = "Assigns contacts to the project.")
	@PUT
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "projectKey"),
			@Parameter(in = ParameterIn.QUERY, name = "contactKeys")
		}
	)
	@Path("/projects/{projectKey}/contacts")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Project")})
	public void putProjectContact(
			@NotNull @Parameter(hidden = true) @PathParam("projectKey") String
				projectKey,
			@NotNull @Parameter(hidden = true) @QueryParam("contactKeys")
				String[] contactKeys)
		throws Exception {
	}

	@Override
	@DELETE
	@Operation(
		description = "Unassigns roles from the contact for the project."
	)
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "projectKey"),
			@Parameter(in = ParameterIn.PATH, name = "contactKey"),
			@Parameter(in = ParameterIn.QUERY, name = "contactRoleKeys")
		}
	)
	@Path("/projects/{projectKey}/contacts/{contactKey}/roles")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Project")})
	public void deleteProjectContactContactKeyRole(
			@NotNull @Parameter(hidden = true) @PathParam("projectKey") String
				projectKey,
			@NotNull @Parameter(hidden = true) @PathParam("contactKey") String
				contactKey,
			@NotNull @Parameter(hidden = true) @QueryParam("contactRoleKeys")
				String[] contactRoleKeys)
		throws Exception {
	}

	@Override
	@Operation(description = "Assigns roles to the contact for the project.")
	@PUT
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "projectKey"),
			@Parameter(in = ParameterIn.PATH, name = "contactKey"),
			@Parameter(in = ParameterIn.QUERY, name = "contactRoleKeys")
		}
	)
	@Path("/projects/{projectKey}/contacts/{contactKey}/roles")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Project")})
	public void putProjectContactContactKeyRole(
			@NotNull @Parameter(hidden = true) @PathParam("projectKey") String
				projectKey,
			@NotNull @Parameter(hidden = true) @PathParam("contactKey") String
				contactKey,
			@NotNull @Parameter(hidden = true) @QueryParam("contactRoleKeys")
				String[] contactRoleKeys)
		throws Exception {
	}

	@Override
	@DELETE
	@Operation(description = "Unassigns roles from the team for the project.")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "projectKey"),
			@Parameter(in = ParameterIn.PATH, name = "teamKey"),
			@Parameter(in = ParameterIn.QUERY, name = "teamRoleKeys")
		}
	)
	@Path("/projects/{projectKey}/teams/{teamKey}/roles")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Project")})
	public void deleteProjectTeamTeamKeyRole(
			@NotNull @Parameter(hidden = true) @PathParam("projectKey") String
				projectKey,
			@NotNull @Parameter(hidden = true) @PathParam("teamKey") String
				teamKey,
			@NotNull @Parameter(hidden = true) @QueryParam("teamRoleKeys")
				String[] teamRoleKeys)
		throws Exception {
	}

	@Override
	@Operation(description = "Assigns roles to the team for the project.")
	@PUT
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "projectKey"),
			@Parameter(in = ParameterIn.PATH, name = "teamKey"),
			@Parameter(in = ParameterIn.QUERY, name = "teamRoleKeys")
		}
	)
	@Path("/projects/{projectKey}/teams/{teamKey}/roles")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Project")})
	public void putProjectTeamTeamKeyRole(
			@NotNull @Parameter(hidden = true) @PathParam("projectKey") String
				projectKey,
			@NotNull @Parameter(hidden = true) @PathParam("teamKey") String
				teamKey,
			@NotNull @Parameter(hidden = true) @QueryParam("teamRoleKeys")
				String[] teamRoleKeys)
		throws Exception {
	}

	public void setContextAcceptLanguage(AcceptLanguage contextAcceptLanguage) {
		this.contextAcceptLanguage = contextAcceptLanguage;
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	public void setContextUser(User contextUser) {
		this.contextUser = contextUser;
	}

	protected void preparePatch(Project project, Project existingProject) {
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

	@Context
	protected User contextUser;

}