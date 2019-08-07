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
 * Provides the local service utility for ContactProjectRole. This utility wraps
 * <code>com.liferay.osb.koroneiki.taproot.service.impl.ContactProjectRoleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactProjectRoleLocalService
 * @generated
 */
@ProviderType
public class ContactProjectRoleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.osb.koroneiki.taproot.service.impl.ContactProjectRoleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the contact project role to the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactProjectRole the contact project role
	 * @return the contact project role that was added
	 */
	public static com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
		addContactProjectRole(
			com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
				contactProjectRole) {

		return getService().addContactProjectRole(contactProjectRole);
	}

	public static com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
			addContactProjectRole(
				long contactId, long projectId, long contactRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addContactProjectRole(
			contactId, projectId, contactRoleId);
	}

	/**
	 * Creates a new contact project role with the primary key. Does not add the contact project role to the database.
	 *
	 * @param contactProjectRolePK the primary key for the new contact project role
	 * @return the new contact project role
	 */
	public static com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
		createContactProjectRole(
			com.liferay.osb.koroneiki.taproot.service.persistence.
				ContactProjectRolePK contactProjectRolePK) {

		return getService().createContactProjectRole(contactProjectRolePK);
	}

	/**
	 * Deletes the contact project role from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactProjectRole the contact project role
	 * @return the contact project role that was removed
	 */
	public static com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
		deleteContactProjectRole(
			com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
				contactProjectRole) {

		return getService().deleteContactProjectRole(contactProjectRole);
	}

	/**
	 * Deletes the contact project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactProjectRolePK the primary key of the contact project role
	 * @return the contact project role that was removed
	 * @throws PortalException if a contact project role with the primary key could not be found
	 */
	public static com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
			deleteContactProjectRole(
				com.liferay.osb.koroneiki.taproot.service.persistence.
					ContactProjectRolePK contactProjectRolePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteContactProjectRole(contactProjectRolePK);
	}

	public static com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
			deleteContactProjectRole(
				long contactId, long projectId, long contactRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteContactProjectRole(
			contactId, projectId, contactRoleId);
	}

	public static void deleteContactProjectRoles(long contactId, long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteContactProjectRoles(contactId, projectId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
		fetchContactProjectRole(
			com.liferay.osb.koroneiki.taproot.service.persistence.
				ContactProjectRolePK contactProjectRolePK) {

		return getService().fetchContactProjectRole(contactProjectRolePK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the contact project role with the primary key.
	 *
	 * @param contactProjectRolePK the primary key of the contact project role
	 * @return the contact project role
	 * @throws PortalException if a contact project role with the primary key could not be found
	 */
	public static com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
			getContactProjectRole(
				com.liferay.osb.koroneiki.taproot.service.persistence.
					ContactProjectRolePK contactProjectRolePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getContactProjectRole(contactProjectRolePK);
	}

	/**
	 * Returns a range of all the contact project roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.koroneiki.taproot.model.impl.ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @return the range of contact project roles
	 */
	public static java.util.List
		<com.liferay.osb.koroneiki.taproot.model.ContactProjectRole>
			getContactProjectRoles(int start, int end) {

		return getService().getContactProjectRoles(start, end);
	}

	public static java.util.List
		<com.liferay.osb.koroneiki.taproot.model.ContactProjectRole>
			getContactProjectRolesByProjectId(long projectId) {

		return getService().getContactProjectRolesByProjectId(projectId);
	}

	/**
	 * Returns the number of contact project roles.
	 *
	 * @return the number of contact project roles
	 */
	public static int getContactProjectRolesCount() {
		return getService().getContactProjectRolesCount();
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
	 * Updates the contact project role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param contactProjectRole the contact project role
	 * @return the contact project role that was updated
	 */
	public static com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
		updateContactProjectRole(
			com.liferay.osb.koroneiki.taproot.model.ContactProjectRole
				contactProjectRole) {

		return getService().updateContactProjectRole(contactProjectRole);
	}

	public static ContactProjectRoleLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ContactProjectRoleLocalService, ContactProjectRoleLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ContactProjectRoleLocalService.class);

		ServiceTracker
			<ContactProjectRoleLocalService, ContactProjectRoleLocalService>
				serviceTracker =
					new ServiceTracker
						<ContactProjectRoleLocalService,
						 ContactProjectRoleLocalService>(
							 bundle.getBundleContext(),
							 ContactProjectRoleLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}