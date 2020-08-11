package Listeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Swing.InterfacePoids;
import Swing.InterfacePrincipal;
import bdd.Poids;

public class InterfacePoidsActionListener implements ActionListener {

	private InterfacePoids IntPoids = new InterfacePoids();
	private Poids poids = new Poids();
	private InterfacePrincipal IntGraphique = new InterfacePrincipal();

	public InterfacePoidsActionListener(InterfacePoids IntPoids) {
		this.IntPoids = IntPoids;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == IntPoids.getAjoutPoids()) {

			String p = IntPoids.getTextePoids().getText();
			try {
				double pds = Double.parseDouble(p);
				poids.ajout(IntGraphique.getName(), pds, IntPoids.getDateS());
				IntPoids.InterfacePoids();
				IntPoids.getContentPane().revalidate();
			} catch (NumberFormatException f) {
				System.out.println(f);
			}

		}

		else if (e.getSource() == IntPoids.getDataPoidsButton()) {
			panelData.removeAll();
			panelData.add(scroll);
			panelData.repaint();
			ContentPane.add(panelData, BorderLayout.CENTER);
			ContentPane.revalidate();
		}

	}
}