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

import com.liferay.osb.koroneiki.taproot.exception.NoSuchContactTeamRoleException;
import com.liferay.osb.koroneiki.taproot.model.ContactTeamRole;
import com.liferay.osb.koroneiki.taproot.model.impl.ContactTeamRoleImpl;
import com.liferay.osb.koroneiki.taproot.model.impl.ContactTeamRoleModelImpl;
import com.liferay.osb.koroneiki.taproot.service.persistence.ContactTeamRolePK;
import com.liferay.osb.koroneiki.taproot.service.persistence.ContactTeamRolePersistence;
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
 * The persistence implementation for the contact team role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ContactTeamRolePersistence.class)
@ProviderType
public class ContactTeamRolePersistenceImpl
	extends BasePersistenceImpl<ContactTeamRole>
	implements ContactTeamRolePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ContactTeamRoleUtil</code> to access the contact team role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ContactTeamRoleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ContactTeamRolePersistenceImpl() {
		setModelClass(ContactTeamRole.class);

		setModelImplClass(ContactTeamRoleImpl.class);
		setModelPKClass(ContactTeamRolePK.class);
	}

	/**
	 * Caches the contact team role in the entity cache if it is enabled.
	 *
	 * @param contactTeamRole the contact team role
	 */
	@Override
	public void cacheResult(ContactTeamRole contactTeamRole) {
		entityCache.putResult(
			entityCacheEnabled, ContactTeamRoleImpl.class,
			contactTeamRole.getPrimaryKey(), contactTeamRole);

		contactTeamRole.resetOriginalValues();
	}

	/**
	 * Caches the contact team roles in the entity cache if it is enabled.
	 *
	 * @param contactTeamRoles the contact team roles
	 */
	@Override
	public void cacheResult(List<ContactTeamRole> contactTeamRoles) {
		for (ContactTeamRole contactTeamRole : contactTeamRoles) {
			if (entityCache.getResult(
					entityCacheEnabled, ContactTeamRoleImpl.class,
					contactTeamRole.getPrimaryKey()) == null) {

				cacheResult(contactTeamRole);
			}
			else {
				contactTeamRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact team roles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ContactTeamRoleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact team role.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactTeamRole contactTeamRole) {
		entityCache.removeResult(
			entityCacheEnabled, ContactTeamRoleImpl.class,
			contactTeamRole.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContactTeamRole> contactTeamRoles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactTeamRole contactTeamRole : contactTeamRoles) {
			entityCache.removeResult(
				entityCacheEnabled, ContactTeamRoleImpl.class,
				contactTeamRole.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contact team role with the primary key. Does not add the contact team role to the database.
	 *
	 * @param contactTeamRolePK the primary key for the new contact team role
	 * @return the new contact team role
	 */
	@Override
	public ContactTeamRole create(ContactTeamRolePK contactTeamRolePK) {
		ContactTeamRole contactTeamRole = new ContactTeamRoleImpl();

		contactTeamRole.setNew(true);
		contactTeamRole.setPrimaryKey(contactTeamRolePK);

		return contactTeamRole;
	}

	/**
	 * Removes the contact team role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactTeamRolePK the primary key of the contact team role
	 * @return the contact team role that was removed
	 * @throws NoSuchContactTeamRoleException if a contact team role with the primary key could not be found
	 */
	@Override
	public ContactTeamRole remove(ContactTeamRolePK contactTeamRolePK)
		throws NoSuchContactTeamRoleException {

		return remove((Serializable)contactTeamRolePK);
	}

	/**
	 * Removes the contact team role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact team role
	 * @return the contact team role that was removed
	 * @throws NoSuchContactTeamRoleException if a contact team role with the primary key could not be found
	 */
	@Override
	public ContactTeamRole remove(Serializable primaryKey)
		throws NoSuchContactTeamRoleException {

		Session session = null;

		try {
			session = openSession();

			ContactTeamRole contactTeamRole = (ContactTeamRole)session.get(
				ContactTeamRoleImpl.class, primaryKey);

			if (contactTeamRole == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactTeamRoleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(contactTeamRole);
		}
		catch (NoSuchContactTeamRoleException nsee) {
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
	protected ContactTeamRole removeImpl(ContactTeamRole contactTeamRole) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactTeamRole)) {
				contactTeamRole = (ContactTeamRole)session.get(
					ContactTeamRoleImpl.class,
					contactTeamRole.getPrimaryKeyObj());
			}

			if (contactTeamRole != null) {
				session.delete(contactTeamRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contactTeamRole != null) {
			clearCache(contactTeamRole);
		}

		return contactTeamRole;
	}

	@Override
	public ContactTeamRole updateImpl(ContactTeamRole contactTeamRole) {
		boolean isNew = contactTeamRole.isNew();

		Session session = null;

		try {
			session = openSession();

			if (contactTeamRole.isNew()) {
				session.save(contactTeamRole);

				contactTeamRole.setNew(false);
			}
			else {
				contactTeamRole = (ContactTeamRole)session.merge(
					contactTeamRole);
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
			entityCacheEnabled, ContactTeamRoleImpl.class,
			contactTeamRole.getPrimaryKey(), contactTeamRole, false);

		contactTeamRole.resetOriginalValues();

		return contactTeamRole;
	}

	/**
	 * Returns the contact team role with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact team role
	 * @return the contact team role
	 * @throws NoSuchContactTeamRoleException if a contact team role with the primary key could not be found
	 */
	@Override
	public ContactTeamRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactTeamRoleException {

		ContactTeamRole contactTeamRole = fetchByPrimaryKey(primaryKey);

		if (contactTeamRole == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactTeamRoleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return contactTeamRole;
	}

	/**
	 * Returns the contact team role with the primary key or throws a <code>NoSuchContactTeamRoleException</code> if it could not be found.
	 *
	 * @param contactTeamRolePK the primary key of the contact team role
	 * @return the contact team role
	 * @throws NoSuchContactTeamRoleException if a contact team role with the primary key could not be found
	 */
	@Override
	public ContactTeamRole findByPrimaryKey(ContactTeamRolePK contactTeamRolePK)
		throws NoSuchContactTeamRoleException {

		return findByPrimaryKey((Serializable)contactTeamRolePK);
	}

	/**
	 * Returns the contact team role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactTeamRolePK the primary key of the contact team role
	 * @return the contact team role, or <code>null</code> if a contact team role with the primary key could not be found
	 */
	@Override
	public ContactTeamRole fetchByPrimaryKey(
		ContactTeamRolePK contactTeamRolePK) {

		return fetchByPrimaryKey((Serializable)contactTeamRolePK);
	}

	/**
	 * Returns all the contact team roles.
	 *
	 * @return the contact team roles
	 */
	@Override
	public List<ContactTeamRole> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ContactTeamRole> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ContactTeamRole> findAll(
		int start, int end,
		OrderByComparator<ContactTeamRole> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ContactTeamRole> findAll(
		int start, int end,
		OrderByComparator<ContactTeamRole> orderByComparator,
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

		List<ContactTeamRole> list = null;

		if (retrieveFromCache) {
			list = (List<ContactTeamRole>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CONTACTTEAMROLE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTTEAMROLE;

				if (pagination) {
					sql = sql.concat(ContactTeamRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContactTeamRole>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ContactTeamRole>)QueryUtil.list(
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
	 * Removes all the contact team roles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ContactTeamRole contactTeamRole : findAll()) {
			remove(contactTeamRole);
		}
	}

	/**
	 * Returns the number of contact team roles.
	 *
	 * @return the number of contact team roles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACTTEAMROLE);

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
		return "contactTeamRolePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONTACTTEAMROLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ContactTeamRoleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the contact team role persistence.
	 */
	@Activate
	public void activate() {
		ContactTeamRoleModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ContactTeamRoleModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ContactTeamRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ContactTeamRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ContactTeamRoleImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.osb.koroneiki.taproot.model.ContactTeamRole"),
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

	private static final String _SQL_SELECT_CONTACTTEAMROLE =
		"SELECT contactTeamRole FROM ContactTeamRole contactTeamRole";

	private static final String _SQL_COUNT_CONTACTTEAMROLE =
		"SELECT COUNT(contactTeamRole) FROM ContactTeamRole contactTeamRole";

	private static final String _ORDER_BY_ENTITY_ALIAS = "contactTeamRole.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ContactTeamRole exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ContactTeamRolePersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"contactId", "teamId", "contactRoleId"});

}