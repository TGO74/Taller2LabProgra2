package controller;

import model.Candidato;
import model.data.dao.CandidatoDAO;

import java.sql.SQLException;
import java.util.List;

public class CandidatoController {
    private CandidatoDAO candidatoDAO;

    public CandidatoController() throws SQLException, ClassNotFoundException {
        this.candidatoDAO = new CandidatoDAO();
    }

    public void agregarCandidato(Candidato candidato) {
        candidatoDAO.agregarCandidato(candidato);
    }

    public void eliminarCandidato(int id) {
        candidatoDAO.eliminarCandidato(id);
    }

    public Candidato buscarCandidatoPorId(int id) {
        return candidatoDAO.buscarCandidatoPorId(id);
    }

    public List<Candidato> listarCandidatos() {
        return candidatoDAO.listarCandidatos();
    }

    public List<Candidato> buscarCandidatosPorNombre(String valor) {

        return candidatoDAO.buscarCandidatosPorNombre(valor);

    }

    public List<Candidato> buscarCandidatosPorPartido(String valor) {

        return candidatoDAO.buscarCandidatosPorPartido(valor);

    }

    public void registrarCandidato(Candidato nuevoCandidato) {

        candidatoDAO.agregarCandidato(nuevoCandidato);
    }
}
