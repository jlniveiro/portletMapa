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

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.grupoica.actuaciones.service.http.ActuacionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ActuacionSoap implements Serializable {

	public static ActuacionSoap toSoapModel(Actuacion model) {
		ActuacionSoap soapModel = new ActuacionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setActuacionId(model.getActuacionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCodTecnico(model.getCodTecnico());
		soapModel.setNombre(model.getNombre());
		soapModel.setObjetivo(model.getObjetivo());
		soapModel.setDescripcion(model.getDescripcion());
		soapModel.setZona(model.getZona());
		soapModel.setComunidadAutonoma(model.getComunidadAutonoma());
		soapModel.setProvincia(model.getProvincia());
		soapModel.setSuperficie(model.getSuperficie());
		soapModel.setCosteEjecucion(model.getCosteEjecucion());
		soapModel.setRegantes(model.getRegantes());
		soapModel.setCultivos(model.getCultivos());
		soapModel.setSituacion(model.getSituacion());
		soapModel.setLongitud(model.getLongitud());
		soapModel.setLatitud(model.getLatitud());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static ActuacionSoap[] toSoapModels(Actuacion[] models) {
		ActuacionSoap[] soapModels = new ActuacionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ActuacionSoap[][] toSoapModels(Actuacion[][] models) {
		ActuacionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ActuacionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ActuacionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ActuacionSoap[] toSoapModels(List<Actuacion> models) {
		List<ActuacionSoap> soapModels = new ArrayList<ActuacionSoap>(
			models.size());

		for (Actuacion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ActuacionSoap[soapModels.size()]);
	}

	public ActuacionSoap() {
	}

	public long getPrimaryKey() {
		return _actuacionId;
	}

	public void setPrimaryKey(long pk) {
		setActuacionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getActuacionId() {
		return _actuacionId;
	}

	public void setActuacionId(long actuacionId) {
		_actuacionId = actuacionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCodTecnico() {
		return _codTecnico;
	}

	public void setCodTecnico(long codTecnico) {
		_codTecnico = codTecnico;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public String getObjetivo() {
		return _objetivo;
	}

	public void setObjetivo(String objetivo) {
		_objetivo = objetivo;
	}

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

	public String getZona() {
		return _zona;
	}

	public void setZona(String zona) {
		_zona = zona;
	}

	public String getComunidadAutonoma() {
		return _comunidadAutonoma;
	}

	public void setComunidadAutonoma(String comunidadAutonoma) {
		_comunidadAutonoma = comunidadAutonoma;
	}

	public String getProvincia() {
		return _provincia;
	}

	public void setProvincia(String provincia) {
		_provincia = provincia;
	}

	public BigDecimal getSuperficie() {
		return _superficie;
	}

	public void setSuperficie(BigDecimal superficie) {
		_superficie = superficie;
	}

	public BigDecimal getCosteEjecucion() {
		return _costeEjecucion;
	}

	public void setCosteEjecucion(BigDecimal costeEjecucion) {
		_costeEjecucion = costeEjecucion;
	}

	public long getRegantes() {
		return _regantes;
	}

	public void setRegantes(long regantes) {
		_regantes = regantes;
	}

	public String getCultivos() {
		return _cultivos;
	}

	public void setCultivos(String cultivos) {
		_cultivos = cultivos;
	}

	public String getSituacion() {
		return _situacion;
	}

	public void setSituacion(String situacion) {
		_situacion = situacion;
	}

	public BigDecimal getLongitud() {
		return _longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		_longitud = longitud;
	}

	public BigDecimal getLatitud() {
		return _latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		_latitud = latitud;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private String _uuid;
	private long _actuacionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _codTecnico;
	private String _nombre;
	private String _objetivo;
	private String _descripcion;
	private String _zona;
	private String _comunidadAutonoma;
	private String _provincia;
	private BigDecimal _superficie;
	private BigDecimal _costeEjecucion;
	private long _regantes;
	private String _cultivos;
	private String _situacion;
	private BigDecimal _longitud;
	private BigDecimal _latitud;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

}