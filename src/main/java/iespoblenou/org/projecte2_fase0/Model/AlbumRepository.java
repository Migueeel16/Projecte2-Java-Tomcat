package iespoblenou.org.projecte2_fase0.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {

    public List<Album> getAlbums(){
        List<Album> albums = new ArrayList<Album>();
        String getAlbums = "SELECT AlbumId, Title, ArtistId FROM Album";

        try {
            Connection con = Conexio.getConexio();
            PreparedStatement stmt = con.prepareStatement(getAlbums);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int albumId = rs.getInt("AlbumId");
                String title = rs.getString("Title");
                int artistId = rs.getInt("ArtistId");

                albums.add(new Album(albumId, title, artistId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albums;
    }

}
