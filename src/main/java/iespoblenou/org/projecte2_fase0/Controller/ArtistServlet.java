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

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

    private ArtistRepository artistRepository = new ArtistRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
        } else {
            List<Artist> Artists = artistRepository.getArtists();
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
