
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.*,modelo2.*,java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Cab2.jsp" %>
    </head>
    <body>
         <%
            Negocio2 ng=new Negocio2();
            String codP=(String)request.getAttribute("cod");
            TipoProducto tp=(TipoProducto)ng.busTip(codP);
            String nomTP=tp.getNomTipo();
             
            %>
          <div style="background-color:black">
            <center>   <img src="image/Logo.png" width="260px" height="210px" id="borde"></center>
        </div>
    <center><br><h2><img src="image/<%=tp.getImagenTipoProd()%>"> Nuevo producto para <%=nomTP%> <img src="image/<%=tp.getImagenTipoProd()%>"></h2></center><br><br>
    <form action="admi2" method="POST" enctype="multipart/form-data"> 
    <div class="container">
        <div class="abs-center">
    <table class="table table-bordered" >
        <tr><th>Código<td>  <input class="form-control" type="text" value="<%=ng.generaCod()%>" readonly>
        <tr><th>Nombre<td>  <input class="form-control" type="text" name="nombre" value="" >
        <tr><th>Descripción<td>  <input class="form-control" type="text" name="descripcion" value="" >
        <tr><th>Precio (s/.)<td><input class="form-control" type="text" name="precio" value="" >
        <tr><th>Stock<td><input class="form-control" type="text" name="stock" value="" >
        <tr><th>Descuento<td>  <input class="form-control" type="text" name="dscto" value="">
        <tr><th>Imagen<td>  <input type="file" name="fileFoto" value="">     
    </table>
       <input type="hidden" name="opc" value="6">
        <input type="hidden" name="code" value="<%=codP%>">
        <input type="hidden" name="nom" value="<%=nomTP%>">
        <center><img src="image/btnGuardar.png">
            <input type="submit" class="btn btn-info" name="accion" value="Guardar"></center>
        </div></div></form>
    </body>S
</html>
