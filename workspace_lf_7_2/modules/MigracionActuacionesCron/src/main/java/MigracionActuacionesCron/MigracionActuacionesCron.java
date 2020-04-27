package MigracionActuacionesCron;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.journal.util.JournalConverter;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureServiceUtil;
import com.liferay.dynamic.data.mapping.storage.Field;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.journal.exception.DuplicateArticleIdException;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
//import com.liferay.xml.formatter.
//compileOnly group: "com.liferay", name: "com.liferay.xml.formatter", version: "1.0.5"

/**
 * @author ica
 */
@Component(
	    immediate = true,
	    property = {
	        "cron.expression= 0 0/20 0/8 1/1 * ?"   // scheduler runs every 12 hours starting at 00. -> 0 0 0/12 ? * *
	    },
	    service = MigracionActuacionesCron.class
	)

public class MigracionActuacionesCron extends BaseMessageListener {

	private static final Log _log = LogFactoryUtil.getLog(MigracionActuacionesCron.class.getName());
	private static final long FOLDER_ACCIONES = 0;
	private static final long USUARIO_ID = 20130; 
	//private Locale local = new Locale("es", "ES");
	private Locale local = LocaleUtil.getDefault();
	//private static final long STRUCTURE_ID = 33816; //Desarrollo MVWAre
	private static final long STRUCTURE_ID = 40110; //PRODUCCION 
	//private static final long STRUCTURE_ID = 39709; //SEIASA - AZURE
	
	@Reference
    private JournalConverter _journalConverter;

	@Override
	protected void doReceive(Message message) throws Exception {
		// TODO Auto-generated method stub
		_log.info("Scheduled task executed...");
		migracionActuaciones();
	}
	
