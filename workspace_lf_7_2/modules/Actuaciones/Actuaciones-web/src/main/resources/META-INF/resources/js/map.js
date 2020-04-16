var urlcapaBase = "http://www.ign.es/wmts/ign-base?request=getTile&layer=IGNBaseTodo&TileMatrixSet=GoogleMapsCompatible&TileMatrix={z}&TileCol={x}&TileRow={y}&format=image/jpeg";
var urlcapaSatelite = "http://www.ign.es/wmts/pnoa-ma?request=getTile&layer=OI.OrthoimageCoverage&TileMatrixSet=GoogleMapsCompatible&TileMatrix={z}&TileCol={x}&TileRow={y}&format=image/jpeg";

// http://a.tile.openstreetmap.org/{z}/{x}/{y}.png
// Z: Nivel de zoom
// X: Longitud
// Y: Latitud
// a.tile.openstreetmap.org : Servidor de tiles
/*
L.tileLayer('http://a.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: 'Map data &copy; OpenStreetMap contributors'
}).addTo(map);
*/

//Mapa Base del asignamos
//http://www.ign.es/wmts/ign-base
var capaBase = L.tileLayer(urlcapaBase, {
    attribution: 'Mapa base IGN',
    maxZoom: 20
});

var capaSatelite = L.tileLayer(urlcapaSatelite, {
    attribution: 'Vista satélite',
    maxZoom: 20
});

//Con centro en Mercamadrid
var map = L.map('map', {
    layers: [capaBase],
    center: [40.359958, -3.661802],
    zoom: 6
});

//creación del mapa map_canvas es el id de la capa donde queremos crear el mapa
/*
map=L.map('map_canvas',{
   layers:[capamapa]
   }).setView([40.359958, -3.661802], 6);
*/
map.attributionControl.addAttribution("Seisa - IGN");

//añadimos las capas de tiles al mapa para poder seleccionarlas

var baseMaps = {
    "Mapa": capaBase,
    "Satelite": capaSatelite
};
L.control.layers(baseMaps).addTo(map);


//40.416935, -3.703612  Puerta del Sol
//var marker = L.marker([40.416935, -3.703612]).addTo(map);

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



//Añadimos los puntos al mapa
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
    //  shelterMarkers.addLayer(arrayPuntos[p]);
    markers.addLayer(arrayPuntos[p]);
}

//Añadimos la capa de Cluster de Puntos
//map.addLayer(markers);


map.on('zoomend', function() {
    if (map.getZoom() < 7) {
        map.removeLayer(markers);
    } else {
        map.addLayer(markers);
    }
});


function mostrarMarkers() {

    for (var m = 0; m < arrayPuntos.length; m++) {
        var punto = arrayPuntos[m];
        punto.addTo(map);
    }
}


//popup
function popup(feature, layer) {
    layer.bindPopup(feature.properties.NOMBRE);
}

//$.getJSON("http://localhost:8080/o/geoapi/regantes/geojson", function(data) {
//$.getJSON("http://seiasa.westeurope.cloudapp.azure.com:3000/comunidades_regantes.geojson", function(data) {
$.getJSON("/o/geoapi/regantes/geojson", function(data) {
    //var datosRegantes = new L.GeoJSON.AJAX("/o/geoapi/regantes/geojson"); 
    console.log(data);
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
    //Cargamos el control de búsqueda
    var searchControl = new L.Control.Search({
        layer: geoActuaciones,
        propertyName: "NOMBRE",
        marker: false,
        moveToLocation: function(latlng, title, map) {
            //map.fitBounds( latlng.layer.getBounds() );
            var zoom = map.getBoundsZoom(latlng.layer.getBounds());
            map.setView(latlng, zoom); // access the zoom
        }
    });

    searchControl.on('search:locationfound', function(e) {

        //console.log('search:locationfound', );

        //map.removeLayer(this._markerSearch)

        e.layer.setStyle({ fillColor: '#3f0', color: '#0f0' });
        if (e.layer._popup) {
            e.layer.openPopup();
        }


    }).on('search:collapsed', function(e) {

        geoActuaciones.eachLayer(function(layer) { //restore feature color
            geoActuaciones.resetStyle(layer);
        });
    });

    map.addControl(searchControl); //inizialize search control
});

//Carga de COMBOS

$.getJSON("/o/combos/autonomias",function(data){
    console.log(JSON.stringify(data));
    $.each(data, function(indice, item){
        $("#comunidades").append("<option value=\""+ item.id +"\">"+ item.nombre +"</option>");
    });
});

$.getJSON("/o/combos/provincias",function(data){
    console.log(JSON.stringify(data));
    $.each(data, function(indice, item){
        $("#provincias").append("<option value=\""+ item.id+ "\">"+ item.nombre +"</option>");
    });
});

$.getJSON("/o/combos/situaciones",function(data){
    console.log(JSON.stringify(data));
    $.each(data, function(indice, item){
        $("#situaciones").append("<option value=\""+ item.id +"\">"+ item.nombre +"</option>");
    });
});


var parametros = {nombre: "Molinar"};

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

});




