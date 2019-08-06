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

import com.liferay.osb.koroneiki.taproot.model.ContactProjectRole;
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
 * The persistence utility for the contact project role service. This utility wraps <code>com.liferay.osb.koroneiki.taproot.service.persistence.impl.ContactProjectRolePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactProjectRolePersistence
 * @generated
 */
@ProviderType
public class ContactProjectRoleUtil {

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
	public static void clearCache(ContactProjectRole contactProjectRole) {
		getPersistence().clearCache(contactProjectRole);
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
	public static Map<Serializable, ContactProjectRole> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ContactProjectRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactProjectRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactProjectRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ContactProjectRole update(
		ContactProjectRole contactProjectRole) {

		return getPersistence().update(contactProjectRole);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ContactProjectRole update(
		ContactProjectRole contactProjectRole, ServiceContext serviceContext) {

		return getPersistence().update(contactProjectRole, serviceContext);
	}

	/**
	 * Returns all the contact project roles where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the matching contact project roles
	 */
	public static List<ContactProjectRole> findByContactId(long contactId) {
		return getPersistence().findByContactId(contactId);
	}

	/**
	 * Returns a range of all the contact project roles where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @return the range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByContactId(
		long contactId, int start, int end) {

		return getPersistence().findByContactId(contactId, start, end);
	}

	/**
	 * Returns an ordered range of all the contact project roles where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByContactId(
		long contactId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().findByContactId(
			contactId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the contact project roles where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByContactId(
		long contactId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByContactId(
			contactId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public static ContactProjectRole findByContactId_First(
			long contactId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByContactId_First(
			contactId, orderByComparator);
	}

	/**
	 * Returns the first contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public static ContactProjectRole fetchByContactId_First(
		long contactId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().fetchByContactId_First(
			contactId, orderByComparator);
	}

	/**
	 * Returns the last contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public static ContactProjectRole findByContactId_Last(
			long contactId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByContactId_Last(
			contactId, orderByComparator);
	}

	/**
	 * Returns the last contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public static ContactProjectRole fetchByContactId_Last(
		long contactId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().fetchByContactId_Last(
			contactId, orderByComparator);
	}

	/**
	 * Returns the contact project roles before and after the current contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactProjectRolePK the primary key of the current contact project role
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact project role
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	public static ContactProjectRole[] findByContactId_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long contactId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByContactId_PrevAndNext(
			contactProjectRolePK, contactId, orderByComparator);
	}

	/**
	 * Removes all the contact project roles where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 */
	public static void removeByContactId(long contactId) {
		getPersistence().removeByContactId(contactId);
	}

	/**
	 * Returns the number of contact project roles where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching contact project roles
	 */
	public static int countByContactId(long contactId) {
		return getPersistence().countByContactId(contactId);
	}

	/**
	 * Returns all the contact project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching contact project roles
	 */
	public static List<ContactProjectRole> findByProjectId(long projectId) {
		return getPersistence().findByProjectId(projectId);
	}

	/**
	 * Returns a range of all the contact project roles where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @return the range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByProjectId(
		long projectId, int start, int end) {

		return getPersistence().findByProjectId(projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the contact project roles where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the contact project roles where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public static ContactProjectRole findByProjectId_First(
			long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the first contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public static ContactProjectRole fetchByProjectId_First(
		long projectId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().fetchByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public static ContactProjectRole findByProjectId_Last(
			long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public static ContactProjectRole fetchByProjectId_Last(
		long projectId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().fetchByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the contact project roles before and after the current contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param contactProjectRolePK the primary key of the current contact project role
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact project role
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	public static ContactProjectRole[] findByProjectId_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByProjectId_PrevAndNext(
			contactProjectRolePK, projectId, orderByComparator);
	}

	/**
	 * Removes all the contact project roles where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public static void removeByProjectId(long projectId) {
		getPersistence().removeByProjectId(projectId);
	}

	/**
	 * Returns the number of contact project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching contact project roles
	 */
	public static int countByProjectId(long projectId) {
		return getPersistence().countByProjectId(projectId);
	}

	/**
	 * Returns all the contact project roles where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @return the matching contact project roles
	 */
	public static List<ContactProjectRole> findByContactRoleId(
		long contactRoleId) {

		return getPersistence().findByContactRoleId(contactRoleId);
	}

	/**
	 * Returns a range of all the contact project roles where contactRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactRoleId the contact role ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @return the range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByContactRoleId(
		long contactRoleId, int start, int end) {

		return getPersistence().findByContactRoleId(contactRoleId, start, end);
	}

	/**
	 * Returns an ordered range of all the contact project roles where contactRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactRoleId the contact role ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByContactRoleId(
		long contactRoleId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().findByContactRoleId(
			contactRoleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the contact project roles where contactRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactRoleId the contact role ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByContactRoleId(
		long contactRoleId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByContactRoleId(
			contactRoleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public static ContactProjectRole findByContactRoleId_First(
			long contactRoleId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByContactRoleId_First(
			contactRoleId, orderByComparator);
	}

	/**
	 * Returns the first contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public static ContactProjectRole fetchByContactRoleId_First(
		long contactRoleId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().fetchByContactRoleId_First(
			contactRoleId, orderByComparator);
	}

	/**
	 * Returns the last contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public static ContactProjectRole findByContactRoleId_Last(
			long contactRoleId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByContactRoleId_Last(
			contactRoleId, orderByComparator);
	}

	/**
	 * Returns the last contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public static ContactProjectRole fetchByContactRoleId_Last(
		long contactRoleId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().fetchByContactRoleId_Last(
			contactRoleId, orderByComparator);
	}

	/**
	 * Returns the contact project roles before and after the current contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactProjectRolePK the primary key of the current contact project role
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact project role
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	public static ContactProjectRole[] findByContactRoleId_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long contactRoleId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByContactRoleId_PrevAndNext(
			contactProjectRolePK, contactRoleId, orderByComparator);
	}

	/**
	 * Removes all the contact project roles where contactRoleId = &#63; from the database.
	 *
	 * @param contactRoleId the contact role ID
	 */
	public static void removeByContactRoleId(long contactRoleId) {
		getPersistence().removeByContactRoleId(contactRoleId);
	}

	/**
	 * Returns the number of contact project roles where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @return the number of matching contact project roles
	 */
	public static int countByContactRoleId(long contactRoleId) {
		return getPersistence().countByContactRoleId(contactRoleId);
	}

	/**
	 * Returns all the contact project roles where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @return the matching contact project roles
	 */
	public static List<ContactProjectRole> findByC_P(
		long contactId, long projectId) {

		return getPersistence().findByC_P(contactId, projectId);
	}

	/**
	 * Returns a range of all the contact project roles where contactId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @return the range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByC_P(
		long contactId, long projectId, int start, int end) {

		return getPersistence().findByC_P(contactId, projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the contact project roles where contactId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByC_P(
		long contactId, long projectId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().findByC_P(
			contactId, projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the contact project roles where contactId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact project roles
	 */
	public static List<ContactProjectRole> findByC_P(
		long contactId, long projectId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_P(
			contactId, projectId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first contact project role in the ordered set where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public static ContactProjectRole findByC_P_First(
			long contactId, long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByC_P_First(
			contactId, projectId, orderByComparator);
	}

	/**
	 * Returns the first contact project role in the ordered set where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public static ContactProjectRole fetchByC_P_First(
		long contactId, long projectId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().fetchByC_P_First(
			contactId, projectId, orderByComparator);
	}

	/**
	 * Returns the last contact project role in the ordered set where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public static ContactProjectRole findByC_P_Last(
			long contactId, long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByC_P_Last(
			contactId, projectId, orderByComparator);
	}

	/**
	 * Returns the last contact project role in the ordered set where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public static ContactProjectRole fetchByC_P_Last(
		long contactId, long projectId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().fetchByC_P_Last(
			contactId, projectId, orderByComparator);
	}

	/**
	 * Returns the contact project roles before and after the current contact project role in the ordered set where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactProjectRolePK the primary key of the current contact project role
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact project role
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	public static ContactProjectRole[] findByC_P_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long contactId,
			long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByC_P_PrevAndNext(
			contactProjectRolePK, contactId, projectId, orderByComparator);
	}

	/**
	 * Removes all the contact project roles where contactId = &#63; and projectId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 */
	public static void removeByC_P(long contactId, long projectId) {
		getPersistence().removeByC_P(contactId, projectId);
	}

	/**
	 * Returns the number of contact project roles where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @return the number of matching contact project roles
	 */
	public static int countByC_P(long contactId, long projectId) {
		return getPersistence().countByC_P(contactId, projectId);
	}

	/**
	 * Caches the contact project role in the entity cache if it is enabled.
	 *
	 * @param contactProjectRole the contact project role
	 */
	public static void cacheResult(ContactProjectRole contactProjectRole) {
		getPersistence().cacheResult(contactProjectRole);
	}

	/**
	 * Caches the contact project roles in the entity cache if it is enabled.
	 *
	 * @param contactProjectRoles the contact project roles
	 */
	public static void cacheResult(
		List<ContactProjectRole> contactProjectRoles) {

		getPersistence().cacheResult(contactProjectRoles);
	}

	/**
	 * Creates a new contact project role with the primary key. Does not add the contact project role to the database.
	 *
	 * @param contactProjectRolePK the primary key for the new contact project role
	 * @return the new contact project role
	 */
	public static ContactProjectRole create(
		ContactProjectRolePK contactProjectRolePK) {

		return getPersistence().create(contactProjectRolePK);
	}

	/**
	 * Removes the contact project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactProjectRolePK the primary key of the contact project role
	 * @return the contact project role that was removed
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	public static ContactProjectRole remove(
			ContactProjectRolePK contactProjectRolePK)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().remove(contactProjectRolePK);
	}

	public static ContactProjectRole updateImpl(
		ContactProjectRole contactProjectRole) {

		return getPersistence().updateImpl(contactProjectRole);
	}

	/**
	 * Returns the contact project role with the primary key or throws a <code>NoSuchContactProjectRoleException</code> if it could not be found.
	 *
	 * @param contactProjectRolePK the primary key of the contact project role
	 * @return the contact project role
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	public static ContactProjectRole findByPrimaryKey(
			ContactProjectRolePK contactProjectRolePK)
		throws com.liferay.osb.koroneiki.taproot.exception.
			NoSuchContactProjectRoleException {

		return getPersistence().findByPrimaryKey(contactProjectRolePK);
	}

	/**
	 * Returns the contact project role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactProjectRolePK the primary key of the contact project role
	 * @return the contact project role, or <code>null</code> if a contact project role with the primary key could not be found
	 */
	public static ContactProjectRole fetchByPrimaryKey(
		ContactProjectRolePK contactProjectRolePK) {

		return getPersistence().fetchByPrimaryKey(contactProjectRolePK);
	}

	/**
	 * Returns all the contact project roles.
	 *
	 * @return the contact project roles
	 */
	public static List<ContactProjectRole> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the contact project roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @return the range of contact project roles
	 */
	public static List<ContactProjectRole> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the contact project roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact project roles
	 */
	public static List<ContactProjectRole> findAll(
		int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the contact project roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactProjectRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact project roles
	 * @param end the upper bound of the range of contact project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of contact project roles
	 */
	public static List<ContactProjectRole> findAll(
		int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the contact project roles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of contact project roles.
	 *
	 * @return the number of contact project roles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static ContactProjectRolePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ContactProjectRolePersistence, ContactProjectRolePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ContactProjectRolePersistence.class);

		ServiceTracker
			<ContactProjectRolePersistence, ContactProjectRolePersistence>
				serviceTracker =
					new ServiceTracker
						<ContactProjectRolePersistence,
						 ContactProjectRolePersistence>(
							 bundle.getBundleContext(),
							 ContactProjectRolePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}