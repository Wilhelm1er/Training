package Listeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDeDonnees.PoidsBdd;
import InterfaceGraphique.InterfacePoids;
import InterfaceGraphique.InterfacePrincipale;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class PoidsActionListener implements ActionListener {

	private InterfacePoids IntPoids = new InterfacePoids();
	private PoidsBdd poids = new PoidsBdd();
	private InterfacePrincipale IntPrincipale = new InterfacePrincipale();

	/**
	 * Listeners des boutons de l'interface relative aux Poids
	 * 
	 * @param interfacePoids Référence à l'interface relative aux Poids
	 */

	public PoidsActionListener(InterfacePoids interfacePoids) {
		this.IntPoids = interfacePoids;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == IntPoids.getAjoutPoids()) {

			String p = IntPoids.getTextePoids().getText();
			try {
				double pds = Double.parseDouble(p);
				poids.ajout(IntPrincipale.getName(), pds, IntPoids.getDateS());
				IntPoids.interfacePoids();
				IntPoids.getPanelPoids().repaint();
				IntPrincipale.getFrame().revalidate();
			} catch (NumberFormatException f) {
				System.out.println(f);
			}

		}

		else if (e.getSource() == IntPoids.getDataPoidsButton()) {
			IntPoids.getPanelCenter().removeAll();
			IntPoids.getPanelCenter().add(IntPoids.getScroll());
			IntPoids.getPanelCenter().repaint();
			IntPoids.getPanelPoids().add(IntPoids.getPanelCenter(), BorderLayout.CENTER);
			IntPoids.getPanelPoids().repaint();
			IntPrincipale.getFrame().revalidate();
		}

	}
}