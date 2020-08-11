package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import InterfaceGraphique.Login;
import InterfaceGraphique.Menu;
import InterfaceGraphique.InterfacePrincipal;
import bdd.Utilisateur;

public class LoginActionListener implements ActionListener {
	private Utilisateur user = new Utilisateur();
	private InterfacePrincipal IntGraphique = new InterfacePrincipal();
	private Login l = new Login();
	private Menu menu = new Menu();

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
				IntGraphique.InterfaceGraphique();

			} else {
				l.getErreur().setVisible(true);
			}
		}
	}
}