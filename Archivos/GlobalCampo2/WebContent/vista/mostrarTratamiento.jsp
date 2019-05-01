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
<title>Administrar Tratamientos</title>
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
            <img class="d-block mx-auto mb-4" src="vista/img/atomizador.png" alt="" width="72" height="72">
                <h2>GESTIÓN DE LOS TRATAMIENTOS</h2>
                <p class="lead">A continuación podra gestionar sus tratamientos al olivar</p>
            </div>
        </div>
	<table>
		<tr>
			<td><a class="btn btn-primary" href="adminTratamiento?action=index" >Ir al menú</a> </td>
			<td><a class="btn btn-info" href="tel:+34609663323">Llamar por teléfono al administrador</a></td>
		</tr>
	</table>
	<br>
	<table class="table">
  <thead class="thead-success">
    <tr>
      <th scope="col">CodTra</th>
      <th scope="col">Fecha del Tratamiento</th>
      <th scope="col">Descripcion del Tratamiento </th>
      <th scope="col">Tipo de Tratamiento</th>
      <th scope="col">Cultivo Tratado</th>
      <th scope="col">Fertilizante Aplicado</th>
      <th scope="col" colspan=2>Acciones</th>
    </tr>
  </thead>
  
  <tbody>
  <c:forEach var="tratamiento" items="${listaTratamiento}">
    <tr>
      <th scope="row"><c:out value="${tratamiento.codTra}"/></th>
				<td><c:out value="${tratamiento.fecTraString}"/></td>
				<td><c:out value="${tratamiento.desTra}"/></td>
				<td><c:out value="${tratamiento.tipTra}"/></td>
				<td><c:out value="${tratamiento.nomCul}"/></td>
				<td><c:out value="${tratamiento.nomFer}"/></td>
								
				<td><a class="btn btn-secondary" href="adminTratamiento?action=showedit&codTra=<c:out value="${tratamiento.codTra}" />">Editar</a></td>
				<td><a class="btn btn-danger" href="adminTratamiento?action=eliminar&codTra=<c:out value="${tratamiento.codTra}"/>">Eliminar</a> </td>	
    </tr>
    </c:forEach>

</body>
</html>