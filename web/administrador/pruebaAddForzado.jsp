<%-- 
    Document   : test3
    Created on : 30/10/2020, 11:46:27 AM
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.*,modelo2.*,java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            DaoProducto ng=new DaoProducto();
            //String codP=(String)request.getAttribute("cod");
           // TipoProducto tp=(TipoProducto)ng.busTip(codP);
           // String nomTP=tp.getNomTipo();
             
            %>
            <div><center>
            <h3>Agregar nuevo producto</h3>
        </div><hr><br>
        <form action="../admi" method="POST" enctype="multipart/form-data">
            <table border='1' style="align-content: center">
            <tr><th>Código<td>  <input  type="text" name="codpp" value="<%=ng.generaCod()%>">
            <tr><th>Tipo Producto<td>  <input  type="text" name="tipo" value="" >        
        <tr><th>Nombre<td>  <input type="text" name="nombre" value="" >
        <tr><th>Descripción<td>  <input  type="text" name="descripcion" value="" >
        <tr><th>Precio (s/.)<td><input type="text" name="precio" value="" >
        <tr><th>Stock<td><input  type="text" name="stock" value="" >
        <tr><th>Descuento<td>  <input  type="text" name="dscto" value="">
        <tr><th>Imagen<td>  <input type="file" name="fileFoto" value=""> 
                </table>
        <center><img src="../image/btnGuardar.png">
            <input type="submit" class="btn btn-info" name="accion" value="Guardar"></center>
        </form></center>
    </body>
</html>
