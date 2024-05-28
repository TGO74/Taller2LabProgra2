package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import controller.CandidatoController;
import model.Candidato;

public class VentanaBuscarCandidato extends JFrame {
    private JPanel panelBuscarCandidato;
    private JTextField txtBuscar;
    private JComboBox<String> cmbCriterio;
    private JButton btnBuscar;
    private JTable tableCandidatos;
    private DefaultTableModel tableModel;
    private CandidatoController candidatoController;

    public VentanaBuscarCandidato() throws SQLException, ClassNotFoundException {
        try {
            candidatoController = new CandidatoController();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        setTitle("Buscar Candidato");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panelBuscarCandidato = new JPanel();
        panelBuscarCandidato.setLayout(new BorderLayout());

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(1, 3, 10, 10));

        txtBuscar = new JTextField();
        cmbCriterio = new JComboBox<>(new String[]{"Nombre", "Partido Político"});
        btnBuscar = new JButton("Buscar");

        panelTop.add(txtBuscar);
        panelTop.add(cmbCriterio);
        panelTop.add(btnBuscar);

        panelBuscarCandidato.add(panelTop, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[]{"ID", "Nombre", "Partido Político", "Cargo Postula"}, 0);
        tableCandidatos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableCandidatos);

        panelBuscarCandidato.add(scrollPane, BorderLayout.CENTER);

        add(panelBuscarCandidato);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCandidato();
            }
        });
    }

    private void buscarCandidato() {
        String criterio = (String) cmbCriterio.getSelectedItem();
        String valor = txtBuscar.getText();

        List<Candidato> candidatos;
        if (criterio.equals("Nombre")) {
            candidatos = candidatoController.buscarCandidatosPorNombre(valor);
        } else {
            candidatos = candidatoController.buscarCandidatosPorPartido(valor);
        }

        actualizarTabla(candidatos);
    }

    private void actualizarTabla(List<Candidato> candidatos) {
        tableModel.setRowCount(0); // Limpiar la tabla

        for (Candidato candidato : candidatos) {
            tableModel.addRow(new Object[]{

                    candidato.getNombreCandidato(),
                    candidato.getRutCandidato(),
                    candidato.getPartidoPolitico(),
                    candidato.getCargoPostula()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new VentanaBuscarCandidato().setVisible(true);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
