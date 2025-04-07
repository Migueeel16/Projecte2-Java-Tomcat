package iespoblenou.org.projecte2_fase0.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet("/price")
public class PriceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double price = 1234.5678;

        request.setAttribute("price", price);
        request.setAttribute("currentDate", new Date());

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/jsp/price.jsp");
        dispatcher.forward(request, response);
    }
}
