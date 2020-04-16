package es.grupoica.seiasaweb.combos.application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import es.grupoica.seiasaweb.combos.application.model.ComunidadAutonoma;

public class ComunidadAutonomaDao {
	
private static final Log _log = LogFactoryUtil.getLog(ComunidadAutonomaDao.class.getName());
	
	/**
	 * Genera un listado de ComunidadesAutonomas
	 * @return
	 */
	public ArrayList<ComunidadAutonoma> getComunidades () {
		
		Connection connection = null;
	    PreparedStatement ptmt = null;
	    ResultSet resultSet = null;
	    ArrayList<ComunidadAutonoma> comunidades = null;
		
	    try {
	    	String sqlComunidades = new String("SELECT id, nombre FROM Comunidad_Autonoma");
	    	connection = DataAccess.getConnection();
	    	//PreparedStatement
	    	ptmt = connection.prepareStatement(sqlComunidades);
	    	//Ejecutamos la consulta	
	    	resultSet = ptmt.executeQuery();
	    	//Iniciamos la lista 
	    	comunidades = new ArrayList<ComunidadAutonoma>();
	    	    	
	    	while (resultSet.next()) {
	    		//Obtenemos los datos de Comunidades Autonoma y generamos el Array de las obtenidas
	    		ComunidadAutonoma comunidad = new ComunidadAutonoma();
	    		comunidad.setIdentificador(resultSet.getString("id"));
	    		comunidad.setNombre(resultSet.getString("nombre"));
	    			    	
	    		//Añadimos a la lista la Comunidad Autónoma obtenida
	    		comunidades.add(comunidad);
	    		
        	}//fin while
        }
	    catch (Exception ex) {
	    	_log.error("Error en la obtención de los datos de las Comunidades Autonomas");
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
	    
	    return comunidades;
	}  

}
