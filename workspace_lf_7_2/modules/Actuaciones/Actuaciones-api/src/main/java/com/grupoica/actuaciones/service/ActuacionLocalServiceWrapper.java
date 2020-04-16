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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link ActuacionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActuacionLocalService
 * @generated
 */
@ProviderType
public class ActuacionLocalServiceWrapper
	implements ActuacionLocalService, ServiceWrapper<ActuacionLocalService> {

	public ActuacionLocalServiceWrapper(
		ActuacionLocalService actuacionLocalService) {

		_actuacionLocalService = actuacionLocalService;
	}

	/**
	 * Adds the actuacion to the database. Also notifies the appropriate model listeners.
	 *
	 * @param actuacion the actuacion
	 * @return the actuacion that was added
	 */
	@Override
	public com.grupoica.actuaciones.model.Actuacion addActuacion(
		com.grupoica.actuaciones.model.Actuacion actuacion) {

		return _actuacionLocalService.addActuacion(actuacion);
	}

	@Override
	public com.grupoica.actuaciones.model.Actuacion addActuacion(
			long groupId, long codTecnico, String nombre, String objetivo,
			String descripcion, String zona, String comunidadAutonoma,
			String provincia, java.math.BigDecimal superficie,
			java.math.BigDecimal costeEjecucion, long regantes, String cultivos,
			String situacion, java.math.BigDecimal longitud,
			java.math.BigDecimal latitud)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actuacionLocalService.addActuacion(
			groupId, codTecnico, nombre, objetivo, descripcion, zona,
			comunidadAutonoma, provincia, superficie, costeEjecucion, regantes,
			cultivos, situacion, longitud, latitud);
	}

	@Override
	public java.util.List<com.grupoica.actuaciones.model.Actuacion>
		buscarPorTituloComAutProvinciaSituacion(
			String nombre, String comunidadAutonoma, String provincia,
			String situacion) {

		return _actuacionLocalService.buscarPorTituloComAutProvinciaSituacion(
			nombre, comunidadAutonoma, provincia, situacion);
	}

	/**
	 * Creates a new actuacion with the primary key. Does not add the actuacion to the database.
	 *
	 * @param actuacionId the primary key for the new actuacion
	 * @return the new actuacion
	 */
	@Override
	public com.grupoica.actuaciones.model.Actuacion createActuacion(
		long actuacionId) {

		return _actuacionLocalService.createActuacion(actuacionId);
	}

	/**
	 * Deletes the actuacion from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actuacion the actuacion
	 * @return the actuacion that was removed
	 */
	@Override
	public com.grupoica.actuaciones.model.Actuacion deleteActuacion(
		com.grupoica.actuaciones.model.Actuacion actuacion) {

		return _actuacionLocalService.deleteActuacion(actuacion);
	}

	/**
	 * Deletes the actuacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion that was removed
	 * @throws PortalException if a actuacion with the primary key could not be found
	 */
	@Override
	public com.grupoica.actuaciones.model.Actuacion deleteActuacion(
			long actuacionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actuacionLocalService.deleteActuacion(actuacionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actuacionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _actuacionLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _actuacionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _actuacionLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _actuacionLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _actuacionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _actuacionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.grupoica.actuaciones.model.Actuacion fetchActuacion(
		long actuacionId) {

		return _actuacionLocalService.fetchActuacion(actuacionId);
	}

	/**
	 * Returns the actuacion matching the UUID and group.
	 *
	 * @param uuid the actuacion's UUID
	 * @param groupId the primary key of the group
	 * @return the matching actuacion, or <code>null</code> if a matching actuacion could not be found
	 */
	@Override
	public com.grupoica.actuaciones.model.Actuacion
		fetchActuacionByUuidAndGroupId(String uuid, long groupId) {

		return _actuacionLocalService.fetchActuacionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.grupoica.actuaciones.model.Actuacion> findAll() {
		return _actuacionLocalService.findAll();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _actuacionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the actuacion with the primary key.
	 *
	 * @param actuacionId the primary key of the actuacion
	 * @return the actuacion
	 * @throws PortalException if a actuacion with the primary key could not be found
	 */
	@Override
	public com.grupoica.actuaciones.model.Actuacion getActuacion(
			long actuacionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actuacionLocalService.getActuacion(actuacionId);
	}

	/**
	 * Returns the actuacion matching the UUID and group.
	 *
	 * @param uuid the actuacion's UUID
	 * @param groupId the primary key of the group
	 * @return the matching actuacion
	 * @throws PortalException if a matching actuacion could not be found
	 */
	@Override
	public com.grupoica.actuaciones.model.Actuacion
			getActuacionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actuacionLocalService.getActuacionByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.grupoica.actuaciones.model.Actuacion>
		getActuacions(int start, int end) {

		return _actuacionLocalService.getActuacions(start, end);
	}

	/**
	 * Returns all the actuacions matching the UUID and company.
	 *
	 * @param uuid the UUID of the actuacions
	 * @param companyId the primary key of the company
	 * @return the matching actuacions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.grupoica.actuaciones.model.Actuacion>
		getActuacionsByUuidAndCompanyId(String uuid, long companyId) {

		return _actuacionLocalService.getActuacionsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.grupoica.actuaciones.model.Actuacion>
		getActuacionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.grupoica.actuaciones.model.Actuacion> orderByComparator) {

		return _actuacionLocalService.getActuacionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of actuacions.
	 *
	 * @return the number of actuacions
	 */
	@Override
	public int getActuacionsCount() {
		return _actuacionLocalService.getActuacionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _actuacionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _actuacionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _actuacionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actuacionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the actuacion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param actuacion the actuacion
	 * @return the actuacion that was updated
	 */
	@Override
	public com.grupoica.actuaciones.model.Actuacion updateActuacion(
		com.grupoica.actuaciones.model.Actuacion actuacion) {

		return _actuacionLocalService.updateActuacion(actuacion);
	}

	@Override
	public ActuacionLocalService getWrappedService() {
		return _actuacionLocalService;
	}

	@Override
	public void setWrappedService(ActuacionLocalService actuacionLocalService) {
		_actuacionLocalService = actuacionLocalService;
	}

	private ActuacionLocalService _actuacionLocalService;

}