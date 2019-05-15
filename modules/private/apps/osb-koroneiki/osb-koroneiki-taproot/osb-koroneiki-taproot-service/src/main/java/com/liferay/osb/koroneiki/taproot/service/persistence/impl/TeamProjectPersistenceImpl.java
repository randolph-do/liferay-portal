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

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.koroneiki.taproot.exception.NoSuchTeamProjectException;
import com.liferay.osb.koroneiki.taproot.model.TeamProject;
import com.liferay.osb.koroneiki.taproot.model.impl.TeamProjectImpl;
import com.liferay.osb.koroneiki.taproot.model.impl.TeamProjectModelImpl;
import com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectPK;
import com.liferay.osb.koroneiki.taproot.service.persistence.TeamProjectPersistence;
import com.liferay.osb.koroneiki.taproot.service.persistence.impl.constants.KoroneikiPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the team project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TeamProjectPersistence.class)
@ProviderType
public class TeamProjectPersistenceImpl
	extends BasePersistenceImpl<TeamProject> implements TeamProjectPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TeamProjectUtil</code> to access the team project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TeamProjectImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TeamProjectPersistenceImpl() {
		setModelClass(TeamProject.class);

		setModelImplClass(TeamProjectImpl.class);
		setModelPKClass(TeamProjectPK.class);
	}

	/**
	 * Caches the team project in the entity cache if it is enabled.
	 *
	 * @param teamProject the team project
	 */
	@Override
	public void cacheResult(TeamProject teamProject) {
		entityCache.putResult(
			entityCacheEnabled, TeamProjectImpl.class,
			teamProject.getPrimaryKey(), teamProject);

		teamProject.resetOriginalValues();
	}

	/**
	 * Caches the team projects in the entity cache if it is enabled.
	 *
	 * @param teamProjects the team projects
	 */
	@Override
	public void cacheResult(List<TeamProject> teamProjects) {
		for (TeamProject teamProject : teamProjects) {
			if (entityCache.getResult(
					entityCacheEnabled, TeamProjectImpl.class,
					teamProject.getPrimaryKey()) == null) {

				cacheResult(teamProject);
			}
			else {
				teamProject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all team projects.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TeamProjectImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the team project.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TeamProject teamProject) {
		entityCache.removeResult(
			entityCacheEnabled, TeamProjectImpl.class,
			teamProject.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TeamProject> teamProjects) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TeamProject teamProject : teamProjects) {
			entityCache.removeResult(
				entityCacheEnabled, TeamProjectImpl.class,
				teamProject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new team project with the primary key. Does not add the team project to the database.
	 *
	 * @param teamProjectPK the primary key for the new team project
	 * @return the new team project
	 */
	@Override
	public TeamProject create(TeamProjectPK teamProjectPK) {
		TeamProject teamProject = new TeamProjectImpl();

		teamProject.setNew(true);
		teamProject.setPrimaryKey(teamProjectPK);

		return teamProject;
	}

	/**
	 * Removes the team project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project that was removed
	 * @throws NoSuchTeamProjectException if a team project with the primary key could not be found
	 */
	@Override
	public TeamProject remove(TeamProjectPK teamProjectPK)
		throws NoSuchTeamProjectException {

		return remove((Serializable)teamProjectPK);
	}

	/**
	 * Removes the team project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the team project
	 * @return the team project that was removed
	 * @throws NoSuchTeamProjectException if a team project with the primary key could not be found
	 */
	@Override
	public TeamProject remove(Serializable primaryKey)
		throws NoSuchTeamProjectException {

		Session session = null;

		try {
			session = openSession();

			TeamProject teamProject = (TeamProject)session.get(
				TeamProjectImpl.class, primaryKey);

			if (teamProject == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTeamProjectException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(teamProject);
		}
		catch (NoSuchTeamProjectException nsee) {
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
	protected TeamProject removeImpl(TeamProject teamProject) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(teamProject)) {
				teamProject = (TeamProject)session.get(
					TeamProjectImpl.class, teamProject.getPrimaryKeyObj());
			}

			if (teamProject != null) {
				session.delete(teamProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (teamProject != null) {
			clearCache(teamProject);
		}

		return teamProject;
	}

	@Override
	public TeamProject updateImpl(TeamProject teamProject) {
		boolean isNew = teamProject.isNew();

		Session session = null;

		try {
			session = openSession();

			if (teamProject.isNew()) {
				session.save(teamProject);

				teamProject.setNew(false);
			}
			else {
				teamProject = (TeamProject)session.merge(teamProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, TeamProjectImpl.class,
			teamProject.getPrimaryKey(), teamProject, false);

		teamProject.resetOriginalValues();

		return teamProject;
	}

	/**
	 * Returns the team project with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the team project
	 * @return the team project
	 * @throws NoSuchTeamProjectException if a team project with the primary key could not be found
	 */
	@Override
	public TeamProject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTeamProjectException {

		TeamProject teamProject = fetchByPrimaryKey(primaryKey);

		if (teamProject == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTeamProjectException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return teamProject;
	}

	/**
	 * Returns the team project with the primary key or throws a <code>NoSuchTeamProjectException</code> if it could not be found.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project
	 * @throws NoSuchTeamProjectException if a team project with the primary key could not be found
	 */
	@Override
	public TeamProject findByPrimaryKey(TeamProjectPK teamProjectPK)
		throws NoSuchTeamProjectException {

		return findByPrimaryKey((Serializable)teamProjectPK);
	}

	/**
	 * Returns the team project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamProjectPK the primary key of the team project
	 * @return the team project, or <code>null</code> if a team project with the primary key could not be found
	 */
	@Override
	public TeamProject fetchByPrimaryKey(TeamProjectPK teamProjectPK) {
		return fetchByPrimaryKey((Serializable)teamProjectPK);
	}

	/**
	 * Returns all the team projects.
	 *
	 * @return the team projects
	 */
	@Override
	public List<TeamProject> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<TeamProject> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<TeamProject> findAll(
		int start, int end, OrderByComparator<TeamProject> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<TeamProject> findAll(
		int start, int end, OrderByComparator<TeamProject> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<TeamProject> list = null;

		if (retrieveFromCache) {
			list = (List<TeamProject>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TEAMPROJECT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TEAMPROJECT;

				if (pagination) {
					sql = sql.concat(TeamProjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TeamProject>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TeamProject>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the team projects from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TeamProject teamProject : findAll()) {
			remove(teamProject);
		}
	}

	/**
	 * Returns the number of team projects.
	 *
	 * @return the number of team projects
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TEAMPROJECT);

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
		return "teamProjectPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TEAMPROJECT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TeamProjectModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the team project persistence.
	 */
	@Activate
	public void activate() {
		TeamProjectModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TeamProjectModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TeamProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TeamProjectImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.osb.koroneiki.taproot.model.TeamProject"),
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

	private static final String _SQL_SELECT_TEAMPROJECT =
		"SELECT teamProject FROM TeamProject teamProject";

	private static final String _SQL_COUNT_TEAMPROJECT =
		"SELECT COUNT(teamProject) FROM TeamProject teamProject";

	private static final String _ORDER_BY_ENTITY_ALIAS = "teamProject.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TeamProject exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TeamProjectPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"teamId", "projectId"});

}