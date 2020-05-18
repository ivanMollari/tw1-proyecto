
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="../../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
    <script type="application/javascript" src="../../js/menu.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="col-lg-7">
            <h1>Menu</h1>
            <div class="menu-box">
                <div class="col-lg-7">
                    <h3>
                        ${menu.nombre}

                    </h3>
                    <p class="menu-descripcion">
                        Descripcion: ${menu.descripcion}
                    </p>
                </div>
                <div class="col-lg-2">
                    <h3 id="precio">${menu.precioDeLista} $</h3>
                </div>
                <div class="col-lg-3 menu-agregar">
                    <div class="row">
                        <button id="boton-decrementar" disabled>-</button>
                        <b id="cantidad">0</b>
                        <button id="boton-incrementar">+</button>
                    </div>
                    <div class="row">
                        Subtotal: <b id="subtotal">0.00 $</b>
                    </div>
                    <div class="row">
                        <button class="button-agregar">Agregar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <h1> Mi pedido</h1>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
