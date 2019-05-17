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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TeamProject. This utility wraps
 * <code>com.liferay.osb.koroneiki.taproot.service.impl.TeamProjectLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TeamProjectLocalService
 * @generated
 */
@ProviderType
public class TeamProjectLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.osb.koroneiki.taproot.service.impl.TeamProjectLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProject
		addTeamProject(long teamId, long projectId) {

		return getService().addTeamProject(teamId, projectId);
	}

	/**
	 * Adds the team project to the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProject the team project
	 * @return the team project that was added
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProject
		addTeamProject(
			com.liferay.osb.koroneiki.taproot.model.TeamProject teamProject) {

		return getService().addTeamProject(teamProject);
	}

	/**
	 * Creates a new team project with the primary key. Does not add the team project to the database.
	 *
	 * @param teamProjectPK the primary key for the new team project
	 * @return the new team project
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProject
		createTeamProject(
			com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectPK
				teamProjectPK) {

		return getService().createTeamProject(teamProjectPK);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the team project from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProject the team project
	 * @return the team project that was removed
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProject
		deleteTeamProject(
			com.liferay.osb.koroneiki.taproot.model.TeamProject teamProject) {

		return getService().deleteTeamProject(teamProject);
	}

	/**
	 * Deletes the team project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project that was removed
	 * @throws PortalException if a team project with the primary key could not be found
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProject
			deleteTeamProject(
				com.liferay.osb.koroneiki.taproot.service.persistence.
					TeamProjectPK teamProjectPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTeamProject(teamProjectPK);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.osb.koroneiki.taproot.model.TeamProject
		fetchTeamProject(
			com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectPK
				teamProjectPK) {

		return getService().fetchTeamProject(teamProjectPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the team project with the primary key.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project
	 * @throws PortalException if a team project with the primary key could not be found
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProject
			getTeamProject(
				com.liferay.osb.koroneiki.taproot.service.persistence.
					TeamProjectPK teamProjectPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTeamProject(teamProjectPK);
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
	public static java.util.List
		<com.liferay.osb.koroneiki.taproot.model.TeamProject> getTeamProjects(
			int start, int end) {

		return getService().getTeamProjects(start, end);
	}

	/**
	 * Returns the number of team projects.
	 *
	 * @return the number of team projects
	 */
	public static int getTeamProjectsCount() {
		return getService().getTeamProjectsCount();
	}

	/**
	 * Updates the team project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param teamProject the team project
	 * @return the team project that was updated
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProject
		updateTeamProject(
			com.liferay.osb.koroneiki.taproot.model.TeamProject teamProject) {

		return getService().updateTeamProject(teamProject);
	}

	public static TeamProjectLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TeamProjectLocalService, TeamProjectLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TeamProjectLocalService.class);

		ServiceTracker<TeamProjectLocalService, TeamProjectLocalService>
			serviceTracker =
				new ServiceTracker
					<TeamProjectLocalService, TeamProjectLocalService>(
						bundle.getBundleContext(),
						TeamProjectLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}