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
<title>Administrar Recolectas</title>
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


<body class="bg-light" style="margin: 0;padding:0">.

	        <div class="container">
            <div class="py-4 text-center">
           		<img class="d-block mx-auto mb-4" src="vista/img/iconol.png" alt="" width="72" height="72">
                <h2>GESTIÓN DE LAS RECOLECTAS</h2>
                <p class="lead">A continuación podra gestionar sus recolectas</p>
            </div>
        </div>
	<table>
		<tr>
			<td><a class="btn btn-primary" href="adminRecolecta?action=index" >Ir al menú</a> </td>
			<td><a class="btn btn-info" href="tel:+34609663323">Llamar por teléfono al administrador</a></td>
		</tr>
	</table>
	
	<table class="table">
  <thead class="thead-success">
    <tr>
      <th scope="col">CodRec</th>
      <th scope="col">Fecha de Recolecta</th>
      <th scope="col">Kilos obtenidos en la recolecta </th>
      <th scope="col">Trabajadores que acudieron a la recolecta</th>
      <th scope="col">DNI de la persona responsable</th>
      <th scope="col">Descripción de la recolecta</th>
      <th scope="col">Cultivo Recolectado</th>
      <th scope="col" colspan=2>Acciones</th>
    </tr>
  </thead>
  
  <tbody>
  <c:forEach var="recolecta" items="${listaRecolecta}">
    <tr>
      <th scope="row"><c:out value="${recolecta.codRec}"/></th>
				<td><c:out value="${recolecta.fecRecString}"/></td>
				<td><c:out value="${recolecta.kilRec}"/></td>
				<td><c:out value="${recolecta.traCul}"/></td>
				<td><c:out value="${recolecta.dniPerRec}"/></td>
				<td><c:out value="${recolecta.desRec}"/></td>
				<td><c:out value="${recolecta.nomCul}"/></td>
				
				<td><a class="btn btn-secondary" href="adminRecolecta?action=showedit&codRec=<c:out value="${recolecta.codRec}" />">Editar</a></td>
				<td><a class="btn btn-danger" href="adminRecolecta?action=eliminar&codRec=<c:out value="${recolecta.codRec}"/>">Eliminar</a> </td>	
    </tr>
    </c:forEach>	
</body>
</html>