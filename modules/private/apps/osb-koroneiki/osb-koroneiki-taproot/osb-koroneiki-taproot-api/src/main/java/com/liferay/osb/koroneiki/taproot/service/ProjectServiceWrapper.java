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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectService
 * @generated
 */
@ProviderType
public class ProjectServiceWrapper
	implements ProjectService, ServiceWrapper<ProjectService> {

	public ProjectServiceWrapper(ProjectService projectService) {
		_projectService = projectService;
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project addProject(
			long accountId, long supportRegionId, String name, String code,
			int industry, int tier, String notes, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectService.addProject(
			accountId, supportRegionId, name, code, industry, tier, notes,
			status);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project deleteProject(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectService.deleteProject(projectId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project getProject(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectService.getProject(projectId);
	}

	@Override
	public java.util.List<com.liferay.osb.koroneiki.taproot.model.Project>
			getProjects(long accountId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectService.getProjects(accountId, start, end);
	}

	@Override
	public int getProjectsCount(long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectService.getProjectsCount(accountId);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project updateProject(
			long projectId, long supportRegionId, String name, String code,
			int industry, int tier, String notes, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectService.updateProject(
			projectId, supportRegionId, name, code, industry, tier, notes,
			status);
	}

	@Override
	public ProjectService getWrappedService() {
		return _projectService;
	}

	@Override
	public void setWrappedService(ProjectService projectService) {
		_projectService = projectService;
	}

	private ProjectService _projectService;

}