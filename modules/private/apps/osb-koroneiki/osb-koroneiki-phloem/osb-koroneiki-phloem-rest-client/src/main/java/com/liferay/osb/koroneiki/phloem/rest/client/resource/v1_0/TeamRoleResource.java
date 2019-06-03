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

package com.liferay.osb.koroneiki.phloem.rest.client.resource.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.TeamRole;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public class TeamRoleResource {

	public static TeamRole postTeamRole(TeamRole teamRole) throws Exception {
		HttpInvoker.HttpResponse httpResponse = postTeamRoleHttpResponse(
			teamRole);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.
				TeamRoleSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse postTeamRoleHttpResponse(
			TeamRole teamRole)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(teamRole.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/team-roles");

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteTeamRole(Long teamRoleId) throws Exception {
		HttpInvoker.HttpResponse httpResponse = deleteTeamRoleHttpResponse(
			teamRoleId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse deleteTeamRoleHttpResponse(
			Long teamRoleId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/team-roles/{teamRoleId}",
			teamRoleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static TeamRole getTeamRole(Long teamRoleId) throws Exception {
		HttpInvoker.HttpResponse httpResponse = getTeamRoleHttpResponse(
			teamRoleId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.
				TeamRoleSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse getTeamRoleHttpResponse(
			Long teamRoleId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/team-roles/{teamRoleId}",
			teamRoleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static TeamRole putTeamRole(Long teamRoleId, TeamRole teamRole)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = putTeamRoleHttpResponse(
			teamRoleId, teamRole);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.
				TeamRoleSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse putTeamRoleHttpResponse(
			Long teamRoleId, TeamRole teamRole)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(teamRole.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		httpInvoker.path(
			"http://localhost:8080/o/koroneiki-rest/v1.0/team-roles/{teamRoleId}",
			teamRoleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	private static final Logger _logger = Logger.getLogger(
		TeamRoleResource.class.getName());

}