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

<script type="text/javascript">
function validacion() {
	   	//valido el nombre 
	   	if (document.formulario.alto.value.length==0 ||  document.formulario.largo.value.length==0 
	   			|| document.formulario.ancho.value.length==0 || document.formulario.peso.value.length==0 ){ 
	      	alert("Complete todos los datos") 
	      	return false; 
	   	} 
	
	   	//el formulario se envia 
	   	alert("Carga exitosa!"); 
	   	return true; 
	}
	
</script>

 <!-- Scripts --> 
 <script type="text/javascript" src="jquery/jquery-2.1.1.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	console.log("js begin");
	/* MAIN MENU */

	  		$("#procesar_archivo_csv").on("click",function(){
	  			$("#principal").load("procesarArchivo.jsp");
	  		});
	
console.log("js complete");;	   
});

</script>

</head>
<body>

	<h1><b>Alta de Carga</b></h1>

	<form name = "formulario" action="Controlador?action=buscarCPA" method="POST" enctype="multipart/from-data" 
	class="form-style-2" onsubmit="return validacion()">
		<table cellspacing="3" cellpadding="3" border="0" width="100%">
			
			<tr>
				<td><b>Calle:</b><td><input type="text" size="30" name="calle"></td>
				<td><b>Altura:</b><td><input type="text" size="10" name="altura"></td>
				<td><b>CP:</b><td><input type="text" size="10" name="cp"></td>
			</tr>
			<tr>	
				<td><b>Localidad:</b><td><input type="text" size="20" name="localidad"></td>
				<td><b>Provincia:</b><td><input type="text" size="20" name="provincia"></td>
			</tr>
			
			
			<!-- <tr>
				<td><b>Provincia:</b>
				<td>
					<select name="provincia">
						<%  provincias = Sistema.getInstancia().getProvincias();
							for(Provincia p : provincias){ %>
            				<option><%= p.getNombre()%></option>
        				<% } %>
					</select>
				</td>
			</tr>  -->  
			
			
			
			

			<tr>
				<td style="text-align:center;"><input type="submit" value="Buscar"></td>
			</tr>


		</table>
		
	</form>
	
	<div id="resultados"></div>
	
	
	
	
	<a href="index.jsp">Volver</a>
</body>
</html>