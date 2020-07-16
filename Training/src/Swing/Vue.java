package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vue extends JFrame{

	JFrame fenetre = new JFrame();

	public void vue() {

		//Instanciation d'un objet JPanel
	    JPanel pan = new JPanel();
	    //Définition de sa couleur de fond
	    //pan.setBackground(Color.BLACK);  
	    
	    //Possibilité 1 : instanciation avec le libellé
	    JButton bouton = new JButton("Mon premier bouton");
	    
	    JComboBox combo = new JComboBox();
	    

	    //Possibilité 2 : instanciation puis définition du libellé
	    JButton bouton2 = new JButton();
	    bouton2.setText("Mon deuxième bouton");
	    pan.add(combo);
	    pan.add(bouton);
	    pan.add(bouton2);
	    
	    fenetre.setLayout(new BorderLayout());
		// Définit un titre pour notre fenêtre
		fenetre.setTitle("Training");
		// Définit sa taille : 400 pixels de large et 100 pixels de haut
		fenetre.setSize(400, 100);
		
		fenetre.setContentPane(pan);  
		
		// Nous demandons maintenant à notre objet de se positionner au centre
		fenetre.setLocationRelativeTo(null);

		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// fenetre.pack();
		fenetre.setVisible(true);
	}
	
	public void authent() {
		JPanel pan = new JPanel();
		
		JLabel login = new JLabel("Login:");
	    JTextField log_input= new JTextField("",8);
	    JLabel mdp = new JLabel("Mot de passe:");
	    JTextField mdp_input= new JTextField("",8);
	    
	    JButton new_user = new JButton("Créer utilisateur");
	    JButton connexion = new JButton("Connexion");
	    
	    pan.add(login);
	    pan.add(log_input);
	    pan.add(mdp);
	    pan.add(mdp_input);
	    pan.add(new_user);
	    pan.add(connexion);
	    
	    fenetre.setLayout(new BorderLayout());
		// Définit un titre pour notre fenêtre
		fenetre.setTitle("Training");
		// Définit sa taille : 400 pixels de large et 100 pixels de haut
		fenetre.setSize(400, 100);
		
		fenetre.setContentPane(pan);  
		
		// Nous demandons maintenant à notre objet de se positionner au centre
		fenetre.setLocationRelativeTo(null);

		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// fenetre.pack();
		fenetre.setVisible(true);
	   
	}
}
