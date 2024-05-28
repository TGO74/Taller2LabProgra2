package controller;

import model.Candidato;
import model.data.dao.CandidatoDAO;
import java.util.List;

public class CandidatoController {
    private CandidatoDAO candidatoDAO;

    public CandidatoController() {
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
}
