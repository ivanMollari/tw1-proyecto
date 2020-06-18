<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Restaurant</title>
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" type="text/css" href="${context}/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${context}/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${context}/css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="${context}/css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="${context}/css/bootstrap.min.css"/>
     <script type="application/javascript" src="${context}/js/menu.js"></script>
    <script type="application/javascript" src="${context}/js/jquery-1.11.3.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#entradas">Entradas</a></li>
                <li><a data-toggle="tab" href="#comidas">Comidas</a></li>
                <li><a data-toggle="tab" href="#bebidas">Bebidas</a></li>
                <li><a data-toggle="tab" href="#postres">Postres</a></li>
            </ul>

            <div class="tab-content">
                <div id="entradas" class="tab-pane fade in active">
                    <h3>Entradas</h3>
                    <c:forEach var="entrada" items="${items.Entradas}" >
                        <div class="comida col-lg-12" comida-id=${entrada.getId()}>
                            <div class="col-lg-8">
                                <h4>
                                        ${entrada.getNombre()} -
                                        ${entrada.getPrecio()}$
                                </h4>
                                <p class="menu-descripcion">${entrada.getDescripcion()}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div id="comidas" class="tab-pane fade in">
                    <h3>Comidas</h3>
                    <c:forEach var="comida" items="${items.Comidas}" >
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
                <div id="bebidas" class="tab-pane fade in">
                    <h3>Bebidas</h3>
                    <c:forEach var="bebida" items="${items.Bebidas}" >
                        <div class="comida col-lg-12" comida-id=${bebida.getId()}>
                            <div class="col-lg-8">
                                <h4>
                                        ${bebida.getNombre()} -
                                        ${bebida.getPrecio()}$
                                </h4>
                                <p class="menu-descripcion">${bebida.getDescripcion()}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div id="postres" class="tab-pane fade in">
                    <h3>Postres</h3>
                    <c:forEach var="postre" items="${items.Postres}" >
                        <div class="comida col-lg-12" comida-id=${postre.getId()}>
                            <div class="col-lg-8">
                                <h4>
                                        ${postre.getNombre()} -
                                        ${postre.getPrecio()}$
                                </h4>
                                <p class="menu-descripcion">${postre.getDescripcion()}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
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
