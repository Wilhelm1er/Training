package Swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal implements ActionListener {

	private JFrame frame = new JFrame();
	private JPanel pan = new JPanel();
	private JButton new_user = new JButton("Créer utilisateur");
	private JButton connexion = new JButton("Connexion");

	public void principal() {
		login();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Crée et active l'interface de login.
	 */
	public void login() {

		JLabel labelLogin = new JLabel("Login:");
		JTextField inputLogin = new JTextField("", 10);
		JLabel labelMdp = new JLabel("Mot de passe:");
		JTextField inputMdp = new JTextField("", 10);

		new_user.addActionListener(this);
		connexion.addActionListener(this);

		pan.add(labelLogin);
		pan.add(inputLogin);
		pan.add(labelMdp);
		pan.add(inputMdp);
		pan.add(new_user);
		pan.add(connexion);

		frame.setLayout(new BorderLayout());

		frame.add(pan);
		// Définit un titre pour notre fenêtre
		frame.setTitle("Training");
		// Définit sa taille : 400 pixels de large et 100 pixels de haut
		frame.setSize(400, 300);

		// Nous demandons maintenant à notre objet de se positionner au centre
		frame.setLocationRelativeTo(null);

	}
	/**
	 * Crée et active l'interface de training.
	 */

	public void training() {

		// Définition de sa couleur de fond
		// pan.setBackground(Color.BLACK);

		JLabel choix = new JLabel("Choix:");

		// Possibilité 1 : instanciation avec le libellé
		JButton bouton = new JButton("Mon premier bouton");

		JComboBox combo = new JComboBox();

		// Possibilité 2 : instanciation puis définition du libellé
		JButton bouton2 = new JButton();
		bouton2.setText("Mon deuxième bouton");
		pan.add(choix);
		pan.add(combo);
		pan.add(bouton);
		pan.add(bouton2);

		frame.add(pan);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == new_user) {

		}

		if (arg0.getSource() == connexion) {

		}

	}
}