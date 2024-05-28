package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controller.VotanteController;
import model.Votante;

public class VentanaRegistroVotante extends JFrame {
    private JPanel panelRegistroVotante;
    private JTextField txtNombre;
    private JTextField txtRut;
    private JTextField txtContacto;
    private JTextField txtPreferenciaPolitica;
    private JButton btnRegistrar;
    private VotanteController votanteController;

    public VentanaRegistroVotante() throws SQLException, ClassNotFoundException {
        votanteController = new VotanteController();

        setTitle("Registrar Votante");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panelRegistroVotante = new JPanel();
        panelRegistroVotante.setLayout(new GridLayout(5, 2, 10, 10));

        txtNombre = new JTextField();
        txtRut = new JTextField();
        txtContacto = new JTextField();
        txtPreferenciaPolitica = new JTextField();
        btnRegistrar = new JButton("Registrar");

        panelRegistroVotante.add(new JLabel("Nombre:"));
        panelRegistroVotante.add(txtNombre);
        panelRegistroVotante.add(new JLabel("RUT:"));
        panelRegistroVotante.add(txtRut);
        panelRegistroVotante.add(new JLabel("Contacto:"));
        panelRegistroVotante.add(txtContacto);
        panelRegistroVotante.add(new JLabel("Preferencia Política:"));
        panelRegistroVotante.add(txtPreferenciaPolitica);
        panelRegistroVotante.add(new JLabel());
        panelRegistroVotante.add(btnRegistrar);

        add(panelRegistroVotante, BorderLayout.CENTER);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarVotante();
            }
        });
    }

    private void registrarVotante() {
        String nombre = txtNombre.getText();
        String rut = txtRut.getText();
        String contacto = txtContacto.getText();
        String preferenciaPolitica = txtPreferenciaPolitica.getText();

        if (nombre.isEmpty() || rut.isEmpty() || contacto.isEmpty() || preferenciaPolitica.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Votante votante = new Votante(nombre, rut, contacto, preferenciaPolitica);
            votanteController.registrarVotante(votante);
            JOptionPane.showMessageDialog(this, "Votante registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtRut.setText("");
        txtContacto.setText("");
        txtPreferenciaPolitica.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new VentanaRegistroVotante().setVisible(true);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
