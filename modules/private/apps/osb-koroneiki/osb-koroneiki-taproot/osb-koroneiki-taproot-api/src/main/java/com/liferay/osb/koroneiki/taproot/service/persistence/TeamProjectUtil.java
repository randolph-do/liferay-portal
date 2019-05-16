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

package com.liferay.osb.koroneiki.taproot.service.persistence;

import com.liferay.osb.koroneiki.taproot.model.TeamProject;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the team project service. This utility wraps <code>com.liferay.osb.koroneiki.taproot.service.persistence.impl.TeamProjectPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamProjectPersistence
 * @generated
 */
@ProviderType
public class TeamProjectUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TeamProject teamProject) {
		getPersistence().clearCache(teamProject);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TeamProject> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TeamProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TeamProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TeamProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TeamProject> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TeamProject update(TeamProject teamProject) {
		return getPersistence().update(teamProject);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TeamProject update(
		TeamProject teamProject, ServiceContext serviceContext) {

		return getPersistence().update(teamProject, serviceContext);
	}

	/**
	 * Caches the team project in the entity cache if it is enabled.
	 *
	 * @param teamProject the team project
	 */
	public static void cacheResult(TeamProject teamProject) {
		getPersistence().cacheResult(teamProject);
	}

	/**
	 * Caches the team projects in the entity cache if it is enabled.
	 *
	 * @param teamProjects the team projects
	 */
	public static void cacheResult(List<TeamProject> teamProjects) {
		getPersistence().cacheResult(teamProjects);
	}

	/**
	 * Creates a new team project with the primary key. Does not add the team project to the database.
	 *
	 * @param teamProjectPK the primary key for the new team project
	 * @return the new team project
	 */
	public static TeamProject create(TeamProjectPK teamProjectPK) {
		return getPersistence().create(teamProjectPK);
	}

	/**
	 * Removes the team project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project that was removed
	 * @throws NoSuchTeamProjectException if a team project with the primary key could not be found
	 */
	public static TeamProject remove(TeamProjectPK teamProjectPK)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectException {

		return getPersistence().remove(teamProjectPK);
	}

	public static TeamProject updateImpl(TeamProject teamProject) {
		return getPersistence().updateImpl(teamProject);
	}

	/**
	 * Returns the team project with the primary key or throws a <code>NoSuchTeamProjectException</code> if it could not be found.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project
	 * @throws NoSuchTeamProjectException if a team project with the primary key could not be found
	 */
	public static TeamProject findByPrimaryKey(TeamProjectPK teamProjectPK)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectException {

		return getPersistence().findByPrimaryKey(teamProjectPK);
	}

	/**
	 * Returns the team project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project, or <code>null</code> if a team project with the primary key could not be found
	 */
	public static TeamProject fetchByPrimaryKey(TeamProjectPK teamProjectPK) {
		return getPersistence().fetchByPrimaryKey(teamProjectPK);
	}

	/**
	 * Returns all the team projects.
	 *
	 * @return the team projects
	 */
	public static List<TeamProject> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the team projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of team projects
	 * @param end the upper bound of the range of team projects (not inclusive)
	 * @return the range of team projects
	 */
	public static List<TeamProject> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the team projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of team projects
	 * @param end the upper bound of the range of team projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of team projects
	 */
	public static List<TeamProject> findAll(
		int start, int end, OrderByComparator<TeamProject> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of team projects
	 * @param end the upper bound of the range of team projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of team projects
	 */
	public static List<TeamProject> findAll(
		int start, int end, OrderByComparator<TeamProject> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the team projects from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of team projects.
	 *
	 * @return the number of team projects
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static TeamProjectPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TeamProjectPersistence, TeamProjectPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TeamProjectPersistence.class);

		ServiceTracker<TeamProjectPersistence, TeamProjectPersistence>
			serviceTracker =
				new ServiceTracker
					<TeamProjectPersistence, TeamProjectPersistence>(
						bundle.getBundleContext(), TeamProjectPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}