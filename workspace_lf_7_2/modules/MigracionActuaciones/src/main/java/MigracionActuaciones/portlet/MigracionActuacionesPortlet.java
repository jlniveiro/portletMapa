package MigracionActuaciones.portlet;

import MigracionActuaciones.constants.MigracionActuacionesPortletKeys;

import com.liferay.journal.exception.DuplicateArticleIdException;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.util.JournalConverter;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureServiceUtil;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.dynamic.data.mapping.storage.Field;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author ica
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MigracionActuaciones",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MigracionActuacionesPortletKeys.MIGRACIONACTUACIONES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MigracionActuacionesPortlet extends MVCPortlet {
	
	//define log for this class
    private static final Log _log = LogFactoryUtil.getLog(MigracionActuacionesPortlet.class.getName());
    private static final long FOLDER_ACCIONES = 0; // LOCAL
    
    @Reference
    private JournalConverter _journalConverter;

    
    @Override
    public void render(RenderRequest request, RenderResponse response)
            throws PortletException, IOException {
        
        super.render(request, response);
    }
    
    
    public void migracionActuaciones(ActionRequest request, ActionResponse response)
            throws IOException, PortletException, PortalException, SystemException{
    	
    	_log.info("Comienza la migracion.");
    	
    	boolean imported = true;
    	long folderId = FOLDER_ACCIONES;
    	
    	// Obtenemos la estructura relacionada.
    	DDMStructure ddmStructure = DDMStructureServiceUtil.getStructure(36702);
    	
    	
        
    	long groupId = ddmStructure.getGroupId();
    	
    	ServiceContext serviceContext = ServiceContextFactory.getInstance(JournalArticle.class.getName(), request);
    	
    	Connection connection = null;
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        
        int contActuacionesNuevas = 0;
        
        String sql = "select * from ActuacionImp";
        try {
            connection = DataAccess.getConnection();
            ptmt = connection.prepareStatement(sql);
            resultSet = ptmt.executeQuery();
            
            while (resultSet.next()) {
                	
            	long codtecnicoAniadir = Long.parseLong(resultSet.getString("codTecnico"));
            	String titulo = resultSet.getString("nombre");
            	String descripcion = resultSet.getString("descripcion");
            	
            	Fields ddmFields = /* obtenerFields(t) */ crearDDMFields(ddmStructure);
            	// Rellenamos los fields
            	ddmFields = rellenarCampos(resultSet, ddmStructure, ddmFields);
            	
            	
            	for (Field field : ddmFields) {
        			field.setDefaultLocale(LocaleUtil.getSiteDefault());
        		}
            	
            	Map<Locale, String> titleMap = new HashMap<Locale, String>();
                Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
                titleMap.put(LocaleUtil.getSiteDefault(),titulo);
                descriptionMap.put(LocaleUtil.getSiteDefault(), descripcion);
                
                String actualContent = _journalConverter.getContent(ddmStructure, ddmFields);
                String ddmStructureKey = ddmStructure.getStructureKey();
        		String ddmTemplateKey = "";
                
            	try {
                    
                    JournalArticle ja = JournalArticleLocalServiceUtil.addArticle(
                    		serviceContext.getUserId(), 
                    		groupId, 
                    		folderId, 
                    		titleMap, 
                    		descriptionMap, 
                    		actualContent, //content, 
                    		ddmStructureKey, //ddmStructureKey, 
                    		ddmTemplateKey, //ddmTemplateKey, 
                    		serviceContext);
                    		
                    		contActuacionesNuevas++;

                  }
                  catch (DuplicateArticleIdException e){
                    System.out.println("Article does already exist!");
                  }
            	
            }
            
            System.out.println("Se han añadido "+contActuacionesNuevas+" actuaciones nuevas.");
        }catch (Exception e) {
        	System.out.println(e);
        	imported = false;
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
        
        
    }
    
    private Fields crearDDMFields(DDMStructure ddmStructure) throws PortalException, SystemException {

		Fields ddmFields = new Fields();

		ddmFields.getAvailableLocales().clear();
		ddmFields.getAvailableLocales().add(LocaleUtil.getSiteDefault());

		Field fieldsDisplayField = new Field(ddmStructure.getStructureId(), "_fieldsDisplay", "");

		ddmFields.put(fieldsDisplayField);

		return ddmFields;
	}
    
	protected void updateFieldsDisplay(Fields ddmFields, String fieldName) {
		String fieldsDisplayValue = fieldName.concat("_INSTANCE_").concat(StringUtil.randomString());

		Field fieldsDisplayField = ddmFields.get("_fieldsDisplay");

		String[] fieldsDisplayValues = StringUtil.split((String) fieldsDisplayField.getValue());

		fieldsDisplayValues = ArrayUtil.append(fieldsDisplayValues, fieldsDisplayValue);

		fieldsDisplayField.setValue(StringUtil.merge(fieldsDisplayValues));
	}
    
    private Fields rellenarCampos(ResultSet resultSet, DDMStructure ddmStructure, Fields ddmFields) {
    	
    	
		try {
			Field fieldCodTecnico = new Field(ddmStructure.getStructureId(), "codTecnico", resultSet.getString("codTecnico"));
			updateFieldsDisplay(ddmFields, "codTecnico");
			ddmFields.put(fieldCodTecnico);
			
			Field fieldNombre = new Field(ddmStructure.getStructureId(), "nombre", resultSet.getString("nombre"));
			updateFieldsDisplay(ddmFields, "nombre");
			ddmFields.put(fieldNombre);
			
			Field fieldObjetivo = new Field(ddmStructure.getStructureId(), "objetivo", resultSet.getString("objetivo"));
			updateFieldsDisplay(ddmFields, "objetivo");
			ddmFields.put(fieldObjetivo);
			
			Field fieldDescripcion = new Field(ddmStructure.getStructureId(), "descripcion", resultSet.getString("descripcion"));
			updateFieldsDisplay(ddmFields, "descripcion");
			ddmFields.put(fieldDescripcion);
			
			Field fieldZona = new Field(ddmStructure.getStructureId(), "zona", resultSet.getString("zona"));
			updateFieldsDisplay(ddmFields, "zona");
			ddmFields.put(fieldZona);
			
			Field fieldCA = new Field(ddmStructure.getStructureId(), "comunidadAutonoma", resultSet.getString("comunidadAutonoma"));
			updateFieldsDisplay(ddmFields, "comunidadAutonoma");
			ddmFields.put(fieldCA);
			
			Field fieldProvincia = new Field(ddmStructure.getStructureId(), "provincia", resultSet.getString("provincia"));
			updateFieldsDisplay(ddmFields, "provincia");
			ddmFields.put(fieldProvincia);
			
			Field fieldCosteEjecucion = new Field(ddmStructure.getStructureId(), "costeEjecucion", resultSet.getString("costeEjecucion"));
			updateFieldsDisplay(ddmFields, "costeEjecucion");
			ddmFields.put(fieldCosteEjecucion);
			
			Field fieldSuperficie = new Field(ddmStructure.getStructureId(), "superficie", resultSet.getString("superficie"));
			updateFieldsDisplay(ddmFields, "superficie");
			ddmFields.put(fieldSuperficie);
			
			Field fieldRegantes = new Field(ddmStructure.getStructureId(), "regantes", resultSet.getString("regantes"));
			updateFieldsDisplay(ddmFields, "regantes");
			ddmFields.put(fieldRegantes);
			
			Field fieldCultivos = new Field(ddmStructure.getStructureId(), "cultivos", resultSet.getString("cultivos"));
			updateFieldsDisplay(ddmFields, "cultivos");
			ddmFields.put(fieldCultivos);
			
			Field fieldSituacion = new Field(ddmStructure.getStructureId(), "situacion", resultSet.getString("situacion"));
			updateFieldsDisplay(ddmFields, "situacion");
			ddmFields.put(fieldSituacion);
			
			Field fieldLongitud = new Field(ddmStructure.getStructureId(), "longitud", resultSet.getString("longitud"));
			updateFieldsDisplay(ddmFields, "longitud");
			ddmFields.put(fieldLongitud);
			
			Field fieldLatitud = new Field(ddmStructure.getStructureId(), "latitud", resultSet.getString("latitud"));
			updateFieldsDisplay(ddmFields, "latitud");
			ddmFields.put(fieldLatitud);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ddmFields;
    	
    }
    
}