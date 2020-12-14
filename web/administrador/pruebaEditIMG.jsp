

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.*,modelo2.*,java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="cabecera.jsp" %>
    </head>
    <body>
         <%
            DaoProducto ng=new DaoProducto(); HttpSession ses=request.getSession();
            String codP=(String)request.getAttribute("cod");
            Producto p=(Producto)ses.getAttribute("objProd");
            String codT=p.getCodtip();
            TipoProducto tp=(TipoProducto)ng.busTip(codT);
            String nomT=tp.getNomTipo();
            %>
             <div style="background-color:black">
            <center>   <img src="image/Logo.png" width="260px" height="210px" id="borde"></center>
             </div><br>
    <center><h1>Producto: <%=p.getNom()%></h1><br>
        <h3><img src="productos2/<%=p.getIdprod()%>.jpg" width="230" height="270" class="img-rounded" ></h3></center><br>
    <form action="admi2" method="POST" enctype="multipart/form-data"> 
    <div class="container">
        <div class="abs-center">
    <table class="table table-bordered" >
        <tr><th>Código<td>  <input class="form-control" type="text" name="idp" value="<%=p.getIdprod()%>" readonly>
        <tr><th>Nombre<td>  <input class="form-control" type="text" name="nombre" value="<%=p.getNom()%>" >
        <tr><th>Descripción<td>  <input class="form-control" type="text" name="descripcion" value="<%=p.getDescrip()%>" >
        <tr><th>Precio (s/.)<td><input class="form-control" type="text" name="precio" value="<%=p.getPrecio()%>" >
        <tr><th>Stock<td><input class="form-control" type="text" name="stock" value="<%=p.getStock()%>" >
        <tr><th>Descuento<td>  <input class="form-control" type="text" name="dscto" value="<%=p.getDscto()%>">
        <tr><th>Nueva Imagen<td>  <input type="file" name="fileFoto" value=""> 
    </table>
        <input type="hidden" name="opc" value="5">
        <input type="hidden" name="code" value="<%=codT%>">
        <input type="hidden" name="nom" value="<%=nomT%>">
        <center><img src="image/btnGuardar.png">
            <input type="submit" class="btn btn-info" name="accion" value="Guardar"></center>
        </div></div></form>
        <br><br><br>
        
        
    </body>
</html>
