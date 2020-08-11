package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import Application.Challenge;
import Application.Training;
import InterfaceGraphique.InterfacePrincipale;
import InterfaceGraphique.InterfaceTraining;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class TrainingActionListener implements ActionListener {
	private InterfacePrincipale IntPrincipale = new InterfacePrincipale();
	private InterfaceTraining IntTraining = new InterfaceTraining();
	private Challenge challenge = new Challenge();
	private Date date = new Date();
	private java.sql.Date dateS = new java.sql.Date(date.getTime());
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
		
		/*
		 * IntTraining.getPanelCenterTRaining().remove(IntTraining.
		 * getDescriptionTraining()); IntTraining.getPanelCenterTRaining().validate();
		 * IntTraining.getPanelCenterTRaining().repaint();
		 * IntGraphique.getFrame().revalidate();
		 */
		
		 System.out.println("nom: "+IntPrincipale.getName());
		if (e.getSource() == IntTraining.getDemarrerButton()) {
			Training Training = new Training();
			level = (String) IntTraining.getComboNiveau().getSelectedItem();
			try {
				if (IntTraining.getTypeTraining().equals("Challenge")) {

					if (level.equals("Pompiers")) {
						IntTraining.processTraining(211);
						// frame.add(new Chrono(211));
						challenge.startChallenge(IntPrincipale.getName(), dateS, level);
					}
					if (level.equals("FBI")) {
						IntTraining.processTraining(292);
						// frame.add(new Chrono(292));
						challenge.startChallenge(IntPrincipale.getName(), dateS, level);
					}
//MAUVAISE DUREE DE PAUSE 45 au lieu de 30
				} else {
					System.out.println("type de training: " + IntTraining.getTypeTraining());
					System.out.println("level: " + level);
					System.out.println("nom: " + IntPrincipale.getName());
					System.out.println("date: " + dateS);
					Application.Timer Timer_Training = new Application.Timer(
							Training.training(IntTraining.getTypeTraining(), level), IntTraining.getTypeTraining(),
							IntPrincipale.getName(), dateS, level);
				}
			} catch (InterruptedException f) {
				System.out.println("ne fonctionne pas");
				f.printStackTrace();
			}
		}
		else if (e.getSource() == IntTraining.getComboNiveau()) {
			Training T = new Training();
			level = (String) IntTraining.getComboNiveau().getSelectedItem();
			IntTraining.getDescriptionTraining().setText(T.affichageTraining(level));
			IntPrincipale.getFrame().revalidate();
		}
	}
}