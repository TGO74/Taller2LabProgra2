package model.data.dao;

import model.Candidato;
import model.data.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDAO {
    private Connection connection;

    public CandidatoDAO() throws SQLException, ClassNotFoundException {
        this.connection = DBConnector.getInstance().getConnection("elecciones", "root", "root");
    }

    public void agregarCandidato(Candidato candidato) {
        String sql = "INSERT INTO Candidato (nombreCandidato, partidoPolitico, cargoPostula) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, candidato.getNombreCandidato());
            pstmt.setString(2, candidato.getPartidoPolitico());
            pstmt.setString(3, candidato.getCargoPostula());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCandidato(int id) {
        String sql = "DELETE FROM Candidato WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Candidato buscarCandidatoPorId(int id) {
        String sql = "SELECT * FROM Candidato WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Candidato(

                        rs.getString("nombreCandidato"),
                        rs.getString("partidoPolitico"),
                        rs.getString("cargoPostula")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Candidato> listarCandidatos() {
        List<Candidato> candidatos = new ArrayList<>();
        String sql = "SELECT * FROM Candidato";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Candidato candidato = new Candidato(

                        rs.getString("nombreCandidato"),
                        rs.getString("partidoPolitico"),
                        rs.getString("cargoPostula")
                );
                candidatos.add(candidato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidatos;
    }
}
