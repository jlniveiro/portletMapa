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
import com.grupoica.actuaciones.model.ActuacionModel;
import com.grupoica.actuaciones.model.ActuacionSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.math.BigDecimal;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the Actuacion service. Represents a row in the &quot;Actuaciones_Actuacion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>ActuacionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ActuacionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActuacionImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ActuacionModelImpl
	extends BaseModelImpl<Actuacion> implements ActuacionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a actuacion model instance should use the <code>Actuacion</code> interface instead.
	 */
	public static final String TABLE_NAME = "Actuaciones_Actuacion";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"actuacionId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"codTecnico", Types.BIGINT}, {"nombre", Types.VARCHAR},
		{"objetivo", Types.VARCHAR}, {"descripcion", Types.VARCHAR},
		{"zona", Types.VARCHAR}, {"comunidadAutonoma", Types.VARCHAR},
		{"provincia", Types.VARCHAR}, {"superficie", Types.DECIMAL},
		{"costeEjecucion", Types.DECIMAL}, {"regantes", Types.BIGINT},
		{"cultivos", Types.VARCHAR}, {"situacion", Types.VARCHAR},
		{"longitud", Types.DECIMAL}, {"latitud", Types.DECIMAL},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("actuacionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("codTecnico", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nombre", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("objetivo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("descripcion", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("zona", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("comunidadAutonoma", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("provincia", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("superficie", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("costeEjecucion", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("regantes", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cultivos", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("situacion", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("longitud", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("latitud", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Actuaciones_Actuacion (uuid_ VARCHAR(75) null,actuacionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,codTecnico LONG,nombre VARCHAR(75) null,objetivo VARCHAR(75) null,descripcion VARCHAR(75) null,zona VARCHAR(75) null,comunidadAutonoma VARCHAR(75) null,provincia VARCHAR(75) null,superficie DECIMAL(30, 16) null,costeEjecucion DECIMAL(30, 16) null,regantes LONG,cultivos VARCHAR(75) null,situacion VARCHAR(75) null,longitud DECIMAL(30, 16) null,latitud DECIMAL(30, 16) null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table Actuaciones_Actuacion";

	public static final String ORDER_BY_JPQL =
		" ORDER BY actuacion.actuacionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Actuaciones_Actuacion.actuacionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long CODTECNICO_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long COMUNIDADAUTONOMA_COLUMN_BITMASK = 4L;

	public static final long GROUPID_COLUMN_BITMASK = 8L;

	public static final long LATITUD_COLUMN_BITMASK = 16L;

	public static final long LONGITUD_COLUMN_BITMASK = 32L;

	public static final long NOMBRE_COLUMN_BITMASK = 64L;

	public static final long PROVINCIA_COLUMN_BITMASK = 128L;

	public static final long SITUACION_COLUMN_BITMASK = 256L;

	public static final long STATUS_COLUMN_BITMASK = 512L;

	public static final long UUID_COLUMN_BITMASK = 1024L;

	public static final long ACTUACIONID_COLUMN_BITMASK = 2048L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Actuacion toModel(ActuacionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Actuacion model = new ActuacionImpl();

		model.setUuid(soapModel.getUuid());
		model.setActuacionId(soapModel.getActuacionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCodTecnico(soapModel.getCodTecnico());
		model.setNombre(soapModel.getNombre());
		model.setObjetivo(soapModel.getObjetivo());
		model.setDescripcion(soapModel.getDescripcion());
		model.setZona(soapModel.getZona());
		model.setComunidadAutonoma(soapModel.getComunidadAutonoma());
		model.setProvincia(soapModel.getProvincia());
		model.setSuperficie(soapModel.getSuperficie());
		model.setCosteEjecucion(soapModel.getCosteEjecucion());
		model.setRegantes(soapModel.getRegantes());
		model.setCultivos(soapModel.getCultivos());
		model.setSituacion(soapModel.getSituacion());
		model.setLongitud(soapModel.getLongitud());
		model.setLatitud(soapModel.getLatitud());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Actuacion> toModels(ActuacionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Actuacion> models = new ArrayList<Actuacion>(soapModels.length);

		for (ActuacionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ActuacionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _actuacionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setActuacionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _actuacionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Actuacion.class;
	}

	@Override
	public String getModelClassName() {
		return Actuacion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Actuacion, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Actuacion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Actuacion, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Actuacion)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Actuacion, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Actuacion, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Actuacion)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Actuacion, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Actuacion, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Actuacion>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Actuacion.class.getClassLoader(), Actuacion.class,
			ModelWrapper.class);

		try {
			Constructor<Actuacion> constructor =
				(Constructor<Actuacion>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Actuacion, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Actuacion, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Actuacion, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Actuacion, Object>>();
		Map<String, BiConsumer<Actuacion, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Actuacion, ?>>();

		attributeGetterFunctions.put("uuid", Actuacion::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Actuacion, String>)Actuacion::setUuid);
		attributeGetterFunctions.put("actuacionId", Actuacion::getActuacionId);
		attributeSetterBiConsumers.put(
			"actuacionId",
			(BiConsumer<Actuacion, Long>)Actuacion::setActuacionId);
		attributeGetterFunctions.put("groupId", Actuacion::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Actuacion, Long>)Actuacion::setGroupId);
		attributeGetterFunctions.put("companyId", Actuacion::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Actuacion, Long>)Actuacion::setCompanyId);
		attributeGetterFunctions.put("userId", Actuacion::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Actuacion, Long>)Actuacion::setUserId);
		attributeGetterFunctions.put("userName", Actuacion::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Actuacion, String>)Actuacion::setUserName);
		attributeGetterFunctions.put("createDate", Actuacion::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<Actuacion, Date>)Actuacion::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", Actuacion::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Actuacion, Date>)Actuacion::setModifiedDate);
		attributeGetterFunctions.put("codTecnico", Actuacion::getCodTecnico);
		attributeSetterBiConsumers.put(
			"codTecnico",
			(BiConsumer<Actuacion, Long>)Actuacion::setCodTecnico);
		attributeGetterFunctions.put("nombre", Actuacion::getNombre);
		attributeSetterBiConsumers.put(
			"nombre", (BiConsumer<Actuacion, String>)Actuacion::setNombre);
		attributeGetterFunctions.put("objetivo", Actuacion::getObjetivo);
		attributeSetterBiConsumers.put(
			"objetivo", (BiConsumer<Actuacion, String>)Actuacion::setObjetivo);
		attributeGetterFunctions.put("descripcion", Actuacion::getDescripcion);
		attributeSetterBiConsumers.put(
			"descripcion",
			(BiConsumer<Actuacion, String>)Actuacion::setDescripcion);
		attributeGetterFunctions.put("zona", Actuacion::getZona);
		attributeSetterBiConsumers.put(
			"zona", (BiConsumer<Actuacion, String>)Actuacion::setZona);
		attributeGetterFunctions.put(
			"comunidadAutonoma", Actuacion::getComunidadAutonoma);
		attributeSetterBiConsumers.put(
			"comunidadAutonoma",
			(BiConsumer<Actuacion, String>)Actuacion::setComunidadAutonoma);
		attributeGetterFunctions.put("provincia", Actuacion::getProvincia);
		attributeSetterBiConsumers.put(
			"provincia",
			(BiConsumer<Actuacion, String>)Actuacion::setProvincia);
		attributeGetterFunctions.put("superficie", Actuacion::getSuperficie);
		attributeSetterBiConsumers.put(
			"superficie",
			(BiConsumer<Actuacion, BigDecimal>)Actuacion::setSuperficie);
		attributeGetterFunctions.put(
			"costeEjecucion", Actuacion::getCosteEjecucion);
		attributeSetterBiConsumers.put(
			"costeEjecucion",
			(BiConsumer<Actuacion, BigDecimal>)Actuacion::setCosteEjecucion);
		attributeGetterFunctions.put("regantes", Actuacion::getRegantes);
		attributeSetterBiConsumers.put(
			"regantes", (BiConsumer<Actuacion, Long>)Actuacion::setRegantes);
		attributeGetterFunctions.put("cultivos", Actuacion::getCultivos);
		attributeSetterBiConsumers.put(
			"cultivos", (BiConsumer<Actuacion, String>)Actuacion::setCultivos);
		attributeGetterFunctions.put("situacion", Actuacion::getSituacion);
		attributeSetterBiConsumers.put(
			"situacion",
			(BiConsumer<Actuacion, String>)Actuacion::setSituacion);
		attributeGetterFunctions.put("longitud", Actuacion::getLongitud);
		attributeSetterBiConsumers.put(
			"longitud",
			(BiConsumer<Actuacion, BigDecimal>)Actuacion::setLongitud);
		attributeGetterFunctions.put("latitud", Actuacion::getLatitud);
		attributeSetterBiConsumers.put(
			"latitud",
			(BiConsumer<Actuacion, BigDecimal>)Actuacion::setLatitud);
		attributeGetterFunctions.put("status", Actuacion::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Actuacion, Integer>)Actuacion::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", Actuacion::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<Actuacion, Long>)Actuacion::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", Actuacion::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<Actuacion, String>)Actuacion::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", Actuacion::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<Actuacion, Date>)Actuacion::setStatusDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getActuacionId() {
		return _actuacionId;
	}

	@Override
	public void setActuacionId(long actuacionId) {
		_actuacionId = actuacionId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCodTecnico() {
		return _codTecnico;
	}

	@Override
	public void setCodTecnico(long codTecnico) {
		_columnBitmask |= CODTECNICO_COLUMN_BITMASK;

		if (!_setOriginalCodTecnico) {
			_setOriginalCodTecnico = true;

			_originalCodTecnico = _codTecnico;
		}

		_codTecnico = codTecnico;
	}

	public long getOriginalCodTecnico() {
		return _originalCodTecnico;
	}

	@JSON
	@Override
	public String getNombre() {
		if (_nombre == null) {
			return "";
		}
		else {
			return _nombre;
		}
	}

	@Override
	public void setNombre(String nombre) {
		_columnBitmask |= NOMBRE_COLUMN_BITMASK;

		if (_originalNombre == null) {
			_originalNombre = _nombre;
		}

		_nombre = nombre;
	}

	public String getOriginalNombre() {
		return GetterUtil.getString(_originalNombre);
	}

	@JSON
	@Override
	public String getObjetivo() {
		if (_objetivo == null) {
			return "";
		}
		else {
			return _objetivo;
		}
	}

	@Override
	public void setObjetivo(String objetivo) {
		_objetivo = objetivo;
	}

	@JSON
	@Override
	public String getDescripcion() {
		if (_descripcion == null) {
			return "";
		}
		else {
			return _descripcion;
		}
	}

	@Override
	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

	@JSON
	@Override
	public String getZona() {
		if (_zona == null) {
			return "";
		}
		else {
			return _zona;
		}
	}

	@Override
	public void setZona(String zona) {
		_zona = zona;
	}

	@JSON
	@Override
	public String getComunidadAutonoma() {
		if (_comunidadAutonoma == null) {
			return "";
		}
		else {
			return _comunidadAutonoma;
		}
	}

	@Override
	public void setComunidadAutonoma(String comunidadAutonoma) {
		_columnBitmask |= COMUNIDADAUTONOMA_COLUMN_BITMASK;

		if (_originalComunidadAutonoma == null) {
			_originalComunidadAutonoma = _comunidadAutonoma;
		}

		_comunidadAutonoma = comunidadAutonoma;
	}

	public String getOriginalComunidadAutonoma() {
		return GetterUtil.getString(_originalComunidadAutonoma);
	}

	@JSON
	@Override
	public String getProvincia() {
		if (_provincia == null) {
			return "";
		}
		else {
			return _provincia;
		}
	}

	@Override
	public void setProvincia(String provincia) {
		_columnBitmask |= PROVINCIA_COLUMN_BITMASK;

		if (_originalProvincia == null) {
			_originalProvincia = _provincia;
		}

		_provincia = provincia;
	}

	public String getOriginalProvincia() {
		return GetterUtil.getString(_originalProvincia);
	}

	@JSON
	@Override
	public BigDecimal getSuperficie() {
		return _superficie;
	}

	@Override
	public void setSuperficie(BigDecimal superficie) {
		_superficie = superficie;
	}

	@JSON
	@Override
	public BigDecimal getCosteEjecucion() {
		return _costeEjecucion;
	}

	@Override
	public void setCosteEjecucion(BigDecimal costeEjecucion) {
		_costeEjecucion = costeEjecucion;
	}

	@JSON
	@Override
	public long getRegantes() {
		return _regantes;
	}

	@Override
	public void setRegantes(long regantes) {
		_regantes = regantes;
	}

	@JSON
	@Override
	public String getCultivos() {
		if (_cultivos == null) {
			return "";
		}
		else {
			return _cultivos;
		}
	}

	@Override
	public void setCultivos(String cultivos) {
		_cultivos = cultivos;
	}

	@JSON
	@Override
	public String getSituacion() {
		if (_situacion == null) {
			return "";
		}
		else {
			return _situacion;
		}
	}

	@Override
	public void setSituacion(String situacion) {
		_columnBitmask |= SITUACION_COLUMN_BITMASK;

		if (_originalSituacion == null) {
			_originalSituacion = _situacion;
		}

		_situacion = situacion;
	}

	public String getOriginalSituacion() {
		return GetterUtil.getString(_originalSituacion);
	}

	@JSON
	@Override
	public BigDecimal getLongitud() {
		return _longitud;
	}

	@Override
	public void setLongitud(BigDecimal longitud) {
		_columnBitmask |= LONGITUD_COLUMN_BITMASK;

		if (_originalLongitud == null) {
			_originalLongitud = _longitud;
		}

		_longitud = longitud;
	}

	public BigDecimal getOriginalLongitud() {
		return _originalLongitud;
	}

	@JSON
	@Override
	public BigDecimal getLatitud() {
		return _latitud;
	}

	@Override
	public void setLatitud(BigDecimal latitud) {
		_columnBitmask |= LATITUD_COLUMN_BITMASK;

		if (_originalLatitud == null) {
			_originalLatitud = _latitud;
		}

		_latitud = latitud;
	}

	public BigDecimal getOriginalLatitud() {
		return _originalLatitud;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Actuacion.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Actuacion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Actuacion toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Actuacion>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ActuacionImpl actuacionImpl = new ActuacionImpl();

		actuacionImpl.setUuid(getUuid());
		actuacionImpl.setActuacionId(getActuacionId());
		actuacionImpl.setGroupId(getGroupId());
		actuacionImpl.setCompanyId(getCompanyId());
		actuacionImpl.setUserId(getUserId());
		actuacionImpl.setUserName(getUserName());
		actuacionImpl.setCreateDate(getCreateDate());
		actuacionImpl.setModifiedDate(getModifiedDate());
		actuacionImpl.setCodTecnico(getCodTecnico());
		actuacionImpl.setNombre(getNombre());
		actuacionImpl.setObjetivo(getObjetivo());
		actuacionImpl.setDescripcion(getDescripcion());
		actuacionImpl.setZona(getZona());
		actuacionImpl.setComunidadAutonoma(getComunidadAutonoma());
		actuacionImpl.setProvincia(getProvincia());
		actuacionImpl.setSuperficie(getSuperficie());
		actuacionImpl.setCosteEjecucion(getCosteEjecucion());
		actuacionImpl.setRegantes(getRegantes());
		actuacionImpl.setCultivos(getCultivos());
		actuacionImpl.setSituacion(getSituacion());
		actuacionImpl.setLongitud(getLongitud());
		actuacionImpl.setLatitud(getLatitud());
		actuacionImpl.setStatus(getStatus());
		actuacionImpl.setStatusByUserId(getStatusByUserId());
		actuacionImpl.setStatusByUserName(getStatusByUserName());
		actuacionImpl.setStatusDate(getStatusDate());

		actuacionImpl.resetOriginalValues();

		return actuacionImpl;
	}

	@Override
	public int compareTo(Actuacion actuacion) {
		long primaryKey = actuacion.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Actuacion)) {
			return false;
		}

		Actuacion actuacion = (Actuacion)obj;

		long primaryKey = actuacion.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		ActuacionModelImpl actuacionModelImpl = this;

		actuacionModelImpl._originalUuid = actuacionModelImpl._uuid;

		actuacionModelImpl._originalGroupId = actuacionModelImpl._groupId;

		actuacionModelImpl._setOriginalGroupId = false;

		actuacionModelImpl._originalCompanyId = actuacionModelImpl._companyId;

		actuacionModelImpl._setOriginalCompanyId = false;

		actuacionModelImpl._setModifiedDate = false;

		actuacionModelImpl._originalCodTecnico = actuacionModelImpl._codTecnico;

		actuacionModelImpl._setOriginalCodTecnico = false;

		actuacionModelImpl._originalNombre = actuacionModelImpl._nombre;

		actuacionModelImpl._originalComunidadAutonoma =
			actuacionModelImpl._comunidadAutonoma;

		actuacionModelImpl._originalProvincia = actuacionModelImpl._provincia;

		actuacionModelImpl._originalSituacion = actuacionModelImpl._situacion;

		actuacionModelImpl._originalLongitud = actuacionModelImpl._longitud;

		actuacionModelImpl._originalLatitud = actuacionModelImpl._latitud;

		actuacionModelImpl._originalStatus = actuacionModelImpl._status;

		actuacionModelImpl._setOriginalStatus = false;

		actuacionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Actuacion> toCacheModel() {
		ActuacionCacheModel actuacionCacheModel = new ActuacionCacheModel();

		actuacionCacheModel.uuid = getUuid();

		String uuid = actuacionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			actuacionCacheModel.uuid = null;
		}

		actuacionCacheModel.actuacionId = getActuacionId();

		actuacionCacheModel.groupId = getGroupId();

		actuacionCacheModel.companyId = getCompanyId();

		actuacionCacheModel.userId = getUserId();

		actuacionCacheModel.userName = getUserName();

		String userName = actuacionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			actuacionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			actuacionCacheModel.createDate = createDate.getTime();
		}
		else {
			actuacionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			actuacionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			actuacionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		actuacionCacheModel.codTecnico = getCodTecnico();

		actuacionCacheModel.nombre = getNombre();

		String nombre = actuacionCacheModel.nombre;

		if ((nombre != null) && (nombre.length() == 0)) {
			actuacionCacheModel.nombre = null;
		}

		actuacionCacheModel.objetivo = getObjetivo();

		String objetivo = actuacionCacheModel.objetivo;

		if ((objetivo != null) && (objetivo.length() == 0)) {
			actuacionCacheModel.objetivo = null;
		}

		actuacionCacheModel.descripcion = getDescripcion();

		String descripcion = actuacionCacheModel.descripcion;

		if ((descripcion != null) && (descripcion.length() == 0)) {
			actuacionCacheModel.descripcion = null;
		}

		actuacionCacheModel.zona = getZona();

		String zona = actuacionCacheModel.zona;

		if ((zona != null) && (zona.length() == 0)) {
			actuacionCacheModel.zona = null;
		}

		actuacionCacheModel.comunidadAutonoma = getComunidadAutonoma();

		String comunidadAutonoma = actuacionCacheModel.comunidadAutonoma;

		if ((comunidadAutonoma != null) && (comunidadAutonoma.length() == 0)) {
			actuacionCacheModel.comunidadAutonoma = null;
		}

		actuacionCacheModel.provincia = getProvincia();

		String provincia = actuacionCacheModel.provincia;

		if ((provincia != null) && (provincia.length() == 0)) {
			actuacionCacheModel.provincia = null;
		}

		actuacionCacheModel.superficie = getSuperficie();

		actuacionCacheModel.costeEjecucion = getCosteEjecucion();

		actuacionCacheModel.regantes = getRegantes();

		actuacionCacheModel.cultivos = getCultivos();

		String cultivos = actuacionCacheModel.cultivos;

		if ((cultivos != null) && (cultivos.length() == 0)) {
			actuacionCacheModel.cultivos = null;
		}

		actuacionCacheModel.situacion = getSituacion();

		String situacion = actuacionCacheModel.situacion;

		if ((situacion != null) && (situacion.length() == 0)) {
			actuacionCacheModel.situacion = null;
		}

		actuacionCacheModel.longitud = getLongitud();

		actuacionCacheModel.latitud = getLatitud();

		actuacionCacheModel.status = getStatus();

		actuacionCacheModel.statusByUserId = getStatusByUserId();

		actuacionCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = actuacionCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			actuacionCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			actuacionCacheModel.statusDate = statusDate.getTime();
		}
		else {
			actuacionCacheModel.statusDate = Long.MIN_VALUE;
		}

		return actuacionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Actuacion, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Actuacion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Actuacion, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Actuacion)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Actuacion, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Actuacion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Actuacion, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Actuacion)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Actuacion>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _actuacionId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _codTecnico;
	private long _originalCodTecnico;
	private boolean _setOriginalCodTecnico;
	private String _nombre;
	private String _originalNombre;
	private String _objetivo;
	private String _descripcion;
	private String _zona;
	private String _comunidadAutonoma;
	private String _originalComunidadAutonoma;
	private String _provincia;
	private String _originalProvincia;
	private BigDecimal _superficie;
	private BigDecimal _costeEjecucion;
	private long _regantes;
	private String _cultivos;
	private String _situacion;
	private String _originalSituacion;
	private BigDecimal _longitud;
	private BigDecimal _originalLongitud;
	private BigDecimal _latitud;
	private BigDecimal _originalLatitud;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private Actuacion _escapedModel;

}