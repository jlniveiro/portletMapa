
<%@ include file="/init.jsp" %>

<%
Util util = new Util();

ArrayList aniosArrayList = util.getPlanes();
request.setAttribute("aniosList", aniosArrayList); 

HashMap usuariosArrayList = util.getUsuarios();
request.setAttribute("usuariosList", usuariosArrayList); 

int anio = Integer.parseInt((String)aniosArrayList.get(0));
HashMap cursosArrayList = util.getCursosPorAnio(anio);
//HashMap cursosArrayList = util.getCursos();
request.setAttribute("cursosList", cursosArrayList); 

%>

<portlet:resourceURL var="getCursosPorAnio"></portlet:resourceURL>

<liferay-portlet:actionURL name="ObtenerHistorialInscripcionCursos" var=" ObtenerHistorialInscripcionCursos">
</liferay-portlet:actionURL>

<portlet:resourceURL var="filtroInscripcionURL"/>

<liferay-portlet:resourceURL var="filtroInscripcionDescargarURL">
	<liferay-portlet:param name="tipo" value="descargarInscripciones"/>
</liferay-portlet:resourceURL>


<aui:select name="anio" id="anio" onChange="cambiaAnio(this.value)" label ="Año">
  <c:forEach items="${aniosList}" var="aniosValue">
    <aui:option value="${aniosValue}">
        ${aniosValue}
    </aui:option>
  </c:forEach>
</aui:select>
<aui:select name="usuario" id="usuario" onChange="cambiaUsuario(this.value)" label ="Usuario">
	<aui:option value="0" selected="true"></aui:option>	
  	<c:forEach items="${usuariosList}" var="usuariosValue">
        <aui:option value="${usuariosValue.key}">
	        ${usuariosValue.value}
	    </aui:option>  	
  	</c:forEach>
</aui:select>
<aui:select name="estado" id="estado" onChange="cambiaEstado(this.value)" label ="Estado">
	<aui:option value="4" selected="true"></aui:option>
    <aui:option value="0">Pendiente</aui:option>
    <aui:option value="1">Aprobada</aui:option>
    <aui:option value="2">Rechazada</aui:option>
</aui:select>

<aui:select name="curso" id="selectCursosId" onChange="cambiaCurso(this.value)" label ="Curso">
	<aui:option value="0" selected="true"></aui:option>	
  	<c:forEach items="${cursosList}" var="cursosValue">
	    <aui:option value="${cursosValue.key}">
	        ${cursosValue.value}
	    </aui:option>
  	</c:forEach>
</aui:select>
<aui:button name="" type="submit" onClick="submitFiltroInscripcionesForm()" value="Filtrar"/>
<a id="descargarInscripciones" href="${filtroInscripcionDescargarURL}&<portlet:namespace/>anio=2020&<portlet:namespace/>estado=4&<portlet:namespace/>usuario=0&<portlet:namespace/>curso=0" target="_blank">Exportar Inscripciones</a>

<br><br><br>
<table id="listadoInscripciones" width="100%"></table>


