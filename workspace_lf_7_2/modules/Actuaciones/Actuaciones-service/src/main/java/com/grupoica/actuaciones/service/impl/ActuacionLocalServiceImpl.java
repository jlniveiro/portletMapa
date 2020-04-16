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

package com.grupoica.actuaciones.service.impl;

import com.grupoica.actuaciones.model.Actuacion;
import com.grupoica.actuaciones.service.base.ActuacionLocalServiceBaseImpl;
import com.grupoica.actuaciones.service.persistence.ActuacionUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the actuacion local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.grupoica.actuaciones.service.ActuacionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActuacionLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.grupoica.actuaciones.model.Actuacion",
	service = AopService.class
)
public class ActuacionLocalServiceImpl extends ActuacionLocalServiceBaseImpl{

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.grupoica.actuaciones.service.ActuacionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.grupoica.actuaciones.service.ActuacionLocalServiceUtil</code>.
	 */
	
	public ServiceContext serviceContext = new ServiceContext();
	
	@Indexable(
			type = IndexableType.REINDEX
			)
	 public Actuacion addActuacion(long groupId, long codTecnico, String nombre,String objetivo, String descripcion, String zona, String comunidadAutonoma,
			 						String provincia, BigDecimal superficie, BigDecimal costeEjecucion, long regantes, String cultivos, String situacion,
			 						BigDecimal longitud, BigDecimal latitud) throws PortalException {
		 
	        long actuaciontId = counterLocalService.increment(Actuacion.class.getName());
	        
	        Group group = groupLocalService.getGroup(groupId);
	        
	        
	        //User
	        long userId = 0;
	        
	        
	        //Actuacion
	        
		 	Actuacion actuacion = createActuacion(actuaciontId);
		 	
		 	//Añado los valores necesarios y los obligatorios
		 	
		 	actuacion.setCompanyId(group.getCompanyId());
		 	actuacion.setGroupId(groupId);
		 	actuacion.setUserId(userId);
			
			
		 	actuacion.setCodTecnico(codTecnico);
		 	actuacion.setNombre(nombre);
		 	actuacion.setObjetivo(objetivo);
			actuacion.setDescripcion(descripcion);
			actuacion.setZona(zona);
		 	actuacion.setComunidadAutonoma(comunidadAutonoma);
		 	actuacion.setProvincia(provincia);
		 	actuacion.setCosteEjecucion(costeEjecucion);
		 	actuacion.setSuperficie(superficie);
		 	actuacion.setRegantes(regantes);
		 	actuacion.setCultivos(cultivos);
		 	actuacion.setSituacion(situacion);
		 	actuacion.setLongitud(longitud);
			actuacion.setLatitud(latitud);
			
			Date createDate = new Date();
			Date modifiedDate = new Date();

		 	actuacion.setCreateDate(createDate);
		 	actuacion.setModifiedDate(modifiedDate);
		 	
		 	actuacion = super.addActuacion(actuacion);
		 	
		 	assetEntryLocalService.updateEntry( userId, groupId, 
		 		createDate, modifiedDate, Actuacion.class.getName(), actuaciontId, actuacion.getUuid(),0, null, null, true, 
		 		true, createDate, null,createDate, null,ContentTypes.TEXT_HTML, actuacion.getNombre(), actuacion.getDescripcion(), 
		 		null, null, null, 0, 0, null);
		 	
		 	Indexer<Actuacion> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Actuacion.class);
		 	
		 	indexer.reindex(actuacion);
		 	
		 	return actuacion;
		 
	 }
	 
	 public List<Actuacion> findAll(){
		 return ActuacionUtil.findAll();
	 }
	 
	 public List<Actuacion> buscarPorTituloComAutProvinciaSituacion(String nombre, String comunidadAutonoma, String provincia, String situacion){
		 return ActuacionUtil.findByTituloComAutProvinciaSituacion(nombre, comunidadAutonoma, provincia, situacion);
	 }
	 
	 
}