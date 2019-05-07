<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
    
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
<title>Actualizar Tratamiento</title>
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
<h1>Actualizar Tratamiento</h1>
	<form action="adminTratamiento?action=editar" method="post" >
		<div class="form-group">
		    <label for="exampleInputEmail1">Codigo </label>
		    <input type="number" class="form-control" name="codTra" value='<c:out value="${tratamiento.codTra}"></c:out>'  placeholder="CodTra">
  		</div>
  		
		<div class="form-group">
		    <label for="exampleInputEmail1">Fecha del tratamiento </label>
		    <input type="date" class="form-control" name="fecTra" value='<c:out value="${tratamiento.fecTra}"></c:out>' placeholder="FecTra">
  		</div>
  		
		<div class="form-group">
		    <label for="exampleInputEmail1">Descripcion del tratamiento </label>
		    <input type="text" class="form-control" name="desTra"  value='<c:out value="${tratamiento.desTra}"></c:out>' placeholder="DesTra">
  		</div>
  		
 		<div class="form-group">
		    <label for="exampleInputEmail1">Tipo de Tratamiento</label>
		    <input type="text"  class="form-control" name="tipTra" value='<c:out value="${tratamiento.tipTra}"></c:out>' placeholder="TipTra">
  		</div>
  		
 		<div class="form-group">
		    <label for="exampleInputEmail1">Cultivo Tratado </label>
           <%
           //Conexión con la base de datos para coger valores especificos
           Class.forName("com.mysql.jdbc.Driver");
           Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/globalcampo", "root", "");
           Statement s = conexion.createStatement();
           Statement s2 = conexion.createStatement();
           
           ResultSet listado7 = s2.executeQuery("SELECT CodCul, NomCul FROM cultivo");
           
              out.print("<select class=\"custom-select\" name=\"codCul\" required=\"required\">");
              while (listado7.next()) {
                  out.print("<option value=\"" + listado7.getString("CodCul") + "\">" + listado7.getString("NomCul") + "</option>");
              }
              out.print("</select>");
           %>
  		</div>

		<div class="form-group">
		    <label for="exampleInputEmail1">Fertilizante Aplicado </label>
           <%
           //Conexión con la base de datos para coger valores especificos

           
           ResultSet listado9 = s2.executeQuery("SELECT CodFer, NomFer FROM fertilizante");
           
              out.print("<select class=\"custom-select\" name=\"codFer\" required=\"required\">");
              while (listado9.next()) {
                  out.print("<option value=\"" + listado9.getString("CodFer") + "\">" + listado9.getString("NomFer") + "</option>");
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