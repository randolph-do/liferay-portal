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

package com.liferay.osb.koroneiki.taproot.internal.permission;

import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.permission.ProjectPermission;
import com.liferay.osb.koroneiki.taproot.service.ProjectLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.ArrayUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = ProjectPermission.class)
public class ProjectPermissionImpl implements ProjectPermission {

	@Override
	public void check(
			PermissionChecker permissionChecker, long projectId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, projectId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, Project.class.getName(), projectId,
				actionId);
		}
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, Project project,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, project, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, Project.class.getName(),
				project.getProjectId(), actionId);
		}
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long projectId,
			String actionId)
		throws PortalException {

		if (permissionChecker.isOmniadmin()) {
			return true;
		}

		return permissionChecker.hasPermission(
			0, Project.class.getName(), projectId, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long[] projectIds,
			String actionId)
		throws PortalException {

		if (ArrayUtil.isEmpty(projectIds)) {
			return false;
		}

		for (long projectId : projectIds) {
			if (!contains(permissionChecker, projectId, actionId)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, Project project,
			String actionId)
		throws PortalException {

		if (contains(permissionChecker, project.getProjectId(), actionId)) {
			return true;
		}

		return false;
	}

	@Reference
	private ProjectLocalService _projectLocalService;

}