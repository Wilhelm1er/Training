package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Application.Training;
import InterfaceGraphique.InterfacePrincipale;
import InterfaceGraphique.InterfaceSession;
import InterfaceGraphique.InterfaceTraining;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class TrainingActionListener implements ActionListener {
	private InterfacePrincipale IntPrincipale = new InterfacePrincipale();
	private InterfaceTraining IntTraining = new InterfaceTraining();
	private InterfaceSession IntSession = new InterfaceSession();
	
	private String level = "";

	/**
	 * Listener des boutons de l'interface relative aux Trainings
	 * 
	 * @param interfaceTraining Référence à l'interface relative aux Trainings
	 */
	public TrainingActionListener(InterfaceTraining interfaceTraining) {
		this.IntTraining = interfaceTraining;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == IntTraining.getOkButton()) {
			IntSession.setLevel(IntTraining.getComboNiveauItem());
			IntSession.setTypeTraining(IntTraining.getTypeTraining());
			IntSession.getLabelTypeTraining().setText(IntTraining.getTypeTraining());
			IntSession.setName(IntTraining.getName());
			IntSession.session();
			
		} else if (e.getSource() == IntTraining.getComboNiveau()) {
			Training T = new Training();
			level = (String) IntTraining.getComboNiveau().getSelectedItem();
			IntTraining.getDescriptionTraining().setText(T.affichageTraining(level));
			IntPrincipale.getFrame().revalidate();
		}

	}
}