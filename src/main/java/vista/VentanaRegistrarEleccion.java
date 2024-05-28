package vista;

import controller.EleccionController;
import model.Eleccion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaRegistrarEleccion extends JFrame {
    private JPanel panelRegistrarEleccion;
    private JTextField txtNombreEleccion;
    private JTextField txtFechaEleccion;
    private JTextField txtLugarEleccion;
    private JTextField txtCargoElegido;
    private JTextField txtCoalicionPartido;
    private JButton btnRegistrar;
    private JButton btnCancelar;

    private EleccionController eleccionController;

    public VentanaRegistrarEleccion() throws SQLException, ClassNotFoundException {
        eleccionController = new EleccionController();

        setTitle("Registrar Nueva Elección");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panelRegistrarEleccion = new JPanel();
        panelRegistrarEleccion.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblNombreEleccion = new JLabel("Nombre de la Elección:");
        txtNombreEleccion = new JTextField();

        JLabel lblFechaEleccion = new JLabel("Fecha de la Elección:");
        txtFechaEleccion = new JTextField();

        JLabel lblLugarEleccion = new JLabel("Lugar de la Elección:");
        txtLugarEleccion = new JTextField();

        JLabel lblCargoElegido = new JLabel("Cargo Elegido:");
        txtCargoElegido = new JTextField();

        JLabel lblCoalicionPartido = new JLabel("Coalición/Partido:");
        txtCoalicionPartido = new JTextField();

        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");

        panelRegistrarEleccion.add(lblNombreEleccion);
        panelRegistrarEleccion.add(txtNombreEleccion);
        panelRegistrarEleccion.add(lblFechaEleccion);
        panelRegistrarEleccion.add(txtFechaEleccion);
        panelRegistrarEleccion.add(lblLugarEleccion);
        panelRegistrarEleccion.add(txtLugarEleccion);
        panelRegistrarEleccion.add(lblCargoElegido);
        panelRegistrarEleccion.add(txtCargoElegido);
        panelRegistrarEleccion.add(lblCoalicionPartido);
        panelRegistrarEleccion.add(txtCoalicionPartido);
        panelRegistrarEleccion.add(btnRegistrar);
        panelRegistrarEleccion.add(btnCancelar);

        add(panelRegistrarEleccion);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEleccion();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void registrarEleccion() {
        String nombre = txtNombreEleccion.getText();
        String fecha = txtFechaEleccion.getText();
        String lugar = txtLugarEleccion.getText();
        String cargo = txtCargoElegido.getText();
        String coalicion = txtCoalicionPartido.getText();

        if (nombre.isEmpty() || fecha.isEmpty() || lugar.isEmpty() || cargo.isEmpty() || coalicion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Eleccion eleccion = new Eleccion(nombre, fecha, lugar, cargo, coalicion);
        boolean registrado = eleccionController.registrarEleccion(eleccion);

        if (registrado) {
            JOptionPane.showMessageDialog(this, "Elección registrada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la elección", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
