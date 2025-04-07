package iespoblenou.org.projecte2_fase0.Model;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexio {
    public static Connection getConexio() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/bbdd");
            Connection conn = dataSource.getConnection();
            return conn;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        }
    }

}
