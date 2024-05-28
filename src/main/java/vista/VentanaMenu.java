package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaMenu extends JFrame {
    private JPanel panelMenu;
    private JButton btnRegistrarEleccion;
    private JButton btnRegistrarCandidato;
    private JButton btnRegistrarVotante;
    private JButton btnVotar;
    private JButton btnBuscarEleccion;
    private JButton btnBuscarCandidato;

    public VentanaMenu() {
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(6, 1, 10, 10));

        btnRegistrarEleccion = new JButton("Registrar Elección");
        btnRegistrarCandidato = new JButton("Registrar Candidato");
        btnRegistrarVotante = new JButton("Registrar Votante");
        btnVotar = new JButton("Votar");
        btnBuscarEleccion = new JButton("Buscar Elección");
        btnBuscarCandidato = new JButton("Buscar Candidato");

        panelMenu.add(btnRegistrarEleccion);
        panelMenu.add(btnRegistrarCandidato);
        panelMenu.add(btnRegistrarVotante);
        panelMenu.add(btnVotar);
        panelMenu.add(btnBuscarEleccion);
        panelMenu.add(btnBuscarCandidato);

        add(panelMenu);

        btnRegistrarEleccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistrarEleccion ventanaRegistrarEleccion = null;
                try {
                    ventanaRegistrarEleccion = new VentanaRegistrarEleccion();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                ventanaRegistrarEleccion.setVisible(true);
            }
        });

        btnRegistrarCandidato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistrarEleccion ventanaRegistroCandidato = null;
                try {
                    ventanaRegistroCandidato = new VentanaRegistrarEleccion();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                ventanaRegistroCandidato.setVisible(true);
            }
        });

        btnRegistrarVotante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistroVotante ventanaRegistroVotante = null;
                try {
                    ventanaRegistroVotante = new VentanaRegistroVotante();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                ventanaRegistroVotante.setVisible(true);
            }
        });



        btnBuscarEleccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaBuscarEleccion ventanaBuscarEleccion = null;
                try {
                    ventanaBuscarEleccion = new VentanaBuscarEleccion();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                ventanaBuscarEleccion.setVisible(true);
            }
        });

        btnBuscarCandidato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaBuscarCandidato ventanaBuscarCandidato = null;
                try {
                    ventanaBuscarCandidato = new VentanaBuscarCandidato();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                ventanaBuscarCandidato.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaMenu().setVisible(true);
            }
        });
    }
}
