<%-- 
    Document   : testeo
    Created on : 29/10/2020, 11:59:12 PM
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
       <%@include file="cabAdmi2.jsp" %>
        <%
            HttpSession rs=request.getSession();
            Producto prod=(Producto)request.getAttribute("prodd");
            %>
          
    <center>
        <h1>IdProd: <%=prod.getIdprod()%></h1>
        <h1>Nombre: <%=prod.getNom()%></h1>
    
        <h1>Stock: <%=prod.getStock()%></h1>
        <h1>Descuento: <%=prod.getDscto()%></h1>
    </center>
            
    </body>
</html>
