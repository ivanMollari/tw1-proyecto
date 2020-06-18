<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Restaurantes Cercanos</title>
	
	
	<c:set var="context" value="${pageContext.request.contextPath}" />
	
	
	<link rel="stylesheet" type="text/css" href="${context}/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/header.css"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/distancia.css"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/footer.css"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/bootstrap.min.css"/>
	<script type="application/javascript" src=" ${context}/js/jquery-1.11.3.min.js"></script>
	
	<script>
		
			var map;
			
			function initMap() {
				map = new google.maps.Map(document.getElementById('map'), {
					  zoom: 16,
			          center: {lat: -34.397, lng: 150.644}
				});
				 var geocoder = new google.maps.Geocoder();
			    var address = "${direccion}";
			    geocoder.geocode( { 'address': address}, function(results, status) {
			      if (status == 'OK') {
			        map.setCenter(results[0].geometry.location);
			        var marker = new google.maps.Marker({
			            map: map,
			            position: results[0].geometry.location
			        });
			      } else {
			        alert('Geocode was not successful for the following reason: ' + status);
			      }
			    });
				
		
				

			}
	</script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCu9ULYND69swbtjAbJttbsRKiGFvHDtzU&callback=initMap" async defer></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h1>Bienveinido</h1>
		<div class="col-lg-8">
			<div id="map"></div>
		</div>
		<div class="col-lg-4">
			<!--<c:forEach var="restaurant" items="${listado}">
				${restaurant.getNombre()}</br>
			</c:forEach>
			${mensaje}-->
			 
			

			</div>
		</div>
		
		</div>
	
	
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>