package iespoblenou.org.projecte2_fase0.Controller;

import iespoblenou.org.projecte2_fase0.Model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet("/favoritesAlbum")
public class FavoriteAlbumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String user = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("token".equals(c.getName())) {
                    user = c.getValue();
                    break;
                }
            }
        }
        int userId = UserRepository.getUserIdByUsername(user);

        HttpSession session = request.getSession();
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

        List<Album> favoriteAlbums = AlbumRepository.getFavoriteAlbums(userId);
        request.setAttribute("favoriteAlbums", favoriteAlbums);
        request.getRequestDispatcher("/jsp/favoriteAlbum.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String user = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("token".equals(c.getName())) {
                    user = c.getValue();
                    break;
                }
            }
        }

        int userId = UserRepository.getUserIdByUsername(user);
        int albumId = Integer.parseInt(request.getParameter("albumId"));
        String action = request.getParameter("action");

        if ("remove".equals(action)) {
            AlbumRepository.removeFavoriteAlbum(userId, albumId);
        } else {
            AlbumRepository.addFavoriteAlbum(userId, albumId);
        }
        response.sendRedirect("favoritesAlbum");
    }
}
