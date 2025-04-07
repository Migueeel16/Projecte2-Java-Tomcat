package iespoblenou.org.projecte2_fase0.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {

    public List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<>();
        String getArtistsQuery = "SELECT ArtistId, Name FROM Artist";

        try {
            Connection con = Conexio.getConexio();
            PreparedStatement stmt = con.prepareStatement(getArtistsQuery);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int artistId = rs.getInt("ArtistId");
                String name = rs.getString("Name");
                artists.add(new Artist(artistId, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artists;
    }
}
