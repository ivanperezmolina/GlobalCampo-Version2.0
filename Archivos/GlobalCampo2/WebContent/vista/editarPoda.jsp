<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Poda</title>
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
<h1>Actualizar Poda</h1>
	<form action="adminPoda?action=editar" method="post" >
		<div class="form-group">
		    <label for="exampleInputEmail1">Codigo </label>
		    <input type="number" class="form-control" name="codPod" value='<c:out value="${poda.codPod}"></c:out>'  placeholder="CodPod">
  		</div>
  		
		<div class="form-group">
		    <label for="exampleInputEmail1">Fecha de la Poda </label>
		    <input type="date" class="form-control" name="fecPod" value='<c:out value="${poda.fecPod}"></c:out>' placeholder="FecPod">
  		</div>
  		
		<div class="form-group">
		    <label for="exampleInputEmail1">Olivos Podados </label>
		    <input type="number" class="form-control" name="oliPod"  value='<c:out value="${poda.oliPod}"></c:out>' placeholder="OliPod">
  		</div>
  		
		 <div class="form-group">
		    <label for="exampleInputEmail1">Descripci�n de la poda </label>
		    <input type="text" class="form-control" name="desPod" value='<c:out value="${poda.desPod}"></c:out>' placeholder="DesPod">
  		</div>
  		
  		 <div class="form-group">
		    <label for="exampleInputEmail1">Cultivo Podado </label>
           <%
           //Conexi�n con la base de datos para coger valores especificos
           Class.forName("com.mysql.jdbc.Driver");
           Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/globalcampo", "root", "");
           Statement s = conexion.createStatement();
           Statement s2 = conexion.createStatement();
           
           ResultSet listado6 = s2.executeQuery("SELECT CodCul, NomCul FROM cultivo");
           
              out.print("<select class=\"custom-select\" name=\"codCul\" required=\"required\">");
              while (listado6.next()) {
                  out.print("<option value=\"" + listado6.getString("CodCul") + "\">" + listado6.getString("NomCul") + "</option>");
              }
              out.print("</select>");
           %>
  		</div>
<br>

		<button type="submit" class="btn btn-primary btn-lg" value="Guardar" name="registrar">Modificar</button>
	
	
	</form>
</div>
</body>
</html>