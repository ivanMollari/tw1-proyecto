
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Pedido</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../css/header.css"/>
    <link rel="stylesheet" type="text/css" href="../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
    <script type="application/javascript" src="../js/jquery-1.11.3.min.js"></script>

</head>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="col-lg-7">

        <div class="menu-box">
            <h3>${comidas.get(comidas.size()-1).getNombre()}</h3>
        </div>

        <div class="col-lg-4">
        <%--@elvariable id="requestPedido" type="ar.edu.unlam.tallerweb1.modelo.RequestPedido"--%>
        <form:form method="POST" action="${requestPedido.id_restaurant}/pedido" modelAttribute="requestPedido">
            <form:hidden name="id" path="id" value="${requestPedido.id}"/>
            <form:hidden  path="total" value="${requestPedido.total}"/>
            <c:forEach var="idComida" items="${requestPedido.id_comidas}" >
                <form:hidden name="comida_id" path="id_comidas" value="${idComida}"/>
            </c:forEach>
            <input type="submit" value="enviar">
        </form:form>
                

        </div>
    </div>
    <div class="col-lg-4">
        <h1> Mi pedido</h1>
        <div class="mi-pedido">
            <c:forEach var="comida" items="${comidas}" >
                <h2>${comida.getNombre()}</h2>
            </c:forEach>

            <div class="total col-lg-12">
                <p class="col-lg-6">Total</p>
                <p class="col-lg-4" id="total">${requestPedido.total}</p>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>


</html>
