package es.grupoica.seiasaweb.combos.application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import es.grupoica.seiasaweb.combos.application.model.Situacion;

public class SituacionDao {
	
private static final Log _log = LogFactoryUtil.getLog(SituacionDao.class.getName());
	
	/**
	 * Genera un listado de Provincias
	 * @return
	 */
	public ArrayList<Situacion> getSituaciones () {
		
		Connection connection = null;
	    PreparedStatement ptmt = null;
	    ResultSet resultSet = null;
	    ArrayList<Situacion> situaciones = null;
		
	    try {
	    	String sqlSituaciones = new String("SELECT id, nombre, colorIcono FROM Situacion");
	    	connection = DataAccess.getConnection();
	    	//PreparedStatement
	    	ptmt = connection.prepareStatement(sqlSituaciones);
	    	//Ejecutamos la consulta	
	    	resultSet = ptmt.executeQuery();
	    	//Iniciamos la lista 
	    	situaciones = new ArrayList<Situacion>();
	    	    	
	    	while (resultSet.next()) {
	    		//Obtenemos los datos de Situaciones y generamos el Array de las obtenidas
	    		Situacion situacion = new Situacion();
	    		situacion.setIdentificador(resultSet.getString("id"));
	    		situacion.setNombre(resultSet.getString("nombre"));
	    		situacion.setColorIcono(resultSet.getString("colorIcono"));
	    			    	
	    		//Añadimos a la lista la Situacion obtenida
	    		situaciones.add(situacion);
	    		
        	}//fin while
        }
	    catch (Exception ex) {
	    	_log.error("Error en la obtención de los datos de las Situaciones");
	    	ex.printStackTrace();
	    }
        finally {
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
	            _log.error("An error occured during closing the result set - the prepared statement - connection.");
	        }
	    } 
	    
	    return situaciones;
	}  

}
