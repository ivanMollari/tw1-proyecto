<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Restaurantes cercanos</title>
</head>
<body>
	<h1>Restaurantes cercanos</h1>
	<p>
		<c:forEach var="restaurant" items="${listado}">  
			  ${restaurant.getNombre()}</br> 
		</c:forEach>
	</p>
</body>
</html>

