package es.grupoica.seiasaweb.detalle.application;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.liferay.portal.kernel.service.ServiceContext;

/**
 * @author ica
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/detalle",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
	},
	service = Application.class
)
public class DetalleActuacionControllerApplication extends Application {

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
		ServiceContext serviceContext = new ServiceContext();
		HttpServletResponse resp = serviceContext.getResponse();
		//resp.sendRedirect("/web/guest/listado-actuaciones/-/asset_publisher/I2YcN2wLXy9L/content/id/34158?_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_redirect=http%3A%2F%2Flocalhost%3A8080%2Fweb%2Fguest%2Flistado-actuaciones%3Fp_p_id%3Dcom_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_cur%3D0%26p_r_p_resetCur%3Dfalse%26_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_assetEntryId%3D460303");
		return "Good morning!";
	}
	
	@GET
	@Path("/morning2")
	@Produces("text/plain")
	public void hello2() throws IOException {
		ServiceContext serviceContext = new ServiceContext();
		HttpServletResponse resp = serviceContext.getResponse();
		resp.sendRedirect("/web/guest/listado-actuaciones/-/asset_publisher/I2YcN2wLXy9L/content/id/34158?_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_redirect=http%3A%2F%2Flocalhost%3A8080%2Fweb%2Fguest%2Flistado-actuaciones%3Fp_p_id%3Dcom_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_cur%3D0%26p_r_p_resetCur%3Dfalse%26_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_assetEntryId%3D460303");
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}

}