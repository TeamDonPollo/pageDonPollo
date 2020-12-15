<%@page import="java.util.*"%>
<%@page import="modelo.*"%>
<!DOCTYPE html>
<html>
    <%@include file="Head.jsp" %>

    <body>
        


        <%@include file="Cabecera.jsp" %>

        
        <%
            HttpSession sesionCarrito = request.getSession();
            ArrayList<Compra> listaCarrito = (ArrayList<Compra>) sesionCarrito.getAttribute("canasta");
        %>
        <section>
            <div class="container">

                <%                    String codCliente = "", nombreLogeado = "";
                    if (sesionCarrito.getAttribute("idCliente") != null) {
                        codCliente = sesionCarrito.getAttribute("idCliente").toString();

                %>
               <!-- <h4>Cliente : <%//=sesionCarrito.getAttribute("nombreLogeado").toString()%></h4>
                <a href="javascript:GenerarCompra()" class="btn btn-success">Aceptar Compra</a> -->
                <%
                    }
                %>

                <div class="row">
                    <table class="table table-bordered table-striped table-hover">
                        <tr>
                            <th>Imagen</th>
                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                            <th>Total</th>
                            <th>Eliminar</th>
                        </tr>
                        <%                            int posc = 0;
                            double total = 0.0;
                            for (Compra cp : listaCarrito) {
                                total += cp.Total();
                        %>
                        <tr>
                            <td>
                                <img src="productos2/<%=cp.getCodProducto()%>.jpg" width="50" height="50">
                            </td>
                            <td><%=cp.getProducto()%></td>
                            <td>

                                <input type="number" id="cant<%=posc%>" value="<%=cp.getCantidad()%>" onchange="ActualizarCarrito(<%=posc%>, '<%=cp.getCodProducto()%>')" min="1">
                            </td>  
                            <td><%=cp.getPrecio()%></td>
                            <td><%=cp.Total()%></td>
                            <td>

                                <a href="ControlCarrito?accion=eliminar&posc=<%=posc%>" class="btn btn-danger" onclick="return confirm('¿Esta seguro que desea eliminar el producto?')">Eliminar</a>

                            </td>
                        </tr>

                        <%
                                posc++;
                            }

                            if (listaCarrito.size() == 0 || listaCarrito == null) {
                                sesionCarrito.setAttribute("comprando", "No");
                        %>
                        <tr>
                            <td style="text-align: center;" colspan="6">Carrito vacio</td>
                        </tr>
                                            </table>

                        <%
                        } else {

                            sesionCarrito.setAttribute("comprando", "Si");
                        %>
                        <tr>
                            <td colspan="4">Total a Pagar :</td>
                            <td colspan="2"><%=total%></td>
                        </tr>
                    </table>

                    <div class="col-9"></div>
                    <a  onclick="Verificar()" style="font-size: 1.3em; font-weight: bold; font-family: Arial;" class="btn btn-success col-2 text-white"> <!-- <i class="fas fa-coins mr-2"></i> -->Comprar</a>


                    <%
                        }
                    %>
                </div>
            </div>
        </section>

        <%@include file="Footer.jsp" %>


        <!-- Script de BOOTSTRAP-->

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>

        <!--
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        -->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
        <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>

        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet"/>

        <script type="text/javascript">

                        function ActualizarCarrito(posc, codeProd) {
                            var cantidad = $("#cant" + posc).val();

                            window.location.href = "ControlCarrito?accion=actualizar&tcan=" + cantidad + "&code=" + codeProd;
                        }


                        function GenerarCompra() {
                            var direccion = prompt("Ingrese direccion");

                            $.ajax({
                                type: 'POST',
                                url: "ControlCarrito",
                                data: {
                                    direccion: direccion,
                                    accion: "generarCompra"
                                },
                                success: function (data) {
                                    if (data.length >= 1 && data.length <= 5) {
                                        Swal.fire('Factura generada correctamente <br># Pedido : ' + data);

                                        setTimeout(function () {
                                            window.location.href = "index2.jsp";
                                        }, 1200);

                                    } else {
                                        ErrorMesj(data);
                                    }
                                }, error: function (jqXHR, textStatus, errorThrown) {
                                    ErrorMesj("Datos incorrectos...!!");
                                }
                            });

                        }

                        function ErrorMesj(msj) {
                            Swal.fire({
                                title: 'Error!',
                                text: msj,
                                icon: 'error',
                                confirmButtonText: 'Cool'
                            });
                        }

                        function PedirDatos() {

                        }

                        function Verificar() {

            <%
                if (ses.getAttribute("usuario") != null) {


            %>
                            window.location.href = "pConfirma1.jsp"
            <%            } else {
            %>
                            swal({
                                title: 'Debes iniciar sesion para la compra',
                                text: 'Si no tienes cuenta puedes registrate facilmente.',
                                type: 'warning',
                                allowOutsideClick: true,
                                closeOnConfirm: true
                            },
                                    function () {
                                        $("#modalRegistro").modal("show");
                                    });


            <%    }%>

                        }


        </script>
    </body>
</html>