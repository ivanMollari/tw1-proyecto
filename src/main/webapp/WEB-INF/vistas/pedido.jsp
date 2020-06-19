
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Pedido</title>
    <link rel="stylesheet" type="text/css" href="../../../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../../../css/header.css"/>
    <link rel="stylesheet" type="text/css" href="../../../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../../../css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="../../../css/bootstrap.min.css"/>
    <script type="application/javascript" src="../../../js/jquery-1.11.3.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="col-lg-7">

        <div class="menu-box">
            <h3>${comida.getNombre()}</h3>
        </div>

        <div class="col-lg-4">
            <%--@elvariable id="pedido" type=""--%>
            <form:form action="/restaurant/${comida.getId()}/pedido" method="POST" modelAttribute="pedido">


                <div><form:input path="total" id="total" type="text" class="form-control"/></div>

                <div><form:input path="comidas" id="comidas" type="comidas" class="form-control"/></div>

                <br>


                <input type="submit" value="realizar pedido">

            </form:form>


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
