<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Deli Fast</title>
	
	
	<c:set var="context" value="${pageContext.request.contextPath}" />
	
	
	<link rel="stylesheet" type="text/css" href="${context}/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/header.css"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/home.css"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/footer.css"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/bootstrap.min.css"/>
	<script src="https://kit.fontawesome.com/1a26fee52e.js" crossorigin="anonymous"></script>
	<script type="application/javascript" src=" ${context}/js/jquery-1.11.3.min.js"></script>

	<body>
		<section class="img-h">
		<div class = "container c">
			<div class="col-lg-2">
				<img src="${context}/images/logoSP3.png" width="100" height="100" class="pull-left"/>
			</div>
			<div class="col-lg-7"></div>
			<div class="col-lg-3">
			<div class="col-lg-2"><i class="fas fa-user"></i></div>
			<div class="col-lg-8"><p>${usuario}</p></div>
			</div>
			
		</div>
		<div class = "container">
			<h1 class="tb text-center">Bienvenidos a Deli Fast</h1>
		</div>
		</section>
		<section class="container contenedor-texto-intro">
			<h2 class="titulo-texto-b">Delivery que satisface tus sentidos</h2>
			<div class="contenedor-texto-b">
				<p class="texto-b">Amamos la comida tanto como vos y por eso queremos llevar a tu mesa,
				 tu comida favorita directamente desde la cocina de los mejores restaurantes.
				  ¿La mejor parte? ¡Te la llevamos donde estés!
				Ingresá tu dirección, elegí el restaurante, seleccioná tu comida favorita y listo. 
				¡Pedir delivery de comida nunca había sido tan sencillo, con Deli Fast lo único difícil será decidir qué comer!</p>
			 </div>
		</section>
		<section calss="container">
			<h2 class="titulo-texto-b">¡Comenza a buscar los restaurantes mas cercanos a tu ubicación!</h2>
			<p class="text-center">Para poder acceder a los restaurantes cercanos a tu ubicación,
			 hace click en  <a  href ="${context}/mapa" class="btn btn-warning" />Buscar</a></p>
		</section>
		<section class="container contenedor-registrarResto">
			<img src="${context}/images/registrarResto3.jpg" width="450" height="450" class="pull-left"/>
			<div class="contenedor-texto-reg" >
				<h2>Busca a tu restaurante favorito</h2>
				<form class="navbar-form " id="buscar" method="get" action="${context}/restaurant/buscar">
				 <input type="text" class="form-control" placeholder="Buscar" name="searchText" required="required">
				<input id="add" type="submit" value="Buscar"class="btn  btn-warning btn-center">
				</form>
			</div>
		</section>
		<section class="container contenedor-img-txt">
			<div class="contenedor-img col-lg-5">
				<img src="${context}/images/fondito.jpg" width="450" height="450" class="pull-left"/>
			</div>
			<div class="texto-img">
				<h1>¿Cuál aplicación debo usar para pedir comida?</h1>
				<p>Con una rutina cada vez más ocupada, a veces hay poco tiempo para pensar en el menú de la semana 
				o el plato del día. ¡Rappi reúne los mejores restaurantes de tu ciudad!
				 Encuentra desde platos rápidos hasta alternativas saludables.
				  Recibe tu pedido rápidamente y ten la seguridad de nuestra garantía de calidad en la entrega.</p>
			</div>
		</section>

		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		
	<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>