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
                                <a class="nav-link active" data-toggle="tab" href="#panel7" role="tab"><i class="fas fa-handshake mr-1"></i>
                                    Contraentega</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#panel8" role="tab"><i class="fab fa-cc-visa mr-1"></i>
                                    Online</a>
                            </li>
                        </ul>

                        <!-- Tab panels -->
                        <div class="tab-content">
                            <!--Panel 7-->
                            <div class="tab-pane fade in show active" id="panel7" role="tabpanel">

                                <!--Body-->
                                <form action="ControlCarrito">
                                    <div class="modal-body mb-1 text-center">


                                        <div class="md-form form-sm mb-5 justify-content-md-center">
                                            <input class="form-check-input" type="radio" value="Efectivo"  name="ContraentregaPago" required="">
                                            <i class="fas fa-money-bill-alt prefix"></i>

                                            <label class="form-check-label mb-4 col-sm-2" for="defaultCheck2">
                                                Efectivo
                                            </label>


                                        </div>

                                        <div class="md-form form-sm mb-5" style="margin-bottom: 10px;">
                                            <input class="form-check-input" type="radio" value="Tarjeta de credito" name="ContraentregaPago">
                                            <i class="fas fa-credit-card prefix"></i>
                                            <label class="form-check-label" for="defaultCheck2">
                                                Tarjeta de debito/credito
                                            </label>
                                        </div>

                                        <div class="text-center mt-2">
                                            <input type="hidden" name="accion" value="Confirma2">
                                            <input type="hidden" name="tipo_pago" value="Contraentrega">
                                            <button type="submit" class="btn btn-secondary">Listo<i class="fas fa-smile-beam ml-1"></i></button>
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

                                        <input type="hidden" name="opc" value="1">

                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="inputEmail4">Nombre</label>
                                            <input type="text" class="form-control" id="inputEmail4" placeholder="Nombre completo" required="">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="inputPassword4">Apellido</label>
                                            <input type="text" class="form-control" id="inputPassword4" placeholder="Apellido completo" required="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputAddress">Numero de Tarjeta</label>
                                        <input type="text" class="form-control" id="inputAddress" placeholder="11111-2222-3333-4444" required="">
                                    </div>
                                    
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="inputCity">Codigo de Seguridad</label>
                                            <input type="text" class="form-control" id="inputCity" placeholder="CCV" required="">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="inputState">Expiracion</label>
                                            <select id="inputState" class="form-control">
                                                
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                                <option>6</option>
                                                <option>7</option>
                                                <option>8</option>
                                                <option>9</option>
                                                <option>10</option>
                                                <option>11</option>
                                                <option selected>12</option>
                                                
                                            </select>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="inputState2" text-white>. </label>
                                            <select id="inputState2" class="form-control">
                                               
                                                <option selected>20</option>
                                                <option>21</option>
                                                <option>22</option>
                                                <option>23</option>
                                                <option>24</option>
                                                <option>25</option>
                                            </select>
                                        </div>
                                    </div>
                                    
                                        <div class="text-center form-sm mt-2">
                                            <input type="hidden" name="accion" value="Confirma2">
                                            <input type="hidden" name="tipo_pago" value="Online">
                                            <button type="submit" class="btn btn-secondary text-white">Listo<i class="fas fa-smile-beam ml-1"></i></button>
                                        </div>
                                        
                                    </div>
                                    
                                         

                                    </div>   
                                        

                                </form>
                                <!--Footer-->
                                <!--<div class="modal-footer">

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
