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
 * Provides a wrapper for {@link TeamProjectLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TeamProjectLocalService
 * @generated
 */
@ProviderType
public class TeamProjectLocalServiceWrapper
	implements TeamProjectLocalService,
			   ServiceWrapper<TeamProjectLocalService> {

	public TeamProjectLocalServiceWrapper(
		TeamProjectLocalService teamProjectLocalService) {

		_teamProjectLocalService = teamProjectLocalService;
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProject addTeamProject(
		long teamId, long projectId) {

		return _teamProjectLocalService.addTeamProject(teamId, projectId);
	}

	/**
	 * Adds the team project to the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProject the team project
	 * @return the team project that was added
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProject addTeamProject(
		com.liferay.osb.koroneiki.taproot.model.TeamProject teamProject) {

		return _teamProjectLocalService.addTeamProject(teamProject);
	}

	/**
	 * Creates a new team project with the primary key. Does not add the team project to the database.
	 *
	 * @param teamProjectPK the primary key for the new team project
	 * @return the new team project
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProject
		createTeamProject(
			com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectPK
				teamProjectPK) {

		return _teamProjectLocalService.createTeamProject(teamProjectPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamProjectLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the team project from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProject the team project
	 * @return the team project that was removed
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProject
		deleteTeamProject(
			com.liferay.osb.koroneiki.taproot.model.TeamProject teamProject) {

		return _teamProjectLocalService.deleteTeamProject(teamProject);
	}

	/**
	 * Deletes the team project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project that was removed
	 * @throws PortalException if a team project with the primary key could not be found
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProject
			deleteTeamProject(
				com.liferay.osb.koroneiki.taproot.service.persistence.
					TeamProjectPK teamProjectPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamProjectLocalService.deleteTeamProject(teamProjectPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _teamProjectLocalService.dynamicQuery();
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

		return _teamProjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.TeamProjectModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _teamProjectLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.TeamProjectModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _teamProjectLocalService.dynamicQuery(
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

		return _teamProjectLocalService.dynamicQueryCount(dynamicQuery);
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

		return _teamProjectLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProject fetchTeamProject(
		com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectPK
			teamProjectPK) {

		return _teamProjectLocalService.fetchTeamProject(teamProjectPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _teamProjectLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _teamProjectLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _teamProjectLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamProjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the team project with the primary key.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project
	 * @throws PortalException if a team project with the primary key could not be found
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProject getTeamProject(
			com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectPK
				teamProjectPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamProjectLocalService.getTeamProject(teamProjectPK);
	}

	/**
	 * Returns a range of all the team projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.TeamProjectModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of team projects
	 * @param end the upper bound of the range of team projects (not inclusive)
	 * @return the range of team projects
	 */
	@Override
	public java.util.List<com.liferay.osb.koroneiki.taproot.model.TeamProject>
		getTeamProjects(int start, int end) {

		return _teamProjectLocalService.getTeamProjects(start, end);
	}

	/**
	 * Returns the number of team projects.
	 *
	 * @return the number of team projects
	 */
	@Override
	public int getTeamProjectsCount() {
		return _teamProjectLocalService.getTeamProjectsCount();
	}

	/**
	 * Updates the team project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param teamProject the team project
	 * @return the team project that was updated
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProject
		updateTeamProject(
			com.liferay.osb.koroneiki.taproot.model.TeamProject teamProject) {

		return _teamProjectLocalService.updateTeamProject(teamProject);
	}

	@Override
	public TeamProjectLocalService getWrappedService() {
		return _teamProjectLocalService;
	}

	@Override
	public void setWrappedService(
		TeamProjectLocalService teamProjectLocalService) {

		_teamProjectLocalService = teamProjectLocalService;
	}

	private TeamProjectLocalService _teamProjectLocalService;

}