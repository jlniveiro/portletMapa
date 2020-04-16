<%@ include file="/init.jsp" %>

<portlet:actionURL var="migracionActuaciones" name="migracionActuaciones"></portlet:actionURL>

<form action="${migracionActuaciones}" method="post">
    <input type="submit" value="Migrar actuacioness"> 
</form>