<%@page import="java.util.*"%>
<%@page import="modelo.*"%>
<!DOCTYPE html>
<html>
    <%@include file="Head.jsp" %>

    <body>
        <%
            HttpSession sesionCarrito = request.getSession();
            ArrayList<Compra> listaCarrito = (ArrayList<Compra>) sesionCarrito.getAttribute("canasta");
        %>


        <%@include file="Cabecera.jsp" %>

        <section>
            <div class="container">
<<<<<<< HEAD
=======
<<<<<<< HEAD
                <%                    String codCliente = "" , nombreLogeado = "";
                    if (sesionCarrito.getAttribute("idCliente") != null) {
                        codCliente = sesionCarrito.getAttribute("idCliente").toString();
                %>
                <h4>Cliente : <%=sesionCarrito.getAttribute("nombreLogeado").toString() %></h4>
                <a href="javascript:GenerarCompra()" class="btn btn-success">Aceptar Compra</a>
                <%
                    }
                %>

=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
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
<<<<<<< HEAD
                                <a href="ControlCarrito?accion=eliminar&posc=<%=posc%>" class="btn btn-danger" onclick="return confirm('¿Esta seguro que desea eliminar el producto?')">Eliminar</a>
=======
<<<<<<< HEAD
                                <a href="ControlCarrito?accion=eliminar&posc=<%=posc%>" class="btn btn-danger" onclick="return confirm('ï¿½Esta seguro que desea eliminar el producto?')">Eliminar</a>
=======
                                <a href="ControlCarrito?accion=eliminar&posc=<%=posc%>" class="btn btn-danger" onclick="return confirm('¿Esta seguro que desea eliminar el producto?')">Eliminar</a>
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
                            </td>
                        </tr>

                        <%
                                posc++;
                            }

                            if (listaCarrito.size() == 0 || listaCarrito == null) {
                        %>
                        <tr>
                            <td style="text-align: center;" colspan="6">Carrito vacio</td>
                        </tr>
                        <%
                        } else {
                        %>
                        <tr>
                            <td colspan="4">Total a Pagar :</td>
                            <td colspan="2"><%=total%></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>
        </section>

        <%@include file="Footer.jsp" %>


        <!-- Script de BOOTSTRAP-->
<<<<<<< HEAD
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
=======
<<<<<<< HEAD
        <!--
          <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
       
        -->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
        <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
=======
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

        <script type="text/javascript">
<<<<<<< HEAD
=======
<<<<<<< HEAD
            
                                    
            
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
                                    function ActualizarCarrito(posc, codeProd) {
                                        var cantidad = $("#cant" + posc).val();

                                        window.location.href = "ControlCarrito?accion=actualizar&tcan=" + cantidad + "&code=" + codeProd;
                                    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
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
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
        </script>
    </body>
</html>