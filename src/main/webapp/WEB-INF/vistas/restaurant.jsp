<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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


                        <c:forEach var="entrada" items="${items.Entradas}">
                            <li class="list-group-item">
                                <form:form method="POST" action="${context}/restaurant/${restaurant.id}/entrada" modelAttribute="entrada" >
                                    <h4 class="list-group-item-heading ">${entrada.getNombre()}</h4>
                                    <p class="list-group-item-text menu-descripcion ">${entrada.getDescripcion()}</p>
                                    <p>$ ${entrada.getPrecio()}</p>
                                    <form:hidden path="id"  id="entradaId" value="${entrada.id}"/>
                                    <form:hidden path="nombre"  id="nombre" value="${entrada.nombre}" />
                                    <form:hidden path="precio"  id="precio" value="${entrada.precio}" />
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
                                <li class="list-group-item">
                                <form:form method="POST" action="${context}/restaurant/${restaurant.id}/comida" modelAttribute="comida" >
                                    <h4 class="list-group-item-heading">${comida.getNombre()}</h4>
                                    <p class="list-group-item-text menu-descripcion">${comida.getDescripcion()}</p>
                                    <p>$ ${comida.getPrecio()}</p>
                                    <form:hidden path="id"  id="nombre" value="${comida.id}" />
	                                <form:hidden path="nombre"  id="nombre" value="${comida.nombre}" />
	                                <form:hidden path="precio"  id="precio" value="${comida.precio}" />
                                    <input id="add" type="submit" value="Agregar"class="btn  btn-success ">
                                 </form:form>
                                </li>
                                
                        </c:forEach>
                    </div>
                </div>
                <div id="bebidas" class="tab-pane fade in">
                    <h3>Bebidas</h3>
                    <div class="list-group">
                        <c:forEach var="bebida" items="${items.Bebidas}" >
                                <li class="list-group-item">
                                <form:form method="POST" action="${context}/restaurant/${restaurant.id}/bebida" modelAttribute="bebida" >
                                    <h4 class="list-group-item-heading">${bebida.getNombre()}</h4>
                                    <p class="list-group-item-text menu-descripcion">${bebida.getDescripcion()}</p>
                                    <p>$ ${bebida.getPrecio()}</p>
                                    <form:hidden path="id"  id="bebidaId" value="${bebida.id}" />
	                                <form:hidden path="nombre"  id="nombre" value="${bebida.nombre}" />
	                                <form:hidden path="precio"  id="precio" value="${bebida.precio}" />
                                    <input id="add" type="submit" value="Agregar"class="btn  btn-success ">
                                </form:form>
                                </li>
                        </c:forEach>
                    </div>
                </div>
                <div id="postres" class="tab-pane fade in">
                    <h3>Postres</h3>
                    <div class="list-group">
                        <c:forEach var="postre" items="${items.Postres}" >
                                <li class="list-group-item">
                                <form:form method="POST" action="${context}/restaurant/${restaurant.id}/postre" modelAttribute="postre" >
                                    <h4 class="list-group-item-heading">${postre.getNombre()}</h4>
                                    <p class="list-group-item-text menu-descripcion">${postre.getDescripcion()}</p>
                                    <p>$ ${postre.getPrecio()}</p>
                                    <form:hidden path="id"  id="postreId" value="${postre.id}" />
	                                <form:hidden path="nombre"  id="nombre" value="${postre.nombre}" />
	                                <form:hidden path="precio"  id="precio" value="${postre.precio}" />
                                    <input id="add" type="submit" value="Agregar"class="btn  btn-success ">
                                 </form:form>
                                </li>
                                
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
        <div class="col-lg-4">
        	<h3>Ubicacion</h3>
        	
        <div id="map" style="width: 400px; height: 300px"></div>
        <div class="col-lg-10">
			<h2>Su pedido</h2>
			<%--@elvariable id="requestPedido" type="ar.edu.unlam.tallerweb1.modelo.RequestPedido"--%>
            <form:form method="POST" action="${context}/restaurant/${requestPedido.id_restaurant}/pedido" modelAttribute="requestPedido">
                <c:forEach var="pedido" items="${pedidos}">
                    <li class="list-group-item">
                        <p>${pedido.nombre}</p>
                    </li>
                </c:forEach>
                <li class="list-group-item">$ ${total}</li>
                <form:hidden name="id" path="idRequestPedido" value="${requestPedido.id}"/>
                <form:hidden name="total" path="total" value="${requestPedido.total}"/>
                <form:hidden name="idResto" path="id_restaurant" value="${requestPedido.id_restaurant}"/>
                <c:forEach var="idComida" items="${requestPedido.idConmidas}">
                    <form:hidden name="comida" path="idConmidas" value="${idComida}"/>
                </c:forEach>
                <c:forEach var="idEntrada" items="${requestPedido.idEntradas}">
                    <form:hidden name="entrada" path="idEntradas" value="${idEntrada}"/>
                </c:forEach>
                <c:forEach var="idPostre" items="${requestPedido.idPostres}">
                    <form:hidden name="postre" path="idPostres" value="${idPostre}"/>
                </c:forEach>
                <c:forEach var="idBebida" items="${requestPedido.idBebidas}">
                    <form:hidden name="bebida" path="idBebidas" value="${idBebida}"/>
                </c:forEach>
				<form:hidden name="total" path="total" value="${total}"/>

                <input id="enviar" type="submit" value="Enviar"class="btn  btn-succes">
            </form:form>

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