
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Pedido, dao.DaoPedido" %>

<html>
     <%@include file="Head.jsp" %>

    <body>
         <%@include file="Cabecera.jsp" %>
         <center> <h1>Historial de Compras</h1></center>
         <div class="container">
        <div class="abs-center">
            <table action="" class="table table-striped">
            <tr>
                  <th>IDPedido</th>
                  <th>Monto Total</th>
                  <th>Medio de Pago</th>
                  <th>Fecha</th>
                  <th>Estado</th>
                  <th>Detalle</th>
                  <th>Eliminar</th>
             </tr> 
              <%
                  List<Pedido> lisp=null;
                  if(request.getAttribute("hPedidos")!=null){
                    lisp=(ArrayList<Pedido>)request.getAttribute("hPedidos");  
                  }
                  if(lisp==null){ %>
                  <tr><td colspan="6">No se encontraron pedidos</td>
                      
                  <% 
                    }  else{
                      for (Pedido p:lisp) {
                            out.print("<tr><td>"+p.getIdPedido()+"<td>"+p.getTotal()+"<td>"+p.getFormp()+"<td>"+p.getFecha()+"<td>"+
                                        p.getEstado()+"<td>");
                    %>
                  <a><img src="fotos/mostrar.png"></a>  
                  <td><a href="ControlCliente?opc=3&cod=<%=p.getIdPedido()%>"><img src="fotos/eliminar.png"></a></td>
                    <%
                    }
                    }
                %>
            </table></div></div>
    </body>
</html>
