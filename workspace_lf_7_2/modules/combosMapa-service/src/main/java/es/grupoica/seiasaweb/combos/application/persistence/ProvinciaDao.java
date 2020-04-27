package es.grupoica.seiasaweb.combos.application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import es.grupoica.seiasaweb.combos.application.model.Provincia;

public class ProvinciaDao {
	
private static final Log _log = LogFactoryUtil.getLog(ProvinciaDao.class.getName());
	
	/**
	 * Genera un listado de Provincias
	 * @return
	 */
	public ArrayList<Provincia> getProvincias () {
		
		Connection connection = null;
	    PreparedStatement ptmt = null;
	    ResultSet resultSet = null;
	    ArrayList<Provincia> provincias = null;
		
	    try {
	    	String sqlProvincias = new String("SELECT id, nombre FROM Provincia");
	    	connection = DataAccess.getConnection();
	    	//PreparedStatement
	    	ptmt = connection.prepareStatement(sqlProvincias);
	    	//Ejecutamos la consulta	
	    	resultSet = ptmt.executeQuery();
	    	//Iniciamos la lista 
	    	provincias = new ArrayList<Provincia>();
	    	    	
	    	while (resultSet.next()) {
	    		//Obtenemos los datos de Situaciones y generamos el Array de las obtenidas
	    		Provincia provincia = new Provincia();
	    		provincia.setIdentificador(resultSet.getString("id"));
	    		provincia.setNombre(resultSet.getString("nombre"));
	    			    	
	    		//Añadimos a la lista la Provincia obtenida
	    		provincias.add(provincia);
	    		
        	}//fin while
        }
	    catch (Exception ex) {
	    	_log.error("Error en la obtención de los datos de las Provincias");
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
	    
	    return provincias;
	}  


}
