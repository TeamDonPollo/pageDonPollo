<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Alumno, java.util.*" %>
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
            List<Alumno> lis=(ArrayList)request.getAttribute("dato");
        %>
        <h2>Lista de Alumnos </h2>
        <table class="table table-striped">
            <tr><th>Codigo<th>Nombre<th>Apellido<th>Pagos<th>Notas<th>foto
             <%
                 for(Alumno x:lis){
                     out.print("<tr><td>"+x.getCoda()+"<td>"+x.getNoma()+"<td>"+x.getApe()+"<td>");
                %>
                <a href="controla1?opc=3&id=<%=x.getCoda()%>">Pagos</a>
                <td><a href="controla1?opc=4&id=<%=x.getCoda()%>">Notas</a>
                <td><img src="fotos/<%=x.getCoda()%>.jpg" width="90" height="90" 
                         onerror="src='fotos/sin_foto.jpg' "  class="img-circle">
                <%
                 }
              %>
        </table>
        
    </center>
    </body>
</html>
