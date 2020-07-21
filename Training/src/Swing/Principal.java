package Swing;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import bdd.ChallengeBdd;
import bdd.Poids;
import bdd.TrainingBdd;
import bdd.Utilisateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

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
	ChallengeBdd challengeBdd = new ChallengeBdd();
	Poids poids = new Poids();
	Date date = new Date();
	java.sql.Date dateS = new java.sql.Date(date.getTime());

	public void principal() {

		// Définit un titre pour notre fenêtre
		frame.setTitle("Training");
		frame.setLayout(new BorderLayout());
		// Définit sa taille : 400 pixels de large et 100 pixels de haut
		frame.setSize(800, 600);

		login();

		// Nous demandons maintenant à notre objet de se positionner au centre
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Crée et active l'interface de login.
	 */
	public void login() {
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();

		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);

		JLabel listUser = new JLabel("Utilisateurs enregistrés: ");
		panelNorth.add(listUser);

		for (String s : user.selectAll()) {
			JLabel label = new JLabel(s);
			label.setVisible(true);
			panelNorth.add(label);
		}

		inputMdp.setEchoChar('*');
		erreur.setVisible(false);

		new_user.addActionListener(this);
		connexion.addActionListener(this);

		panelCenter.add(labelLogin);
		panelCenter.add(inputLogin);
		panelCenter.add(labelMdp);
		panelCenter.add(inputMdp);

		panelCenter.add(new_user);
		panelCenter.add(connexion);

		panelCenter.add(erreur);

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
		panel.setSize(600, 400);
		String[] colonne = new String[] { "Date", "type", "Série", "Level", "Corde/Pause", "Temps" };
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(colonne, 0);

		model.setColumnIdentifiers(colonne);

		JScrollPane scroll = new JScrollPane(table);

		panel.add(scroll);

		frame.getContentPane().removeAll();

		for (List<String> d : trainingBdd.training_Selected(name)) {
			model.addRow(new Object[] { d.get(0), d.get(1), d.get(2), d.get(3), d.get(4), d.get(5) });

		}
		table.setModel(model);

		TableColumn rope = table.getColumnModel().getColumn(4);
		rope.setPreferredWidth(40);
		TableColumn serie = table.getColumnModel().getColumn(2);
		serie.setPreferredWidth(40);
		TableColumn level = table.getColumnModel().getColumn(3);
		level.setPreferredWidth(40);

		panel.add(scroll);

		for (String s : challengeBdd.affichageChallenge(name)) {
			JLabel label = new JLabel(s);
			label.setVisible(true);
			panel.add(label);
		}

		return panel;
	}

	public void interfacePoids() {
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();

		String[] colonne = new String[] { "Date", "Poids" };
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(colonne, 0);

		model.setColumnIdentifiers(colonne);

		JScrollPane scroll = new JScrollPane(table);

		panelCenter.add(scroll);

		frame.getContentPane().removeAll();
		frame.setLayout(new BorderLayout());
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);

		JLabel labelPoids = new JLabel("Entrer votre poids: ");
		JTextField textePoids = new JTextField(10);
		JButton buttonPoids = new JButton("Enregistrer");

		buttonPoids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ajout du poids
				String p = textePoids.getText();
				double pds = Double.parseDouble(p);
				poids.ajout(name, pds, dateS);
				interfacePoids();
				frame.revalidate();
			}
		});

		panelNorth.add(labelPoids);
		panelNorth.add(textePoids);
		panelNorth.add(buttonPoids);

		for (String d : poids.user_Selected(name).keySet()) {
			model.addRow(new Object[] { d, poids.user_Selected(name).get(d) });

		}
		table.setModel(model);
		panelCenter.add(scroll);
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
				interfacePoids();
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
				name = inputLogin.getText();
				frame.getContentPane().removeAll();
				this.menu();
				frame.revalidate();
			} else {
				System.out.println("Connexion échouée");
				erreur.setVisible(true);
			}
		}
	}
}