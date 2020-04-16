package es.grupoica.seiasaweb.buscador.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

//import javax.json.Json;
//import javax.json.JsonArrayBuilder;
//import javax.json.JsonObjectBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import es.grupoica.seiasaweb.buscador.application.model.Actuacion;
import es.grupoica.seiasaweb.buscador.application.persistence.ActuacionesDao;

/**
 * @author ica
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/buscador",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Buscador.Rest"
	},
	service = Application.class
)
public class BuscadorActuacionesControllerApplication extends Application {
	
	private static final Log _log = LogFactoryUtil.getLog(BuscadorActuacionesControllerApplication.class.getName());

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	
	@GET
	@Path("/actuaciones")
	@Produces(MediaType.APPLICATION_JSON)
	public String getActuaciones(
			@QueryParam("nombre") String nombre,
			@QueryParam("comunidad") String comunidad,
			@QueryParam("provincia") String provincia,
			@QueryParam("situacion") String situacion) {

		String jsonString = "";
		JSONArray jSONArray = new JSONArray();
		ActuacionesDao dao = new ActuacionesDao();
		try {
			//Parámetros recibidos. Comprobamos si son nulos y evitamos errores
			if (nombre == null) nombre = "";
			if (comunidad == null) comunidad = "";
			if (provincia == null) provincia = "";
			if (situacion == null) situacion = "";
			//Obtenemos las actuaciones
			ArrayList<Actuacion> actuaciones = dao.getActuaciones(nombre, comunidad, provincia, situacion);
			System.out.println("Procesamos : " + actuaciones.size() + " actuaciones");
			if (actuaciones != null && !actuaciones.isEmpty()) {
				for (Actuacion actua : actuaciones) {
					//Construimos el JSON a enviar al cliente.
					JSONObject jSONObject = new JSONObject();
					jSONObject.put("entryId", actua.getCodTecnico());
					jSONObject.put("codTecnico", actua.getCodTecnico());
					jSONObject.put("nombre", actua.getNombre());
					jSONObject.put("ubicacion", actua.getUbicacion());
					jSONObject.put("comunidadAutonoma", actua.getComunidadAutonoma());
					jSONObject.put("provincia", actua.getProvincia());
					jSONObject.put("superficie", actua.getSuperficie());
					jSONObject.put("regantes", actua.getRegantes());
					jSONObject.put("cultivos", actua.getCultivos());
					jSONObject.put("situacion", actua.getSituacion());
					jSONObject.put("colorSituacion", actua.getColorSituacion());
					jSONObject.put("longitud", actua.getLongitud());
					jSONObject.put("latitud", actua.getLatitud());
					jSONArray.put(jSONObject);
			
		    	}//fin for
			}//fin if
			//jsonString = builder.build().toString();
			jsonString = jSONArray.toString();
				
		}
		catch (Exception ex) {
			_log.error("Error al obtener el JSON de actuaciones");
			ex.printStackTrace();
		}

		

		return jsonString;
	}
	
	
}