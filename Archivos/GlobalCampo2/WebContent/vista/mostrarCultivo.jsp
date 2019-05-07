<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Cultivos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
            
            a:link 
{ 
text-decoration:none; 
color: white;
} 
        </style>
</head>


<body class="bg-light" style="margin: 0;padding:0">
	        <div class="container">
            <div class="py-4 text-center">
            	<img class="d-block mx-auto mb-4" src="vista/img/cultivo.png" alt="" width="72" height="72">
                <h2>GESTION DE LOS CULTIVOS</h2>
                <p class="lead">A continuacion podra gestionar los cultivos de sus socios</p>
            </div>
        </div>
	<table>
		<tr>
			<td><a class="btn btn-primary" href="adminCultivo?action=index" >Ir al menu</a> </td>
			<td><a class="btn btn-secondary" target="_blank" href="https://www.google.com/maps/place/Llanos+de+Don+Juan,+C%C3%B3rdoba/@37.4065261,-4.4164942,17z/data=!4m5!3m4!1s0xd6d77ea7d0b135d:0x231d5c2e55c835b1!8m2!3d37.4069623!4d-4.4146723">Ver Mapa de la zona</a></td>
			
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td>ID</td>
		 <td> Nombre del Cultivo</td>
		 <td> Descripcion del Cultivo</td>
		 <td>Registro del Cultivo</td>
		 <td>Cooperativa habitual del Cultivo</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="cultivo" items="${listaCultivo}">
			<tr>
				
				<td><c:out value="${cultivo.codCul}"/></td>
				<td><c:out value="${cultivo.nomCul}"/></td>
				<td><c:out value="${cultivo.desCul}"/></td>
				<td><c:out value="${cultivo.regCul}"/></td>
				<td><c:out value="${cultivo.copeCul}"/></td>
				<td><a class="btn btn-secondary" href="adminCultivo?action=showedit&codCul=<c:out value="${cultivo.codCul}" />">Editar</a></td>
				<td><a class="btn btn-danger" href="adminCultivo?action=eliminar&codCul=<c:out value="${cultivo.codCul}"/>">Borrar</a> </td>	
			</tr>
		</c:forEach>
	</table>
	

	
</body>
</html>