package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import InterfaceGraphique.Login;
import InterfaceGraphique.InterfacePoids;
import InterfaceGraphique.InterfaceTraining;
import InterfaceGraphique.InterfacePrincipale;
import InterfaceGraphique.InterfaceRapports;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class MenuActionListener implements ActionListener {

	private InterfacePrincipale IntGraphique = new InterfacePrincipale();
	private Login login = new Login();
	private InterfaceTraining IntTraining = new InterfaceTraining();
	private InterfacePoids IntPoids = new InterfacePoids();
	private InterfaceRapports IntRapports = new InterfaceRapports();

	private String typeTraining;

	/**
	 * Listeners des boutons du menu
	 * 
	 * @param IntGraphique Référence à l'interface principale
	 */
	public MenuActionListener(InterfacePrincipale IntGraphique) {
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
			IntGraphique.getFrame().add(IntRapports.interfaceRapports());
			IntGraphique.getFrame().getContentPane().repaint();
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getPoids()) {
			IntGraphique.interfacePrincipale();
			IntGraphique.getFrame().getContentPane().removeAll();
			IntGraphique.getFrame().add(IntPoids.interfacePoids());
			IntGraphique.getFrame().getContentPane().repaint();
			IntGraphique.getFrame().revalidate();
			
		} else if (e.getSource() == IntGraphique.getMenu().getRenforcement()) {
			if(!typeTraining.equals("Renforcement")){
			typeTraining = "Renforcement";}
			IntGraphique.getFrame().getContentPane().removeAll();
			IntGraphique.getFrame().add(IntTraining.interfaceTraining("Renforcement"));
			IntGraphique.getFrame().getContentPane().repaint();
			IntGraphique.getFrame().revalidate();
			
		} else if (e.getSource() == IntGraphique.getMenu().getMusculation()) {
			if(!typeTraining.equals("Musculation")){
			typeTraining = "Musculation";}
			IntGraphique.getFrame().getContentPane().removeAll();
			IntGraphique.getFrame().add(IntTraining.interfaceTraining("Musculation"));
			IntGraphique.getFrame().getContentPane().repaint();
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getGainage()) {
			if(!typeTraining.equals("Gainage")){
			typeTraining = "Gainage";}
			IntGraphique.getFrame().getContentPane().removeAll();
			IntGraphique.getFrame().add(IntTraining.interfaceTraining("Gainage"));
			IntGraphique.getFrame().getContentPane().repaint();
			IntGraphique.getFrame().revalidate();
		} else if (e.getSource() == IntGraphique.getMenu().getChallenge()) {
			if(!typeTraining.equals("Challenge")){
			typeTraining = "Challenge";}
			IntGraphique.getFrame().getContentPane().removeAll();
			IntGraphique.getFrame().add(IntTraining.interfaceTraining("Challenge"));
			IntGraphique.getFrame().getContentPane().repaint();
			IntGraphique.getFrame().revalidate();
		}
	}
}