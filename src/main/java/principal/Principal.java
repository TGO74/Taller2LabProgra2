package principal;

import vista.*;
import controller.*;

public class Principal {

    public static void main(String[] args) {
        // Prueba de la ventana de bienvenida
        VentanaMenu ventanaPrincipal = new VentanaMenu();

        // Prueba del controlador de productos


        // Prueba del controlador de clientes
        CandidatoController.metodoMostrar();

        // Prueba de la ventana de búsqueda de productos
        VentanaBuscarEleccion ventanaBuscarEleccion = new VentanaBuscarEleccion();

        // Prueba de la ventana de registro de productos
        VentanaRegistrarEleccion ventanaRegistrarEleccion = new VentanaRegistrarEleccion();

        // Prueba de la ventana de tabla genérica
        String[][] datosEjemplo = {{"1", "Producto 1", "Marca 1", "Categoría 1", "100.0"},
                {"2", "Producto 2", "Marca 2", "Categoría 2", "200.0"}};
        String[] columnasEjemplo = {"ID", "Nombre", "Marca", "Categoría", "Precio"};

        VentanaTabla ventanaTabla = new VentanaTabla(datosEjemplo, columnasEjemplo);
    }
}

