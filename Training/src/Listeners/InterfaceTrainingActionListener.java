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
	private Login l = new Login();
	private Challenge challenge = new Challenge();
	private Date date = new Date();
	private java.sql.Date dateS = new java.sql.Date(date.getTime());

	public InterfaceTrainingActionListener(InterfaceTraining IntTraining) {
		this.IntTraining = IntTraining;

		/*
		 * panelCenterTRaining.remove(descriptionTraining);
		 * panelCenterTRaining.validate(); //panelCenterTRaining.revalidate();
		 * panelCenterTRaining.repaint(); login.getFrame().revalidate();
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == IntTraining.getDemarrerButton()) {
			Training Training = new Training();
			String level = (String) IntTraining.getComboNiveau().getSelectedItem();
			try {
				if (IntTraining.getTypeTraining().equals("Challenge")) {

					if (level.equals("Pompiers")) {
						IntTraining.processTraining(211);
						// frame.add(new Chrono(211));
						challenge.startChallenge(l.getName(), dateS, level);
					}
					if (level.equals("FBI")) {
						IntTraining.processTraining(292);
						// frame.add(new Chrono(292));
						challenge.startChallenge(l.getName(), dateS, level);
					}
//MAUVAISE DUREE DE PAUSE 45 au lieu de 30
				} else {
					System.out.println("type de training: " + IntTraining.getTypeTraining());
					System.out.println("level: " + level);
					System.out.println("nom: " + l.getName());
					System.out.println("date: " + dateS);
					Application.Timer Timer_Training = new Application.Timer(
							Training.training(IntTraining.getTypeTraining(), level), IntTraining.getTypeTraining(),
							l.getName(), dateS, level);
				}
			} catch (InterruptedException f) {
				System.out.println("ne fonctionne pas");
				f.printStackTrace();
			}
		}
		else if (e.getSource() == IntTraining.getComboNiveau()) {

			Training T = new Training();
			String level = (String) IntTraining.getComboNiveau().getSelectedItem();

			IntTraining.getDescriptionTraining().setText(T.affichageTraining(level));
			IntGraphique.getFrame().revalidate();
		}
	}
}