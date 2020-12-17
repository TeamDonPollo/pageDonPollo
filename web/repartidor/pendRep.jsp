
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DON POLLO</title>
    </head>
    <body>
        <%@include file="cabRep.jsp" %>
        
    <center><h1>LISTA DE PEDIDOS PENDIENTES</h1></center><br><br><h5><img src="fotos/check.png">Efectuado<img src="fotos/cancel.png">Cancelado</h5>
    <br><div class="container">
       <div class="abs-center">
            <table action="" class="table table-bordered table-striped table-hover">
            <tr>
                  <th>IDPedido</th>
                  <th>Receptor</th>
                  <th style="text-align: center;">Fecha Pedido</th>
                  <th>Total</th>
                  <th style="text-align: center;">Dirección</th>
                  <th style="text-align: center;">Referencia</th>
                  <th>Celular</th>
                  <th>Detalle</th>
                  <th style="text-align: center;">Actualizar Estado</th>
             </tr> 
             <%
                 DaoRepartidor daor=new DaoRepartidor(); List<Pedido> listped=null;
                 listped=daor.lisPedidosP(codRep);
                 if(listped.size()==0 || listped==null){%>
                 <tr><td style="text-align: center;" colspan="9">No se encontraron pedidos pendientes</td></tr>
                <% }
                 else{
                 for(Pedido r:daor.lisPedidosP(codRep)){
                     out.print("<tr><td>"+r.getIdPedido()+"<td>"+r.getRecp()+"<td>"+r.getFecha()+
                             "<td>"+r.getTotal()+"<td>"+r.getDistrito()+"<td>"+r.getRef()+
                             "<td>"+r.getCel());%>
                
                 <td><img src="fotos/mostrar.png" data-toggle="modal" data-target=".bd-example-modal-lg">
                 <td style="text-align: center;"><a href="admi?opc=8&idp=<%=r.getIdPedido()%>&est=Efectuado">
                         <img src="fotos/check.png" ></a><a href="admi?opc=8&idp=<%=r.getIdPedido()%>&est=Cancelado" ><img src="fotos/cancel.png"></a></td>      
                     <%             }}
                 %>
            </table>
       </div>
        </div>
    </body>
</html>
