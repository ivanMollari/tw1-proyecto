<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarse</title>

	<c:set var="context" value="${pageContext.request.contextPath}" />
	
	
	<link rel="stylesheet" type="text/css" href="${context}/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/header.css"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/distancia.css"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/footer.css"/>
	<link href="${context}/css/login.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${context}/css/bootstrap.min.css"/>
	<script src="https://kit.fontawesome.com/1a26fee52e.js" crossorigin="anonymous"></script>
	<script type="application/javascript" src=" ${context}/js/jquery-1.11.3.min.js"></script>
	
</head>
<body>
	<div class = "container">
		
			<div id="loginbox" style="margin-top:20em;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 formulario">
				
					
					<h1 class="text-center cr-fuente pt-3">REGISTRARSE</h1>
				<form:form action="guardar-registro" method="POST" modelAttribute="usuario" class="form-group">
			    	
					<hr class="colorgraph"><br>


					<div class="form-group pt-3"> 
						<form:input path="email" id="email" type="email" class="form-control" placeholder="Ingrese su mail" />
					</div>
					<div class="form-group pb-3"> 	
						<form:input path="password" type="password" id="password" class="form-control" placeholder="Ingrese su clave"/>     		  
					</div>
					<div class="form-group pb-5">
						<button class="btn btn-lg  btn-block login " Type="Submit"/>Registrarse</button>
					</div>
					<div class="form-group pb-5">
						<a  haref ="${context}/login" class="btn btn-lg  btn-block registrarse " />Login</a>
					</div>
				</form:form>

				
				<c:if test="${not empty error}">
			        <h4 class="error-login"><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
</body>
</html>