package es.grupoica.seiasaweb.combos.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import es.grupoica.seiasaweb.combos.application.model.ComunidadAutonoma;
import es.grupoica.seiasaweb.combos.application.model.Provincia;
import es.grupoica.seiasaweb.combos.application.model.Situacion;
import es.grupoica.seiasaweb.combos.application.persistence.ComunidadAutonomaDao;
import es.grupoica.seiasaweb.combos.application.persistence.ProvinciaDao;
import es.grupoica.seiasaweb.combos.application.persistence.SituacionDao;

/**
 * @author ica
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/combos",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Combos.Rest"
	},
	service = Application.class
)
public class CombosMapaControllerApplication extends Application {
	
	private static final Log _log = LogFactoryUtil.getLog(CombosMapaControllerApplication.class.getName());

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/autonomias")
	@Produces(MediaType.APPLICATION_JSON)
	public String getComboAutonomias() {

		String jsonString = "";
		JSONArray jSONArray = new JSONArray();
		ComunidadAutonomaDao dao = new ComunidadAutonomaDao();
		try {
			//Obtenemos las comunidades
			ArrayList<ComunidadAutonoma> comunidades = dao.getComunidades();
			System.out.println("Procesamos : " + comunidades.size() + " comunidades");
			if (comunidades != null && !comunidades.isEmpty()) {
				for (ComunidadAutonoma comunidad : comunidades) {
					//Construimos el JSON a enviar al cliente.
					JSONObject jSONObject = new JSONObject();
					jSONObject.put("id", comunidad.getIdentificador());
					jSONObject.put("nombre", comunidad.getNombre());
					jSONArray.put(jSONObject);
		    	}//fin for
			}//fin if
			jsonString = jSONArray.toString();
				
		}
		catch (Exception ex) {
			_log.error("Error al obtener el JSON de Comunidades Autonomas");
			ex.printStackTrace();
		}
	

		return jsonString;
	}
	
	
	@GET
	@Path("/provincias")
	@Produces(MediaType.APPLICATION_JSON)
	public String getComboProvincias() {

		String jsonString = "";
		JSONArray jSONArray = new JSONArray();
		ProvinciaDao dao = new ProvinciaDao();
		try {
			//Obtenemos las provincias
			ArrayList<Provincia> provincias = dao.getProvincias();
			System.out.println("Procesamos : " + provincias.size() + " provincias");
			if (provincias != null && !provincias.isEmpty()) {
				for (Provincia provincia : provincias) {
					//Construimos el JSON a enviar al cliente.
					JSONObject jSONObject = new JSONObject();
					jSONObject.put("id", provincia.getIdentificador());
					jSONObject.put("nombre", provincia.getNombre());
					jSONArray.put(jSONObject);
		    	}//fin for
			}//fin if
			jsonString = jSONArray.toString();
				
		}
		catch (Exception ex) {
			_log.error("Error al obtener el JSON de provincias");
			ex.printStackTrace();
		}
	

		return jsonString;
	}
	
	
	@GET
	@Path("/situaciones")
	@Produces(MediaType.APPLICATION_JSON)
	public String getComboSituaciones() {

		String jsonString = "";
		JSONArray jSONArray = new JSONArray();
		SituacionDao dao = new SituacionDao();
		try {
			//Obtenemos las situaciones
			ArrayList<Situacion> situaciones = dao.getSituaciones();
			System.out.println("Procesamos : " + situaciones.size() + " situaciones");
			if (situaciones != null && !situaciones.isEmpty()) {
				for (Situacion situacion : situaciones) {
					//Construimos el JSON a enviar al cliente.
					JSONObject jSONObject = new JSONObject();
					jSONObject.put("id", situacion.getIdentificador());
					jSONObject.put("nombre", situacion.getNombre());
					jSONObject.put("colorSituacion", situacion.getColorIcono());
					jSONArray.put(jSONObject);
		    	}//fin for
			}//fin if
			jsonString = jSONArray.toString();
				
		}
		catch (Exception ex) {
			_log.error("Error al obtener el JSON de situaciones");
			ex.printStackTrace();
		}
	

		return jsonString;
	}

}