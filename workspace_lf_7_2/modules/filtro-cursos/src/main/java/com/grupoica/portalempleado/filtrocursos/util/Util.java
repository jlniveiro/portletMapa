package com.grupoica.portalempleado.filtrocursos.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;

public class Util {
	
	public Util() {
		
	}
	
	public ArrayList<String> getPlanes(){
		ArrayList<String> listaPlanes = new ArrayList<String>();
		Connection connection = null;
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        
        //String sql = "SELECT distinct(YEAR(convert(datetime, FechaSolicitud, 101))) as anios FROM vwSolicitudesFormacion order by YEAR(convert(datetime, FechaSolicitud, 101)) desc";
        String sql = "SELECT distinct(year(STR_TO_DATE(FechaSolicitud, '%m/%d/%Y'))) as anios FROM vwSolicitudesFormacion order by year(STR_TO_DATE(FechaSolicitud, '%m/%d/%Y')) desc";
        try {
        	
            connection = DataAccess.getConnection();
            ptmt = connection.prepareStatement(sql);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                	
            	listaPlanes.add(resultSet.getString("anios")) ;
            	
            }
            
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
		
		return listaPlanes;
	}
	
	public HashMap<String, String>  getUsuarios(){
		HashMap<String, String> listaUsuarios = new HashMap<String, String>();
		Connection connection = null;
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        
        //String sql = "SELECT distinct(idUser), SolicitanteFirst + ' ' + SolicitanteLast AS usuario FROM vwSolicitudesFormacion";
        String sql ="SELECT distinct(idUser), concat(SolicitanteFirst,' ',SolicitanteLast) AS usuario FROM vwSolicitudesFormacion";
        
        try {
            connection = DataAccess.getConnection();
            ptmt = connection.prepareStatement(sql);
            resultSet = ptmt.executeQuery();
            
            while (resultSet.next()) {
                	
            	listaUsuarios.put(resultSet.getString("idUser"), resultSet.getString("usuario"));
            	
            }
            
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
                // we can iSELECT DISTINCT NombreCurso, Curso , YEAR(convert(datetime, FechaSolicitud, 101)) as anio FROM dbo.vwSolicitudesFormacion WHERE (NombreCurso IS NOT NULL) AND (NombreCurso <> '')gnore this error: it must not occur during normal operation (logging is also not necessary, but causes no harm)
                System.out.println("An error occured during closing the result set - the prepared statement - connection.");
            }
        } 
		
		return listaUsuarios;
	}
	
	public HashMap<String, String>  getCursos(){
		HashMap<String, String> listaCursos = new HashMap<String, String>();
		
		Connection connection = null;
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        
        //String sql = "SELECT DISTINCT NombreCurso, Curso , YEAR(convert(datetime, FechaSolicitud, 101)) as anio FROM dbo.vwSolicitudesFormacion WHERE (NombreCurso IS NOT NULL) AND (NombreCurso <> '')";
        String sql = "SELECT DISTINCT NombreCurso, Curso , year(STR_TO_DATE(FechaSolicitud, '%m/%d/%Y')) as anio FROM vwSolicitudesFormacion WHERE (NombreCurso IS NOT NULL) AND (NombreCurso <> '')";
        
        listaCursos.put("0","");
        try {
            connection = DataAccess.getConnection();
            ptmt = connection.prepareStatement(sql);
            resultSet = ptmt.executeQuery();
            
            while (resultSet.next()) {
                	
            	listaCursos.put(resultSet.getString("Curso"), resultSet.getString("anio") + "-" +resultSet.getString("NombreCurso"));
            	System.out.println(resultSet.getString("Curso")+"-"+resultSet.getString("NombreCurso"));
            	
            }
            
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
		
		return listaCursos;
	}
	
	
	public HashMap<String, String>  getCursosPorAnio(int anio){
		HashMap<String, String> listaCursos = new HashMap<String, String>();
		
		Connection connection = null;
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        
        //String sql = "SELECT DISTINCT NombreCurso, Curso , YEAR(convert(datetime, FechaSolicitud, 101)) as anio FROM dbo.vwSolicitudesFormacion WHERE(NombreCurso IS NOT NULL) AND (NombreCurso <> '')";
        // YEAR(convert(datetime, FechaSolicitud, 101))="+anio+" and
        String sql = "SELECT DISTINCT NombreCurso, Curso , year(STR_TO_DATE(FechaSolicitud, '%m/%d/%Y')) as anio FROM vwSolicitudesFormacion WHERE (NombreCurso IS NOT NULL) AND (NombreCurso <> '')";
        try {
            connection = DataAccess.getConnection();
            ptmt = connection.prepareStatement(sql);
            resultSet = ptmt.executeQuery();
            
            while (resultSet.next()) {
            	
            	if(Integer.parseInt(resultSet.getString("anio"))==anio) {
            		listaCursos.put(resultSet.getString("Curso"),resultSet.getString("NombreCurso"));
            	}
            	
            }
            
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
		
		return listaCursos;
	}
}
