<%@page import="modelo.TipoProducto"%>
<%@page import="java.util.List"%>
<%@page import="dao.TipoProductoDAO"%>
<<<<<<< HEAD
=======
<<<<<<< HEAD
<%@page import="java.util.*"%>
<%@page import="modelo.*"%>

<%
    HttpSession ses = request.getSession();
    String nombreUsuario = "";
    Integer sizeProducts = (Integer) ses.getAttribute("sizeProducts");
    String totalMount = (String) ses.getAttribute("totalMount");
    sizeProducts = sizeProducts == null ? 0 : sizeProducts;
    totalMount = totalMount == null ? "0.0" : totalMount;
%>
<style>
    .sidebar {
        position: fixed;
        left:-320px;
        width:320px;
        height:100%;
        background:#f1f1f1;
        transition: all .5s ease;
        z-index: 100;
    }
    .sidebar__text{
        font-size: 24px; 
        color:#c50a25; 
        text-align: center;
        line-height: 70px;
        user-select:none;
        font-weight: 600;
        display:block;
      
    }
    .sidebar__text:hover{
        text-decoration: none;
        color:black;
    }
    .sidebar__a{
        display:block;
        height:100%;
        width:100%;
        line-height: 80px;
        font-size: 20px;
        color: #c50a25;
        padding-left: 60px;
        box-sizing: border-box;
        transition:.4s;
        font-weight:500;
    }
    .sidebar .sidebar__li:hover .sidebar__a{
        padding-left:50px;
        text-decoration: none;
    }
    #check{
        display: none !important;
    }
    label{
        display:initial;
    }
    label #btn,label #cancel{
        position:absolute;
        cursor:pointer;
        background:#042331;
        border-radius: 3px;
    }
    label #btn{
        left:40px;
        top:25px;
        font-size:35px;
        color:white;
        padding:6px 12px;
        transition:all .5s ;
    }
    label #cancel{
        z-index:200;
        left:-260px;
        top:17px;
        font-size:30px;
        color:white;
        padding:4px 8px;
        transition:all .5s ease ;
        position:fixed;
    }
    #check:checked ~ .sidebar {
        left:0
    }
    #check:checked ~ label #btn {
        left:320px;
        opacity: 0;
        pointer-events:none;
    }
     #check:checked ~ label #cancel {
        left:260px;
    }
</style>
     <div style="height: 100px; width: 100%; display:flex; justify-content: space-between;">     
            <input type="checkbox" id="check"/>
            <label for="check">
                <i class="fas fa-bars" id="btn"></i>
                <i class="fas fa-times" id="cancel"></i>
            </label>
     
            <div class="sidebar">   
                <ul style="list-style: none; text-decoration: none;">
                    <!--<div>-->
                        <a class="sidebar__text" href="index2.jsp"> Don Pollo</a>
                        <center><img src="image/Logo.png"  width="120px" height="80px" class="mb-4 mt-4" /></center>
                    <!--</div>-->
                    <li class="sidebar__li">
                        <a class="sidebar__a" href="contactenos.jsp"><img src="image/Contactanos.svg" class="mr-4"/>Contactenos</a>
                    </li>    
                    <li class="sidebar__li">
                        <a class="sidebar__a" href="ControlLocations"><img src="image/Locales.svg" class="mr-4"/>Sedes</a>
                    </li>
                </ul>
            </div>
            <!--<img src="image/Logo.png"  width="80px" height="80px"/>-->
            <a  href="contactenos.jsp" style="margin-right: 80px; margin-bottom: auto; margin-top: auto; font-size: 20px; font-weight: 500; color: #c50a25;">Contactenos</a>
        </div>
=======
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23


<%
    HttpSession ses = request.getSession();

    String nombreUsuario = "";

%>


<<<<<<< HEAD
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
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
<<<<<<< HEAD
            <a href="ControlCarrito?accion=miCarrito" class="btn btn-primary my-2 my-sm-0" title="Mi Carrito"><i class="fas fa-shopping-cart"></i></a>&nbsp;
=======
<<<<<<< HEAD
            <a href="ControlCarrito?accion=miCarrito" class="btn btn-danger my-2 my-sm-0" title="Mi Carrito"><i class="fas fa-shopping-cart" style="margin-right: 5px;"></i><span style="margin-right: 5px;" class="badge badge-light" id="sizeBadge"><%=sizeProducts%></span><span class="badge badge-light" id="sizeBadge"><%=totalMount%></span></a>&nbsp;
=======
            <a href="ControlCarrito?accion=miCarrito" class="btn btn-primary my-2 my-sm-0" title="Mi Carrito"><i class="fas fa-shopping-cart"></i></a>&nbsp;
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
            <!-- registrar-->
            <!--<form class="form-inline my-2 my-lg-0">--> <!--No agregar como formulario el modal es el que redirecciona-->
            <%
                if (ses.getAttribute("usuario") != null) {

                    nombreUsuario = (String) ses.getAttribute("usuario");
            %>
<<<<<<< HEAD
=======
<<<<<<< HEAD
            <a class="btn btn-outline-secondary my-2 my-sm-0" href="ControlRegistro?opc=3" >Salir</a>
            <%
            } else {
            %>
            <button class="btn btn-outline-secondary my-2 my-sm-0" data-toggle="modal" data-target="#modalRegistro">Registrarse</button>
=======
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
            <a class="btn btn-primary my-2 my-sm-0" href="ControlRegistro?opc=3" >Salir</a>
            <%
            } else {
            %>
            <button class="btn btn-primary my-2 my-sm-0" data-toggle="modal" data-target="#modalRegistro">Registrarse</button>
<<<<<<< HEAD
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
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