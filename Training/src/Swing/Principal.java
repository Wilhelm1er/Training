package Swing;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bdd.ChallengeBdd;
import bdd.Poids;
import bdd.TrainingBdd;
import bdd.Utilisateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal implements ActionListener {

	private JFrame frame = new JFrame();

	private JButton new_user = new JButton("Créer utilisateur");
	private JButton connexion = new JButton("Connexion");
	private JLabel erreur = new JLabel("Erreur, utilisateur inconnu ou mot de passe erroné");
	private JTextField inputLogin = new JTextField("", 10);
	private JPasswordField inputMdp = new JPasswordField("", 10);
	private Utilisateur user = new Utilisateur();
	private JLabel labelLogin = new JLabel("Login:");
	private JLabel labelMdp = new JLabel("Mot de passe:");
	private JComboBox<String> comboNiveau = new JComboBox<String>();
	private String name = "";
	TrainingBdd trainingBdd = new TrainingBdd();
	ChallengeBdd challengeBdd=new ChallengeBdd();
	Poids poids = new Poids();

	public void principal() {

		// Définit un titre pour notre fenêtre
		frame.setTitle("Training");
		frame.setLayout(new BorderLayout());
		// Définit sa taille : 400 pixels de large et 100 pixels de haut
		frame.setSize(800, 500);

		frame.add(login());

		// Nous demandons maintenant à notre objet de se positionner au centre
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Crée et active l'interface de login.
	 */
	public JPanel login() {
		JPanel panLogin = new JPanel();

		inputMdp.setEchoChar('*');
		erreur.setVisible(false);

		new_user.addActionListener(this);
		connexion.addActionListener(this);

		panLogin.add(labelLogin);
		panLogin.add(inputLogin);
		panLogin.add(labelMdp);
		panLogin.add(inputMdp);

		panLogin.add(new_user);
		panLogin.add(connexion);

		panLogin.add(erreur);

		return panLogin;
	}

	public JPanel interfaceTraining(String type) {
		JPanel panel = new JPanel();
		
		frame.getContentPane().removeAll();

		JLabel niveau = new JLabel("");
		
		if (type == "Renforcement") {
			comboNiveau.removeAllItems();
			String[] liste = { "Débutant", "Intermédiaire", "Confirmé", "Elite" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			niveau.setText("Level");
			panel.add(niveau);
		}
		if (type == "Musculation") {
			comboNiveau.removeAllItems();
			String[] liste = { "Numéro 1", "Numéro 2" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			niveau.setText("Level");
			panel.add(niveau);
		}
		if (type == "Gainage") {
			comboNiveau.removeAllItems();
			String[] liste = { "Numéro 1", "Numéro 2" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			niveau.setText("Routine");
			panel.add(niveau);
		}
		if (type == "Challenge") {
			comboNiveau.removeAllItems();
			String[] liste = { "FBI", "Pompiers" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			niveau.setText("Challenge");
			panel.add(niveau);
		}

		panel.add(comboNiveau);

		return panel;
	}
	public JPanel interfaceRapports() {
		JPanel panel = new JPanel();
		
		frame.getContentPane().removeAll();

		for(String s:trainingBdd.training_Selected(name)) {
			JLabel label = new JLabel(s);
			   label.setVisible(true);
			   panel.add(label);
		}
		for(String s:challengeBdd.affichageChallenge(name)) {
			JLabel label = new JLabel(s);
			   label.setVisible(true);
			   panel.add(label);
		}
		System.out.println(" ");
		System.out.println("Affichage Rapports");
		System.out.println(" ");


		return panel;
	}
	public JPanel interfacePoids() {
		JPanel panel = new JPanel();
		
		frame.getContentPane().removeAll();

		for(String s:poids.user_Selected(name)) {
			JLabel label = new JLabel(s);
			   label.setVisible(true);
			   panel.add(label);
		}
		System.out.println(" ");
		System.out.println("Affichage poids");
		System.out.println(" ");

		return panel;
	}

	/**
	 * Crée et active le menu.
	 */

	public void menu() {
		// Menu
		JMenuBar menuBar = new JMenuBar();

		JMenu menuFichier = new JMenu("Fichier");
		JMenu menuUser = new JMenu(name);
		JMenu menuTraining = new JMenu("Entrainement");

		JMenuItem rapports = new JMenuItem("Rapports");
		JMenuItem poids = new JMenuItem("Suivi du poids");
		JMenuItem quitter = new JMenuItem("Quitter");

		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		rapports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.add(interfaceRapports());
				frame.revalidate();
			}
		});
		poids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.add(interfacePoids());
				frame.revalidate();
			}
		});
		menuUser.add(rapports);
		menuUser.add(poids);
		
		menuFichier.add(quitter);

		JMenuItem renforcement = new JMenuItem("Renforcement");
		JMenuItem musculation = new JMenuItem("Musculation");
		JMenuItem gainage = new JMenuItem("Gainage");
		JMenuItem challenge = new JMenuItem("Challenge");

		renforcement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.add(interfaceTraining("Renforcement"));
				frame.revalidate();
			}
		});
		musculation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.add(interfaceTraining("Musculation"));
				frame.revalidate();
			}
		});
		gainage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.add(interfaceTraining("Gainage"));
				frame.revalidate();
			}
		});
		challenge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.add(interfaceTraining("Challenge"));
				frame.revalidate();
			}
		});

		menuTraining.add(renforcement);
		menuTraining.add(musculation);
		menuTraining.add(gainage);
		menuTraining.add(challenge);

		menuBar.add(menuFichier);
		menuBar.add(menuUser);
		menuBar.add(menuTraining);

		frame.setJMenuBar(menuBar);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == new_user) {
			if (user.create_User(inputLogin.getText(), inputMdp.getText())) {
				System.out.println("Création réussie de l'utilisateur");
			} else {
				System.out.println("Création échouée de l'utilisateur");
				erreur.setVisible(true);
			}
		}

		if (arg0.getSource() == connexion) {
			if (user.connexion_User(inputLogin.getText(), inputMdp.getText())) {
				System.out.println("Connexion réussie");
				name=inputLogin.getText();
				frame.remove(login());
				this.menu();
				frame.revalidate();
			} else {
				System.out.println("Connexion échouée");
				erreur.setVisible(true);
			}
		}
	}
}