<!DOCTYPE html>
<html>
    <head>
        <%@include file="cabecera.jsp" %>
    </head>
    <%@page import="modelo.TipoProducto"%>
    <%@page import="java.util.List"%>
    <%@page import="dao.TipoProductoDAO"%>   
    <body>

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
                    <i class="fas fa-user"></i> Bienvenido, <%=nombreUsuario%> 
                    <a  class="btn btn-primary my-2 my-sm-0" href="ControlRegistro?opc=3" ><i class="fas fa-sign-in-alt ml-1"></i></a>
                </span>
                    <%}%>            
            </div>
        </div>

        <br>
    <center> <h1>MANTENIMIENTO</h1></center>

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
                        <a href="admi2?opc=1&code=<%=t.getCodTipo()%>&nom=<%=t.getNomTipo()%>" class="nav-link">

                            <img src="image/<%=t.getImagenTipoProd()%>"><%=t.getNomTipo()%></a>
                    </li>            
                    <%
                        }
                    %>

                    <li class="nav-item">
                        <a href="admi?opc=2" class="nav-link">
                            <img src="fotos/userf.png"> Clientes</a>
                    </li>

                    <li class="nav-item">
                        <a href="admi?opc=3" class="nav-link">
                            <img src="fotos/buzon.png">Quejas</a>
                    </li> 
                    <li class="nav-item">
                        <a href="admi?opc=4" class="nav-link">
                            <img src="fotos/grafica.png">Graficas</a>
                    </li> 

                </ul>
            </div>

        </nav>
    </header>
</body>
</html>