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

			
				navigator.geolocation.getCurrentPosition(fn_ok, fn_mal);
				function fn_mal(){}
				function fn_ok(rta){
					 lat = rta.coords.latitude;
					 lng = rta.coords.longitude;
					
					var gLatLng = new google.maps.LatLng(lat,lng);
					
					document.getElementById("latitud").value = lat;
					document.getElementById("longitud").value = lng;
					
					map = new google.maps.Map(document.getElementById('map'), {
						center: gLatLng,
						zoom: 16
					});
				
					
					 marker = new google.maps.Marker({
						position: gLatLng,
						map: map,
						title: 'Tu ubicacion',
					});
					
			        var geocoder = new google.maps.Geocoder();
			        
			        geocoder.geocode({'location': gLatLng}, function(results, status) {
			            if (status === 'OK') {
			              if (results[0]) {
			               
			            	document.getElementById("ubicacion").value = results[0].formatted_address;


			              } else {
			                window.alert('No results found');
			              }
			            } else {
			              window.alert('Geocoder failed due to: ' + status);
			            }
			          }); 

			        document.getElementById('submit').addEventListener('click', function() {
			          geocodeAddress(geocoder, map);
			        });
			      }

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
		<h1>Bienveinido ${usuario}</h1>
		<div class="col-lg-8">
			<div id="map"></div>
		</div>
		<div class="col-lg-4">

			<h2>Cambiar ubicacion</h2>

				   <form method="POST" action="mapa/modificar-ubicacion" >
					<p>Cambie su ubicación</p>
						<div class="form-group col-md-8 ">
							<input path="ubicacion" type="text" name="ubicacion" class="form-control" placeholder="Escriba la ubicacion" id="ubicacion"/>
						</div>
						<input id="submit" type="button" value="Cambiar">
						<div class="form-group col-md-8 ">		
					        <input path="latitud" type="text" name="latitud" class="form-control" placeholder="Escriba la latitud" id="latitud"/>
					   </div> 
					   <div class="form-group col-md-8 ">    
					        <input path="longitud" type="text" name="longitud" placeholder="Escriba la longitud" class="form-control" id="longitud"/>
					   </div>
					   <div class="form-group col-md-8 "> 
							<p>Escriba el radio en metros</p>
						</div>	
					   <div class="form-group col-md-8 ">    
					        <input path="radioEnM" type="text" name="radioEnM" placeholder="Escriba los metros para saber la distancia" class="form-control" />
					   </div>

					   <div class="form-group col-md-8 ">     
					        <input type="submit" value="Enviar" class="btn btn-lg btn-primary btn-block">
					   </div>
				  </form> 

			</div>
		</div>
		
		</div>

	
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>
