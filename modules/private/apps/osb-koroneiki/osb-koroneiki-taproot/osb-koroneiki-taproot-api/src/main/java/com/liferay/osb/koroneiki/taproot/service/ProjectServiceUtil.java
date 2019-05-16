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

package com.liferay.osb.koroneiki.taproot.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Project. This utility wraps
 * <code>com.liferay.osb.koroneiki.taproot.service.impl.ProjectServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectService
 * @generated
 */
@ProviderType
public class ProjectServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.osb.koroneiki.taproot.service.impl.ProjectServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.osb.koroneiki.taproot.model.Project addProject(
			long accountId, long supportRegionId, String name, String code,
			int industry, int tier, String notes, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addProject(
			accountId, supportRegionId, name, code, industry, tier, notes,
			status);
	}

	public static com.liferay.osb.koroneiki.taproot.model.Project deleteProject(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteProject(projectId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.osb.koroneiki.taproot.model.Project getProject(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProject(projectId);
	}

	public static java.util.List
		<com.liferay.osb.koroneiki.taproot.model.Project> getProjects(
				long accountId, int start, int end)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProjects(accountId, start, end);
	}

	public static int getProjectsCount(long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProjectsCount(accountId);
	}

	public static com.liferay.osb.koroneiki.taproot.model.Project updateProject(
			long projectId, long supportRegionId, String name, String code,
			int industry, int tier, String notes, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateProject(
			projectId, supportRegionId, name, code, industry, tier, notes,
			status);
	}

	public static ProjectService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectService, ProjectService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectService.class);

		ServiceTracker<ProjectService, ProjectService> serviceTracker =
			new ServiceTracker<ProjectService, ProjectService>(
				bundle.getBundleContext(), ProjectService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}