<%-- 
    Document   : pConfirma1
    Created on : 11/12/2020, 05:11:38 PM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <%@include file="Head.jsp" %>
     
     
    <body>
        
        <%@include file="Cabecera.jsp" %>
        
        <div class="form" id="modalRegistro" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <!--Content-->
        <div class="modal-content">

            <!--Modal cascading tabs-->
            <div class="modal-c-tabs">

                <!-- Nav tabs -->
                <ul class="nav nav-tabs md-tabs tabs-2 dark-blue" role="tablist" style="margin:0; padding:0;">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#panel7" role="tab"><i class="fas fa-truck mr-1"></i>
                            Delivery</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#panel8" role="tab"><i class="fas fa-street-view mr-1"></i>
                            Despacho</a>
                    </li>
                </ul>

                <!-- Tab panels -->
                <div class="tab-content">
                    <!--Panel 7-->
                    <div class="tab-pane fade in show active" id="panel7" role="tabpanel">

                        <!--Body-->
                        <form action="ControlCarrito">
                            <div class="modal-body mb-1">
                                <div class="md-form form-sm mb-5">
                                    <i class="fas fa-map-marked-alt prefix"></i>
                                    <label>Ingresar su direccion</label>
                                    <input name="Direccion" type="text" required="" class="form-control form-control-sm ">
                                </div>
                                
                                <div class="md-form form-sm mb-5">
                                    <i class="fas fa-map-pin prefix"></i>
                                    <label>Referencia</label>
                                    <input name="Referencia" type="text" required="" class="form-control form-control-sm ">
                                </div>

                                <div class="md-form form-sm mb-4">
                                    <i class="fas fa-mobile-alt prefix"></i>
                                    <label>Numero Celular</label>
                                    <input name="Celular" type="text" required="" class="form-control form-control-sm ">
                                </div>
                                <div class="text-center mt-2">
                                    <input type="hidden" name="accion" value="Confirma1">
                                    <input type="hidden" name="tipo" value="Delivery">
                                    <button class="btn btn-secondary">Continuar <i class="fas fa-shipping-fast ml-1"></i></button>
                                </div>
                            </div>
                        </form>
                        <!--Footer-->
                        <div class="modal-footer">

                            <a href="index2.jsp" type="button" class="btn btn-outline-secondary ml-auto">Continuar comprando</a>
                        </div>

                    </div>
                    <!--/.Panel 7-->

                    <!--Panel 8-->
                    <div class="tab-pane fade" id="panel8" role="tabpanel">

                        <!--Body-->
                        <form action="ControlCarrito">
                            <div class="modal-body">

                                <div class="md-form form-sm mb-5">
                                    <i class="fas fa-address-card prefix"></i>
                                    <label>Tu nombre</label>
                                    <input  name="Nombre" type="text" class="form-control form-control-sm"  required="" value="<%=nombreUsuario%>">
                                </div>

                                <input type="hidden" name="accion" value="Confirma1">
                                   <input type="hidden" name="tipo" value="Despacho">

                                <div class="text-center form-sm mt-2">
                                    <button type="submit" class="btn btn-secondary text-white">Continuar<i class="fas fa-store ml-1"></i></button>
                                </div>

                            </div>
                        </form>
                        <!--Footer-->
                        <div class="modal-footer">

                            <a href="index2.jsp" type="button" class="btn btn-outline-secondary ml-auto" >Continuar comprando</a>
                        </div>
                    </div>
                    <!--/.Panel 8-->
                </div>

            </div>
        </div>
        <!--/.Content-->
    </div>
</div>
                                
    <%@include file="Footer.jsp" %>                            
                                
    </body>
</html>
