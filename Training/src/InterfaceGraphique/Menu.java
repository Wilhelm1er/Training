package InterfaceGraphique;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class Menu {

	JMenuItem profil = new JMenuItem("Profil");
	JMenuItem rapports = new JMenuItem("Rapports");
	JMenuItem poids = new JMenuItem("Suivi du poids");
	JMenuItem logout = new JMenuItem("Fermer la session");
	JMenuItem quitter = new JMenuItem("Quitter");
	JMenuItem renforcement = new JMenuItem("Renforcement");
	JMenuItem musculation = new JMenuItem("Musculation");
	JMenuItem gainage = new JMenuItem("Gainage");
	JMenuItem challenge = new JMenuItem("Challenge");
	JMenuItem git = new JMenuItem("Git");

	private JMenu menuUser = new JMenu();

	/**
	 * Crée et active le menu.
	 * 
	 * @return JMenuBar le menu de l'interface principale
	 */

	public JMenuBar menu() {

		JMenuBar menuBar = new JMenuBar();

		JMenu menuFichier = new JMenu("Fichier");
		JMenu menuTraining = new JMenu("Entrainement");
		JMenu help = new JMenu("Help");

		menuUser.add(profil);
		menuUser.add(rapports);
		menuUser.add(poids);

		menuFichier.add(logout);
		menuFichier.add(quitter);

		menuTraining.add(renforcement);
		menuTraining.add(musculation);
		menuTraining.add(gainage);
		menuTraining.add(challenge);
		
		help.add(git);

		menuBar.add(menuFichier);
		menuBar.add(menuUser);
		menuBar.add(menuTraining);
		menuBar.add(help);

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
	public JMenuItem getProfil() {
		return profil;
	}

	public void setProfil(JMenuItem profil) {
		this.profil = profil;
	}

	public JMenuItem getGit() {
		return git;
	}

	public void setGit(JMenuItem git) {
		this.git = git;
	}
}
