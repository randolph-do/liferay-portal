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

package com.liferay.osb.koroneiki.trunk.service.persistence;

import com.liferay.osb.koroneiki.trunk.model.ProductConsumption;
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
 * The persistence utility for the product consumption service. This utility wraps <code>com.liferay.osb.koroneiki.trunk.service.persistence.impl.ProductConsumptionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductConsumptionPersistence
 * @generated
 */
@ProviderType
public class ProductConsumptionUtil {

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
	public static void clearCache(ProductConsumption productConsumption) {
		getPersistence().clearCache(productConsumption);
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
	public static Map<Serializable, ProductConsumption> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductConsumption> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductConsumption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductConsumption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductConsumption> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductConsumption update(
		ProductConsumption productConsumption) {

		return getPersistence().update(productConsumption);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductConsumption update(
		ProductConsumption productConsumption, ServiceContext serviceContext) {

		return getPersistence().update(productConsumption, serviceContext);
	}

	/**
	 * Returns all the product consumptions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product consumptions
	 */
	public static List<ProductConsumption> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the product consumptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @return the range of matching product consumptions
	 */
	public static List<ProductConsumption> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product consumptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product consumptions
	 */
	public static List<ProductConsumption> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductConsumption> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product consumptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching product consumptions
	 */
	public static List<ProductConsumption> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductConsumption> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first product consumption in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product consumption
	 * @throws NoSuchProductConsumptionException if a matching product consumption could not be found
	 */
	public static ProductConsumption findByUuid_First(
			String uuid,
			OrderByComparator<ProductConsumption> orderByComparator)
		throws com.liferay.osb.koroneiki.trunk.exception.
			NoSuchProductConsumptionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product consumption in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product consumption, or <code>null</code> if a matching product consumption could not be found
	 */
	public static ProductConsumption fetchByUuid_First(
		String uuid, OrderByComparator<ProductConsumption> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product consumption in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product consumption
	 * @throws NoSuchProductConsumptionException if a matching product consumption could not be found
	 */
	public static ProductConsumption findByUuid_Last(
			String uuid,
			OrderByComparator<ProductConsumption> orderByComparator)
		throws com.liferay.osb.koroneiki.trunk.exception.
			NoSuchProductConsumptionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product consumption in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product consumption, or <code>null</code> if a matching product consumption could not be found
	 */
	public static ProductConsumption fetchByUuid_Last(
		String uuid, OrderByComparator<ProductConsumption> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product consumptions before and after the current product consumption in the ordered set where uuid = &#63;.
	 *
	 * @param productConsumptionId the primary key of the current product consumption
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product consumption
	 * @throws NoSuchProductConsumptionException if a product consumption with the primary key could not be found
	 */
	public static ProductConsumption[] findByUuid_PrevAndNext(
			long productConsumptionId, String uuid,
			OrderByComparator<ProductConsumption> orderByComparator)
		throws com.liferay.osb.koroneiki.trunk.exception.
			NoSuchProductConsumptionException {

		return getPersistence().findByUuid_PrevAndNext(
			productConsumptionId, uuid, orderByComparator);
	}

	/**
	 * Returns all the product consumptions that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product consumptions that the user has permission to view
	 */
	public static List<ProductConsumption> filterFindByUuid(String uuid) {
		return getPersistence().filterFindByUuid(uuid);
	}

	/**
	 * Returns a range of all the product consumptions that the user has permission to view where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @return the range of matching product consumptions that the user has permission to view
	 */
	public static List<ProductConsumption> filterFindByUuid(
		String uuid, int start, int end) {

		return getPersistence().filterFindByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product consumptions that the user has permissions to view where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product consumptions that the user has permission to view
	 */
	public static List<ProductConsumption> filterFindByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductConsumption> orderByComparator) {

		return getPersistence().filterFindByUuid(
			uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the product consumptions before and after the current product consumption in the ordered set of product consumptions that the user has permission to view where uuid = &#63;.
	 *
	 * @param productConsumptionId the primary key of the current product consumption
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product consumption
	 * @throws NoSuchProductConsumptionException if a product consumption with the primary key could not be found
	 */
	public static ProductConsumption[] filterFindByUuid_PrevAndNext(
			long productConsumptionId, String uuid,
			OrderByComparator<ProductConsumption> orderByComparator)
		throws com.liferay.osb.koroneiki.trunk.exception.
			NoSuchProductConsumptionException {

		return getPersistence().filterFindByUuid_PrevAndNext(
			productConsumptionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the product consumptions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product consumptions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product consumptions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the number of product consumptions that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product consumptions that the user has permission to view
	 */
	public static int filterCountByUuid(String uuid) {
		return getPersistence().filterCountByUuid(uuid);
	}

	/**
	 * Returns all the product consumptions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product consumptions
	 */
	public static List<ProductConsumption> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the product consumptions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @return the range of matching product consumptions
	 */
	public static List<ProductConsumption> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the product consumptions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product consumptions
	 */
	public static List<ProductConsumption> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductConsumption> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product consumptions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching product consumptions
	 */
	public static List<ProductConsumption> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductConsumption> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first product consumption in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product consumption
	 * @throws NoSuchProductConsumptionException if a matching product consumption could not be found
	 */
	public static ProductConsumption findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductConsumption> orderByComparator)
		throws com.liferay.osb.koroneiki.trunk.exception.
			NoSuchProductConsumptionException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first product consumption in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product consumption, or <code>null</code> if a matching product consumption could not be found
	 */
	public static ProductConsumption fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductConsumption> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product consumption in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product consumption
	 * @throws NoSuchProductConsumptionException if a matching product consumption could not be found
	 */
	public static ProductConsumption findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductConsumption> orderByComparator)
		throws com.liferay.osb.koroneiki.trunk.exception.
			NoSuchProductConsumptionException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product consumption in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product consumption, or <code>null</code> if a matching product consumption could not be found
	 */
	public static ProductConsumption fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductConsumption> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the product consumptions before and after the current product consumption in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productConsumptionId the primary key of the current product consumption
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product consumption
	 * @throws NoSuchProductConsumptionException if a product consumption with the primary key could not be found
	 */
	public static ProductConsumption[] findByUuid_C_PrevAndNext(
			long productConsumptionId, String uuid, long companyId,
			OrderByComparator<ProductConsumption> orderByComparator)
		throws com.liferay.osb.koroneiki.trunk.exception.
			NoSuchProductConsumptionException {

		return getPersistence().findByUuid_C_PrevAndNext(
			productConsumptionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Returns all the product consumptions that the user has permission to view where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product consumptions that the user has permission to view
	 */
	public static List<ProductConsumption> filterFindByUuid_C(
		String uuid, long companyId) {

		return getPersistence().filterFindByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the product consumptions that the user has permission to view where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @return the range of matching product consumptions that the user has permission to view
	 */
	public static List<ProductConsumption> filterFindByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().filterFindByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the product consumptions that the user has permissions to view where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product consumptions that the user has permission to view
	 */
	public static List<ProductConsumption> filterFindByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductConsumption> orderByComparator) {

		return getPersistence().filterFindByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the product consumptions before and after the current product consumption in the ordered set of product consumptions that the user has permission to view where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productConsumptionId the primary key of the current product consumption
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product consumption
	 * @throws NoSuchProductConsumptionException if a product consumption with the primary key could not be found
	 */
	public static ProductConsumption[] filterFindByUuid_C_PrevAndNext(
			long productConsumptionId, String uuid, long companyId,
			OrderByComparator<ProductConsumption> orderByComparator)
		throws com.liferay.osb.koroneiki.trunk.exception.
			NoSuchProductConsumptionException {

		return getPersistence().filterFindByUuid_C_PrevAndNext(
			productConsumptionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the product consumptions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of product consumptions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product consumptions
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of product consumptions that the user has permission to view where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product consumptions that the user has permission to view
	 */
	public static int filterCountByUuid_C(String uuid, long companyId) {
		return getPersistence().filterCountByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the product consumption in the entity cache if it is enabled.
	 *
	 * @param productConsumption the product consumption
	 */
	public static void cacheResult(ProductConsumption productConsumption) {
		getPersistence().cacheResult(productConsumption);
	}

	/**
	 * Caches the product consumptions in the entity cache if it is enabled.
	 *
	 * @param productConsumptions the product consumptions
	 */
	public static void cacheResult(
		List<ProductConsumption> productConsumptions) {

		getPersistence().cacheResult(productConsumptions);
	}

	/**
	 * Creates a new product consumption with the primary key. Does not add the product consumption to the database.
	 *
	 * @param productConsumptionId the primary key for the new product consumption
	 * @return the new product consumption
	 */
	public static ProductConsumption create(long productConsumptionId) {
		return getPersistence().create(productConsumptionId);
	}

	/**
	 * Removes the product consumption with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productConsumptionId the primary key of the product consumption
	 * @return the product consumption that was removed
	 * @throws NoSuchProductConsumptionException if a product consumption with the primary key could not be found
	 */
	public static ProductConsumption remove(long productConsumptionId)
		throws com.liferay.osb.koroneiki.trunk.exception.
			NoSuchProductConsumptionException {

		return getPersistence().remove(productConsumptionId);
	}

	public static ProductConsumption updateImpl(
		ProductConsumption productConsumption) {

		return getPersistence().updateImpl(productConsumption);
	}

	/**
	 * Returns the product consumption with the primary key or throws a <code>NoSuchProductConsumptionException</code> if it could not be found.
	 *
	 * @param productConsumptionId the primary key of the product consumption
	 * @return the product consumption
	 * @throws NoSuchProductConsumptionException if a product consumption with the primary key could not be found
	 */
	public static ProductConsumption findByPrimaryKey(long productConsumptionId)
		throws com.liferay.osb.koroneiki.trunk.exception.
			NoSuchProductConsumptionException {

		return getPersistence().findByPrimaryKey(productConsumptionId);
	}

	/**
	 * Returns the product consumption with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productConsumptionId the primary key of the product consumption
	 * @return the product consumption, or <code>null</code> if a product consumption with the primary key could not be found
	 */
	public static ProductConsumption fetchByPrimaryKey(
		long productConsumptionId) {

		return getPersistence().fetchByPrimaryKey(productConsumptionId);
	}

	/**
	 * Returns all the product consumptions.
	 *
	 * @return the product consumptions
	 */
	public static List<ProductConsumption> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product consumptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @return the range of product consumptions
	 */
	public static List<ProductConsumption> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product consumptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product consumptions
	 */
	public static List<ProductConsumption> findAll(
		int start, int end,
		OrderByComparator<ProductConsumption> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product consumptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductConsumptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of product consumptions
	 * @param end the upper bound of the range of product consumptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of product consumptions
	 */
	public static List<ProductConsumption> findAll(
		int start, int end,
		OrderByComparator<ProductConsumption> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the product consumptions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product consumptions.
	 *
	 * @return the number of product consumptions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductConsumptionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProductConsumptionPersistence, ProductConsumptionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProductConsumptionPersistence.class);

		ServiceTracker
			<ProductConsumptionPersistence, ProductConsumptionPersistence>
				serviceTracker =
					new ServiceTracker
						<ProductConsumptionPersistence,
						 ProductConsumptionPersistence>(
							 bundle.getBundleContext(),
							 ProductConsumptionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}