package com.grupoica.portalempleado.filtrocursos.portlet;

import com.grupoica.portalempleado.filtrocursos.constants.FiltroCursosPortletKeys;
import com.grupoica.portalempleado.filtrocursos.exporter.Exporter;
import com.grupoica.portalempleado.filtrocursos.util.Util;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

/**
 * @author ica
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FiltroCursos",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FiltroCursosPortletKeys.FILTROCURSOS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FiltroCursosPortlet extends MVCPortlet {
	
	@Override
    public void render(RenderRequest request, RenderResponse response)
            throws PortletException, IOException {
        
        super.render(request, response);
    }
	
	public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) {
		
		HashMap<String, String> listaInscripciones = new HashMap<String, String>();
		
		String tipo = ParamUtil.getString(resourceRequest, "tipo");
		long anio = ParamUtil.getLong(resourceRequest, "anio");
		long usuarioId = ParamUtil.getLong(resourceRequest, "usuario");
		long estado = ParamUtil.getLong(resourceRequest, "estado");
		long cursoId = ParamUtil.getLong(resourceRequest, "curso");
		
		if(tipo.equals("mostrarInscripciones") || tipo.equals("descargarInscripciones")) {
			JSONObject jsonobj =  JSONFactoryUtil.createJSONObject();
		    jsonobj.put("dataReceivedMessage","Data Received Successfully");
		    jsonobj.put("Año", anio);
		    jsonobj.put("Usuario", usuarioId);
		    jsonobj.put("Estado", estado);
		    jsonobj.put("Curso", cursoId);
		     
		    String selectAnio = "";
			String selectUsuario ="";
			String selectEstado ="";
			String selectCurso ="";
			
			//String sql = "SELECT * from vwSolicitudesFormacion where YEAR(convert(datetime, FechaSolicitud, 101))="+anio;
			String sql ="SELECT * from vwSolicitudesFormacion where year(STR_TO_DATE(FechaSolicitud, '%m/%d/%Y'))="+anio;
			
			if(usuarioId!=0) {
				sql = sql + " and idUser="+usuarioId;
			}
			if(estado!=4) { //Estado 4 es vacio
				sql = sql + " and Estado="+estado;
			}
			if(cursoId!=0) { //Estado 4 es vacio
				sql = sql + " and Curso="+cursoId;
			}
			
			System.out.println("SQL:"+sql);
			Connection connection = null;
	        PreparedStatement ptmt = null;
	        ResultSet resultSet = null;
	        
	        if(tipo.equals("mostrarInscripciones")) {
	        	
	        	PrintWriter printout;
				try {
					connection = DataAccess.getConnection();
		            ptmt = connection.prepareStatement(sql);
		            resultSet = ptmt.executeQuery();
		            JSONArray jsonInscripciones = JSONFactoryUtil.createJSONArray();
		            JSONObject objInscripciones;
		            
		            while (resultSet.next()) {
		            	jsonInscripciones.put(resultSet.getString("NombreCurso")+";"+resultSet.getString("nombreUsuario")+";"+resultSet.getString("FechaSolicitud")+";"+resultSet.getString("ObservacionesAdministracion")+";"+resultSet.getString("nombreEstado"));
		            }
		            objInscripciones =  JSONFactoryUtil.createJSONObject();
		            objInscripciones.put("listaInscripciones", jsonInscripciones.toString());
		            resourceResponse.setContentType("application/json");
		            resourceResponse.setCharacterEncoding("UTF-8");
		            
					resourceResponse.getWriter().write(objInscripciones.toString());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }else if(tipo.equals("descargarInscripciones")){
				try {
					
					connection = DataAccess.getConnection();
		            ptmt = connection.prepareStatement(sql);
		            resultSet = ptmt.executeQuery();
		            
					HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);	
					
					httpResponse.setHeader("Content-Disposition", "attachment; filename=\"lista_inscripciones.xlsx\"");
					httpResponse.setHeader("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					
					
					Exporter exporter = new Exporter();
					XSSFWorkbook w = exporter.exportarExcel(resultSet);
					
					
					w.write(httpResponse.getOutputStream());

					httpResponse.getOutputStream().flush();
					httpResponse.getOutputStream().close();
					
					
					
				} catch (SystemException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        
		      
		}else {
			
			String CMD = ParamUtil.getString(resourceRequest, "CMD");
			//String CMD = resourceRequest.getParameter("CMD");
			int anioCambia = Integer.parseInt(ParamUtil.getString(resourceRequest, "anio"));
	        JSONArray jsonResults = JSONFactoryUtil.createJSONArray();
	        JSONObject obj;
	        HashMap<String, String>  cursos = new HashMap<String, String>();
	        Util util = new Util();
	        
	        if(CMD.equalsIgnoreCase("cursos")){
	        	
	        	try {
	        		cursos =util.getCursosPorAnio(anioCambia);
	        		
	        		for (Map.Entry<String, String> entry : cursos.entrySet()) {
	        		    jsonResults.put(entry.getKey()+":"+entry.getValue());
	        		}
	        		
		        	obj =  JSONFactoryUtil.createJSONObject();
		            obj.put("listaCursos", jsonResults.toString());
		            resourceResponse.setContentType("application/json");
		            resourceResponse.setCharacterEncoding("UTF-8");
		            
					resourceResponse.getWriter().write(obj.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        }
		}
	}
	/*
	public void ObtenerHistorialInscripcionCursos(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		Long anio = ParamUtil.getLong(actionRequest, "anio", -1L);
		Long usuarioId = ParamUtil.getLong(actionRequest, "usuario", -1L);
		Long estado = ParamUtil.getLong(actionRequest, "estado", -1L);
		Long cursoId = ParamUtil.getLong(actionRequest, "curso", -1L);
		
		String selectAnio = "";
		String selectUsuario ="";
		String selectEstado ="";
		String selectCurso ="";
		
		//String sql = "SELECT * from vwSolicitudesFormacion where YEAR(convert(datetime, FechaSolicitud, 101))="+anio;
		String sql ="SELECT * from vwSolicitudesFormacion where year(STR_TO_DATE(FechaSolicitud, '%m/%d/%Y'))="+anio;
		
		if(usuarioId!=0) {
			sql = sql + " and idUser="+usuarioId;
		}
		if(estado!=4) { //Estado 4 es vacio
			sql = sql + " and Estado="+estado;
		}
		if(cursoId!=0) { //Estado 4 es vacio
			sql = sql + " and Curso="+cursoId;
		}
		
		System.out.println("SQL:"+sql);
		Connection connection = null;
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        
        
        try {
        	
            connection = DataAccess.getConnection();
            ptmt = connection.prepareStatement(sql);
            resultSet = ptmt.executeQuery();
            
            Exporter exporter = new Exporter();
            boolean excelOk = exporter.exportarExcel(actionRequest, actionResponse,resultSet);
            
        }catch (Exception e) {
        	System.out.println(e);
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
		
		
	}*/
}



