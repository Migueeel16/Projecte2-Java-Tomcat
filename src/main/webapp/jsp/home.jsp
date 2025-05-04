<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Home</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background: #f4f4f4;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }

            .container {
                background: white;
                padding: 40px;
                border-radius: 12px;
                box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
                width: 600px;
                text-align: center;
            }

            h1 {
                margin-bottom: 15px;
                color: #333;
                font-size: 32px;
            }

            h2 {
                margin-bottom: 25px;
                color: #555;
                font-size: 22px;
            }

            p {
                color: #666;
                margin: 12px 0;
                font-size: 16px;
            }

            .btn-container {
                margin-top: 30px;
                display: flex;
                justify-content: center;
                gap: 20px;
            }

            .btn {
                background-color: #007bff;
                color: white;
                padding: 14px 28px;
                text-decoration: none;
                border-radius: 8px;
                font-size: 16px;
                transition: background-color 0.3s ease;
            }

            .btn:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Miguel's APP</h1>
            <h2><c:out value="${labels['title']}"/>, <c:out value="${sessionScope.user}" />!</h2>
            <p><c:out value="${labels['subtitle']}"/></p>
            <div class="language-selector">
                <form action="change-language" method="get">
                    <select name="lang" id="lang" onchange="this.form.submit()">
                        <option value="es" ${sessionScope.lang == 'es' ? 'selected' : ''}>Español</option>
                        <option value="en" ${sessionScope.lang == 'en' ? 'selected' : ''}>English</option>
                    </select>
                </form>
            </div>
            <div class="btn-container">
                <a href="album" class="btn"><c:out value="${labels['botonAlbumes']}"/></a>
                <a href="artist" class="btn"><c:out value="${labels['botonartistas']}"/></a>
            </div>
        </div>
    </body>
</html>
