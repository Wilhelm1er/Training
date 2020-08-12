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

	private InterfacePrincipale IntPrincipale = new InterfacePrincipale();
	private Login login = new Login();
	private InterfaceTraining IntTraining = new InterfaceTraining();
	private InterfacePoids IntPoids = new InterfacePoids();
	private InterfaceRapports IntRapports = new InterfaceRapports();
	private String name=login.getName();
	private String typeTraining;

	/**
	 * Listeners des boutons du menu
	 * 
	 * @param IntGraphique Référence à l'interface principale
	 */
	public MenuActionListener(InterfacePrincipale IntGraphique) {
		this.IntPrincipale = IntGraphique;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		typeTraining="";
		if (e.getSource() == IntPrincipale.getMenu().getQuitter()) {
			System.exit(0);
		} else if (e.getSource() == IntPrincipale.getMenu().getLogout()) {
			IntPrincipale.getFrame().dispose();
			login.login();
		} else if (e.getSource() == IntPrincipale.getMenu().getRapports()) {
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntRapports.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntRapports.interfaceRapports());
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();
		} else if (e.getSource() == IntPrincipale.getMenu().getPoids()) {
			//IntPrincipale.interfacePrincipale(name);
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntPoids.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntPoids.interfacePoids());
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();
			
		} else if (e.getSource() == IntPrincipale.getMenu().getRenforcement()) {
			if(!typeTraining.equals("Renforcement")){
			typeTraining = "Renforcement";}
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntTraining.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntTraining.interfaceTraining("Renforcement"));
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();
			
		} else if (e.getSource() == IntPrincipale.getMenu().getMusculation()) {
			if(!typeTraining.equals("Musculation")){
			typeTraining = "Musculation";}
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntTraining.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntTraining.interfaceTraining("Musculation"));
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();
		} else if (e.getSource() == IntPrincipale.getMenu().getGainage()) {
			if(!typeTraining.equals("Gainage")){
			typeTraining = "Gainage";}
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntTraining.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntTraining.interfaceTraining("Gainage"));
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();
		} else if (e.getSource() == IntPrincipale.getMenu().getChallenge()) {
			if(!typeTraining.equals("Challenge")){
			typeTraining = "Challenge";}
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntTraining.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntTraining.interfaceTraining("Challenge"));
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();
		}
	}
}