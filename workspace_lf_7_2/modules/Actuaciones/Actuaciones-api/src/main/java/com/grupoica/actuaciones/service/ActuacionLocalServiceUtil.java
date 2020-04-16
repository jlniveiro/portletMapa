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

package com.grupoica.actuaciones.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Actuacion. This utility wraps
 * <code>com.grupoica.actuaciones.service.impl.ActuacionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ActuacionLocalService
 * @generated
 */
@ProviderType
public class ActuacionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.grupoica.actuaciones.service.impl.ActuacionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the actuacion to the database. Also notifies the appropriate model listeners.
	 *
	 * @param actuacion the actuacion
	 * @return the actuacion that was added
	 */
	public static com.grupoica.actuaciones.model.Actuacion addActuacion(
		com.grupoica.actuaciones.model.Actuacion actuacion) {

		return getService().addActuacion(actuacion);
	}

	public static com.grupoica.actuaciones.model.Actuacion addActuacion(
			long groupId, long codTecnico, String nombre, String objetivo,
			String descripcion, String zona, String comunidadAutonoma,
			String provincia, java.math.BigDecimal superficie,
			java.math.BigDecimal costeEjecucion, long regantes, String cultivos,
			String situacion, java.math.BigDecimal longitud,
			java.math.BigDecimal latitud)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addActuacion(
			groupId, codTecnico, nombre, objetivo, descripcion, zona,
			comunidadAutonoma, provincia, superficie, costeEjecucion, regantes,
			cultivos, situacion, longitud, latitud);
	}

	public static java.util.List<com.grupoica.actuaciones.model.Actuacion>
		buscarPorTituloComAutProvinciaSituacion(
			String nombre, String comunidadAutonoma, String provincia,
			String situacion) {

		return getService().buscarPorTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion);
	}

	/**
	 * Creates a new actuacion with the primary key. Does not add the actuacion to the database.
	 *
	 * @param actuacionId the primary key for the new actuacion
	 * @return the new actuacion
	 */
	public static com.grupoica.actuaciones.model.Actuacion createActuacion(
		long actuacionId) {

		return getService().createActuacion(actuacionId);
	}

	/**
	 * Deletes the actuacion from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actuacion the actuacion
	 * @return the actuacion that was removed
	 */
	public static com.grupoica.actuaciones.model.Actuacion deleteActuacion(
		com.grupoica.actuaciones.model.Actuacion actuacion) {

		return getService().deleteActuacion(actuacion);
	}

	/**
	 * Deletes the actuacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion that was removed
	 * @throws PortalException if a actuacion with the primary key could not be found
	 */
	public static com.grupoica.actuaciones.model.Actuacion deleteActuacion(
			long actuacionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteActuacion(actuacionId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.grupoica.actuaciones.model.impl.ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.grupoica.actuaciones.model.impl.ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.grupoica.actuaciones.model.Actuacion fetchActuacion(
		long actuacionId) {

		return getService().fetchActuacion(actuacionId);
	}

	/**
	 * Returns the actuacion matching the UUID and group.
	 *
	 * @param uuid the actuacion's UUID
	 * @param groupId the primary key of the group
	 * @return the matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	public static com.grupoica.actuaciones.model.Actuacion
		fetchActuacionByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchActuacionByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.grupoica.actuaciones.model.Actuacion>
		findAll() {

		return getService().findAll();
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the actuacion with the primary key.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion
	 * @throws PortalException if a actuacion with the primary key could not be found
	 */
	public static com.grupoica.actuaciones.model.Actuacion getActuacion(
			long actuacionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getActuacion(actuacionId);
	}

	/**
	 * Returns the actuacion matching the UUID and group.
	 *
	 * @param uuid the actuacion's UUID
	 * @param groupId the primary key of the group
	 * @return the matching actuacion
	 * @throws PortalException if a matching actuacion could not be found
	 */
	public static com.grupoica.actuaciones.model.Actuacion
			getActuacionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getActuacionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the actuacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.grupoica.actuaciones.model.impl.ActuacionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @return the range of actuacions
	 */
	public static java.util.List<com.grupoica.actuaciones.model.Actuacion>
		getActuacions(int start, int end) {

		return getService().getActuacions(start, end);
	}

	/**
	 * Returns all the actuacions matching the UUID and company.
	 *
	 * @param uuid the UUID of the actuacions
	 * @param companyId the primary key of the company
	 * @return the matching actuacions, or an empty list if no matches were found
	 */
	public static java.util.List<com.grupoica.actuaciones.model.Actuacion>
		getActuacionsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getActuacionsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of actuacions matching the UUID and company.
	 *
	 * @param uuid the UUID of the actuacions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of actuacions
	 * @param end the upper bound of the range of actuacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching actuacions, or an empty list if no matches were found
	 */
	public static java.util.List<com.grupoica.actuaciones.model.Actuacion>
		getActuacionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.grupoica.actuaciones.model.Actuacion> orderByComparator) {

		return getService().getActuacionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of actuacions.
	 *
	 * @return the number of actuacions
	 */
	public static int getActuacionsCount() {
		return getService().getActuacionsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the actuacion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param actuacion the actuacion
	 * @return the actuacion that was updated
	 */
	public static com.grupoica.actuaciones.model.Actuacion updateActuacion(
		com.grupoica.actuaciones.model.Actuacion actuacion) {

		return getService().updateActuacion(actuacion);
	}

	public static ActuacionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ActuacionLocalService, ActuacionLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ActuacionLocalService.class);

		ServiceTracker<ActuacionLocalService, ActuacionLocalService>
			serviceTracker =
				new ServiceTracker
					<ActuacionLocalService, ActuacionLocalService>(
						bundle.getBundleContext(), ActuacionLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}