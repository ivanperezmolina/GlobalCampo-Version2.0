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
    	if(!nivel.equals("2")){
    		response.sendRedirect("index.jsp");    		
    	}
    }
    
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Podas</title>
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
            	<img class="d-block mx-auto mb-4" src="vista/img/poda.png" alt="" width="72" height="72">
                <h2>GESTIÓN DE LAS PODAS</h2>
                <p class="lead">A continuación podra gestionar sus podas</p>
            </div>
        </div>
        <br>
	<table>
		<tr>
			<td><a class="btn btn-primary" href="adminPoda?action=index" >Ir al menú</a> </td>
			<td><a class="btn btn-info" href="tel:+34609663323">Llamar por teléfono al administrador</a></td>
		</tr>
	</table>
	<br>
	
	<table class="table">
  <thead class="thead-success">
    <tr>
      <th scope="col">CodPod</th>
      <th scope="col">Fecha de Poda</th>
      <th scope="col">Olivos Podados </th>
      <th scope="col">Descripción de la poda</th>
      <th scope="col">Cultivo Podado</th>
      <th scope="col" colspan=2>Acciones</th>
    </tr>
  </thead>
  
  <tbody>
  <c:forEach var="poda" items="${listaPoda}">
    <tr>
      <th scope="row"><c:out value="${poda.codPod}"/></th>
				<td><c:out value="${poda.fecPodString}"/></td>
				<td><c:out value="${poda.oliPod}"/></td>
				<td><c:out value="${poda.desPod}"/></td>
				<td><c:out value="${poda.nomCul}"/></td>
				
				<td><a class="btn btn-secondary" href="adminPoda?action=showedit&codPod=<c:out value="${poda.codPod}" />">Editar</a></td>
				<td><a class="btn btn-danger" href="adminPoda?action=eliminar&codPod=<c:out value="${poda.codPod}"/>">Eliminar</a> </td>	
    </tr>
    </c:forEach>	
</body>
</html>