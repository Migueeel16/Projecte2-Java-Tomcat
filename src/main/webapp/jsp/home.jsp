<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Home</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #eef2f3;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                height: 100vh;
                margin: 0;
            }
            h1 {
                color: #333;
            }
            .btn-container {
                margin-top: 20px;
            }
            .btn {
                display: inline-block;
                background-color: #007bff;
                color: white;
                padding: 12px 20px;
                margin: 10px;
                text-decoration: none;
                border-radius: 6px;
                font-size: 16px;
                transition: background-color 0.3s ease;
            }
        </style>
    </head>
    <body>

        <h1>Bienvenido <c:out value="${sessionScope.user}" /> !</h1>

        <div class="btn-container">
            <a href="album" class="btn">Ver Álbumes</a>
            <a href="artist" class="btn">Ver Artistas</a>
        </div>
    </body>
</html>
