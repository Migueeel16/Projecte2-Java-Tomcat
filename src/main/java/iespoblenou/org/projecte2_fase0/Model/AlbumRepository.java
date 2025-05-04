package iespoblenou.org.projecte2_fase0.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {

    public static List<Album> getAlbums(){
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

    public void deleteAlbum(int id) {
        String queryDeleteAlbum = "DELETE FROM Album WHERE AlbumId = ?";
        try {
            Connection con = Conexio.getConexio();
            PreparedStatement statement = con.prepareStatement(queryDeleteAlbum);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFavoriteAlbum(int userId, int albumId) {
        String sql = "INSERT OR IGNORE INTO Favorites_Album (user_id, album_id) VALUES (?, ?)";
        try (Connection con = Conexio.getConexio();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, albumId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Album> getFavoriteAlbums(int userId) {
        List<Album> favorites = new ArrayList<>();
        String sql = "SELECT a.AlbumId, a.Title, a.ArtistId FROM Album a " +
                "JOIN Favorites_Album f ON a.AlbumId = f.album_id " +
                "WHERE f.user_id = ?";

        try (Connection con = Conexio.getConexio();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("AlbumId");
                String title = rs.getString("Title");
                int artistId = rs.getInt("ArtistId");
                favorites.add(new Album(id, title, artistId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return favorites;
    }

    public static void removeFavoriteAlbum(int userId, int albumId) {
        String sql = "DELETE FROM Favorites_Album WHERE user_id = ? AND album_id = ?";
        try (Connection con = Conexio.getConexio();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, albumId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
