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
    	if(!nivel.equals("2")){
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


</style>


</head>
<body>
	<div class="container">
	<p style="text-align: right;"> Hola <%=sesion.getAttribute("nombre") %> ||  <a href="index.jsp?cerrar=true">Cerrar Sesión</a></p>
	<hr>	
	<h1 style="text-align: center;">Panel de control Usuario</h1>
	<br>
	
	                    <div class="row">
                        <div class="col-md-4">
                            <div class="jumbotron">
                                <h2>
                                    <a href="indexRecolecta.jsp">GESTIÓN DE LAS RECOLECTAS HECHAS EN LAS ACEITUNAS</a>
                                </h2>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="jumbotron">
                                <h2>
                                    <a href="indexPoda.jsp">GESTIÓN DE LAS PODAS REALIZADAS AL OLIVO</a>						
                                </h2>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="jumbotron">
                                <h2>
                                    <a href="indexTratamiento.jsp">GESTIÓN DEL TRATAMIENTO APLICADO A LOS OLIVOS</a>
                                </h2>
                            </div>
                        </div>
</div>
	</div>
</body>
</html>