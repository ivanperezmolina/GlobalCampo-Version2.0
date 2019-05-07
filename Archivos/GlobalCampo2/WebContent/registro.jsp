<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>
<div class="container">
	        <section id="formulario" class="p-3" >
            <h1 class="display-3 text-center" >Solicitud de Registro en GlobalCampo</h1>
            <h3 class="text-center" >En este apartado podras solicitar tu registro en GlobalCampo</h3>
             <div class="container-fluid text-dark text-center"  id="container-fluid2" style="padding-bottom: 2%">
                <div class="row text-center">
                  <div class="col-sm-12 col-md-12  text-center ">
                    <form action="mailto:ivan.perez.8500@gmail.com" method="post" enctype="text/plain">
                        <div class="form-group">
                            Nombre <br>
                            <input type="text" class="form-control" name="Nombre"  placeholder="Introduce tu nombre (no nick)" pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.']{2,48}" required>
                        </div>
                        <div class="form-group">
                          Correo para el registro<br>
                          <input type="email" class="form-control" name="Correo" placeholder="Introduce tu Correo (estilo: yo@dominio.com)" required>
                          
                        </div>
                        <div class="form-group">
                            Telefono <br>
                            <input type="tel" class="form-control" name="Telefono" placeholder="Introduce tu numero de telefono (9 digitos)" pattern="[0-9]{9}"required>
                        </div>

                        <div class="form-group">
                            Comentarios para los administradores <br>
  							 <input type="textarea" class="form-control" name="Comentarios" pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.']{2,48}" placeholder="Introduce tus comentarios">
                          </div>
                        <div class="form-group form-check">
                          <input type="checkbox" class="form-check-input" id="exampleCheck1">
                          <label class="form-check-label" for="exampleCheck1">He leido los <u>terminos y condiciones de privacidad</u></label>
                        </div>
                        

     			
     			
     			
     			<button type="submit" value="Send"  class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong">
  Enviar
</button>
<input type="reset" value="Reset" class="btn btn-info">
     			
     			<!-- Modal -->
			<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLongTitle">Redirigiendo</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        Esta siendo redirigido a su aplicacion de correo favorita; ahora simplemente le queda enviar dicho correo y nuestros administradores podran registrarlo en Globalcampo<br>
			        <i>Puede que el proceso tarde hasta una semana. Puede hacer un seguimiento de la solicitud llamando al 902202122 </i><br><br>
			        Si la aplicacion no abre compruebe que esten bien los campos del formulario o reinicie su navegador
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">De acuerdo</button>
			        
			      </div>
			    </div>
			  </div>
			</div>

        </section><!--FIN SECTION FORMULARIO-->
</div>





</body>
</html>