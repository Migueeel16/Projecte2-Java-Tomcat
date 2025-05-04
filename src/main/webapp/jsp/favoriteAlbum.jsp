<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
  <title>Artistas Favoritos</title>
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
      width: 700px;
      text-align: center;
    }

    h1 {
      margin-bottom: 15px;
      color: #333;
      font-size: 28px;
    }

    p {
      color: #666;
      font-size: 16px;
      margin-bottom: 25px;
    }

    table {
      border-collapse: collapse;
      width: 100%;
      background: white;
      text-align: center;
      border-radius: 10px;
      overflow: hidden;
      box-shadow: 0 0 8px rgba(0, 0, 0, 0.05);
    }

    th, td {
      border-bottom: 1px solid #ddd;
      padding: 12px;
      font-size: 15px;
    }

    th {
      background-color: #007bff;
      color: white;
    }

    .btn-home {
      display: inline-block;
      background-color: #007bff;
      color: white;
      padding: 10px 20px;
      margin-bottom: 25px;
      text-decoration: none;
      border-radius: 8px;
      font-size: 16px;
      transition: background-color 0.3s ease;
    }

    .btn-home:hover {
      background-color: #0056b3;
    }

    .eliminar {
      background-color: #dc3545;
      color: white;
      padding: 8px 16px;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      font-size: 14px;
    }

    .eliminar:hover {
      background-color: #bb2d3b;
    }
  </style>
</head>
<body>

  <div class="container">
    <a href="home" class="btn-home"><c:out value="${labels['botonHome']}"/></a>
    <h1><c:out value="${labels['titleAlbumesFavoritos']}"/></h1>
    <p><c:out value="${labels['subtitleAlbumesFavoritos']}"/></p>
    <table>
      <thead>
      <tr>
        <th><c:out value="${labels['tituloFavoritosAlbumes']}"/></th>
        <th><c:out value="${labels['acciones']}"/></th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="album" items="${favoriteAlbums}">
        <tr>
          <td>${album.title}</td>
          <td>
            <form action="favoritesAlbum" method="post">
              <input type="hidden" name="action" value="remove">
              <input type="hidden" name="albumId" value="${album.albumId}">
              <button class="eliminar" type="submit"><c:out value="${labels['eliminarFavorito']}"/></button>
            </form>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
