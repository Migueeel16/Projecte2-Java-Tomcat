package iespoblenou.org.projecte2_fase0.Controller;

import iespoblenou.org.projecte2_fase0.Model.Product;
import iespoblenou.org.projecte2_fase0.Model.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductControllerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> productList = ProductRepository.getAllProducts();
        request.setAttribute("products", productList);
        request.getRequestDispatcher("/jsp/products.jsp").forward(request, response);
    }
}
