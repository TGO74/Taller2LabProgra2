package model.data.dao;

import model.Votante;
import model.data.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VotanteDAO {
    private Connection connection;

    public VotanteDAO() throws SQLException, ClassNotFoundException {
        this.connection = DBConnector.getInstance().getConnection("elecciones", "root", "root");
    }

    public void agregarVotante(Votante votante) {
        String sql = "INSERT INTO Votante (rutVotante, nombreVotante, contactoVotante, preferenciaPolitica) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, votante.getRutVotante());
            pstmt.setString(2, votante.getNombreVotante());
            pstmt.setString(3, votante.getContactoVotante());
            pstmt.setString(4, votante.getPreferenciaPolitica());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarVotante(String rutVotante) {
        String sql = "DELETE FROM Votante WHERE rutVotante = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, rutVotante);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Votante buscarVotantePorRut(String rutVotante) {
        String sql = "SELECT * FROM Votante WHERE rutVotante = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, rutVotante);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Votante(
                        rs.getString("rutVotante"),
                        rs.getString("nombreVotante"),
                        rs.getString("contactoVotante"),
                        rs.getString("preferenciaPolitica")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Votante> listarVotantes() {
        List<Votante> votantes = new ArrayList<>();
        String sql = "SELECT * FROM Votante";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Votante votante = new Votante(
                        rs.getString("rutVotante"),
                        rs.getString("nombreVotante"),
                        rs.getString("contactoVotante"),
                        rs.getString("preferenciaPolitica")
                );
                votantes.add(votante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return votantes;
    }

    public void registrarVotante(Votante votante) {

        agregarVotante(votante);

    }
}
