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

 
  <div class="row">
  <br>
    <div class="col-sm">
     <h3>GlobalCampo</h3>
    </div>
    <div class="col-sm">
      
    </div>
    <div class="col-sm">
         
                    <nav class="nav nav-masthead justify-content-center">
                        <a href="https://www.facebook.com/ivan.perezmolina.5">
                            <img border="0" alt="W3Schools" src="facebook.png" width="20" height="20" HSPACE="10" VSPACE="10">
                        </a>

                        <a href="https://twitter.com/Ivan852000">
                            <img border="0" alt="W3Schools" src="twitter.png" width="20" height="20" HSPACE="10" VSPACE="10">
                        </a>

                        <a href="https://plus.google.com/+Iv%C3%A1nP%C3%A9rezMolina">
                            <img border="0" alt="W3Schools" src="google.png" width="20" height="20" HSPACE="10" VSPACE="10">
                        </a>

                        <a href="https://www.instagram.com/ivanperez8500/?hl=es">
                            <img border="0" alt="W3Schools" src="instagram.png" width="20" height="20" HSPACE="10" VSPACE="10">
                        </a>


                    </nav>
    </div>
  </div>

  
    <form class="form-signin" action="SERVLOGIN" method="post">
    <br>
      <img src="icono2.png" alt="" width="100" height="100">

      
 
      

		  
		  <h1 class="h3 mb-3 font-weight-normal">Inicio de sesión</h1>
		  
		  
		  <input type="text" name="txtusuario" class="form-control" placeholder="Ingrese su nombre de usuario">
		  <br><br>
		 
		  <input type="password" name="txtcontra" class="form-control" placeholder="Ingrese su contraseña">
			<br><br>
		  <button class="btn btn-lg btn-primary btn-block" name="btnIniciar" value="Iniciar Sesion" type="submit">Entrar a GlobalCampo</button>
		  
		  <br><br>
		  <a class="btn btn-lg btn-secondary btn-block" target="_blank" href="registro.jsp"> Registro en GlobalCampo</a>
		  
		  
		  <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	</form>	
	</div>
        <footer class="masthead mb-auto">
                <div class="inner">
                 
                </div>
 </footer>
      
            <footer class="mastfoot mt-auto">
                <div class="inner">
                    <p style="color:white">Página web de <a href="https://www.linkedin.com/in/ivan-perez-molina/">Iván Pérez Molina</a></p>
                </div>
            </footer>


	
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