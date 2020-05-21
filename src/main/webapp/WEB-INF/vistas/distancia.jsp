<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Restaurantes Cercanos</title>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCu9ULYND69swbtjAbJttbsRKiGFvHDtzU&callback=initMap"
			async defer></script>

	<script type="application/javascript" src="../../js/jquery-1.11.3.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../../css/main.css"/>
	<link rel="stylesheet" type="text/css" href="../../css/distancia.css"/>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
	<script>
			var map;
			function initMap() {
				var restaurants = [];
				<c:forEach var="restaurant" items="${listado}">
					restaurants.push({
						nombre: '${restaurant.getNombre()}',
						ubicacion: {
							lat :${restaurant.getLatitudResto()},
							lng :${restaurant.getLongitudResto()},
						}
					});
				</c:forEach>

				var myLatLng = {
					lat: ${usuario.getLatitud()},
					lng: ${usuario.getLongitud()}
				};

				map = new google.maps.Map(document.getElementById('map'), {
					center: myLatLng,
					zoom: 16
				});

				var marker = new google.maps.Marker({
					position: myLatLng,
					map: map,
					title: 'Tu ubicacion',
				});

				restaurants.forEach(restaurant => {
					new google.maps.Marker({
						position: restaurant.ubicacion,
						map: map,
						title: restaurant.nombre
					});
				});
			}
	</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h1>Restaurantes cercanos</h1>
		<div class="col-lg-8">
			<div id="map"></div>
		</div>
		<div class="col-lg-4">
			<c:forEach var="restaurant" items="${listado}">
				${restaurant.getNombre()}</br>
				<div class="restaurant">
					<input type="hidden" id="latitud_${restaurant.getId()}" value=${restaurant.getLatitudResto()}>
					<input type="hidden" id="longitud_${restaurant.getId()}" value=${restaurant.getLongitudResto()}>
				</div>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

