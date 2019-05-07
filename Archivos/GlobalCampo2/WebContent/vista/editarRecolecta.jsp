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
<title>Actualizar Recolecta</title>
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
<h1>Actualizar Recolecta</h1>
	<form action="adminRecolecta?action=editar" method="post" >
		<div class="form-group">
		    <label for="exampleInputEmail1">Codigo </label>
		    <input type="number" class="form-control" name="codRec" value='<c:out value="${recolecta.codRec}"></c:out>'  placeholder="CodRec">
  		</div>
  		
		<div class="form-group">
		    <label for="exampleInputEmail1">Fecha de la Recolecta </label>
		    <input type="date" class="form-control" name="fecRec" value='<c:out value="${recolecta.fecRec}"></c:out>' placeholder="FecRec">
  		</div>
  		
		<div class="form-group">
		    <label for="exampleInputEmail1">Kilos obtenidos en la recolecta </label>
		    <input type="number" class="form-control" name="kilRec"  value='<c:out value="${recolecta.kilRec}"></c:out>' placeholder="KilRec">
  		</div>
  		
 		<div class="form-group">
		    <label for="exampleInputEmail1">Trabajadores que acudieron a la recolecta </label>
		    <input type="number"  class="form-control" name="traCul" value='<c:out value="${recolecta.traCul}"></c:out>' placeholder="TraCul">
  		</div>
  		
 		<div class="form-group">
		    <label for="exampleInputEmail1">DNI de la persona responsable </label>
		    <input type="text" class="form-control" name="dniPerRec" value='<c:out value="${recolecta.dniPerRec}"></c:out>' placeholder="DNIPerRec">
  		</div>

		 <div class="form-group">
		    <label for="exampleInputEmail1">Descripción de la recolecta </label>
		    <input type="text" class="form-control" name="desRec" value='<c:out value="${recolecta.desRec}"></c:out>' placeholder="DesRec">
  		</div>
  		
  		 <div class="form-group">
		    <label for="exampleInputEmail1">Cultivo Recolectado </label>
           <%
           //Conexión con la base de datos para coger valores especificos
           Class.forName("com.mysql.jdbc.Driver");
           Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/globalcampo", "root", "");
           Statement s = conexion.createStatement();
           Statement s2 = conexion.createStatement();
           
           ResultSet listado5 = s2.executeQuery("SELECT CodCul, NomCul FROM cultivo");
           
              out.print("<select class=\"custom-select\" name=\"codCul\" required=\"required\">");
              while (listado5.next()) {
                  out.print("<option value=\"" + listado5.getString("CodCul") + "\">" + listado5.getString("NomCul") + "</option>");
              }
              out.print("</select>");
           %>
  		</div>

  		

  		
  		
  		

		<button type="submit" class="btn btn-primary btn-lg" value="Guardar" name="registrar">Modificar</button>
	
	
	</form>
</div>
</body>
</html>