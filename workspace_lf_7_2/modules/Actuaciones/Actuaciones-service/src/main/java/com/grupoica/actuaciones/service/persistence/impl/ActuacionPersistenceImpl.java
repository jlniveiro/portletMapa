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

package com.grupoica.actuaciones.service.persistence.impl;

import com.grupoica.actuaciones.exception.NoSuchActuacionException;
import com.grupoica.actuaciones.model.Actuacion;
import com.grupoica.actuaciones.model.impl.ActuacionImpl;
import com.grupoica.actuaciones.model.impl.ActuacionModelImpl;
import com.grupoica.actuaciones.service.persistence.ActuacionPersistence;
import com.grupoica.actuaciones.service.persistence.impl.constants.ActuacionesPersistenceConstants;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.math.BigDecimal;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the actuacion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ActuacionPersistence.class)
@ProviderType
public class ActuacionPersistenceImpl
	extends BasePersistenceImpl<Actuacion> implements ActuacionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ActuacionUtil</code> to access the actuacion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ActuacionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the actuacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching actuacions
	 */
	@Override
	public List<Actuacion> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Actuacion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findByUuid(uuid, start, end, orderByComparator);
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
	@Override
	public List<Actuacion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Actuacion actuacion : list) {
				if (!uuid.equals(actuacion.getUuid())) {
					list = null;

					break;
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

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActuacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	 * Returns the first actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByUuid_First(
			String uuid, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByUuid_First(uuid, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the first actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByUuid_First(
		String uuid, OrderByComparator<Actuacion> orderByComparator) {

		List<Actuacion> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByUuid_Last(
			String uuid, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByUuid_Last(uuid, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the last actuacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByUuid_Last(
		String uuid, OrderByComparator<Actuacion> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Actuacion> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion[] findByUuid_PrevAndNext(
			long actuacionId, String uuid,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		uuid = Objects.toString(uuid, "");

		Actuacion actuacion = findByPrimaryKey(actuacionId);

		Session session = null;

		try {
			session = openSession();

			Actuacion[] array = new ActuacionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, actuacion, uuid, orderByComparator, true);

			array[1] = actuacion;

			array[2] = getByUuid_PrevAndNext(
				session, actuacion, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Actuacion getByUuid_PrevAndNext(
		Session session, Actuacion actuacion, String uuid,
		OrderByComparator<Actuacion> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTUACION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

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
			query.append(ActuacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actuacion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Actuacion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actuacions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Actuacion actuacion :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(actuacion);
		}
	}

	/**
	 * Returns the number of actuacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching actuacions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"actuacion.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(actuacion.uuid IS NULL OR actuacion.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the actuacion where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchActuacionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByUUID_G(String uuid, long groupId)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByUUID_G(uuid, groupId);

		if (actuacion == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchActuacionException(msg.toString());
		}

		return actuacion;
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
	@Override
	public Actuacion fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the actuacion where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = finderCache.getResult(
			_finderPathFetchByUUID_G, finderArgs, this);

		if (result instanceof Actuacion) {
			Actuacion actuacion = (Actuacion)result;

			if (!Objects.equals(uuid, actuacion.getUuid()) ||
				(groupId != actuacion.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Actuacion> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					Actuacion actuacion = list.get(0);

					result = actuacion;

					cacheResult(actuacion);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByUUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Actuacion)result;
		}
	}

	/**
	 * Removes the actuacion where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the actuacion that was removed
	 */
	@Override
	public Actuacion removeByUUID_G(String uuid, long groupId)
		throws NoSuchActuacionException {

		Actuacion actuacion = findByUUID_G(uuid, groupId);

		return remove(actuacion);
	}

	/**
	 * Returns the number of actuacions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching actuacions
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"actuacion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(actuacion.uuid IS NULL OR actuacion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"actuacion.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the actuacions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching actuacions
	 */
	@Override
	public List<Actuacion> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Actuacion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
	@Override
	public List<Actuacion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid_C;
			finderArgs = new Object[] {uuid, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Actuacion actuacion : list) {
				if (!uuid.equals(actuacion.getUuid()) ||
					(companyId != actuacion.getCompanyId())) {

					list = null;

					break;
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

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActuacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	 * Returns the first actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the first actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Actuacion> orderByComparator) {

		List<Actuacion> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the last actuacion in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Actuacion> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Actuacion> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion[] findByUuid_C_PrevAndNext(
			long actuacionId, String uuid, long companyId,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		uuid = Objects.toString(uuid, "");

		Actuacion actuacion = findByPrimaryKey(actuacionId);

		Session session = null;

		try {
			session = openSession();

			Actuacion[] array = new ActuacionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, actuacion, uuid, companyId, orderByComparator, true);

			array[1] = actuacion;

			array[2] = getByUuid_C_PrevAndNext(
				session, actuacion, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Actuacion getByUuid_C_PrevAndNext(
		Session session, Actuacion actuacion, String uuid, long companyId,
		OrderByComparator<Actuacion> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ACTUACION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(ActuacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actuacion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Actuacion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actuacions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Actuacion actuacion :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(actuacion);
		}
	}

	/**
	 * Returns the number of actuacions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching actuacions
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"actuacion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(actuacion.uuid IS NULL OR actuacion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"actuacion.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the actuacions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching actuacions
	 */
	@Override
	public List<Actuacion> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Actuacion> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findByGroupId(groupId, start, end, orderByComparator);
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
	@Override
	public List<Actuacion> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGroupId;
			finderArgs = new Object[] {groupId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Actuacion actuacion : list) {
				if ((groupId != actuacion.getGroupId())) {
					list = null;

					break;
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

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActuacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	 * Returns the first actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByGroupId_First(
			long groupId, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByGroupId_First(groupId, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the first actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByGroupId_First(
		long groupId, OrderByComparator<Actuacion> orderByComparator) {

		List<Actuacion> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByGroupId_Last(
			long groupId, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByGroupId_Last(groupId, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the last actuacion in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByGroupId_Last(
		long groupId, OrderByComparator<Actuacion> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Actuacion> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion[] findByGroupId_PrevAndNext(
			long actuacionId, long groupId,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = findByPrimaryKey(actuacionId);

		Session session = null;

		try {
			session = openSession();

			Actuacion[] array = new ActuacionImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, actuacion, groupId, orderByComparator, true);

			array[1] = actuacion;

			array[2] = getByGroupId_PrevAndNext(
				session, actuacion, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Actuacion getByGroupId_PrevAndNext(
		Session session, Actuacion actuacion, long groupId,
		OrderByComparator<Actuacion> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTUACION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(ActuacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actuacion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Actuacion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actuacions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Actuacion actuacion :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(actuacion);
		}
	}

	/**
	 * Returns the number of actuacions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching actuacions
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"actuacion.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the actuacions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching actuacions
	 */
	@Override
	public List<Actuacion> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
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
	@Override
	public List<Actuacion> findByStatus(
		int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findByStatus(status, start, end, orderByComparator);
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
	@Override
	public List<Actuacion> findByStatus(
		int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByStatus;
			finderArgs = new Object[] {status};
		}
		else {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Actuacion actuacion : list) {
				if ((status != actuacion.getStatus())) {
					list = null;

					break;
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

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActuacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	 * Returns the first actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByStatus_First(
			int status, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByStatus_First(status, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the first actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByStatus_First(
		int status, OrderByComparator<Actuacion> orderByComparator) {

		List<Actuacion> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByStatus_Last(
			int status, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByStatus_Last(status, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the last actuacion in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByStatus_Last(
		int status, OrderByComparator<Actuacion> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Actuacion> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion[] findByStatus_PrevAndNext(
			long actuacionId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = findByPrimaryKey(actuacionId);

		Session session = null;

		try {
			session = openSession();

			Actuacion[] array = new ActuacionImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, actuacion, status, orderByComparator, true);

			array[1] = actuacion;

			array[2] = getByStatus_PrevAndNext(
				session, actuacion, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Actuacion getByStatus_PrevAndNext(
		Session session, Actuacion actuacion, int status,
		OrderByComparator<Actuacion> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTUACION_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(ActuacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actuacion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Actuacion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actuacions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (Actuacion actuacion :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(actuacion);
		}
	}

	/**
	 * Returns the number of actuacions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching actuacions
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"actuacion.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the actuacions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching actuacions
	 */
	@Override
	public List<Actuacion> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
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
	@Override
	public List<Actuacion> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findByG_S(groupId, status, start, end, orderByComparator);
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
	@Override
	public List<Actuacion> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByG_S;
			finderArgs = new Object[] {groupId, status};
		}
		else {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Actuacion actuacion : list) {
				if ((groupId != actuacion.getGroupId()) ||
					(status != actuacion.getStatus())) {

					list = null;

					break;
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

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActuacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	 * Returns the first actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByG_S_First(
			long groupId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the first actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<Actuacion> orderByComparator) {

		List<Actuacion> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion findByG_S_Last(
			long groupId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the last actuacion in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<Actuacion> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<Actuacion> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion[] findByG_S_PrevAndNext(
			long actuacionId, long groupId, int status,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = findByPrimaryKey(actuacionId);

		Session session = null;

		try {
			session = openSession();

			Actuacion[] array = new ActuacionImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, actuacion, groupId, status, orderByComparator, true);

			array[1] = actuacion;

			array[2] = getByG_S_PrevAndNext(
				session, actuacion, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Actuacion getByG_S_PrevAndNext(
		Session session, Actuacion actuacion, long groupId, int status,
		OrderByComparator<Actuacion> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ACTUACION_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

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
			query.append(ActuacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actuacion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Actuacion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actuacions where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (Actuacion actuacion :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(actuacion);
		}
	}

	/**
	 * Returns the number of actuacions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching actuacions
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"actuacion.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"actuacion.status = ?";

	private FinderPath _finderPathWithPaginationFindByPosicion;
	private FinderPath _finderPathWithoutPaginationFindByPosicion;
	private FinderPath _finderPathCountByPosicion;

	/**
	 * Returns all the actuacions where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @return the matching actuacions
	 */
	@Override
	public List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud) {

		return findByPosicion(
			longitud, latitud, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud, int start, int end) {

		return findByPosicion(longitud, latitud, start, end, null);
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
	@Override
	public List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findByPosicion(longitud, latitud, start, end, orderByComparator);
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
	@Override
	public List<Actuacion> findByPosicion(
		BigDecimal longitud, BigDecimal latitud, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByPosicion;
			finderArgs = new Object[] {longitud, latitud};
		}
		else {
			finderPath = _finderPathWithPaginationFindByPosicion;
			finderArgs = new Object[] {
				longitud, latitud, start, end, orderByComparator
			};
		}

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Actuacion actuacion : list) {
				if (!Objects.equals(longitud, actuacion.getLongitud()) ||
					!Objects.equals(latitud, actuacion.getLatitud())) {

					list = null;

					break;
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

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			boolean bindLongitud = false;

			if (longitud == null) {
				query.append(_FINDER_COLUMN_POSICION_LONGITUD_1);
			}
			else {
				bindLongitud = true;

				query.append(_FINDER_COLUMN_POSICION_LONGITUD_2);
			}

			boolean bindLatitud = false;

			if (latitud == null) {
				query.append(_FINDER_COLUMN_POSICION_LATITUD_1);
			}
			else {
				bindLatitud = true;

				query.append(_FINDER_COLUMN_POSICION_LATITUD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActuacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLongitud) {
					qPos.add(longitud);
				}

				if (bindLatitud) {
					qPos.add(latitud);
				}

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	 * Returns the first actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByPosicion_First(
			BigDecimal longitud, BigDecimal latitud,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByPosicion_First(
			longitud, latitud, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("longitud=");
		msg.append(longitud);

		msg.append(", latitud=");
		msg.append(latitud);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the first actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByPosicion_First(
		BigDecimal longitud, BigDecimal latitud,
		OrderByComparator<Actuacion> orderByComparator) {

		List<Actuacion> list = findByPosicion(
			longitud, latitud, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion findByPosicion_Last(
			BigDecimal longitud, BigDecimal latitud,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByPosicion_Last(
			longitud, latitud, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("longitud=");
		msg.append(longitud);

		msg.append(", latitud=");
		msg.append(latitud);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the last actuacion in the ordered set where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByPosicion_Last(
		BigDecimal longitud, BigDecimal latitud,
		OrderByComparator<Actuacion> orderByComparator) {

		int count = countByPosicion(longitud, latitud);

		if (count == 0) {
			return null;
		}

		List<Actuacion> list = findByPosicion(
			longitud, latitud, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion[] findByPosicion_PrevAndNext(
			long actuacionId, BigDecimal longitud, BigDecimal latitud,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = findByPrimaryKey(actuacionId);

		Session session = null;

		try {
			session = openSession();

			Actuacion[] array = new ActuacionImpl[3];

			array[0] = getByPosicion_PrevAndNext(
				session, actuacion, longitud, latitud, orderByComparator, true);

			array[1] = actuacion;

			array[2] = getByPosicion_PrevAndNext(
				session, actuacion, longitud, latitud, orderByComparator,
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

	protected Actuacion getByPosicion_PrevAndNext(
		Session session, Actuacion actuacion, BigDecimal longitud,
		BigDecimal latitud, OrderByComparator<Actuacion> orderByComparator,
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

		query.append(_SQL_SELECT_ACTUACION_WHERE);

		boolean bindLongitud = false;

		if (longitud == null) {
			query.append(_FINDER_COLUMN_POSICION_LONGITUD_1);
		}
		else {
			bindLongitud = true;

			query.append(_FINDER_COLUMN_POSICION_LONGITUD_2);
		}

		boolean bindLatitud = false;

		if (latitud == null) {
			query.append(_FINDER_COLUMN_POSICION_LATITUD_1);
		}
		else {
			bindLatitud = true;

			query.append(_FINDER_COLUMN_POSICION_LATITUD_2);
		}

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
			query.append(ActuacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLongitud) {
			qPos.add(longitud);
		}

		if (bindLatitud) {
			qPos.add(latitud);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actuacion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Actuacion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actuacions where longitud = &#63; and latitud = &#63; from the database.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 */
	@Override
	public void removeByPosicion(BigDecimal longitud, BigDecimal latitud) {
		for (Actuacion actuacion :
				findByPosicion(
					longitud, latitud, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(actuacion);
		}
	}

	/**
	 * Returns the number of actuacions where longitud = &#63; and latitud = &#63;.
	 *
	 * @param longitud the longitud
	 * @param latitud the latitud
	 * @return the number of matching actuacions
	 */
	@Override
	public int countByPosicion(BigDecimal longitud, BigDecimal latitud) {
		FinderPath finderPath = _finderPathCountByPosicion;

		Object[] finderArgs = new Object[] {longitud, latitud};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			boolean bindLongitud = false;

			if (longitud == null) {
				query.append(_FINDER_COLUMN_POSICION_LONGITUD_1);
			}
			else {
				bindLongitud = true;

				query.append(_FINDER_COLUMN_POSICION_LONGITUD_2);
			}

			boolean bindLatitud = false;

			if (latitud == null) {
				query.append(_FINDER_COLUMN_POSICION_LATITUD_1);
			}
			else {
				bindLatitud = true;

				query.append(_FINDER_COLUMN_POSICION_LATITUD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLongitud) {
					qPos.add(longitud);
				}

				if (bindLatitud) {
					qPos.add(latitud);
				}

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

	private static final String _FINDER_COLUMN_POSICION_LONGITUD_1 =
		"actuacion.longitud IS NULL AND ";

	private static final String _FINDER_COLUMN_POSICION_LONGITUD_2 =
		"actuacion.longitud = ? AND ";

	private static final String _FINDER_COLUMN_POSICION_LATITUD_1 =
		"actuacion.latitud IS NULL";

	private static final String _FINDER_COLUMN_POSICION_LATITUD_2 =
		"actuacion.latitud = ?";

	private FinderPath _finderPathWithPaginationFindByCodTecnico;
	private FinderPath _finderPathWithoutPaginationFindByCodTecnico;
	private FinderPath _finderPathCountByCodTecnico;

	/**
	 * Returns all the actuacions where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @return the matching actuacions
	 */
	@Override
	public List<Actuacion> findByCodTecnico(long codTecnico) {
		return findByCodTecnico(
			codTecnico, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findByCodTecnico(
		long codTecnico, int start, int end) {

		return findByCodTecnico(codTecnico, start, end, null);
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
	@Override
	public List<Actuacion> findByCodTecnico(
		long codTecnico, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findByCodTecnico(codTecnico, start, end, orderByComparator);
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
	@Override
	public List<Actuacion> findByCodTecnico(
		long codTecnico, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCodTecnico;
			finderArgs = new Object[] {codTecnico};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCodTecnico;
			finderArgs = new Object[] {
				codTecnico, start, end, orderByComparator
			};
		}

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Actuacion actuacion : list) {
				if ((codTecnico != actuacion.getCodTecnico())) {
					list = null;

					break;
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

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			query.append(_FINDER_COLUMN_CODTECNICO_CODTECNICO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActuacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(codTecnico);

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	 * Returns the first actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByCodTecnico_First(
			long codTecnico, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByCodTecnico_First(
			codTecnico, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("codTecnico=");
		msg.append(codTecnico);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the first actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByCodTecnico_First(
		long codTecnico, OrderByComparator<Actuacion> orderByComparator) {

		List<Actuacion> list = findByCodTecnico(
			codTecnico, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByCodTecnico_Last(
			long codTecnico, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByCodTecnico_Last(
			codTecnico, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("codTecnico=");
		msg.append(codTecnico);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the last actuacion in the ordered set where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByCodTecnico_Last(
		long codTecnico, OrderByComparator<Actuacion> orderByComparator) {

		int count = countByCodTecnico(codTecnico);

		if (count == 0) {
			return null;
		}

		List<Actuacion> list = findByCodTecnico(
			codTecnico, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion[] findByCodTecnico_PrevAndNext(
			long actuacionId, long codTecnico,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = findByPrimaryKey(actuacionId);

		Session session = null;

		try {
			session = openSession();

			Actuacion[] array = new ActuacionImpl[3];

			array[0] = getByCodTecnico_PrevAndNext(
				session, actuacion, codTecnico, orderByComparator, true);

			array[1] = actuacion;

			array[2] = getByCodTecnico_PrevAndNext(
				session, actuacion, codTecnico, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Actuacion getByCodTecnico_PrevAndNext(
		Session session, Actuacion actuacion, long codTecnico,
		OrderByComparator<Actuacion> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTUACION_WHERE);

		query.append(_FINDER_COLUMN_CODTECNICO_CODTECNICO_2);

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
			query.append(ActuacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(codTecnico);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actuacion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Actuacion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actuacions where codTecnico = &#63; from the database.
	 *
	 * @param codTecnico the cod tecnico
	 */
	@Override
	public void removeByCodTecnico(long codTecnico) {
		for (Actuacion actuacion :
				findByCodTecnico(
					codTecnico, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(actuacion);
		}
	}

	/**
	 * Returns the number of actuacions where codTecnico = &#63;.
	 *
	 * @param codTecnico the cod tecnico
	 * @return the number of matching actuacions
	 */
	@Override
	public int countByCodTecnico(long codTecnico) {
		FinderPath finderPath = _finderPathCountByCodTecnico;

		Object[] finderArgs = new Object[] {codTecnico};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			query.append(_FINDER_COLUMN_CODTECNICO_CODTECNICO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(codTecnico);

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

	private static final String _FINDER_COLUMN_CODTECNICO_CODTECNICO_2 =
		"actuacion.codTecnico = ?";

	private FinderPath _finderPathWithPaginationFindByNombre;
	private FinderPath _finderPathWithoutPaginationFindByNombre;
	private FinderPath _finderPathCountByNombre;

	/**
	 * Returns all the actuacions where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching actuacions
	 */
	@Override
	public List<Actuacion> findByNombre(String nombre) {
		return findByNombre(nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findByNombre(String nombre, int start, int end) {
		return findByNombre(nombre, start, end, null);
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
	@Override
	public List<Actuacion> findByNombre(
		String nombre, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findByNombre(nombre, start, end, orderByComparator);
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
	@Override
	public List<Actuacion> findByNombre(
		String nombre, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		nombre = Objects.toString(nombre, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNombre;
			finderArgs = new Object[] {nombre};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNombre;
			finderArgs = new Object[] {nombre, start, end, orderByComparator};
		}

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Actuacion actuacion : list) {
				if (!nombre.equals(actuacion.getNombre())) {
					list = null;

					break;
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

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			boolean bindNombre = false;

			if (nombre.isEmpty()) {
				query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_3);
			}
			else {
				bindNombre = true;

				query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActuacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNombre) {
					qPos.add(nombre);
				}

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	 * Returns the first actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByNombre_First(
			String nombre, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByNombre_First(nombre, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nombre=");
		msg.append(nombre);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the first actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByNombre_First(
		String nombre, OrderByComparator<Actuacion> orderByComparator) {

		List<Actuacion> list = findByNombre(nombre, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByNombre_Last(
			String nombre, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByNombre_Last(nombre, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nombre=");
		msg.append(nombre);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the last actuacion in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByNombre_Last(
		String nombre, OrderByComparator<Actuacion> orderByComparator) {

		int count = countByNombre(nombre);

		if (count == 0) {
			return null;
		}

		List<Actuacion> list = findByNombre(
			nombre, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion[] findByNombre_PrevAndNext(
			long actuacionId, String nombre,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		nombre = Objects.toString(nombre, "");

		Actuacion actuacion = findByPrimaryKey(actuacionId);

		Session session = null;

		try {
			session = openSession();

			Actuacion[] array = new ActuacionImpl[3];

			array[0] = getByNombre_PrevAndNext(
				session, actuacion, nombre, orderByComparator, true);

			array[1] = actuacion;

			array[2] = getByNombre_PrevAndNext(
				session, actuacion, nombre, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Actuacion getByNombre_PrevAndNext(
		Session session, Actuacion actuacion, String nombre,
		OrderByComparator<Actuacion> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTUACION_WHERE);

		boolean bindNombre = false;

		if (nombre.isEmpty()) {
			query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_3);
		}
		else {
			bindNombre = true;

			query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_2);
		}

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
			query.append(ActuacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNombre) {
			qPos.add(nombre);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actuacion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Actuacion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actuacions where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	@Override
	public void removeByNombre(String nombre) {
		for (Actuacion actuacion :
				findByNombre(
					nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(actuacion);
		}
	}

	/**
	 * Returns the number of actuacions where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching actuacions
	 */
	@Override
	public int countByNombre(String nombre) {
		nombre = Objects.toString(nombre, "");

		FinderPath finderPath = _finderPathCountByNombre;

		Object[] finderArgs = new Object[] {nombre};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			boolean bindNombre = false;

			if (nombre.isEmpty()) {
				query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_3);
			}
			else {
				bindNombre = true;

				query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNombre) {
					qPos.add(nombre);
				}

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

	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_2 =
		"actuacion.nombre = ?";

	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_3 =
		"(actuacion.nombre IS NULL OR actuacion.nombre = '')";

	private FinderPath _finderPathWithPaginationFindByCA;
	private FinderPath _finderPathWithoutPaginationFindByCA;
	private FinderPath _finderPathCountByCA;

	/**
	 * Returns all the actuacions where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @return the matching actuacions
	 */
	@Override
	public List<Actuacion> findByCA(String comunidadAutonoma) {
		return findByCA(
			comunidadAutonoma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findByCA(
		String comunidadAutonoma, int start, int end) {

		return findByCA(comunidadAutonoma, start, end, null);
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
	@Override
	public List<Actuacion> findByCA(
		String comunidadAutonoma, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findByCA(comunidadAutonoma, start, end, orderByComparator);
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
	@Override
	public List<Actuacion> findByCA(
		String comunidadAutonoma, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		comunidadAutonoma = Objects.toString(comunidadAutonoma, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCA;
			finderArgs = new Object[] {comunidadAutonoma};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCA;
			finderArgs = new Object[] {
				comunidadAutonoma, start, end, orderByComparator
			};
		}

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Actuacion actuacion : list) {
				if (!comunidadAutonoma.equals(
						actuacion.getComunidadAutonoma())) {

					list = null;

					break;
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

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			boolean bindComunidadAutonoma = false;

			if (comunidadAutonoma.isEmpty()) {
				query.append(_FINDER_COLUMN_CA_COMUNIDADAUTONOMA_3);
			}
			else {
				bindComunidadAutonoma = true;

				query.append(_FINDER_COLUMN_CA_COMUNIDADAUTONOMA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActuacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComunidadAutonoma) {
					qPos.add(comunidadAutonoma);
				}

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	 * Returns the first actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByCA_First(
			String comunidadAutonoma,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByCA_First(
			comunidadAutonoma, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("comunidadAutonoma=");
		msg.append(comunidadAutonoma);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the first actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByCA_First(
		String comunidadAutonoma,
		OrderByComparator<Actuacion> orderByComparator) {

		List<Actuacion> list = findByCA(
			comunidadAutonoma, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByCA_Last(
			String comunidadAutonoma,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByCA_Last(
			comunidadAutonoma, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("comunidadAutonoma=");
		msg.append(comunidadAutonoma);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the last actuacion in the ordered set where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByCA_Last(
		String comunidadAutonoma,
		OrderByComparator<Actuacion> orderByComparator) {

		int count = countByCA(comunidadAutonoma);

		if (count == 0) {
			return null;
		}

		List<Actuacion> list = findByCA(
			comunidadAutonoma, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion[] findByCA_PrevAndNext(
			long actuacionId, String comunidadAutonoma,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		comunidadAutonoma = Objects.toString(comunidadAutonoma, "");

		Actuacion actuacion = findByPrimaryKey(actuacionId);

		Session session = null;

		try {
			session = openSession();

			Actuacion[] array = new ActuacionImpl[3];

			array[0] = getByCA_PrevAndNext(
				session, actuacion, comunidadAutonoma, orderByComparator, true);

			array[1] = actuacion;

			array[2] = getByCA_PrevAndNext(
				session, actuacion, comunidadAutonoma, orderByComparator,
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

	protected Actuacion getByCA_PrevAndNext(
		Session session, Actuacion actuacion, String comunidadAutonoma,
		OrderByComparator<Actuacion> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTUACION_WHERE);

		boolean bindComunidadAutonoma = false;

		if (comunidadAutonoma.isEmpty()) {
			query.append(_FINDER_COLUMN_CA_COMUNIDADAUTONOMA_3);
		}
		else {
			bindComunidadAutonoma = true;

			query.append(_FINDER_COLUMN_CA_COMUNIDADAUTONOMA_2);
		}

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
			query.append(ActuacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindComunidadAutonoma) {
			qPos.add(comunidadAutonoma);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actuacion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Actuacion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actuacions where comunidadAutonoma = &#63; from the database.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 */
	@Override
	public void removeByCA(String comunidadAutonoma) {
		for (Actuacion actuacion :
				findByCA(
					comunidadAutonoma, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(actuacion);
		}
	}

	/**
	 * Returns the number of actuacions where comunidadAutonoma = &#63;.
	 *
	 * @param comunidadAutonoma the comunidad autonoma
	 * @return the number of matching actuacions
	 */
	@Override
	public int countByCA(String comunidadAutonoma) {
		comunidadAutonoma = Objects.toString(comunidadAutonoma, "");

		FinderPath finderPath = _finderPathCountByCA;

		Object[] finderArgs = new Object[] {comunidadAutonoma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			boolean bindComunidadAutonoma = false;

			if (comunidadAutonoma.isEmpty()) {
				query.append(_FINDER_COLUMN_CA_COMUNIDADAUTONOMA_3);
			}
			else {
				bindComunidadAutonoma = true;

				query.append(_FINDER_COLUMN_CA_COMUNIDADAUTONOMA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComunidadAutonoma) {
					qPos.add(comunidadAutonoma);
				}

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

	private static final String _FINDER_COLUMN_CA_COMUNIDADAUTONOMA_2 =
		"actuacion.comunidadAutonoma = ?";

	private static final String _FINDER_COLUMN_CA_COMUNIDADAUTONOMA_3 =
		"(actuacion.comunidadAutonoma IS NULL OR actuacion.comunidadAutonoma = '')";

	private FinderPath _finderPathWithPaginationFindByProvincia;
	private FinderPath _finderPathWithoutPaginationFindByProvincia;
	private FinderPath _finderPathCountByProvincia;

	/**
	 * Returns all the actuacions where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @return the matching actuacions
	 */
	@Override
	public List<Actuacion> findByProvincia(String provincia) {
		return findByProvincia(
			provincia, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findByProvincia(
		String provincia, int start, int end) {

		return findByProvincia(provincia, start, end, null);
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
	@Override
	public List<Actuacion> findByProvincia(
		String provincia, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findByProvincia(provincia, start, end, orderByComparator);
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
	@Override
	public List<Actuacion> findByProvincia(
		String provincia, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		provincia = Objects.toString(provincia, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByProvincia;
			finderArgs = new Object[] {provincia};
		}
		else {
			finderPath = _finderPathWithPaginationFindByProvincia;
			finderArgs = new Object[] {
				provincia, start, end, orderByComparator
			};
		}

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Actuacion actuacion : list) {
				if (!provincia.equals(actuacion.getProvincia())) {
					list = null;

					break;
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

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			boolean bindProvincia = false;

			if (provincia.isEmpty()) {
				query.append(_FINDER_COLUMN_PROVINCIA_PROVINCIA_3);
			}
			else {
				bindProvincia = true;

				query.append(_FINDER_COLUMN_PROVINCIA_PROVINCIA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActuacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProvincia) {
					qPos.add(provincia);
				}

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	 * Returns the first actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByProvincia_First(
			String provincia, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByProvincia_First(
			provincia, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provincia=");
		msg.append(provincia);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the first actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByProvincia_First(
		String provincia, OrderByComparator<Actuacion> orderByComparator) {

		List<Actuacion> list = findByProvincia(
			provincia, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion
	 * @throws NoSuchActuacionException if a matching actuacion could not be found
	 */
	@Override
	public Actuacion findByProvincia_Last(
			String provincia, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByProvincia_Last(
			provincia, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provincia=");
		msg.append(provincia);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
	}

	/**
	 * Returns the last actuacion in the ordered set where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public Actuacion fetchByProvincia_Last(
		String provincia, OrderByComparator<Actuacion> orderByComparator) {

		int count = countByProvincia(provincia);

		if (count == 0) {
			return null;
		}

		List<Actuacion> list = findByProvincia(
			provincia, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion[] findByProvincia_PrevAndNext(
			long actuacionId, String provincia,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		provincia = Objects.toString(provincia, "");

		Actuacion actuacion = findByPrimaryKey(actuacionId);

		Session session = null;

		try {
			session = openSession();

			Actuacion[] array = new ActuacionImpl[3];

			array[0] = getByProvincia_PrevAndNext(
				session, actuacion, provincia, orderByComparator, true);

			array[1] = actuacion;

			array[2] = getByProvincia_PrevAndNext(
				session, actuacion, provincia, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Actuacion getByProvincia_PrevAndNext(
		Session session, Actuacion actuacion, String provincia,
		OrderByComparator<Actuacion> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTUACION_WHERE);

		boolean bindProvincia = false;

		if (provincia.isEmpty()) {
			query.append(_FINDER_COLUMN_PROVINCIA_PROVINCIA_3);
		}
		else {
			bindProvincia = true;

			query.append(_FINDER_COLUMN_PROVINCIA_PROVINCIA_2);
		}

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
			query.append(ActuacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindProvincia) {
			qPos.add(provincia);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actuacion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Actuacion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actuacions where provincia = &#63; from the database.
	 *
	 * @param provincia the provincia
	 */
	@Override
	public void removeByProvincia(String provincia) {
		for (Actuacion actuacion :
				findByProvincia(
					provincia, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(actuacion);
		}
	}

	/**
	 * Returns the number of actuacions where provincia = &#63;.
	 *
	 * @param provincia the provincia
	 * @return the number of matching actuacions
	 */
	@Override
	public int countByProvincia(String provincia) {
		provincia = Objects.toString(provincia, "");

		FinderPath finderPath = _finderPathCountByProvincia;

		Object[] finderArgs = new Object[] {provincia};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			boolean bindProvincia = false;

			if (provincia.isEmpty()) {
				query.append(_FINDER_COLUMN_PROVINCIA_PROVINCIA_3);
			}
			else {
				bindProvincia = true;

				query.append(_FINDER_COLUMN_PROVINCIA_PROVINCIA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProvincia) {
					qPos.add(provincia);
				}

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

	private static final String _FINDER_COLUMN_PROVINCIA_PROVINCIA_2 =
		"actuacion.provincia = ?";

	private static final String _FINDER_COLUMN_PROVINCIA_PROVINCIA_3 =
		"(actuacion.provincia IS NULL OR actuacion.provincia = '')";

	private FinderPath
		_finderPathWithPaginationFindByTituloComAutProvinciaSituacion;
	private FinderPath
		_finderPathWithoutPaginationFindByTituloComAutProvinciaSituacion;
	private FinderPath _finderPathCountByTituloComAutProvinciaSituacion;

	/**
	 * Returns all the actuacions where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63;.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 * @return the matching actuacions
	 */
	@Override
	public List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion) {

		return findByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, int start, int end) {

		return findByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion, start, end, null);
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
	@Override
	public List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, int start, int end,
		OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion, start, end,
			orderByComparator);
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
	@Override
	public List<Actuacion> findByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, int start, int end,
		OrderByComparator<Actuacion> orderByComparator) {

		nombre = Objects.toString(nombre, "");
		comunidadAutonoma = Objects.toString(comunidadAutonoma, "");
		provincia = Objects.toString(provincia, "");
		situacion = Objects.toString(situacion, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByTituloComAutProvinciaSituacion;
			finderArgs = new Object[] {
				nombre, comunidadAutonoma, provincia, situacion
			};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByTituloComAutProvinciaSituacion;
			finderArgs = new Object[] {
				nombre, comunidadAutonoma, provincia, situacion, start, end,
				orderByComparator
			};
		}

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Actuacion actuacion : list) {
				if (!nombre.equals(actuacion.getNombre()) ||
					!comunidadAutonoma.equals(
						actuacion.getComunidadAutonoma()) ||
					!provincia.equals(actuacion.getProvincia()) ||
					!situacion.equals(actuacion.getSituacion())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_ACTUACION_WHERE);

			boolean bindNombre = false;

			if (nombre.isEmpty()) {
				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_NOMBRE_3);
			}
			else {
				bindNombre = true;

				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_NOMBRE_2);
			}

			boolean bindComunidadAutonoma = false;

			if (comunidadAutonoma.isEmpty()) {
				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_COMUNIDADAUTONOMA_3);
			}
			else {
				bindComunidadAutonoma = true;

				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_COMUNIDADAUTONOMA_2);
			}

			boolean bindProvincia = false;

			if (provincia.isEmpty()) {
				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_PROVINCIA_3);
			}
			else {
				bindProvincia = true;

				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_PROVINCIA_2);
			}

			boolean bindSituacion = false;

			if (situacion.isEmpty()) {
				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_SITUACION_3);
			}
			else {
				bindSituacion = true;

				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_SITUACION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActuacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNombre) {
					qPos.add(nombre);
				}

				if (bindComunidadAutonoma) {
					qPos.add(comunidadAutonoma);
				}

				if (bindProvincia) {
					qPos.add(provincia);
				}

				if (bindSituacion) {
					qPos.add(situacion);
				}

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	@Override
	public Actuacion findByTituloComAutProvinciaSituacion_First(
			String nombre, String comunidadAutonoma, String provincia,
			String situacion, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByTituloComAutProvinciaSituacion_First(
			nombre, comunidadAutonoma, provincia, situacion, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nombre=");
		msg.append(nombre);

		msg.append(", comunidadAutonoma=");
		msg.append(comunidadAutonoma);

		msg.append(", provincia=");
		msg.append(provincia);

		msg.append(", situacion=");
		msg.append(situacion);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
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
	@Override
	public Actuacion fetchByTituloComAutProvinciaSituacion_First(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, OrderByComparator<Actuacion> orderByComparator) {

		List<Actuacion> list = findByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion findByTituloComAutProvinciaSituacion_Last(
			String nombre, String comunidadAutonoma, String provincia,
			String situacion, OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByTituloComAutProvinciaSituacion_Last(
			nombre, comunidadAutonoma, provincia, situacion, orderByComparator);

		if (actuacion != null) {
			return actuacion;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nombre=");
		msg.append(nombre);

		msg.append(", comunidadAutonoma=");
		msg.append(comunidadAutonoma);

		msg.append(", provincia=");
		msg.append(provincia);

		msg.append(", situacion=");
		msg.append(situacion);

		msg.append("}");

		throw new NoSuchActuacionException(msg.toString());
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
	@Override
	public Actuacion fetchByTituloComAutProvinciaSituacion_Last(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion, OrderByComparator<Actuacion> orderByComparator) {

		int count = countByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion);

		if (count == 0) {
			return null;
		}

		List<Actuacion> list = findByTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Actuacion[] findByTituloComAutProvinciaSituacion_PrevAndNext(
			long actuacionId, String nombre, String comunidadAutonoma,
			String provincia, String situacion,
			OrderByComparator<Actuacion> orderByComparator)
		throws NoSuchActuacionException {

		nombre = Objects.toString(nombre, "");
		comunidadAutonoma = Objects.toString(comunidadAutonoma, "");
		provincia = Objects.toString(provincia, "");
		situacion = Objects.toString(situacion, "");

		Actuacion actuacion = findByPrimaryKey(actuacionId);

		Session session = null;

		try {
			session = openSession();

			Actuacion[] array = new ActuacionImpl[3];

			array[0] = getByTituloComAutProvinciaSituacion_PrevAndNext(
				session, actuacion, nombre, comunidadAutonoma, provincia,
				situacion, orderByComparator, true);

			array[1] = actuacion;

			array[2] = getByTituloComAutProvinciaSituacion_PrevAndNext(
				session, actuacion, nombre, comunidadAutonoma, provincia,
				situacion, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Actuacion getByTituloComAutProvinciaSituacion_PrevAndNext(
		Session session, Actuacion actuacion, String nombre,
		String comunidadAutonoma, String provincia, String situacion,
		OrderByComparator<Actuacion> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_ACTUACION_WHERE);

		boolean bindNombre = false;

		if (nombre.isEmpty()) {
			query.append(
				_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_NOMBRE_3);
		}
		else {
			bindNombre = true;

			query.append(
				_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_NOMBRE_2);
		}

		boolean bindComunidadAutonoma = false;

		if (comunidadAutonoma.isEmpty()) {
			query.append(
				_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_COMUNIDADAUTONOMA_3);
		}
		else {
			bindComunidadAutonoma = true;

			query.append(
				_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_COMUNIDADAUTONOMA_2);
		}

		boolean bindProvincia = false;

		if (provincia.isEmpty()) {
			query.append(
				_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_PROVINCIA_3);
		}
		else {
			bindProvincia = true;

			query.append(
				_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_PROVINCIA_2);
		}

		boolean bindSituacion = false;

		if (situacion.isEmpty()) {
			query.append(
				_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_SITUACION_3);
		}
		else {
			bindSituacion = true;

			query.append(
				_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_SITUACION_2);
		}

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
			query.append(ActuacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNombre) {
			qPos.add(nombre);
		}

		if (bindComunidadAutonoma) {
			qPos.add(comunidadAutonoma);
		}

		if (bindProvincia) {
			qPos.add(provincia);
		}

		if (bindSituacion) {
			qPos.add(situacion);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actuacion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Actuacion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actuacions where nombre = &#63; and comunidadAutonoma = &#63; and provincia = &#63; and situacion = &#63; from the database.
	 *
	 * @param nombre the nombre
	 * @param comunidadAutonoma the comunidad autonoma
	 * @param provincia the provincia
	 * @param situacion the situacion
	 */
	@Override
	public void removeByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion) {

		for (Actuacion actuacion :
				findByTituloComAutProvinciaSituacion(
					nombre, comunidadAutonoma, provincia, situacion,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(actuacion);
		}
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
	@Override
	public int countByTituloComAutProvinciaSituacion(
		String nombre, String comunidadAutonoma, String provincia,
		String situacion) {

		nombre = Objects.toString(nombre, "");
		comunidadAutonoma = Objects.toString(comunidadAutonoma, "");
		provincia = Objects.toString(provincia, "");
		situacion = Objects.toString(situacion, "");

		FinderPath finderPath =
			_finderPathCountByTituloComAutProvinciaSituacion;

		Object[] finderArgs = new Object[] {
			nombre, comunidadAutonoma, provincia, situacion
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_ACTUACION_WHERE);

			boolean bindNombre = false;

			if (nombre.isEmpty()) {
				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_NOMBRE_3);
			}
			else {
				bindNombre = true;

				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_NOMBRE_2);
			}

			boolean bindComunidadAutonoma = false;

			if (comunidadAutonoma.isEmpty()) {
				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_COMUNIDADAUTONOMA_3);
			}
			else {
				bindComunidadAutonoma = true;

				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_COMUNIDADAUTONOMA_2);
			}

			boolean bindProvincia = false;

			if (provincia.isEmpty()) {
				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_PROVINCIA_3);
			}
			else {
				bindProvincia = true;

				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_PROVINCIA_2);
			}

			boolean bindSituacion = false;

			if (situacion.isEmpty()) {
				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_SITUACION_3);
			}
			else {
				bindSituacion = true;

				query.append(
					_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_SITUACION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNombre) {
					qPos.add(nombre);
				}

				if (bindComunidadAutonoma) {
					qPos.add(comunidadAutonoma);
				}

				if (bindProvincia) {
					qPos.add(provincia);
				}

				if (bindSituacion) {
					qPos.add(situacion);
				}

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
		_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_NOMBRE_2 =
			"actuacion.nombre = ? AND ";

	private static final String
		_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_NOMBRE_3 =
			"(actuacion.nombre IS NULL OR actuacion.nombre = '') AND ";

	private static final String
		_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_COMUNIDADAUTONOMA_2 =
			"actuacion.comunidadAutonoma = ? AND ";

	private static final String
		_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_COMUNIDADAUTONOMA_3 =
			"(actuacion.comunidadAutonoma IS NULL OR actuacion.comunidadAutonoma = '') AND ";

	private static final String
		_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_PROVINCIA_2 =
			"actuacion.provincia = ? AND ";

	private static final String
		_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_PROVINCIA_3 =
			"(actuacion.provincia IS NULL OR actuacion.provincia = '') AND ";

	private static final String
		_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_SITUACION_2 =
			"actuacion.situacion = ?";

	private static final String
		_FINDER_COLUMN_TITULOCOMAUTPROVINCIASITUACION_SITUACION_3 =
			"(actuacion.situacion IS NULL OR actuacion.situacion = '')";

	public ActuacionPersistenceImpl() {
		setModelClass(Actuacion.class);

		setModelImplClass(ActuacionImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the actuacion in the entity cache if it is enabled.
	 *
	 * @param actuacion the actuacion
	 */
	@Override
	public void cacheResult(Actuacion actuacion) {
		entityCache.putResult(
			entityCacheEnabled, ActuacionImpl.class, actuacion.getPrimaryKey(),
			actuacion);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {actuacion.getUuid(), actuacion.getGroupId()},
			actuacion);

		actuacion.resetOriginalValues();
	}

	/**
	 * Caches the actuacions in the entity cache if it is enabled.
	 *
	 * @param actuacions the actuacions
	 */
	@Override
	public void cacheResult(List<Actuacion> actuacions) {
		for (Actuacion actuacion : actuacions) {
			if (entityCache.getResult(
					entityCacheEnabled, ActuacionImpl.class,
					actuacion.getPrimaryKey()) == null) {

				cacheResult(actuacion);
			}
			else {
				actuacion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all actuacions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ActuacionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the actuacion.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Actuacion actuacion) {
		entityCache.removeResult(
			entityCacheEnabled, ActuacionImpl.class, actuacion.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ActuacionModelImpl)actuacion, true);
	}

	@Override
	public void clearCache(List<Actuacion> actuacions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Actuacion actuacion : actuacions) {
			entityCache.removeResult(
				entityCacheEnabled, ActuacionImpl.class,
				actuacion.getPrimaryKey());

			clearUniqueFindersCache((ActuacionModelImpl)actuacion, true);
		}
	}

	protected void cacheUniqueFindersCache(
		ActuacionModelImpl actuacionModelImpl) {

		Object[] args = new Object[] {
			actuacionModelImpl.getUuid(), actuacionModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, actuacionModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ActuacionModelImpl actuacionModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				actuacionModelImpl.getUuid(), actuacionModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((actuacionModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				actuacionModelImpl.getOriginalUuid(),
				actuacionModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new actuacion with the primary key. Does not add the actuacion to the database.
	 *
	 * @param actuacionId the primary key for the new actuacion
	 * @return the new actuacion
	 */
	@Override
	public Actuacion create(long actuacionId) {
		Actuacion actuacion = new ActuacionImpl();

		actuacion.setNew(true);
		actuacion.setPrimaryKey(actuacionId);

		String uuid = PortalUUIDUtil.generate();

		actuacion.setUuid(uuid);

		actuacion.setCompanyId(CompanyThreadLocal.getCompanyId());

		return actuacion;
	}

	/**
	 * Removes the actuacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion that was removed
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	@Override
	public Actuacion remove(long actuacionId) throws NoSuchActuacionException {
		return remove((Serializable)actuacionId);
	}

	/**
	 * Removes the actuacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the actuacion
	 * @return the actuacion that was removed
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	@Override
	public Actuacion remove(Serializable primaryKey)
		throws NoSuchActuacionException {

		Session session = null;

		try {
			session = openSession();

			Actuacion actuacion = (Actuacion)session.get(
				ActuacionImpl.class, primaryKey);

			if (actuacion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActuacionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(actuacion);
		}
		catch (NoSuchActuacionException nsee) {
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
	protected Actuacion removeImpl(Actuacion actuacion) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(actuacion)) {
				actuacion = (Actuacion)session.get(
					ActuacionImpl.class, actuacion.getPrimaryKeyObj());
			}

			if (actuacion != null) {
				session.delete(actuacion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (actuacion != null) {
			clearCache(actuacion);
		}

		return actuacion;
	}

	@Override
	public Actuacion updateImpl(Actuacion actuacion) {
		boolean isNew = actuacion.isNew();

		if (!(actuacion instanceof ActuacionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(actuacion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(actuacion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in actuacion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Actuacion implementation " +
					actuacion.getClass());
		}

		ActuacionModelImpl actuacionModelImpl = (ActuacionModelImpl)actuacion;

		if (Validator.isNull(actuacion.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			actuacion.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (actuacion.getCreateDate() == null)) {
			if (serviceContext == null) {
				actuacion.setCreateDate(now);
			}
			else {
				actuacion.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!actuacionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				actuacion.setModifiedDate(now);
			}
			else {
				actuacion.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (actuacion.isNew()) {
				session.save(actuacion);

				actuacion.setNew(false);
			}
			else {
				actuacion = (Actuacion)session.merge(actuacion);
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
			Object[] args = new Object[] {actuacionModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				actuacionModelImpl.getUuid(), actuacionModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {actuacionModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {actuacionModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			args = new Object[] {
				actuacionModelImpl.getGroupId(), actuacionModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_S, args);

			args = new Object[] {
				actuacionModelImpl.getLongitud(),
				actuacionModelImpl.getLatitud()
			};

			finderCache.removeResult(_finderPathCountByPosicion, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPosicion, args);

			args = new Object[] {actuacionModelImpl.getCodTecnico()};

			finderCache.removeResult(_finderPathCountByCodTecnico, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCodTecnico, args);

			args = new Object[] {actuacionModelImpl.getNombre()};

			finderCache.removeResult(_finderPathCountByNombre, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNombre, args);

			args = new Object[] {actuacionModelImpl.getComunidadAutonoma()};

			finderCache.removeResult(_finderPathCountByCA, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCA, args);

			args = new Object[] {actuacionModelImpl.getProvincia()};

			finderCache.removeResult(_finderPathCountByProvincia, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByProvincia, args);

			args = new Object[] {
				actuacionModelImpl.getNombre(),
				actuacionModelImpl.getComunidadAutonoma(),
				actuacionModelImpl.getProvincia(),
				actuacionModelImpl.getSituacion()
			};

			finderCache.removeResult(
				_finderPathCountByTituloComAutProvinciaSituacion, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTituloComAutProvinciaSituacion,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((actuacionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					actuacionModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {actuacionModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((actuacionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					actuacionModelImpl.getOriginalUuid(),
					actuacionModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					actuacionModelImpl.getUuid(),
					actuacionModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((actuacionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					actuacionModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {actuacionModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((actuacionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					actuacionModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {actuacionModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}

			if ((actuacionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					actuacionModelImpl.getOriginalGroupId(),
					actuacionModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);

				args = new Object[] {
					actuacionModelImpl.getGroupId(),
					actuacionModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);
			}

			if ((actuacionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPosicion.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					actuacionModelImpl.getOriginalLongitud(),
					actuacionModelImpl.getOriginalLatitud()
				};

				finderCache.removeResult(_finderPathCountByPosicion, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPosicion, args);

				args = new Object[] {
					actuacionModelImpl.getLongitud(),
					actuacionModelImpl.getLatitud()
				};

				finderCache.removeResult(_finderPathCountByPosicion, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPosicion, args);
			}

			if ((actuacionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCodTecnico.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					actuacionModelImpl.getOriginalCodTecnico()
				};

				finderCache.removeResult(_finderPathCountByCodTecnico, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCodTecnico, args);

				args = new Object[] {actuacionModelImpl.getCodTecnico()};

				finderCache.removeResult(_finderPathCountByCodTecnico, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCodTecnico, args);
			}

			if ((actuacionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNombre.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					actuacionModelImpl.getOriginalNombre()
				};

				finderCache.removeResult(_finderPathCountByNombre, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNombre, args);

				args = new Object[] {actuacionModelImpl.getNombre()};

				finderCache.removeResult(_finderPathCountByNombre, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNombre, args);
			}

			if ((actuacionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCA.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					actuacionModelImpl.getOriginalComunidadAutonoma()
				};

				finderCache.removeResult(_finderPathCountByCA, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCA, args);

				args = new Object[] {actuacionModelImpl.getComunidadAutonoma()};

				finderCache.removeResult(_finderPathCountByCA, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCA, args);
			}

			if ((actuacionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByProvincia.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					actuacionModelImpl.getOriginalProvincia()
				};

				finderCache.removeResult(_finderPathCountByProvincia, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProvincia, args);

				args = new Object[] {actuacionModelImpl.getProvincia()};

				finderCache.removeResult(_finderPathCountByProvincia, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProvincia, args);
			}

			if ((actuacionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTituloComAutProvinciaSituacion.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					actuacionModelImpl.getOriginalNombre(),
					actuacionModelImpl.getOriginalComunidadAutonoma(),
					actuacionModelImpl.getOriginalProvincia(),
					actuacionModelImpl.getOriginalSituacion()
				};

				finderCache.removeResult(
					_finderPathCountByTituloComAutProvinciaSituacion, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTituloComAutProvinciaSituacion,
					args);

				args = new Object[] {
					actuacionModelImpl.getNombre(),
					actuacionModelImpl.getComunidadAutonoma(),
					actuacionModelImpl.getProvincia(),
					actuacionModelImpl.getSituacion()
				};

				finderCache.removeResult(
					_finderPathCountByTituloComAutProvinciaSituacion, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTituloComAutProvinciaSituacion,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ActuacionImpl.class, actuacion.getPrimaryKey(),
			actuacion, false);

		clearUniqueFindersCache(actuacionModelImpl, false);
		cacheUniqueFindersCache(actuacionModelImpl);

		actuacion.resetOriginalValues();

		return actuacion;
	}

	/**
	 * Returns the actuacion with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the actuacion
	 * @return the actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	@Override
	public Actuacion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActuacionException {

		Actuacion actuacion = fetchByPrimaryKey(primaryKey);

		if (actuacion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActuacionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return actuacion;
	}

	/**
	 * Returns the actuacion with the primary key or throws a <code>NoSuchActuacionException</code> if it could not be found.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion
	 * @throws NoSuchActuacionException if a actuacion with the primary key could not be found
	 */
	@Override
	public Actuacion findByPrimaryKey(long actuacionId)
		throws NoSuchActuacionException {

		return findByPrimaryKey((Serializable)actuacionId);
	}

	/**
	 * Returns the actuacion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion, or <code>null</code> if a actuacion with the primary key could not be found
	 */
	@Override
	public Actuacion fetchByPrimaryKey(long actuacionId) {
		return fetchByPrimaryKey((Serializable)actuacionId);
	}

	/**
	 * Returns all the actuacions.
	 *
	 * @return the actuacions
	 */
	@Override
	public List<Actuacion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Actuacion> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Actuacion> findAll(
		int start, int end, OrderByComparator<Actuacion> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<Actuacion> findAll(
		int start, int end, OrderByComparator<Actuacion> orderByComparator) {

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

		List<Actuacion> list = (List<Actuacion>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ACTUACION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACTUACION;

				if (pagination) {
					sql = sql.concat(ActuacionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Actuacion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Actuacion>)QueryUtil.list(
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
	 * Removes all the actuacions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Actuacion actuacion : findAll()) {
			remove(actuacion);
		}
	}

	/**
	 * Returns the number of actuacions.
	 *
	 * @return the number of actuacions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ACTUACION);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "actuacionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ACTUACION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ActuacionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the actuacion persistence.
	 */
	@Activate
	public void activate() {
		ActuacionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ActuacionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ActuacionModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			ActuacionModelImpl.UUID_COLUMN_BITMASK |
			ActuacionModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			ActuacionModelImpl.UUID_COLUMN_BITMASK |
			ActuacionModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			ActuacionModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()},
			ActuacionModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			ActuacionModelImpl.GROUPID_COLUMN_BITMASK |
			ActuacionModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByPosicion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPosicion",
			new String[] {
				BigDecimal.class.getName(), BigDecimal.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPosicion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPosicion",
			new String[] {
				BigDecimal.class.getName(), BigDecimal.class.getName()
			},
			ActuacionModelImpl.LONGITUD_COLUMN_BITMASK |
			ActuacionModelImpl.LATITUD_COLUMN_BITMASK);

		_finderPathCountByPosicion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPosicion",
			new String[] {
				BigDecimal.class.getName(), BigDecimal.class.getName()
			});

		_finderPathWithPaginationFindByCodTecnico = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCodTecnico",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCodTecnico = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCodTecnico",
			new String[] {Long.class.getName()},
			ActuacionModelImpl.CODTECNICO_COLUMN_BITMASK);

		_finderPathCountByCodTecnico = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodTecnico",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByNombre = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNombre",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNombre = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNombre",
			new String[] {String.class.getName()},
			ActuacionModelImpl.NOMBRE_COLUMN_BITMASK);

		_finderPathCountByNombre = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNombre",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByCA = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCA",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCA = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCA",
			new String[] {String.class.getName()},
			ActuacionModelImpl.COMUNIDADAUTONOMA_COLUMN_BITMASK);

		_finderPathCountByCA = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCA",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByProvincia = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProvincia",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByProvincia = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProvincia",
			new String[] {String.class.getName()},
			ActuacionModelImpl.PROVINCIA_COLUMN_BITMASK);

		_finderPathCountByProvincia = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProvincia",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByTituloComAutProvinciaSituacion =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTituloComAutProvinciaSituacion",
				new String[] {
					String.class.getName(), String.class.getName(),
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByTituloComAutProvinciaSituacion =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, ActuacionImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTituloComAutProvinciaSituacion",
				new String[] {
					String.class.getName(), String.class.getName(),
					String.class.getName(), String.class.getName()
				},
				ActuacionModelImpl.NOMBRE_COLUMN_BITMASK |
				ActuacionModelImpl.COMUNIDADAUTONOMA_COLUMN_BITMASK |
				ActuacionModelImpl.PROVINCIA_COLUMN_BITMASK |
				ActuacionModelImpl.SITUACION_COLUMN_BITMASK);

		_finderPathCountByTituloComAutProvinciaSituacion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTituloComAutProvinciaSituacion",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ActuacionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ActuacionesPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.grupoica.actuaciones.model.Actuacion"),
			true);
	}

	@Override
	@Reference(
		target = ActuacionesPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ActuacionesPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_ACTUACION =
		"SELECT actuacion FROM Actuacion actuacion";

	private static final String _SQL_SELECT_ACTUACION_WHERE =
		"SELECT actuacion FROM Actuacion actuacion WHERE ";

	private static final String _SQL_COUNT_ACTUACION =
		"SELECT COUNT(actuacion) FROM Actuacion actuacion";

	private static final String _SQL_COUNT_ACTUACION_WHERE =
		"SELECT COUNT(actuacion) FROM Actuacion actuacion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "actuacion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Actuacion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Actuacion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ActuacionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(ActuacionesPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}