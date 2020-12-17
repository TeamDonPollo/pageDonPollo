
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DON POLLO</title>
    </head>
    <body>
       <%@include file="cabRep.jsp" %>
       <center><h1>HISTORIAL DE PEDIDOS</h1></center><br><br><h5><img src="fotos/check.png">Efectuado<img src="fotos/cancel.png">Cancelado</h5>
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
                  <th style="text-align: center;">Estado</th>
             </tr> 
             <%
                 DaoRepartidor daor=new DaoRepartidor();
                 for(Pedido r:daor.lisHistorialPed(codRep)){
                     out.print("<tr><td>"+r.getIdPedido()+"<td>"+r.getRecp()+"<td>"+r.getFecha()+
                             "<td>"+r.getTotal()+"<td>"+r.getDistrito()+"<td>"+r.getRef()+
                             "<td>"+r.getCel());%>
                <td><img src="fotos/mostrar.png" data-toggle="modal" data-target=".bd-example-modal-lg">
                    <%
                        if(r.getEstado().equals("Efectuado")){
                        %>
                <td style="text-align: center;"><img src="fotos/check.png"></td>
                <%    
                }
                   else{ %>
                <td style="text-align: center;"><img src="fotos/cancel.png"></td>
                <%
                    }
}%>
                    
                
       </div>
        </div>
    </body>
</html>
