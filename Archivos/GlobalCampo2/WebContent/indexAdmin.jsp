<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="true" %>
    
    <%-- AÑADO SEGURIDAD PARA QUE TENGAN QUE PASAR POR EL LOGIN --%>
    <%
    
    HttpSession sesion = request.getSession();
    
    if(sesion.getAttribute("nivel")==null){
    	response.sendRedirect("index.jsp");
    	
    }else{
    	String nivel = sesion.getAttribute("nivel").toString();
    	if(!nivel.equals("1")){
    		response.sendRedirect("index.jsp");    		
    	}
    }
    
    
    %>
	    
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Panel de control</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<style>
	a:link 
	{ 
	text-decoration:none; 
	} 
	
	      body{
      	background-image: url("fondousuario.jpg");
      }
    
	</style>
	</head>
	
	<body>
	<div class="container">
	<p style="text-align: right;"> Hola <%=sesion.getAttribute("nombre") %> ||  <a href="index.jsp?cerrar=true">Cerrar Sesión</a></p>
	<hr>	
	<h1 style="text-align: center; border: red 5px dotted; background-color:#ffffbf;">Panel de control Administradores</h1>
	<br>
	
	 <div class="row">
                <div class="col-md-6">
                    <div class="jumbotron">
                        <h2>
                            <a href="indexCultivo.jsp" style="text-align: center;">GESTIÓN DE LOS CULTIVOS</a>
                        </h2>

                    </div>
                </div>
                <div class="col-md-6">
                    <div class="jumbotron">
                        <h2>
                            <a href="indexFertilizante.jsp" style="text-align: center;">GESTIÓN EN FERTILIZANTES</a>
                        </h2>
                     </div>
				</div>
	</div>
	</div>
	</body>
	</html>
	
	