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
			<div class="col-lg-8"></div>
			<div class="col-lg-1">
				<a href="${context}/registrarUsuario" class="lh">Registrate</a>
			</div>
			<div class="col-lg-1">
				<a href="${context}/login" class="lh">Ingresa</a>
			</div>
			
		</div>
		<div class = "container">
			<h1 class="tb text-center">Bienvenidos a Deli Fast</h1>
		</div>
		</section>
		<section class="container contenedor-texto-intro">
			<h2 class="titulo-texto-b">Lorem</h2>
			<div class="contenedor-texto-b">
				<p class="texto-b">Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
				Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
				when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
				It has survived not only five centuries, but also the leap into electronic typesetting,
				 remaining essentially unchanged. It was popularised in the 1960s with the release of 
				 Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing 
				 software like Aldus PageMaker including versions of Lorem Ipsum.</p>
			 </div>
		</section>
		<section class="container contenedor-registrarResto">
			<img src="${context}/images/registrarResto3.jpg" width="450" height="450" class="pull-left"/>
			<div class="contenedor-texto-reg" >
				<h2>Hace que tu restaurante forme parte</h2>
				<input id="add" type="submit" value="Registrar"class="btn  btn-warning btn-center">
			</div>
		</section>
		<section class="container contenedor-img-txt">
			<div class="contenedor-img col-lg-5">
				<img src="${context}/images/fondito.jpg" width="450" height="450" class="pull-left"/>
			</div>
			<div class="texto-img">
				<h1>Titulo del texto de la foto</h1>
				<p>Nota que los atributos width y height redimensionan 
				la imagen al vuelo, esto es, la imagen tendrá unas dimensiones concretas y 
				se descargará siempre a máxima resolución. Con estos atributos redimensionas la imagen 
				al tamaño de ancho y alto indicado, pero la imagen realmente tiene su propio tamaño. 
				Puedes omitir estos atributos siempre que quieras, ya que no son obligatorios, 
				pero se consideran una buena práctica para evitar los molestos cambios repentinos 
				de posición o tamaño en una página.</p>
			</div>
		</section>

		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		
	<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>