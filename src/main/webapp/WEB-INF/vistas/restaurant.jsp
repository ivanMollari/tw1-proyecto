<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="../../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
    <script type="application/javascript" src="../../js/jquery-1.11.3.min.js"></script>
    <script type="application/javascript" src="../../js/menu.js"></script>
    <script>
        var map;
        function initMap() {
            var myLatLng = {lat: ${restaurant.getLatitudResto()}, lng: ${restaurant.getLongitudResto()}};
            map = new google.maps.Map(document.getElementById('map'), {
                <%--center: {lat: ${restaurant.getLatitudResto()}, lng: ${restaurant.getLongitudResto()}},--%>
                center: myLatLng,
                zoom: 16
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
        ${restaurant.getNombre()}
        <div id="map" style="width: 800px; height: 600px"></div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
