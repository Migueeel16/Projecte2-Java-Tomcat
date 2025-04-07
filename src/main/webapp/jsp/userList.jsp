<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <c:forEach var="user" items="${userList}">
            <p>${user}</p>
        </c:forEach>
    </body>
</html>
