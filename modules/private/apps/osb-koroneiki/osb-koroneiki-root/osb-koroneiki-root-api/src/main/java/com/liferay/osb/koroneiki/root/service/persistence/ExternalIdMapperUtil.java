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

package com.liferay.osb.koroneiki.root.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.koroneiki.root.model.ExternalIdMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the external ID mapper service. This utility wraps <code>com.liferay.osb.koroneiki.root.service.persistence.impl.ExternalIdMapperPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExternalIdMapperPersistence
 * @generated
 */
@ProviderType
public class ExternalIdMapperUtil {

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
	public static void clearCache(ExternalIdMapper externalIdMapper) {
		getPersistence().clearCache(externalIdMapper);
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
	public static Map<Serializable, ExternalIdMapper> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ExternalIdMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExternalIdMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExternalIdMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExternalIdMapper> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExternalIdMapper update(ExternalIdMapper externalIdMapper) {
		return getPersistence().update(externalIdMapper);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExternalIdMapper update(
		ExternalIdMapper externalIdMapper, ServiceContext serviceContext) {

		return getPersistence().update(externalIdMapper, serviceContext);
	}

	/**
	 * Caches the external ID mapper in the entity cache if it is enabled.
	 *
	 * @param externalIdMapper the external ID mapper
	 */
	public static void cacheResult(ExternalIdMapper externalIdMapper) {
		getPersistence().cacheResult(externalIdMapper);
	}

	/**
	 * Caches the external ID mappers in the entity cache if it is enabled.
	 *
	 * @param externalIdMappers the external ID mappers
	 */
	public static void cacheResult(List<ExternalIdMapper> externalIdMappers) {
		getPersistence().cacheResult(externalIdMappers);
	}

	/**
	 * Creates a new external ID mapper with the primary key. Does not add the external ID mapper to the database.
	 *
	 * @param externalIdMapperId the primary key for the new external ID mapper
	 * @return the new external ID mapper
	 */
	public static ExternalIdMapper create(long externalIdMapperId) {
		return getPersistence().create(externalIdMapperId);
	}

	/**
	 * Removes the external ID mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param externalIdMapperId the primary key of the external ID mapper
	 * @return the external ID mapper that was removed
	 * @throws NoSuchExternalIdMapperException if a external ID mapper with the primary key could not be found
	 */
	public static ExternalIdMapper remove(long externalIdMapperId)
		throws com.liferay.osb.koroneiki.root.exception.
			NoSuchExternalIdMapperException {

		return getPersistence().remove(externalIdMapperId);
	}

	public static ExternalIdMapper updateImpl(
		ExternalIdMapper externalIdMapper) {

		return getPersistence().updateImpl(externalIdMapper);
	}

	/**
	 * Returns the external ID mapper with the primary key or throws a <code>NoSuchExternalIdMapperException</code> if it could not be found.
	 *
	 * @param externalIdMapperId the primary key of the external ID mapper
	 * @return the external ID mapper
	 * @throws NoSuchExternalIdMapperException if a external ID mapper with the primary key could not be found
	 */
	public static ExternalIdMapper findByPrimaryKey(long externalIdMapperId)
		throws com.liferay.osb.koroneiki.root.exception.
			NoSuchExternalIdMapperException {

		return getPersistence().findByPrimaryKey(externalIdMapperId);
	}

	/**
	 * Returns the external ID mapper with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param externalIdMapperId the primary key of the external ID mapper
	 * @return the external ID mapper, or <code>null</code> if a external ID mapper with the primary key could not be found
	 */
	public static ExternalIdMapper fetchByPrimaryKey(long externalIdMapperId) {
		return getPersistence().fetchByPrimaryKey(externalIdMapperId);
	}

	/**
	 * Returns all the external ID mappers.
	 *
	 * @return the external ID mappers
	 */
	public static List<ExternalIdMapper> findAll() {
		return getPersistence().findAll();
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
	public static List<ExternalIdMapper> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ExternalIdMapper> findAll(
		int start, int end,
		OrderByComparator<ExternalIdMapper> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ExternalIdMapper> findAll(
		int start, int end,
		OrderByComparator<ExternalIdMapper> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the external ID mappers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of external ID mappers.
	 *
	 * @return the number of external ID mappers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExternalIdMapperPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ExternalIdMapperPersistence, ExternalIdMapperPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ExternalIdMapperPersistence.class);

		ServiceTracker<ExternalIdMapperPersistence, ExternalIdMapperPersistence>
			serviceTracker =
				new ServiceTracker
					<ExternalIdMapperPersistence, ExternalIdMapperPersistence>(
						bundle.getBundleContext(),
						ExternalIdMapperPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}