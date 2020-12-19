
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Pedido, dao.DaoPedido" %>
<script src="../src/java/dao/app.js" type="text/javascript"></script>

<html>
     <%@include file="Head.jsp" %>

    <body>
         <%@include file="Cabecera.jsp" %>
         <center> <h1>Historial de Compras</h1></center><br><br><h5><img src="fotos/pendientec.png">Pendiente
             <img src="fotos/check.png">Efectuado<img src="fotos/cancel.png">Cancelado</h5>
         <br><div class="container">
       <div class="abs-center">
            <table action="" class="table table-bordered table-striped table-hover">
            <tr>
                  <th>IDPedido</th>
                  <th>Monto Total</th>
                  <th>Medio de Pagosss</th>
                  <th>Fecha</th>
                  <th>Estado</th>
                  <th>Detalle</th>
                  <th>Eliminar</th>
             </tr> 
              <%
                  //List<DetallePedido> lisDP=null;
                  DaoPedido dap2=new DaoPedido();
                  List<Pedido> lisp=null;
                  List<DetallePedido> lisdp=null;
                  
                  
                 if(request.getAttribute("hPedidos")!=null){
                    lisp=(ArrayList<Pedido>)request.getAttribute("hPedidos");
                    lisdp =(ArrayList<DetallePedido>)request.getAttribute("hDetalles");
                  }
                  if(lisp==null || lisp.size()==0){ %>
                  <tr><td style="text-align: center;" colspan="7">No se encontraron pedidos</td></tr>
                      
                  <% 
                    }  else{
                        DaoPedido dap=new DaoPedido(); 
                      for (Pedido p:lisp) {
                            out.print("<tr><td>"+p.getIdPedido()+"<td>"+p.getTotal()+"<td>"+p.getFormp()+"<td>"+p.getFecha());
        if(p.getEstado().equals("Pendiente")){%>
         <td style="text-align: center;"><img src="fotos/pendientec.png"></td>
         <% } %>
         <%if(p.getEstado().equals("Efectuado")){%>
         <td style="text-align: center;"><img src="fotos/check.png"></td>
             <% }%>
         <%if(p.getEstado().equals("Cancelado")){%>
         <td style="text-align: center;"><img src="fotos/cancel.png"></td>
             <% }%>
                                     
         <td style="text-align: center;"><button data-toggle="modal" data-target="#a<%=p.getIdPedido()%>" onclick="actualizarModal(<%=p.getIdPedido()%>)"> <img src="fotos/mostrar.png"> </button> </td>
                       <td style="text-align: center;"><a href="ControlCliente?opc=3&cod=<%=p.getIdPedido()%>"><img src="fotos/eliminar.png"></a></td>
                    <%
                    
                    }
                                        }
                %>
            </table>
        </div>
    </div>
            
                <%
                    if(lisp==null || lisp.size()==0){ %>
                  <tr><td style="text-align: center;" colspan="7">No se encontraron pedidos</td></tr>
                      
                  <% 
                    }  else{
                        DaoPedido dap=new DaoPedido(); 
                      for (Pedido p:lisp) {
            
            %>
<div class="modal fade bd-example-modal-lg" id="a<%=p.getIdPedido()%>" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Detalle Pedido N°<%=p.getIdPedido()%></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <table action="" class="table table-bordered table-striped table-hover">
            <tr>
                  <th>Producto</th>
                  <th>Imagen</th>
                  <th>Cantidad</th>
                  <th>Precio Total</th>
            </tr> 
                
                     
                    <%
for (DetallePedido xdp:lisdp) {
      
    if (xdp.getCodigo().equalsIgnoreCase( p.getIdPedido())){
        
        double tot=xdp.getPrecio()*xdp.getCantidad();
        out.print("<tr><td>"+xdp.getNomprod()+"<td>");

%>     
                     
            <img src="productos2/<%=xdp.getIdproduc()%>.jpg" width="80" height="80"></td>
                            
                    <%
                        out.print("<td>"+xdp.getCantidad()+"<td>"+tot+"</tr>");
                        }
                        }
                    %>
      
      </table>
        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
                    <%
                                        }
                                        }
                %>
         
    </body>
    
              <script>

function actualizarModal(cod){
    //var code=cod;
   // var costo=<=dap2.lisDetPedido(cod)%>;
 
            console.log(cod);
            console.log("Hola");
}

</script>
</html>
