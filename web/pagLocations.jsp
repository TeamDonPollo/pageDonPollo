
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Location"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="Head.jsp" %>
    <%@include file="Cabecera.jsp" %>
    <body>
        
        <%
            List<Location> locations = (ArrayList<Location>) request.getAttribute("locations");
        %>
        
        <div class="container"> <p class="font-weight-bold">NUESTRAS SEDES</p> </div>
        <div class="container">
            <% for (Location location : locations) {  %>
                <div class="row">
                    <div class="col-6" style="margin: 15px auto;">
                      <div class="text-center">
                        <img src="<%=location.getLocationImage()%>" class="rounded" alt="Location Image">
                      </div>
                        <div>
                            <p class="font-weight-bold"><%=location.getLocationName()%></p>
                            <p class="font-weight-normal"><%=location.getDescription()%></p>
                        </div>
                        <div>
                            <ul class="list-group">
                                <li class="list-group-item"><img width="40px" src="https://www.donbelisario.com.pe/skin/frontend/default/donbelisario/images/fono-mobile.svg" class="img-fluid img-thumbnail" alt="Phone Number"><%=location.getPhoneNumber()%></li>
                                <li class="list-group-item"><img width="40px" src="https://www.donbelisario.com.pe/skin/frontend/default/donbelisario/images/modalidades/delivery-y-recojo-en-tienda.png" class="img-fluid img-thumbnail" alt="Delivery Time"><%=location.getDeliveryStoreTime()%></li>
                                <li class="list-group-item"><img width="40px" src="https://www.donbelisario.com.pe/skin/frontend/default/donbelisario/images/modalidades/para-llevar.png" class="img-fluid img-thumbnail" alt="Reception Time"><%=location.getReceptionTime()%></li>
                                <li class="list-group-item"><img width="40px" src="https://www.donbelisario.com.pe/skin/frontend/default/donbelisario/images/modalidades/salon.png" class="img-fluid img-thumbnail" alt="Presential Time"><%=location.getPresentialTime()%></li>
                            </ul>
                        </div>
                    </div>           
                </div>
            <% } %>
        </div>
        
        <%@include file="Footer.jsp" %>
    </body>
    <!-- Script de BOOTSTRAP-->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
