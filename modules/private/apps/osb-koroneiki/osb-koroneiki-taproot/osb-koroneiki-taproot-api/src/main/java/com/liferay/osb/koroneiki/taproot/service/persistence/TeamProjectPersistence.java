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

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.koroneiki.taproot.exception.NoSuchTeamProjectException;
import com.liferay.osb.koroneiki.taproot.model.TeamProject;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

/**
 * The persistence interface for the team project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamProjectUtil
 * @generated
 */
@ProviderType
public interface TeamProjectPersistence extends BasePersistence<TeamProject> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TeamProjectUtil} to access the team project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the team project in the entity cache if it is enabled.
	 *
	 * @param teamProject the team project
	 */
	public void cacheResult(TeamProject teamProject);

	/**
	 * Caches the team projects in the entity cache if it is enabled.
	 *
	 * @param teamProjects the team projects
	 */
	public void cacheResult(java.util.List<TeamProject> teamProjects);

	/**
	 * Creates a new team project with the primary key. Does not add the team project to the database.
	 *
	 * @param teamProjectPK the primary key for the new team project
	 * @return the new team project
	 */
	public TeamProject create(TeamProjectPK teamProjectPK);

	/**
	 * Removes the team project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project that was removed
	 * @throws NoSuchTeamProjectException if a team project with the primary key could not be found
	 */
	public TeamProject remove(TeamProjectPK teamProjectPK)
		throws NoSuchTeamProjectException;

	public TeamProject updateImpl(TeamProject teamProject);

	/**
	 * Returns the team project with the primary key or throws a <code>NoSuchTeamProjectException</code> if it could not be found.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project
	 * @throws NoSuchTeamProjectException if a team project with the primary key could not be found
	 */
	public TeamProject findByPrimaryKey(TeamProjectPK teamProjectPK)
		throws NoSuchTeamProjectException;

	/**
	 * Returns the team project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project, or <code>null</code> if a team project with the primary key could not be found
	 */
	public TeamProject fetchByPrimaryKey(TeamProjectPK teamProjectPK);

	/**
	 * Returns all the team projects.
	 *
	 * @return the team projects
	 */
	public java.util.List<TeamProject> findAll();

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
	public java.util.List<TeamProject> findAll(int start, int end);

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
	public java.util.List<TeamProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProject>
			orderByComparator);

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
	public java.util.List<TeamProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamProject>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the team projects from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of team projects.
	 *
	 * @return the number of team projects
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}