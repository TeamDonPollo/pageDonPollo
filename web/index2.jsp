<!DOCTYPE html>
<html>
      
    <%@include file="Head.jsp" %>
    <body>

        <!-- BARRA DE NAVEGACION-->

        <%@include file="Cabecera.jsp" %>
        <!-- Carrucel de productos-->
        <section>
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators"weight="550pt">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" align="center">
                    <div class="carousel-item active">
                        <img src="img/fondo.jpeg" class="d-block w-80" width="80%" height="550pt">
                        <div class="carousel-caption d-none d-md-block div-carrucel">
                            <h5>Variedad de combos  y guarniciones</h5>
                            <p>Don Pollo ofrece la mayor variedad para los diferentes gustos.</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="img/delivery.jpg" class="d-block w-80" width="80%" height="550pt">
                        <div class="carousel-caption d-none d-md-block div-carrucel">
                            <h5>Servidicio de Delivery</h5>
                            <p>Este servicios es gratuito solo para los que compren por este medio.</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="img/promociones.jpg" class="d-block w-80" width="80%" height="550pt">
                        <div class="carousel-caption d-none d-md-block div-carrucel">
                            <h5>Promociones</h5>
                            <p>Ofrecemos promociones/combos en conjunto con nuestros partners.</p>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </section>

        <%@include file="Footer.jsp" %>
         
        <!-- Script de BOOTSTRAP-->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>




    </body>
</html>