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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Cultivo</title>
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
	<h1>Registrar Cultivo</h1>
	<br>
		<table>
		<tr>
			<td><a class="btn btn-primary" href="adminCultivo?action=index" >Ir al menú</a> </td>
		</tr>
	</table>
	<br>
	<form action="adminCultivo?action=register" method="post">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Nombre del Cultivo</label>
		    <input type="text" class="form-control" name="nomCul"  placeholder="NomCul">
  		</div>
  		
  				  <div class="form-group">
		    <label for="exampleInputEmail1">Descripción del Cultivo</label>
		    <input type="text" class="form-control" name="desCul"  placeholder="DesCul">
  		</div>
  		
  				  <div class="form-group">
		    <label for="exampleInputEmail1">Registro del Cultivo</label>
		    <input type="number" min="0" max="999999999" class="form-control" name="regCul"  placeholder="RegCul">
  		</div>
  		
  				  <div class="form-group">
		    <label for="exampleInputEmail1">Cooperativa habitual del Cultivo</label>
		    <input type="text" class="form-control" name="copeCul"  placeholder="CopeCul">
  		</div>

	
		
	
	<br>

		
		<button type="submit" class="btn btn-primary btn-lg" value="Agregar" name="agregar">Agregar</button>
	
	</form>
	</div>
</body>
</html>