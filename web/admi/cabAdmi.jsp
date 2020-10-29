<!DOCTYPE html>
<html>
    <head>
        <%@page import="modelo.TipoProducto"%>
        <%@page import="java.util.List"%>
        <%@page import="dao.TipoProductoDAO"%>
        <%@include file="Cab1.jsp" %>
    </head>

    <body>
        <div style="background-color:black">
            <center>   <img src="../image/Logo.png" width="260px" height="210px" id="borde"></center>
        </div>
        
        <br>
    <center> <h1>MANTENIMIENTO</h1></center>

        <!-- BARRA DE NAVEGACION-->
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
                    <a href="../admi2?opc=1&code=<%=t.getCodTipo() %>&nom=<%=t.getNomTipo()%>" class="nav-link">
                        
                        <img src="../image/<%=t.getImagenTipoProd()%>"><%=t.getNomTipo()%></a>
                </li>            
                <%
                    }
                %>
                    </ul>

                </div>

            </nav>
        </header>
        
    </body>
</html>