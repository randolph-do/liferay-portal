/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.change.tracking.service.persistence;

import com.liferay.change.tracking.exception.NoSuchCollectionException;
import com.liferay.change.tracking.model.CTCollection;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ct collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTCollectionUtil
 * @generated
 */
@ProviderType
public interface CTCollectionPersistence extends BasePersistence<CTCollection> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CTCollectionUtil} to access the ct collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ct collections where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching ct collections
	 */
	public java.util.List<CTCollection> findByCompanyId(long companyId);

	/**
	 * Returns a range of all the ct collections where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CTCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ct collections
	 * @param end the upper bound of the range of ct collections (not inclusive)
	 * @return the range of matching ct collections
	 */
	public java.util.List<CTCollection> findByCompanyId(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the ct collections where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CTCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ct collections
	 * @param end the upper bound of the range of ct collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ct collections
	 */
	public java.util.List<CTCollection> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ct collections where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CTCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ct collections
	 * @param end the upper bound of the range of ct collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ct collections
	 */
	public java.util.List<CTCollection> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ct collection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ct collection
	 * @throws NoSuchCollectionException if a matching ct collection could not be found
	 */
	public CTCollection findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CTCollection>
				orderByComparator)
		throws NoSuchCollectionException;

	/**
	 * Returns the first ct collection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ct collection, or <code>null</code> if a matching ct collection could not be found
	 */
	public CTCollection fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CTCollection>
			orderByComparator);

	/**
	 * Returns the last ct collection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ct collection
	 * @throws NoSuchCollectionException if a matching ct collection could not be found
	 */
	public CTCollection findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CTCollection>
				orderByComparator)
		throws NoSuchCollectionException;

	/**
	 * Returns the last ct collection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ct collection, or <code>null</code> if a matching ct collection could not be found
	 */
	public CTCollection fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CTCollection>
			orderByComparator);

	/**
	 * Returns the ct collections before and after the current ct collection in the ordered set where companyId = &#63;.
	 *
	 * @param ctCollectionId the primary key of the current ct collection
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ct collection
	 * @throws NoSuchCollectionException if a ct collection with the primary key could not be found
	 */
	public CTCollection[] findByCompanyId_PrevAndNext(
			long ctCollectionId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CTCollection>
				orderByComparator)
		throws NoSuchCollectionException;

	/**
	 * Removes all the ct collections where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of ct collections where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching ct collections
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns the ct collection where companyId = &#63; and name = &#63; or throws a <code>NoSuchCollectionException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the matching ct collection
	 * @throws NoSuchCollectionException if a matching ct collection could not be found
	 */
	public CTCollection findByC_N(long companyId, String name)
		throws NoSuchCollectionException;

	/**
	 * Returns the ct collection where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the matching ct collection, or <code>null</code> if a matching ct collection could not be found
	 */
	public CTCollection fetchByC_N(long companyId, String name);

	/**
	 * Returns the ct collection where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ct collection, or <code>null</code> if a matching ct collection could not be found
	 */
	public CTCollection fetchByC_N(
		long companyId, String name, boolean useFinderCache);

	/**
	 * Removes the ct collection where companyId = &#63; and name = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the ct collection that was removed
	 */
	public CTCollection removeByC_N(long companyId, String name)
		throws NoSuchCollectionException;

	/**
	 * Returns the number of ct collections where companyId = &#63; and name = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the number of matching ct collections
	 */
	public int countByC_N(long companyId, String name);

	/**
	 * Caches the ct collection in the entity cache if it is enabled.
	 *
	 * @param ctCollection the ct collection
	 */
	public void cacheResult(CTCollection ctCollection);

	/**
	 * Caches the ct collections in the entity cache if it is enabled.
	 *
	 * @param ctCollections the ct collections
	 */
	public void cacheResult(java.util.List<CTCollection> ctCollections);

	/**
	 * Creates a new ct collection with the primary key. Does not add the ct collection to the database.
	 *
	 * @param ctCollectionId the primary key for the new ct collection
	 * @return the new ct collection
	 */
	public CTCollection create(long ctCollectionId);

	/**
	 * Removes the ct collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ctCollectionId the primary key of the ct collection
	 * @return the ct collection that was removed
	 * @throws NoSuchCollectionException if a ct collection with the primary key could not be found
	 */
	public CTCollection remove(long ctCollectionId)
		throws NoSuchCollectionException;

	public CTCollection updateImpl(CTCollection ctCollection);

	/**
	 * Returns the ct collection with the primary key or throws a <code>NoSuchCollectionException</code> if it could not be found.
	 *
	 * @param ctCollectionId the primary key of the ct collection
	 * @return the ct collection
	 * @throws NoSuchCollectionException if a ct collection with the primary key could not be found
	 */
	public CTCollection findByPrimaryKey(long ctCollectionId)
		throws NoSuchCollectionException;

	/**
	 * Returns the ct collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ctCollectionId the primary key of the ct collection
	 * @return the ct collection, or <code>null</code> if a ct collection with the primary key could not be found
	 */
	public CTCollection fetchByPrimaryKey(long ctCollectionId);

	/**
	 * Returns all the ct collections.
	 *
	 * @return the ct collections
	 */
	public java.util.List<CTCollection> findAll();

	/**
	 * Returns a range of all the ct collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CTCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ct collections
	 * @param end the upper bound of the range of ct collections (not inclusive)
	 * @return the range of ct collections
	 */
	public java.util.List<CTCollection> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ct collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CTCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ct collections
	 * @param end the upper bound of the range of ct collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ct collections
	 */
	public java.util.List<CTCollection> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ct collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CTCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ct collections
	 * @param end the upper bound of the range of ct collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ct collections
	 */
	public java.util.List<CTCollection> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ct collections from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ct collections.
	 *
	 * @return the number of ct collections
	 */
	public int countAll();

}