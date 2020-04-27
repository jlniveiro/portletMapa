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

package com.grupoica.actuaciones.model.impl;

import com.grupoica.actuaciones.model.Actuacion;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Actuacion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ActuacionCacheModel
	implements CacheModel<Actuacion>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActuacionCacheModel)) {
			return false;
		}

		ActuacionCacheModel actuacionCacheModel = (ActuacionCacheModel)obj;

		if (actuacionId == actuacionCacheModel.actuacionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, actuacionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", actuacionId=");
		sb.append(actuacionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", codTecnico=");
		sb.append(codTecnico);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", objetivo=");
		sb.append(objetivo);
		sb.append(", descripcion=");
		sb.append(descripcion);
		sb.append(", zona=");
		sb.append(zona);
		sb.append(", comunidadAutonoma=");
		sb.append(comunidadAutonoma);
		sb.append(", provincia=");
		sb.append(provincia);
		sb.append(", superficie=");
		sb.append(superficie);
		sb.append(", costeEjecucion=");
		sb.append(costeEjecucion);
		sb.append(", regantes=");
		sb.append(regantes);
		sb.append(", cultivos=");
		sb.append(cultivos);
		sb.append(", situacion=");
		sb.append(situacion);
		sb.append(", longitud=");
		sb.append(longitud);
		sb.append(", latitud=");
		sb.append(latitud);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Actuacion toEntityModel() {
		ActuacionImpl actuacionImpl = new ActuacionImpl();

		if (uuid == null) {
			actuacionImpl.setUuid("");
		}
		else {
			actuacionImpl.setUuid(uuid);
		}

		actuacionImpl.setActuacionId(actuacionId);
		actuacionImpl.setGroupId(groupId);
		actuacionImpl.setCompanyId(companyId);
		actuacionImpl.setUserId(userId);

		if (userName == null) {
			actuacionImpl.setUserName("");
		}
		else {
			actuacionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			actuacionImpl.setCreateDate(null);
		}
		else {
			actuacionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			actuacionImpl.setModifiedDate(null);
		}
		else {
			actuacionImpl.setModifiedDate(new Date(modifiedDate));
		}

		actuacionImpl.setCodTecnico(codTecnico);

		if (nombre == null) {
			actuacionImpl.setNombre("");
		}
		else {
			actuacionImpl.setNombre(nombre);
		}

		if (objetivo == null) {
			actuacionImpl.setObjetivo("");
		}
		else {
			actuacionImpl.setObjetivo(objetivo);
		}

		if (descripcion == null) {
			actuacionImpl.setDescripcion("");
		}
		else {
			actuacionImpl.setDescripcion(descripcion);
		}

		if (zona == null) {
			actuacionImpl.setZona("");
		}
		else {
			actuacionImpl.setZona(zona);
		}

		if (comunidadAutonoma == null) {
			actuacionImpl.setComunidadAutonoma("");
		}
		else {
			actuacionImpl.setComunidadAutonoma(comunidadAutonoma);
		}

		if (provincia == null) {
			actuacionImpl.setProvincia("");
		}
		else {
			actuacionImpl.setProvincia(provincia);
		}

		actuacionImpl.setSuperficie(superficie);
		actuacionImpl.setCosteEjecucion(costeEjecucion);
		actuacionImpl.setRegantes(regantes);

		if (cultivos == null) {
			actuacionImpl.setCultivos("");
		}
		else {
			actuacionImpl.setCultivos(cultivos);
		}

		if (situacion == null) {
			actuacionImpl.setSituacion("");
		}
		else {
			actuacionImpl.setSituacion(situacion);
		}

		actuacionImpl.setLongitud(longitud);
		actuacionImpl.setLatitud(latitud);
		actuacionImpl.setStatus(status);
		actuacionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			actuacionImpl.setStatusByUserName("");
		}
		else {
			actuacionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			actuacionImpl.setStatusDate(null);
		}
		else {
			actuacionImpl.setStatusDate(new Date(statusDate));
		}

		actuacionImpl.resetOriginalValues();

		return actuacionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		actuacionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		codTecnico = objectInput.readLong();
		nombre = objectInput.readUTF();
		objetivo = objectInput.readUTF();
		descripcion = objectInput.readUTF();
		zona = objectInput.readUTF();
		comunidadAutonoma = objectInput.readUTF();
		provincia = objectInput.readUTF();
		superficie = (BigDecimal)objectInput.readObject();
		costeEjecucion = (BigDecimal)objectInput.readObject();

		regantes = objectInput.readLong();
		cultivos = objectInput.readUTF();
		situacion = objectInput.readUTF();
		longitud = (BigDecimal)objectInput.readObject();
		latitud = (BigDecimal)objectInput.readObject();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(actuacionId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(codTecnico);

		if (nombre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nombre);
		}

		if (objetivo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(objetivo);
		}

		if (descripcion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descripcion);
		}

		if (zona == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zona);
		}

		if (comunidadAutonoma == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comunidadAutonoma);
		}

		if (provincia == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(provincia);
		}

		objectOutput.writeObject(superficie);
		objectOutput.writeObject(costeEjecucion);

		objectOutput.writeLong(regantes);

		if (cultivos == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cultivos);
		}

		if (situacion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(situacion);
		}

		objectOutput.writeObject(longitud);
		objectOutput.writeObject(latitud);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long actuacionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long codTecnico;
	public String nombre;
	public String objetivo;
	public String descripcion;
	public String zona;
	public String comunidadAutonoma;
	public String provincia;
	public BigDecimal superficie;
	public BigDecimal costeEjecucion;
	public long regantes;
	public String cultivos;
	public String situacion;
	public BigDecimal longitud;
	public BigDecimal latitud;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}