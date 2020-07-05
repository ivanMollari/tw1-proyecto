<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<header>

			<nav class="navbar navbar-inverse">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <img src="${context}/images/logoSP3.png" width="50" height="50"" class="pull-left" />
			      <a class="navbar-brand" href="#">DELI FAST</a>
			    </div>
			    <ul class="nav navbar-nav">
			      <li class="li-nav"><a href="/proyecto_limpio_spring_war_exploded/mapa" style="color:white; text-decoration: none">Restaurantes Cercanos</a></li>
			      <li class="li-nav"><a href="#">Mis pedido</a></li>
			      
			    </ul>
			    <form class="navbar-form navbar-right" id="buscar" method="get" action="${context}/restaurant/buscar">
			      <div class="input-group">
			        <input type="text" class="form-control" placeholder="Buscar" name="searchText">
			        <div class="input-group-btn">
			          <button class="btn btn-default" type="submit">
			            <i class="glyphicon glyphicon-search"></i>
			          </button>
			        </div>
			      </div>
			    </form>
			  </div>
			</nav>

</header>
