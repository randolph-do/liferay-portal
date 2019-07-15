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

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Project;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import javax.annotation.Generated;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/koroneiki-rest/v1.0
 *
 * @author Amos Fong
 * @generated
 */
@Generated("")
@ProviderType
public interface ProjectResource {

	public Page<Project> getAccountAccountKeyProjectsPage(
			String accountKey, Pagination pagination)
		throws Exception;

	public Project postAccountAccountKeyProject(
			String accountKey, Project project)
		throws Exception;

	public void deleteProject(String projectKey) throws Exception;

	public Project getProject(String projectKey) throws Exception;

	public Project putProject(String projectKey, Project project)
		throws Exception;

	public void deleteProjectContact(String projectKey, String[] contactKeys)
		throws Exception;

	public void putProjectContact(String projectKey, String[] contactKeys)
		throws Exception;

	public void deleteProjectContactContactKeyRole(
			String projectKey, String contactKey, String[] contactRoleKeys)
		throws Exception;

	public void putProjectContactContactKeyRole(
			String projectKey, String contactKey, String[] contactRoleKeys)
		throws Exception;

	public void deleteProjectTeamTeamKeyRole(
			String projectKey, String teamKey, String[] teamRoleKeys)
		throws Exception;

	public void putProjectTeamTeamKeyRole(
			String projectKey, String teamKey, String[] teamRoleKeys)
		throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(Company contextCompany);

	public void setContextUser(User contextUser);

}