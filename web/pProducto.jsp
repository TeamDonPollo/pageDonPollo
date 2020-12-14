<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Producto"%>
<!DOCTYPE html>
<html>
    <%@include file="Head.jsp" %>

    <body>
        <%
            List<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");
        %>


        <%@include file="Cabecera.jsp" %>

        <section>
            <div class="container">
                <div class="row">


                    <%                    for (Producto p : productos) {
                    %>
                    <div class="col-md-4 mt-3">
                        <div class="card" style="width: 22rem;">
                            <img class="card-img-top" src="productos2/<%=p.getCodProducto()%>.jpg" width="50" height="260">
<<<<<<< HEAD
=======
<<<<<<< HEAD
                             <div class="card-header">
                                <p style="font-size: 18px; font-weight: 700; margin: auto; text-align: center"><%=p.getProducto()%></p>
                            </div>
                            <div class="card-body d-flex align-items-center justify-content-between">
                                <p style="font-weight: 600; font-size: 16px; margin: auto">
                                  Precio S/. <%=p.getPrecio()%>  
                                </p>
                                <a href="ControlCarrito?accion=agregar&code=<%=p.getCodProducto() %>&tcan=1" class="btn btn-dark rounded-pill">Comprar <i class="fas fa-shopping-cart ml-1"></i>  </a>
                            </div>
=======
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
                            <div class="card-header">
                                <p style="font-size: 14px;"><%=p.getProducto()%></p>
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Precio S/. <%=p.getPrecio()%></li>
                                <li class="list-group-item">
                                    <a href="ControlCarrito?accion=agregar&code=<%=p.getCodProducto() %>&tcan=1" class="btn btn-primary">Comprar</a>
                                </li>
                            </ul>
<<<<<<< HEAD
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
                        </div>
                    </div>

                    <%
                        }
                    %>
                </div>
            </div>
        </section>

        <%@include file="Footer.jsp" %>


        <!-- Script de BOOTSTRAP-->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>