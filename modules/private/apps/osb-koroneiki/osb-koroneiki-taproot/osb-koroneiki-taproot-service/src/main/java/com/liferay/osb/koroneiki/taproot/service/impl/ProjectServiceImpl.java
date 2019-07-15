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
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.permission.AccountPermission;
import com.liferay.osb.koroneiki.taproot.permission.ProjectPermission;
import com.liferay.osb.koroneiki.taproot.service.AccountLocalService;
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
			long accountId, String name, String code, String industry,
			String tier, String notes, String soldBy, int status)
		throws PortalException {

		_projectPermission.check(
			getPermissionChecker(), TaprootActionKeys.ADD_PROJECT);

		return projectLocalService.addProject(
			getUserId(), accountId, name, code, industry, tier, notes, soldBy,
			status);
	}

	public Project addProject(
			String accountKey, String name, String code, String industry,
			String tier, String notes, String soldBy, int status)
		throws PortalException {

		Account account = _accountLocalService.getAccount(accountKey);

		return addProject(
			account.getAccountId(), name, code, industry, tier, notes, soldBy,
			status);
	}

	public Project deleteProject(long projectId) throws PortalException {
		_projectPermission.check(
			getPermissionChecker(), projectId, ActionKeys.DELETE);

		return projectLocalService.deleteProject(projectId);
	}

	public Project deleteProject(String projectKey) throws PortalException {
		Project project = projectLocalService.getProject(projectKey);

		_projectPermission.check(
			getPermissionChecker(), project, ActionKeys.DELETE);

		return projectLocalService.deleteProject(project);
	}

	public Project getProject(long projectId) throws PortalException {
		_projectPermission.check(
			getPermissionChecker(), projectId, ActionKeys.VIEW);

		return projectLocalService.getProject(projectId);
	}

	public Project getProject(String projectKey) throws PortalException {
		Project project = projectLocalService.getProject(projectKey);

		_projectPermission.check(
			getPermissionChecker(), project, ActionKeys.VIEW);

		return project;
	}

	public List<Project> getProjects(long accountId, int start, int end)
		throws PortalException {

		_accountPermission.check(
			getPermissionChecker(), accountId, ActionKeys.VIEW);

		return projectLocalService.getProjects(accountId, start, end);
	}

	public List<Project> getProjects(String accountKey, int start, int end)
		throws PortalException {

		Account account = _accountLocalService.getAccount(accountKey);

		_accountPermission.check(
			getPermissionChecker(), account, ActionKeys.VIEW);

		return projectLocalService.getProjects(
			account.getAccountId(), start, end);
	}

	public int getProjectsCount(long accountId) throws PortalException {
		_accountPermission.check(
			getPermissionChecker(), accountId, ActionKeys.VIEW);

		return projectLocalService.getProjectsCount(accountId);
	}

	public int getProjectsCount(String accountKey) throws PortalException {
		Account account = _accountLocalService.getAccount(accountKey);

		_accountPermission.check(
			getPermissionChecker(), account, ActionKeys.VIEW);

		return projectLocalService.getProjectsCount(account.getAccountId());
	}

	public Project updateProject(
			long projectId, String name, String code, String industry,
			String tier, String notes, String soldBy, int status)
		throws PortalException {

		_projectPermission.check(
			getPermissionChecker(), projectId, ActionKeys.UPDATE);

		return projectLocalService.updateProject(
			getUserId(), projectId, name, code, industry, tier, notes, soldBy,
			status);
	}

	public Project updateProject(
			String projectKey, String name, String code, String industry,
			String tier, String notes, String soldBy, int status)
		throws PortalException {

		Project project = projectLocalService.getProject(projectKey);

		_projectPermission.check(
			getPermissionChecker(), project, ActionKeys.UPDATE);

		return projectLocalService.updateProject(
			getUserId(), project.getProjectId(), name, code, industry, tier,
			notes, soldBy, status);
	}

	@Reference
	private AccountLocalService _accountLocalService;

	@Reference
	private AccountPermission _accountPermission;

	@Reference
	private ProjectPermission _projectPermission;

}