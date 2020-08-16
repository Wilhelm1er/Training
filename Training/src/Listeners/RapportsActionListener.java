package Listeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import InterfaceGraphique.InterfacePrincipale;
import InterfaceGraphique.InterfaceRapports;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class RapportsActionListener implements ActionListener {

	private InterfaceRapports IntRapports = new InterfaceRapports();
	private InterfacePrincipale IntGraphique = new InterfacePrincipale();

	/**
	 * Listener des boutons de l'interface relative aux Rapports
	 * 
	 * @param interfaceRapports Référence à l'interface relative aux Rapports
	 */
	public RapportsActionListener(InterfaceRapports interfaceRapports) {
		this.IntRapports = interfaceRapports;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == IntRapports.getTrainingButton()) {
			IntRapports.getPanelRapports().removeAll();
			IntRapports.getPanelRapports().add(IntRapports.getScrollChallenge());
			IntRapports.getPanelRapports().repaint();
			IntGraphique.getFrame().add(IntRapports.getPanelRapports(), BorderLayout.CENTER);
			IntGraphique.getFrame().revalidate();

		}

		else if (e.getSource() == IntRapports.getChallengeButton()) {
			IntRapports.getPanelRapports().removeAll();
			IntRapports.getPanelRapports().add(IntRapports.getScrollTraining());
			IntRapports.getPanelRapports().repaint();
			IntGraphique.getFrame().add(IntRapports.getPanelRapports(), BorderLayout.CENTER);
			IntGraphique.getFrame().revalidate();
		}

	}
}