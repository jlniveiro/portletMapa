package es.grupoica.seiasaweb.buscador.application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import es.grupoica.seiasaweb.buscador.application.model.Actuacion;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class ActuacionesDao {
	
	private static final Log _log = LogFactoryUtil.getLog(ActuacionesDao.class.getName());
	
	/**
	 * Genera la consulta de búsqueda de actuaciones a realizar
	 * @param nombre
	 * @param comunidad
	 * @param provincia
	 * @param situacion
	 * @return
	 */
	private String queryActuaciones(String nombre, String comunidadAutonoma, String provincia, String situacion) {
		
		
		StringBuffer sqlActuaciones = new StringBuffer("SELECT entryId, codTecnico, nombre, ");
	    sqlActuaciones.append(" ubicacion, comunidadAutonoma, provincia, superficie, regantes, ")
	                  .append("	cultivos, situacion, colorSituacion, longitud, latitud ")
	                  .append("	FROM VW_PUB_ACTUACIONES where 1 = 1 ");
	    if (!nombre.trim().isEmpty()) {
	    	sqlActuaciones.append(" AND UPPER(nombre) LIKE ? ");
	    }
	    if (!comunidadAutonoma.trim().isEmpty()) {
	    	sqlActuaciones.append(" AND comunidadAutonoma = ? ");
	    }
	    if (!provincia.trim().isEmpty()) {
	    	sqlActuaciones.append(" AND provincia = ? ");
	    }
	    if (!situacion.trim().isEmpty()) {
	    	sqlActuaciones.append(" AND situacion = ? ");
	    }
	    
	    System.out.println("Consulta a realizar: " + sqlActuaciones.toString());
	    
	    return sqlActuaciones.toString();
	}

	
	
	/**
	 * Genera un listado de Actuaciones actualmente registradas
	 * @param nombre
	 * @param comunidad
	 * @param provincia
	 * @param situacion
	 * @return
	 */
	public ArrayList<Actuacion> getActuaciones (String nombre, String comunidad, String provincia, String situacion) {
		
		Connection connection = null;
	    PreparedStatement ptmt = null;
	    ResultSet resultSet = null;
	    ArrayList<Actuacion> actuaciones = null;
		
	    try {
	    	connection = DataAccess.getConnection();
	    	//PreparedStatement
	    	ptmt = connection.prepareStatement(queryActuaciones(nombre, comunidad, provincia, situacion));
	    	int numParametro = 0;
	    	if (!nombre.trim().isEmpty()) {
	    		ptmt.setString(++numParametro, "%" + nombre.toUpperCase() + "%");
		    }
		    if (!comunidad.trim().isEmpty()) {
		    	ptmt.setString(++numParametro, comunidad);
		    }
		    if (!provincia.trim().isEmpty()) {
		    	ptmt.setString(++numParametro, provincia);
		    }
		    if (!situacion.trim().isEmpty()) {
		    	ptmt.setString(++numParametro, situacion);
		    }
	    	//Ejecutamos la consulta	
	    	resultSet = ptmt.executeQuery();
	    	//Iniciamos la lista 
	    	actuaciones = new ArrayList<Actuacion>();
	    	    	
	    	while (resultSet.next()) {
	    		//Obtenemos los datos de Actuaciones y generamos el Array de las obtenidas
	    		Actuacion actuacion = new Actuacion();
	    		actuacion.setEntryId(resultSet.getString("entryId"));
	    		actuacion.setCodTecnico(resultSet.getString("codTecnico"));
	    		actuacion.setNombre(resultSet.getString("nombre"));
	    		actuacion.setUbicacion(resultSet.getString("ubicacion"));
	    		actuacion.setComunidadAutonoma(resultSet.getString("comunidadAutonoma"));
	    		actuacion.setProvincia(resultSet.getString("provincia"));
	    		actuacion.setSuperficie(resultSet.getString("superficie") + " ha");
	    		actuacion.setRegantes(resultSet.getString("regantes"));
	    		actuacion.setCultivos(resultSet.getString("cultivos"));
	    		actuacion.setSituacion(resultSet.getString("situacion"));
	    		actuacion.setColorSituacion(resultSet.getString("colorSituacion"));
	    		actuacion.setLongitud(resultSet.getString("longitud"));
	    		actuacion.setLatitud(resultSet.getString("latitud"));
	    	
	    		//Añadimos a la lista la Actuacion obtenida
	    		actuaciones.add(actuacion);
	    		
        	}//fin while
        }
	    catch (Exception ex) {
	    	_log.error("Error en la obtención de los datos de las Actuaciones");
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
	    
	    return actuaciones;
	}  
	
}