<aui:script>

    
    function submitFiltroInscripcionesForm(){
    	AUI().use('aui-base','aui-io-request-deprecated', function(A){
	    	var anio=A.one("#<portlet:namespace />anio").get('value');
	        var usuario=A.one("#<portlet:namespace />usuario").get('value');
	        var estado=A.one("#<portlet:namespace />estado").get('value');
	        var curso=A.one("#<portlet:namespace />selectCursosId").get('value');

			A.io.request('<%=filtroInscripcionURL%>',{
	            dataType: 'json',
	            method: 'POST',
	            data: { <portlet:namespace/>tipo: 'mostrarInscripciones',
	            		<portlet:namespace/>anio: anio,
	                    <portlet:namespace/>usuario: usuario,
	                    <portlet:namespace/>estado: estado,
	                    <portlet:namespace/>curso: curso
	                    },
	            on: {
		            success: function(event,id, obj) {
		            
		                 var instance = this;
                         var inscripciones = instance.get('responseData');
                         if (inscripciones) {
                         	var data = JSON.parse(inscripciones.listaInscripciones);
                         	var cabeceras = "<thead><tr><th>Curso</th><th>Usuario</th><th>Solicitud</th><th>Observaciones Adm</th><th>Estado</th></tr></thead><tbody>";
                         	var contenidoCompleto = cabeceras;
                         	for (var i = 0; i < data.length; i++) {
                               var datavalue = data[i].split(";");
                               var contenidoFila='<tr><td>'+datavalue[0]+'</td><td>'+datavalue[1]+'</td><td>'+datavalue[2]+'</td><td>'+datavalue[3]+'</td><td>'+datavalue[4]+'</td></tr>';
                           	   contenidoCompleto = contenidoCompleto + contenidoFila;
                           }
                           
                           contenidoCompleto = contenidoCompleto + "</tbody>";
                           
                           A.one('#listadoInscripciones').empty();
    					   A.one('#listadoInscripciones').set('innerHTML',contenidoCompleto);
                         }
	                }
	            }
            
        	});
        });
        
    }
    
    
    //Ajax para cuando cambia el año
    
    function cambiaAnio(anio) {
    	var href = document.getElementById("descargarInscripciones").href;
    	var hrefHastaAnio = href.split("anio=");
    	var hrefDespuesAnio = hrefHastaAnio[1].indexOf('&');
    	document.getElementById("descargarInscripciones").href = hrefHastaAnio[0] + "anio=" + anio + hrefHastaAnio[1].substring(hrefDespuesAnio);

        AUI().use(
              'aui-base',
              'aui-io-request-deprecated',
              function(A) {
                  A.io
                     .request(
                     		'<%=getCursosPorAnio%>',
                          {
                              dataType : 'json',
                              method : 'GET',
                              data : {
                                  <portlet:namespace />CMD : 'cursos',
                                  <portlet:namespace />anio : anio
                              },
                              on : {
                                  success : function(event,
                                          id, obj) {
                                      var instance = this;
                                      var cursos = instance.get('responseData');
                                      if (cursos) {
                                          var data = JSON.parse(cursos.listaCursos);
                                          var selectTest = document.getElementById("<portlet:namespace/>selectCursosId");
                                          var i, L = selectTest.options.length - 1;
										   for(i = L; i >= 0; i--) {
										      selectTest.remove(i);
										   }
                                          var option = document.createElement("option");
                                          option.value = "0";
                                          option.text = "";
                                          selectTest.appendChild(option);
                                      	  for (var i = 0; i < data.length; i++) {
                                      	  
                                               option = document.createElement("option");
                                               var datavalue = data[i].split(":");
                                               option.value = datavalue[0];
                                               option.text = datavalue[1];
                                               selectTest.appendChild(option);
                                           }
                                      }
                                  }
                              }
                          });
              })
    }
    
    function cambiaUsuario(usuario) {
    	var href = document.getElementById("descargarInscripciones").href;
    	var hrefHastaUsuario = href.split("usuario=");
    	var hrefDespuesUsuario = hrefHastaUsuario[1].indexOf('&');
    	document.getElementById("descargarInscripciones").href = hrefHastaUsuario[0] + "usuario=" + usuario + hrefHastaUsuario[1].substring(hrefDespuesUsuario);
    }
    
    function cambiaEstado(estado) {
    	var href = document.getElementById("descargarInscripciones").href;
    	var hrefHastaEstado = href.split("estado=");
    	var hrefDespuesEstado = hrefHastaEstado[1].indexOf('&');
    	document.getElementById("descargarInscripciones").href = hrefHastaEstado[0] + "estado=" + estado + hrefHastaEstado[1].substring(hrefDespuesEstado);
    }
    
    function cambiaCurso(curso) {
    	var href = document.getElementById("descargarInscripciones").href;
    	var hrefHastaCurso = href.split("curso=");
    	document.getElementById("descargarInscripciones").href = hrefHastaCurso[0] + "curso=" + curso;
    }
</aui:script>



