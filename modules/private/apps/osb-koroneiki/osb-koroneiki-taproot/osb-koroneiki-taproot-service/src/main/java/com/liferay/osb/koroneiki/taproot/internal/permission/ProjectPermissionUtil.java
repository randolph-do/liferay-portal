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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = {})
public class ProjectPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long projectId,
			String actionId)
		throws PortalException {

		getProjectPermission().check(permissionChecker, projectId, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, Project project,
			String actionId)
		throws PortalException {

		getProjectPermission().check(permissionChecker, project, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long projectId,
			String actionId)
		throws PortalException {

		return getProjectPermission().contains(
			permissionChecker, projectId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, Project project,
			String actionId)
		throws PortalException {

		return getProjectPermission().contains(
			permissionChecker, project, actionId);
	}

	public static ProjectPermission getProjectPermission() {
		return _projectPermission;
	}

	@Reference(unbind = "-")
	public void setProjectPermission(ProjectPermission projectPermission) {
		_projectPermission = projectPermission;
	}

	private static ProjectPermission _projectPermission;

}