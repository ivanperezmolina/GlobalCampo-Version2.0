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
<title>Administrar Fertilizante</title>
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
            	<img class="d-block mx-auto mb-4" src="vista/img/fertilizantes.png" alt="" width="72" height="72">
                <h2>GESTIÓN DE LOS FERTILIZANTES</h2>
                <p class="lead">A continuación podra gestionar los fertilizantes de los proovedores</p>
            </div>
        </div>
	<table>
		<tr>
			<td><a class="btn btn-primary" href="adminFertilizante?action=index" >Ir al menú</a> </td>
			<td><a class="btn btn-info" href="tel:+34609663323">Llamar al distribuidor de <br> fertilizantes más cercano</a></td>
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td>ID</td>
		 <td> Nombre del Fertilizante</td>
		 <td> Descripción del Fertilizante</td>
		 <td>Tipo de Fertilizante</td>
		 <td>Unidad de almacenado</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="fertilizante" items="${listaFertilizante}">
			<tr>
				<td><c:out value="${fertilizante.codFer}"/></td>
				<td><c:out value="${fertilizante.nomFer}"/></td>
				<td><c:out value="${fertilizante.desFer}"/></td>
				<td><c:out value="${fertilizante.tipCulFer}"/></td>
				<td><c:out value="${fertilizante.uniFer}"/></td>
				<td><a class="btn btn-secondary" href="adminFertilizante?action=showedit&codFer=<c:out value="${fertilizante.codFer}" />">Editar</a></td>
				<td><a class="btn btn-danger" href="adminFertilizante?action=eliminar&codFer=<c:out value="${fertilizante.codFer}"/>">Eliminar</a> </td>	
			</tr>
		</c:forEach>
	</table>
	

	

	
</body>
</html>