package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			principal.interfaceRapports();
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getPoids()) {
			IntGraphique.getFrame().getContentPane().removeAll();
			principal.interfacePoids();
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getRenforcement()) {
			System.out.println(typeTraining);
			if(!typeTraining.equals("Renforcement")){
			typeTraining = "Renforcement";}
			System.out.println(typeTraining);
			IntTraining.interfaceTraining("Renforcement");
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getMusculation()) {
			if(!typeTraining.equals("Musculation")){
			typeTraining = "Musculation";}
			IntTraining.interfaceTraining("Musculation");
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getGainage()) {
			if(!typeTraining.equals("Gainage")){
			typeTraining = "Gainage";}
			IntTraining.interfaceTraining("Gainage");
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getChallenge()) {
			if(!typeTraining.equals("Challenge")){
			typeTraining = "Challenge";}
			IntTraining.interfaceTraining("Challenge");
			IntGraphique.getFrame().revalidate();
		}
	}
}