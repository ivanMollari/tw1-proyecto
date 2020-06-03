<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Restaurant</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../css/header.css"/>
    <link rel="stylesheet" type="text/css" href="../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
    <script type="application/javascript" src="../js/jquery-1.11.3.min.js"></script>
    <script>
        var map;
        function initMap() {
            var myLatLng = {lat: ${restaurant.getLatitudResto()}, lng: ${restaurant.getLongitudResto()}};
            map = new google.maps.Map(document.getElementById('map'), {
                center: myLatLng,
                zoom: 16,
                disableDefaultUI: true,
            });

            var marker = new google.maps.Marker({
                position: myLatLng,
                map: map,
                title: '${restaurant.getNombre()}'
            });
        }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCu9ULYND69swbtjAbJttbsRKiGFvHDtzU&callback=initMap"
            async defer></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="col-lg-8">
            <h1>${restaurant.getNombre()}</h1>
            <div class="menu-box" id="comidas">
                <h3>Comidas</h3>
                <c:forEach var="comida" items="${menu.getComidas()}" >
                    <div class="comida col-lg-12" comida-id=${comida.getId()}>
                        <div class="col-lg-8">
                            <h4>
                                    ${comida.getNombre()} -
                                    ${comida.getPrecio()}$
                            </h4>
                            <p class="menu-descripcion">${comida.getDescripcion()}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="menu-box" id="bebidas">
                <h3>Bebidas</h3>
                <c:forEach var="bebida" items="${menu.getBebidas()}" >
                    <div class="comida col-lg-12">
                        <div class="col-lg-5">
                            <h4>
                                    ${bebida.getNombre()} -
                                    ${bebida.getPrecio()}$
                            </h4>
                            <p class="menu-descripcion">
                                    ${bebida.getDescripcion()}
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="menu-box" id="postres">
                <h3>Postres</h3>
                <c:forEach var="postre" items="${menu.getPostres()}" >
                    <div class="comida col-lg-12">
                        <div class="col-lg-5">
                            <h4>
                                    ${postre.getNombre()} -
                                    ${postre.getPrecio()}$
                            </h4>
                            <p class="menu-descripcion">
                                    ${postre.getDescripcion() ? postre.getDescripcion : "Sin descripcion"}
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="menu-box" id="entradas">
                <h3>Entradas</h3>
                <c:forEach var="entrada" items="${menu.getEntradas()}" >
                    <div class="comida col-lg-12">
                        <div class="col-lg-5">
                            <h4>
                                    ${entrada.getNombre()} -
                                    ${entrada.getPrecio()}$
                            </h4>
                            <p class="menu-descripcion">
                                    ${entrada.getDescripcion() ? entrada.getDescripcion : "Sin descripcion"}
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-lg-4">
            <h3>Ubicacion</h3>
            <div id="map" style="width: 400px; height: 300px"></div>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