	@Activate
	@Modified
	protected void activate(Map<String,Object> properties) throws SchedulerException {

		try {
			// extract the cron expression from the properties
			String cronExpression = GetterUtil.getString(properties.get("cron.expression"), "cronExpression");

			_log.info(" cronExpression: " + cronExpression);

			// create a new trigger definition for the job.
			String listenerClass = getClass().getName();
			Trigger jobTrigger = TriggerFactoryUtil.createTrigger(listenerClass, listenerClass, new Date(), null, cronExpression);

			// wrap the current scheduler entry in our new wrapper.
			// use the persisted storage type and set the wrapper back to the class field.
			SchedulerEntryImpl schedulerEntryImpl = new SchedulerEntryImpl();
		    schedulerEntryImpl.setEventListenerClass(listenerClass);
		    schedulerEntryImpl.setTrigger(jobTrigger);

		    SchedulerEngineHelperUtil.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);

		} catch (Exception e){
			_log.error(e);
		}

	}
	
	@Deactivate
	protected void deactive() {
	    SchedulerEngineHelperUtil.unregister(this);
	}
 
	
	public void migracionActuaciones()
            throws IOException, PortalException, SystemException{
    	
    	_log.info("Comienza la migracion.");
    	
    	boolean imported = true;
    	long folderId = FOLDER_ACCIONES;
    	
    	User usuario = UserLocalServiceUtil.getUser(USUARIO_ID);
    	PermissionChecker checker = PermissionCheckerFactoryUtil.create(usuario);
    	PermissionThreadLocal.setPermissionChecker(checker);
    	
    	// Obtenemos la estructura relacionada.
    	DDMStructure ddmStructure = DDMStructureServiceUtil.getStructure(STRUCTURE_ID);
        
    	long groupId = ddmStructure.getGroupId();
    	
    	
    	Connection connection = null;
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        
        Connection connection1 = null;
        PreparedStatement ptmt1 = null;
        ResultSet resultSetCodTecnico = null;
        // Mapa de Actuaciones publicadas en Liferay
        HashMap<String, String> mapaActuaciones = new HashMap<String, String>();
        
        int contActuacionesNuevas = 0;
        
        String sqlCodTecnico = "select EXTRACTVALUE(content, " +
              " '(/root/dynamic-element[@name=\"codTecnico\"]/dynamic-content)') AS `codTecnico`, "
              + " resourcePrimKey from JournalArticle;";
        /*
         * use seiasa_web;
			SELECT a.codTecnico as codTecnico, a.nombre as nombre, a.objetivo as objetivo, a.ubicacion as ubicacion,
			a.descripcion as descripcion, c.nombre as comunidadAutonoma, p.nombre as provincia, a.superficie as superficie,
			a.regantes as regantes, a.cultivos as cultivos, s.nombre as situacion, s.colorIcono as colorIcono, a.longitud as longitud, a.latitud as latitud
			 FROM Actuaciones_tmp a 
			     INNER JOIN Comunidad_Autonoma c ON a.comunidadAutonoma = c.id
			     INNER JOIN Provincia p ON a.provincia = p.id
			     INNER JOIN Situacion s ON a.situacion = s.id
			         */
        StringBuffer sqlActuaciones = new StringBuffer("SELECT a.codTecnico as codTecnico, a.nombre as nombre, ");
        sqlActuaciones.append("a.objetivo as objetivo, a.ubicacion as ubicacion, a.descripcion as descripcion, ")
        			  .append("	c.nombre as comunidadAutonoma, p.nombre as provincia, a.superficie as superficie,")
                      .append("	a.regantes as regantes, a.cultivos as cultivos, s.nombre as situacion, ")
                      .append(" s.colorIcono as colorIcono, a.longitud as longitud, a.latitud as latitud ")
                      .append("	FROM Actuaciones_tmp a ")
                      .append("	INNER JOIN Comunidad_Autonoma c ON a.comunidadAutonoma = c.id ")
                      .append("	INNER JOIN Provincia p ON a.provincia = p.id\n") 
        		      .append("	INNER JOIN Situacion s ON a.situacion = s.id");
        try {
        	connection = DataAccess.getConnection();
            ptmt = connection.prepareStatement(sqlActuaciones.toString());
            resultSet = ptmt.executeQuery();
        	
        	
            connection1 = DataAccess.getConnection();
            ptmt1 = connection1.prepareStatement(sqlCodTecnico);
            resultSetCodTecnico = ptmt1.executeQuery();
            
                     
            while (resultSetCodTecnico.next()) {
            	//codigosTecnicos.add(resultSetCodTecnico.getString("codTecnico"));
            	mapaActuaciones.put(resultSetCodTecnico.getString("codTecnico"), resultSetCodTecnico.getString("resourcePrimKey"));
            }
            //mapaActuaciones.containsKey(key)
            
            while (resultSet.next()) {
                //Obtenemos el Código Técnico del registro actual
            	String codTecnico = resultSet.getString("codTecnico");
            	//if(!codigosTecnicos.contains(resultSet.getString("codTecnico"))) {
            	if (!mapaActuaciones.containsKey(codTecnico)){
            		String titulo = resultSet.getString("nombre");
                	String descripcion = resultSet.getString("descripcion");
                	
                	Fields ddmFields = /* obtenerFields(t) */ crearDDMFields(ddmStructure);
                	// Rellenamos los fields
                	ddmFields = rellenarCampos(resultSet, ddmStructure, ddmFields);
                	
                	
                	for (Field field : ddmFields) {
            			field.setDefaultLocale(local);
            		}
                	
                	Map<Locale, String> titleMap = new HashMap<Locale, String>();
                    Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
                    titleMap.put(local,titulo);
                    descriptionMap.put(local, descripcion);
                    
                    String actualContent = _journalConverter.getContent(ddmStructure, ddmFields);
                    String ddmStructureKey = ddmStructure.getStructureKey();
            		String ddmTemplateKey = "";
            		
            		ServiceContext serviceContext = new ServiceContext();
                    serviceContext.setScopeGroupId(groupId);
                    serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH); 
                    serviceContext.setAddGuestPermissions(true);
                    
                	try {
                        
                        JournalArticle ja = JournalArticleLocalServiceUtil.addArticle(
                        		usuario.getUserId(), 
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
                        _log.error("Article does already exist!", e);
                      }
            	}
            	else {
            		//Existe Actuación publicada para el codTecnico indicado
            		//Obtenemos el Journal correspondiente y lo actualizamos
            		JournalArticle latest = 
            				JournalArticleLocalServiceUtil.getLatestArticle(Long.parseLong(mapaActuaciones.get(codTecnico)));
            		//Actualizamos el Journal con los datos recogidos
            		if (latest != null) {
            			_log.info("Actualizando contenido con assetID " + latest.getResourcePrimKey());
            			actualizarContenido(resultSet, ddmStructure, latest);
            		}
            	
            	}
            	
            	
            }
           
            _log.info("Se han añadido "+contActuacionesNuevas+" actuaciones nuevas.");
            
        }catch (Exception e) {
        	_log.error(e);
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
                _log.error("An error occured during closing the result set - the prepared statement - connection.");
            }
        } 
        
        
    }
    
    private Fields crearDDMFields(DDMStructure ddmStructure) throws PortalException, SystemException {

		Fields ddmFields = new Fields();

		ddmFields.getAvailableLocales().clear();
		ddmFields.getAvailableLocales().add(local);

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
    
	/**
	 * Genera un contenido de Actuacion con los datos obtenidos de la Actuación importada
	 * @param resultSet
	 * @param ddmStructure
	 * @param latest
	 * @return
	 */
    private void actualizarContenido(ResultSet resultSet, DDMStructure ddmStructure, JournalArticle latest) {
    	
    	try 
    	{
    		
    		String nombreLatest = null;
    		
			//OBTENEMOS EL DOCUMENT DEL ARTICLE ACTUAL
			Document document = SAXReaderUtil.read(latest.getContentByLocale(local.toString()));
			
			//Procesamos el NOMBRE
			Node nodeNombre = document.selectSingleNode("/root/dynamic-element[@name='nombre']/dynamic-content");
			if (nodeNombre != null)
			{
				//Valor de NOMBRE actual
				nombreLatest = (nodeNombre.getText()!=null) ? nodeNombre.getText() : "";
				//NOMBRE recibido
	    		String nombre = (resultSet.getString("nombre")!=null) ? resultSet.getString("nombre") : "";
	    		if (! nombre.trim().equals(nombreLatest.trim())) {
	    			_log.info("Se actualiza el 'nombre' del contenido");
	    			nodeNombre.setText(nombre);
	    		}
			}
			
			
			//Procesamos el OBJETIVO
			Node nodeObjetivo = document.selectSingleNode("/root/dynamic-element[@name='objetivo']/dynamic-content");
			if (nodeObjetivo != null)
			{
				//Valor de OBJETIVO actual
				String objetivoLatest = (nodeObjetivo.getText()!=null) ? nodeObjetivo.getText() : "";
				//NOMBRE recibido
	    		String objetivo = (resultSet.getString("objetivo")!=null) ? resultSet.getString("objetivo") : "";
	    		if (! objetivo.trim().equals(objetivoLatest.trim())) {
	    			_log.info("Se actualiza el 'objetivo' del contenido");
	    			nodeObjetivo.setText(objetivo);
	    		}
			}
			
			
			//UBICACION
			Node nodeUbicacion = document.selectSingleNode("/root/dynamic-element[@name='ubicacion']/dynamic-content");
			if (nodeUbicacion != null)
			{
				//Valor de UBICACION actual
				String ubicacionLatest = (nodeUbicacion.getText()!=null) ? nodeUbicacion.getText() : "";
				//UBICACION recibido
				String ubicacion = (resultSet.getString("ubicacion")!=null) ? resultSet.getString("ubicacion") : "";
    			if (! ubicacion.trim().equals(ubicacionLatest.trim())) {
    				_log.info("Se actualiza la 'ubicación' del contenido");
    				nodeUbicacion.setText(ubicacion);
    			}
    		}
    			
    			
    			
			//DESCRIPCION
			Node nodeDescripcion = document.selectSingleNode("/root/dynamic-element[@name='descripcion']/dynamic-content");
			if (nodeDescripcion != null)
			{
				//Valor de DESCRIPCION actual
				String descripcionLatest = (nodeDescripcion.getText()!=null) ? nodeDescripcion.getText() : "";
				//DESCRIPCION recibido
				String descripcion = (resultSet.getString("descripcion")!=null) ? resultSet.getString("descripcion") : "";
    			if (! descripcion.trim().equals(descripcionLatest.trim())) {
    				_log.info("Se actualiza la 'descripcion' del contenido");
    				nodeDescripcion.setText(descripcion);
    			}
    		}	
    			
    			
			//COMUNIDAD_AUTONOMA
			Node nodeComunidad = document.selectSingleNode("/root/dynamic-element[@name='comunidadAutonoma']/dynamic-content");
			if (nodeComunidad != null)
			{
				//Valor de COMUNIDAD_AUTONOMA actual
				String comunidadAutonomaLatest = (nodeComunidad.getText()!=null) ? nodeComunidad.getText() : "";
				//COMUNIDAD_AUTONOMA recibido
				String comunidadAutonoma = (resultSet.getString("comunidadAutonoma")!=null) ? resultSet.getString("comunidadAutonoma") : "";
    			if (! comunidadAutonoma.trim().equals(comunidadAutonomaLatest.trim())) {
    				_log.info("Se actualiza la 'Comunidad Autónoma' del contenido");
    				nodeComunidad.setText(comunidadAutonoma);
    			}
    		}
    			
			//PROVINCIA
			Node nodeProvincia = document.selectSingleNode("/root/dynamic-element[@name='provincia']/dynamic-content");
			if (nodeProvincia != null)
			{
				//Valor de PROVINCIA actual
				String provinciaLatest = (nodeProvincia.getText()!=null) ? nodeProvincia.getText() : "";
				//PROVINCIA recibido
				String provincia = (resultSet.getString("provincia")!=null) ? resultSet.getString("provincia") : "";
    			if (! provincia.trim().equals(provinciaLatest.trim())) {
    				_log.info("Se actualiza la 'Provincia' del contenido");
    				nodeProvincia.setText(provincia);
    			}
    		}
    			
    			
			//SUPERFICIE
			Node nodeSuperficie = document.selectSingleNode("/root/dynamic-element[@name='superficie']/dynamic-content");
			if (nodeSuperficie != null)
			{
				//Valor de SUPERFICIE actual
				String superficieLatest = (nodeSuperficie.getText()!=null) ? nodeSuperficie.getText() : "";
				//SUPERFICIE recibido
				String superficie = (resultSet.getString("superficie")!=null) ? resultSet.getString("superficie") : "";
    			if (! superficie.trim().equals(superficieLatest.trim())) {
    				_log.info("Se actualiza la 'Superficie' del contenido");
    				nodeSuperficie.setText(superficie);
    			}
    		}
    			
    			
			//REGANTES
			Node nodeRegantes = document.selectSingleNode("/root/dynamic-element[@name='regantes']/dynamic-content");
			if (nodeRegantes != null)
			{
				//Valor de REGANTES actual
				String regantesLatest = (nodeRegantes.getText()!=null) ? nodeRegantes.getText() : "";
				//REGANTES recibido
				String regantes = (resultSet.getString("regantes")!=null) ? resultSet.getString("regantes") : "";
    			if (! regantes.trim().equals(regantesLatest.trim())) {
    				_log.info("Se actualiza la 'Regantes' del contenido");
    				nodeRegantes.setText(regantes);
    			}
    		}
    			
    			
			//CULTIVOS
			Node nodeCultivos = document.selectSingleNode("/root/dynamic-element[@name='cultivos']/dynamic-content");
			if (nodeCultivos != null)
			{
				//Valor de CULTIVOS actual
				String cultivosLatest = (nodeCultivos.getText()!=null) ? nodeCultivos.getText() : "";
				//CULTIVOS recibido
				String cultivos = (resultSet.getString("cultivos")!=null) ? resultSet.getString("cultivos") : "";
    			if (! cultivos.trim().equals(cultivosLatest.trim())) {
    				_log.info("Se actualiza la 'Cultivos' del contenido");
    				nodeCultivos.setText(cultivos);
    			}
    		}
    			
    			
			//SITUACION
			Node nodeSituacion = document.selectSingleNode("/root/dynamic-element[@name='situacion']/dynamic-content");
			if (nodeSituacion != null)
			{
				//Valor de SITUACION actual
				String situacionLatest = (nodeSituacion.getText()!=null) ? nodeSituacion.getText() : "";
				//SITUACION recibido
				String situacion = (resultSet.getString("situacion")!=null) ? resultSet.getString("situacion") : "";
    			if (! situacion.trim().equals(situacionLatest.trim())) {
    				_log.info("Se actualiza la 'Situacion' del contenido");
    				nodeSituacion.setText(situacion);
    			}
    		}
    			
    			
			//COLORSITUACION
			Node nodeColorSituacion = document.selectSingleNode("/root/dynamic-element[@name='colorSituacion']/dynamic-content");
			if (nodeColorSituacion != null)
			{
				//Valor de COLORSITUACION actual
				String colorSituacionLatest = (nodeColorSituacion.getText()!=null) ? nodeColorSituacion.getText() : "";
				//COLORSITUACION recibido
				String colorSituacion = (resultSet.getString("colorIcono")!=null) ? resultSet.getString("colorIcono") : "";
    			if (! colorSituacion.trim().equals(colorSituacionLatest.trim())) {
    				_log.info("Se actualiza la 'colorSituacion' del contenido");
    				nodeColorSituacion.setText(colorSituacion);
    			}
    		}
    			
			//LONGITUD
			Node nodeLongitud = document.selectSingleNode("/root/dynamic-element[@name='longitud']/dynamic-content");
			if (nodeLongitud != null)
			{
				//Valor de LONGITUD actual
				String longitudLatest = (nodeLongitud.getText()!=null) ? nodeLongitud.getText() : "";
				//LONGITUD recibido
				String longitud = (resultSet.getString("longitud")!=null) ? resultSet.getString("longitud") : "";
    			if (! longitud.trim().equals(longitudLatest.trim())) {
    				_log.info("Se actualiza la 'longitud' del contenido");
    				nodeLongitud.setText(longitud);
    			}
    		}
    			
			//LATITUD
			Node nodeLatitud = document.selectSingleNode("/root/dynamic-element[@name='latitud']/dynamic-content");
			if (nodeLatitud != null)
			{
				//Valor de LATITUD actual
				String latitudLatest = (nodeLatitud.getText()!=null) ? nodeLatitud.getText() : "";
				//LATITUD recibido
				String latitud = (resultSet.getString("latitud")!=null) ? resultSet.getString("latitud") : "";
    			if (! latitud.trim().equals(latitudLatest.trim())) {
    				_log.info("Se actualiza la 'latitud' del contenido");
    				nodeLatitud.setText(latitud);
    			}
    		}
			
    		//Actualizamos el contenido del JOURNAL
    		String newContent = document.formattedString();
    		latest.setContent(newContent);

    		JournalArticle ja = JournalArticleLocalServiceUtil.updateJournalArticle(latest);
		
    			
			
		} catch (Exception e) {
			_log.error("Error al actualizar contenido con assetID " + latest.getResourcePrimKey());
			e.printStackTrace();
		}
    	
    	
       	
    	
    }
    
    
    /**
     * Cumplimenta los datos para un contenido nuevo
     * @param resultSet
     * @param ddmStructure
     * @param ddmFields
     * @return
     */
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
			
			Field fieldUbicacion = new Field(ddmStructure.getStructureId(), "ubicacion", resultSet.getString("ubicacion"));
			updateFieldsDisplay(ddmFields, "ubicacion");
			ddmFields.put(fieldUbicacion);
			
			Field fieldDescripcion = new Field(ddmStructure.getStructureId(), "descripcion", resultSet.getString("descripcion"));
			updateFieldsDisplay(ddmFields, "descripcion");
			ddmFields.put(fieldDescripcion);
						
			Field fieldCA = new Field(ddmStructure.getStructureId(), "comunidadAutonoma", resultSet.getString("comunidadAutonoma"));
			updateFieldsDisplay(ddmFields, "comunidadAutonoma");
			ddmFields.put(fieldCA);
			
			Field fieldProvincia = new Field(ddmStructure.getStructureId(), "provincia", resultSet.getString("provincia"));
			updateFieldsDisplay(ddmFields, "provincia");
			ddmFields.put(fieldProvincia);
			
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
			
			Field fieldColorSituacion = new Field(ddmStructure.getStructureId(), "colorSituacion", resultSet.getString("colorIcono"));
			updateFieldsDisplay(ddmFields, "colorSituacion");
			ddmFields.put(fieldColorSituacion);
			
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
    
    
    /**
	 * Modifica el valor del campo solicitado por el nuevo valor.
	 * @param fieldname
	 * @param article
	 * @param locale
	 * @param newValue
	 */
	private void setParseValue(String fieldname, JournalArticle article, String locale, String newValue) {

		try {
			 //System.out.println(article.getContent());

			Document document = null;
			Node node = null;
			 //Extraemos el XML del Journal
			 //document = SAXReaderUtil.read(article.getContentByLocale(locale));
			 //rootElement = document.getRootElement();

			String xmlString = article.getContent();
			document = SAXReaderUtil.read(xmlString);
			node = document.selectSingleNode("/root/dynamic-element[@name='" + fieldname +"']/dynamic-content");
			
			node.setText(newValue);
			 
			
			String newContent = document.formattedString();
			article.setContent(newContent);

			JournalArticle ja = JournalArticleLocalServiceUtil.updateJournalArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obtiene el contenido de un determinado campo desde la raiz del JournalArticle especificado.
	 * @param fieldname
	 * @param article
	 * @param locale
	 * @return
	 */
	private String getRootParseValue(String fieldname, JournalArticle article, String locale) {
		String value = null;
		try {
			Document document = SAXReaderUtil.read(article.getContentByLocale(locale));
			Node node = document.selectSingleNode("/root/dynamic-element[@name='" + fieldname +"']/dynamic-content");
			if (node != null)
			{
				value = node.getText();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			value = null;
		}

		return value;
	}
}