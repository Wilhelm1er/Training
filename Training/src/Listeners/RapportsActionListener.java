package Listeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import InterfaceGraphique.InterfacePrincipal;
import InterfaceGraphique.InterfaceRapports;

public class RapportsActionListener implements ActionListener {

	private InterfaceRapports IntRapports = new InterfaceRapports();
	private InterfacePrincipal IntGraphique = new InterfacePrincipal();

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