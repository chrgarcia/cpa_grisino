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


<h1> Resultado de la busqueda </h1>

<table cellspacing="3" cellpadding="3" border="0" width="100%">
	<tr>
		<td></td>
		<td><b>CPA Encontrado</b></td>
	</tr>
<%
	String aux;
	aux = (String) request.getAttribute("resultado");
%>
	<tr>
		<td></td>

		<td><%=aux%></td>
	
	</tr>

</form>
</body>
</html>