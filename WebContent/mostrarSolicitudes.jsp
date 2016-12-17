<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ page import="java.util.*"%> 
<%@ page import="Servlets.Controlador" %>
<%@ page import="negocio.Solicitud" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Caminos</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>


<h1> Listado de Solicitudes </h1>

<table cellspacing="3" cellpadding="3" border="0" width="100%">
	<tr>
		<td></td>
		<td><b>ID</b></td>
		<td><b>Calle</b></td>
		<td><b>Altura</b></td>
		<td><b>Localidad</b></td>
		<td><b>Provincia</b></td>
		<td><b>CP</b></td>
		<td><b>CPA</b></td>
		<td><b>Metodo</b></td>
	</tr>
<%
	Solicitud aux;
	List<Solicitud> solicitudes = (List<Solicitud>)request.getAttribute("solicitudes");
	
	for(Iterator<Solicitud> i = solicitudes.iterator(); i.hasNext();){
		aux = i.next();
%>
	<tr>
		<td></td>

		<td><%=aux.getId()%></td>
		<td><%=aux.getCalle()%></td>
		<td><%=aux.getAltura()%></td>
		<td><%=aux.getLocalidad()%></td>
		<td><%=aux.getProvincia()%></td>
		<td><%=aux.getCp()%></td>
		<td><%=aux.getCpa()%></td>
		<td><%=aux.getMetodo()%></td>
	
	</tr>
<% } %>



</form>
</body>
</html>