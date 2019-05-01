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
<title>Actualizar Cultivo</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>a:link 
{ 
text-decoration:none; 
color: white;
} 
</style>
</head>
<body>
<div class="container">
<h1>Actualizar Cultivo</h1>
	<form action="adminCultivo?action=editar" method="post" >
		<div class="form-group">
		    <label for="exampleInputEmail1">Codigo </label>
		    <input type="number" class="form-control" name="codCul" value='<c:out value="${cultivo.codCul}"></c:out>'  placeholder="CodCul">
  		</div>
		<div class="form-group">
		    <label for="exampleInputEmail1">Nombre del Cultivo </label>
		    <input type="text" class="form-control" name="nomCul" value='<c:out value="${cultivo.nomCul}"></c:out>' placeholder="NomCul">
  		</div>
		<div class="form-group">
		    <label for="exampleInputEmail1">Descripción del Cultivo </label>
		    <input type="text" class="form-control" name="desCul"  value='<c:out value="${cultivo.desCul}"></c:out>' placeholder="DesCul">
  		</div>
  		
 		<div class="form-group">
		    <label for="exampleInputEmail1">Registro del Cultivo </label>
		    <input type="number" min="0" max="999999999" class="form-control" name="regCul" value='<c:out value="${cultivo.regCul}"></c:out>' placeholder="RegCul">
  		</div>
  		
 		<div class="form-group">
		    <label for="exampleInputEmail1">Cooperativa Habitual del Cultivo </label>
		    <input type="text" class="form-control" name="copeCul" value='<c:out value="${cultivo.copeCul}"></c:out>' placeholder="CopeCul">
  		</div>

<br>

		<button type="submit" class="btn btn-primary btn-lg" value="Guardar" name="registrar">Modificar</button>
	
	
	</form>
</div>
</body>
</html>