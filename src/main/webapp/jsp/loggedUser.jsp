<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Comprovació Usuari Logat</title>
    <style>
        .highlight {
            color: #4CAF50;
            font-weight: bold;
            font-size: 15pt;
        }
    </style>
</head>
    <body>
        <h1>Comprovació de l'usuari logat</h1>
        <%
            // Recuperem l'atribut 'user' de la sessió
            String user = (String) session.getAttribute("user");
            if (user != null) {
        %>
        <p>Benvingut, <span class="highlight"><%= user %></span>! Ets un
            usuari logat.</p>
        <%
        } else {
        %>
        <p>No hi ha cap usuari logat. Si us plau, inicia sessió.</p>
        <%
            }
        %>
    </body>
</html>
