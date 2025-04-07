<%@ page import="iespoblenou.org.projecte2_fase0.Model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>Llista de Productes</h2>
    <table>
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Precio</th>
      </tr>
      <%
        List<Product> products = (List<Product>) request.getAttribute("products");
        if (products != null) {
          for (Product product : products) {
      %>
      <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %>€</td>
      </tr>
      <%
          }
        }
      %>
    </table>
</body>
</html>
