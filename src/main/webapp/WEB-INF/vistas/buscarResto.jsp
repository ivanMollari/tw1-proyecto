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
    <script type="application/javascript" src="${context}/js/jquery-1.11.3.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container">
    <h2>Busqueda de restaurants que coinciden con: ${param.searchText}</h2>
    <div class="list-group">
        <c:choose>
            <c:when test="${listaResto.size() != 0}">
                <c:forEach var="restaurant" items="${listaResto}" >
                    <a href="${context}/restaurant/${restaurant.getId()}" class="list-group-item list-group-item-action">
                            ${restaurant.getNombre()}
                    </a>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>No se encontraron restaurantes para la busqueda</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>
