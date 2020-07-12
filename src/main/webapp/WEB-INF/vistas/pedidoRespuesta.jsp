<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Pedido</title>
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" type="text/css" href="${context}/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${context}/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${context}/css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="${context}/css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="${context}/css/pedidoRespuesta.css"/>
    <link rel="stylesheet" type="text/css" href="${context}/css/bootstrap.min.css"/>
    <script src="https://kit.fontawesome.com/1a26fee52e.js" crossorigin="anonymous"></script>
    <script type="application/javascript" src="${context}/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="img-estilo">
	<h1 class="text-center titulo-imagen ">¡Que disfrutes tu comida!</h1>		
</div>

<div class="container">
	<h1 class="text-center info-pedido">
		Tu pedido a ${restaurant.nombre} ha sido realizado
	</h1>
</div>
<div class="container">
	
</div>
<div class="container ct-lista">
<div class="col-lg-3"></div>
<div class="col-lg-8">

	<div class="col-lg-8 pedido col align-self-center fm-color">
	  <p class="text-color text-center">¡Gracias por realizar su pedido en DELI FAST!</p>
	    <c:forEach var="pedido" items="${listaPedido}">
	       <li class="list-group-item list-group-item-success">
	          ${pedido.nombre}
	          <span class="badge"><i class="fas fa-check-circle"></i></span> 
	       </li>
	    </c:forEach>
	    <h3 class="tc">Total a pagar:</h3>
	    <li class="list-group-item list-group-item-success">$ ${total}</li>
	    <a href="${context}/restaurant/${restaurant.id}" class="btn btn-warning btn-lg btn-pedido btn-block">Realizar otro pedido</a>
	    <a href="${context}/mapa" class="btn btn-warning btn-lg btn-pedido btn-block">Ir a la página principal</a>
    </div>
	<div class="col align-self-end"></div>
</div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>