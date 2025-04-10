<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
  <title>Lista de Artistas</title>
  <style>
    body {
      display: flex;
      flex-direction: column;
      align-items: center;
      height: 100vh;
      background-color: #f4f4f4;
      padding-top: 20px;
    }
    table {
      border-collapse: collapse;
      width: 60%;
      background: white;
      text-align: center;
      border-radius: 10px;
      overflow: hidden;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      margin-top: 20px;
    }
    h1{
      text-align: center;
    }
    th, td {
      border-bottom: 1px solid #ddd;
      padding: 10px;
    }
    th {
      background-color: #007bff;
      color: white;
    }
    button {
      padding: 5px 10px;
      border: none;
      cursor: pointer;
      border-radius: 5px;
    }
    .favorito {
      background-color: #ffc107;
      color: white;
    }
    .eliminar {
      background-color: #dc3545;
      color: white;
    }
    .btn-home {
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
<a href="home" class="btn-home">Volver a Home</a>
<table>
  <thead>
  <h1>Lista de Artistas</h1>
  <tr>
    <th>Artista</th>
    <th>Acciones</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="artist" items="${artists}">
    <tr>
      <td>${artist.name}</td>
      <td>
        <button class="favorito">Añadir a Favoritos</button>
        <button class="eliminar">Eliminar</button>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
