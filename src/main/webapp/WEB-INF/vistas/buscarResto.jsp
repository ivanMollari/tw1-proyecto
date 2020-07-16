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
    <link rel="stylesheet" type="text/css" href="${context}/css/buscar.css"/>
    <link rel="stylesheet" type="text/css" href="${context}/css/bootstrap.min.css"/>
    <script type="application/javascript" src="${context}/js/jquery-1.11.3.min.js"></script>
    <script src="https://kit.fontawesome.com/1a26fee52e.js" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container container-lista">
    <h2 class="titulo-lista">Busqueda de restaurants que coinciden con: ${param.searchText}</h2>
    <div class="list-group listado">
        <c:choose>
            <c:when test="${listaResto.size() != 0}">
                <c:forEach var="restaurant" items="${listaResto}" >
                    <div class="list-group-item list-group-item-action restaurant">
                        <img src="${context}/images/${restaurant.getImg()}" width="100px" class="col-lg-1">
                        <div class="">
                            <a href="${context}/restaurant/${restaurant.getId()}">
                                    ${restaurant.getNombre()}
                            </a>
                            <c:choose>
                                <c:when test="${restaurant.getDistancia() < 1000}">
                                    <p>Este restaurant esta a menos de 1 km</p>
                                </c:when>
                                <c:otherwise>
                                    <p>Este restaurant esta a ${restaurant.getDistancia() / 1000} km</p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p class="ct-contenido">No se encontraron restaurantes para la busqueda</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>
