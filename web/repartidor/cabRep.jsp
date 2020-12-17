<!DOCTYPE html>
<html>
    <head>
       <title>DON POLLO</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <!-- CSS BOOTSTRAP-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <link rel="stylesheet" href=".fonts.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- MDBootstrap -->

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link href="css/styleRegistro.css" rel="stylesheet" type="text/css"/>

        <!-- Script de BOOTSTRAP-->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </head>
    <%@page import="modelo.*"%>
    <%@page import="java.util.List"%>
    <%@page import="dao.*"%>   
    <body>

        <%
          HttpSession ses = request.getSession();
          String nombreUsuario = "";String  codRep ="NULO";
          if(ses.getAttribute("idRep")!=null){
            codRep = ses.getAttribute("idRep").toString();  
          }
                    
        %>

        <div class="row" style="background-color:black">
            <div class="col-3"></div>
            <div class="col-6">
                <center>   <img src="image/Logo.png" width="260px" height="210px" id="borde"></center>
            </div>
            <div class="col-3" style="position:relative"> 
                <%  if (ses.getAttribute("usuario") != null) {
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
    <center>
    <header>
        <nav class="navbar navbar-expand-lg navbar-nav bg-white" id="menu">

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-" >
                   <li class="nav-item">
                        <a href="admi?opc=1" class="nav-link">
                            <img src="fotos/hours.png"> Pendientes</a>
                    </li>
                    <li class="nav-item">
                        <a href="admi?opc=5" class="nav-link">
                            <img src="fotos/history.png">Historial</a>
                    </li> 
                   </ul>
            </div>

        </nav>
    </header></center>
</body>
</html>