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
 * Provides a wrapper for {@link TeamProjectRoleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TeamProjectRoleLocalService
 * @generated
 */
@ProviderType
public class TeamProjectRoleLocalServiceWrapper
	implements TeamProjectRoleLocalService,
			   ServiceWrapper<TeamProjectRoleLocalService> {

	public TeamProjectRoleLocalServiceWrapper(
		TeamProjectRoleLocalService teamProjectRoleLocalService) {

		_teamProjectRoleLocalService = teamProjectRoleLocalService;
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
			addTeamProjectRole(long teamId, long projectId, long teamRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamProjectRoleLocalService.addTeamProjectRole(
			teamId, projectId, teamRoleId);
	}

	/**
	 * Adds the team project role to the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectRole the team project role
	 * @return the team project role that was added
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		addTeamProjectRole(
			com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
				teamProjectRole) {

		return _teamProjectRoleLocalService.addTeamProjectRole(teamProjectRole);
	}

	/**
	 * Creates a new team project role with the primary key. Does not add the team project role to the database.
	 *
	 * @param teamProjectRolePK the primary key for the new team project role
	 * @return the new team project role
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		createTeamProjectRole(
			com.liferay.osb.koroneiki.taproot.service.persistence.
				TeamProjectRolePK teamProjectRolePK) {

		return _teamProjectRoleLocalService.createTeamProjectRole(
			teamProjectRolePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamProjectRoleLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		deleteTeamProjectRole(long teamId, long projectId, long teamRoleId) {

		return _teamProjectRoleLocalService.deleteTeamProjectRole(
			teamId, projectId, teamRoleId);
	}

	/**
	 * Deletes the team project role from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectRole the team project role
	 * @return the team project role that was removed
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		deleteTeamProjectRole(
			com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
				teamProjectRole) {

		return _teamProjectRoleLocalService.deleteTeamProjectRole(
			teamProjectRole);
	}

	/**
	 * Deletes the team project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role that was removed
	 * @throws PortalException if a team project role with the primary key could not be found
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
			deleteTeamProjectRole(
				com.liferay.osb.koroneiki.taproot.service.persistence.
					TeamProjectRolePK teamProjectRolePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamProjectRoleLocalService.deleteTeamProjectRole(
			teamProjectRolePK);
	}

	@Override
	public void deleteTeamProjectRoles(long teamId, long projectId) {
		_teamProjectRoleLocalService.deleteTeamProjectRoles(teamId, projectId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _teamProjectRoleLocalService.dynamicQuery();
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

		return _teamProjectRoleLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _teamProjectRoleLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _teamProjectRoleLocalService.dynamicQuery(
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

		return _teamProjectRoleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _teamProjectRoleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		fetchTeamProjectRole(
			com.liferay.osb.koroneiki.taproot.service.persistence.
				TeamProjectRolePK teamProjectRolePK) {

		return _teamProjectRoleLocalService.fetchTeamProjectRole(
			teamProjectRolePK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _teamProjectRoleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _teamProjectRoleLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _teamProjectRoleLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamProjectRoleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the team project role with the primary key.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role
	 * @throws PortalException if a team project role with the primary key could not be found
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
			getTeamProjectRole(
				com.liferay.osb.koroneiki.taproot.service.persistence.
					TeamProjectRolePK teamProjectRolePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamProjectRoleLocalService.getTeamProjectRole(
			teamProjectRolePK);
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
	@Override
	public java.util.List
		<com.liferay.osb.koroneiki.taproot.model.TeamProjectRole>
			getTeamProjectRoles(int start, int end) {

		return _teamProjectRoleLocalService.getTeamProjectRoles(start, end);
	}

	/**
	 * Returns the number of team project roles.
	 *
	 * @return the number of team project roles
	 */
	@Override
	public int getTeamProjectRolesCount() {
		return _teamProjectRoleLocalService.getTeamProjectRolesCount();
	}

	/**
	 * Updates the team project role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectRole the team project role
	 * @return the team project role that was updated
	 */
	@Override
	public com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
		updateTeamProjectRole(
			com.liferay.osb.koroneiki.taproot.model.TeamProjectRole
				teamProjectRole) {

		return _teamProjectRoleLocalService.updateTeamProjectRole(
			teamProjectRole);
	}

	@Override
	public TeamProjectRoleLocalService getWrappedService() {
		return _teamProjectRoleLocalService;
	}

	@Override
	public void setWrappedService(
		TeamProjectRoleLocalService teamProjectRoleLocalService) {

		_teamProjectRoleLocalService = teamProjectRoleLocalService;
	}

	private TeamProjectRoleLocalService _teamProjectRoleLocalService;

}