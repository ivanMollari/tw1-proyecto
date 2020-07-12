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
    <link rel="stylesheet" type="text/css" href="${context}/css/misPedidos.css"/>
    <script type="application/javascript" src="${context}/js/menu.js"></script>
    <script type="application/javascript" src="${context}/js/jquery-1.11.3.min.js"></script>
     <script src="https://kit.fontawesome.com/1a26fee52e.js" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>



<div class="container ct-lista">
    <div class="col-lg-3"></div>
    <div class="col-lg-8">

        <div class="col-lg-8 pedido col align-self-center fm-color">
            <p class="text-color text-center">Pedidos</p>

                <c:forEach var="pedido" items="${listita}" >
                    <div style="margin: 10px;">
                        <section>
                            <article>
                                <h3>${pedido.restaurant.nombre}</h3>
                                <c:forEach var="entradas" items="${pedido.entradas}">

                                    <li class="list-group-item list-group-item-success">
                                            ${entradas.nombre}

                                        <span class="badge"><i class="fas fa-check-circle"></i></span>
                                    </li>

                                </c:forEach>

                                <c:forEach var="comidas" items="${pedido.comidas}">

                                    <li class="list-group-item list-group-item-success">
                                            ${comidas.nombre}

                                        <span class="badge"><i class="fas fa-check-circle"></i></span>
                                    </li>

                                </c:forEach>

                                <c:forEach var="bebidas" items="${pedido.bebidas}">

                                    <li class="list-group-item list-group-item-success">
                                            ${bebidas.nombre}

                                        <span class="badge"><i class="fas fa-check-circle"></i></span>
                                    </li>

                                </c:forEach>

                                <c:forEach var="postres" items="${pedido.postres}">

                                    <li class="list-group-item list-group-item-success">
                                            ${postres.nombre}

                                        <span class="badge"><i class="fas fa-check-circle"></i></span>
                                    </li>

                                </c:forEach>

                            </article>
                            <article>
                                <div><img src="${context}/${pedido.restaurant.img}" alt="restaurant"></div>
                            </article>
                        </section>

                    <div><p>total: ${pedido.total}</p></div>

                    </div>




                </c:forEach>

        </div>
        <div class="col align-self-end"></div>
    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>