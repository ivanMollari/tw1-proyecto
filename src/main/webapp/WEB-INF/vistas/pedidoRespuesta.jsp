<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Pedido</title>
    <link rel="stylesheet" type="text/css" href="../../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/header.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
    <script type="application/javascript" src="../../js/jquery-1.11.3.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
   <h1>Su pedidop ha sido realizado</h1>
    <a href="distancia.jsp">volver</a>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>