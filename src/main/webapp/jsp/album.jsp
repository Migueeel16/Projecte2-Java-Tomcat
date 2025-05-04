<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
    <title>Lista de Álbumes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f3;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            margin-top: 40px;
            width: 90%;
            max-width: 1000px;
            background: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 10px;
        }

        p {
            margin-bottom: 20px;
            color: #555;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        .btn-home {
            margin-top: 20px;
            margin-bottom: 20px;
            display: inline-block;
            background-color: #007bff;
            color: white;
            padding: 12px 20px;
            text-decoration: none;
            border-radius: 8px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .btn-home:hover {
            background-color: #0056b3;
        }

        .favorito {
            background-color: #ffc107;
            color: white;
            margin-right: 5px;
        }

        .eliminar {
            background-color: #dc3545;
            color: white;
        }

        .favorito, .eliminar {
            padding: 8px 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .favorito:hover {
            background-color: #e0a800;
        }

        .eliminar:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <a href="home" class="btn-home"><c:out value="${labels['botonHome']}"/></a>
    <div class="container">
        <h1><c:out value="${labels['titleAlbumes']}"/></h1>
        <p><c:out value="${labels['subtitleAlbumes']}"/></p>
        <a href="favoritesAlbum" class="btn-home"><c:out value="${labels['botonFavoritos']}"/></a>
        <table>
            <thead>
            <tr>
                <th><c:out value="${labels['titulo']}"/></th>
                <th><c:out value="${labels['acciones']}"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="album" items="${albums}">
                <tr>
                    <td>${album.title}</td>
                    <td>
                        <div style="display: flex; justify-content: center; gap: 5px;">
                            <form method="post" action="favoritesAlbum">
                                <input type="hidden" name="action" value="addFavorite">
                                <input type="hidden" name="albumId" value="${album.albumId}" />
                                <button type="submit" class="favorito"><c:out value="${labels['addFavoritos']}"/></button>
                            </form>
                            <form action="album" method="post">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="albumId" value="${album.albumId}">
                                <button type="submit" class="eliminar"><c:out value="${labels['eliminar']}"/></button>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
