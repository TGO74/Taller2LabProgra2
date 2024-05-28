package model.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBGenerator {

    public static void createSchema(Connection connection) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            // Crea la tabla
            String sql = "CREATE TABLE IF NOT EXISTS productos ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(255) NOT NULL, "
                    + "marca VARCHAR(255) NOT NULL)";
            stmt.executeUpdate(sql);
            System.out.println("Tabla 'productos' creada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla 'productos': " + e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar el Statement: " + e.getMessage());
                }
            }
        }
    }
}
