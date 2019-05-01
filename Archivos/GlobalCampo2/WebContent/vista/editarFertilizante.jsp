<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Fertilizante</title>
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
<h1>Actualizar Fertilizante</h1>
	<form action="adminFertilizante?action=editar" method="post" >
		<div class="form-group">
		    <label for="exampleInputEmail1">Codigo </label>
		    <input type="number" class="form-control" name="codFer" value='<c:out value="${fertilizante.codFer}"></c:out>'  placeholder="CodFer">
  		</div>
		<div class="form-group">
		    <label for="exampleInputEmail1">Nombre del Fertilizante </label>
		    <input type="text" class="form-control" name="nomFer" value='<c:out value="${fertilizante.nomFer}"></c:out>' placeholder="NomFer">
  		</div>
		<div class="form-group">
		    <label for="exampleInputEmail1">Descripción del Fertilizante </label>
		    <input type="text" class="form-control" name="desFer"  value='<c:out value="${fertilizante.desFer}"></c:out>' placeholder="DesFer">
  		</div>
  		
 		<div class="form-group">
		    <label for="exampleInputEmail1">Tipo de Fertilizante </label>
		    <input type="text"  class="form-control" name="tipCulFer" value='<c:out value="${fertilizante.tipCulFer}"></c:out>' placeholder="TipCulFer">
  		</div>
  		
 		<div class="form-group">
		    <label for="exampleInputEmail1">Unidad de almacenado </label>
		    <input type="text" class="form-control" name="uniFer" value='<c:out value="${fertilizante.uniFer}"></c:out>' placeholder="uniFer">
  		</div>

<br>

		<button type="submit" class="btn btn-primary btn-lg" value="Guardar" name="registrar">Modificar</button>
	
	
	</form>
</div>
</body>
</html>