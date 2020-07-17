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
import com.liferay.portal.kernel.service.ServiceContext;

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
		
	    ServiceContext serviceContext = new ServiceContext();
	    //HttpServletResponse resp = serviceContext.getResponse();

		String jsonString = "";
		JSONArray jSONArray = new JSONArray();
		ActuacionesDao dao = new ActuacionesDao();
		String viewURL = "/web/guest/listado-actuaciones/-/asset_publisher/I2YcN2wLXy9L/content/id/34158?_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_redirect=http%3A%2F%2Flocalhost%3A8080%2Fweb%2Fguest%2Flistado-actuaciones%3Fp_p_id%3Dcom_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_cur%3D0%26p_r_p_resetCur%3Dfalse%26_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_assetEntryId%3D";
		try {
			//Parámetros recibidos. Comprobamos si son nulos y evitamos errores
			if (nombre == null) nombre = "";
			if (comunidad == null) comunidad = "";
			if (provincia == null) provincia = "";
			if (situacion == null) situacion = "";
			//Obtenemos las actuaciones
			ArrayList<Actuacion> actuaciones = dao.getActuaciones(nombre, comunidad, provincia, situacion);
			//System.out.println("Procesamos : " + actuaciones.size() + " actuaciones");
			if (actuaciones != null && !actuaciones.isEmpty()) {
				for (Actuacion actua : actuaciones) {
					//Construimos el JSON a enviar al cliente.
					JSONObject jSONObject = new JSONObject();
					jSONObject.put("entryId", actua.getEntryId());
					jSONObject.put("codTecnico", actua.getCodTecnico());
					jSONObject.put("nombre", actua.getNombre());
					jSONObject.put("Nombre de la actuación", actua.getNombre());
					jSONObject.put("ubicacion", actua.getUbicacion());
					jSONObject.put("Ubicación", actua.getUbicacion());
					jSONObject.put("comunidadAutonoma", actua.getComunidadAutonoma());
					jSONObject.put("Comunidad Autónoma", actua.getComunidadAutonoma());
					jSONObject.put("provincia", actua.getProvincia());
					jSONObject.put("Provincia", actua.getProvincia());
					jSONObject.put("superficie", actua.getSuperficie());
					jSONObject.put("Superficie", actua.getSuperficie());
					jSONObject.put("regantes", actua.getRegantes());
					jSONObject.put("cultivos", actua.getCultivos());
					jSONObject.put("situacion", actua.getSituacion());
					jSONObject.put("Situación", actua.getSituacion());
					jSONObject.put("colorSituacion", actua.getColorSituacion());
					jSONObject.put("longitud", actua.getLongitud());
					jSONObject.put("latitud", actua.getLatitud());
					jSONObject.put("urlTitle", actua.getUrlTitle());
					//Construimos la URL de detalle
					//String urlDetalle = "<a href='#' onclick='irADetalle(" + actua.getEntryId() + ");return false;'>Ver detalle</a>";
					//String boton = "<button onclick=window.location.href='/web/guest/detalle-actuaci%C3%B3n/-/asset_publisher/zliXYsKhtQJm/content/id/34158?_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_zliXYsKhtQJm_redirect=http%3A%2F%2Flocalhost%3A8080%2Fweb%2Fguest%2Fdetalle-actuaci%25C3%25B3n%3Fp_p_id%3Dcom_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_zliXYsKhtQJm%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_zliXYsKhtQJm_cur%3D0%26p_r_p_resetCur%3Dfalse%26_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_zliXYsKhtQJm_assetEntryId%3D" + actua.getEntryId() + "'>Ver detalle</button>";
					//String boton = "<button onclick=window.location.href='/web/guest/detalle-actuacion/-/asset_publisher/zliXYsKhtQJm/content/id/" + actua.getEntryId() + "#'>Ver detalle</button>";
					//String boton = "<button onclick=window.location.href='/web/guest/detalle-actuacion/-/asset_publisher/r19Ajlbdn4Nm?assetEntry=" + actua.getEntryId() + "#'>Ver detalle</button>";
					String boton = "<button onclick=window.location.href='/web/guest/detalle-actuacion/-/asset_publisher/r19Ajlbdn4Nm/" + actua.getEntryId() + "#'>Ver detalle</button>";
					
					//String boton = "<button onclick=window.location.href='/web/guest/-/" + actua.getUrlTitle() + "'>Ver detalle</button>";
					//System.out.println("DETALLE:" + urlDetalle);
					jSONObject.put("Detalle", boton);
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