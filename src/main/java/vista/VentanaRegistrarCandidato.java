package vista;

import javax.swing.*;
import controller.CandidatoController;
import model.Candidato;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaRegistrarCandidato extends JFrame {
    private JPanel panelRegistrarCandidato;
    private JTextField txtNombre;
    private JTextField txtPartidoPolitico;
    private JTextField txtCargoPostula;
    private JButton btnRegistrar;
    private CandidatoController candidatoController;

    public VentanaRegistrarCandidato() throws SQLException, ClassNotFoundException {
        candidatoController = new CandidatoController();

        setTitle("Registrar Candidato");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panelRegistrarCandidato = new JPanel();
        panelRegistrarCandidato.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        JLabel lblPartidoPolitico = new JLabel("Partido Político:");
        txtPartidoPolitico = new JTextField();
        JLabel lblCargoPostula = new JLabel("Cargo al que Postula:");
        txtCargoPostula = new JTextField();

        btnRegistrar = new JButton("Registrar");

        panelRegistrarCandidato.add(lblNombre);
        panelRegistrarCandidato.add(txtNombre);
        panelRegistrarCandidato.add(lblPartidoPolitico);
        panelRegistrarCandidato.add(txtPartidoPolitico);
        panelRegistrarCandidato.add(lblCargoPostula);
        panelRegistrarCandidato.add(txtCargoPostula);
        panelRegistrarCandidato.add(new JLabel()); // Espacio vacío para alinear botón
        panelRegistrarCandidato.add(btnRegistrar);

        add(panelRegistrarCandidato);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCandidato();
            }
        });
    }

    private void registrarCandidato() {
        String nombre = txtNombre.getText();
        String partidoPolitico = txtPartidoPolitico.getText();
        String cargoPostula = txtCargoPostula.getText();

        Candidato nuevoCandidato = new Candidato(nombre, partidoPolitico, cargoPostula);
        candidatoController.registrarCandidato(nuevoCandidato);

        JOptionPane.showMessageDialog(this, "Candidato registrado correctamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar campos después del registro
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtPartidoPolitico.setText("");
        txtCargoPostula.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new VentanaRegistrarCandidato().setVisible(true);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
