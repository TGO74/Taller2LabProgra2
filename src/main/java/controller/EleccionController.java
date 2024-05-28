package controller;

import model.Eleccion;
import model.data.dao.EleccionDAO;

import java.sql.SQLException;
import java.util.List;

public class EleccionController {
    private EleccionDAO eleccionDAO;

    public EleccionController() throws SQLException, ClassNotFoundException {
        this.eleccionDAO = new EleccionDAO();
    }

    public void agregarEleccion(Eleccion eleccion) {
        eleccionDAO.agregarEleccion(eleccion);
    }

    public void eliminarEleccion(String nombreEleccion) {
        eleccionDAO.eliminarEleccion(nombreEleccion);
    }

    public Eleccion buscarEleccionPorNombre(String nombreEleccion) {
        return eleccionDAO.buscarEleccionPorNombre(nombreEleccion);
    }

    public List<Eleccion> buscarEleccionesPorCargo(String cargoElegido) {
        return eleccionDAO.buscarEleccionesPorCargo(cargoElegido);
    }

    public List<Eleccion> listarElecciones() {
        return eleccionDAO.listarElecciones();
    }
}

