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
     <script src="https://kit.fontawesome.com/1a26fee52e.js" crossorigin="anonymous"></script>
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
            

	      /*  document.getElementById('add').addEventListener('click', function() {
	          agregar();
	        });*/
	      
            

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
                    <div class="list-group">
                        <c:forEach var="entrada" items="${items.Entradas}" >
                                <!--  <a href="#" class="list-group-item" comida-id=${entrada.getId()}></a>-->
                                <li class="list-group-item">
                                	<form:form method="POST" action="${context}/restaurant/${restaurant.id}/${entrada.id}" modelAttribute="entrada" >
	                                 	<h4 class="list-group-item-heading">${entrada.getNombre()}</h4>
	                                    <p class="list-group-item-text menu-descripcion">${entrada.getDescripcion()}</p>
	                                    <p>$ ${entrada.getPrecio()}</p>
	                                    <form:input path="id" type="text" id="entradaId" value="${entrada.id}" />
	                                    <form:input path="nombre" type="text" id="nombre" value="${entrada.nombre}" />
	                                    <form:input path="precio" type="text" id="precio" value="${entrada.precio}" />
                                    	<input id="add" type="submit" value="Agregar"class="btn  btn-success ">
                                    </form:form>
                                </li>
                        </c:forEach>
                    </div>
                </div>
                <div id="comidas" class="tab-pane fade in">
                    <h3>Comidas</h3>
                    <div class="list-group">
                        <c:forEach var="comida" items="${items.Comidas}" >
                                <!--<a href="pedido?comida.id=${comida.getId()}&restaurant.id=${restaurant.getId()}" class="list-group-item" comida-id=${comida.getId()}></a>-->
                                <li class="list-group-item">
                                <form method="GET" action="${context}/restaurant/${restaurant.id}/${comida.nombre}" >
                                    <h4 class="list-group-item-heading">${comida.getNombre()}</h4>
                                    <p class="list-group-item-text menu-descripcion">${comida.getDescripcion()}</p>
                                    <p>$ ${comida.getPrecio()}</p>
                                    <input type="text" id="texto" value="${comida.nombre}" >
                                    <input id="add" type="submit" value="Cambiar"class="btn  btn-success ">
                                 </form>
                                </li>
                                
                        </c:forEach>
                    </div>
                </div>
                <div id="bebidas" class="tab-pane fade in">
                    <h3>Bebidas</h3>
                    <div class="list-group">
                        <c:forEach var="bebida" items="${items.Bebidas}" >
                               <!--   <a href="#" class="list-group-item" comida-id=${bebida.getId()}>

                                </a>-->
                                <li class="list-group-item">
                                    <h4 class="list-group-item-heading">${bebida.getNombre()}</h4>
                                    <p class="list-group-item-text menu-descripcion">${bebida.getDescripcion()}</p>
                                    <p>$ ${bebida.getPrecio()}</p>
                                    <input id="add" type="button" value="Cambiar"class="btn  btn-success">
                                </li>
                        </c:forEach>
                    </div>
                </div>
                <div id="postres" class="tab-pane fade in">
                    <h3>Postres</h3>
                    <div class="list-group">
                        <c:forEach var="postre" items="${items.Postres}" >
                                <!--<a href="#" class="list-group-item" comida-id=${postre.getId()}></a>-->
                                <li class="list-group-item">
                                    <h4 class="list-group-item-heading">${postre.getNombre()}</h4>
                                    <p class="list-group-item-text menu-descripcion">${postre.getDescripcion()}</p>
                                    <p>$ ${postre.getPrecio()}</p>
                                    <input id="add" type="button" value="Cambiar"class="btn  btn-success">
                                </li>
                                
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
        <div class="col-lg-4">
        	<h3>Ubicacion</h3>
        	
        <div id="map" style="width: 400px; height: 300px"></div>
        <div class="col-lg-8">
			<h2>Lista de sus pedidos</h2>
				<c:forEach var="pedido" items="${pedidos}">
					<li>${pedido.nombre}</li>
				</c:forEach>

			</div>

    </div>
    </div>

<script>
		function agregar(){
			var dato= document.getElementById('texto').value;
			 alert(dato);
		}
</script>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>