<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 48095097g
  Date: 25/2/25
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Precio: <fmt:formatNumber value="${price}" type="currency" maxFractionDigits="3"/></p>
    <p>Fecha actual: <fmt:formatDate value="${currentDate}" pattern="dd/MM/yyyy HH:mm:ss"/></p>
</body>
</html>
