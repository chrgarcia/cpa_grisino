<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Principal</title>

 <!-- Scripts --> 
 <script type="text/javascript" src="jquery/jquery-2.1.1.js"></script>

 <!-- CSS -->
 <link href="css/style.css" rel="stylesheet" type="text/css" />

 <!-- Tipografia -->
 <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>

<script type="text/javascript">
$(document).ready(function() {
	console.log("js begin");
	/* MAIN MENU */

	  		$("#procesar_archivo_csv").on("click",function(){
	  			$("#principal").load("procesarArchivo.jsp");
	  		});
	
	  		$("#buscarCPA").on("click",function(){
	  			$("#principal").load("buscarCPA.jsp");
	  		});
	
	
console.log("js complete");;	   
});

</script>


</head>

<body>

<div class="container">
    <div class="content">
        <div id="wrap">
        	<header>
        		<div class="inner relative">
                      <ul style="width:227px;">
        				<li style="width:230px;"><a class="logo" href="index.jsp"><img src="images/logo_web_dgv_02.jpg" alt="" border="0"></a></li>
                        </li>
         			    </ul>
         			    
                    <a id="menu-toggle" class="button dark" href="#"></a>
        			<nav id="navigation">
        				<ul id="main-menu">
        				 	<li class="current-menu-item"><a href=""></a></li>  
        					
        					<li class="parent" style="text-align:left;display: inline-block;">
        						<a class="parent" href="#"> Procesar CPA´s</a>
        							<ul class="sub-menu">
        								<li><a id="procesar_archivo_csv">Procesar archivo completo CSV</a></li>
		        					</ul>
        					</li>
        					
        					<li class="parent" style="text-align:left;display: inline-block;">
        						<a class="parent" href="#">CPA</a>
        							<ul class="sub-menu">
        								<li><a id="buscarCPA">Buscar CPA</a></li>
		        					</ul>
        					</li>
        					
        
                        </ul>    
                            
        		    </nav>
        			<div class="clear"></div>
        			
          		</div>
        	</header>
        </div>	

		
		<div id="principal">
		
		
		
		
		</div>
		

		
		
		
		
	</body>
</html>