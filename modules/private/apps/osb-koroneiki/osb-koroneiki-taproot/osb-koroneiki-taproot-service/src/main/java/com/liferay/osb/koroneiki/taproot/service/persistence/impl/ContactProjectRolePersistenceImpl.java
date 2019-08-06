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

package com.liferay.osb.koroneiki.taproot.service.persistence.impl;

import com.liferay.osb.koroneiki.taproot.exception.NoSuchContactProjectRoleException;
import com.liferay.osb.koroneiki.taproot.model.ContactProjectRole;
import com.liferay.osb.koroneiki.taproot.model.impl.ContactProjectRoleImpl;
import com.liferay.osb.koroneiki.taproot.model.impl.ContactProjectRoleModelImpl;
import com.liferay.osb.koroneiki.taproot.service.persistence.ContactProjectRolePK;
import com.liferay.osb.koroneiki.taproot.service.persistence.ContactProjectRolePersistence;
import com.liferay.osb.koroneiki.taproot.service.persistence.impl.constants.KoroneikiPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the contact project role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ContactProjectRolePersistence.class)
@ProviderType
public class ContactProjectRolePersistenceImpl
	extends BasePersistenceImpl<ContactProjectRole>
	implements ContactProjectRolePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ContactProjectRoleUtil</code> to access the contact project role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ContactProjectRoleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByContactId;
	private FinderPath _finderPathWithoutPaginationFindByContactId;
	private FinderPath _finderPathCountByContactId;

	/**
	 * Returns all the contact project roles where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the matching contact project roles
	 */
	@Override
	public List<ContactProjectRole> findByContactId(long contactId) {
		return findByContactId(
			contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ContactProjectRole> findByContactId(
		long contactId, int start, int end) {

		return findByContactId(contactId, start, end, null);
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
	@Override
	public List<ContactProjectRole> findByContactId(
		long contactId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return findByContactId(contactId, start, end, orderByComparator, true);
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
	@Override
	public List<ContactProjectRole> findByContactId(
		long contactId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByContactId;
				finderArgs = new Object[] {contactId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByContactId;
			finderArgs = new Object[] {
				contactId, start, end, orderByComparator
			};
		}

		List<ContactProjectRole> list = null;

		if (useFinderCache) {
			list = (List<ContactProjectRole>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ContactProjectRole contactProjectRole : list) {
					if ((contactId != contactProjectRole.getContactId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CONTACTPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ContactProjectRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				if (!pagination) {
					list = (List<ContactProjectRole>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ContactProjectRole>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole findByContactId_First(
			long contactId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = fetchByContactId_First(
			contactId, orderByComparator);

		if (contactProjectRole != null) {
			return contactProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append("}");

		throw new NoSuchContactProjectRoleException(msg.toString());
	}

	/**
	 * Returns the first contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole fetchByContactId_First(
		long contactId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		List<ContactProjectRole> list = findByContactId(
			contactId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole findByContactId_Last(
			long contactId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = fetchByContactId_Last(
			contactId, orderByComparator);

		if (contactProjectRole != null) {
			return contactProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append("}");

		throw new NoSuchContactProjectRoleException(msg.toString());
	}

	/**
	 * Returns the last contact project role in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole fetchByContactId_Last(
		long contactId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		int count = countByContactId(contactId);

		if (count == 0) {
			return null;
		}

		List<ContactProjectRole> list = findByContactId(
			contactId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ContactProjectRole[] findByContactId_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long contactId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = findByPrimaryKey(
			contactProjectRolePK);

		Session session = null;

		try {
			session = openSession();

			ContactProjectRole[] array = new ContactProjectRoleImpl[3];

			array[0] = getByContactId_PrevAndNext(
				session, contactProjectRole, contactId, orderByComparator,
				true);

			array[1] = contactProjectRole;

			array[2] = getByContactId_PrevAndNext(
				session, contactProjectRole, contactId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactProjectRole getByContactId_PrevAndNext(
		Session session, ContactProjectRole contactProjectRole, long contactId,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTPROJECTROLE_WHERE);

		query.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ContactProjectRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						contactProjectRole)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ContactProjectRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact project roles where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 */
	@Override
	public void removeByContactId(long contactId) {
		for (ContactProjectRole contactProjectRole :
				findByContactId(
					contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(contactProjectRole);
		}
	}

	/**
	 * Returns the number of contact project roles where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching contact project roles
	 */
	@Override
	public int countByContactId(long contactId) {
		FinderPath finderPath = _finderPathCountByContactId;

		Object[] finderArgs = new Object[] {contactId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONTACTID_CONTACTID_2 =
		"contactProjectRole.id.contactId = ?";

	private FinderPath _finderPathWithPaginationFindByProjectId;
	private FinderPath _finderPathWithoutPaginationFindByProjectId;
	private FinderPath _finderPathCountByProjectId;

	/**
	 * Returns all the contact project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching contact project roles
	 */
	@Override
	public List<ContactProjectRole> findByProjectId(long projectId) {
		return findByProjectId(
			projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ContactProjectRole> findByProjectId(
		long projectId, int start, int end) {

		return findByProjectId(projectId, start, end, null);
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
	@Override
	public List<ContactProjectRole> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return findByProjectId(projectId, start, end, orderByComparator, true);
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
	@Override
	public List<ContactProjectRole> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProjectId;
				finderArgs = new Object[] {projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProjectId;
			finderArgs = new Object[] {
				projectId, start, end, orderByComparator
			};
		}

		List<ContactProjectRole> list = null;

		if (useFinderCache) {
			list = (List<ContactProjectRole>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ContactProjectRole contactProjectRole : list) {
					if ((projectId != contactProjectRole.getProjectId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CONTACTPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ContactProjectRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				if (!pagination) {
					list = (List<ContactProjectRole>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ContactProjectRole>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole findByProjectId_First(
			long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = fetchByProjectId_First(
			projectId, orderByComparator);

		if (contactProjectRole != null) {
			return contactProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchContactProjectRoleException(msg.toString());
	}

	/**
	 * Returns the first contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole fetchByProjectId_First(
		long projectId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		List<ContactProjectRole> list = findByProjectId(
			projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole findByProjectId_Last(
			long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = fetchByProjectId_Last(
			projectId, orderByComparator);

		if (contactProjectRole != null) {
			return contactProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchContactProjectRoleException(msg.toString());
	}

	/**
	 * Returns the last contact project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole fetchByProjectId_Last(
		long projectId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		int count = countByProjectId(projectId);

		if (count == 0) {
			return null;
		}

		List<ContactProjectRole> list = findByProjectId(
			projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ContactProjectRole[] findByProjectId_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = findByPrimaryKey(
			contactProjectRolePK);

		Session session = null;

		try {
			session = openSession();

			ContactProjectRole[] array = new ContactProjectRoleImpl[3];

			array[0] = getByProjectId_PrevAndNext(
				session, contactProjectRole, projectId, orderByComparator,
				true);

			array[1] = contactProjectRole;

			array[2] = getByProjectId_PrevAndNext(
				session, contactProjectRole, projectId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactProjectRole getByProjectId_PrevAndNext(
		Session session, ContactProjectRole contactProjectRole, long projectId,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTPROJECTROLE_WHERE);

		query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ContactProjectRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						contactProjectRole)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ContactProjectRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact project roles where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByProjectId(long projectId) {
		for (ContactProjectRole contactProjectRole :
				findByProjectId(
					projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(contactProjectRole);
		}
	}

	/**
	 * Returns the number of contact project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching contact project roles
	 */
	@Override
	public int countByProjectId(long projectId) {
		FinderPath finderPath = _finderPathCountByProjectId;

		Object[] finderArgs = new Object[] {projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 =
		"contactProjectRole.id.projectId = ?";

	private FinderPath _finderPathWithPaginationFindByContactRoleId;
	private FinderPath _finderPathWithoutPaginationFindByContactRoleId;
	private FinderPath _finderPathCountByContactRoleId;

	/**
	 * Returns all the contact project roles where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @return the matching contact project roles
	 */
	@Override
	public List<ContactProjectRole> findByContactRoleId(long contactRoleId) {
		return findByContactRoleId(
			contactRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ContactProjectRole> findByContactRoleId(
		long contactRoleId, int start, int end) {

		return findByContactRoleId(contactRoleId, start, end, null);
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
	@Override
	public List<ContactProjectRole> findByContactRoleId(
		long contactRoleId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return findByContactRoleId(
			contactRoleId, start, end, orderByComparator, true);
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
	@Override
	public List<ContactProjectRole> findByContactRoleId(
		long contactRoleId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByContactRoleId;
				finderArgs = new Object[] {contactRoleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByContactRoleId;
			finderArgs = new Object[] {
				contactRoleId, start, end, orderByComparator
			};
		}

		List<ContactProjectRole> list = null;

		if (useFinderCache) {
			list = (List<ContactProjectRole>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ContactProjectRole contactProjectRole : list) {
					if ((contactRoleId !=
							contactProjectRole.getContactRoleId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CONTACTPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_CONTACTROLEID_CONTACTROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ContactProjectRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactRoleId);

				if (!pagination) {
					list = (List<ContactProjectRole>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ContactProjectRole>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole findByContactRoleId_First(
			long contactRoleId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = fetchByContactRoleId_First(
			contactRoleId, orderByComparator);

		if (contactProjectRole != null) {
			return contactProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactRoleId=");
		msg.append(contactRoleId);

		msg.append("}");

		throw new NoSuchContactProjectRoleException(msg.toString());
	}

	/**
	 * Returns the first contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole fetchByContactRoleId_First(
		long contactRoleId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		List<ContactProjectRole> list = findByContactRoleId(
			contactRoleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role
	 * @throws NoSuchContactProjectRoleException if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole findByContactRoleId_Last(
			long contactRoleId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = fetchByContactRoleId_Last(
			contactRoleId, orderByComparator);

		if (contactProjectRole != null) {
			return contactProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactRoleId=");
		msg.append(contactRoleId);

		msg.append("}");

		throw new NoSuchContactProjectRoleException(msg.toString());
	}

	/**
	 * Returns the last contact project role in the ordered set where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole fetchByContactRoleId_Last(
		long contactRoleId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		int count = countByContactRoleId(contactRoleId);

		if (count == 0) {
			return null;
		}

		List<ContactProjectRole> list = findByContactRoleId(
			contactRoleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ContactProjectRole[] findByContactRoleId_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long contactRoleId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = findByPrimaryKey(
			contactProjectRolePK);

		Session session = null;

		try {
			session = openSession();

			ContactProjectRole[] array = new ContactProjectRoleImpl[3];

			array[0] = getByContactRoleId_PrevAndNext(
				session, contactProjectRole, contactRoleId, orderByComparator,
				true);

			array[1] = contactProjectRole;

			array[2] = getByContactRoleId_PrevAndNext(
				session, contactProjectRole, contactRoleId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactProjectRole getByContactRoleId_PrevAndNext(
		Session session, ContactProjectRole contactProjectRole,
		long contactRoleId,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTPROJECTROLE_WHERE);

		query.append(_FINDER_COLUMN_CONTACTROLEID_CONTACTROLEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ContactProjectRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactRoleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						contactProjectRole)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ContactProjectRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact project roles where contactRoleId = &#63; from the database.
	 *
	 * @param contactRoleId the contact role ID
	 */
	@Override
	public void removeByContactRoleId(long contactRoleId) {
		for (ContactProjectRole contactProjectRole :
				findByContactRoleId(
					contactRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(contactProjectRole);
		}
	}

	/**
	 * Returns the number of contact project roles where contactRoleId = &#63;.
	 *
	 * @param contactRoleId the contact role ID
	 * @return the number of matching contact project roles
	 */
	@Override
	public int countByContactRoleId(long contactRoleId) {
		FinderPath finderPath = _finderPathCountByContactRoleId;

		Object[] finderArgs = new Object[] {contactRoleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_CONTACTROLEID_CONTACTROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactRoleId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONTACTROLEID_CONTACTROLEID_2 =
		"contactProjectRole.id.contactRoleId = ?";

	private FinderPath _finderPathWithPaginationFindByC_P;
	private FinderPath _finderPathWithoutPaginationFindByC_P;
	private FinderPath _finderPathCountByC_P;

	/**
	 * Returns all the contact project roles where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @return the matching contact project roles
	 */
	@Override
	public List<ContactProjectRole> findByC_P(long contactId, long projectId) {
		return findByC_P(
			contactId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ContactProjectRole> findByC_P(
		long contactId, long projectId, int start, int end) {

		return findByC_P(contactId, projectId, start, end, null);
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
	@Override
	public List<ContactProjectRole> findByC_P(
		long contactId, long projectId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return findByC_P(
			contactId, projectId, start, end, orderByComparator, true);
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
	@Override
	public List<ContactProjectRole> findByC_P(
		long contactId, long projectId, int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_P;
				finderArgs = new Object[] {contactId, projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_P;
			finderArgs = new Object[] {
				contactId, projectId, start, end, orderByComparator
			};
		}

		List<ContactProjectRole> list = null;

		if (useFinderCache) {
			list = (List<ContactProjectRole>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ContactProjectRole contactProjectRole : list) {
					if ((contactId != contactProjectRole.getContactId()) ||
						(projectId != contactProjectRole.getProjectId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CONTACTPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_C_P_CONTACTID_2);

			query.append(_FINDER_COLUMN_C_P_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ContactProjectRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				qPos.add(projectId);

				if (!pagination) {
					list = (List<ContactProjectRole>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ContactProjectRole>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public ContactProjectRole findByC_P_First(
			long contactId, long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = fetchByC_P_First(
			contactId, projectId, orderByComparator);

		if (contactProjectRole != null) {
			return contactProjectRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchContactProjectRoleException(msg.toString());
	}

	/**
	 * Returns the first contact project role in the ordered set where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole fetchByC_P_First(
		long contactId, long projectId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		List<ContactProjectRole> list = findByC_P(
			contactId, projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ContactProjectRole findByC_P_Last(
			long contactId, long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = fetchByC_P_Last(
			contactId, projectId, orderByComparator);

		if (contactProjectRole != null) {
			return contactProjectRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchContactProjectRoleException(msg.toString());
	}

	/**
	 * Returns the last contact project role in the ordered set where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact project role, or <code>null</code> if a matching contact project role could not be found
	 */
	@Override
	public ContactProjectRole fetchByC_P_Last(
		long contactId, long projectId,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		int count = countByC_P(contactId, projectId);

		if (count == 0) {
			return null;
		}

		List<ContactProjectRole> list = findByC_P(
			contactId, projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ContactProjectRole[] findByC_P_PrevAndNext(
			ContactProjectRolePK contactProjectRolePK, long contactId,
			long projectId,
			OrderByComparator<ContactProjectRole> orderByComparator)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = findByPrimaryKey(
			contactProjectRolePK);

		Session session = null;

		try {
			session = openSession();

			ContactProjectRole[] array = new ContactProjectRoleImpl[3];

			array[0] = getByC_P_PrevAndNext(
				session, contactProjectRole, contactId, projectId,
				orderByComparator, true);

			array[1] = contactProjectRole;

			array[2] = getByC_P_PrevAndNext(
				session, contactProjectRole, contactId, projectId,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactProjectRole getByC_P_PrevAndNext(
		Session session, ContactProjectRole contactProjectRole, long contactId,
		long projectId, OrderByComparator<ContactProjectRole> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CONTACTPROJECTROLE_WHERE);

		query.append(_FINDER_COLUMN_C_P_CONTACTID_2);

		query.append(_FINDER_COLUMN_C_P_PROJECTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ContactProjectRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactId);

		qPos.add(projectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						contactProjectRole)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ContactProjectRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact project roles where contactId = &#63; and projectId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 */
	@Override
	public void removeByC_P(long contactId, long projectId) {
		for (ContactProjectRole contactProjectRole :
				findByC_P(
					contactId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(contactProjectRole);
		}
	}

	/**
	 * Returns the number of contact project roles where contactId = &#63; and projectId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param projectId the project ID
	 * @return the number of matching contact project roles
	 */
	@Override
	public int countByC_P(long contactId, long projectId) {
		FinderPath finderPath = _finderPathCountByC_P;

		Object[] finderArgs = new Object[] {contactId, projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_C_P_CONTACTID_2);

			query.append(_FINDER_COLUMN_C_P_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				qPos.add(projectId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_P_CONTACTID_2 =
		"contactProjectRole.id.contactId = ? AND ";

	private static final String _FINDER_COLUMN_C_P_PROJECTID_2 =
		"contactProjectRole.id.projectId = ?";

	public ContactProjectRolePersistenceImpl() {
		setModelClass(ContactProjectRole.class);

		setModelImplClass(ContactProjectRoleImpl.class);
		setModelPKClass(ContactProjectRolePK.class);
	}

	/**
	 * Caches the contact project role in the entity cache if it is enabled.
	 *
	 * @param contactProjectRole the contact project role
	 */
	@Override
	public void cacheResult(ContactProjectRole contactProjectRole) {
		entityCache.putResult(
			entityCacheEnabled, ContactProjectRoleImpl.class,
			contactProjectRole.getPrimaryKey(), contactProjectRole);

		contactProjectRole.resetOriginalValues();
	}

	/**
	 * Caches the contact project roles in the entity cache if it is enabled.
	 *
	 * @param contactProjectRoles the contact project roles
	 */
	@Override
	public void cacheResult(List<ContactProjectRole> contactProjectRoles) {
		for (ContactProjectRole contactProjectRole : contactProjectRoles) {
			if (entityCache.getResult(
					entityCacheEnabled, ContactProjectRoleImpl.class,
					contactProjectRole.getPrimaryKey()) == null) {

				cacheResult(contactProjectRole);
			}
			else {
				contactProjectRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact project roles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ContactProjectRoleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact project role.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactProjectRole contactProjectRole) {
		entityCache.removeResult(
			entityCacheEnabled, ContactProjectRoleImpl.class,
			contactProjectRole.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContactProjectRole> contactProjectRoles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactProjectRole contactProjectRole : contactProjectRoles) {
			entityCache.removeResult(
				entityCacheEnabled, ContactProjectRoleImpl.class,
				contactProjectRole.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contact project role with the primary key. Does not add the contact project role to the database.
	 *
	 * @param contactProjectRolePK the primary key for the new contact project role
	 * @return the new contact project role
	 */
	@Override
	public ContactProjectRole create(
		ContactProjectRolePK contactProjectRolePK) {

		ContactProjectRole contactProjectRole = new ContactProjectRoleImpl();

		contactProjectRole.setNew(true);
		contactProjectRole.setPrimaryKey(contactProjectRolePK);

		return contactProjectRole;
	}

	/**
	 * Removes the contact project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactProjectRolePK the primary key of the contact project role
	 * @return the contact project role that was removed
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	@Override
	public ContactProjectRole remove(ContactProjectRolePK contactProjectRolePK)
		throws NoSuchContactProjectRoleException {

		return remove((Serializable)contactProjectRolePK);
	}

	/**
	 * Removes the contact project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact project role
	 * @return the contact project role that was removed
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	@Override
	public ContactProjectRole remove(Serializable primaryKey)
		throws NoSuchContactProjectRoleException {

		Session session = null;

		try {
			session = openSession();

			ContactProjectRole contactProjectRole =
				(ContactProjectRole)session.get(
					ContactProjectRoleImpl.class, primaryKey);

			if (contactProjectRole == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactProjectRoleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(contactProjectRole);
		}
		catch (NoSuchContactProjectRoleException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ContactProjectRole removeImpl(
		ContactProjectRole contactProjectRole) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactProjectRole)) {
				contactProjectRole = (ContactProjectRole)session.get(
					ContactProjectRoleImpl.class,
					contactProjectRole.getPrimaryKeyObj());
			}

			if (contactProjectRole != null) {
				session.delete(contactProjectRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contactProjectRole != null) {
			clearCache(contactProjectRole);
		}

		return contactProjectRole;
	}

	@Override
	public ContactProjectRole updateImpl(
		ContactProjectRole contactProjectRole) {

		boolean isNew = contactProjectRole.isNew();

		if (!(contactProjectRole instanceof ContactProjectRoleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(contactProjectRole.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					contactProjectRole);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in contactProjectRole proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ContactProjectRole implementation " +
					contactProjectRole.getClass());
		}

		ContactProjectRoleModelImpl contactProjectRoleModelImpl =
			(ContactProjectRoleModelImpl)contactProjectRole;

		Session session = null;

		try {
			session = openSession();

			if (contactProjectRole.isNew()) {
				session.save(contactProjectRole);

				contactProjectRole.setNew(false);
			}
			else {
				contactProjectRole = (ContactProjectRole)session.merge(
					contactProjectRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				contactProjectRoleModelImpl.getContactId()
			};

			finderCache.removeResult(_finderPathCountByContactId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByContactId, args);

			args = new Object[] {contactProjectRoleModelImpl.getProjectId()};

			finderCache.removeResult(_finderPathCountByProjectId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByProjectId, args);

			args = new Object[] {
				contactProjectRoleModelImpl.getContactRoleId()
			};

			finderCache.removeResult(_finderPathCountByContactRoleId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByContactRoleId, args);

			args = new Object[] {
				contactProjectRoleModelImpl.getContactId(),
				contactProjectRoleModelImpl.getProjectId()
			};

			finderCache.removeResult(_finderPathCountByC_P, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_P, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((contactProjectRoleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByContactId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					contactProjectRoleModelImpl.getOriginalContactId()
				};

				finderCache.removeResult(_finderPathCountByContactId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByContactId, args);

				args = new Object[] {
					contactProjectRoleModelImpl.getContactId()
				};

				finderCache.removeResult(_finderPathCountByContactId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByContactId, args);
			}

			if ((contactProjectRoleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByProjectId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					contactProjectRoleModelImpl.getOriginalProjectId()
				};

				finderCache.removeResult(_finderPathCountByProjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProjectId, args);

				args = new Object[] {
					contactProjectRoleModelImpl.getProjectId()
				};

				finderCache.removeResult(_finderPathCountByProjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProjectId, args);
			}

			if ((contactProjectRoleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByContactRoleId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					contactProjectRoleModelImpl.getOriginalContactRoleId()
				};

				finderCache.removeResult(_finderPathCountByContactRoleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByContactRoleId, args);

				args = new Object[] {
					contactProjectRoleModelImpl.getContactRoleId()
				};

				finderCache.removeResult(_finderPathCountByContactRoleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByContactRoleId, args);
			}

			if ((contactProjectRoleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_P.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					contactProjectRoleModelImpl.getOriginalContactId(),
					contactProjectRoleModelImpl.getOriginalProjectId()
				};

				finderCache.removeResult(_finderPathCountByC_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_P, args);

				args = new Object[] {
					contactProjectRoleModelImpl.getContactId(),
					contactProjectRoleModelImpl.getProjectId()
				};

				finderCache.removeResult(_finderPathCountByC_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_P, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ContactProjectRoleImpl.class,
			contactProjectRole.getPrimaryKey(), contactProjectRole, false);

		contactProjectRole.resetOriginalValues();

		return contactProjectRole;
	}

	/**
	 * Returns the contact project role with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact project role
	 * @return the contact project role
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	@Override
	public ContactProjectRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactProjectRoleException {

		ContactProjectRole contactProjectRole = fetchByPrimaryKey(primaryKey);

		if (contactProjectRole == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactProjectRoleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return contactProjectRole;
	}

	/**
	 * Returns the contact project role with the primary key or throws a <code>NoSuchContactProjectRoleException</code> if it could not be found.
	 *
	 * @param contactProjectRolePK the primary key of the contact project role
	 * @return the contact project role
	 * @throws NoSuchContactProjectRoleException if a contact project role with the primary key could not be found
	 */
	@Override
	public ContactProjectRole findByPrimaryKey(
			ContactProjectRolePK contactProjectRolePK)
		throws NoSuchContactProjectRoleException {

		return findByPrimaryKey((Serializable)contactProjectRolePK);
	}

	/**
	 * Returns the contact project role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactProjectRolePK the primary key of the contact project role
	 * @return the contact project role, or <code>null</code> if a contact project role with the primary key could not be found
	 */
	@Override
	public ContactProjectRole fetchByPrimaryKey(
		ContactProjectRolePK contactProjectRolePK) {

		return fetchByPrimaryKey((Serializable)contactProjectRolePK);
	}

	/**
	 * Returns all the contact project roles.
	 *
	 * @return the contact project roles
	 */
	@Override
	public List<ContactProjectRole> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ContactProjectRole> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ContactProjectRole> findAll(
		int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ContactProjectRole> findAll(
		int start, int end,
		OrderByComparator<ContactProjectRole> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ContactProjectRole> list = null;

		if (useFinderCache) {
			list = (List<ContactProjectRole>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CONTACTPROJECTROLE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTPROJECTROLE;

				if (pagination) {
					sql = sql.concat(ContactProjectRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContactProjectRole>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ContactProjectRole>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the contact project roles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ContactProjectRole contactProjectRole : findAll()) {
			remove(contactProjectRole);
		}
	}

	/**
	 * Returns the number of contact project roles.
	 *
	 * @return the number of contact project roles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACTPROJECTROLE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "contactProjectRolePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONTACTPROJECTROLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ContactProjectRoleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the contact project role persistence.
	 */
	@Activate
	public void activate() {
		ContactProjectRoleModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ContactProjectRoleModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ContactProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ContactProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByContactId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ContactProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByContactId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ContactProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContactId",
			new String[] {Long.class.getName()},
			ContactProjectRoleModelImpl.CONTACTID_COLUMN_BITMASK);

		_finderPathCountByContactId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByProjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ContactProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByProjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ContactProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectId",
			new String[] {Long.class.getName()},
			ContactProjectRoleModelImpl.PROJECTID_COLUMN_BITMASK);

		_finderPathCountByProjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByContactRoleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ContactProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactRoleId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByContactRoleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ContactProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContactRoleId",
			new String[] {Long.class.getName()},
			ContactProjectRoleModelImpl.CONTACTROLEID_COLUMN_BITMASK);

		_finderPathCountByContactRoleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactRoleId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByC_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ContactProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ContactProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_P",
			new String[] {Long.class.getName(), Long.class.getName()},
			ContactProjectRoleModelImpl.CONTACTID_COLUMN_BITMASK |
			ContactProjectRoleModelImpl.PROJECTID_COLUMN_BITMASK);

		_finderPathCountByC_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_P",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ContactProjectRoleImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = KoroneikiPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.osb.koroneiki.taproot.model.ContactProjectRole"),
			true);
	}

	@Override
	@Reference(
		target = KoroneikiPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = KoroneikiPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CONTACTPROJECTROLE =
		"SELECT contactProjectRole FROM ContactProjectRole contactProjectRole";

	private static final String _SQL_SELECT_CONTACTPROJECTROLE_WHERE =
		"SELECT contactProjectRole FROM ContactProjectRole contactProjectRole WHERE ";

	private static final String _SQL_COUNT_CONTACTPROJECTROLE =
		"SELECT COUNT(contactProjectRole) FROM ContactProjectRole contactProjectRole";

	private static final String _SQL_COUNT_CONTACTPROJECTROLE_WHERE =
		"SELECT COUNT(contactProjectRole) FROM ContactProjectRole contactProjectRole WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "contactProjectRole.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ContactProjectRole exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ContactProjectRole exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ContactProjectRolePersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"contactId", "projectId", "contactRoleId"});

}