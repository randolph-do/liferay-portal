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

import com.liferay.osb.koroneiki.taproot.exception.NoSuchTeamProjectRoleException;
import com.liferay.osb.koroneiki.taproot.model.TeamProjectRole;
import com.liferay.osb.koroneiki.taproot.model.impl.TeamProjectRoleImpl;
import com.liferay.osb.koroneiki.taproot.model.impl.TeamProjectRoleModelImpl;
import com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectRolePK;
import com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectRolePersistence;
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
 * The persistence implementation for the team project role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TeamProjectRolePersistence.class)
@ProviderType
public class TeamProjectRolePersistenceImpl
	extends BasePersistenceImpl<TeamProjectRole>
	implements TeamProjectRolePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TeamProjectRoleUtil</code> to access the team project role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TeamProjectRoleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByTeamId;
	private FinderPath _finderPathWithoutPaginationFindByTeamId;
	private FinderPath _finderPathCountByTeamId;

	/**
	 * Returns all the team project roles where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @return the matching team project roles
	 */
	@Override
	public List<TeamProjectRole> findByTeamId(long teamId) {
		return findByTeamId(teamId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TeamProjectRole> findByTeamId(long teamId, int start, int end) {
		return findByTeamId(teamId, start, end, null);
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
	@Override
	public List<TeamProjectRole> findByTeamId(
		long teamId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return findByTeamId(teamId, start, end, orderByComparator, true);
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
	@Override
	public List<TeamProjectRole> findByTeamId(
		long teamId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTeamId;
				finderArgs = new Object[] {teamId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTeamId;
			finderArgs = new Object[] {teamId, start, end, orderByComparator};
		}

		List<TeamProjectRole> list = null;

		if (useFinderCache) {
			list = (List<TeamProjectRole>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TeamProjectRole teamProjectRole : list) {
					if ((teamId != teamProjectRole.getTeamId())) {
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

			query.append(_SQL_SELECT_TEAMPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_TEAMID_TEAMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TeamProjectRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(teamId);

				if (!pagination) {
					list = (List<TeamProjectRole>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TeamProjectRole>)QueryUtil.list(
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
	 * Returns the first team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole findByTeamId_First(
			long teamId, OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = fetchByTeamId_First(
			teamId, orderByComparator);

		if (teamProjectRole != null) {
			return teamProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("teamId=");
		msg.append(teamId);

		msg.append("}");

		throw new NoSuchTeamProjectRoleException(msg.toString());
	}

	/**
	 * Returns the first team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole fetchByTeamId_First(
		long teamId, OrderByComparator<TeamProjectRole> orderByComparator) {

		List<TeamProjectRole> list = findByTeamId(
			teamId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole findByTeamId_Last(
			long teamId, OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = fetchByTeamId_Last(
			teamId, orderByComparator);

		if (teamProjectRole != null) {
			return teamProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("teamId=");
		msg.append(teamId);

		msg.append("}");

		throw new NoSuchTeamProjectRoleException(msg.toString());
	}

	/**
	 * Returns the last team project role in the ordered set where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole fetchByTeamId_Last(
		long teamId, OrderByComparator<TeamProjectRole> orderByComparator) {

		int count = countByTeamId(teamId);

		if (count == 0) {
			return null;
		}

		List<TeamProjectRole> list = findByTeamId(
			teamId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TeamProjectRole[] findByTeamId_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long teamId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = findByPrimaryKey(teamProjectRolePK);

		Session session = null;

		try {
			session = openSession();

			TeamProjectRole[] array = new TeamProjectRoleImpl[3];

			array[0] = getByTeamId_PrevAndNext(
				session, teamProjectRole, teamId, orderByComparator, true);

			array[1] = teamProjectRole;

			array[2] = getByTeamId_PrevAndNext(
				session, teamProjectRole, teamId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TeamProjectRole getByTeamId_PrevAndNext(
		Session session, TeamProjectRole teamProjectRole, long teamId,
		OrderByComparator<TeamProjectRole> orderByComparator,
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

		query.append(_SQL_SELECT_TEAMPROJECTROLE_WHERE);

		query.append(_FINDER_COLUMN_TEAMID_TEAMID_2);

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
			query.append(TeamProjectRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(teamId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						teamProjectRole)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TeamProjectRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team project roles where teamId = &#63; from the database.
	 *
	 * @param teamId the team ID
	 */
	@Override
	public void removeByTeamId(long teamId) {
		for (TeamProjectRole teamProjectRole :
				findByTeamId(
					teamId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(teamProjectRole);
		}
	}

	/**
	 * Returns the number of team project roles where teamId = &#63;.
	 *
	 * @param teamId the team ID
	 * @return the number of matching team project roles
	 */
	@Override
	public int countByTeamId(long teamId) {
		FinderPath finderPath = _finderPathCountByTeamId;

		Object[] finderArgs = new Object[] {teamId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TEAMPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_TEAMID_TEAMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(teamId);

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

	private static final String _FINDER_COLUMN_TEAMID_TEAMID_2 =
		"teamProjectRole.id.teamId = ?";

	private FinderPath _finderPathWithPaginationFindByProjectId;
	private FinderPath _finderPathWithoutPaginationFindByProjectId;
	private FinderPath _finderPathCountByProjectId;

	/**
	 * Returns all the team project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching team project roles
	 */
	@Override
	public List<TeamProjectRole> findByProjectId(long projectId) {
		return findByProjectId(
			projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TeamProjectRole> findByProjectId(
		long projectId, int start, int end) {

		return findByProjectId(projectId, start, end, null);
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
	@Override
	public List<TeamProjectRole> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return findByProjectId(projectId, start, end, orderByComparator, true);
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
	@Override
	public List<TeamProjectRole> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator,
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

		List<TeamProjectRole> list = null;

		if (useFinderCache) {
			list = (List<TeamProjectRole>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TeamProjectRole teamProjectRole : list) {
					if ((projectId != teamProjectRole.getProjectId())) {
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

			query.append(_SQL_SELECT_TEAMPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TeamProjectRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				if (!pagination) {
					list = (List<TeamProjectRole>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TeamProjectRole>)QueryUtil.list(
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
	 * Returns the first team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole findByProjectId_First(
			long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = fetchByProjectId_First(
			projectId, orderByComparator);

		if (teamProjectRole != null) {
			return teamProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchTeamProjectRoleException(msg.toString());
	}

	/**
	 * Returns the first team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole fetchByProjectId_First(
		long projectId, OrderByComparator<TeamProjectRole> orderByComparator) {

		List<TeamProjectRole> list = findByProjectId(
			projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole findByProjectId_Last(
			long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = fetchByProjectId_Last(
			projectId, orderByComparator);

		if (teamProjectRole != null) {
			return teamProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchTeamProjectRoleException(msg.toString());
	}

	/**
	 * Returns the last team project role in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole fetchByProjectId_Last(
		long projectId, OrderByComparator<TeamProjectRole> orderByComparator) {

		int count = countByProjectId(projectId);

		if (count == 0) {
			return null;
		}

		List<TeamProjectRole> list = findByProjectId(
			projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TeamProjectRole[] findByProjectId_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = findByPrimaryKey(teamProjectRolePK);

		Session session = null;

		try {
			session = openSession();

			TeamProjectRole[] array = new TeamProjectRoleImpl[3];

			array[0] = getByProjectId_PrevAndNext(
				session, teamProjectRole, projectId, orderByComparator, true);

			array[1] = teamProjectRole;

			array[2] = getByProjectId_PrevAndNext(
				session, teamProjectRole, projectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TeamProjectRole getByProjectId_PrevAndNext(
		Session session, TeamProjectRole teamProjectRole, long projectId,
		OrderByComparator<TeamProjectRole> orderByComparator,
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

		query.append(_SQL_SELECT_TEAMPROJECTROLE_WHERE);

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
			query.append(TeamProjectRoleModelImpl.ORDER_BY_JPQL);
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
						teamProjectRole)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TeamProjectRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team project roles where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByProjectId(long projectId) {
		for (TeamProjectRole teamProjectRole :
				findByProjectId(
					projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(teamProjectRole);
		}
	}

	/**
	 * Returns the number of team project roles where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching team project roles
	 */
	@Override
	public int countByProjectId(long projectId) {
		FinderPath finderPath = _finderPathCountByProjectId;

		Object[] finderArgs = new Object[] {projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TEAMPROJECTROLE_WHERE);

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
		"teamProjectRole.id.projectId = ?";

	private FinderPath _finderPathWithPaginationFindByTeamRoleId;
	private FinderPath _finderPathWithoutPaginationFindByTeamRoleId;
	private FinderPath _finderPathCountByTeamRoleId;

	/**
	 * Returns all the team project roles where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @return the matching team project roles
	 */
	@Override
	public List<TeamProjectRole> findByTeamRoleId(long teamRoleId) {
		return findByTeamRoleId(
			teamRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TeamProjectRole> findByTeamRoleId(
		long teamRoleId, int start, int end) {

		return findByTeamRoleId(teamRoleId, start, end, null);
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
	@Override
	public List<TeamProjectRole> findByTeamRoleId(
		long teamRoleId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return findByTeamRoleId(
			teamRoleId, start, end, orderByComparator, true);
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
	@Override
	public List<TeamProjectRole> findByTeamRoleId(
		long teamRoleId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTeamRoleId;
				finderArgs = new Object[] {teamRoleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTeamRoleId;
			finderArgs = new Object[] {
				teamRoleId, start, end, orderByComparator
			};
		}

		List<TeamProjectRole> list = null;

		if (useFinderCache) {
			list = (List<TeamProjectRole>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TeamProjectRole teamProjectRole : list) {
					if ((teamRoleId != teamProjectRole.getTeamRoleId())) {
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

			query.append(_SQL_SELECT_TEAMPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_TEAMROLEID_TEAMROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TeamProjectRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(teamRoleId);

				if (!pagination) {
					list = (List<TeamProjectRole>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TeamProjectRole>)QueryUtil.list(
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
	 * Returns the first team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole findByTeamRoleId_First(
			long teamRoleId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = fetchByTeamRoleId_First(
			teamRoleId, orderByComparator);

		if (teamProjectRole != null) {
			return teamProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("teamRoleId=");
		msg.append(teamRoleId);

		msg.append("}");

		throw new NoSuchTeamProjectRoleException(msg.toString());
	}

	/**
	 * Returns the first team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole fetchByTeamRoleId_First(
		long teamRoleId, OrderByComparator<TeamProjectRole> orderByComparator) {

		List<TeamProjectRole> list = findByTeamRoleId(
			teamRoleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole findByTeamRoleId_Last(
			long teamRoleId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = fetchByTeamRoleId_Last(
			teamRoleId, orderByComparator);

		if (teamProjectRole != null) {
			return teamProjectRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("teamRoleId=");
		msg.append(teamRoleId);

		msg.append("}");

		throw new NoSuchTeamProjectRoleException(msg.toString());
	}

	/**
	 * Returns the last team project role in the ordered set where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole fetchByTeamRoleId_Last(
		long teamRoleId, OrderByComparator<TeamProjectRole> orderByComparator) {

		int count = countByTeamRoleId(teamRoleId);

		if (count == 0) {
			return null;
		}

		List<TeamProjectRole> list = findByTeamRoleId(
			teamRoleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TeamProjectRole[] findByTeamRoleId_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long teamRoleId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = findByPrimaryKey(teamProjectRolePK);

		Session session = null;

		try {
			session = openSession();

			TeamProjectRole[] array = new TeamProjectRoleImpl[3];

			array[0] = getByTeamRoleId_PrevAndNext(
				session, teamProjectRole, teamRoleId, orderByComparator, true);

			array[1] = teamProjectRole;

			array[2] = getByTeamRoleId_PrevAndNext(
				session, teamProjectRole, teamRoleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TeamProjectRole getByTeamRoleId_PrevAndNext(
		Session session, TeamProjectRole teamProjectRole, long teamRoleId,
		OrderByComparator<TeamProjectRole> orderByComparator,
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

		query.append(_SQL_SELECT_TEAMPROJECTROLE_WHERE);

		query.append(_FINDER_COLUMN_TEAMROLEID_TEAMROLEID_2);

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
			query.append(TeamProjectRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(teamRoleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						teamProjectRole)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TeamProjectRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team project roles where teamRoleId = &#63; from the database.
	 *
	 * @param teamRoleId the team role ID
	 */
	@Override
	public void removeByTeamRoleId(long teamRoleId) {
		for (TeamProjectRole teamProjectRole :
				findByTeamRoleId(
					teamRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(teamProjectRole);
		}
	}

	/**
	 * Returns the number of team project roles where teamRoleId = &#63;.
	 *
	 * @param teamRoleId the team role ID
	 * @return the number of matching team project roles
	 */
	@Override
	public int countByTeamRoleId(long teamRoleId) {
		FinderPath finderPath = _finderPathCountByTeamRoleId;

		Object[] finderArgs = new Object[] {teamRoleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TEAMPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_TEAMROLEID_TEAMROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(teamRoleId);

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

	private static final String _FINDER_COLUMN_TEAMROLEID_TEAMROLEID_2 =
		"teamProjectRole.id.teamRoleId = ?";

	private FinderPath _finderPathWithPaginationFindByT_P;
	private FinderPath _finderPathWithoutPaginationFindByT_P;
	private FinderPath _finderPathCountByT_P;

	/**
	 * Returns all the team project roles where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @return the matching team project roles
	 */
	@Override
	public List<TeamProjectRole> findByT_P(long teamId, long projectId) {
		return findByT_P(
			teamId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TeamProjectRole> findByT_P(
		long teamId, long projectId, int start, int end) {

		return findByT_P(teamId, projectId, start, end, null);
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
	@Override
	public List<TeamProjectRole> findByT_P(
		long teamId, long projectId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return findByT_P(
			teamId, projectId, start, end, orderByComparator, true);
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
	@Override
	public List<TeamProjectRole> findByT_P(
		long teamId, long projectId, int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByT_P;
				finderArgs = new Object[] {teamId, projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByT_P;
			finderArgs = new Object[] {
				teamId, projectId, start, end, orderByComparator
			};
		}

		List<TeamProjectRole> list = null;

		if (useFinderCache) {
			list = (List<TeamProjectRole>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TeamProjectRole teamProjectRole : list) {
					if ((teamId != teamProjectRole.getTeamId()) ||
						(projectId != teamProjectRole.getProjectId())) {

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

			query.append(_SQL_SELECT_TEAMPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_T_P_TEAMID_2);

			query.append(_FINDER_COLUMN_T_P_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TeamProjectRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(teamId);

				qPos.add(projectId);

				if (!pagination) {
					list = (List<TeamProjectRole>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TeamProjectRole>)QueryUtil.list(
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
	 * Returns the first team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role
	 * @throws NoSuchTeamProjectRoleException if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole findByT_P_First(
			long teamId, long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = fetchByT_P_First(
			teamId, projectId, orderByComparator);

		if (teamProjectRole != null) {
			return teamProjectRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("teamId=");
		msg.append(teamId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchTeamProjectRoleException(msg.toString());
	}

	/**
	 * Returns the first team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole fetchByT_P_First(
		long teamId, long projectId,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		List<TeamProjectRole> list = findByT_P(
			teamId, projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TeamProjectRole findByT_P_Last(
			long teamId, long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = fetchByT_P_Last(
			teamId, projectId, orderByComparator);

		if (teamProjectRole != null) {
			return teamProjectRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("teamId=");
		msg.append(teamId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchTeamProjectRoleException(msg.toString());
	}

	/**
	 * Returns the last team project role in the ordered set where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team project role, or <code>null</code> if a matching team project role could not be found
	 */
	@Override
	public TeamProjectRole fetchByT_P_Last(
		long teamId, long projectId,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		int count = countByT_P(teamId, projectId);

		if (count == 0) {
			return null;
		}

		List<TeamProjectRole> list = findByT_P(
			teamId, projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TeamProjectRole[] findByT_P_PrevAndNext(
			TeamProjectRolePK teamProjectRolePK, long teamId, long projectId,
			OrderByComparator<TeamProjectRole> orderByComparator)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = findByPrimaryKey(teamProjectRolePK);

		Session session = null;

		try {
			session = openSession();

			TeamProjectRole[] array = new TeamProjectRoleImpl[3];

			array[0] = getByT_P_PrevAndNext(
				session, teamProjectRole, teamId, projectId, orderByComparator,
				true);

			array[1] = teamProjectRole;

			array[2] = getByT_P_PrevAndNext(
				session, teamProjectRole, teamId, projectId, orderByComparator,
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

	protected TeamProjectRole getByT_P_PrevAndNext(
		Session session, TeamProjectRole teamProjectRole, long teamId,
		long projectId, OrderByComparator<TeamProjectRole> orderByComparator,
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

		query.append(_SQL_SELECT_TEAMPROJECTROLE_WHERE);

		query.append(_FINDER_COLUMN_T_P_TEAMID_2);

		query.append(_FINDER_COLUMN_T_P_PROJECTID_2);

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
			query.append(TeamProjectRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(teamId);

		qPos.add(projectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						teamProjectRole)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TeamProjectRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team project roles where teamId = &#63; and projectId = &#63; from the database.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 */
	@Override
	public void removeByT_P(long teamId, long projectId) {
		for (TeamProjectRole teamProjectRole :
				findByT_P(
					teamId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(teamProjectRole);
		}
	}

	/**
	 * Returns the number of team project roles where teamId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the team ID
	 * @param projectId the project ID
	 * @return the number of matching team project roles
	 */
	@Override
	public int countByT_P(long teamId, long projectId) {
		FinderPath finderPath = _finderPathCountByT_P;

		Object[] finderArgs = new Object[] {teamId, projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TEAMPROJECTROLE_WHERE);

			query.append(_FINDER_COLUMN_T_P_TEAMID_2);

			query.append(_FINDER_COLUMN_T_P_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(teamId);

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

	private static final String _FINDER_COLUMN_T_P_TEAMID_2 =
		"teamProjectRole.id.teamId = ? AND ";

	private static final String _FINDER_COLUMN_T_P_PROJECTID_2 =
		"teamProjectRole.id.projectId = ?";

	public TeamProjectRolePersistenceImpl() {
		setModelClass(TeamProjectRole.class);

		setModelImplClass(TeamProjectRoleImpl.class);
		setModelPKClass(TeamProjectRolePK.class);
	}

	/**
	 * Caches the team project role in the entity cache if it is enabled.
	 *
	 * @param teamProjectRole the team project role
	 */
	@Override
	public void cacheResult(TeamProjectRole teamProjectRole) {
		entityCache.putResult(
			entityCacheEnabled, TeamProjectRoleImpl.class,
			teamProjectRole.getPrimaryKey(), teamProjectRole);

		teamProjectRole.resetOriginalValues();
	}

	/**
	 * Caches the team project roles in the entity cache if it is enabled.
	 *
	 * @param teamProjectRoles the team project roles
	 */
	@Override
	public void cacheResult(List<TeamProjectRole> teamProjectRoles) {
		for (TeamProjectRole teamProjectRole : teamProjectRoles) {
			if (entityCache.getResult(
					entityCacheEnabled, TeamProjectRoleImpl.class,
					teamProjectRole.getPrimaryKey()) == null) {

				cacheResult(teamProjectRole);
			}
			else {
				teamProjectRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all team project roles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TeamProjectRoleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the team project role.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TeamProjectRole teamProjectRole) {
		entityCache.removeResult(
			entityCacheEnabled, TeamProjectRoleImpl.class,
			teamProjectRole.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TeamProjectRole> teamProjectRoles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TeamProjectRole teamProjectRole : teamProjectRoles) {
			entityCache.removeResult(
				entityCacheEnabled, TeamProjectRoleImpl.class,
				teamProjectRole.getPrimaryKey());
		}
	}

	/**
	 * Creates a new team project role with the primary key. Does not add the team project role to the database.
	 *
	 * @param teamProjectRolePK the primary key for the new team project role
	 * @return the new team project role
	 */
	@Override
	public TeamProjectRole create(TeamProjectRolePK teamProjectRolePK) {
		TeamProjectRole teamProjectRole = new TeamProjectRoleImpl();

		teamProjectRole.setNew(true);
		teamProjectRole.setPrimaryKey(teamProjectRolePK);

		return teamProjectRole;
	}

	/**
	 * Removes the team project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role that was removed
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	@Override
	public TeamProjectRole remove(TeamProjectRolePK teamProjectRolePK)
		throws NoSuchTeamProjectRoleException {

		return remove((Serializable)teamProjectRolePK);
	}

	/**
	 * Removes the team project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the team project role
	 * @return the team project role that was removed
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	@Override
	public TeamProjectRole remove(Serializable primaryKey)
		throws NoSuchTeamProjectRoleException {

		Session session = null;

		try {
			session = openSession();

			TeamProjectRole teamProjectRole = (TeamProjectRole)session.get(
				TeamProjectRoleImpl.class, primaryKey);

			if (teamProjectRole == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTeamProjectRoleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(teamProjectRole);
		}
		catch (NoSuchTeamProjectRoleException nsee) {
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
	protected TeamProjectRole removeImpl(TeamProjectRole teamProjectRole) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(teamProjectRole)) {
				teamProjectRole = (TeamProjectRole)session.get(
					TeamProjectRoleImpl.class,
					teamProjectRole.getPrimaryKeyObj());
			}

			if (teamProjectRole != null) {
				session.delete(teamProjectRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (teamProjectRole != null) {
			clearCache(teamProjectRole);
		}

		return teamProjectRole;
	}

	@Override
	public TeamProjectRole updateImpl(TeamProjectRole teamProjectRole) {
		boolean isNew = teamProjectRole.isNew();

		if (!(teamProjectRole instanceof TeamProjectRoleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(teamProjectRole.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					teamProjectRole);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in teamProjectRole proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TeamProjectRole implementation " +
					teamProjectRole.getClass());
		}

		TeamProjectRoleModelImpl teamProjectRoleModelImpl =
			(TeamProjectRoleModelImpl)teamProjectRole;

		Session session = null;

		try {
			session = openSession();

			if (teamProjectRole.isNew()) {
				session.save(teamProjectRole);

				teamProjectRole.setNew(false);
			}
			else {
				teamProjectRole = (TeamProjectRole)session.merge(
					teamProjectRole);
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
			Object[] args = new Object[] {teamProjectRoleModelImpl.getTeamId()};

			finderCache.removeResult(_finderPathCountByTeamId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTeamId, args);

			args = new Object[] {teamProjectRoleModelImpl.getProjectId()};

			finderCache.removeResult(_finderPathCountByProjectId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByProjectId, args);

			args = new Object[] {teamProjectRoleModelImpl.getTeamRoleId()};

			finderCache.removeResult(_finderPathCountByTeamRoleId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTeamRoleId, args);

			args = new Object[] {
				teamProjectRoleModelImpl.getTeamId(),
				teamProjectRoleModelImpl.getProjectId()
			};

			finderCache.removeResult(_finderPathCountByT_P, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByT_P, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((teamProjectRoleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTeamId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					teamProjectRoleModelImpl.getOriginalTeamId()
				};

				finderCache.removeResult(_finderPathCountByTeamId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeamId, args);

				args = new Object[] {teamProjectRoleModelImpl.getTeamId()};

				finderCache.removeResult(_finderPathCountByTeamId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeamId, args);
			}

			if ((teamProjectRoleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByProjectId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					teamProjectRoleModelImpl.getOriginalProjectId()
				};

				finderCache.removeResult(_finderPathCountByProjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProjectId, args);

				args = new Object[] {teamProjectRoleModelImpl.getProjectId()};

				finderCache.removeResult(_finderPathCountByProjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProjectId, args);
			}

			if ((teamProjectRoleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTeamRoleId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					teamProjectRoleModelImpl.getOriginalTeamRoleId()
				};

				finderCache.removeResult(_finderPathCountByTeamRoleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeamRoleId, args);

				args = new Object[] {teamProjectRoleModelImpl.getTeamRoleId()};

				finderCache.removeResult(_finderPathCountByTeamRoleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeamRoleId, args);
			}

			if ((teamProjectRoleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByT_P.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					teamProjectRoleModelImpl.getOriginalTeamId(),
					teamProjectRoleModelImpl.getOriginalProjectId()
				};

				finderCache.removeResult(_finderPathCountByT_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByT_P, args);

				args = new Object[] {
					teamProjectRoleModelImpl.getTeamId(),
					teamProjectRoleModelImpl.getProjectId()
				};

				finderCache.removeResult(_finderPathCountByT_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByT_P, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TeamProjectRoleImpl.class,
			teamProjectRole.getPrimaryKey(), teamProjectRole, false);

		teamProjectRole.resetOriginalValues();

		return teamProjectRole;
	}

	/**
	 * Returns the team project role with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the team project role
	 * @return the team project role
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	@Override
	public TeamProjectRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTeamProjectRoleException {

		TeamProjectRole teamProjectRole = fetchByPrimaryKey(primaryKey);

		if (teamProjectRole == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTeamProjectRoleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return teamProjectRole;
	}

	/**
	 * Returns the team project role with the primary key or throws a <code>NoSuchTeamProjectRoleException</code> if it could not be found.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role
	 * @throws NoSuchTeamProjectRoleException if a team project role with the primary key could not be found
	 */
	@Override
	public TeamProjectRole findByPrimaryKey(TeamProjectRolePK teamProjectRolePK)
		throws NoSuchTeamProjectRoleException {

		return findByPrimaryKey((Serializable)teamProjectRolePK);
	}

	/**
	 * Returns the team project role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamProjectRolePK the primary key of the team project role
	 * @return the team project role, or <code>null</code> if a team project role with the primary key could not be found
	 */
	@Override
	public TeamProjectRole fetchByPrimaryKey(
		TeamProjectRolePK teamProjectRolePK) {

		return fetchByPrimaryKey((Serializable)teamProjectRolePK);
	}

	/**
	 * Returns all the team project roles.
	 *
	 * @return the team project roles
	 */
	@Override
	public List<TeamProjectRole> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TeamProjectRole> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TeamProjectRole> findAll(
		int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TeamProjectRole> findAll(
		int start, int end,
		OrderByComparator<TeamProjectRole> orderByComparator,
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

		List<TeamProjectRole> list = null;

		if (useFinderCache) {
			list = (List<TeamProjectRole>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TEAMPROJECTROLE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TEAMPROJECTROLE;

				if (pagination) {
					sql = sql.concat(TeamProjectRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TeamProjectRole>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TeamProjectRole>)QueryUtil.list(
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
	 * Removes all the team project roles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TeamProjectRole teamProjectRole : findAll()) {
			remove(teamProjectRole);
		}
	}

	/**
	 * Returns the number of team project roles.
	 *
	 * @return the number of team project roles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TEAMPROJECTROLE);

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
		return "teamProjectRolePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TEAMPROJECTROLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TeamProjectRoleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the team project role persistence.
	 */
	@Activate
	public void activate() {
		TeamProjectRoleModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TeamProjectRoleModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByTeamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTeamId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTeamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTeamId",
			new String[] {Long.class.getName()},
			TeamProjectRoleModelImpl.TEAMID_COLUMN_BITMASK);

		_finderPathCountByTeamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTeamId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByProjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByProjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectId",
			new String[] {Long.class.getName()},
			TeamProjectRoleModelImpl.PROJECTID_COLUMN_BITMASK);

		_finderPathCountByProjectId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByTeamRoleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTeamRoleId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTeamRoleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTeamRoleId",
			new String[] {Long.class.getName()},
			TeamProjectRoleModelImpl.TEAMROLEID_COLUMN_BITMASK);

		_finderPathCountByTeamRoleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTeamRoleId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByT_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByT_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_P",
			new String[] {Long.class.getName(), Long.class.getName()},
			TeamProjectRoleModelImpl.TEAMID_COLUMN_BITMASK |
			TeamProjectRoleModelImpl.PROJECTID_COLUMN_BITMASK);

		_finderPathCountByT_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_P",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TeamProjectRoleImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.osb.koroneiki.taproot.model.TeamProjectRole"),
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

	private static final String _SQL_SELECT_TEAMPROJECTROLE =
		"SELECT teamProjectRole FROM TeamProjectRole teamProjectRole";

	private static final String _SQL_SELECT_TEAMPROJECTROLE_WHERE =
		"SELECT teamProjectRole FROM TeamProjectRole teamProjectRole WHERE ";

	private static final String _SQL_COUNT_TEAMPROJECTROLE =
		"SELECT COUNT(teamProjectRole) FROM TeamProjectRole teamProjectRole";

	private static final String _SQL_COUNT_TEAMPROJECTROLE_WHERE =
		"SELECT COUNT(teamProjectRole) FROM TeamProjectRole teamProjectRole WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "teamProjectRole.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TeamProjectRole exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TeamProjectRole exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TeamProjectRolePersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"teamId", "projectId", "teamRoleId"});

}