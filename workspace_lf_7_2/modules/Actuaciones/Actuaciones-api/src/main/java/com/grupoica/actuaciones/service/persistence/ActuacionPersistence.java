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

import com.grupoica.actuaciones.exception.NoSuchActuacionException;
import com.grupoica.actuaciones.model.Actuacion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.math.BigDecimal;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the actuacion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActuacionUtil
 * @generated
 */
@ProviderType
public interface ActuacionPersistence extends BasePersistence<Actuacion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ActuacionUtil} to access the actuacion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the actuacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching actuacions
	 */
	public java.util.List<Actuacion> findByUuid(String uuid);

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
	public java.util.List<Actuacion> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Actuacion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Actuacion> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Actuacion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the first actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByUuid_First(
			String uuid, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the first actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByUuid_First(
		String uuid, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the last actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByUuid_Last(
			String uuid, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the last actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByUuid_Last(
		String uuid, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public Actuacion[] findByUuid_PrevAndNext(
			long actuacionId, String uuid,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Removes all the actuacions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of actuacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching actuacions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the actuacion where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchActuacionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByUUID_G(String uuid, long groupId)
		throws NoSuchActuacionException;

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
	public Actuacion fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the actuacion where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the actuacion where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the actuacion that was removed
	 */
	public Actuacion removeByUUID_G(String uuid, long groupId)
		throws NoSuchActuacionException;

	/**
	 * Returns the number of actuacions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching actuacions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the actuacions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching actuacions
	 */
	public java.util.List<Actuacion> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Actuacion> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Actuacion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Actuacion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the first actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the first actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the last actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the last actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Actuacion> orderByComparator);

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
	public Actuacion[] findByUuid_C_PrevAndNext(
			long actuacionId, String uuid, long companyId,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Removes all the actuacions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of actuacions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching actuacions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the actuacions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching actuacions
	 */
	public java.util.List<Actuacion> findByGroupId(long groupId);

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
	public java.util.List<Actuacion> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Actuacion> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Actuacion> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the first actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByGroupId_First(
			long groupId, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the first actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByGroupId_First(
		long groupId, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the last actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByGroupId_Last(
			long groupId, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the last actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByGroupId_Last(
		long groupId, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public Actuacion[] findByGroupId_PrevAndNext(
			long actuacionId, long groupId,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Removes all the actuacions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of actuacions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching actuacions
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the actuacions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching actuacions
	 */
	public java.util.List<Actuacion> findByStatus(int status);

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
	public java.util.List<Actuacion> findByStatus(
		int status, int start, int end);

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
	public java.util.List<Actuacion> findByStatus(
		int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Actuacion> findByStatus(
		int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the first actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByStatus_First(
			int status, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the first actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByStatus_First(
		int status, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the last actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByStatus_Last(
			int status, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the last actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByStatus_Last(
		int status, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where status = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public Actuacion[] findByStatus_PrevAndNext(
			long actuacionId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Removes all the actuacions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of actuacions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching actuacions
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the actuacions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching actuacions
	 */
	public java.util.List<Actuacion> findByG_S(long groupId, int status);

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
	public java.util.List<Actuacion> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<Actuacion> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Actuacion> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the first actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByG_S_First(
			long groupId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the first actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the last actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByG_S_Last(
			long groupId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the last actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<Actuacion> orderByComparator);

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
	public Actuacion[] findByG_S_PrevAndNext(
			long actuacionId, long groupId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Removes all the actuacions where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of actuacions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching actuacions
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns all the actuacions where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @return the matching actuacions
	 */
	public java.util.List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud);

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
	public java.util.List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud, int start, int end);

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
	public java.util.List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud, int start, int end,
		OrderByComparator<Actuacion> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud, int start, int end,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the first actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByPosicion_First(
			BigDecimal longitud, BigDecimal latitud,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the first actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByPosicion_First(
		BigDecimal longitud, BigDecimal latitud,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the last actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByPosicion_Last(
			BigDecimal longitud, BigDecimal latitud,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the last actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByPosicion_Last(
		BigDecimal longitud, BigDecimal latitud,
		OrderByComparator<Actuacion> orderByComparator);

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
	public Actuacion[] findByPosicion_PrevAndNext(
			long actuacionId, BigDecimal longitud, BigDecimal latitud,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Removes all the actuacions where longitud = &#63; and latitud = &#63; from the database.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 */
	public void removeByPosicion(BigDecimal longitud, BigDecimal latitud);

	/**
	 * Returns the number of actuacions where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @return the number of matching actuacions
	 */
	public int countByPosicion(BigDecimal longitud, BigDecimal latitud);

	/**
	 * Returns all the actuacions where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @return the matching actuacions
	 */
	public java.util.List<Actuacion> findByCodTecnico(long codTecnico);

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
	public java.util.List<Actuacion> findByCodTecnico(
		long codTecnico, int start, int end);

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
	public java.util.List<Actuacion> findByCodTecnico(
		long codTecnico, int start, int end,
		OrderByComparator<Actuacion> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Actuacion> findByCodTecnico(
		long codTecnico, int start, int end,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the first actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByCodTecnico_First(
			long codTecnico, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the first actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByCodTecnico_First(
		long codTecnico, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the last actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByCodTecnico_Last(
			long codTecnico, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the last actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByCodTecnico_Last(
		long codTecnico, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public Actuacion[] findByCodTecnico_PrevAndNext(
			long actuacionId, long codTecnico,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Removes all the actuacions where codTecnico = &#63; from the database.
	 *
	 * @param codTecnico the cod tecnico
	 */
	public void removeByCodTecnico(long codTecnico);

	/**
	 * Returns the number of actuacions where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @return the number of matching actuacions
	 */
	public int countByCodTecnico(long codTecnico);

	/**
	 * Returns all the actuacions where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching actuacions
	 */
	public java.util.List<Actuacion> findByNombre(String nombre);

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
	public java.util.List<Actuacion> findByNombre(
		String nombre, int start, int end);

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
	public java.util.List<Actuacion> findByNombre(
		String nombre, int start, int end,
		OrderByComparator<Actuacion> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Actuacion> findByNombre(
		String nombre, int start, int end,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the first actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByNombre_First(
			String nombre, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the first actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByNombre_First(
		String nombre, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the last actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByNombre_Last(
			String nombre, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the last actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByNombre_Last(
		String nombre, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public Actuacion[] findByNombre_PrevAndNext(
			long actuacionId, String nombre,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Removes all the actuacions where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	public void removeByNombre(String nombre);

	/**
	 * Returns the number of actuacions where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching actuacions
	 */
	public int countByNombre(String nombre);

	/**
	 * Returns all the actuacions where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @return the matching actuacions
	 */
	public java.util.List<Actuacion> findByCA(String comunidadAutonoma);

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
	public java.util.List<Actuacion> findByCA(
		String comunidadAutonoma, int start, int end);

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
	public java.util.List<Actuacion> findByCA(
		String comunidadAutonoma, int start, int end,
		OrderByComparator<Actuacion> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Actuacion> findByCA(
		String comunidadAutonoma, int start, int end,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the first actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByCA_First(
			String comunidadAutonoma,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the first actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByCA_First(
		String comunidadAutonoma,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the last actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByCA_Last(
			String comunidadAutonoma,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the last actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByCA_Last(
		String comunidadAutonoma,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public Actuacion[] findByCA_PrevAndNext(
			long actuacionId, String comunidadAutonoma,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Removes all the actuacions where comunidadAutonoma = &#63; from the database.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 */
	public void removeByCA(String comunidadAutonoma);

	/**
	 * Returns the number of actuacions where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @return the number of matching actuacions
	 */
	public int countByCA(String comunidadAutonoma);

	/**
	 * Returns all the actuacions where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @return the matching actuacions
	 */
	public java.util.List<Actuacion> findByProvincia(String provincia);

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
	public java.util.List<Actuacion> findByProvincia(
		String provincia, int start, int end);

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
	public java.util.List<Actuacion> findByProvincia(
		String provincia, int start, int end,
		OrderByComparator<Actuacion> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Actuacion> findByProvincia(
		String provincia, int start, int end,
		OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the first actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByProvincia_First(
			String provincia, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the first actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByProvincia_First(
		String provincia, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the last actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	public Actuacion findByProvincia_Last(
			String provincia, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Returns the last actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public Actuacion fetchByProvincia_Last(
		String provincia, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Returns the actuacions before and after the current actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param actuacionId the primary key of the current actuacion
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public Actuacion[] findByProvincia_PrevAndNext(
			long actuacionId, String provincia,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Removes all the actuacions where provincia = &#63; from the database.
	 *
	 * @param provincia the provincia
	 */
	public void removeByProvincia(String provincia);

	/**
	 * Returns the number of actuacions where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @return the number of matching actuacions
	 */
	public int countByProvincia(String provincia);

	/**
	 * Returns all the actuacions where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @return the matching actuacions
	 */
	public java.util.List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion);

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
	public java.util.List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, int start, int end);

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
	public java.util.List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, int start, int end,
		OrderByComparator<Actuacion> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, int start, int end,
		OrderByComparator<Actuacion> orderByComparator);

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
	public Actuacion findByTituloComAutProvinciaSituacion_First(
			String nombre, String comunidadAutonoma, String provincia,
			String situacion, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

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
	public Actuacion fetchByTituloComAutProvinciaSituacion_First(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, OrderByComparator<Actuacion> orderByComparator);

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
	public Actuacion findByTituloComAutProvinciaSituacion_Last(
			String nombre, String comunidadAutonoma, String provincia,
			String situacion, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

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
	public Actuacion fetchByTituloComAutProvinciaSituacion_Last(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, OrderByComparator<Actuacion> orderByComparator);

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
	public Actuacion[] findByTituloComAutProvinciaSituacion_PrevAndNext(
			long actuacionId, String nombre, String comunidadAutonoma,
			String provincia, String situacion,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException;

	/**
	 * Removes all the actuacions where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63; from the database.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 */
	public void removeByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion);

	/**
	 * Returns the number of actuacions where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @return the number of matching actuacions
	 */
	public int countByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion);

	/**
	 * Caches the actuacion in the entity cache if it is enabled.
	 *
	 * @param actuacion the actuacion
	 */
	public void cacheResult(Actuacion actuacion);

	/**
	 * Caches the actuacions in the entity cache if it is enabled.
	 *
	 * @param actuacions the actuacions
	 */
	public void cacheResult(java.util.List<Actuacion> actuacions);

	/**
	 * Creates a new actuacion with the primary key. Does not add the actuacion to the database.
	 *
	 * @param actuacionId the primary key for the new actuacion
	 * @return the new actuacion
	 */
	public Actuacion create(long actuacionId);

	/**
	 * Removes the actuacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion that was removed
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public Actuacion remove(long actuacionId) throws NoSuchActuacionException;

	public Actuacion updateImpl(Actuacion actuacion);

	/**
	 * Returns the actuacion with the primary key or throws a <code>NoSuchActuacionException</code> if it could not be found.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	public Actuacion findByPrimaryKey(long actuacionId)
		throws NoSuchActuacionException;

	/**
	 * Returns the actuacion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion, or <code>null</code> if a actuacion with the primary key could not be found
	 */
	public Actuacion fetchByPrimaryKey(long actuacionId);

	/**
	 * Returns all the actuacions.
	 *
	 * @return the actuacions
	 */
	public java.util.List<Actuacion> findAll();

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
	public java.util.List<Actuacion> findAll(int start, int end);

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
	public java.util.List<Actuacion> findAll(
		int start, int end, OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Actuacion> findAll(
		int start, int end, OrderByComparator<Actuacion> orderByComparator);

	/**
	 * Removes all the actuacions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of actuacions.
	 *
	 * @return the number of actuacions
	 */
	public int countAll();

}