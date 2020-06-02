
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="../../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
    <script type="application/javascript" src="../../js/jquery-1.11.3.min.js"></script>
    <script type="application/javascript" src="../../js/menu.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="col-lg-7">
            <h1>Menu - ${menuBuscado.getDescripcion()}</h1>
            <div class="menu-box">
                <h3>Comidas</h3>
                <c:forEach var="comida" items="${menuBuscado.getComidas()}" >
                    <div class="comida col-lg-12" comida-id=${comida.getId()}>
                        <input type="hidden" id="nombre-${comida.getId()}" value=${comida.getNombre()}>
                        <input type="hidden" id="precio-${comida.getId()}" value=${comida.getPrecio()}>
                        <div class="col-lg-5">
                            <h4 class="menu-descripcion">
                                    ${comida.getNombre()} -
                                    ${comida.getPrecio()}$
                            </h4>
                        </div>
                        <div class="col-lg-4">
                            <button class="cambiar-cantidad" type-change="decrement" disabled>-</button>
                            <b id="cantidad-${comida.getId()}">0</b>
                            <button class="cambiar-cantidad" type-change="increment">+</button>
                        </div>
                        <div class="col-lg-3 menu-agregar">
                            <div class="row">
                                Subtotal: <b id="subtotal-${comida.getId()}">0 $</b>
                            </div>
                            <div class="row">
                                <button class="button-agregar" id="agregar-${comida.getId()}" disabled>Agregar</button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <c:forEach var="bebida" items="${menuBuscado.getBebidas()}" >
                    ${bebida.getNombre()}
                </c:forEach>
                <c:forEach var="postre" items="${menuBuscado.getPostres()}" >
                    ${postre.getNombre()}
                </c:forEach>
            </div>
        </div>
        <div class="col-lg-4">
            <h1> Mi pedido</h1>
            <div class="mi-pedido">
                <div class="productos col-lg-12">
                    <p>No hay productos seleccionados</p>
                </div>
                <div class="total col-lg-12">
                    <p class="col-lg-6">Total</p>
                    <p class="col-lg-4" id="total">0$</p>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
