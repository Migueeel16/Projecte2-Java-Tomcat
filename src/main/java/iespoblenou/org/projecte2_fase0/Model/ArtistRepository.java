package iespoblenou.org.projecte2_fase0.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {

    public static List<Artist> getArtists() {
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

    public void delete(int artistId) {
        String queryDeleteArtist = "DELETE FROM Artist WHERE ArtistId = ?";
        try {
            Connection con = Conexio.getConexio();
            PreparedStatement statement = con.prepareStatement(queryDeleteArtist);
            statement.setInt(1, artistId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFavorite(int userId, int artistId) {
        String sql = "INSERT OR IGNORE INTO Favorites_Artist (user_id, artist_id) VALUES (?, ?)";
        try {
            Connection con = Conexio.getConexio();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setInt(2, artistId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Artist> getFavoriteArtists(int userId) {
        List<Artist> favorites = new ArrayList<>();
        String sql = "SELECT a.ArtistId, a.Name FROM Favorites_Artist fa " +
                "JOIN Artist a ON fa.artist_id = a.ArtistId WHERE fa.user_id = ?";

        try (Connection con = Conexio.getConexio();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int artistId = rs.getInt("ArtistId");
                String name = rs.getString("Name");
                favorites.add(new Artist(artistId, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return favorites;
    }

    public static void removeFavorite(int userId, int artistId) {
        String sql = "DELETE FROM Favorites_Artist WHERE user_id = ? AND artist_id = ?";
        try (Connection con = Conexio.getConexio();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, artistId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
