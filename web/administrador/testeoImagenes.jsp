<%-- 
    Document   : test2
    Created on : 30/10/2020, 10:24:52 AM
    Author     : chris
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.*,java.util.*,modelo2.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpServletResponse responsem;
            DaoProducto ng=new DaoProducto();
            List<Producto> lis=ng.lisProd("T001");
            %>
           <center>
               <table border="1">
                   <% for(Producto p:lis){
                       %>
                    <tr><th>Codigo Producto<td><%=p.getIdprod()%>
                    <tr><th>Imagen<td><img src="/ControIMG?idt=<%=p.getIdprod()%>"
                                           width="200" height="250"
                                           onerror="src='../fotos/sin_foto.jpg'">        
                       
                       <%
                   }
                   %>
                   
               </table>
            
            
    </center>
    </body>
</html>
