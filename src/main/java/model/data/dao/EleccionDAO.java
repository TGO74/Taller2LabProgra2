package model.data.dao;

import model.Eleccion;
import model.data.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EleccionDAO {
    private Connection connection;

    public EleccionDAO() throws SQLException, ClassNotFoundException {
        this.connection = DBConnector.getInstance().getConnection("elecciones", "root", "root");
    }

    public void agregarEleccion(Eleccion eleccion) {
        String sql = "INSERT INTO Eleccion (nombreEleccion, fechaEleccion, lugarEleccion, cargoElegido, coalicionPartido) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, eleccion.getNombreEleccion());
            pstmt.setDate(2, new Date(eleccion.getFechaEleccion().getTime()));
            pstmt.setString(3, eleccion.getLugarEleccion());
            pstmt.setString(4, eleccion.getCargoElegido());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEleccion(String nombreEleccion) {
        String sql = "DELETE FROM Eleccion WHERE nombreEleccion = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombreEleccion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Eleccion buscarEleccionPorNombre(String nombreEleccion) {
        String sql = "SELECT * FROM Eleccion WHERE nombreEleccion = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombreEleccion);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Eleccion(
                        rs.getString("nombreEleccion"),
                        rs.getDate("fechaEleccion"),
                        rs.getString("lugarEleccion"),
                        rs.getString("cargoElegido"),
                        rs.getString("coalicionPartido"),
                        new ArrayList<>() // Debería tener lógica para obtener los candidatos
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Eleccion> buscarEleccionesPorCargo(String cargoElegido) {
        List<Eleccion> elecciones = new ArrayList<>();
        String sql = "SELECT * FROM Eleccion WHERE cargoElegido = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cargoElegido);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Eleccion eleccion = new Eleccion(
                        rs.getString("nombreEleccion"),
                        rs.getDate("fechaEleccion"),
                        rs.getString("lugarEleccion"),
                        rs.getString("cargoElegido"),
                        rs.getString("coalicionPartido"),
                        new ArrayList<>() // Debería tener lógica para obtener los candidatos
                );
                elecciones.add(eleccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return elecciones;
    }

    public List<Eleccion> registrarElecciones() {
        List<Eleccion> elecciones = new ArrayList<>();
        String sql = "SELECT * FROM Eleccion";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Eleccion eleccion = new Eleccion(
                        rs.getString("nombreEleccion"),
                        rs.getDate("fechaEleccion"),
                        rs.getString("lugarEleccion"),
                        rs.getString("cargoElegido"),
                        rs.getString("coalicionPartido"),
                        new ArrayList<>() // Debería tener lógica para obtener los candidatos
                );
                elecciones.add(eleccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return elecciones;
    }


    public Eleccion buscarEleccionPorId(int id) {

        return null;


    }
}
