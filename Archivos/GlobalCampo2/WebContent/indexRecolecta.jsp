<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
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
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RECOLECTAS</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
	a:link 
	{ 
		text-decoration:none;
		color: white; 
	} 
</style>
</head>
<body>
<div class="container">
	<h1 style="text-align: center;">Administrar Recolectas</h1>
	<br>
	<button type="button" class="btn btn-success btn-lg btn-block"><a href="adminRecolecta?action=nuevo">Nuevo</a></button>
	<br>
	<button type="button" class="btn btn-secondary btn-lg btn-block"><a href="adminRecolecta?action=mostrar">Mostrar</a></button>
	<br>
 	<button type="button" class="btn btn-warning btn-lg btn-block"><a href="indexUser.jsp">Volver al panel de control</a></button>
	

</div>	
	
</body>
</html>