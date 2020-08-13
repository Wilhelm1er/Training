package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.SwingWorker;

import Application.Challenge;
import Application.Training;
import InterfaceGraphique.InterfaceSession;
import InterfaceGraphique.InterfaceTraining;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class SessionActionListener implements ActionListener {
	private InterfaceSession IntSession = new InterfaceSession();
	private Challenge challenge = new Challenge();
	private Date date = new Date();
	private java.sql.Date dateS = new java.sql.Date(date.getTime());
	private InterfaceTraining IntTraining = new InterfaceTraining();
	private String level = "";
	private long diff;
	private long tempsTotal;

	private BaseDeDonnées.TrainingBdd TrainingBdd = new BaseDeDonnées.TrainingBdd();

	/**
	 * Listeners des boutons de l'interface de session de training
	 * 
	 * @param interfaceSession Référence a l'interface de session de training
	 */
	public SessionActionListener(InterfaceSession interfaceSession) {
		this.IntSession = interfaceSession;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == IntSession.getArreterButton()) {
			Timestamp timestamp_3 = new Timestamp(System.currentTimeMillis());
			// Conversion de la durée de l'entrainement.
			tempsTotal = timestamp_3.getTime() - IntSession.getTimestamp_1().getTime();
			int sec = (int) (tempsTotal / 1000) % 60;
			int min = (int) ((tempsTotal / (1000 * 60)) % 60);
			int h = (int) ((tempsTotal / (1000 * 60 * 60)) % 24);
			System.out.println(h+" heures" + min + " minutes " + sec + " secondes.");
			
			switch (IntSession.getTypeTraining()) {
			case "Renforcement":
				// Ajout training dans la BDD
				TrainingBdd.ajout_training(IntSession.getName(), dateS, IntSession.getTypeTraining(), IntSession.getNbre_serie(),
				IntSession.getDuree_corde(), level, tempsTotal);
				break;
			case "Musculation":
				// Ajout training dans la BDD
				TrainingBdd.ajout_autre(IntSession.getName(), dateS, IntSession.getTypeTraining(), IntSession.getNbre_serie(),
				IntSession.getDuree_pause(), level, tempsTotal);
				break;
			case "Gainage":
				// Ajout training dans la BDD
				// BUG CAR PAS DE DUREE DE CORDE DANS L EXO GAINAGE
				
				
				TrainingBdd.ajout_training(IntSession.getName(), dateS, IntSession.getTypeTraining(), IntSession.getNbre_serie(),
						IntSession.getDuree_corde(), level, tempsTotal);
				break;
			}
			IntSession.getFrame().dispose();
			
		} else if (e.getSource() == IntSession.getPauseButton()) {
			//
		} else if (e.getSource() == IntSession.getDemarrerButton()) {
			Training Training = new Training();
			level = (String) IntTraining.getComboNiveau().getSelectedItem();
			try {

				if (IntSession.getTypeTraining().equals("Challenge")) {

					if (level.equals("Pompiers")) {
						IntTraining.processTraining(211);
						// frame.add(new Chrono(211));
						challenge.startChallenge(IntSession.getName(), dateS, IntSession.getLevel());
					}
					if (level.equals("FBI")) {
						IntTraining.processTraining(292);
						// frame.add(new Chrono(292));
						challenge.startChallenge(IntSession.getName(), dateS, IntSession.getLevel());
					}

				} else {
					System.out.println("level: " + IntSession.getLevel());
					new SwingWorker<Object, Object>() {

						@Override
						protected Object doInBackground() throws Exception {
							if (!IntSession.getLevel().equals("Choix")) {
								IntSession.setList(Training.training(IntSession.getTypeTraining(), IntSession.getLevel()));
								IntSession.sessionTraining();
								for(;;) {
								// Prise de l'instant de fin de l'entrainement
								Timestamp timestamp_2 = new Timestamp(System.currentTimeMillis());
											// Conversion de la durée de l'entrainement.
								diff = timestamp_2.getTime() - IntSession.getTimestamp_1().getTime();
								int seconds = (int) (diff / 1000) % 60;
								int minutes = (int) ((diff / (1000 * 60)) % 60);
								int hours = (int) ((diff / (1000 * 60 * 60)) % 24);
								IntSession.getTimeSession().setText(hours+" :" + minutes + " : " + seconds);
								IntSession.getPanelPrincipal().repaint();
								}
							} else {

							}
							return null;
						}
					}.execute();
					
				}
			}

			catch (InterruptedException f) {
				System.out.println("ne fonctionne pas");
				f.printStackTrace();
			}

		}
	}
}
