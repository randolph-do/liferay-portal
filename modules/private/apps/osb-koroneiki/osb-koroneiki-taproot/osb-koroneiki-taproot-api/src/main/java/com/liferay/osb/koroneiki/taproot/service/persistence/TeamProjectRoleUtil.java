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

import com.liferay.osb.koroneiki.taproot.model.TeamProjectRole;
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
 * The persistence utility for the team project role service. This utility wraps <code>com.liferay.osb.koroneiki.taproot.service.persistence.impl.TeamProjectRolePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamProjectRolePersistence
 * @generated
 */
@ProviderType
public class TeamProjectRoleUtil {

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
	public static void clearCache(TeamProjectRole teamProjectRole) {
		getPersistence().clearCache(teamProjectRole);
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
	public static Map<Serializable, TeamProjectRole> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TeamProjectRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TeamProjectRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TeamProjectRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TeamProjectRole update(TeamProjectRole teamProjectRole) {
		return getPersistence().update(teamProjectRole);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TeamProjectRole update(
		TeamProjectRole teamProjectRole, ServiceContext serviceContext) {

		return getPersistence().update(teamProjectRole, serviceContext);
	}

	/**
	 * Returns all the team project roles where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @return the matching team project roles
	 */
	public static List<TeamProjectRole> findByTeamId(long teamId) {
		return getPersistence().findByTeamId(teamId);
	}

	/**
	 * Returns a range of all the team project roles where teamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @return the range of matching team project roles
	 */
	public static List<TeamProjectRole> findByTeamId(
		long teamId, int start, int end) {

		return getPersistence().findByTeamId(teamId, start, end);
	}

	/**
	 * Returns an ordered range of all the team project roles where teamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team project roles
	 */
	public static List<TeamProjectRole> findByTeamId(
		long teamId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().findByTeamId(
			teamId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team project roles where teamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team project roles
	 */
	public static List<TeamProjectRole> findByTeamId(
		long teamId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTeamId(
			teamId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public static TeamProjectRole findByTeamId_First(
			long teamId, OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByTeamId_First(teamId, orderByComparator);
	}

	/**
	 * Returns the first team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public static TeamProjectRole fetchByTeamId_First(
		long teamId, OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().fetchByTeamId_First(teamId, orderByComparator);
	}

	/**
	 * Returns the last team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public static TeamProjectRole findByTeamId_Last(
			long teamId, OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByTeamId_Last(teamId, orderByComparator);
	}

	/**
	 * Returns the last team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public static TeamProjectRole fetchByTeamId_Last(
		long teamId, OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().fetchByTeamId_Last(teamId, orderByComparator);
	}

	/**
	 * Returns the team project roles before and after the current team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamProjectRolePK the primary key of the current team project role
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team project role
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	public static TeamProjectRole[] findByTeamId_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long teamId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByTeamId_PrevAndNext(
			teamProjectRolePK, teamId, orderByComparator);
	}

	/**
	 * Removes all the team project roles where teamId = &#63; from the database.
	 *
	 * @param teamId the team ID
	 */
	public static void removeByTeamId(long teamId) {
		getPersistence().removeByTeamId(teamId);
	}

	/**
	 * Returns the number of team project roles where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @return the number of matching team project roles
	 */
	public static int countByTeamId(long teamId) {
		return getPersistence().countByTeamId(teamId);
	}

	/**
	 * Returns all the team project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching team project roles
	 */
	public static List<TeamProjectRole> findByProjectId(long projectId) {
		return getPersistence().findByProjectId(projectId);
	}

	/**
	 * Returns a range of all the team project roles where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @return the range of matching team project roles
	 */
	public static List<TeamProjectRole> findByProjectId(
		long projectId, int start, int end) {

		return getPersistence().findByProjectId(projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the team project roles where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team project roles
	 */
	public static List<TeamProjectRole> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team project roles where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team project roles
	 */
	public static List<TeamProjectRole> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public static TeamProjectRole findByProjectId_First(
			long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the first team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public static TeamProjectRole fetchByProjectId_First(
		long projectId, OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().fetchByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public static TeamProjectRole findByProjectId_Last(
			long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public static TeamProjectRole fetchByProjectId_Last(
		long projectId, OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().fetchByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the team project roles before and after the current team project role in the ordered set where projectId = &#63;.
	 *
	 * @param teamProjectRolePK the primary key of the current team project role
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team project role
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	public static TeamProjectRole[] findByProjectId_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByProjectId_PrevAndNext(
			teamProjectRolePK, projectId, orderByComparator);
	}

	/**
	 * Removes all the team project roles where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public static void removeByProjectId(long projectId) {
		getPersistence().removeByProjectId(projectId);
	}

	/**
	 * Returns the number of team project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching team project roles
	 */
	public static int countByProjectId(long projectId) {
		return getPersistence().countByProjectId(projectId);
	}

	/**
	 * Returns all the team project roles where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @return the matching team project roles
	 */
	public static List<TeamProjectRole> findByTeamRoleId(long teamRoleId) {
		return getPersistence().findByTeamRoleId(teamRoleId);
	}

	/**
	 * Returns a range of all the team project roles where teamRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param teamRoleId the team role ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @return the range of matching team project roles
	 */
	public static List<TeamProjectRole> findByTeamRoleId(
		long teamRoleId, int start, int end) {

		return getPersistence().findByTeamRoleId(teamRoleId, start, end);
	}

	/**
	 * Returns an ordered range of all the team project roles where teamRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param teamRoleId the team role ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team project roles
	 */
	public static List<TeamProjectRole> findByTeamRoleId(
		long teamRoleId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().findByTeamRoleId(
			teamRoleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team project roles where teamRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param teamRoleId the team role ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team project roles
	 */
	public static List<TeamProjectRole> findByTeamRoleId(
		long teamRoleId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTeamRoleId(
			teamRoleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public static TeamProjectRole findByTeamRoleId_First(
			long teamRoleId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByTeamRoleId_First(
			teamRoleId, orderByComparator);
	}

	/**
	 * Returns the first team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public static TeamProjectRole fetchByTeamRoleId_First(
		long teamRoleId, OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().fetchByTeamRoleId_First(
			teamRoleId, orderByComparator);
	}

	/**
	 * Returns the last team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public static TeamProjectRole findByTeamRoleId_Last(
			long teamRoleId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByTeamRoleId_Last(
			teamRoleId, orderByComparator);
	}

	/**
	 * Returns the last team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public static TeamProjectRole fetchByTeamRoleId_Last(
		long teamRoleId, OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().fetchByTeamRoleId_Last(
			teamRoleId, orderByComparator);
	}

	/**
	 * Returns the team project roles before and after the current team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamProjectRolePK the primary key of the current team project role
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team project role
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	public static TeamProjectRole[] findByTeamRoleId_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long teamRoleId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByTeamRoleId_PrevAndNext(
			teamProjectRolePK, teamRoleId, orderByComparator);
	}

	/**
	 * Removes all the team project roles where teamRoleId = &#63; from the database.
	 *
	 * @param teamRoleId the team role ID
	 */
	public static void removeByTeamRoleId(long teamRoleId) {
		getPersistence().removeByTeamRoleId(teamRoleId);
	}

	/**
	 * Returns the number of team project roles where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @return the number of matching team project roles
	 */
	public static int countByTeamRoleId(long teamRoleId) {
		return getPersistence().countByTeamRoleId(teamRoleId);
	}

	/**
	 * Returns all the team project roles where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @return the matching team project roles
	 */
	public static List<TeamProjectRole> findByT_P(long teamId, long projectId) {
		return getPersistence().findByT_P(teamId, projectId);
	}

	/**
	 * Returns a range of all the team project roles where teamId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @return the range of matching team project roles
	 */
	public static List<TeamProjectRole> findByT_P(
		long teamId, long projectId, int start, int end) {

		return getPersistence().findByT_P(teamId, projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the team project roles where teamId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team project roles
	 */
	public static List<TeamProjectRole> findByT_P(
		long teamId, long projectId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().findByT_P(
			teamId, projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team project roles where teamId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team project roles
	 */
	public static List<TeamProjectRole> findByT_P(
		long teamId, long projectId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByT_P(
			teamId, projectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public static TeamProjectRole findByT_P_First(
			long teamId, long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByT_P_First(
			teamId, projectId, orderByComparator);
	}

	/**
	 * Returns the first team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public static TeamProjectRole fetchByT_P_First(
		long teamId, long projectId,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().fetchByT_P_First(
			teamId, projectId, orderByComparator);
	}

	/**
	 * Returns the last team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public static TeamProjectRole findByT_P_Last(
			long teamId, long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByT_P_Last(
			teamId, projectId, orderByComparator);
	}

	/**
	 * Returns the last team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public static TeamProjectRole fetchByT_P_Last(
		long teamId, long projectId,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().fetchByT_P_Last(
			teamId, projectId, orderByComparator);
	}

	/**
	 * Returns the team project roles before and after the current team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamProjectRolePK the primary key of the current team project role
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team project role
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	public static TeamProjectRole[] findByT_P_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long teamId, long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByT_P_PrevAndNext(
			teamProjectRolePK, teamId, projectId, orderByComparator);
	}

	/**
	 * Removes all the team project roles where teamId = &#63; and projectId = &#63; from the database.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 */
	public static void removeByT_P(long teamId, long projectId) {
		getPersistence().removeByT_P(teamId, projectId);
	}

	/**
	 * Returns the number of team project roles where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @return the number of matching team project roles
	 */
	public static int countByT_P(long teamId, long projectId) {
		return getPersistence().countByT_P(teamId, projectId);
	}

	/**
	 * Caches the team project role in the entity cache if it is enabled.
	 *
	 * @param teamProjectRole the team project role
	 */
	public static void cacheResult(TeamProjectRole teamProjectRole) {
		getPersistence().cacheResult(teamProjectRole);
	}

	/**
	 * Caches the team project roles in the entity cache if it is enabled.
	 *
	 * @param teamProjectRoles the team project roles
	 */
	public static void cacheResult(List<TeamProjectRole> teamProjectRoles) {
		getPersistence().cacheResult(teamProjectRoles);
	}

	/**
	 * Creates a new team project role with the primary key. Does not add the team project role to the database.
	 *
	 * @param teamProjectRolePK the primary key for the new team project role
	 * @return the new team project role
	 */
	public static TeamProjectRole create(TeamProjectRolePK teamProjectRolePK) {
		return getPersistence().create(teamProjectRolePK);
	}

	/**
	 * Removes the team project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role that was removed
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	public static TeamProjectRole remove(TeamProjectRolePK teamProjectRolePK)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().remove(teamProjectRolePK);
	}

	public static TeamProjectRole updateImpl(TeamProjectRole teamProjectRole) {
		return getPersistence().updateImpl(teamProjectRole);
	}

	/**
	 * Returns the team project role with the primary key or throws a <code>NoSuchTeamProjectRoleException</code> if it could not be found.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	public static TeamProjectRole findByPrimaryKey(
			TeamProjectRolePK teamProjectRolePK)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchTeamProjectRoleException {

		return getPersistence().findByPrimaryKey(teamProjectRolePK);
	}

	/**
	 * Returns the team project role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role, or <code>null</code> if a team project role with the primary key could not be found
	 */
	public static TeamProjectRole fetchByPrimaryKey(
		TeamProjectRolePK teamProjectRolePK) {

		return getPersistence().fetchByPrimaryKey(teamProjectRolePK);
	}

	/**
	 * Returns all the team project roles.
	 *
	 * @return the team project roles
	 */
	public static List<TeamProjectRole> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the team project roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @return the range of team project roles
	 */
	public static List<TeamProjectRole> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the team project roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of team project roles
	 */
	public static List<TeamProjectRole> findAll(
		int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team project roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of team project roles
	 * @param end the upper bound of the range of team project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of team project roles
	 */
	public static List<TeamProjectRole> findAll(
		int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the team project roles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of team project roles.
	 *
	 * @return the number of team project roles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static TeamProjectRolePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TeamProjectRolePersistence, TeamProjectRolePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TeamProjectRolePersistence.class);

		ServiceTracker<TeamProjectRolePersistence, TeamProjectRolePersistence>
			serviceTracker =
				new ServiceTracker
					<TeamProjectRolePersistence, TeamProjectRolePersistence>(
						bundle.getBundleContext(),
						TeamProjectRolePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}