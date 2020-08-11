package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import Application.Challenge;
import Application.Training;
import Swing.InterfacePrincipal;
import Swing.InterfaceTraining;
import Swing.Login;

public class InterfaceTrainingActionListener implements ActionListener {
	private InterfacePrincipal IntGraphique = new InterfacePrincipal();
	private InterfaceTraining IntTraining = new InterfaceTraining();
	private Challenge challenge = new Challenge();
	private Date date = new Date();
	private java.sql.Date dateS = new java.sql.Date(date.getTime());
	private String level = "";
	
	public InterfaceTrainingActionListener(InterfaceTraining IntTraining) {
		this.IntTraining = IntTraining;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * IntTraining.getPanelCenterTRaining().remove(IntTraining.
		 * getDescriptionTraining()); IntTraining.getPanelCenterTRaining().validate();
		 * IntTraining.getPanelCenterTRaining().repaint();
		 * IntGraphique.getFrame().revalidate();
		 */
		 
		if (e.getSource() == IntTraining.getDemarrerButton()) {
			Training Training = new Training();
			level = (String) IntTraining.getComboNiveau().getSelectedItem();
			try {
				if (IntTraining.getTypeTraining().equals("Challenge")) {

					if (level.equals("Pompiers")) {
						IntTraining.processTraining(211);
						// frame.add(new Chrono(211));
						challenge.startChallenge(IntGraphique.getName(), dateS, level);
					}
					if (level.equals("FBI")) {
						IntTraining.processTraining(292);
						// frame.add(new Chrono(292));
						challenge.startChallenge(IntGraphique.getName(), dateS, level);
					}
//MAUVAISE DUREE DE PAUSE 45 au lieu de 30
				} else {
					System.out.println("type de training: " + IntTraining.getTypeTraining());
					System.out.println("level: " + level);
					System.out.println("nom: " + IntGraphique.getName());
					System.out.println("date: " + dateS);
					Application.Timer Timer_Training = new Application.Timer(
							Training.training(IntTraining.getTypeTraining(), level), IntTraining.getTypeTraining(),
							IntGraphique.getName(), dateS, level);
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
			IntGraphique.getFrame().revalidate();
		}
	}
}