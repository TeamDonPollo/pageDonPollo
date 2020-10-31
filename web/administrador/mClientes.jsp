

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo2.Cliente, dao.*" %>

<!DOCTYPE html>
<html>
    <head>
        
        <title>CLIENTES</title>
    </head>
    <body>
        <%@include file="cabAdmi2.jsp" %>
    <center> <h1>Listado de Clientes</h1></center>
   
            <div class="container">
        <div class="abs-center">
            <table action="" class="table table-striped">
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Tipo docuemnto</th>
                    <th>Documento</th>
                    <th>Sexo</th>
                    <th>Correo</th>
                    <th>Fecha</th>
                    <th>Contraseña</th>
                    <th>Eliminar</th>
                    
                </tr>
                <%
                    DaoCliente obj2 = new DaoCliente();
                    for (Cliente x: obj2.listaClientes()) {
                            out.print("<tr><td>"+x.getCodigo()+"<td>"+x.getNombre()+"<td>"+x.getApellido()+"<td>"+x.getTipoDoc()
                                    +"<td>"+x.getNroDoc()+"<td>"+x.getSexo()+"<td>"+x.getCorreo()+"<td>"+x.getFecha()+"<td>"+
                                    x.getPassword()+"<td>");
                    %>
                    <a href="ControlCliente?opc=2&cod=<%=x.getCodigo()%>"><button class="btn btn-danger">Eliminar</button></a>
                    <%
                    }
                    
                %>
            </table>
        </div></div>
        
    </body>
</html>
