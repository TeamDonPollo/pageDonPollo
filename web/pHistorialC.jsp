
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Pedido, dao.DaoPedido" %>
<script src="js/app.js" type="text/javascript"></script>

<html>
     <%@include file="Head.jsp" %>

    <body>
         <%@include file="Cabecera.jsp" %>
         <center> <h1>Historial de Compras</h1></center>
    <div class="container">
       <div class="abs-center">
            <table action="" class="table table-bordered table-striped table-hover">
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
                  List<DetallePedido> lisDP=null;
                  List<Pedido> lisp=null;
                  if(request.getAttribute("hPedidos")!=null){
                    lisp=(ArrayList<Pedido>)request.getAttribute("hPedidos");  
                  }
                  if(lisp==null || lisp.size()==0){ %>
                  <tr><td style="text-align: center;" colspan="7">No se encontraron pedidos</td></tr>
                      
                  <% 
                    }  else{
                        DaoPedido dap=new DaoPedido(); 
                      for (Pedido p:lisp) {
                            out.print("<tr><td>"+p.getIdPedido()+"<td>"+p.getTotal()+"<td>"+p.getFormp()+"<td>"+p.getFecha()+"<td>"+
                                        p.getEstado()+"<td>"); %>
                       <img src="fotos/mostrar.png" data-toggle="modal" data-target=".bd-example-modal-lg" onclick="<%=lisDP=(ArrayList<DetallePedido>)dap.lisDetPedido(p.getIdPedido())%>">  
                       <td><a href="ControlCliente?opc=3&cod=<%=p.getIdPedido()%>"><img src="fotos/eliminar.png"></a></td>
                    <%
                    }
                    }
                %>
            </table>
        </div>
    </div>
<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">PedidoXD</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <table action="" class="table table-bordered table-striped table-hover">
            <tr>
                  <th>IDPedido</th>
                  <th>Producto</th>
                  <th>Imagen</th>
                  <th>Cantidad</th>
                  <th>Precio</th>
            </tr> 
                <%for (DetallePedido xp:lisDP) {
                    out.print("<tr><td>"+xp.getCodigo()+"<td>"+xp.getIdproduc()+"<td>"); %>
               <img src="productos2/<%=xp.getCodigo()%>.jpg" width="50" height="50"></td>
                            
                    <%
                     out.print("<td>"+xp.getCantidad()+"<td>"+xp.getPrecio()+"");
                                        } %>
      
      </table>
        <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
          
         
    </body>
</html>
