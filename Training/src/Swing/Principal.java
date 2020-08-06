package Swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Application.Challenge;
import Application.Chrono;
import Application.Training;
import bdd.ChallengeBdd;
import bdd.Poids;
import bdd.TrainingBdd;
import bdd.Utilisateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Principal {

	private JFrame window = new JFrame();
	private Utilisateur user = new Utilisateur();
	private JButton new_user = new JButton("Créer utilisateur");
	private JButton connexion = new JButton("Connexion");
	private JTextField inputLogin = new JTextField("", 8);
	private JPasswordField inputMdp = new JPasswordField("", 8);
	private JLabel erreur = new JLabel("Erreur, utilisateur inconnu ou mot de passe erroné");

	private JComboBox<String> comboNiveau = new JComboBox<String>();
	private String name = "";
	private TrainingBdd trainingBdd = new TrainingBdd();
	private ChallengeBdd challengeBdd = new ChallengeBdd();
	private Poids poids = new Poids();
	private Date date = new Date();
	private Challenge challenge = new Challenge();

	private java.sql.Date dateS = new java.sql.Date(date.getTime());
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
	private JScrollPane scrollChallenge;
	private JScrollPane scrollTraining;
	private JPanel panelData = new JPanel();
	private JPanel panelNorthChoix = new JPanel();
	private JPanel panelCenterTRaining = new JPanel();

	public void principal() {

		window.getContentPane().removeAll();
		// Définit un titre pour notre fenêtre
		window.setTitle("Training");
		window.setLayout(new BorderLayout());
		// Définit sa taille : 400 pixels de large et 100 pixels de haut
		window.setSize(300, 300);

		login();

		// Nous demandons maintenant à notre objet de se positionner au centre
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	/**
	 * Crée et active l'interface de login.
	 */
	public void login() {
		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		JPanel panelCenter = new JPanel();
		// Menu menu = new Menu();

		JLabel labelLogin = new JLabel("Login:");
		JLabel labelMdp = new JLabel("Mot de passe:");
		inputLogin.setSize(10, 20);
		inputMdp.setSize(10, 20);

		new_user.setSize(10, 20);
		connexion.setSize(10, 20);

		new_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.create_User(inputLogin.getText(), inputMdp.getText())) {
				} else {
					erreur.setVisible(true);
				}
			}
		});
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.connexion_User(inputLogin.getText(), inputMdp.getText())) {
					name = inputLogin.getText();
					window.getContentPane().removeAll();
					window.setSize(600, 500);
					menu();
					window.revalidate();
				} else {
					erreur.setVisible(true);
				}
			}
		});

		labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		labelMdp.setHorizontalAlignment(SwingConstants.CENTER);
		inputMdp.setHorizontalAlignment(SwingConstants.CENTER);
		inputLogin.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel labelWelcome = new JLabel("Application training");

		panelNorth.add(labelWelcome);

		panelCenter.setLayout(new GridLayout(6, 1));
		panelSouth.setLayout(new GridLayout(6, 1));

		inputLogin.setText("");
		inputMdp.setText("");

		window.add(panelSouth, BorderLayout.SOUTH);
		window.add(panelCenter, BorderLayout.CENTER);

		JLabel listUser = new JLabel("Utilisateurs connus: ");
		listUser.setHorizontalAlignment(SwingConstants.CENTER);
		panelSouth.add(listUser);

		for (String s : user.selectAll()) {
			JLabel label = new JLabel(s);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setVisible(true);
			panelSouth.add(label);
		}

		inputMdp.setEchoChar('*');
		erreur.setVisible(false);

		// UTILITE?
		InputMap im = connexion.getInputMap();
		im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
		im.put(KeyStroke.getKeyStroke("released ENTER"), "released");

		window.getRootPane().setDefaultButton(connexion);

		panelCenter.add(labelLogin);
		panelCenter.add(inputLogin);
		panelCenter.add(labelMdp);
		panelCenter.add(inputMdp);

		panelCenter.add(new_user);
		panelCenter.add(connexion);

		panelCenter.add(erreur);

	}

	public void interfaceTraining(String type) {
		JPanel panelNorth = new JPanel();

		JPanel panelWest = new JPanel();
		JPanel panelSouth = new JPanel();

		window.getContentPane().removeAll();
		window.setSize(600, 500);
		window.setLayout(new BorderLayout());
		window.add(panelNorth, BorderLayout.NORTH);
		window.add(panelCenterTRaining, BorderLayout.CENTER);
		window.add(panelWest, BorderLayout.WEST);
		window.add(panelSouth, BorderLayout.SOUTH);

		panelWest.setLayout(new GridLayout(20, 1));

		JLabel labelTraining = new JLabel(typeTraining);
		panelNorth.add(labelTraining);

		inputCorde.setHorizontalAlignment(JTextField.CENTER);

		inputPause.setHorizontalAlignment(JTextField.CENTER);

		inputSerie.setHorizontalAlignment(JTextField.CENTER);

		JLabel niveau = new JLabel("");

		if (type == "Renforcement") {
			comboNiveau.removeAllItems();
			comboNiveau.setSelectedItem("Choix");
			String[] liste = { "Choix", "Débutant", "Intermédiaire", "Confirmé", "Elite" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			// panelCenter.add(descriptionTraining);
			panelWest.add(labelCorde);
			panelWest.add(inputCorde);
			panelWest.add(labelSerie);
			panelWest.add(inputSerie);
			niveau.setText("Level");
			panelWest.add(niveau);

		}
		if (type == "Musculation") {
			comboNiveau.removeAllItems();
			comboNiveau.setSelectedItem("Choix");
			String[] liste = { "Choix", "Numéro 1", "Numéro 2" };
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
			comboNiveau.setSelectedItem("Choix");
			String[] liste = { "Choix", "Routine 1", "Routine 2" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}

			// panelWest.add(labelCorde);
			// panelWest.add(inputCorde);
			panelWest.add(labelSerie);
			panelWest.add(inputSerie);
			niveau.setText("Routine");
			panelWest.add(niveau);

		}
		if (type == "Challenge") {
			comboNiveau.removeAllItems();
			comboNiveau.setSelectedItem("Choix");
			String[] liste = { "Choix", "FBI", "Pompiers" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}

			niveau.setText("Challenge");
			panelWest.add(niveau);

		}

		panelWest.add(comboNiveau);

		panelSouth.add(demarrer);
		panelSouth.add(demarrerButton);
		panelCenterTRaining.add(descriptionTraining);

		demarrerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Training Training = new Training();
				String level = (String) comboNiveau.getSelectedItem();
				try {
					if (typeTraining.equals("Challenge")) {
						if (level.equals("Pompiers")) {
							// frame.add(new Chrono(211));
							challenge.startChallenge(name, dateS, level);
						}
						if (level.equals("FBI")) {
							// frame.add(new Chrono(292));
							challenge.startChallenge(name, dateS, level);
						}

					} else {
						Application.Timer Timer_Training = new Application.Timer(Training.training(typeTraining, level),
								typeTraining, name, dateS, level);
					}
				} catch (InterruptedException f) {
					System.out.println("ne fonctionne pas");
					f.printStackTrace();
				}
			}
		});

		comboNiveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Training T = new Training();
				String level = (String) comboNiveau.getSelectedItem();

				descriptionTraining.setText(T.affichageTraining(level));
				window.revalidate();
			}
		});
	}

	public void interfaceRapports() {
		panelData.removeAll();
		JPanel panelNorthChoix = new JPanel();
		JButton trainingButton = new JButton("Training");
		JButton challengeButton = new JButton("Challenge");

		window.getContentPane().removeAll();

		window.setLayout(new BorderLayout());
		window.add(panelNorthChoix, BorderLayout.NORTH);

		// panelWest.setLayout(new GridLayout(20,1));

		panelNorthChoix.add(trainingButton);
		panelNorthChoix.add(challengeButton);

		challengeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelData.removeAll();
				panelData.add(scrollChallenge);
				panelData.repaint();
				window.add(panelData, BorderLayout.CENTER);
				window.revalidate();
			}
		});
		trainingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelData.removeAll();
				panelData.add(scrollTraining);
				panelData.repaint();
				window.add(panelData, BorderLayout.CENTER);
				window.revalidate();
			}
		});

		String[] colTraining = new String[] { "Date", "type", "Série", "Level", "Corde/Pause", "Temps" };
		JTable tableTraining = new JTable();

		DefaultTableModel modelTraining = new DefaultTableModel(colTraining, 0);

		modelTraining.setColumnIdentifiers(colTraining);

		scrollTraining = new JScrollPane(tableTraining);
		scrollTraining.setPreferredSize(new Dimension(500, 300));

		// panel.add(scrollTraining);

		DefaultTableCellRenderer custom = new DefaultTableCellRenderer();
		custom.setHorizontalAlignment(JLabel.CENTER); // centre les données de ton tableau

		for (List<String> d : trainingBdd.affichageTraining(name)) {
			modelTraining.addRow(new Object[] { d.get(0), d.get(1), d.get(2), d.get(3), d.get(4), d.get(5) });

		}
		tableTraining.setModel(modelTraining);

		TableColumn rope = tableTraining.getColumnModel().getColumn(4);
		rope.setCellRenderer(custom);
		rope.setPreferredWidth(40);
		TableColumn serie = tableTraining.getColumnModel().getColumn(2);
		serie.setCellRenderer(custom);
		serie.setPreferredWidth(30);
		TableColumn level = tableTraining.getColumnModel().getColumn(3);
		level.setCellRenderer(custom);
		level.setPreferredWidth(80);

		// panel.add(scrollTraining);

		String[] colChallenge = new String[] { "Date", "Challenge", "Temps", "Terminé" };
		JTable tableChallenge = new JTable();

		DefaultTableModel modelChallenge = new DefaultTableModel(colChallenge, 0);

		modelChallenge.setColumnIdentifiers(colChallenge);

		scrollChallenge = new JScrollPane(tableChallenge);
		scrollChallenge.setPreferredSize(new Dimension(500, 300));

		for (List<String> d : challengeBdd.affichageChallenge(name)) {
			modelChallenge.addRow(new Object[] { d.get(0), d.get(1), d.get(2), d.get(3) });
		}
		tableChallenge.setModel(modelChallenge);

		// panel.add(scrollChallenge);

	}

	public void interfacePoids() {

		panelData.removeAll();
		panelNorthChoix.removeAll();
		window.getContentPane().removeAll();

		JButton dataPoidsButton = new JButton("Données");
		panelNorthChoix.add(dataPoidsButton);

		window.setLayout(new BorderLayout());
		window.add(panelNorthChoix, BorderLayout.NORTH);
		window.add(panelData, BorderLayout.CENTER);

		String[] colonne = new String[] { "Date", "Poids" };
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(colonne, 0);

		model.setColumnIdentifiers(colonne);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(550, 300));

		JLabel labelPoids = new JLabel("Entrer votre poids: ");
		JTextField textePoids = new JTextField(10);
		JButton ajoutPoids = new JButton("Enregistrer");

		ajoutPoids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ajout du poids
				String p = textePoids.getText();
				try {
					double pds = Double.parseDouble(p);
					poids.ajout(name, pds, dateS);
					interfacePoids();
					window.revalidate();
				} catch (NumberFormatException f) {
					System.out.println(f);
				}

			}

		});
		dataPoidsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelData.removeAll();
				panelData.add(scroll);
				panelData.repaint();
				window.add(panelData, BorderLayout.CENTER);
				window.revalidate();
			}
		});

		panelNorthChoix.add(labelPoids);
		panelNorthChoix.add(textePoids);
		panelNorthChoix.add(ajoutPoids);

		for (String d : poids.user_Selected(name).keySet()) {
			model.addRow(new Object[] { d, poids.user_Selected(name).get(d) });

		}
		table.setModel(model);
	}

	public void menu() { // Menu
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
				window.getContentPane().removeAll();
				window.setJMenuBar(null);
				window.revalidate();
				name = "";
				principal();
			}
		});

		rapports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.getContentPane().removeAll();
				interfaceRapports();
				window.revalidate();
			}
		});
		poids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.getContentPane().removeAll();
				interfacePoids();
				window.revalidate();
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
				window.revalidate();
			}
		});
		musculation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeTraining = "Musculation";
				interfaceTraining("Musculation");
				window.revalidate();
			}
		});
		gainage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeTraining = "Gainage";
				interfaceTraining("Gainage");
				window.revalidate();
			}
		});
		challenge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeTraining = "Challenge";
				interfaceTraining("Challenge");
				window.revalidate();
			}
		});

		menuTraining.add(renforcement);
		menuTraining.add(musculation);
		menuTraining.add(gainage);
		menuTraining.add(challenge);

		menuBar.add(menuFichier);
		menuBar.add(menuUser);
		menuBar.add(menuTraining);

		window.setJMenuBar(menuBar);
	}

	public void processTraining(int time) {
		JLabel timer = new JLabel();
		// panelCenterTRaining
		for (int i = 0; i < time; i--) {
			time--;
			timer.setText(String.valueOf(time));
			window.revalidate();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public JFrame getFrame() {
		return window;
	}
}