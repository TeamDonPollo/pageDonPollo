<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Especial, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <%
            List<Especial> lis=(ArrayList)request.getAttribute("dato");
        %>
        <h2>Lista de ESpecialidades</h2>
        <table class="table table-striped">
            <tr><th>Codigo<th>Nombre<th>ver Alumno
             <%
                 for(Especial x:lis){
                     out.print("<tr><td>"+x.getCode()+"<td>"+x.getNomesp()+"<td>");
                %>
                <a href="controla1?opc=2&id=<%=x.getCode()%>">Alumnos</a>
                <%
                 }
              %>
        </table>
        
    </center>
    </body>
</html>
