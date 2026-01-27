package traineeManagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class ConnectionFactory {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     ConnectionFactory.class
                             .getClassLoader()
                             .getResourceAsStream("db.properties")) {

            if (input == null) {
                throw new RuntimeException("db.properties file not found");
            }

            properties.load(input);
            Class.forName(properties.getProperty("jdbc.driver"));

        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
