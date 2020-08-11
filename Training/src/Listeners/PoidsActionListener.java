package Listeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDeDonnées.PoidsBdd;
import InterfaceGraphique.InterfacePoids;
import InterfaceGraphique.InterfacePrincipal;

public class PoidsActionListener implements ActionListener {

	private InterfacePoids IntPoids = new InterfacePoids();
	private PoidsBdd poids = new PoidsBdd();
	private InterfacePrincipal IntGraphique = new InterfacePrincipal();

	public PoidsActionListener(InterfacePoids interfacePoids) {
		this.IntPoids = interfacePoids;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == IntPoids.getAjoutPoids()) {

			String p = IntPoids.getTextePoids().getText();
			try {
				double pds = Double.parseDouble(p);
				poids.ajout(IntGraphique.getName(), pds, IntPoids.getDateS());
				IntPoids.interfacePoids();
				IntPoids.getPanelPoids().repaint();
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
		}

	}
}