
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="formulario-conten">
            <div class="row">
                <div class="col-md-2 col-xs-2"></div>
                <div class="col-md-8 col-xs-8">

                    <form id="form-register" method="POST" action="">

                        <h1>Registrarme</h1>
                        <span class="text-sub">Por favor, Ingrese la siguiente información</span>
                        <div class="clearfix">
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6 col-xs-6">
                                <input class="form-control" type="text" name="nombre" value="" placeholder="Nombres" >
                            </div>
                            <div class="form-group col-md-6 col-xs-6">
                                <input class="form-control" type="text" name="apellido" value="" placeholder="Apellidos">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col">
                                <input class="form-control" type="text" name="email" value="" placeholder="Correo electrónico">
                            </div>
                            <div class="viewpassword col">
                                <div class="form-group bgSlctArrow">
                                    <select id="doc_tipo" class="form-control" name="doc_tipo">
                                        <option value="">Seleccione tipo de documento</option>
                                        <option value="0">DNI</option>
                                        <option value="1">RUC</option>
                                        <option value="2">Carnet de Extranjería</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6 col-xs-6">
                                <input id="doc_numero" maxlength="12" class="form-control" type="text" name="doc_numero" value="" placeholder="Documento">
                            </div>
                            <div class="form-group col-md-6 col-xs-6">
                                <input id="fecha_nacimineto" class="form-control" type="text" name="fecha_nacimiento" value="" placeholder="Fecha nacimiento  dd/mm/aaa">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col bgSlctArrow">
                                <select class="form-control" name="genero">
                                    <option value="">Seleccione género</option>
                                    <option value="1">Femenino</option>
                                    <option value="2">Masculino</option>
                                </select>
                            </div>
                            <div class="viewpassword col">
                                <div class="form-group">
                                    <input class="form-control" type="password" name="password" value="" placeholder="Contraseña">
                                    <!--<a class="viewclave" onclick="mostrar_clave(this)"><i class="fa fa-eye" aria-hidden="true"> </i><span> Mostrar </span></a>-->
                                </div>
                            </div>
                        </div>
                        <div class="row register-checked">
                            <div class="col-md-12">
                                <input type="checkbox" id="terminos">
                                <label for="terminos">Acepto los <a href="">TÉRMINOS Y CONDICIONES DE USO</a> y asimismo declaro haber leído </label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 col-xs-6">
                            </div>
                            <div class="col-md-6 col-xs-6">
                                <input type="submit" class="btn btn-secondary btn-block " value="CREAR">
                            </div>
                            <div class="col-md-3 col-xs-6">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-2 col-xs-2"></div>
            </div>
        </div>

    </body>
</html>
