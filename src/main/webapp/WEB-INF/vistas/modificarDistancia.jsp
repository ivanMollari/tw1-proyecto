			
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
		// var iconBase ='https://maps.google.com/mapfiles/kml/shapes/';
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
			

				
				map = new google.maps.Map(document.getElementById('map'), {
					center: {lat: -34.647858, lng: -58.62861},
					zoom: 16
				});
				 var geocoder = new google.maps.Geocoder();
				    var address = "${direccion}";
				    geocoder.geocode( { 'address': address}, function(results, status) {
				      if (status == 'OK') {
				        map.setCenter(results[0].geometry.location);
				        
				        document.getElementById("latitud").value = results[0].geometry.location.lat();
				        document.getElementById("longitud").value = results[0].geometry.location.lng();
				        document.getElementById("ubicacion").value = results[0].formatted_address;
				        var marker = new google.maps.Marker({
				            map: map,
				            title: 'Tu ubicacion',
				            position: results[0].geometry.location
				        });
				        

				      } else {
				        alert('Geocode was not successful for the following reason: ' + status);
				      }
				    });
					
					/*var marker = new google.maps.Marker({
						position: myLatLng,
						map: map,
						title: 'Tu ubicacion',
					});*/
					
				
					var iconBase={
							url: '${context}/images/resto.png',
							 scaledSize: new google.maps.Size(40, 35)};

					restaurants.forEach(restaurant => {
						new google.maps.Marker({
							position: restaurant.ubicacion,
							map: map,
							title: restaurant.nombre,
							icon: iconBase
						});
					});
					
					
				}
				
		
				

			
	</script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCu9ULYND69swbtjAbJttbsRKiGFvHDtzU&callback=initMap" async defer></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		
		<div class="col-lg-8">
			<div id="map"></div>
		</div>
		<div class="col-lg-4">

			${mensaje}

			
			<div class="col-lg-12">
					<h2>Buscar restaurantes cercanos</h2>
				   <form method="POST" action="modificar-ubicacion" >
					<p>Cambie su ubicación</p>
						<div class="form-group col-md-8 ">
							<input path="ubicacion" type="text" name="ubicacion" class="form-control" placeholder="Escriba la ubicacion" id="ubicacion"/>
						</div>
						<div class="form-group col-md-8 ">		
					        <input path="latitud" type="text" name="latitud" class="form-control" placeholder="Escriba la latitud" id="latitud"/>
					   </div> 
					   <div class="form-group col-md-8 ">    
					        <input path="longitud" type="text" name="longitud" placeholder="Escriba la longitud" class="form-control" id="longitud"/>
					   </div>
					   <div class="form-group col-md-8 "> 
							<p>Escriba la distancia maxima a buscar</p>
						</div>
					   <div class="form-group col-md-8 ">    
					        <input path="radioEnM" type="text" name="radioEnM" placeholder="Escriba los metros para saber la distancia" class="form-control" value="${radioEnM}" />
					   </div>
					   <div class="form-group col-md-8 ">  
					        <input type="submit" value="Enviar" class="btn btn-lg btn-primary btn-block">
					   </div>
				  </form> 
			</div>

			</div>
			<div class="col-lg-10">
				<h2>Lista de los restos cercanos a usted</h2>
					<c:forEach var="restaurant" items="${listado}">
						<li>${restaurant.getNombre()}</li>
					</c:forEach>
			</div>
		</div>
		
		</div>
	
	<!-- 					 -->
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>		