package main;

import java.awt.EventQueue;

import data.JdbcParticipante;
import model.Servicio;
import ui.AgregarParticipante;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AgregarParticipante(new Servicio(new JdbcParticipante()));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}
}
