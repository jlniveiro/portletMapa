<%@page import="com.grupoica.actuaciones.service.persistence.ActuacionUtil"%>
<%@page import="com.grupoica.actuaciones.service.ActuacionLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.6.0/leaflet.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet.markercluster/1.4.1/MarkerCluster.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet.markercluster/1.4.1/MarkerCluster.Default.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/leaflet-search.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/map.css"/>

<!-- <link rel="stylesheet" href="https://unpkg.com/leaflet@1.0.3/dist/leaflet.css">  -->
<!-- <script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>	 -->  

<!--  <h1><liferay-ui:message key="actuaciones.caption"/></h1>  -->  
<div id="map" style="margin:12px 0 12px 0;height:500px;"></div>

<div id="filtro">
    <div>
	    <label for="nombre">Nombre:</label><input type="text" id="nombre"> &nbsp;
		<label for="comunidad">Comunidades:</label><select id="comunidad"></select> &nbsp;
		<label for="provincia">Provincias:</label><select id="provincia"></select> &nbsp;
		<label for="situacion">Situaci&oacute;n:</label><select id="situacion"></select>
	</div>
	<div id="busqueda">
		<input type="button" id="buscar" value="Buscar"></input>
	</div>
</div>

<div id="buscador_actuaciones">

</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.6.0/leaflet.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet.markercluster/1.4.1/leaflet.markercluster-src.js"></script>
<script src="<%=request.getContextPath()%>/js/leaflet-search.js"></script>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script>
<script src="<%=request.getContextPath()%>/js/markers.js"></script>
<script src="<%=request.getContextPath()%>/js/i18n/es.js"></script>
<script src="<%=request.getContextPath()%>/js/map.js"></script>

