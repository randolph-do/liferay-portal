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

import com.liferay.osb.koroneiki.taproot.exception.NoSuchTeamProjectRoleException;
import com.liferay.osb.koroneiki.taproot.model.TeamProjectRole;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the team project role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamProjectRoleUtil
 * @generated
 */
@ProviderType
public interface TeamProjectRolePersistence
	extends BasePersistence<TeamProjectRole> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TeamProjectRoleUtil} to access the team project role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the team project roles where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @return the matching team project roles
	 */
	public java.util.List<TeamProjectRole> findByTeamId(long teamId);

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
	public java.util.List<TeamProjectRole> findByTeamId(
		long teamId, int start, int end);

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
	public java.util.List<TeamProjectRole> findByTeamId(
		long teamId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

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
	public java.util.List<TeamProjectRole> findByTeamId(
		long teamId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public TeamProjectRole findByTeamId_First(
			long teamId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Returns the first team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public TeamProjectRole fetchByTeamId_First(
		long teamId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

	/**
	 * Returns the last team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public TeamProjectRole findByTeamId_Last(
			long teamId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Returns the last team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public TeamProjectRole fetchByTeamId_Last(
		long teamId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

	/**
	 * Returns the team project roles before and after the current team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamProjectRolePK the primary key of the current team project role
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team project role
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	public TeamProjectRole[] findByTeamId_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long teamId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Removes all the team project roles where teamId = &#63; from the database.
	 *
	 * @param teamId the team ID
	 */
	public void removeByTeamId(long teamId);

	/**
	 * Returns the number of team project roles where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @return the number of matching team project roles
	 */
	public int countByTeamId(long teamId);

	/**
	 * Returns all the team project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching team project roles
	 */
	public java.util.List<TeamProjectRole> findByProjectId(long projectId);

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
	public java.util.List<TeamProjectRole> findByProjectId(
		long projectId, int start, int end);

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
	public java.util.List<TeamProjectRole> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

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
	public java.util.List<TeamProjectRole> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public TeamProjectRole findByProjectId_First(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Returns the first team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public TeamProjectRole fetchByProjectId_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

	/**
	 * Returns the last team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public TeamProjectRole findByProjectId_Last(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Returns the last team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public TeamProjectRole fetchByProjectId_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

	/**
	 * Returns the team project roles before and after the current team project role in the ordered set where projectId = &#63;.
	 *
	 * @param teamProjectRolePK the primary key of the current team project role
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team project role
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	public TeamProjectRole[] findByProjectId_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Removes all the team project roles where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public void removeByProjectId(long projectId);

	/**
	 * Returns the number of team project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching team project roles
	 */
	public int countByProjectId(long projectId);

	/**
	 * Returns all the team project roles where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @return the matching team project roles
	 */
	public java.util.List<TeamProjectRole> findByTeamRoleId(long teamRoleId);

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
	public java.util.List<TeamProjectRole> findByTeamRoleId(
		long teamRoleId, int start, int end);

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
	public java.util.List<TeamProjectRole> findByTeamRoleId(
		long teamRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

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
	public java.util.List<TeamProjectRole> findByTeamRoleId(
		long teamRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public TeamProjectRole findByTeamRoleId_First(
			long teamRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Returns the first team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public TeamProjectRole fetchByTeamRoleId_First(
		long teamRoleId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

	/**
	 * Returns the last team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public TeamProjectRole findByTeamRoleId_Last(
			long teamRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Returns the last team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public TeamProjectRole fetchByTeamRoleId_Last(
		long teamRoleId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

	/**
	 * Returns the team project roles before and after the current team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamProjectRolePK the primary key of the current team project role
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team project role
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	public TeamProjectRole[] findByTeamRoleId_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long teamRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Removes all the team project roles where teamRoleId = &#63; from the database.
	 *
	 * @param teamRoleId the team role ID
	 */
	public void removeByTeamRoleId(long teamRoleId);

	/**
	 * Returns the number of team project roles where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @return the number of matching team project roles
	 */
	public int countByTeamRoleId(long teamRoleId);

	/**
	 * Returns all the team project roles where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @return the matching team project roles
	 */
	public java.util.List<TeamProjectRole> findByT_P(
		long teamId, long projectId);

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
	public java.util.List<TeamProjectRole> findByT_P(
		long teamId, long projectId, int start, int end);

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
	public java.util.List<TeamProjectRole> findByT_P(
		long teamId, long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

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
	public java.util.List<TeamProjectRole> findByT_P(
		long teamId, long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public TeamProjectRole findByT_P_First(
			long teamId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Returns the first team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public TeamProjectRole fetchByT_P_First(
		long teamId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

	/**
	 * Returns the last team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	public TeamProjectRole findByT_P_Last(
			long teamId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Returns the last team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	public TeamProjectRole fetchByT_P_Last(
		long teamId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

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
	public TeamProjectRole[] findByT_P_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long teamId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
				orderByComparator)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Removes all the team project roles where teamId = &#63; and projectId = &#63; from the database.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 */
	public void removeByT_P(long teamId, long projectId);

	/**
	 * Returns the number of team project roles where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @return the number of matching team project roles
	 */
	public int countByT_P(long teamId, long projectId);

	/**
	 * Caches the team project role in the entity cache if it is enabled.
	 *
	 * @param teamProjectRole the team project role
	 */
	public void cacheResult(TeamProjectRole teamProjectRole);

	/**
	 * Caches the team project roles in the entity cache if it is enabled.
	 *
	 * @param teamProjectRoles the team project roles
	 */
	public void cacheResult(java.util.List<TeamProjectRole> teamProjectRoles);

	/**
	 * Creates a new team project role with the primary key. Does not add the team project role to the database.
	 *
	 * @param teamProjectRolePK the primary key for the new team project role
	 * @return the new team project role
	 */
	public TeamProjectRole create(TeamProjectRolePK teamProjectRolePK);

	/**
	 * Removes the team project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role that was removed
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	public TeamProjectRole remove(TeamProjectRolePK teamProjectRolePK)
		throws NoSuchTeamProjectRoleException;

	public TeamProjectRole updateImpl(TeamProjectRole teamProjectRole);

	/**
	 * Returns the team project role with the primary key or throws a <code>NoSuchTeamProjectRoleException</code> if it could not be found.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	public TeamProjectRole findByPrimaryKey(TeamProjectRolePK teamProjectRolePK)
		throws NoSuchTeamProjectRoleException;

	/**
	 * Returns the team project role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role, or <code>null</code> if a team project role with the primary key could not be found
	 */
	public TeamProjectRole fetchByPrimaryKey(
		TeamProjectRolePK teamProjectRolePK);

	/**
	 * Returns all the team project roles.
	 *
	 * @return the team project roles
	 */
	public java.util.List<TeamProjectRole> findAll();

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
	public java.util.List<TeamProjectRole> findAll(int start, int end);

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
	public java.util.List<TeamProjectRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator);

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
	public java.util.List<TeamProjectRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProjectRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the team project roles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of team project roles.
	 *
	 * @return the number of team project roles
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}