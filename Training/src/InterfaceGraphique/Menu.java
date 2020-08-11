package InterfaceGraphique;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {

	JMenuItem rapports = new JMenuItem("Rapports");
	JMenuItem poids = new JMenuItem("Suivi du poids");
	JMenuItem logout = new JMenuItem("Fermer la session");
	JMenuItem quitter = new JMenuItem("Quitter");
	JMenuItem renforcement = new JMenuItem("Renforcement");
	JMenuItem musculation = new JMenuItem("Musculation");
	JMenuItem gainage = new JMenuItem("Gainage");
	JMenuItem challenge = new JMenuItem("Challenge");

	private JMenu menuUser = new JMenu();

	/**
	 * Crée et active le menu.
	 */

	public JMenuBar menu() {

		JMenuBar menuBar = new JMenuBar();

		JMenu menuFichier = new JMenu("Fichier");

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

	public JMenu getMenuUser() {
		return menuUser;
	}

	public JMenuItem getQuitter() {
		return quitter;
	}

	public JMenuItem getLogout() {
		return logout;
	}

	public JMenuItem getPoids() {
		return poids;
	}

	public JMenuItem getRapports() {
		return rapports;
	}

	public JMenuItem getRenforcement() {
		return renforcement;
	}

	public JMenuItem getMusculation() {
		return musculation;
	}

	public JMenuItem getGainage() {
		return gainage;
	}

	public JMenuItem getChallenge() {
		return challenge;
	}

	public void setMenuUser(String name) {
		this.menuUser = new JMenu(name);
	}

}
