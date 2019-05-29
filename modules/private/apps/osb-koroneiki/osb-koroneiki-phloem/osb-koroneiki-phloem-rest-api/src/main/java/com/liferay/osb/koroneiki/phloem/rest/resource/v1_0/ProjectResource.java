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
public interface ProjectResource {

	public Page<Project> getAccountProjectsPage(
			Long accountId, Pagination pagination)
		throws Exception;

	public Project postAccountProject(Long accountId, Project project)
		throws Exception;

	public void deleteProject(Long projectId) throws Exception;

	public Project getProject(Long projectId) throws Exception;

	public Project putProject(Long projectId, Project project) throws Exception;

	public void deleteProjectContact(Long projectId, Long[] contactIds)
		throws Exception;

	public void putProjectContact(Long projectId, Long[] contactIds)
		throws Exception;

	public void deleteProjectContactRole(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public void putProjectContactRole(
			Long projectId, Long contactId, Long[] contactRoleIds)
		throws Exception;

	public void deleteProjectTeamRole(
			Long projectId, Long teamId, Long[] teamRoleIds)
		throws Exception;

	public void putProjectTeamRole(
			Long projectId, Long teamId, Long[] teamRoleIds)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}