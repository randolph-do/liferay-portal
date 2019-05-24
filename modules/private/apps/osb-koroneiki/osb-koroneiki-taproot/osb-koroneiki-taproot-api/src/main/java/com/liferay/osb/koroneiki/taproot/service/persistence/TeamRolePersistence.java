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

import com.liferay.osb.koroneiki.taproot.exception.NoSuchTeamRoleException;
import com.liferay.osb.koroneiki.taproot.model.TeamRole;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the team role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamRoleUtil
 * @generated
 */
@ProviderType
public interface TeamRolePersistence extends BasePersistence<TeamRole> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TeamRoleUtil} to access the team role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the team roles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching team roles
	 */
	public java.util.List<TeamRole> findByUuid(String uuid);

	/**
	 * Returns a range of all the team roles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @return the range of matching team roles
	 */
	public java.util.List<TeamRole> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the team roles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team roles
	 */
	public java.util.List<TeamRole> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the team roles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching team roles
	 */
	public java.util.List<TeamRole> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first team role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team role
	 * @throws NoSuchTeamRoleException if a matching team role could not be found
	 */
	public TeamRole findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns the first team role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team role, or <code>null</code> if a matching team role could not be found
	 */
	public TeamRole fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the last team role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team role
	 * @throws NoSuchTeamRoleException if a matching team role could not be found
	 */
	public TeamRole findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns the last team role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team role, or <code>null</code> if a matching team role could not be found
	 */
	public TeamRole fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the team roles before and after the current team role in the ordered set where uuid = &#63;.
	 *
	 * @param teamRoleId the primary key of the current team role
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team role
	 * @throws NoSuchTeamRoleException if a team role with the primary key could not be found
	 */
	public TeamRole[] findByUuid_PrevAndNext(
			long teamRoleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns all the team roles that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByUuid(String uuid);

	/**
	 * Returns a range of all the team roles that the user has permission to view where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @return the range of matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the team roles that the user has permissions to view where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the team roles before and after the current team role in the ordered set of team roles that the user has permission to view where uuid = &#63;.
	 *
	 * @param teamRoleId the primary key of the current team role
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team role
	 * @throws NoSuchTeamRoleException if a team role with the primary key could not be found
	 */
	public TeamRole[] filterFindByUuid_PrevAndNext(
			long teamRoleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Removes all the team roles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of team roles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching team roles
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the number of team roles that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching team roles that the user has permission to view
	 */
	public int filterCountByUuid(String uuid);

	/**
	 * Returns all the team roles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching team roles
	 */
	public java.util.List<TeamRole> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the team roles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @return the range of matching team roles
	 */
	public java.util.List<TeamRole> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the team roles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team roles
	 */
	public java.util.List<TeamRole> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the team roles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching team roles
	 */
	public java.util.List<TeamRole> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first team role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team role
	 * @throws NoSuchTeamRoleException if a matching team role could not be found
	 */
	public TeamRole findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns the first team role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team role, or <code>null</code> if a matching team role could not be found
	 */
	public TeamRole fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the last team role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team role
	 * @throws NoSuchTeamRoleException if a matching team role could not be found
	 */
	public TeamRole findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns the last team role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team role, or <code>null</code> if a matching team role could not be found
	 */
	public TeamRole fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the team roles before and after the current team role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param teamRoleId the primary key of the current team role
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team role
	 * @throws NoSuchTeamRoleException if a team role with the primary key could not be found
	 */
	public TeamRole[] findByUuid_C_PrevAndNext(
			long teamRoleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns all the team roles that the user has permission to view where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the team roles that the user has permission to view where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @return the range of matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the team roles that the user has permissions to view where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the team roles before and after the current team role in the ordered set of team roles that the user has permission to view where uuid = &#63; and companyId = &#63;.
	 *
	 * @param teamRoleId the primary key of the current team role
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team role
	 * @throws NoSuchTeamRoleException if a team role with the primary key could not be found
	 */
	public TeamRole[] filterFindByUuid_C_PrevAndNext(
			long teamRoleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Removes all the team roles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of team roles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching team roles
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of team roles that the user has permission to view where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching team roles that the user has permission to view
	 */
	public int filterCountByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the team roles where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching team roles
	 */
	public java.util.List<TeamRole> findByName(String name);

	/**
	 * Returns a range of all the team roles where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @return the range of matching team roles
	 */
	public java.util.List<TeamRole> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the team roles where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team roles
	 */
	public java.util.List<TeamRole> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the team roles where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching team roles
	 */
	public java.util.List<TeamRole> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first team role in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team role
	 * @throws NoSuchTeamRoleException if a matching team role could not be found
	 */
	public TeamRole findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns the first team role in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team role, or <code>null</code> if a matching team role could not be found
	 */
	public TeamRole fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the last team role in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team role
	 * @throws NoSuchTeamRoleException if a matching team role could not be found
	 */
	public TeamRole findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns the last team role in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team role, or <code>null</code> if a matching team role could not be found
	 */
	public TeamRole fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the team roles before and after the current team role in the ordered set where name = &#63;.
	 *
	 * @param teamRoleId the primary key of the current team role
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team role
	 * @throws NoSuchTeamRoleException if a team role with the primary key could not be found
	 */
	public TeamRole[] findByName_PrevAndNext(
			long teamRoleId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns all the team roles that the user has permission to view where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByName(String name);

	/**
	 * Returns a range of all the team roles that the user has permission to view where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @return the range of matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the team roles that the user has permissions to view where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the team roles before and after the current team role in the ordered set of team roles that the user has permission to view where name = &#63;.
	 *
	 * @param teamRoleId the primary key of the current team role
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team role
	 * @throws NoSuchTeamRoleException if a team role with the primary key could not be found
	 */
	public TeamRole[] filterFindByName_PrevAndNext(
			long teamRoleId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Removes all the team roles where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of team roles where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching team roles
	 */
	public int countByName(String name);

	/**
	 * Returns the number of team roles that the user has permission to view where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching team roles that the user has permission to view
	 */
	public int filterCountByName(String name);

	/**
	 * Returns all the team roles where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching team roles
	 */
	public java.util.List<TeamRole> findByType(int type);

	/**
	 * Returns a range of all the team roles where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @return the range of matching team roles
	 */
	public java.util.List<TeamRole> findByType(int type, int start, int end);

	/**
	 * Returns an ordered range of all the team roles where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team roles
	 */
	public java.util.List<TeamRole> findByType(
		int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the team roles where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching team roles
	 */
	public java.util.List<TeamRole> findByType(
		int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first team role in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team role
	 * @throws NoSuchTeamRoleException if a matching team role could not be found
	 */
	public TeamRole findByType_First(
			int type,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns the first team role in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team role, or <code>null</code> if a matching team role could not be found
	 */
	public TeamRole fetchByType_First(
		int type,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the last team role in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team role
	 * @throws NoSuchTeamRoleException if a matching team role could not be found
	 */
	public TeamRole findByType_Last(
			int type,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns the last team role in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team role, or <code>null</code> if a matching team role could not be found
	 */
	public TeamRole fetchByType_Last(
		int type,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the team roles before and after the current team role in the ordered set where type = &#63;.
	 *
	 * @param teamRoleId the primary key of the current team role
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team role
	 * @throws NoSuchTeamRoleException if a team role with the primary key could not be found
	 */
	public TeamRole[] findByType_PrevAndNext(
			long teamRoleId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Returns all the team roles that the user has permission to view where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByType(int type);

	/**
	 * Returns a range of all the team roles that the user has permission to view where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @return the range of matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByType(
		int type, int start, int end);

	/**
	 * Returns an ordered range of all the team roles that the user has permissions to view where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team roles that the user has permission to view
	 */
	public java.util.List<TeamRole> filterFindByType(
		int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns the team roles before and after the current team role in the ordered set of team roles that the user has permission to view where type = &#63;.
	 *
	 * @param teamRoleId the primary key of the current team role
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team role
	 * @throws NoSuchTeamRoleException if a team role with the primary key could not be found
	 */
	public TeamRole[] filterFindByType_PrevAndNext(
			long teamRoleId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
				orderByComparator)
		throws NoSuchTeamRoleException;

	/**
	 * Removes all the team roles where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public void removeByType(int type);

	/**
	 * Returns the number of team roles where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching team roles
	 */
	public int countByType(int type);

	/**
	 * Returns the number of team roles that the user has permission to view where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching team roles that the user has permission to view
	 */
	public int filterCountByType(int type);

	/**
	 * Caches the team role in the entity cache if it is enabled.
	 *
	 * @param teamRole the team role
	 */
	public void cacheResult(TeamRole teamRole);

	/**
	 * Caches the team roles in the entity cache if it is enabled.
	 *
	 * @param teamRoles the team roles
	 */
	public void cacheResult(java.util.List<TeamRole> teamRoles);

	/**
	 * Creates a new team role with the primary key. Does not add the team role to the database.
	 *
	 * @param teamRoleId the primary key for the new team role
	 * @return the new team role
	 */
	public TeamRole create(long teamRoleId);

	/**
	 * Removes the team role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamRoleId the primary key of the team role
	 * @return the team role that was removed
	 * @throws NoSuchTeamRoleException if a team role with the primary key could not be found
	 */
	public TeamRole remove(long teamRoleId) throws NoSuchTeamRoleException;

	public TeamRole updateImpl(TeamRole teamRole);

	/**
	 * Returns the team role with the primary key or throws a <code>NoSuchTeamRoleException</code> if it could not be found.
	 *
	 * @param teamRoleId the primary key of the team role
	 * @return the team role
	 * @throws NoSuchTeamRoleException if a team role with the primary key could not be found
	 */
	public TeamRole findByPrimaryKey(long teamRoleId)
		throws NoSuchTeamRoleException;

	/**
	 * Returns the team role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamRoleId the primary key of the team role
	 * @return the team role, or <code>null</code> if a team role with the primary key could not be found
	 */
	public TeamRole fetchByPrimaryKey(long teamRoleId);

	/**
	 * Returns all the team roles.
	 *
	 * @return the team roles
	 */
	public java.util.List<TeamRole> findAll();

	/**
	 * Returns a range of all the team roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @return the range of team roles
	 */
	public java.util.List<TeamRole> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the team roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of team roles
	 */
	public java.util.List<TeamRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the team roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of team roles
	 * @param end the upper bound of the range of team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of team roles
	 */
	public java.util.List<TeamRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamRole>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the team roles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of team roles.
	 *
	 * @return the number of team roles
	 */
	public int countAll();

}