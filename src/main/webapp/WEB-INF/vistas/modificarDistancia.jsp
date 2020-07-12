			
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
	<script src="https://kit.fontawesome.com/1a26fee52e.js" crossorigin="anonymous"></script>
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
				        marker = new google.maps.Marker({
				            map: map,
				            title: 'Tu ubicacion',
				            position: results[0].geometry.location
				        });
				        

				      } else {
				        alert('Geocode was not successful for the following reason: ' + status);
				      }
				    });
					

				
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
					
			        document.getElementById('submit').addEventListener('click', function() {
				          geocodeAddress(geocoder, map);
				     });
			        
				      function geocodeAddress(geocoder, resultsMap) {
					        var address = document.getElementById('ubicacion').value;
					        geocoder.geocode({'address': address}, function(results, status) {
					          if (status === 'OK') {
					            resultsMap.setCenter(results[0].geometry.location);
					            marker.setPosition(results[0].geometry.location);
				            	document.getElementById("latitud").value = results[0].geometry.location.lat();
								document.getElementById("longitud").value = results[0].geometry.location.lng();
					           
					          } else {
					            alert('Geocode was not successful for the following reason: ' + status);
					          }
					        });
					      }		
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
			<div class="col-lg-4 form-mapa">
			<p class="titulo-form">CAMBIAR UBICACIÓN</p>

				   <form method="POST" action="${context}/mapa/modificar-ubicacion" >
					<hr class="colorgraph"><br>
						<div class=" col-md-10 ">
							<p class="ct-fm">Cambie su ubucación</p>
						</div>
						<div class=" col-md-10 input-fm">
							<input path="ubicacion" type="text" name="ubicacion" class="form-control" placeholder="Escriba la ubicacion" id="ubicacion"/>
						</div>
						<div class=" col-md-10 ">		
					        <input path="latitud" type="hidden" name="latitud" class="form-control" placeholder="Escriba la latitud" id="latitud"/>
					   </div> 
					   <div class=" col-md-10 ">    
					        <input path="longitud" type="hidden" name="longitud" placeholder="Escriba la longitud" class="form-control" id="longitud"/>
					   </div>
						<div class=" col-md-6 ">
							<input id="submit" type="button" value="Cambiar"class="btn btn-lg btn-block btn-warning">
						</div>

					   <div class=" col-md-10"> 
							<p class="ct-fm">Escriba el radio en metros</p>
						</div>	
					   <div class="col-md-10 input-fm">    
					        <input path="radioEnM" type="text" name="radioEnM" placeholder="Escriba los metros para saber la distancia" class="form-control" required="required" />

					   </div>

					   <div class=" col-md-10">     
					        <input type="submit" value="Enviar" class="btn btn-lg btn-block btn-warning">
					   </div>
					   
					   ${mensaje}
				  </form> 
				  
			</div>

			</div>
			<div class="container">
			<div class="col-lg-8">
				<h2>Lista de los restos cercanos a usted</h2>
					<c:forEach var="restaurant" items="${listado}">
				
						<a href="${context}/restaurant/${restaurant.id}" class="list-group-item list-restos">
						<strong>${restaurant.nombre}</strong></a>
					
					</c:forEach>
				
			</div>
			</div>

	
	<!-- 					 -->
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>		