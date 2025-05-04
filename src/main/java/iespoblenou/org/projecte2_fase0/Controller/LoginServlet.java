package iespoblenou.org.projecte2_fase0.Controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import iespoblenou.org.projecte2_fase0.Model.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Cookie cookie = new Cookie("username", username);
        HttpSession session = request.getSession();
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");
        response.addCookie(cookie);

        String lang = request.getParameter("lang");
        if (lang == null || lang.isEmpty()) {
            lang = (String) session.getAttribute("lang");
            if (lang == null || lang.isEmpty()) {
                lang = "es";
            }
        } else {
            session.setAttribute("lang", lang);
        }
        Locale locale = new Locale(lang);
        ResourceBundle labels = ResourceBundle.getBundle("i18n.messages", locale);
        request.setAttribute("labels", labels);

        if (UserRepository.validateUser(username, password)) {

            session.setAttribute("user", username);
            response.sendRedirect("home");

        } else {
            request.setAttribute("errorMessage", "Usuari o contrasenya incorrectes!");
            response.sendRedirect("ErrorServlet");
        }
        System.out.println("Usuario: " + username);
        System.out.println("Contraseña: " + password);
        System.out.println("Usuario válido: " + UserRepository.validateUser(username, password));
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
