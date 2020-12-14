
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="Head.jsp" %>
    <%@include file="Cabecera.jsp" %>
    <body>
        
        <%
            String nombre = request.getParameter("nombre");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            %>
        
        <div class="formulario-conten">
            <div class="row">
                <div class="col-md-2 col-xs-2"></div>
                <div class="col-md-8 col-xs-8">

                    <form id="form-register" action="ControlRegistro">

                        <h1>Registrarme</h1>
                        <span class="text-sub">Por favor, Ingrese la siguiente información</span>
                        <div class="clearfix">
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6 col-xs-6">
                                <input class="form-control" type="text" name="nombre" value="<%=nombre%>" placeholder="Nombres" >
                            </div>
                            <div class="form-group col-md-6 col-xs-6">
                                <input class="form-control" type="text" name="apellido" value="" placeholder="Apellidos">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col">
                                <input class="form-control" type="text" name="email" value="<%=email%>" placeholder="Correo electrónico">
                            </div>
                            <div class="viewpassword col">
                                <div class="form-group bgSlctArrow">
                                    <select id="doc_tipo" class="form-control" name="doc_tipo">
                                        <option value="">Seleccione tipo de documento</option>
                                        <option value="DNI">DNI</option>
                                        <option value="RUC">RUC</option>
                                        <option value="EXTRANJERIA">Carnet de Extranjería</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6 col-xs-6">
                                <input id="doc_numero" maxlength="12" class="form-control" type="text" name="doc_numero" value="" placeholder="Documento">
                            </div>
                            <div class="form-group col-md-6 col-xs-6">
                                <input id="fecha_nacimineto" class="form-control" type="text" name="fecha" value="" placeholder="Fecha nacimiento  dd/mm/aaa">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col bgSlctArrow">
                                <select class="form-control" name="sexo">
                                    <option value="">Seleccione género</option>
                                    <option value="Femenino">Femenino</option>
                                    <option value="Masculino">Masculino</option>
                                </select>
                            </div>
                            <div class="viewpassword col">
                                <div class="form-group">
                                    <input class="form-control" type="password" name="password" value="<%=password%>" placeholder="Contraseña">
                                    <!--<a class="viewclave" onclick="mostrar_clave(this)"><i class="fa fa-eye" aria-hidden="true"> </i><span> Mostrar </span></a>-->
                                </div>
                            </div>
                        </div>
                        <div class="row register-checked">
                            <div class="col-md-12">
                                <input type="checkbox" id="terminos" required="">
                                <label for="terminos">Acepto los <a href="">TÉRMINOS Y CONDICIONES DE USO</a> y asimismo declaro haber leído </label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 col-xs-6">
                            </div>
                            <div class="col-md-6 col-xs-6">
                                <input type="hidden" name="opc" value="2">
                                <input type="submit" class="btn btn-secondary btn-block " value="REGISTRAR">
                            </div>
                            <div class="col-md-3 col-xs-6">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-2 col-xs-2"></div>
            </div>
        </div>
        
        <%@include file="Footer.jsp" %>
    </body>
    <!-- Script de BOOTSTRAP-->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<<<<<<< HEAD
</html>
=======
<<<<<<< HEAD
</html>
=======
</html>
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
