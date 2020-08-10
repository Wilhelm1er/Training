package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Swing.InterfacePrincipal;
import Swing.InterfaceTraining;
import Swing.Login;
import Swing.Menu;
import Swing.Principal;

public class MenuActionListener implements ActionListener{
	
	private InterfacePrincipal IntGraphique = new InterfacePrincipal();
	private Login login =new Login();
	private Principal principal = new Principal();
	private InterfaceTraining IntTraining = new InterfaceTraining();
	
	private String typeTraining;

	public MenuActionListener(InterfacePrincipal IntGraphique) {
		this.IntGraphique=IntGraphique;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==IntGraphique.getMenu().getQuitter())
		{
			System.exit(0);
		}
		else if (e.getSource()==IntGraphique.getMenu().getLogout())
		{
			
			IntGraphique.getFrame().dispose();
			
			login.login();
		}
		else if (e.getSource()==IntGraphique.getMenu().getRapports())
		{
			IntGraphique.getFrame().getContentPane().removeAll();
			principal.interfaceRapports();
			IntGraphique.getFrame().revalidate();
		}
		else if (e.getSource()==IntGraphique.getMenu().getPoids())
		{
			IntGraphique.getFrame().getContentPane().removeAll();
			principal.interfacePoids();
			IntGraphique.getFrame().revalidate();
		}
		else if (e.getSource()==IntGraphique.getMenu().getRenforcement())
		{
			typeTraining = "Renforcement";
			IntTraining.interfaceTraining("Renforcement");
			IntGraphique.getFrame().revalidate();
		}
		else if (e.getSource()==IntGraphique.getMenu().getMusculation())
		{
			typeTraining = "Musculation";
			IntTraining.interfaceTraining("Musculation");
			IntGraphique.getFrame().revalidate();
		}
		else if (e.getSource()==IntGraphique.getMenu().getGainage())
		{
			typeTraining = "Gainage";
			IntTraining.interfaceTraining("Gainage");
			IntGraphique.getFrame().revalidate();
		}
		else if (e.getSource()==IntGraphique.getMenu().getChallenge())
		{
			typeTraining = "Challenge";
			IntTraining.interfaceTraining("Challenge");
			IntGraphique.getFrame().revalidate();
		}
	}
}