package model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final DBConnector INSTANCE = new DBConnector();
    private static Connection connection = null;





    public static Connection getConnection(String username, String password) throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            connection = doConnection("", username, password);
        }
        return connection;
    }

    public static Connection getConnection(String db, String username, String password) throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            connection = doConnection(db, username, password);
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    private static Connection doConnection(String db, String username, String password) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL + db, username, password);
            System.out.println("Conexión creada: " + conn);
            return conn;
        } catch (SQLException e) {
            System.err.println("Error al crear la conexión: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static DBConnector getInstance() {

        return INSTANCE;
    }
}
