package es.grupoica.seiasaweb.rest.application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import java.io.File;
import java.io.FileInputStream;



/**
 * @author ica
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/geoapi",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=GeoApi.Rest"
	},
	service = Application.class
)

public class GeoJSONControllerApplication extends Application {
	
	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	 
	 @GET
	 @Path("/regantes/geojson")
	 @Produces(MediaType.APPLICATION_JSON)
	  public String getRegantes(){
		 String jsonString = null;
		 String fichero = "/home/ica/geoapi/Datos_SEIASA_EPSG4326.json";
		 int i;
         FileInputStream fin;
       try {
            //Abrir el archivo
            fin=new FileInputStream(fichero);
        }catch (FileNotFoundException exc){
            System.out.println("Archivo no encontrado");
            return "{ \"error\" : \"Fichero no encontrado\"}"; 
        }
        try {
        	//Creating a File object
            File file = new File(fichero);
            //Creating an InputStream object
            InputStream inputStream = new FileInputStream(file);
            //creating an InputStreamReader object
            InputStreamReader isReader = new InputStreamReader(inputStream);
            //Creating a character array
            char charArray[] = new char[(int) file.length()];
            //Reading the contents of the reader
            isReader.read(charArray);
            //Converting character array to a String
            jsonString  = new String(charArray);
            //System.out.println("Tamaño fichero: " + jsonString.length());
            
        }catch (IOException exc){
            System.out.println("Error al leer el archivo");
        }
        try {
            fin.close();
            //Cerrar el archivo
        }catch (IOException exc){
            System.out.println("Error cerrando el archivo.");
        }
	     return jsonString.trim();
	 }
	 
	 
	 
	 
	 
	 
	 
	

}