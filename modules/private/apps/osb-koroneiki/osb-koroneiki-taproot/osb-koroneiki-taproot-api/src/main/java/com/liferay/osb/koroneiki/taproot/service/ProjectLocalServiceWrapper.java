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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link ProjectLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectLocalService
 * @generated
 */
@ProviderType
public class ProjectLocalServiceWrapper
	implements ProjectLocalService, ServiceWrapper<ProjectLocalService> {

	public ProjectLocalServiceWrapper(ProjectLocalService projectLocalService) {
		_projectLocalService = projectLocalService;
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project addProject(
			long userId, long accountId, String name, String code,
			String industry, String tier, String notes, String soldBy,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.addProject(
			userId, accountId, name, code, industry, tier, notes, soldBy,
			status);
	}

	/**
	 * Adds the project to the database. Also notifies the appropriate model listeners.
	 *
	 * @param project the project
	 * @return the project that was added
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project addProject(
		com.liferay.osb.koroneiki.taproot.model.Project project) {

		return _projectLocalService.addProject(project);
	}

	/**
	 * Creates a new project with the primary key. Does not add the project to the database.
	 *
	 * @param projectId the primary key for the new project
	 * @return the new project
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project createProject(
		long projectId) {

		return _projectLocalService.createProject(projectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the project
	 * @return the project that was removed
	 * @throws PortalException if a project with the primary key could not be found
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project deleteProject(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.deleteProject(projectId);
	}

	/**
	 * Deletes the project from the database. Also notifies the appropriate model listeners.
	 *
	 * @param project the project
	 * @return the project that was removed
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project deleteProject(
		com.liferay.osb.koroneiki.taproot.model.Project project) {

		return _projectLocalService.deleteProject(project);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _projectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.ProjectModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _projectLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.ProjectModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _projectLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _projectLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _projectLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project fetchProject(
		long projectId) {

		return _projectLocalService.fetchProject(projectId);
	}

	/**
	 * Returns the project with the matching UUID and company.
	 *
	 * @param uuid the project's UUID
	 * @param companyId the primary key of the company
	 * @return the matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project
		fetchProjectByUuidAndCompanyId(String uuid, long companyId) {

		return _projectLocalService.fetchProjectByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _projectLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the project with the primary key.
	 *
	 * @param projectId the primary key of the project
	 * @return the project
	 * @throws PortalException if a project with the primary key could not be found
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project getProject(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.getProject(projectId);
	}

	/**
	 * Returns the project with the matching UUID and company.
	 *
	 * @param uuid the project's UUID
	 * @param companyId the primary key of the company
	 * @return the matching project
	 * @throws PortalException if a matching project could not be found
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project
			getProjectByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.getProjectByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.ProjectModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of projects
	 */
	@Override
	public java.util.List<com.liferay.osb.koroneiki.taproot.model.Project>
		getProjects(int start, int end) {

		return _projectLocalService.getProjects(start, end);
	}

	@Override
	public java.util.List<com.liferay.osb.koroneiki.taproot.model.Project>
		getProjects(long accountId, int start, int end) {

		return _projectLocalService.getProjects(accountId, start, end);
	}

	/**
	 * Returns the number of projects.
	 *
	 * @return the number of projects
	 */
	@Override
	public int getProjectsCount() {
		return _projectLocalService.getProjectsCount();
	}

	@Override
	public int getProjectsCount(long accountId) {
		return _projectLocalService.getProjectsCount(accountId);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project updateProject(
			long userId, long projectId, String name, String code,
			String industry, String tier, String notes, String soldBy,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.updateProject(
			userId, projectId, name, code, industry, tier, notes, soldBy,
			status);
	}

	/**
	 * Updates the project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param project the project
	 * @return the project that was updated
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.Project updateProject(
		com.liferay.osb.koroneiki.taproot.model.Project project) {

		return _projectLocalService.updateProject(project);
	}

	@Override
	public ProjectLocalService getWrappedService() {
		return _projectLocalService;
	}

	@Override
	public void setWrappedService(ProjectLocalService projectLocalService) {
		_projectLocalService = projectLocalService;
	}

	private ProjectLocalService _projectLocalService;

}