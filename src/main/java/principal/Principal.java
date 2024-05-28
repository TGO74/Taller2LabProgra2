package principal;

import vista.*;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crear y mostrar la ventana del menú principal
                VentanaMenu ventanaMenu = new VentanaMenu();
                ventanaMenu.setVisible(true);


            }
        });
    }
}
