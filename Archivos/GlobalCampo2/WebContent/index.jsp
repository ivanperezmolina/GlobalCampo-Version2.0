<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page session="true"%>    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Sign In </title>

    

    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      body{
      	background-image: url("olivar3.jpg");
      }
    </style>

  </head>
  
  
  <body class="text-center" >
  <div class="container">
  
    <form class="form-signin" action="SERVLOGIN" method="post">
      <img src="icono2.png" alt="" width="100" height="100">
		  
		  <h1 class="h3 mb-3 font-weight-normal">Inicio de sesión</h1>
		  
		  
		  <input type="text" name="txtusuario" class="form-control" placeholder="Ingrese su nombre de usuario">
		  <br><br>
		 
		  <input type="password" name="txtcontra" class="form-control" placeholder="Ingrese su contraseña">
			<br><br>
		  <button class="btn btn-lg btn-primary btn-block" name="btnIniciar" value="Iniciar Sesion" type="submit">Entrar a GlobalCampo</button>
		  
		  <br><br>
		  <a class="btn btn-lg btn-secondary btn-block" target="_blank" href="registro.jsp"> Registro en GlobalCampo</a>
		  
		  
		  
	</form>	
	</div>


	
	<%
	HttpSession sesion = request.getSession();
    int nivel =0;
    
    		if(request.getAttribute("nivel")!=null){
    			nivel = (Integer) request.getAttribute("nivel");
    			if(nivel==1){
    				sesion.setAttribute("nombre", request.getAttribute("nombre"));
    				sesion.setAttribute("nivel", nivel);
    				response.sendRedirect("indexAdmin.jsp");
    			}else if(nivel==2){
    				sesion.setAttribute("nombre", request.getAttribute("nombre"));
    				sesion.setAttribute("nivel", nivel);
    				response.sendRedirect("indexUser.jsp");
    				
    			}
    		}
    		
    		if(request.getParameter("cerrar")!=null){
    			session.invalidate();
    			
    			
    		}
	
	%>
	
	
	
	
</body>
</html>