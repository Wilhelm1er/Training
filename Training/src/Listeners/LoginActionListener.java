package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Swing.Login;
import Swing.Menu;
import bdd.Utilisateur;

public class LoginActionListener implements ActionListener{
	private Utilisateur user = new Utilisateur();
	private Login l=new Login();
	private Menu menu= new Menu();

	public LoginActionListener(Login login) {
		this.l=login;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==l.getNew_user())
		{
			if (user.create_User(l.getInputLogin().getText(), l.getInputMdp().getText())) {
			} else {
				l.getErreur().setVisible(true);
			}
		}
		else if (e.getSource()==l.getConnexion())
		{
			if (user.connexion_User(l.getInputLogin().getText(), l.getInputMdp().getText())) {
				l.setName(l.getInputLogin().getText());
				menu.setMenuUser(l.getName());
				l.getFrame().getContentPane().removeAll();
				l.getFrame().setSize(600, 500);
				l.getFrame().setJMenuBar(menu.menu());
				l.getFrame().revalidate();
			} else {
				l.getErreur().setVisible(true);
			}
		}
	}
}