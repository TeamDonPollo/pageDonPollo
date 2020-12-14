<!--Modal: Login / Register Form-->
<div class="modal fade" id="modalRegistro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <!--Content-->
        <div class="modal-content">

            <!--Modal cascading tabs-->
            <div class="modal-c-tabs">

                <!-- Nav tabs -->
                <ul class="nav nav-tabs md-tabs tabs-2 light-blue darken-3" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#panel7" role="tab"><i class="fas fa-user mr-1"></i>
                            Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#panel8" role="tab"><i class="fas fa-user-plus mr-1"></i>
                            Registro</a>
                    </li>
                </ul>

                <!-- Tab panels -->
                <div class="tab-content">
                    <!--Panel 7-->
                    <div class="tab-pane fade in show active" id="panel7" role="tabpanel">

                        <!--Body-->
                        <form action="ControlRegistro">
                            <div class="modal-body mb-1">
                                <div class="md-form form-sm mb-5">
                                    <i class="fas fa-address-card prefix"></i>
                                    <label>Tu email</label>
                                    <input  name="email" type="text" required="" class="form-control form-control-sm ">
                                </div>

                                <div class="md-form form-sm mb-4">
                                    <i class="fas fa-lock prefix"></i>
                                    <label>Tu contraseña</label>
                                    <input name="password" type="password" class="form-control form-control-sm ">
                                </div>
                                <div class="text-center mt-2">
                                    <input type="hidden" name="opc" value="4">
                                    <button class="btn btn-success">Entrar <i class="fas fa-sign-in-alt ml-1"></i></button>
                                </div>
                            </div>
                        </form>
                        <!--Footer-->
                        <div class="modal-footer">

                            <button type="button" class="btn btn-outline-secondary ml-auto" data-dismiss="modal">Cerrar</button>
                        </div>

                    </div>
                    <!--/.Panel 7-->

                    <!--Panel 8-->
                    <div class="tab-pane fade" id="panel8" role="tabpanel">

                        <!--Body-->
                        <form action="ControlRegistro">
                            <div class="modal-body">

                                <div class="md-form form-sm mb-5">
                                    <i class="fas fa-address-card prefix"></i>
                                    <label>Tu nombre</label>
                                    <input  name="nombre" type="text" class="form-control form-control-sm">
                                </div>

                                <div class="md-form form-sm mb-5">
                                    <i class="fas fa-address-card prefix"></i>
                                    <label>Tu email</label>
                                    <input  name="email" type="email" class="form-control form-control-sm">
                                </div>

                                <div class="md-form form-sm mb-5">
                                    <i class="fas fa-lock prefix"></i>
                                    <label>Una contraseña</label>
                                    <input name="password" type="password"  class="form-control form-control-sm">
                                </div>

                                <input type="hidden" name="opc" value="1">

                                <!--<div class="md-form form-sm mb-4">
                                    <i class="fas fa-lock prefix"></i>
                                    <label>Repite la contraseña</label>
                                    <input type="password"  class="form-control form-control-sm">
                                </div>-->

                                <div class="text-center form-sm mt-2">
                                    <button type="submit" class="btn btn-success text-white">Registrar<i class="fas fa-sign-in-alt ml-1"></i></button>
                                </div>

                            </div>
                        </form>
                        <!--Footer-->
                        <div class="modal-footer">

                            <button type="button" class="btn btn-outline-secondary ml-auto" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                    <!--/.Panel 8-->
                </div>

            </div>
        </div>
        <!--/.Content-->
    </div>
</div>
<!--Modal: Login / Register Form-->