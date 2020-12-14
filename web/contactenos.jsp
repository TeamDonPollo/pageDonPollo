<!DOCTYPE html>
<html>
      
    <%@include file="Head.jsp" %>
    <body>

        <!-- BARRA DE NAVEGACION-->

        <%@include file="Cabecera.jsp" %>
          <footer class="fondo">

    <div class="deg-fondo"></div>

    <div class="ejeZfondo">
        <div class="fondo-conten">
            <div class="fondo-title">


                <h2 >Formulario de Contacto</h2>
              
                <hr>
            </div>

            <div class="formulario-conten">
                <form action="ControlConsulta" name="fr" id="formulario">

                    <label for="usuario" >Nombre y apellido:</label>
                    <input type="text" id="usuario" name="usuario" placeholder="Ingresa tu Nombre">

                    <label for="email">Correo Electronico:</label>
                    <input type="email" id="email" name="email" placeholder="Ingresa tu Correo Electronico">

                    <label for="mensaje">Escribe tu mensaje</label>
                    <textarea name="mensaje" id="mensaje"></textarea>
                    <input type="hidden" name="opc" value="3">
                    <div class="send">
                        <button class="btn btn-primary my-2 my-sm-0" type="submit" value="Enviar" onclick="calculo()">Enviar</button>
                    </div>


                    <div class="mensaje-form">
                        <center><p>Escribenos un mensaje, con gusto tendras una respuesta de parte de nosotros en muy poco tiempo.</p></center>
                    </div>
                </form>
            </div>
        </div>
            <script type="text/javascript">
                function calculo() {
                    nom = fr.usuario.value;
                    alert("Gracias " + nom + ", hemos enviado un mensaje a tu correo :)");
                }
            </script> 


            </footer>
        <%--<%@include file="Footer.jsp" %>--%>
         
        <!-- Script de BOOTSTRAP-->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>




    </body>
</html>