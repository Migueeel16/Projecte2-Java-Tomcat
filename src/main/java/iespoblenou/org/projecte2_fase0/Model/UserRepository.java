package iespoblenou.org.projecte2_fase0.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {

    public static boolean validateUser(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try {
            Connection con = Conexio.getConexio();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getUserIdByUsername(String username) {
        String sql = "SELECT id FROM Users WHERE username = ?";
        try (Connection con = Conexio.getConexio();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // usuario no encontrado
    }

}
