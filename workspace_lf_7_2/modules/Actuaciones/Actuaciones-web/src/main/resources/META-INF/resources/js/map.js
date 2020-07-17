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
	
	//ICONOS
	
	//#FFFF00
	var iconffff00 = L.icon({
	    iconUrl: '/o/com.grupoica.actuaciones.web/images/icono_FFFF00_24.png',
	    iconRetinaUrl: '/o/com.grupoica.actuaciones.web/images/icono_FFFF00_24.png', 
		iconSize: [24,24],
	    iconAnchor: [12,24],
	    popupAnchor: [0, -24]
	});
	
	//#000080
	var icon000080 = L.icon({
	    iconUrl: '/o/com.grupoica.actuaciones.web/images/icono_000080_24.png',
	    iconRetinaUrl: '/o/com.grupoica.actuaciones.web/images/icono_000080_24.png', 
		iconSize: [24,24],
	    iconAnchor: [12,24],
	    popupAnchor: [0, -24]
	});
	
	//#0000FF
	var icon0000ff = L.icon({
	    iconUrl: '/o/com.grupoica.actuaciones.web/images/icono_0000FF_24.png',
	    iconRetinaUrl: '/o/com.grupoica.actuaciones.web/images/icono_0000FF_24.png', 
		iconSize: [24,24],
	    iconAnchor: [12,24],
	    popupAnchor: [0, -24]
	});
	
	//#00FFFF
	var icon00ffff = L.icon({
	    iconUrl: '/o/com.grupoica.actuaciones.web/images/icono_00FFFF_24.png',
	    iconRetinaUrl: '/o/com.grupoica.actuaciones.web/images/icono_00FFFF_24.png', 
		iconSize: [24,24],
	    iconAnchor: [12,24],
	    popupAnchor: [0, -24]
	});
	
	//#00FF00
	var icon00ff00 = L.icon({
	    iconUrl: '/o/com.grupoica.actuaciones.web/images/icono_00FF00_24.png',
	    iconRetinaUrl: '/o/com.grupoica.actuaciones.web/images/icono_00FF00_24.png', 
		iconSize: [24,24],
	    iconAnchor: [12,24],
	    popupAnchor: [0, -24]
	});
	
	//#008000
	var icon008000 = L.icon({
	    iconUrl: '/o/com.grupoica.actuaciones.web/images/icono_008000_24.png',
	    iconRetinaUrl: '/o/com.grupoica.actuaciones.web/images/icono_008000_24.png', 
		iconSize: [24,24],
	    iconAnchor: [12,24],
	    popupAnchor: [0, -24]
	});
	
	//#icono_00FA9A_24.png
	var icon00FA9A = L.icon({
	    iconUrl: '/o/com.grupoica.actuaciones.web/images/icono_00FA9A_24.png',
	    iconRetinaUrl: '/o/com.grupoica.actuaciones.web/images/icono_00FA9A_24.png', 
		iconSize: [24,24],
	    iconAnchor: [12,24],
	    popupAnchor: [0, -24]
	});
	
	
	var defaultIcon = L.icon({
	      iconUrl: '/o/com.grupoica.actuaciones.web/images/icono_verde24.png',
	      iconRetinaUrl: '/o/com.grupoica.actuaciones.web/images/icono_verde24.png',
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
		        //layer.bindPopup("<p class='titulo'><strong>Nombre:</strong> " + layer.feature.properties.NOMBRE + "<p>" +
		    	layer.bindPopup("<p class='titulo'>" + layer.feature.properties.NOMBRE + "<p>" +
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
			    height: "auto",
			
			    sorting: true,
			    paging: true,
			    autoload: true,
			    pageSize: 10,
			    pageButtonCount: 5,
			    
			    		
			    data: data,
			
			    fields: [
			        { name: "Nombre de la actuación", type: "text"},
			        { name: "Superficie", type: "text" },
			        { name: "Provincia", type: "text" },
			        { name: "Situación", type: "text" },
			        //{ itemTemplate: function(i, item) {
			        	//return $("<button>").attr("type", "button").text("Ver detalle")
                        //.on("click", function () {
                          //  detalleActuacion(data[i].entryId);
                       // });
	               // },
	               // align: "center",
	               // width: 50 }
			        { name: "Detalle", type: "text"}
			     ]
			});
			
						
			//FUNCIÓN QUE GENERA EL POPUP DE UNA ACTUACIÓN
			function generateData(nombre, comunidad, provincia, situacion, regantes, superficie, entryId){
				  var content = "<p class='contenido'><strong><a class='titulo' href='/web/guest/detalle-actuacion/-/asset_publisher/r19Ajlbdn4Nm/" + entryId + "#'>" + nombre + "</a></strong></p>" +
				                "<p class='contenido'><strong>C. Aut&oacute;noma:</strong>" + comunidad + "</p>" +
				                "<p class='contenido'><strong>Provincia:</strong>" + provincia + "</p>" +
				                "<p class='contenido'><strong>Estado:</strong>" + situacion + "</p>" + 
				                "<p class='contenido'><strong>Regantes:</strong>" + regantes + "</p>" +
				                "<p class='contenido'><strong>Superficie:</strong>" + superficie + "</p>";

				  return content; 
			}
			
			//function irADetalle(entry){
				//window.location.href='/web/guest/listado-actuaciones/-/asset_publisher/I2YcN2wLXy9L/content/id/34158?_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_redirect=http%3A%2F%2Flocalhost%3A8080%2Fweb%2Fguest%2Flistado-actuaciones%3Fp_p_id%3Dcom_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_cur%3D0%26p_r_p_resetCur%3Dfalse%26_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_I2YcN2wLXy9L_assetEntryId%3D' + entry;
			//},
			
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
				      map.addLayer(markers);
				      //Evento que se activa con el Zoom				      
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
			var situaciones = [];
			var contentData = [];
			
			$.each(data, function(i,item){
				puntos[i]=[data[i].latitud, data[i].longitud];
				console.log(i + " - LAT: " + data[i].latitud + " , LONG: " + data[i].longitud);
				situaciones[i] = [data[i].colorSituacion];
				contentData[i] = generateData(data[i].nombre, data[i].comunidadAutonoma, data[i].provincia, data[i].situacion, data[i].regantes, data[i].superficie, data[i].entryId);
			});
			
						
			//AÑADIMOS LOS PUNTOS AL MAPA
			for (var p = 0; p < puntos.length; p++) {
				var icono = situaciones[p];
				if (icono == '#FFFF00'){
					arrayPuntos[p] = L.marker(puntos[p], { icon: iconffff00 });
				}
				else if (icono == '#000080'){
					arrayPuntos[p] = L.marker(puntos[p], { icon: icon000080 });
				}
				else if (icono == '#0000FF'){
					arrayPuntos[p] = L.marker(puntos[p], { icon: icon0000ff });
				}
				else if (icono == '#00FFFF'){
					arrayPuntos[p] = L.marker(puntos[p], { icon: icon00ffff });
				}
				else if (icono == '#00FF00'){
					arrayPuntos[p] = L.marker(puntos[p], { icon: icon00ff00 });
				}
				else if (icono == '#008000'){
					arrayPuntos[p] = L.marker(puntos[p], { icon: icon008000 });
				}
				else if (icono == '#00FA9A'){
					arrayPuntos[p] = L.marker(puntos[p], { icon: icon00FA9A });
				}
				else{
					arrayPuntos[p] = L.marker(puntos[p], { icon: defaultIcon });
				}
					    
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




