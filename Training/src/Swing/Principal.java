package Swing;

import java.awt.BorderLayout;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

	public JPanel InterfaceTraining() {
		/**
		 * Crée et active l'interface de training.
		 */
		JPanel panel= new JPanel();
		
			JLabel niveau = new JLabel("niveau");
			panel.add(niveau);
			
			String[] liste={"Débutant","Intermédiaire","Confirmé","Elite"};
			JComboBox niveauCB = new JComboBox(liste);
			panel.add(niveauCB);
			
			return panel;
		}
	/**
	 * Crée et active le menu.
	 */

	public void menu() {
		// Menu
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu1 = new JMenu("Fichier");
		JMenu menu2 = new JMenu("Entrainement");
		
		JMenuItem rapports = new JMenuItem("Rapports");
		JMenuItem poids = new JMenuItem("Suivi du poids");
		JMenuItem quitter = new JMenuItem(new QuitterAction("Quitter"));
		
		menu1.add(rapports);
		menu1.add(poids);
		menu1.add(quitter);
		
		JMenuItem renforcement = new JMenuItem(new RenforcementAction("Renforcement"));
		JMenuItem musculation = new JMenuItem("Musculation");
		JMenuItem gainage = new JMenuItem("Gainage");
		JMenuItem challenge = new JMenuItem("Challenge");
		
		menu2.add(renforcement);
		menu2.add(musculation);
		menu2.add(gainage);
		menu2.add(challenge);
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		
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
				frame.remove(login());
				this.menu();
				frame.revalidate();
			} else {
				System.out.println("Connexion échouée");
				erreur.setVisible(true);
			}
		}
	}
	public class RenforcementAction extends AbstractAction {
		public RenforcementAction(String texte){
			super(texte);
		}
	 
		public void actionPerformed(ActionEvent e) { 
			frame.add(InterfaceTraining());
		} 
	}
	
	public class QuitterAction extends AbstractAction {
		public QuitterAction(String texte){
			super(texte);
		}
	 
		public void actionPerformed(ActionEvent e) { 
			System.exit(0);
		} 
	}
}