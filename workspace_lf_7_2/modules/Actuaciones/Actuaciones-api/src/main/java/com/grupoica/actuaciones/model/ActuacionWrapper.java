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

package com.grupoica.actuaciones.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Actuacion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Actuacion
 * @generated
 */
@ProviderType
public class ActuacionWrapper
	extends BaseModelWrapper<Actuacion>
	implements Actuacion, ModelWrapper<Actuacion> {

	public ActuacionWrapper(Actuacion actuacion) {
		super(actuacion);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("actuacionId", getActuacionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("codTecnico", getCodTecnico());
		attributes.put("nombre", getNombre());
		attributes.put("objetivo", getObjetivo());
		attributes.put("descripcion", getDescripcion());
		attributes.put("zona", getZona());
		attributes.put("comunidadAutonoma", getComunidadAutonoma());
		attributes.put("provincia", getProvincia());
		attributes.put("superficie", getSuperficie());
		attributes.put("costeEjecucion", getCosteEjecucion());
		attributes.put("regantes", getRegantes());
		attributes.put("cultivos", getCultivos());
		attributes.put("situacion", getSituacion());
		attributes.put("longitud", getLongitud());
		attributes.put("latitud", getLatitud());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long actuacionId = (Long)attributes.get("actuacionId");

		if (actuacionId != null) {
			setActuacionId(actuacionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long codTecnico = (Long)attributes.get("codTecnico");

		if (codTecnico != null) {
			setCodTecnico(codTecnico);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String objetivo = (String)attributes.get("objetivo");

		if (objetivo != null) {
			setObjetivo(objetivo);
		}

		String descripcion = (String)attributes.get("descripcion");

		if (descripcion != null) {
			setDescripcion(descripcion);
		}

		String zona = (String)attributes.get("zona");

		if (zona != null) {
			setZona(zona);
		}

		String comunidadAutonoma = (String)attributes.get("comunidadAutonoma");

		if (comunidadAutonoma != null) {
			setComunidadAutonoma(comunidadAutonoma);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		BigDecimal superficie = (BigDecimal)attributes.get("superficie");

		if (superficie != null) {
			setSuperficie(superficie);
		}

		BigDecimal costeEjecucion = (BigDecimal)attributes.get(
			"costeEjecucion");

		if (costeEjecucion != null) {
			setCosteEjecucion(costeEjecucion);
		}

		Long regantes = (Long)attributes.get("regantes");

		if (regantes != null) {
			setRegantes(regantes);
		}

		String cultivos = (String)attributes.get("cultivos");

		if (cultivos != null) {
			setCultivos(cultivos);
		}

		String situacion = (String)attributes.get("situacion");

		if (situacion != null) {
			setSituacion(situacion);
		}

		BigDecimal longitud = (BigDecimal)attributes.get("longitud");

		if (longitud != null) {
			setLongitud(longitud);
		}

		BigDecimal latitud = (BigDecimal)attributes.get("latitud");

		if (latitud != null) {
			setLatitud(latitud);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	 * Returns the actuacion ID of this actuacion.
	 *
	 * @return the actuacion ID of this actuacion
	 */
	@Override
	public long getActuacionId() {
		return model.getActuacionId();
	}

	/**
	 * Returns the cod tecnico of this actuacion.
	 *
	 * @return the cod tecnico of this actuacion
	 */
	@Override
	public long getCodTecnico() {
		return model.getCodTecnico();
	}

	/**
	 * Returns the company ID of this actuacion.
	 *
	 * @return the company ID of this actuacion
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the comunidad autonoma of this actuacion.
	 *
	 * @return the comunidad autonoma of this actuacion
	 */
	@Override
	public String getComunidadAutonoma() {
		return model.getComunidadAutonoma();
	}

	/**
	 * Returns the coste ejecucion of this actuacion.
	 *
	 * @return the coste ejecucion of this actuacion
	 */
	@Override
	public BigDecimal getCosteEjecucion() {
		return model.getCosteEjecucion();
	}

	/**
	 * Returns the create date of this actuacion.
	 *
	 * @return the create date of this actuacion
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the cultivos of this actuacion.
	 *
	 * @return the cultivos of this actuacion
	 */
	@Override
	public String getCultivos() {
		return model.getCultivos();
	}

	/**
	 * Returns the descripcion of this actuacion.
	 *
	 * @return the descripcion of this actuacion
	 */
	@Override
	public String getDescripcion() {
		return model.getDescripcion();
	}

	/**
	 * Returns the group ID of this actuacion.
	 *
	 * @return the group ID of this actuacion
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the latitud of this actuacion.
	 *
	 * @return the latitud of this actuacion
	 */
	@Override
	public BigDecimal getLatitud() {
		return model.getLatitud();
	}

	/**
	 * Returns the longitud of this actuacion.
	 *
	 * @return the longitud of this actuacion
	 */
	@Override
	public BigDecimal getLongitud() {
		return model.getLongitud();
	}

	/**
	 * Returns the modified date of this actuacion.
	 *
	 * @return the modified date of this actuacion
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nombre of this actuacion.
	 *
	 * @return the nombre of this actuacion
	 */
	@Override
	public String getNombre() {
		return model.getNombre();
	}

	/**
	 * Returns the objetivo of this actuacion.
	 *
	 * @return the objetivo of this actuacion
	 */
	@Override
	public String getObjetivo() {
		return model.getObjetivo();
	}

	/**
	 * Returns the primary key of this actuacion.
	 *
	 * @return the primary key of this actuacion
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the provincia of this actuacion.
	 *
	 * @return the provincia of this actuacion
	 */
	@Override
	public String getProvincia() {
		return model.getProvincia();
	}

	/**
	 * Returns the regantes of this actuacion.
	 *
	 * @return the regantes of this actuacion
	 */
	@Override
	public long getRegantes() {
		return model.getRegantes();
	}

	/**
	 * Returns the situacion of this actuacion.
	 *
	 * @return the situacion of this actuacion
	 */
	@Override
	public String getSituacion() {
		return model.getSituacion();
	}

	/**
	 * Returns the status of this actuacion.
	 *
	 * @return the status of this actuacion
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this actuacion.
	 *
	 * @return the status by user ID of this actuacion
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this actuacion.
	 *
	 * @return the status by user name of this actuacion
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this actuacion.
	 *
	 * @return the status by user uuid of this actuacion
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this actuacion.
	 *
	 * @return the status date of this actuacion
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the superficie of this actuacion.
	 *
	 * @return the superficie of this actuacion
	 */
	@Override
	public BigDecimal getSuperficie() {
		return model.getSuperficie();
	}

	/**
	 * Returns the user ID of this actuacion.
	 *
	 * @return the user ID of this actuacion
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this actuacion.
	 *
	 * @return the user name of this actuacion
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this actuacion.
	 *
	 * @return the user uuid of this actuacion
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this actuacion.
	 *
	 * @return the uuid of this actuacion
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the zona of this actuacion.
	 *
	 * @return the zona of this actuacion
	 */
	@Override
	public String getZona() {
		return model.getZona();
	}

	/**
	 * Returns <code>true</code> if this actuacion is approved.
	 *
	 * @return <code>true</code> if this actuacion is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this actuacion is denied.
	 *
	 * @return <code>true</code> if this actuacion is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this actuacion is a draft.
	 *
	 * @return <code>true</code> if this actuacion is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this actuacion is expired.
	 *
	 * @return <code>true</code> if this actuacion is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this actuacion is inactive.
	 *
	 * @return <code>true</code> if this actuacion is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this actuacion is incomplete.
	 *
	 * @return <code>true</code> if this actuacion is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this actuacion is pending.
	 *
	 * @return <code>true</code> if this actuacion is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this actuacion is scheduled.
	 *
	 * @return <code>true</code> if this actuacion is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the actuacion ID of this actuacion.
	 *
	 * @param actuacionId the actuacion ID of this actuacion
	 */
	@Override
	public void setActuacionId(long actuacionId) {
		model.setActuacionId(actuacionId);
	}

	/**
	 * Sets the cod tecnico of this actuacion.
	 *
	 * @param codTecnico the cod tecnico of this actuacion
	 */
	@Override
	public void setCodTecnico(long codTecnico) {
		model.setCodTecnico(codTecnico);
	}

	/**
	 * Sets the company ID of this actuacion.
	 *
	 * @param companyId the company ID of this actuacion
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the comunidad autonoma of this actuacion.
	 *
	 * @param comunidadAutonoma the comunidad autonoma of this actuacion
	 */
	@Override
	public void setComunidadAutonoma(String comunidadAutonoma) {
		model.setComunidadAutonoma(comunidadAutonoma);
	}

	/**
	 * Sets the coste ejecucion of this actuacion.
	 *
	 * @param costeEjecucion the coste ejecucion of this actuacion
	 */
	@Override
	public void setCosteEjecucion(BigDecimal costeEjecucion) {
		model.setCosteEjecucion(costeEjecucion);
	}

	/**
	 * Sets the create date of this actuacion.
	 *
	 * @param createDate the create date of this actuacion
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the cultivos of this actuacion.
	 *
	 * @param cultivos the cultivos of this actuacion
	 */
	@Override
	public void setCultivos(String cultivos) {
		model.setCultivos(cultivos);
	}

	/**
	 * Sets the descripcion of this actuacion.
	 *
	 * @param descripcion the descripcion of this actuacion
	 */
	@Override
	public void setDescripcion(String descripcion) {
		model.setDescripcion(descripcion);
	}

	/**
	 * Sets the group ID of this actuacion.
	 *
	 * @param groupId the group ID of this actuacion
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the latitud of this actuacion.
	 *
	 * @param latitud the latitud of this actuacion
	 */
	@Override
	public void setLatitud(BigDecimal latitud) {
		model.setLatitud(latitud);
	}

	/**
	 * Sets the longitud of this actuacion.
	 *
	 * @param longitud the longitud of this actuacion
	 */
	@Override
	public void setLongitud(BigDecimal longitud) {
		model.setLongitud(longitud);
	}

	/**
	 * Sets the modified date of this actuacion.
	 *
	 * @param modifiedDate the modified date of this actuacion
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nombre of this actuacion.
	 *
	 * @param nombre the nombre of this actuacion
	 */
	@Override
	public void setNombre(String nombre) {
		model.setNombre(nombre);
	}

	/**
	 * Sets the objetivo of this actuacion.
	 *
	 * @param objetivo the objetivo of this actuacion
	 */
	@Override
	public void setObjetivo(String objetivo) {
		model.setObjetivo(objetivo);
	}

	/**
	 * Sets the primary key of this actuacion.
	 *
	 * @param primaryKey the primary key of this actuacion
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the provincia of this actuacion.
	 *
	 * @param provincia the provincia of this actuacion
	 */
	@Override
	public void setProvincia(String provincia) {
		model.setProvincia(provincia);
	}

	/**
	 * Sets the regantes of this actuacion.
	 *
	 * @param regantes the regantes of this actuacion
	 */
	@Override
	public void setRegantes(long regantes) {
		model.setRegantes(regantes);
	}

	/**
	 * Sets the situacion of this actuacion.
	 *
	 * @param situacion the situacion of this actuacion
	 */
	@Override
	public void setSituacion(String situacion) {
		model.setSituacion(situacion);
	}

	/**
	 * Sets the status of this actuacion.
	 *
	 * @param status the status of this actuacion
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this actuacion.
	 *
	 * @param statusByUserId the status by user ID of this actuacion
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this actuacion.
	 *
	 * @param statusByUserName the status by user name of this actuacion
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this actuacion.
	 *
	 * @param statusByUserUuid the status by user uuid of this actuacion
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this actuacion.
	 *
	 * @param statusDate the status date of this actuacion
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the superficie of this actuacion.
	 *
	 * @param superficie the superficie of this actuacion
	 */
	@Override
	public void setSuperficie(BigDecimal superficie) {
		model.setSuperficie(superficie);
	}

	/**
	 * Sets the user ID of this actuacion.
	 *
	 * @param userId the user ID of this actuacion
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this actuacion.
	 *
	 * @param userName the user name of this actuacion
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this actuacion.
	 *
	 * @param userUuid the user uuid of this actuacion
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this actuacion.
	 *
	 * @param uuid the uuid of this actuacion
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the zona of this actuacion.
	 *
	 * @param zona the zona of this actuacion
	 */
	@Override
	public void setZona(String zona) {
		model.setZona(zona);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ActuacionWrapper wrap(Actuacion actuacion) {
		return new ActuacionWrapper(actuacion);
	}

}