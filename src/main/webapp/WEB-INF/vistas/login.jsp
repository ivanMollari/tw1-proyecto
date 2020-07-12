<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <c:set var="context" value="${pageContext.request.contextPath}" />
	     <link href="css/login.css" rel="stylesheet">
	</head>
	<body>
	
		
		<div class = "container">
		
			<div id="loginbox" style="margin-top:10em;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 formulario">
				<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
				<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
					<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
					
					<h1 class="text-center cr-fuente pt-3">INICIAR SESI�N</h1>
				<form:form action="validar-login" method="POST" modelAttribute="usuario" class="form-group">
			    	
					<hr class="colorgraph"><br>

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<div class="form-group pt-3"> 
						<form:input path="email" id="email" type="email" class="form-control" placeholder="Ingrese su mail" />
					</div>
					<div class="form-group pb-3"> 	
						<form:input path="password" type="password" id="password" class="form-control" placeholder="Ingrese su clave"/>     		  
					</div>
					<div class="form-group pb-5">
						<button class="btn btn-lg  btn-block login " Type="Submit"/>Login</button>
					</div>
					<div class="form-group pb-5">
						<a  href ="${context}/registrarUsuario" class="btn btn-lg  btn-block registrarse " />Registrarse</a>
					</div>
				</form:form>

				<%--Bloque que es visible si el elemento error no está vacío	--%>
				<c:if test="${not empty error}">
			        <h4 class="error-login"><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>