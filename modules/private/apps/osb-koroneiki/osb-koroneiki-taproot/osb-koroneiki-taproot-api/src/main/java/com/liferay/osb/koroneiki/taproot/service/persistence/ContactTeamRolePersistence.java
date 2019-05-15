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

import com.liferay.osb.koroneiki.taproot.exception.NoSuchContactTeamRoleException;
import com.liferay.osb.koroneiki.taproot.model.ContactTeamRole;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

/**
 * The persistence interface for the contact team role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactTeamRoleUtil
 * @generated
 */
@ProviderType
public interface ContactTeamRolePersistence
	extends BasePersistence<ContactTeamRole> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactTeamRoleUtil} to access the contact team role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the contact team role in the entity cache if it is enabled.
	 *
	 * @param contactTeamRole the contact team role
	 */
	public void cacheResult(ContactTeamRole contactTeamRole);

	/**
	 * Caches the contact team roles in the entity cache if it is enabled.
	 *
	 * @param contactTeamRoles the contact team roles
	 */
	public void cacheResult(java.util.List<ContactTeamRole> contactTeamRoles);

	/**
	 * Creates a new contact team role with the primary key. Does not add the contact team role to the database.
	 *
	 * @param contactTeamRolePK the primary key for the new contact team role
	 * @return the new contact team role
	 */
	public ContactTeamRole create(ContactTeamRolePK contactTeamRolePK);

	/**
	 * Removes the contact team role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactTeamRolePK the primary key of the contact team role
	 * @return the contact team role that was removed
	 * @throws NoSuchContactTeamRoleException if a contact team role with the primary key could not be found
	 */
	public ContactTeamRole remove(ContactTeamRolePK contactTeamRolePK)
		throws NoSuchContactTeamRoleException;

	public ContactTeamRole updateImpl(ContactTeamRole contactTeamRole);

	/**
	 * Returns the contact team role with the primary key or throws a <code>NoSuchContactTeamRoleException</code> if it could not be found.
	 *
	 * @param contactTeamRolePK the primary key of the contact team role
	 * @return the contact team role
	 * @throws NoSuchContactTeamRoleException if a contact team role with the primary key could not be found
	 */
	public ContactTeamRole findByPrimaryKey(ContactTeamRolePK contactTeamRolePK)
		throws NoSuchContactTeamRoleException;

	/**
	 * Returns the contact team role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactTeamRolePK the primary key of the contact team role
	 * @return the contact team role, or <code>null</code> if a contact team role with the primary key could not be found
	 */
	public ContactTeamRole fetchByPrimaryKey(
		ContactTeamRolePK contactTeamRolePK);

	/**
	 * Returns all the contact team roles.
	 *
	 * @return the contact team roles
	 */
	public java.util.List<ContactTeamRole> findAll();

	/**
	 * Returns a range of all the contact team roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactTeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact team roles
	 * @param end the upper bound of the range of contact team roles (not inclusive)
	 * @return the range of contact team roles
	 */
	public java.util.List<ContactTeamRole> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the contact team roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactTeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact team roles
	 * @param end the upper bound of the range of contact team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact team roles
	 */
	public java.util.List<ContactTeamRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactTeamRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the contact team roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContactTeamRoleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact team roles
	 * @param end the upper bound of the range of contact team roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of contact team roles
	 */
	public java.util.List<ContactTeamRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactTeamRole>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the contact team roles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of contact team roles.
	 *
	 * @return the number of contact team roles
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}