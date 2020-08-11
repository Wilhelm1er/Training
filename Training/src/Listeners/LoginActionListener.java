package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDeDonnées.Utilisateur;
import InterfaceGraphique.Login;
import InterfaceGraphique.Menu;
import InterfaceGraphique.InterfacePrincipale;
/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class LoginActionListener implements ActionListener {
	private Utilisateur user = new Utilisateur();
	private InterfacePrincipale IntGraphique = new InterfacePrincipale();
	private Login l = new Login();

	/**
	 * Listeners des boutons de l'interface de login
	 * 
	 * @param login Référence a l'interface de Login
	 */
	public LoginActionListener(Login login) {
		this.l = login;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == l.getNew_user()) {
			if (user.create_User(l.getInputLogin().getText(), l.getInputMdp().getText())) {
			} else {
				l.getErreur().setVisible(true);
			}
		} else if (e.getSource() == l.getConnexion()) {
			if (user.connexion_User(l.getInputLogin().getText(), l.getInputMdp().getText())) {
				l.getFrame().dispose();
				l.setName(l.getInputLogin().getText());
				IntGraphique.setName(l.getName());
				IntGraphique.interfacePrincipale();

			} else {
				l.getErreur().setVisible(true);
			}
		}
	}
}