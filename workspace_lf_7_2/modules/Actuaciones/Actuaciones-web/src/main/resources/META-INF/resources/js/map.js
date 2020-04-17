$( document ).ready(function() {

	var urlcapaBase = "http://www.ign.es/wmts/ign-base?request=getTile&layer=IGNBaseTodo&TileMatrixSet=GoogleMapsCompatible&TileMatrix={z}&TileCol={x}&TileRow={y}&format=image/jpeg";
	var urlcapaSatelite = "http://www.ign.es/wmts/pnoa-ma?request=getTile&layer=OI.OrthoimageCoverage&TileMatrixSet=GoogleMapsCompatible&TileMatrix={z}&TileCol={x}&TileRow={y}&format=image/jpeg";
	
	//Mapa Base del asignamos
	//http://www.ign.es/wmts/ign-base
	var capaBase = L.tileLayer(urlcapaBase, {
	    attribution: 'Mapa base IGN',
	    maxZoom: 18
	});
	
	var capaSatelite = L.tileLayer(urlcapaSatelite, {
	    attribution: 'Vista satélite',
	    maxZoom: 18
	});
	
	//Iniciamos el mapa	
	var map = load_map();
	
	//añadimos las capas de tiles al mapa para poder seleccionarlas
	
	var baseMaps = {
	    "Mapa": capaBase,
	    "Satelite": capaSatelite
	};
	//añadimos las capas de tiles al mapa para poder seleccionarlas
	L.control.layers(baseMaps).addTo(map);
	
	
	
	var townIcon = L.icon({
	    //iconUrl: '/o/com.grupoica.actuaciones.web/images/icono_verde24.png',
	    //iconRetinaUrl: '/o/com.grupoica.actuaciones.web/images/icono_verde24.png', 
		iconUrl: '/documents/20124/0/icono_verde24.png/572aa805-c05e-c8e9-b235-d355c47bf8e6?version=1.0&t=1586862128062&imageThumbnail=1',
		iconRetinaUrl: '/documents/20124/0/icono_verde24.png/572aa805-c05e-c8e9-b235-d355c47bf8e6?version=1.0&t=1586862128062&imageThumbnail=1',
	    iconSize: [24,24],
	    iconAnchor: [12,24],
	    popupAnchor: [0, -24]
	  });
	
	var arrayPuntos = [];
	var arrayCirculos = [];
	var shelterMarkers = new L.FeatureGroup();
	var markers = L.markerClusterGroup();
	
		
		
	//COMBOS DE BÚSQUEDA
	$.getJSON("/o/combos/autonomias",function(data){
	    //console.log(JSON.stringify(data));
	    //Valor por defecto
	    $("#comunidad").append("<option value=\"\">Todas</option>");
	    $.each(data, function(indice, item){
	        $("#comunidad").append("<option value=\""+ item.nombre +"\">"+ item.nombre +"</option>");
	    });
	});
	
	$.getJSON("/o/combos/provincias",function(data){
	    //console.log(JSON.stringify(data));
	    $("#provincia").append("<option value=\"\">Todas</option>");
	    $.each(data, function(indice, item){
	        $("#provincia").append("<option value=\""+ item.nombre+ "\">"+ item.nombre +"</option>");
	    });
	});
	
	$.getJSON("/o/combos/situaciones",function(data){
	    //console.log(JSON.stringify(data));
	    $("#situacion").append("<option value=\"\">Todas</option>");
	    $.each(data, function(indice, item){
	        $("#situacion").append("<option value=\""+ item.nombre +"\">"+ item.nombre +"</option>");
	    });
	});
	
	//FUNCION PARA CARGAR EL MAPA
	function load_map() {
		//Con centro en Mercamadrid
		map = new L.map('map', {
		    layers: [capaBase],
		    center: [40.359958, -3.661802],
		    zoom: 6
		});
		
		map.attributionControl.addAttribution("Seisa - IGN");
		
		return map;
	}
	
		
	//FUNCIÓN PARA CARGAR LOS DATOS DEL BUSCADOR Y MAPA
	function actualizarActuaciones(){
		
		/*
		 * EN CADA BÚSQUEDA ES NECESARIO REINICIAR EL MAPA PARA QUE LOS PUNTOS NO SE 
		 * DUPLIQUEN EN EL MAPA. DE AHI QUE ELIMINEMOS LAS CAPAS DEL MAPA Y LAS 
		 * VOLVAMOS A CARGAR DE NUEVO. 
		 */
		
		$("#map").innerHTML = "";
		//BORRAMOS TODAS LAS CAPAS
		map.eachLayer(function(layer){
			map.removeLayer(layer);
			console.log("Borrando capa........");
		});
		
		//BORRAMOS TODOS LOS CLUSTER
		markers.eachLayer(function(layer){
			markers.removeLayer(layer);
			console.log("Borrando marker cluster........");
		});
		//map.remove();
		
		//REINICIAMOS EL MAPA CON LOS PUNTOS NUEVOS 
		arrayPuntos = []; 
		markers = L.markerClusterGroup();
		//AÑADIMOS LAS CAPAS BASE
		map.addLayer(capaBase);
		
        
		
		//CARGAMOS LA CAPA DE REGANTES
		$.getJSON("/o/geoapi/regantes/geojson", function(data) {
		    //var datosRegantes = new L.GeoJSON.AJAX("/o/geoapi/regantes/geojson"); 
		    //console.log(data);
			//GeoJSON from API Rest
			let geoActuaciones = L.geoJson(null, {});
		    geoActuaciones.addData(data);
		    geoActuaciones.eachLayer(function(layer) {
		        layer.bindPopup("<p class='contenido'><strong>Nombre:</strong> " + layer.feature.properties.NOMBRE + "<p>" +
		            "<p class='contenido'><strong>Autonom&iacute;a:</strong> " + layer.feature.properties.AUTONOMIA + "<p>" +
		            "<p class='contenido'><strong>Provincia:</strong> " + layer.feature.properties.PROVINCIA + "<p>" +
		            "<p class='contenido'><strong>Regantes:</strong> " + layer.feature.properties.REGANTES + "<p>");
		        layer.setStyle({ fillColor: '#3f0', color: '#0f0' });
		        layer.on('click', function(e){
		        	layer.setStyle({ fillColor: '#3377F9', color: '#5C92FB' });
		        });
		        layer.on('popupclose', function(e){
		        	layer.setStyle({ fillColor: '#3f0', color: '#0f0' });
		        });
		    });
		    
		    geoActuaciones.addTo(map);
		
		});
		
						
		//OBTENEMOS LOS DATOS DE LA BUSQUEDA
		//CARGAMOS EL ARRAY DE PARAMETROS
		var txtNombre = document.getElementById("nombre").value;
		//console.log("NOMBRE: " + txtNombre);
		var sltComunidad = document.getElementById("comunidad").value;
		//console.log("COMUNIDAD: " + sltComunidad);
		var sltProvincia = document.getElementById("provincia").value;
		//console.log("PROVINCIA: " + sltProvincia);
		var sltSituacion = document.getElementById("situacion").value;
		//console.log("SITUACION: " + sltSituacion);
		
		var parametros = {nombre: txtNombre, comunidad: sltComunidad, 
				          provincia: sltProvincia, situacion: sltSituacion};
		
		//OBTENEMOS LOS DATOS DE ACTUACIONES
		$.getJSON("/o/buscador/actuaciones",parametros, function(data){
			
			jsGrid.locale("es");
			
			$("#buscador_actuaciones").jsGrid({
			    width: "100%",
			    height: "500px",
			
			    sorting: true,
			    paging: true,
			    autoload: true,
			    pageSize: 10,
			    pageButtonCount: 5,
			
			    data: data,
			
			    fields: [
			        { name: "nombre", type: "text", width: 150 },
			        { name: "superficie", type: "text", width: 50 },
			        { name: "provincia", type: "text", width: 50 },
			        { name: "situacion", type: "text", width: 50 },
			        { name: "Ver detalle", type: "text", width:50 }
			     ]
			});
			
			//FUNCIÓN QUE GENERA EL POPUP DE UNA ACTUACIÓN
			function generateData(nombre, comunidad, provincia, situacion){
				  var content = "<p class='contenido'><strong><a class='titulo' href=''>" + nombre + "</a></strong></p>" +
				                "<p class='contenido'><strong>C. Aut&oacute;noma:</strong>" + comunidad + "</p>" +
				                "<p class='contenido'><strong>Provincia:</strong>" + provincia + "</p>" +
				                "<p class='contenido'><strong>Estado:</strong>" + situacion + "</p>";

				  return content;
			}
			
			//FUNCIÓN QUE CENTRA EL MAPA EN EL ARRAY DE PUNTOS DE LA BÚSQUEDA.
			function centerLeafletMapOnMarkers() {
			      var latLngs = [];
			      if (arrayPuntos.length > 0) {
				      for (var a=0; a < arrayPuntos.length; a++){
				        latLngs[a] = [ arrayPuntos[a].getLatLng() ];
				      }
				      var markerBounds = L.latLngBounds(latLngs);
				      console.log("ZOOM: " + map.getZoom());
				      map.fitBounds(markerBounds);
				      
				      map.on('zoomend', function() {
						    if (map.getZoom() < 7) {
						        map.removeLayer(markers);
						    } else {
						        map.addLayer(markers);
						    }
					  });
			      }
			      else {
			    	  //NO HAY DATOS, CENTRAMOS EL MAPA EN EL CENTRO DEL PAIS.
			    	  latLngs[0] = [40.359958, -3.661802];
			    	  map.setView(latLngs[0], 6);
				      console.log("ZOOM: " + map.getZoom());
				  }
			}
			
			
			//CARGAMOS LOS PUNTOS EN EL MAPA
			var puntos = [];
			var contentData = [];
			
			$.each(data, function(i,item){
				puntos[i]=[data[i].latitud, data[i].longitud];
				console.log(i + " - LAT: " + data[i].latitud + " , LONG: " + data[i].longitud);
				contentData[i] = generateData(data[i].nombre, data[i].comunidadAutonoma, data[i].provincia, data[i].situacion);
			})
			
			console.log("PUNTOS: " + puntos.length);
			console.log("CONTENT DATA: " + contentData.length);
			console.log("ARRAY de PUNTOS: " + arrayPuntos.length);
			
			
			//AÑADIMOS LOS PUNTOS AL MAPA
			for (var p = 0; p < puntos.length; p++) {
			    arrayPuntos[p] = L.marker(puntos[p], { icon: townIcon });
			    //Creamos un popup para el punto.
			    var popup = L.popup({
			        minWidth: 100,
			        maxWidth: 300
			    }).setContent(contentData[p]);
			    //El popup creado se lo asignamos al MARKER
			    arrayPuntos[p].bindPopup(popup);
			    //Añadimos el punto al grupo de Puntos
			    markers.addLayer(arrayPuntos[p]);
			}
			
			console.log("ARRAY de PUNTOS TRAS LA ASIGNACIÓN: " + arrayPuntos.length);		
			//Hacemos ZOOM en el mapa para MOSTRAR los puntos obtenidos
		    centerLeafletMapOnMarkers();
	
		});
		
	}
	
	
	//EVENTO DE BÚSQUEDA DE DATOS
	$("#buscar").click(function(){
		console.log("Buscamos..........");
		//ACTUALIZAMOS LAS ACTUACIONES
		actualizarActuaciones();
	});
	
	
	//ACTUALIZAMOS LAS ACTUACIONES
	actualizarActuaciones();
	
	
});




