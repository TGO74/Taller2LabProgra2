package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controller.EleccionController;
import model.Eleccion;

public class VentanaBuscarEleccion extends JFrame {
    private JPanel panelBuscarEleccion;
    private JTextField txtId;
    private JTextField txtNombre;
    private JButton btnBuscarPorId;
    private JButton btnBuscarPorNombre;
    private JTextArea areaResultado;
    private EleccionController eleccionController;

    public VentanaBuscarEleccion() throws SQLException, ClassNotFoundException {
        eleccionController = new EleccionController();

        setTitle("Buscar Elección");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panelBuscarEleccion = new JPanel();
        panelBuscarEleccion.setLayout(new GridLayout(6, 1, 10, 10));

        txtId = new JTextField();
        txtNombre = new JTextField();
        btnBuscarPorId = new JButton("Buscar por ID");
        btnBuscarPorNombre = new JButton("Buscar por Nombre");
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        panelBuscarEleccion.add(new JLabel("ID de la Elección:"));
        panelBuscarEleccion.add(txtId);
        panelBuscarEleccion.add(btnBuscarPorId);
        panelBuscarEleccion.add(new JLabel("Nombre de la Elección:"));
        panelBuscarEleccion.add(txtNombre);
        panelBuscarEleccion.add(btnBuscarPorNombre);

        add(panelBuscarEleccion, BorderLayout.NORTH);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEleccionPorId();
            }
        });

        btnBuscarPorNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEleccionPorNombre();
            }
        });
    }

    private void buscarEleccionPorId() {
        try {
            int id = Integer.parseInt(txtId.getText());
            Eleccion eleccion = eleccionController.buscarEleccionPorId(id);
            if (eleccion != null) {
                areaResultado.setText(eleccion.toString());
            } else {
                areaResultado.setText("Elección no encontrada.");
            }
        } catch (NumberFormatException ex) {
            areaResultado.setText("ID inválido.");
        }
    }

    private void buscarEleccionPorNombre() {
        String nombre = txtNombre.getText();
        Eleccion eleccion = eleccionController.buscarEleccionPorNombre(nombre);
        if (eleccion != null) {
            areaResultado.setText(eleccion.toString());
        } else {
            areaResultado.setText("Elección no encontrada.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new VentanaBuscarEleccion().setVisible(true);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
