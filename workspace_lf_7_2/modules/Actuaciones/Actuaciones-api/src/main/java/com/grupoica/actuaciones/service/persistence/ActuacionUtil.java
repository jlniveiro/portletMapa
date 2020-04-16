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

package com.grupoica.actuaciones.service.persistence;

import com.grupoica.actuaciones.model.Actuacion;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the actuacion service. This utility wraps <code>com.grupoica.actuaciones.service.persistence.impl.ActuacionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActuacionPersistence
 * @generated
 */
@ProviderType
public class ActuacionUtil {

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
	public static void clearCache(Actuacion actuacion) {
		getPersistence().clearCache(actuacion);
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
	public static Map<Serializable, Actuacion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Actuacion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Actuacion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Actuacion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Actuacion update(Actuacion actuacion) {
		return getPersistence().update(actuacion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Actuacion update(
		Actuacion actuacion, ServiceContext serviceContext) {

		return getPersistence().update(actuacion, serviceContext);
	}

	/**
	 * Returns all the actuacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching actuacions
	 */
	public static List<Actuacion> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the actuacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of matching actuacions
	 */
	public static List<Actuacion> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actuacions
	 */
	@Deprecated
	public static List<Actuacion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actuacions
	 */
	public static List<Actuacion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByUuid_First(
			String uuid, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByUuid_First(
		String uuid, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByUuid_Last(
			String uuid, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByUuid_Last(
		String uuid, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion[] findByUuid_PrevAndNext(
			long actuacionId, String uuid,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByUuid_PrevAndNext(
			actuacionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the actuacions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of actuacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching actuacions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the actuacion where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchActuacionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByUUID_G(String uuid, long groupId)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the actuacion where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Deprecated
	public static Actuacion fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Returns the actuacion where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Removes the actuacion where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the actuacion that was removed
	 */
	public static Actuacion removeByUUID_G(String uuid, long groupId)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of actuacions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching actuacions
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the actuacions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching actuacions
	 */
	public static List<Actuacion> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the actuacions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of matching actuacions
	 */
	public static List<Actuacion> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actuacions
	 */
	@Deprecated
	public static List<Actuacion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actuacions
	 */
	public static List<Actuacion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion[] findByUuid_C_PrevAndNext(
			long actuacionId, String uuid, long companyId,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByUuid_C_PrevAndNext(
			actuacionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the actuacions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of actuacions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching actuacions
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the actuacions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching actuacions
	 */
	public static List<Actuacion> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the actuacions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of matching actuacions
	 */
	public static List<Actuacion> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupId(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actuacions
	 */
	@Deprecated
	public static List<Actuacion> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actuacions
	 */
	public static List<Actuacion> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByGroupId_First(
			long groupId, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByGroupId_First(
		long groupId, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByGroupId_Last(
			long groupId, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByGroupId_Last(
		long groupId, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion[] findByGroupId_PrevAndNext(
			long actuacionId, long groupId,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByGroupId_PrevAndNext(
			actuacionId, groupId, orderByComparator);
	}

	/**
	 * Removes all the actuacions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of actuacions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching actuacions
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the actuacions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching actuacions
	 */
	public static List<Actuacion> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the actuacions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of matching actuacions
	 */
	public static List<Actuacion> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByStatus(int, int, int, OrderByComparator)}
	 * @param status the status
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actuacions
	 */
	@Deprecated
	public static List<Actuacion> findByStatus(
		int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actuacions
	 */
	public static List<Actuacion> findByStatus(
		int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByStatus_First(
			int status, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByStatus_First(
		int status, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByStatus_Last(
			int status, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByStatus_Last(
		int status, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where status = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion[] findByStatus_PrevAndNext(
			long actuacionId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByStatus_PrevAndNext(
			actuacionId, status, orderByComparator);
	}

	/**
	 * Removes all the actuacions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of actuacions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching actuacions
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the actuacions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching actuacions
	 */
	public static List<Actuacion> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the actuacions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of matching actuacions
	 */
	public static List<Actuacion> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByG_S(long,int, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actuacions
	 */
	@Deprecated
	public static List<Actuacion> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actuacions
	 */
	public static List<Actuacion> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByG_S_First(
			long groupId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByG_S_Last(
			long groupId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion[] findByG_S_PrevAndNext(
			long actuacionId, long groupId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByG_S_PrevAndNext(
			actuacionId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the actuacions where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of actuacions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching actuacions
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns all the actuacions where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @return the matching actuacions
	 */
	public static List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud) {

		return getPersistence().findByPosicion(longitud, latitud);
	}

	/**
	 * Returns a range of all the actuacions where longitud = &#63; and latitud = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of matching actuacions
	 */
	public static List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud, int start, int end) {

		return getPersistence().findByPosicion(longitud, latitud, start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions where longitud = &#63; and latitud = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByPosicion(BigDecimal,BigDecimal, int, int, OrderByComparator)}
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actuacions
	 */
	@Deprecated
	public static List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPosicion(
			longitud, latitud, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions where longitud = &#63; and latitud = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actuacions
	 */
	public static List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findByPosicion(
			longitud, latitud, start, end, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByPosicion_First(
			BigDecimal longitud, BigDecimal latitud,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByPosicion_First(
			longitud, latitud, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByPosicion_First(
		BigDecimal longitud, BigDecimal latitud,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByPosicion_First(
			longitud, latitud, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByPosicion_Last(
			BigDecimal longitud, BigDecimal latitud,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByPosicion_Last(
			longitud, latitud, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByPosicion_Last(
		BigDecimal longitud, BigDecimal latitud,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByPosicion_Last(
			longitud, latitud, orderByComparator);
	}

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion[] findByPosicion_PrevAndNext(
			long actuacionId, BigDecimal longitud, BigDecimal latitud,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByPosicion_PrevAndNext(
			actuacionId, longitud, latitud, orderByComparator);
	}

	/**
	 * Removes all the actuacions where longitud = &#63; and latitud = &#63; from the database.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 */
	public static void removeByPosicion(
		BigDecimal longitud, BigDecimal latitud) {

		getPersistence().removeByPosicion(longitud, latitud);
	}

	/**
	 * Returns the number of actuacions where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @return the number of matching actuacions
	 */
	public static int countByPosicion(BigDecimal longitud, BigDecimal latitud) {
		return getPersistence().countByPosicion(longitud, latitud);
	}

	/**
	 * Returns all the actuacions where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @return the matching actuacions
	 */
	public static List<Actuacion> findByCodTecnico(long codTecnico) {
		return getPersistence().findByCodTecnico(codTecnico);
	}

	/**
	 * Returns a range of all the actuacions where codTecnico = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param codTecnico the cod tecnico
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of matching actuacions
	 */
	public static List<Actuacion> findByCodTecnico(
		long codTecnico, int start, int end) {

		return getPersistence().findByCodTecnico(codTecnico, start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions where codTecnico = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCodTecnico(long, int, int, OrderByComparator)}
	 * @param codTecnico the cod tecnico
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actuacions
	 */
	@Deprecated
	public static List<Actuacion> findByCodTecnico(
		long codTecnico, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCodTecnico(
			codTecnico, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions where codTecnico = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param codTecnico the cod tecnico
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actuacions
	 */
	public static List<Actuacion> findByCodTecnico(
		long codTecnico, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findByCodTecnico(
			codTecnico, start, end, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByCodTecnico_First(
			long codTecnico, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByCodTecnico_First(
			codTecnico, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByCodTecnico_First(
		long codTecnico, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByCodTecnico_First(
			codTecnico, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByCodTecnico_Last(
			long codTecnico, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByCodTecnico_Last(
			codTecnico, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByCodTecnico_Last(
		long codTecnico, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByCodTecnico_Last(
			codTecnico, orderByComparator);
	}

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion[] findByCodTecnico_PrevAndNext(
			long actuacionId, long codTecnico,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByCodTecnico_PrevAndNext(
			actuacionId, codTecnico, orderByComparator);
	}

	/**
	 * Removes all the actuacions where codTecnico = &#63; from the database.
	 *
	 * @param codTecnico the cod tecnico
	 */
	public static void removeByCodTecnico(long codTecnico) {
		getPersistence().removeByCodTecnico(codTecnico);
	}

	/**
	 * Returns the number of actuacions where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @return the number of matching actuacions
	 */
	public static int countByCodTecnico(long codTecnico) {
		return getPersistence().countByCodTecnico(codTecnico);
	}

	/**
	 * Returns all the actuacions where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching actuacions
	 */
	public static List<Actuacion> findByNombre(String nombre) {
		return getPersistence().findByNombre(nombre);
	}

	/**
	 * Returns a range of all the actuacions where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of matching actuacions
	 */
	public static List<Actuacion> findByNombre(
		String nombre, int start, int end) {

		return getPersistence().findByNombre(nombre, start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByNombre(String, int, int, OrderByComparator)}
	 * @param nombre the nombre
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actuacions
	 */
	@Deprecated
	public static List<Actuacion> findByNombre(
		String nombre, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByNombre(
			nombre, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actuacions
	 */
	public static List<Actuacion> findByNombre(
		String nombre, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findByNombre(
			nombre, start, end, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByNombre_First(
			String nombre, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByNombre_First(nombre, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByNombre_First(
		String nombre, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByNombre_First(nombre, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByNombre_Last(
			String nombre, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByNombre_Last(nombre, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByNombre_Last(
		String nombre, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByNombre_Last(nombre, orderByComparator);
	}

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion[] findByNombre_PrevAndNext(
			long actuacionId, String nombre,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByNombre_PrevAndNext(
			actuacionId, nombre, orderByComparator);
	}

	/**
	 * Removes all the actuacions where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	public static void removeByNombre(String nombre) {
		getPersistence().removeByNombre(nombre);
	}

	/**
	 * Returns the number of actuacions where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching actuacions
	 */
	public static int countByNombre(String nombre) {
		return getPersistence().countByNombre(nombre);
	}

	/**
	 * Returns all the actuacions where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @return the matching actuacions
	 */
	public static List<Actuacion> findByCA(String comunidadAutonoma) {
		return getPersistence().findByCA(comunidadAutonoma);
	}

	/**
	 * Returns a range of all the actuacions where comunidadAutonoma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of matching actuacions
	 */
	public static List<Actuacion> findByCA(
		String comunidadAutonoma, int start, int end) {

		return getPersistence().findByCA(comunidadAutonoma, start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions where comunidadAutonoma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCA(String, int, int, OrderByComparator)}
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actuacions
	 */
	@Deprecated
	public static List<Actuacion> findByCA(
		String comunidadAutonoma, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCA(
			comunidadAutonoma, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions where comunidadAutonoma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actuacions
	 */
	public static List<Actuacion> findByCA(
		String comunidadAutonoma, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findByCA(
			comunidadAutonoma, start, end, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByCA_First(
			String comunidadAutonoma,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByCA_First(
			comunidadAutonoma, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByCA_First(
		String comunidadAutonoma,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByCA_First(
			comunidadAutonoma, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByCA_Last(
			String comunidadAutonoma,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByCA_Last(
			comunidadAutonoma, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByCA_Last(
		String comunidadAutonoma,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByCA_Last(
			comunidadAutonoma, orderByComparator);
	}

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion[] findByCA_PrevAndNext(
			long actuacionId, String comunidadAutonoma,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByCA_PrevAndNext(
			actuacionId, comunidadAutonoma, orderByComparator);
	}

	/**
	 * Removes all the actuacions where comunidadAutonoma = &#63; from the database.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 */
	public static void removeByCA(String comunidadAutonoma) {
		getPersistence().removeByCA(comunidadAutonoma);
	}

	/**
	 * Returns the number of actuacions where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @return the number of matching actuacions
	 */
	public static int countByCA(String comunidadAutonoma) {
		return getPersistence().countByCA(comunidadAutonoma);
	}

	/**
	 * Returns all the actuacions where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @return the matching actuacions
	 */
	public static List<Actuacion> findByProvincia(String provincia) {
		return getPersistence().findByProvincia(provincia);
	}

	/**
	 * Returns a range of all the actuacions where provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param provincia the provincia
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of matching actuacions
	 */
	public static List<Actuacion> findByProvincia(
		String provincia, int start, int end) {

		return getPersistence().findByProvincia(provincia, start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions where provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByProvincia(String, int, int, OrderByComparator)}
	 * @param provincia the provincia
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actuacions
	 */
	@Deprecated
	public static List<Actuacion> findByProvincia(
		String provincia, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProvincia(
			provincia, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions where provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param provincia the provincia
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actuacions
	 */
	public static List<Actuacion> findByProvincia(
		String provincia, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findByProvincia(
			provincia, start, end, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByProvincia_First(
			String provincia, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByProvincia_First(
			provincia, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByProvincia_First(
		String provincia, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByProvincia_First(
			provincia, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByProvincia_Last(
			String provincia, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByProvincia_Last(
			provincia, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByProvincia_Last(
		String provincia, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByProvincia_Last(
			provincia, orderByComparator);
	}

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion[] findByProvincia_PrevAndNext(
			long actuacionId, String provincia,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByProvincia_PrevAndNext(
			actuacionId, provincia, orderByComparator);
	}

	/**
	 * Removes all the actuacions where provincia = &#63; from the database.
	 *
	 * @param provincia the provincia
	 */
	public static void removeByProvincia(String provincia) {
		getPersistence().removeByProvincia(provincia);
	}

	/**
	 * Returns the number of actuacions where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @return the number of matching actuacions
	 */
	public static int countByProvincia(String provincia) {
		return getPersistence().countByProvincia(provincia);
	}

	/**
	 * Returns all the actuacions where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @return the matching actuacions
	 */
	public static List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion) {

		return getPersistence().findByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion);
	}

	/**
	 * Returns a range of all the actuacions where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of matching actuacions
	 */
	public static List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, int start, int end) {

		return getPersistence().findByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion, start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByTituloComAutProvinciaSituacion(String,String,String,String, int, int, OrderByComparator)}
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actuacions
	 */
	@Deprecated
	public static List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actuacions
	 */
	public static List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion, start, end,
			orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByTituloComAutProvinciaSituacion_First(
			String nombre, String comunidadAutonoma, String provincia,
			String situacion, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByTituloComAutProvinciaSituacion_First(
			nombre, comunidadAutonoma, provincia, situacion, orderByComparator);
	}

	/**
	 * Returns the first actuacion in the ordered set where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByTituloComAutProvinciaSituacion_First(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByTituloComAutProvinciaSituacion_First(
			nombre, comunidadAutonoma, provincia, situacion, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public static Actuacion findByTituloComAutProvinciaSituacion_Last(
			String nombre, String comunidadAutonoma, String provincia,
			String situacion, OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByTituloComAutProvinciaSituacion_Last(
			nombre, comunidadAutonoma, provincia, situacion, orderByComparator);
	}

	/**
	 * Returns the last actuacion in the ordered set where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static Actuacion fetchByTituloComAutProvinciaSituacion_Last(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().fetchByTituloComAutProvinciaSituacion_Last(
			nombre, comunidadAutonoma, provincia, situacion, orderByComparator);
	}

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion[] findByTituloComAutProvinciaSituacion_PrevAndNext(
			long actuacionId, String nombre, String comunidadAutonoma,
			String provincia, String situacion,
			OrderByComparator<Actuacion> orderByComparator)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().
			findByTituloComAutProvinciaSituacion_PrevAndNext(
				actuacionId, nombre, comunidadAutonoma, provincia, situacion,
				orderByComparator);
	}

	/**
	 * Removes all the actuacions where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63; from the database.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 */
	public static void removeByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion) {

		getPersistence().removeByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion);
	}

	/**
	 * Returns the number of actuacions where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @return the number of matching actuacions
	 */
	public static int countByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion) {

		return getPersistence().countByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion);
	}

	/**
	 * Caches the actuacion in the entity cache if it is enabled.
	 *
	 * @param actuacion the actuacion
	 */
	public static void cacheResult(Actuacion actuacion) {
		getPersistence().cacheResult(actuacion);
	}

	/**
	 * Caches the actuacions in the entity cache if it is enabled.
	 *
	 * @param actuacions the actuacions
	 */
	public static void cacheResult(List<Actuacion> actuacions) {
		getPersistence().cacheResult(actuacions);
	}

	/**
	 * Creates a new actuacion with the primary key. Does not add the actuacion to the database.
	 *
	 * @param actuacionId the primary key for the new actuacion
	 * @return the new actuacion
	 */
	public static Actuacion create(long actuacionId) {
		return getPersistence().create(actuacionId);
	}

	/**
	 * Removes the actuacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion that was removed
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion remove(long actuacionId)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().remove(actuacionId);
	}

	public static Actuacion updateImpl(Actuacion actuacion) {
		return getPersistence().updateImpl(actuacion);
	}

	/**
	 * Returns the actuacion with the primary key or throws a <code>NoSuchActuacionException</code> if it could not be found.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public static Actuacion findByPrimaryKey(long actuacionId)
		throws com.grupoica.actuaciones.exception.NoSuchActuacionException {

		return getPersistence().findByPrimaryKey(actuacionId);
	}

	/**
	 * Returns the actuacion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion, or <code>null</code> if a actuacion with the primary key could not be found
	 */
	public static Actuacion fetchByPrimaryKey(long actuacionId) {
		return getPersistence().fetchByPrimaryKey(actuacionId);
	}

	/**
	 * Returns all the actuacions.
	 *
	 * @return the actuacions
	 */
	public static List<Actuacion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the actuacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of actuacions
	 */
	public static List<Actuacion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the actuacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of actuacions
	 */
	@Deprecated
	public static List<Actuacion> findAll(
		int start, int end, OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the actuacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of actuacions
	 */
	public static List<Actuacion> findAll(
		int start, int end, OrderByComparator<Actuacion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the actuacions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of actuacions.
	 *
	 * @return the number of actuacions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ActuacionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ActuacionPersistence, ActuacionPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ActuacionPersistence.class);

		ServiceTracker<ActuacionPersistence, ActuacionPersistence>
			serviceTracker =
				new ServiceTracker<ActuacionPersistence, ActuacionPersistence>(
					bundle.getBundleContext(), ActuacionPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}