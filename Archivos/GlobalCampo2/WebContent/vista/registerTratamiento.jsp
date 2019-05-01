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
<title>Registrar Tratamiento</title>
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
	<h1>Registrar Tratamiento</h1>
	<br>
		<table>
		<tr>
			<td><a class="btn btn-primary" href="adminTratamiento?action=index" >Ir al menú</a> </td>
		</tr>
	</table>
	<br>
	<form action="adminTratamiento?action=register" method="post">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Fecha del Tratamiento</label>
		    <input type="date" class="form-control" name="fecTra"  placeholder="FecTra">
  		</div>
  		
  		<div class="form-group">
		    <label for="exampleInputEmail1">Descripcion del Tratamiento</label>
		    <input type="text" class="form-control" name="desTra"  placeholder="DesTra">
  		</div>
  		
  		<div class="form-group">
		    <label for="exampleInputEmail1">Tipo de Tratamiento</label>
		    <input type="text" class="form-control" name="tipTra"  placeholder="TipTra">
  		</div>
  		
  		<div class="form-group">
		    <label for="exampleInputEmail1">Codigo de Cultivo</label>
		    <input type="number" class="form-control" name="codCul"  placeholder="CodCul">
  		</div>
  		
  		
  		
  		 <div class="form-group">
		    <label for="exampleInputEmail1">Codigo de Fertilizante</label>
		    <input type="number" class="form-control" name="codFer"  placeholder="CodFer">
  		</div>	
	<br>		
		<button type="submit" class="btn btn-primary btn-lg" value="Agregar" name="agregar">Agregar</button>
	
	</form>
	</div>
</body>
</html>