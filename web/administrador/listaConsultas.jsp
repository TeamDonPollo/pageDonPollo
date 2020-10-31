
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Consulta, dao.*" %>

<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <%@include file="cabAdmi2.jsp" %>
       
        
    <center><h1>Consultas de posibles clientes</h1></center>
        <br>
        
            <div class="container">
        <div class="abs-center">
            <table action="" class="table table-striped">
                <tr>
                    <th>N° cliente</th>
                    <th>Nombre y apellidos</th>
                    <th>Correo de contacto</th>
                    <th>Consulta</th>
                    <th>Anular</th>
                    
                </tr>
                <%
                    DaoConsulta obj2 = new DaoConsulta();
                    for (Consulta x: obj2.listaConsultas()) {
                            out.print("<tr><td>"+x.getIdcon()+"<td>"+x.getNom()+"<td>"+x.getCorreo()+"<td>"+x.getCons()+"<td>");
                    %>
                    <a href="ControlConsulta?opc=2&cod=<%=x.getIdcon()%>"><button class="btn btn-danger">Eliminar</button></a>
                    <%
                    }
                    
                %>
            </table>
        </div></div>
        
    </body>
</html>
