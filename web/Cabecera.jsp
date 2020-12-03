<%@page import="modelo.TipoProducto"%>
<%@page import="java.util.List"%>
<%@page import="dao.TipoProductoDAO"%>


<%
    HttpSession ses = request.getSession();

    String nombreUsuario = "";

%>


    <div class="row" style="background-color:black">
        <div class="col-3"></div>
        <div class="col-6">
            <center>   <img src="image/Logo.png" width="260px" height="210px" id="borde"></center>
        </div>
        <div class="col-3" style="position:relative"> 
            <%                if (ses.getAttribute("usuario") != null) {

                    nombreUsuario = (String) ses.getAttribute("usuario");
            %>    
            <span style="position:absolute; bottom:0; margin-bottom:20px; padding: 15px; background: white; ">
                <i class="fas fa-user"></i> Bienvenido, <%=nombreUsuario%></span>
                <%}%>            
        </div>
    </div>


<header>
    <nav class="navbar navbar-expand-lg navbar-nav bg-white" id="menu">

        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-" >

                <%
                    TipoProductoDAO obj = new TipoProductoDAO();
                    List<TipoProducto> lista = obj.ListaTipoProductos();

                    for (TipoProducto t : lista) {
                %>
                <li class="nav-item active">
                    <a href="admi?opc=6&code=<%=t.getCodTipo()%>" class="nav-link">
                        <img src="image/<%=t.getImagenTipoProd()%>"><%=t.getNomTipo()%></a>
                </li>            
                <%
                    }
                %>
            </ul>
            <a href="ControlCarrito?accion=miCarrito" class="btn btn-primary my-2 my-sm-0" title="Mi Carrito"><i class="fas fa-shopping-cart"></i></a>&nbsp;
            <!-- registrar-->
            <!--<form class="form-inline my-2 my-lg-0">--> <!--No agregar como formulario el modal es el que redirecciona-->
            <%
                if (ses.getAttribute("usuario") != null) {

                    nombreUsuario = (String) ses.getAttribute("usuario");
            %>
            <a class="btn btn-primary my-2 my-sm-0" href="ControlRegistro?opc=3" >Salir</a>
            <%
            } else {
            %>
            <button class="btn btn-primary my-2 my-sm-0" data-toggle="modal" data-target="#modalRegistro">Registrarse</button>
            <%    }

                String login = (String) ses.getAttribute("login");

                if (login != null) {
            %>
            <script>
                alert("Sus datos han sido incorrectos al logearse");
            </script>
            <%
                    ses.setAttribute("login", null);
                }
            %>
            <!--</form>-->
        </div>

    </nav>
</header>