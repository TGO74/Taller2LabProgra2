package controller;

import model.Votante;
import model.data.dao.VotanteDAO;
import java.util.List;

public class VotanteController {
    private VotanteDAO votanteDAO;

    public VotanteController() {
        this.votanteDAO = new VotanteDAO();
    }

    public void agregarVotante(Votante votante) {
        votanteDAO.agregarVotante(votante);
    }

    public void eliminarVotante(String rutVotante) {
        votanteDAO.eliminarVotante(rutVotante);
    }

    public Votante buscarVotantePorRut(String rutVotante) {
        return votanteDAO.buscarVotantePorRut(rutVotante);
    }

    public List<Votante> listarVotantes() {
        return votanteDAO.listarVotantes();
    }

    public void registrarVotante(Votante votante) {

        votanteDAO.registrarVotante(votante);
    }
}
