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

package com.liferay.osb.koroneiki.root.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.koroneiki.root.exception.NoSuchExternalIdMapperException;
import com.liferay.osb.koroneiki.root.model.ExternalIdMapper;
import com.liferay.osb.koroneiki.root.model.impl.ExternalIdMapperImpl;
import com.liferay.osb.koroneiki.root.model.impl.ExternalIdMapperModelImpl;
import com.liferay.osb.koroneiki.root.service.persistence.ExternalIdMapperPersistence;
import com.liferay.osb.koroneiki.root.service.persistence.impl.constants.KoroneikiPersistenceConstants;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the external ID mapper service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ExternalIdMapperPersistence.class)
@ProviderType
public class ExternalIdMapperPersistenceImpl
	extends BasePersistenceImpl<ExternalIdMapper>
	implements ExternalIdMapperPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ExternalIdMapperUtil</code> to access the external ID mapper persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ExternalIdMapperImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ExternalIdMapperPersistenceImpl() {
		setModelClass(ExternalIdMapper.class);

		setModelImplClass(ExternalIdMapperImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the external ID mapper in the entity cache if it is enabled.
	 *
	 * @param externalIdMapper the external ID mapper
	 */
	@Override
	public void cacheResult(ExternalIdMapper externalIdMapper) {
		entityCache.putResult(
			entityCacheEnabled, ExternalIdMapperImpl.class,
			externalIdMapper.getPrimaryKey(), externalIdMapper);

		externalIdMapper.resetOriginalValues();
	}

	/**
	 * Caches the external ID mappers in the entity cache if it is enabled.
	 *
	 * @param externalIdMappers the external ID mappers
	 */
	@Override
	public void cacheResult(List<ExternalIdMapper> externalIdMappers) {
		for (ExternalIdMapper externalIdMapper : externalIdMappers) {
			if (entityCache.getResult(
					entityCacheEnabled, ExternalIdMapperImpl.class,
					externalIdMapper.getPrimaryKey()) == null) {

				cacheResult(externalIdMapper);
			}
			else {
				externalIdMapper.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all external ID mappers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExternalIdMapperImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the external ID mapper.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExternalIdMapper externalIdMapper) {
		entityCache.removeResult(
			entityCacheEnabled, ExternalIdMapperImpl.class,
			externalIdMapper.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ExternalIdMapper> externalIdMappers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExternalIdMapper externalIdMapper : externalIdMappers) {
			entityCache.removeResult(
				entityCacheEnabled, ExternalIdMapperImpl.class,
				externalIdMapper.getPrimaryKey());
		}
	}

	/**
	 * Creates a new external ID mapper with the primary key. Does not add the external ID mapper to the database.
	 *
	 * @param externalIdMapperId the primary key for the new external ID mapper
	 * @return the new external ID mapper
	 */
	@Override
	public ExternalIdMapper create(long externalIdMapperId) {
		ExternalIdMapper externalIdMapper = new ExternalIdMapperImpl();

		externalIdMapper.setNew(true);
		externalIdMapper.setPrimaryKey(externalIdMapperId);

		externalIdMapper.setCompanyId(companyProvider.getCompanyId());

		return externalIdMapper;
	}

	/**
	 * Removes the external ID mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param externalIdMapperId the primary key of the external ID mapper
	 * @return the external ID mapper that was removed
	 * @throws NoSuchExternalIdMapperException if a external ID mapper with the primary key could not be found
	 */
	@Override
	public ExternalIdMapper remove(long externalIdMapperId)
		throws NoSuchExternalIdMapperException {

		return remove((Serializable)externalIdMapperId);
	}

	/**
	 * Removes the external ID mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the external ID mapper
	 * @return the external ID mapper that was removed
	 * @throws NoSuchExternalIdMapperException if a external ID mapper with the primary key could not be found
	 */
	@Override
	public ExternalIdMapper remove(Serializable primaryKey)
		throws NoSuchExternalIdMapperException {

		Session session = null;

		try {
			session = openSession();

			ExternalIdMapper externalIdMapper = (ExternalIdMapper)session.get(
				ExternalIdMapperImpl.class, primaryKey);

			if (externalIdMapper == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExternalIdMapperException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(externalIdMapper);
		}
		catch (NoSuchExternalIdMapperException nsee) {
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
	protected ExternalIdMapper removeImpl(ExternalIdMapper externalIdMapper) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(externalIdMapper)) {
				externalIdMapper = (ExternalIdMapper)session.get(
					ExternalIdMapperImpl.class,
					externalIdMapper.getPrimaryKeyObj());
			}

			if (externalIdMapper != null) {
				session.delete(externalIdMapper);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (externalIdMapper != null) {
			clearCache(externalIdMapper);
		}

		return externalIdMapper;
	}

	@Override
	public ExternalIdMapper updateImpl(ExternalIdMapper externalIdMapper) {
		boolean isNew = externalIdMapper.isNew();

		if (!(externalIdMapper instanceof ExternalIdMapperModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(externalIdMapper.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					externalIdMapper);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in externalIdMapper proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ExternalIdMapper implementation " +
					externalIdMapper.getClass());
		}

		ExternalIdMapperModelImpl externalIdMapperModelImpl =
			(ExternalIdMapperModelImpl)externalIdMapper;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (externalIdMapper.getCreateDate() == null)) {
			if (serviceContext == null) {
				externalIdMapper.setCreateDate(now);
			}
			else {
				externalIdMapper.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!externalIdMapperModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				externalIdMapper.setModifiedDate(now);
			}
			else {
				externalIdMapper.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (externalIdMapper.isNew()) {
				session.save(externalIdMapper);

				externalIdMapper.setNew(false);
			}
			else {
				externalIdMapper = (ExternalIdMapper)session.merge(
					externalIdMapper);
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
			entityCacheEnabled, ExternalIdMapperImpl.class,
			externalIdMapper.getPrimaryKey(), externalIdMapper, false);

		externalIdMapper.resetOriginalValues();

		return externalIdMapper;
	}

	/**
	 * Returns the external ID mapper with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the external ID mapper
	 * @return the external ID mapper
	 * @throws NoSuchExternalIdMapperException if a external ID mapper with the primary key could not be found
	 */
	@Override
	public ExternalIdMapper findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExternalIdMapperException {

		ExternalIdMapper externalIdMapper = fetchByPrimaryKey(primaryKey);

		if (externalIdMapper == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExternalIdMapperException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return externalIdMapper;
	}

	/**
	 * Returns the external ID mapper with the primary key or throws a <code>NoSuchExternalIdMapperException</code> if it could not be found.
	 *
	 * @param externalIdMapperId the primary key of the external ID mapper
	 * @return the external ID mapper
	 * @throws NoSuchExternalIdMapperException if a external ID mapper with the primary key could not be found
	 */
	@Override
	public ExternalIdMapper findByPrimaryKey(long externalIdMapperId)
		throws NoSuchExternalIdMapperException {

		return findByPrimaryKey((Serializable)externalIdMapperId);
	}

	/**
	 * Returns the external ID mapper with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param externalIdMapperId the primary key of the external ID mapper
	 * @return the external ID mapper, or <code>null</code> if a external ID mapper with the primary key could not be found
	 */
	@Override
	public ExternalIdMapper fetchByPrimaryKey(long externalIdMapperId) {
		return fetchByPrimaryKey((Serializable)externalIdMapperId);
	}

	/**
	 * Returns all the external ID mappers.
	 *
	 * @return the external ID mappers
	 */
	@Override
	public List<ExternalIdMapper> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external ID mappers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExternalIdMapperModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of external ID mappers
	 * @param end the upper bound of the range of external ID mappers (not inclusive)
	 * @return the range of external ID mappers
	 */
	@Override
	public List<ExternalIdMapper> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the external ID mappers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExternalIdMapperModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of external ID mappers
	 * @param end the upper bound of the range of external ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of external ID mappers
	 */
	@Override
	public List<ExternalIdMapper> findAll(
		int start, int end,
		OrderByComparator<ExternalIdMapper> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the external ID mappers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExternalIdMapperModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of external ID mappers
	 * @param end the upper bound of the range of external ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of external ID mappers
	 */
	@Override
	public List<ExternalIdMapper> findAll(
		int start, int end,
		OrderByComparator<ExternalIdMapper> orderByComparator,
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

		List<ExternalIdMapper> list = null;

		if (retrieveFromCache) {
			list = (List<ExternalIdMapper>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXTERNALIDMAPPER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXTERNALIDMAPPER;

				if (pagination) {
					sql = sql.concat(ExternalIdMapperModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExternalIdMapper>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExternalIdMapper>)QueryUtil.list(
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
	 * Removes all the external ID mappers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExternalIdMapper externalIdMapper : findAll()) {
			remove(externalIdMapper);
		}
	}

	/**
	 * Returns the number of external ID mappers.
	 *
	 * @return the number of external ID mappers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXTERNALIDMAPPER);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "externalIdMapperId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EXTERNALIDMAPPER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExternalIdMapperModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the external ID mapper persistence.
	 */
	@Activate
	public void activate() {
		ExternalIdMapperModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ExternalIdMapperModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExternalIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExternalIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ExternalIdMapperImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.osb.koroneiki.root.model.ExternalIdMapper"),
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

	@Reference(service = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EXTERNALIDMAPPER =
		"SELECT externalIdMapper FROM ExternalIdMapper externalIdMapper";

	private static final String _SQL_COUNT_EXTERNALIDMAPPER =
		"SELECT COUNT(externalIdMapper) FROM ExternalIdMapper externalIdMapper";

	private static final String _ORDER_BY_ENTITY_ALIAS = "externalIdMapper.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ExternalIdMapper exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ExternalIdMapperPersistenceImpl.class);

}