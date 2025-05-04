package iespoblenou.org.projecte2_fase0.Controller;

import iespoblenou.org.projecte2_fase0.Model.Artist;
import iespoblenou.org.projecte2_fase0.Model.ArtistRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        if(session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
        } else {
            List<Artist> Artists = ArtistRepository.getArtists();
            session.setAttribute("artists", Artists);
            request.getRequestDispatcher("jsp/artist.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            int artistId = Integer.parseInt(req.getParameter("artistId"));

            ArtistRepository artistRepository = new ArtistRepository();
            artistRepository.delete(artistId);

            resp.sendRedirect("artist");
        } else {
            doGet(req, resp);
        }
    }

}
