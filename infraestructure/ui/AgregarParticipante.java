package ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import portsin.DomainException;
import portsin.ParticipanteRecord;
import portsin.RegistroParticipante;
import portsout.InfraestructuraException;

public class AgregarParticipante extends JFrame {

	private RegistroParticipante registroParticipante;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;

	public AgregarParticipante(RegistroParticipante registro) throws SQLException {
		this.registroParticipante = registro;
		setupUIComponents();
	}

	private void setupUIComponents() {
		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nombre = new JTextField(10);
		this.telefono = new JTextField(10);
		this.region = new JTextField(10);
		this.nombre.setText("");

		this.telefono.setText("");
		this.region.setText("China");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);
		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					onBotonCargar();
				} catch (SQLException e1) {
					throw new RuntimeException(e1);
				}
			}
		});
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

	private void onBotonCargar() throws SQLException {

		try {
			registroParticipante
					.registrar(new ParticipanteRecord(nombre.getText(), telefono.getText(), region.getText()));
		} catch (DomainException | InfraestructuraException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		dispose();
	}

}
