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

package com.liferay.osb.koroneiki.taproot.service.impl;

import com.liferay.osb.koroneiki.taproot.constants.TaprootActionKeys;
import com.liferay.osb.koroneiki.taproot.internal.permission.ProjectPermissionUtil;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.permission.AccountPermission;
import com.liferay.osb.koroneiki.taproot.service.base.ProjectServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=Project"
	},
	service = AopService.class
)
public class ProjectServiceImpl extends ProjectServiceBaseImpl {

	public Project addProject(
			long accountId, long supportRegionId, String name, String code,
			int industry, int tier, String notes, int status)
		throws PortalException {

		ProjectPermissionUtil.check(
			getPermissionChecker(), 0, TaprootActionKeys.ADD_PROJECT);

		return projectLocalService.addProject(
			getUserId(), accountId, supportRegionId, name, code, industry, tier,
			notes, status);
	}

	public Project deleteProject(long projectId) throws PortalException {
		ProjectPermissionUtil.check(
			getPermissionChecker(), projectId, ActionKeys.DELETE);

		return projectLocalService.deleteProject(projectId);
	}

	public Project getProject(long projectId) throws PortalException {
		ProjectPermissionUtil.check(
			getPermissionChecker(), projectId, ActionKeys.VIEW);

		return projectLocalService.getProject(projectId);
	}

	public List<Project> getProjects(long accountId, int start, int end)
		throws PortalException {

		_accountPermission.check(
			getPermissionChecker(), accountId, ActionKeys.VIEW);

		return projectLocalService.getProjects(accountId, start, end);
	}

	public int getProjectsCount(long accountId) throws PortalException {
		_accountPermission.check(
			getPermissionChecker(), accountId, ActionKeys.VIEW);

		return projectLocalService.getProjectsCount(accountId);
	}

	public Project updateProject(
			long projectId, long supportRegionId, String name, String code,
			int industry, int tier, String notes, int status)
		throws PortalException {

		ProjectPermissionUtil.check(
			getPermissionChecker(), projectId, ActionKeys.UPDATE);

		return projectLocalService.updateProject(
			projectId, supportRegionId, name, code, industry, tier, notes,
			status);
	}

	@Reference
	private AccountPermission _accountPermission;

}