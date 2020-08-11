package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Swing.InterfacePoids;
import Swing.InterfacePrincipal;
import Swing.InterfaceTraining;
import Swing.Login;
import Swing.Menu;
import Swing.Principal;

public class MenuActionListener implements ActionListener {

	private InterfacePrincipal IntGraphique = new InterfacePrincipal();
	private Login login = new Login();
	private Principal principal = new Principal();
	private InterfaceTraining IntTraining = new InterfaceTraining();
	private InterfacePoids IntPoids = new InterfacePoids();

	private String typeTraining;

	public MenuActionListener(InterfacePrincipal IntGraphique) {
		this.IntGraphique = IntGraphique;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		typeTraining="";
		if (e.getSource() == IntGraphique.getMenu().getQuitter()) {
			System.exit(0);
		} else if (e.getSource() == IntGraphique.getMenu().getLogout()) {
			IntGraphique.getFrame().dispose();
			login.login();
		} else if (e.getSource() == IntGraphique.getMenu().getRapports()) {
			IntGraphique.getFrame().getContentPane().removeAll();
			IntGraphique.getFrame().revalidate();
			principal.interfaceRapports();
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getPoids()) {
			IntGraphique.getFrame().getContentPane().removeAll();
			IntGraphique.getFrame().revalidate();
			IntGraphique.getFrame().add(IntPoids.interfacePoids());
			
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getRenforcement()) {
			if(!typeTraining.equals("Renforcement")){
			typeTraining = "Renforcement";}
			IntGraphique.getFrame().getContentPane().removeAll();
			IntGraphique.getFrame().revalidate();
			IntGraphique.getFrame().add(IntTraining.interfaceTraining("Renforcement"));
			
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getMusculation()) {
			if(!typeTraining.equals("Musculation")){
			typeTraining = "Musculation";}
			IntGraphique.getFrame().getContentPane().removeAll();
			IntGraphique.getFrame().revalidate();
			IntGraphique.getFrame().add(IntTraining.interfaceTraining("Musculation"));
			
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getGainage()) {
			if(!typeTraining.equals("Gainage")){
			typeTraining = "Gainage";}
			IntGraphique.getFrame().getContentPane().removeAll();
			IntGraphique.getFrame().revalidate();
			IntGraphique.getFrame().add(IntTraining.interfaceTraining("Gainage"));
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getChallenge()) {
			if(!typeTraining.equals("Challenge")){
			typeTraining = "Challenge";}
			IntGraphique.getFrame().getContentPane().removeAll();
			IntGraphique.getFrame().revalidate();
			IntGraphique.getFrame().add(IntTraining.interfaceTraining("Challenge"));
			//IntTraining.interfaceTraining("Challenge");
			IntGraphique.getFrame().revalidate();
		}
	}
}