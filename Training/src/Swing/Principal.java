package Swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Application.Training;
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
	private JTextArea descriptionTraining = new JTextArea(20, 30);
	private JLabel labelCorde = new JLabel("Temps de corde: ");
	private JTextField inputCorde = new JTextField("45", 10);
	private JLabel labelPause = new JLabel("Temps de pause: ");
	private JTextField inputPause = new JTextField("30", 10);
	private JLabel labelSerie = new JLabel("Nombre de série: ");
	private JTextField inputSerie = new JTextField("1", 10);
	private int dureeCorde = 45;
	private int dureePause = 30;
	private int nbreSerie = 1;
	private JLabel demarrer = new JLabel("Lancer session:");
	private JButton demarrerButton = new JButton("Démarrer");
	private String typeTraining;

	public void principal() {

		frame.getContentPane().removeAll();
		// Définit un titre pour notre fenêtre
		frame.setTitle("Training");
		frame.setLayout(new BorderLayout());
		// Définit sa taille : 400 pixels de large et 100 pixels de haut
		frame.setSize(600, 400);

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
		JPanel panelSouth = new JPanel();
		JPanel panelWest = new JPanel();
		
		JLabel labelWelcome = new JLabel("Application training");
		
		panelNorth.add(labelWelcome);
		
		panelWest.setLayout(new GridLayout(10, 1));

		inputLogin.setText("");
		inputMdp.setText("");

		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.add(panelWest, BorderLayout.WEST);

		JLabel listUser = new JLabel("Utilisateurs enregistrés: ");
		panelSouth.add(listUser);

		for (String s : user.selectAll()) {
			JLabel label = new JLabel(s);
			label.setVisible(true);
			panelSouth.add(label);
		}

		inputMdp.setEchoChar('*');
		erreur.setVisible(false);

		new_user.addActionListener(this);
		connexion.addActionListener(this);

		panelWest.add(labelLogin);
		panelWest.add(inputLogin);
		panelWest.add(labelMdp);
		panelWest.add(inputMdp);

		panelWest.add(new_user);
		panelWest.add(connexion);

		panelWest.add(erreur);

	}

	public void interfaceTraining(String type) {
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelSouth = new JPanel();

		frame.getContentPane().removeAll();
		frame.setLayout(new BorderLayout());
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelWest, BorderLayout.WEST);
		frame.add(panelSouth, BorderLayout.SOUTH);
		
		panelWest.setLayout(new GridLayout(20, 1));

		JLabel labelTraining = new JLabel(typeTraining);
		panelNorth.add(labelTraining);

		inputCorde.setHorizontalAlignment(JTextField.CENTER);

		inputPause.setHorizontalAlignment(JTextField.CENTER);

		inputSerie.setHorizontalAlignment(JTextField.CENTER);

		JLabel niveau = new JLabel("");

		if (type == "Renforcement") {
			comboNiveau.removeAllItems();
			String[] liste = { "Débutant", "Intermédiaire", "Confirmé", "Elite" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			panelWest.add(labelCorde);
			panelWest.add(inputCorde);
			panelWest.add(labelSerie);
			panelWest.add(inputSerie);
			niveau.setText("Level");
			panelWest.add(niveau);
		}
		if (type == "Musculation") {
			comboNiveau.removeAllItems();
			String[] liste = { "Numéro 1", "Numéro 2" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			panelWest.add(labelPause);
			panelWest.add(inputPause);
			panelWest.add(labelSerie);
			panelWest.add(inputSerie);
			niveau.setText("Level");
			panelWest.add(niveau);
		}
		if (type == "Gainage") {
			comboNiveau.removeAllItems();
			String[] liste = { "Numéro 1", "Numéro 2" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			panelWest.add(labelCorde);
			panelWest.add(inputCorde);
			panelWest.add(labelSerie);
			panelWest.add(inputSerie);
			niveau.setText("Routine");
			panelWest.add(niveau);
		}
		if (type == "Challenge") {
			comboNiveau.removeAllItems();
			String[] liste = { "FBI", "Pompiers" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			niveau.setText("Challenge");
			panelWest.add(niveau);
		}

		panelWest.add(comboNiveau);
		panelCenter.add(descriptionTraining);
		panelSouth.add(demarrer);
		panelSouth.add(demarrerButton);

		demarrerButton.addActionListener(this);

	}

	public JPanel interfaceRapports() {
		JPanel panel = new JPanel();
		String[] colonne = new String[] { "Date", "type", "Série", "Level", "Corde/Pause", "Temps" };
		JTable table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel(colonne, 0);

		model.setColumnIdentifiers(colonne);
		

		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(550,300));

		panel.add(scroll);

		frame.getContentPane().removeAll();
		
		DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
		custom.setHorizontalAlignment(JLabel.CENTER); // centre les données de ton tableau
		

		for (List<String> d : trainingBdd.training_Selected(name)) {
			model.addRow(new Object[] { d.get(0), d.get(1), d.get(2), d.get(3), d.get(4), d.get(5) });

		}
		table.setModel(model);

		TableColumn rope = table.getColumnModel().getColumn(4);
		rope.setCellRenderer(custom);
		rope.setPreferredWidth(40);
		TableColumn serie = table.getColumnModel().getColumn(2);
		serie.setCellRenderer(custom);
		serie.setPreferredWidth(30);
		TableColumn level = table.getColumnModel().getColumn(3);
		level.setCellRenderer(custom);
		level.setPreferredWidth(80);

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
		scroll.setPreferredSize(new Dimension(550,300));
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
		JMenuItem logout = new JMenuItem("Fermer la session");
		JMenuItem quitter = new JMenuItem("Quitter");

		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.setJMenuBar(null);
				frame.revalidate();
				name = "";
				principal();
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

		menuFichier.add(logout);
		menuFichier.add(quitter);

		JMenuItem renforcement = new JMenuItem("Renforcement");
		JMenuItem musculation = new JMenuItem("Musculation");
		JMenuItem gainage = new JMenuItem("Gainage");
		JMenuItem challenge = new JMenuItem("Challenge");

		renforcement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeTraining = "Renforcement";
				interfaceTraining("Renforcement");
				frame.revalidate();
			}
		});
		musculation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeTraining = "Musculation";
				interfaceTraining("Musculation");
				frame.revalidate();
			}
		});
		gainage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeTraining = "Gainage";
				interfaceTraining("Gainage");
				frame.revalidate();
			}
		});
		challenge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeTraining = "Challenge";
				interfaceTraining("Challenge");
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
				// System.out.println("Création réussie de l'utilisateur");
			} else {
				// System.out.println("Création échouée de l'utilisateur");
				erreur.setVisible(true);
			}
		}

		if (arg0.getSource() == connexion) {
			if (user.connexion_User(inputLogin.getText(), inputMdp.getText())) {
				// System.out.println("Connexion réussie");
				name = inputLogin.getText();
				frame.getContentPane().removeAll();
				this.menu();
				frame.revalidate();
			} else {
				// System.out.println("Connexion échouée");
				erreur.setVisible(true);
			}
		}
		if (arg0.getSource() == demarrerButton) {
			System.out.println(("type training:"+typeTraining));
			Training Training = new Training();
			String level = (String) comboNiveau.getSelectedItem();
			try {
				Application.Timer Timer_Training = new Application.Timer(Training.training(level), typeTraining, name,
						dateS, level);
			} catch (InterruptedException e) {
				System.out.println("ne fonctionne pas");
				e.printStackTrace();
			}
		}
	}

	public int getDureeCorde() {
		return dureeCorde;
	}

	public int setDureeCorde() {
		dureeCorde = Integer.parseInt(inputCorde.getText());
		return dureeCorde;
	}

	public int getDureePause() {
		return dureeCorde;
	}

	public int setDureePause() {
		dureePause = Integer.parseInt(inputPause.getText());
		return dureePause;
	}

	public int getNbreSerie() {
		return nbreSerie;
	}

	public int setNbreSerie() {
		nbreSerie = Integer.parseInt(inputSerie.getText());
		return nbreSerie;
	}

	public String getTypeTraining() {
		return typeTraining;
	}
}