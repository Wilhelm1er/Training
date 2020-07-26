package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {

	private Principal first = new Principal();
	private String typeTraining;
	JMenuItem rapports = new JMenuItem("Rapports");
	JMenuItem poids = new JMenuItem("Suivi du poids");
	JMenuItem logout = new JMenuItem("Fermer la session");
	JMenuItem quitter = new JMenuItem("Quitter");

	JMenuItem renforcement = new JMenuItem("Renforcement");
	JMenuItem musculation = new JMenuItem("Musculation");
	JMenuItem gainage = new JMenuItem("Gainage");
	JMenuItem challenge = new JMenuItem("Challenge");

	/**
	 * Crée et active le menu.
	 */

	public JMenuBar menu() {

		System.out.println("nom: "+first.getName());
		typeTraining = first.getTypeTraining();

		// Menu
		JMenuBar menuBar = new JMenuBar();

		JMenu menuFichier = new JMenu("Fichier");
		JMenu menuUser = new JMenu(first.getName());
		JMenu menuTraining = new JMenu("Entrainement");

		menuUser.add(rapports);
		menuUser.add(poids);

		menuFichier.add(logout);
		menuFichier.add(quitter);

		menuTraining.add(renforcement);
		menuTraining.add(musculation);
		menuTraining.add(gainage);
		menuTraining.add(challenge);

		menuBar.add(menuFichier);
		menuBar.add(menuUser);
		menuBar.add(menuTraining);

		return menuBar;
	}

	public void menuAction() {
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first.getFrame().getContentPane().removeAll();
				first.getFrame().setJMenuBar(null);
				first.getFrame().revalidate();
				first.getFrame().setName(" ");
				first.principal();
			}
		});

		rapports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first.getFrame().getContentPane().removeAll();
				first.interfaceRapports();
				first.getFrame().revalidate();
			}
		});
		poids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first.getFrame().getContentPane().removeAll();
				first.interfacePoids();
				first.getFrame().revalidate();
			}
		});
		renforcement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeTraining = "Renforcement";
				first.interfaceTraining("Renforcement");
				first.getFrame().revalidate();
			}
		});
		musculation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeTraining = "Musculation";
				first.interfaceTraining("Musculation");
				first.getFrame().revalidate();
			}
		});
		gainage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeTraining = "Gainage";
				first.interfaceTraining("Gainage");
				first.getFrame().revalidate();
			}
		});
		challenge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeTraining = "Challenge";
				first.interfaceTraining("Challenge");
				first.getFrame().revalidate();
			}
		});
	}
}
