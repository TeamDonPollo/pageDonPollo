
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Consulta, dao.DaoConsulta" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>pruebaaaaa</title>
    </head>
    <body>
    <center><h1>Consultas de posibles clientes</h1></center>
        <br>
        <form>
            <table action="" class="table table-striped">
                <tr>
                    <th>N° cliente</th>
                    <th>Nombre y apellidos</th>
                    <th>Correo de contacto</th>
                    <th>Consulta</th>
                    <th>Anular</th>
                    
                </tr>
                <%
                    DaoConsulta obj = new DaoConsulta();
                    for (Consulta x: obj.listaConsultas()) {
                            out.print("<tr><td>"+x.getIdcon()+"<td>"+x.getNom()+"<td>"+x.getCorreo()+"<td>"+x.getCons()+"<td>");
                    %>
                    <a href="servlet?opc=2&cod=<%=x.getIdcon()%>"><button class="btn btn-toolbar">Eliminar</a>
                    <%
                    }
                    
                %>
            </table>
        </form>
    </body>
</html>
