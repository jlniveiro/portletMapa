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
import com.grupoica.actuaciones.service.base.ActuacionServiceBaseImpl;
import com.grupoica.actuaciones.service.persistence.ActuacionUtil;
import com.grupoica.actuaciones.service.persistence.impl.ActuacionPersistenceImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;


import com.liferay.portal.kernel.dao.jdbc.DataAccess;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the actuacion remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.grupoica.actuaciones.service.ActuacionService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActuacionServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=actuaciones",
		"json.web.service.context.path=Actuacion"
	},
	service = AopService.class
)
public class ActuacionServiceImpl extends ActuacionServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.grupoica.actuaciones.service.ActuacionServiceUtil</code> to access the actuacion remote service.
	 */	
	
	
	public boolean importActuaciones() {
		
		boolean imported = true;
		System.out.println("Comienza la importación de actuaciones.");

		Connection connection = null;
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        
        int contActuacionesNuevas = 0;
        
        String sql = "select * from ActuacionImp";
        try {
            connection = DataAccess.getConnection();
            ptmt = connection.prepareStatement(sql);
            resultSet = ptmt.executeQuery();
            
            while (resultSet.next()) {
                	
            	long codtecnicoAniadir = Long.parseLong(resultSet.getString("codTecnico"));
            	if(ActuacionUtil.findByCodTecnico(codtecnicoAniadir).isEmpty()) {
            		
            		 System.out.println("Se ha añadido la obra: "+resultSet.getString("codTecnico"));
            		 actuacionLocalService.addActuacion(20124, Long.parseLong(resultSet.getString("codTecnico")), resultSet.getString("nombre"), 
								resultSet.getString("objetivo"), resultSet.getString("descripcion"),
								resultSet.getString("zona"), resultSet.getString("comunidadAutonoma"),
								resultSet.getString("provincia"), new BigDecimal(resultSet.getString("superficie")), 
								new BigDecimal(resultSet.getString("costeEjecucion")), Long.parseLong(resultSet.getString("regantes")), 
								resultSet.getString("cultivos"), resultSet.getString("situacion"), 
								new BigDecimal(resultSet.getString("longitud")), new BigDecimal(resultSet.getString("latitud")));
            	
            		 contActuacionesNuevas++;
            	}
            }
            
            System.out.println("Se han añadido "+contActuacionesNuevas+" actuaciones nuevas.");
        }catch (Exception e) {
        	System.out.println(e);
        	imported = false;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ptmt != null) {
                    ptmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // we can ignore this error: it must not occur during normal operation (logging is also not necessary, but causes no harm)
                System.out.println("An error occured during closing the result set - the prepared statement - connection.");
            }
        } 
            
        
        return imported;
	}
}