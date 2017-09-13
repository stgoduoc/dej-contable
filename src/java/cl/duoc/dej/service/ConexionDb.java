package cl.duoc.dej.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Santiago Neira <sant.neira@profesor.duoc.cl>
 */
public class ConexionDb {
    
    static Connection connection;
    
    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        if(connection != null) {
            return connection;
        }
        Properties connProperties = new Properties();
        connProperties.put("user", "root");
        connProperties.put("password", "Duocadmin2017");
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contable", connProperties);
        return connection;
    }
    
}
