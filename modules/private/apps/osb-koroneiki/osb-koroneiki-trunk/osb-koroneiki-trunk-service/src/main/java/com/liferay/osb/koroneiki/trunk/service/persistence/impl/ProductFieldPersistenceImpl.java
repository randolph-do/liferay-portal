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

package com.liferay.osb.koroneiki.trunk.service.persistence.impl;

import com.liferay.osb.koroneiki.trunk.exception.NoSuchProductFieldException;
import com.liferay.osb.koroneiki.trunk.model.ProductField;
import com.liferay.osb.koroneiki.trunk.model.impl.ProductFieldImpl;
import com.liferay.osb.koroneiki.trunk.model.impl.ProductFieldModelImpl;
import com.liferay.osb.koroneiki.trunk.service.persistence.ProductFieldPersistence;
import com.liferay.osb.koroneiki.trunk.service.persistence.impl.constants.KoroneikiPersistenceConstants;
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
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the product field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductFieldPersistence.class)
@ProviderType
public class ProductFieldPersistenceImpl
	extends BasePersistenceImpl<ProductField>
	implements ProductFieldPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductFieldUtil</code> to access the product field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductFieldImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByProductPurchaseId;
	private FinderPath _finderPathWithoutPaginationFindByProductPurchaseId;
	private FinderPath _finderPathCountByProductPurchaseId;

	/**
	 * Returns all the product fields where productPurchaseId = &#63;.
	 *
	 * @param productPurchaseId the product purchase ID
	 * @return the matching product fields
	 */
	@Override
	public List<ProductField> findByProductPurchaseId(long productPurchaseId) {
		return findByProductPurchaseId(
			productPurchaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product fields where productPurchaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param productPurchaseId the product purchase ID
	 * @param start the lower bound of the range of product fields
	 * @param end the upper bound of the range of product fields (not inclusive)
	 * @return the range of matching product fields
	 */
	@Override
	public List<ProductField> findByProductPurchaseId(
		long productPurchaseId, int start, int end) {

		return findByProductPurchaseId(productPurchaseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product fields where productPurchaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param productPurchaseId the product purchase ID
	 * @param start the lower bound of the range of product fields
	 * @param end the upper bound of the range of product fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product fields
	 */
	@Override
	public List<ProductField> findByProductPurchaseId(
		long productPurchaseId, int start, int end,
		OrderByComparator<ProductField> orderByComparator) {

		return findByProductPurchaseId(
			productPurchaseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product fields where productPurchaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param productPurchaseId the product purchase ID
	 * @param start the lower bound of the range of product fields
	 * @param end the upper bound of the range of product fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching product fields
	 */
	@Override
	public List<ProductField> findByProductPurchaseId(
		long productPurchaseId, int start, int end,
		OrderByComparator<ProductField> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByProductPurchaseId;
			finderArgs = new Object[] {productPurchaseId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByProductPurchaseId;
			finderArgs = new Object[] {
				productPurchaseId, start, end, orderByComparator
			};
		}

		List<ProductField> list = null;

		if (retrieveFromCache) {
			list = (List<ProductField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductField productField : list) {
					if ((productPurchaseId !=
							productField.getProductPurchaseId())) {

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

			query.append(_SQL_SELECT_PRODUCTFIELD_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTPURCHASEID_PRODUCTPURCHASEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ProductFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productPurchaseId);

				if (!pagination) {
					list = (List<ProductField>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProductField>)QueryUtil.list(
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
	 * Returns the first product field in the ordered set where productPurchaseId = &#63;.
	 *
	 * @param productPurchaseId the product purchase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product field
	 * @throws NoSuchProductFieldException if a matching product field could not be found
	 */
	@Override
	public ProductField findByProductPurchaseId_First(
			long productPurchaseId,
			OrderByComparator<ProductField> orderByComparator)
		throws NoSuchProductFieldException {

		ProductField productField = fetchByProductPurchaseId_First(
			productPurchaseId, orderByComparator);

		if (productField != null) {
			return productField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productPurchaseId=");
		msg.append(productPurchaseId);

		msg.append("}");

		throw new NoSuchProductFieldException(msg.toString());
	}

	/**
	 * Returns the first product field in the ordered set where productPurchaseId = &#63;.
	 *
	 * @param productPurchaseId the product purchase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product field, or <code>null</code> if a matching product field could not be found
	 */
	@Override
	public ProductField fetchByProductPurchaseId_First(
		long productPurchaseId,
		OrderByComparator<ProductField> orderByComparator) {

		List<ProductField> list = findByProductPurchaseId(
			productPurchaseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product field in the ordered set where productPurchaseId = &#63;.
	 *
	 * @param productPurchaseId the product purchase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product field
	 * @throws NoSuchProductFieldException if a matching product field could not be found
	 */
	@Override
	public ProductField findByProductPurchaseId_Last(
			long productPurchaseId,
			OrderByComparator<ProductField> orderByComparator)
		throws NoSuchProductFieldException {

		ProductField productField = fetchByProductPurchaseId_Last(
			productPurchaseId, orderByComparator);

		if (productField != null) {
			return productField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productPurchaseId=");
		msg.append(productPurchaseId);

		msg.append("}");

		throw new NoSuchProductFieldException(msg.toString());
	}

	/**
	 * Returns the last product field in the ordered set where productPurchaseId = &#63;.
	 *
	 * @param productPurchaseId the product purchase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product field, or <code>null</code> if a matching product field could not be found
	 */
	@Override
	public ProductField fetchByProductPurchaseId_Last(
		long productPurchaseId,
		OrderByComparator<ProductField> orderByComparator) {

		int count = countByProductPurchaseId(productPurchaseId);

		if (count == 0) {
			return null;
		}

		List<ProductField> list = findByProductPurchaseId(
			productPurchaseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product fields before and after the current product field in the ordered set where productPurchaseId = &#63;.
	 *
	 * @param productFieldId the primary key of the current product field
	 * @param productPurchaseId the product purchase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product field
	 * @throws NoSuchProductFieldException if a product field with the primary key could not be found
	 */
	@Override
	public ProductField[] findByProductPurchaseId_PrevAndNext(
			long productFieldId, long productPurchaseId,
			OrderByComparator<ProductField> orderByComparator)
		throws NoSuchProductFieldException {

		ProductField productField = findByPrimaryKey(productFieldId);

		Session session = null;

		try {
			session = openSession();

			ProductField[] array = new ProductFieldImpl[3];

			array[0] = getByProductPurchaseId_PrevAndNext(
				session, productField, productPurchaseId, orderByComparator,
				true);

			array[1] = productField;

			array[2] = getByProductPurchaseId_PrevAndNext(
				session, productField, productPurchaseId, orderByComparator,
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

	protected ProductField getByProductPurchaseId_PrevAndNext(
		Session session, ProductField productField, long productPurchaseId,
		OrderByComparator<ProductField> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCTFIELD_WHERE);

		query.append(_FINDER_COLUMN_PRODUCTPURCHASEID_PRODUCTPURCHASEID_2);

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
			query.append(ProductFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(productPurchaseId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(productField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ProductField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product fields where productPurchaseId = &#63; from the database.
	 *
	 * @param productPurchaseId the product purchase ID
	 */
	@Override
	public void removeByProductPurchaseId(long productPurchaseId) {
		for (ProductField productField :
				findByProductPurchaseId(
					productPurchaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productField);
		}
	}

	/**
	 * Returns the number of product fields where productPurchaseId = &#63;.
	 *
	 * @param productPurchaseId the product purchase ID
	 * @return the number of matching product fields
	 */
	@Override
	public int countByProductPurchaseId(long productPurchaseId) {
		FinderPath finderPath = _finderPathCountByProductPurchaseId;

		Object[] finderArgs = new Object[] {productPurchaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCTFIELD_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTPURCHASEID_PRODUCTPURCHASEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productPurchaseId);

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

	private static final String
		_FINDER_COLUMN_PRODUCTPURCHASEID_PRODUCTPURCHASEID_2 =
			"productField.productPurchaseId = ?";

	public ProductFieldPersistenceImpl() {
		setModelClass(ProductField.class);

		setModelImplClass(ProductFieldImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the product field in the entity cache if it is enabled.
	 *
	 * @param productField the product field
	 */
	@Override
	public void cacheResult(ProductField productField) {
		entityCache.putResult(
			entityCacheEnabled, ProductFieldImpl.class,
			productField.getPrimaryKey(), productField);

		productField.resetOriginalValues();
	}

	/**
	 * Caches the product fields in the entity cache if it is enabled.
	 *
	 * @param productFields the product fields
	 */
	@Override
	public void cacheResult(List<ProductField> productFields) {
		for (ProductField productField : productFields) {
			if (entityCache.getResult(
					entityCacheEnabled, ProductFieldImpl.class,
					productField.getPrimaryKey()) == null) {

				cacheResult(productField);
			}
			else {
				productField.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all product fields.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductFieldImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product field.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductField productField) {
		entityCache.removeResult(
			entityCacheEnabled, ProductFieldImpl.class,
			productField.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProductField> productFields) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductField productField : productFields) {
			entityCache.removeResult(
				entityCacheEnabled, ProductFieldImpl.class,
				productField.getPrimaryKey());
		}
	}

	/**
	 * Creates a new product field with the primary key. Does not add the product field to the database.
	 *
	 * @param productFieldId the primary key for the new product field
	 * @return the new product field
	 */
	@Override
	public ProductField create(long productFieldId) {
		ProductField productField = new ProductFieldImpl();

		productField.setNew(true);
		productField.setPrimaryKey(productFieldId);

		productField.setCompanyId(companyProvider.getCompanyId());

		return productField;
	}

	/**
	 * Removes the product field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productFieldId the primary key of the product field
	 * @return the product field that was removed
	 * @throws NoSuchProductFieldException if a product field with the primary key could not be found
	 */
	@Override
	public ProductField remove(long productFieldId)
		throws NoSuchProductFieldException {

		return remove((Serializable)productFieldId);
	}

	/**
	 * Removes the product field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product field
	 * @return the product field that was removed
	 * @throws NoSuchProductFieldException if a product field with the primary key could not be found
	 */
	@Override
	public ProductField remove(Serializable primaryKey)
		throws NoSuchProductFieldException {

		Session session = null;

		try {
			session = openSession();

			ProductField productField = (ProductField)session.get(
				ProductFieldImpl.class, primaryKey);

			if (productField == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductFieldException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productField);
		}
		catch (NoSuchProductFieldException nsee) {
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
	protected ProductField removeImpl(ProductField productField) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productField)) {
				productField = (ProductField)session.get(
					ProductFieldImpl.class, productField.getPrimaryKeyObj());
			}

			if (productField != null) {
				session.delete(productField);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (productField != null) {
			clearCache(productField);
		}

		return productField;
	}

	@Override
	public ProductField updateImpl(ProductField productField) {
		boolean isNew = productField.isNew();

		if (!(productField instanceof ProductFieldModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productField.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productField);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productField proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductField implementation " +
					productField.getClass());
		}

		ProductFieldModelImpl productFieldModelImpl =
			(ProductFieldModelImpl)productField;

		Session session = null;

		try {
			session = openSession();

			if (productField.isNew()) {
				session.save(productField);

				productField.setNew(false);
			}
			else {
				productField = (ProductField)session.merge(productField);
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
				productFieldModelImpl.getProductPurchaseId()
			};

			finderCache.removeResult(_finderPathCountByProductPurchaseId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByProductPurchaseId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((productFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByProductPurchaseId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					productFieldModelImpl.getOriginalProductPurchaseId()
				};

				finderCache.removeResult(
					_finderPathCountByProductPurchaseId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProductPurchaseId, args);

				args = new Object[] {
					productFieldModelImpl.getProductPurchaseId()
				};

				finderCache.removeResult(
					_finderPathCountByProductPurchaseId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProductPurchaseId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ProductFieldImpl.class,
			productField.getPrimaryKey(), productField, false);

		productField.resetOriginalValues();

		return productField;
	}

	/**
	 * Returns the product field with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product field
	 * @return the product field
	 * @throws NoSuchProductFieldException if a product field with the primary key could not be found
	 */
	@Override
	public ProductField findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductFieldException {

		ProductField productField = fetchByPrimaryKey(primaryKey);

		if (productField == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductFieldException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productField;
	}

	/**
	 * Returns the product field with the primary key or throws a <code>NoSuchProductFieldException</code> if it could not be found.
	 *
	 * @param productFieldId the primary key of the product field
	 * @return the product field
	 * @throws NoSuchProductFieldException if a product field with the primary key could not be found
	 */
	@Override
	public ProductField findByPrimaryKey(long productFieldId)
		throws NoSuchProductFieldException {

		return findByPrimaryKey((Serializable)productFieldId);
	}

	/**
	 * Returns the product field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productFieldId the primary key of the product field
	 * @return the product field, or <code>null</code> if a product field with the primary key could not be found
	 */
	@Override
	public ProductField fetchByPrimaryKey(long productFieldId) {
		return fetchByPrimaryKey((Serializable)productFieldId);
	}

	/**
	 * Returns all the product fields.
	 *
	 * @return the product fields
	 */
	@Override
	public List<ProductField> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of product fields
	 * @param end the upper bound of the range of product fields (not inclusive)
	 * @return the range of product fields
	 */
	@Override
	public List<ProductField> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of product fields
	 * @param end the upper bound of the range of product fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product fields
	 */
	@Override
	public List<ProductField> findAll(
		int start, int end, OrderByComparator<ProductField> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProductFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of product fields
	 * @param end the upper bound of the range of product fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of product fields
	 */
	@Override
	public List<ProductField> findAll(
		int start, int end, OrderByComparator<ProductField> orderByComparator,
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

		List<ProductField> list = null;

		if (retrieveFromCache) {
			list = (List<ProductField>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PRODUCTFIELD);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTFIELD;

				if (pagination) {
					sql = sql.concat(ProductFieldModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProductField>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProductField>)QueryUtil.list(
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
	 * Removes all the product fields from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductField productField : findAll()) {
			remove(productField);
		}
	}

	/**
	 * Returns the number of product fields.
	 *
	 * @return the number of product fields
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRODUCTFIELD);

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
		return "productFieldId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTFIELD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductFieldModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product field persistence.
	 */
	@Activate
	public void activate() {
		ProductFieldModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ProductFieldModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ProductFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ProductFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByProductPurchaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ProductFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProductPurchaseId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByProductPurchaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ProductFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProductPurchaseId", new String[] {Long.class.getName()},
			ProductFieldModelImpl.PRODUCTPURCHASEID_COLUMN_BITMASK);

		_finderPathCountByProductPurchaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProductPurchaseId", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ProductFieldImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.osb.koroneiki.trunk.model.ProductField"),
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

	private static final String _SQL_SELECT_PRODUCTFIELD =
		"SELECT productField FROM ProductField productField";

	private static final String _SQL_SELECT_PRODUCTFIELD_WHERE =
		"SELECT productField FROM ProductField productField WHERE ";

	private static final String _SQL_COUNT_PRODUCTFIELD =
		"SELECT COUNT(productField) FROM ProductField productField";

	private static final String _SQL_COUNT_PRODUCTFIELD_WHERE =
		"SELECT COUNT(productField) FROM ProductField productField WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productField.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductField exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductField exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductFieldPersistenceImpl.class);

}