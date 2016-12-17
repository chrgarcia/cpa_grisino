<%@page import="controlador.Sistema"%>
<%@page import="negocio.Provincia"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="Servlets.Controlador" %>
<%@ page import="java.util.*"%>
<%List<Provincia> provincias;%>
<%Float precio = null;%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Carga de Cliente No Regular</title>
<link href="css/style.css" rel="stylesheet" type="text/css">

 <!-- Scripts --> 
 <script type="text/javascript" src="jquery/jquery-2.1.1.js"></script>
 
<script type="text/javascript">

function comprobar_extension(formulario, archivo) { 
	   extensiones_permitidas = new Array(".csv"); 
	   mierror = ""; 
	   if (!archivo) { 
	      //Si no tengo archivo, es que no se ha seleccionado un archivo en el formulario 
	      	mierror = "No has seleccionado ningún archivo";
	      	return false;
	      	
	   }else{ 
	      //recupero la extensión de este nombre de archivo 
	      extension = (archivo.substring(archivo.lastIndexOf("."))).toLowerCase(); 
	      //alert (extension); 
	      //compruebo si la extensión está entre las permitidas 
	      permitida = false; 
	      for (var i = 0; i < extensiones_permitidas.length; i++) { 
	         if (extensiones_permitidas[i] == extension) { 
	         permitida = true; 
	         break; 
	         } 
	      } 
	      if (!permitida) { 
	         mierror = "Comprueba la extensión de los archivos a subir. \nSólo se pueden subir archivos con extensiones: " + extensiones_permitidas.join(); 
	      	}else{ 
	         	//submito! 
	         alert ("Todo correcto. Voy a submitir el formulario."); 
	         formulario.submit(); 
	         return 1; 
	      	} 
	   } 
	   //si estoy aqui es que no se ha podido submitir 
	   alert (mierror); 
	   return 0; 
	}
	
</script>

</head>
<body>

	<h1><b>Procesar Archivos CSV</b></h1>

	<form action="ControladorArchivos" method="post" enctype=multipart/form-data>
		<table>
			<tr>
			<td>Fichero CSV: </td>
			<td><input type=file name=fichero></td>
			<tr><td><input type=submit value="Procesar" onclick="comprobar_extension(this.form, this.form.fichero.value)"></td></tr>
			</tr>
		</table>
	</form>
 
	<br>
	<br>
	
	
	
	<a href="index.jsp">Volver</a>
</body>
</html>