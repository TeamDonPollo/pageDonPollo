<%-- 
    Document   : mGuar
    Created on : 25/10/2020, 08:13:58 PM
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,dao.*,modelo2.*,modelo.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GUARNICIONES</title>
    </head>
    <body>
         <%@include file="cabAdmi2.jsp" %>
    <%
            List<Producto> lis=(ArrayList<Producto>)request.getAttribute("dato");
            /*HttpSession ses=request.getSession();
            List<Producto> lis=(ArrayList<Producto>)ses.getAttribute("datom");*/
            
            %>
         
    <center><h1>Gestión de Guarniciones</h1><br>
         <a href="admi/prueba.jsp"><h5><img src="fotos/add.png" width="30" height="20">Añadir producto nuevo</h5></a></center>
    <table class="table table-hover" >
        <tr><th>Código<th>Nombre<th>Descripción<th>Precio<th>Stock<th>Descuento
             <%
                for(Producto a:lis){
                     out.print("<tr><td>"+a.getIdprod()+"<td>"+a.getNom()+"<td>"+
                             a.getDescrip()+"<td>"+a.getPrecio()+"<td>"+a.getStock()+"<td>"+a.getDscto());
                  %>   
                 
                 <th><a><button type="button" class="btn btn-danger">Eliminar</button></a>
                 <th><a><button type="button" class="btn btn-success">Editar</button></a>     
                      <%
                            }     
                     %>
    </body>
</html>
