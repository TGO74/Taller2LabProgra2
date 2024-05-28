package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                VentanaRegistrarEleccion ventanaRegistrarEleccion = new VentanaRegistrarEleccion();
                ventanaRegistrarEleccion.setVisible(true);
            }
        });

        btnRegistrarCandidato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistroCandidato ventanaRegistroCandidato = new VentanaRegistroCandidato();
                ventanaRegistroCandidato.setVisible(true);
            }
        });

        btnRegistrarVotante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistroVotante ventanaRegistroVotante = new VentanaRegistroVotante();
                ventanaRegistroVotante.setVisible(true);
            }
        });

        btnVotar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaVotar ventanaVotar = new VentanaVotar();
                ventanaVotar.setVisible(true);
            }
        });

        btnBuscarEleccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaBuscarEleccion ventanaBuscarEleccion = new VentanaBuscarEleccion();
                ventanaBuscarEleccion.setVisible(true);
            }
        });

        btnBuscarCandidato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaBuscarCandidato ventanaBuscarCandidato = new VentanaBuscarCandidato();
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
