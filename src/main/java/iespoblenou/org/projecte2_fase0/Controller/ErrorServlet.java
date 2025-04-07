package iespoblenou.org.projecte2_fase0.Controller;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String errorMessage = (String) request.getAttribute("errorMessage");
        out.println("<h1>Error d'autenticació</h1>");
        out.println("<p>" + (errorMessage != null ? errorMessage : "Error desconegut") + "</p>");
        out.println("<a href='login.html'>Torna a intentar</a>");
    }
}
