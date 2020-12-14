<br>
<footer class="fondo">

    <div class="deg-fondo"></div>

    <div class="ejeZfondo">
        <div class="fondo-conten">
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
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

<<<<<<< HEAD
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
            <script type="text/javascript">
                function calculo() {
                    nom = fr.usuario.value;
                    alert("Gracias " + nom + ", hemos enviado un mensaje a tu correo :)");

                }
            </script> 


            </footer>

            <br>
            <div class="fondo-text" >
                <h5><span class="icon-sphere"></span> PolleríaDonPollo-2020 </h5>
            </div>
            
            <%@include file="logueo.jsp" %>