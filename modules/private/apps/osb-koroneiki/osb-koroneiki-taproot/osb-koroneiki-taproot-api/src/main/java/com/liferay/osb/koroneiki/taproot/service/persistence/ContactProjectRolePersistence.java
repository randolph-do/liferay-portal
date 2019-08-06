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

import com.liferay.osb.koroneiki.taproot.exception.NoSuchContactProjectRoleException;
import com.liferay.osb.koroneiki.taproot.model.ContactProjectRole;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the contact project role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactProjectRoleUtil
 * @generated
 */
@ProviderType
public interface ContactProjectRolePersistence
	extends BasePersistence<ContactProjectRole> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactProjectRoleUtil} to access the contact project role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the contact project roles where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the matching contact project roles
	 */
	public java.util.List<ContactProjectRole> findByContactId(long contactId);

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
	public java.util.List<ContactProjectRole> findByContactId(
		long contactId, int start, int end);

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
	public java.util.List<ContactProjectRole> findByContactId(
		long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

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
	public java.util.List<ContactProjectRole> findByContactId(
		long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public ContactProjectRole findByContactId_First(
			long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Returns the first contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public ContactProjectRole fetchByContactId_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

	/**
	 * Returns the last contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public ContactProjectRole findByContactId_Last(
			long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Returns the last contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public ContactProjectRole fetchByContactId_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

	/**
	 * Returns the contact project roles before and after the current contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactProjectRolePK the primary key of the current contact project role
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact project role
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	public ContactProjectRole[] findByContactId_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Removes all the contact project roles where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 */
	public void removeByContactId(long contactId);

	/**
	 * Returns the number of contact project roles where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching contact project roles
	 */
	public int countByContactId(long contactId);

	/**
	 * Returns all the contact project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching contact project roles
	 */
	public java.util.List<ContactProjectRole> findByProjectId(long projectId);

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
	public java.util.List<ContactProjectRole> findByProjectId(
		long projectId, int start, int end);

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
	public java.util.List<ContactProjectRole> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

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
	public java.util.List<ContactProjectRole> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public ContactProjectRole findByProjectId_First(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Returns the first contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public ContactProjectRole fetchByProjectId_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

	/**
	 * Returns the last contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public ContactProjectRole findByProjectId_Last(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Returns the last contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public ContactProjectRole fetchByProjectId_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

	/**
	 * Returns the contact project roles before and after the current contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param contactProjectRolePK the primary key of the current contact project role
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact project role
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	public ContactProjectRole[] findByProjectId_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Removes all the contact project roles where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public void removeByProjectId(long projectId);

	/**
	 * Returns the number of contact project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching contact project roles
	 */
	public int countByProjectId(long projectId);

	/**
	 * Returns all the contact project roles where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @return the matching contact project roles
	 */
	public java.util.List<ContactProjectRole> findByContactRoleId(
		long contactRoleId);

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
	public java.util.List<ContactProjectRole> findByContactRoleId(
		long contactRoleId, int start, int end);

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
	public java.util.List<ContactProjectRole> findByContactRoleId(
		long contactRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

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
	public java.util.List<ContactProjectRole> findByContactRoleId(
		long contactRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public ContactProjectRole findByContactRoleId_First(
			long contactRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Returns the first contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public ContactProjectRole fetchByContactRoleId_First(
		long contactRoleId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

	/**
	 * Returns the last contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public ContactProjectRole findByContactRoleId_Last(
			long contactRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Returns the last contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public ContactProjectRole fetchByContactRoleId_Last(
		long contactRoleId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

	/**
	 * Returns the contact project roles before and after the current contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactProjectRolePK the primary key of the current contact project role
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact project role
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	public ContactProjectRole[] findByContactRoleId_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long contactRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Removes all the contact project roles where contactRoleId = &#63; from the database.
	 *
	 * @param contactRoleId the contact role ID
	 */
	public void removeByContactRoleId(long contactRoleId);

	/**
	 * Returns the number of contact project roles where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @return the number of matching contact project roles
	 */
	public int countByContactRoleId(long contactRoleId);

	/**
	 * Returns all the contact project roles where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @return the matching contact project roles
	 */
	public java.util.List<ContactProjectRole> findByC_P(
		long contactId, long projectId);

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
	public java.util.List<ContactProjectRole> findByC_P(
		long contactId, long projectId, int start, int end);

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
	public java.util.List<ContactProjectRole> findByC_P(
		long contactId, long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

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
	public java.util.List<ContactProjectRole> findByC_P(
		long contactId, long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact project role in the ordered set where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public ContactProjectRole findByC_P_First(
			long contactId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Returns the first contact project role in the ordered set where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public ContactProjectRole fetchByC_P_First(
		long contactId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

	/**
	 * Returns the last contact project role in the ordered set where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	public ContactProjectRole findByC_P_Last(
			long contactId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Returns the last contact project role in the ordered set where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	public ContactProjectRole fetchByC_P_Last(
		long contactId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

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
	public ContactProjectRole[] findByC_P_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long contactId,
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
				orderByComparator)
		throws NoSuchContactProjectRoleException;

	/**
	 * Removes all the contact project roles where contactId = &#63; and projectId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 */
	public void removeByC_P(long contactId, long projectId);

	/**
	 * Returns the number of contact project roles where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @return the number of matching contact project roles
	 */
	public int countByC_P(long contactId, long projectId);

	/**
	 * Caches the contact project role in the entity cache if it is enabled.
	 *
	 * @param contactProjectRole the contact project role
	 */
	public void cacheResult(ContactProjectRole contactProjectRole);

	/**
	 * Caches the contact project roles in the entity cache if it is enabled.
	 *
	 * @param contactProjectRoles the contact project roles
	 */
	public void cacheResult(
		java.util.List<ContactProjectRole> contactProjectRoles);

	/**
	 * Creates a new contact project role with the primary key. Does not add the contact project role to the database.
	 *
	 * @param contactProjectRolePK the primary key for the new contact project role
	 * @return the new contact project role
	 */
	public ContactProjectRole create(ContactProjectRolePK contactProjectRolePK);

	/**
	 * Removes the contact project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactProjectRolePK the primary key of the contact project role
	 * @return the contact project role that was removed
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	public ContactProjectRole remove(ContactProjectRolePK contactProjectRolePK)
		throws NoSuchContactProjectRoleException;

	public ContactProjectRole updateImpl(ContactProjectRole contactProjectRole);

	/**
	 * Returns the contact project role with the primary key or throws a <code>NoSuchContactProjectRoleException</code> if it could not be found.
	 *
	 * @param contactProjectRolePK the primary key of the contact project role
	 * @return the contact project role
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	public ContactProjectRole findByPrimaryKey(
			ContactProjectRolePK contactProjectRolePK)
		throws NoSuchContactProjectRoleException;

	/**
	 * Returns the contact project role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactProjectRolePK the primary key of the contact project role
	 * @return the contact project role, or <code>null</code> if a contact project role with the primary key could not be found
	 */
	public ContactProjectRole fetchByPrimaryKey(
		ContactProjectRolePK contactProjectRolePK);

	/**
	 * Returns all the contact project roles.
	 *
	 * @return the contact project roles
	 */
	public java.util.List<ContactProjectRole> findAll();

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
	public java.util.List<ContactProjectRole> findAll(int start, int end);

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
	public java.util.List<ContactProjectRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator);

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
	public java.util.List<ContactProjectRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactProjectRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the contact project roles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of contact project roles.
	 *
	 * @return the number of contact project roles
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}