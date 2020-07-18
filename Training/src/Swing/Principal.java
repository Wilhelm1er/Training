package Swing;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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

	public void principal() {

		// Définit un titre pour notre fenêtre
		frame.setTitle("Training");
		frame.setLayout(new BorderLayout());
		// Définit sa taille : 400 pixels de large et 100 pixels de haut
		frame.setSize(400, 300);

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

	/**
	 * Crée et active l'interface de training.
	 */

	public JPanel training() {
		JPanel panTraining = new JPanel();

		JLabel titre = new JLabel("Bienvenue dans l'appli d'entrainements automatisés:");
		// Définition de sa couleur de fond
		//panTraining.setBackground(Color.BLACK);

		JLabel choix = new JLabel("Choix:");

		// Possibilité 1 : instanciation avec le libellé
		JButton bouton = new JButton("Mon premier bouton");

		JComboBox combo = new JComboBox();

		// Possibilité 2 : instanciation puis définition du libellé
		JButton bouton2 = new JButton();
		bouton2.setText("Mon deuxième bouton");
		panTraining.add(titre);
		panTraining.add(choix);
		panTraining.add(combo);
		panTraining.add(bouton);
		panTraining.add(bouton2);

		return panTraining;

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
				System.out.println("Connexion réussie de l'utilisateur");
				frame.remove(login());
				frame.add(training());
				frame.revalidate();
			} else {
				System.out.println("Connexion échouée de l'utilisateur");
				erreur.setVisible(true);
			}
		}

	}
}