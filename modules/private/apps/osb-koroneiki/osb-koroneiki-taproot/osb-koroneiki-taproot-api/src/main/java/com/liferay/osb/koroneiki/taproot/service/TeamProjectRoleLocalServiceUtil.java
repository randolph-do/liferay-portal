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
 * Provides the local service utility for TeamProjectRole. This utility wraps
 * <code>com.liferay.osb.koroneiki.taproot.service.impl.TeamProjectRoleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TeamProjectRoleLocalService
 * @generated
 */
@ProviderType
public class TeamProjectRoleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.osb.koroneiki.taproot.service.impl.TeamProjectRoleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
			addTeamProjectRole(long teamId, long projectId, long teamRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTeamProjectRole(teamId, projectId, teamRoleId);
	}

	/**
	 * Adds the team project role to the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectRole the team project role
	 * @return the team project role that was added
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		addTeamProjectRole(
			com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
				teamProjectRole) {

		return getService().addTeamProjectRole(teamProjectRole);
	}

	/**
	 * Creates a new team project role with the primary key. Does not add the team project role to the database.
	 *
	 * @param teamProjectRolePK the primary key for the new team project role
	 * @return the new team project role
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		createTeamProjectRole(
			com.liferay.osb.koroneiki.taproot.service.persistence.
				TeamProjectRolePK teamProjectRolePK) {

		return getService().createTeamProjectRole(teamProjectRolePK);
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

	public static com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		deleteTeamProjectRole(long teamId, long projectId, long teamRoleId) {

		return getService().deleteTeamProjectRole(
			teamId, projectId, teamRoleId);
	}

	/**
	 * Deletes the team project role from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectRole the team project role
	 * @return the team project role that was removed
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		deleteTeamProjectRole(
			com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
				teamProjectRole) {

		return getService().deleteTeamProjectRole(teamProjectRole);
	}

	/**
	 * Deletes the team project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role that was removed
	 * @throws PortalException if a team project role with the primary key could not be found
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
			deleteTeamProjectRole(
				com.liferay.osb.koroneiki.taproot.service.persistence.
					TeamProjectRolePK teamProjectRolePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTeamProjectRole(teamProjectRolePK);
	}

	public static void deleteTeamProjectRoles(long teamId, long projectId) {
		getService().deleteTeamProjectRoles(teamId, projectId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		fetchTeamProjectRole(
			com.liferay.osb.koroneiki.taproot.service.persistence.
				TeamProjectRolePK teamProjectRolePK) {

		return getService().fetchTeamProjectRole(teamProjectRolePK);
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
	 * Returns the team project role with the primary key.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role
	 * @throws PortalException if a team project role with the primary key could not be found
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
			getTeamProjectRole(
				com.liferay.osb.koroneiki.taproot.service.persistence.
					TeamProjectRolePK teamProjectRolePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTeamProjectRole(teamProjectRolePK);
	}

	/**
	 * Returns a range of all the team project roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @return the range of team project roles
	 */
	public static java.util.List
		<com.liferay.osb.koroneiki.taproot.model.TeamProjectRole>
			getTeamProjectRoles(int start, int end) {

		return getService().getTeamProjectRoles(start, end);
	}

	/**
	 * Returns the number of team project roles.
	 *
	 * @return the number of team project roles
	 */
	public static int getTeamProjectRolesCount() {
		return getService().getTeamProjectRolesCount();
	}

	/**
	 * Updates the team project role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectRole the team project role
	 * @return the team project role that was updated
	 */
	public static com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		updateTeamProjectRole(
			com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
				teamProjectRole) {

		return getService().updateTeamProjectRole(teamProjectRole);
	}

	public static TeamProjectRoleLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TeamProjectRoleLocalService, TeamProjectRoleLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TeamProjectRoleLocalService.class);

		ServiceTracker<TeamProjectRoleLocalService, TeamProjectRoleLocalService>
			serviceTracker =
				new ServiceTracker
					<TeamProjectRoleLocalService, TeamProjectRoleLocalService>(
						bundle.getBundleContext(),
						TeamProjectRoleLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}