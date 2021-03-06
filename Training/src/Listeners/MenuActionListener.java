package Listeners;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import InterfaceGraphique.Login;
import InterfaceGraphique.InterfacePoids;
import InterfaceGraphique.InterfaceTraining;
import InterfaceGraphique.InterfacePrincipale;
import InterfaceGraphique.InterfaceProfil;
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
	private InterfaceProfil IntProfil = new InterfaceProfil();
	private String name = login.getName();
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
		typeTraining = "";
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
		} else if (e.getSource() == IntPrincipale.getMenu().getProfil()) {
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntProfil.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntProfil.interfaceProfil());
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();
		} else if (e.getSource() == IntPrincipale.getMenu().getPoids()) {
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntPoids.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntPoids.interfacePoids());
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();

		} else if (e.getSource() == IntPrincipale.getMenu().getRenforcement()) {
			if (!typeTraining.equals("Renforcement")) {
				typeTraining = "Renforcement";
			}
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntTraining.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntTraining.interfaceTraining("Renforcement"));
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();

		} else if (e.getSource() == IntPrincipale.getMenu().getMusculation()) {
			if (!typeTraining.equals("Musculation")) {
				typeTraining = "Musculation";
			}
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntTraining.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntTraining.interfaceTraining("Musculation"));
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();
		} else if (e.getSource() == IntPrincipale.getMenu().getGainage()) {
			if (!typeTraining.equals("Gainage")) {
				typeTraining = "Gainage";
			}
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntTraining.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntTraining.interfaceTraining("Gainage"));
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();
		} else if (e.getSource() == IntPrincipale.getMenu().getChallenge()) {
			if (!typeTraining.equals("Challenge")) {
				typeTraining = "Challenge";
			}
			IntPrincipale.getFrame().getContentPane().removeAll();
			IntTraining.setName(IntPrincipale.getName());
			IntPrincipale.getFrame().add(IntTraining.interfaceTraining("Challenge"));
			IntPrincipale.getFrame().getContentPane().repaint();
			IntPrincipale.getFrame().revalidate();
		}
		else if (e.getSource() == IntPrincipale.getMenu().getGit()) {
			
	            try {
					Desktop.getDesktop().browse(new URI("https://github.com/Wilhelm1er/Training"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
}