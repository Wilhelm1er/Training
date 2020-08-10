package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Swing.InterfaceTraining;
import Swing.Login;
import Swing.Menu;
import Swing.Principal;

public class MenuActionListener implements ActionListener{
	
	private Login login =new Login();
	private Principal principal = new Principal();
	private Menu menu= new Menu();
	private InterfaceTraining IntTraining = new InterfaceTraining();
	
	private String typeTraining;

	public MenuActionListener(Menu menu) {
		this.menu=menu;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==menu.getQuitter())
		{
			System.exit(0);
		}
		else if (e.getSource()==menu.getLogout())
		{
			login.getFrame().getContentPane().removeAll();
			login.getFrame().setJMenuBar(null);
			login.getFrame().revalidate();
			login.getFrame().setName(" ");
			login.login();
		}
		else if (e.getSource()==menu.getRapports())
		{
			login.getFrame().getContentPane().removeAll();
			principal.interfaceRapports();
			login.getFrame().revalidate();
		}
		else if (e.getSource()==menu.getPoids())
		{
			login.getFrame().getContentPane().removeAll();
			principal.interfacePoids();
			login.getFrame().revalidate();
		}
		else if (e.getSource()==menu.getRenforcement())
		{
			typeTraining = "Renforcement";
			IntTraining.interfaceTraining("Renforcement");
			login.getFrame().revalidate();
		}
		else if (e.getSource()==menu.getMusculation())
		{
			typeTraining = "Musculation";
			IntTraining.interfaceTraining("Musculation");
			login.getFrame().revalidate();
		}
		else if (e.getSource()==menu.getGainage())
		{
			typeTraining = "Gainage";
			IntTraining.interfaceTraining("Gainage");
			login.getFrame().revalidate();
		}
		else if (e.getSource()==menu.getChallenge())
		{
			typeTraining = "Challenge";
			IntTraining.interfaceTraining("Challenge");
			login.getFrame().revalidate();
		}
	}
}