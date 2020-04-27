package com.grupoica.portalempleado.filtrocursos.exporter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PortalUtil;

public class Exporter {
	
	public Exporter() {
		
	}
	
	public XSSFWorkbook exportarExcel(ResultSet resultSet) {
		
		System.out.println("EXPORTAMOS EXCEL");
		XSSFWorkbook wb = new XSSFWorkbook();
		CellStyle cellStyle = wb.createCellStyle();
		Font headersFont = wb.createFont();
		headersFont.setBold(true);
		cellStyle.setFont(headersFont);
        XSSFSheet sheet = wb.createSheet();
        
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
	    	
		
		
	    try {
	    	
	    	int numeroFila = 0;
	    	XSSFRow row = sheet.createRow(numeroFila);
	        XSSFCell cellPlan = row.createCell(0);
	        cellPlan.setCellValue("Plan Formación");
	        cellPlan.setCellStyle(cellStyle);
	        XSSFCell cellFechaSolicitud = row.createCell(1);
	        cellFechaSolicitud.setCellValue("Fecha solicitud");
	        cellFechaSolicitud.setCellStyle(cellStyle);
	        XSSFCell cellEmail = row.createCell(2);
	        cellEmail.setCellValue("Email");
	        cellEmail.setCellStyle(cellStyle);
	        XSSFCell cellNombreSolicitante = row.createCell(3);
	        cellNombreSolicitante.setCellValue("Nombre solicitante");
	        cellNombreSolicitante.setCellStyle(cellStyle);
	        XSSFCell cellNombreCurso = row.createCell(4);
	        cellNombreCurso.setCellValue("Nombre curso");
	        cellNombreCurso.setCellStyle(cellStyle);
	        XSSFCell cellObservaciones = row.createCell(5);
	        cellObservaciones.setCellValue("Observaciones");
	        cellObservaciones.setCellStyle(cellStyle);
	    	
	    	

		    while(resultSet.next()) {
		    	
		    	numeroFila++;
		    	
		    	XSSFRow rowDato = sheet.createRow(numeroFila);
		    	
		    	XSSFCell cellPlanDato = rowDato.createCell(0);
		    	cellPlanDato.setCellValue(resultSet.getString("PlanFormacion"));
		    	XSSFCell cellFechaSolicitudDato = rowDato.createCell(1);
		        cellFechaSolicitudDato.setCellValue(resultSet.getString("FechaSolicitud"));
		        XSSFCell cellEmailDato = rowDato.createCell(2);
		        cellEmailDato.setCellValue(resultSet.getString("email"));
		        XSSFCell cellNombreSolicitanteDato = rowDato.createCell(3);
		        cellNombreSolicitanteDato.setCellValue(resultSet.getString("nombreUsuario"));
		        XSSFCell cellNombreCursoDato = rowDato.createCell(4);
		        cellNombreCursoDato.setCellValue(resultSet.getString("NombreCurso"));
		        XSSFCell cellObservacionesDato = rowDato.createCell(5);
		        cellObservacionesDato.setCellValue(resultSet.getString("Observaciones"));
		    	
		    	
	    	}
		    
		    for(int j = 0; j < 6; j++) { 
		    	sheet.autoSizeColumn((short)j); 
		    }
		    

		    
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return wb;
	}
}
