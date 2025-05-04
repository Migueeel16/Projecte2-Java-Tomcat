package iespoblenou.org.projecte2_fase0.Controller;

import iespoblenou.org.projecte2_fase0.Model.Artist;
import iespoblenou.org.projecte2_fase0.Model.ArtistRepository;
import iespoblenou.org.projecte2_fase0.Model.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet("/favoritesArtist")
public class FavoriteArtistServlet extends HttpServlet {


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

        List<Artist> favoriteArtists = ArtistRepository.getFavoriteArtists(userId);
        request.setAttribute("favoriteArtists", favoriteArtists);
        request.getRequestDispatcher("/jsp/favoriteArtist.jsp").forward(request, response);
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
        int artistId = Integer.parseInt(request.getParameter("artistId"));
        String action = request.getParameter("action");

        if ("remove".equals(action)) {
            ArtistRepository.removeFavorite(userId, artistId);
        } else {
            ArtistRepository.addFavorite(userId, artistId);
        }
        response.sendRedirect("favoritesArtist");
    }
}
