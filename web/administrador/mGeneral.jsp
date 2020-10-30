


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.*,modelo2.*,java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="cabAdmi2.jsp" %>
        <%
            List<Producto> lis=(ArrayList<Producto>)request.getAttribute("dato");
            String codp=(String)request.getAttribute("codProd");
            String tipon=(String)request.getAttribute("tipo");
            %>
         
    <center><h1>Gestión de <%=tipon%></h1><br>
        <a href="admi2?opc=2&id=<%=codp%>"><h5>
        <img src="fotos/add.png" width="30" height="20">Añadir producto nuevo</h5></a></center>
    <div class="container">
        <div class="abs-center">
     <table class="table table-hover" >
         <tr><th>Código</th><th>Nombre</th><th>Descripción</th><th>Precio</th><th>Stock</th><th>Descuento</th>
             <th colspan="2"><center>Acciones</center></th>
             <%
                for(Producto a:lis){
                     out.print("<tr><td>"+a.getIdprod()+"<td>"+a.getNom()+"<td>"+
                             a.getDescrip()+"<td>"+a.getPrecio()+"<td>"+a.getStock()+"<td>"+a.getDscto());
                  %>   
                 
                 <th><a><button type="button" class="btn btn-danger">Eliminar</button></a>
                 <th><a href="admi2?opc=4&id=<%=a.getIdprod()%>"><button type="button" class="btn btn-success">Editar</button></a>     
                      <%
                            }     
                     %>
     </table></div></div>
    </body>
</html>
