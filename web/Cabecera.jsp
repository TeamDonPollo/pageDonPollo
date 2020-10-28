<%@page import="modelo.TipoProducto"%>
<%@page import="java.util.List"%>
<%@page import="dao.TipoProductoDAO"%>

<div style="background-color:black">
    <center>   <img src="image/Logo.png" width="260px" height="210px" id="borde"></center>
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
                    <a href="ControlProductos?opc=1&code=<%=t.getCodTipo() %>" class="nav-link">
                        <img src="image/<%=t.getImagenTipoProd()%>"><%=t.getNomTipo()%></a>
                </li>            
                <%
                    }
                %>
            </ul>

            <!-- registrar-->
            <form class="form-inline my-2 my-lg-0">
                <a href="pagRegistro.jsp">
                    <button class="btn btn-primary my-2 my-sm-0" type="submit">Registrarse</button>
                </a>
            </form>
        </div>

    </nav>
</header>