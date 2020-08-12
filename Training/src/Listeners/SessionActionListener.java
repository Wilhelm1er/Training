package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;
import java.util.Map;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Application.Challenge;
import Application.Training;
import InterfaceGraphique.InterfacePrincipale;
import InterfaceGraphique.InterfaceSession;
import InterfaceGraphique.InterfaceTraining;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class SessionActionListener implements ActionListener {
	private InterfaceSession IntSession = new InterfaceSession();
	private String type = IntSession.getTypeTraining();
	private Challenge challenge = new Challenge();
	private Date date = new Date();
	private java.sql.Date dateS = new java.sql.Date(date.getTime());
	private InterfaceTraining IntTraining = new InterfaceTraining();

	private int duree_corde = IntTraining.getDureeCorde();
	private int duree_pause = IntTraining.getDureePause();
	private int nbre_serie = IntTraining.getNbreSerie();
	private File bip = new File("resources/buzzer1.wav");
	private Timestamp timestamp_1 = new Timestamp(System.currentTimeMillis());

	private String level = "";

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

					// MAUVAISE DUREE DE PAUSE 45 au lieu de 30
				} else {

					System.out.println("level: " + IntSession.getLevel());
					if (!IntSession.getLevel().equals("Choix")) {
						/*
						 * Application.Session Session = new
						 * Application.Session(Training.training(IntSession.getTypeTraining(),
						 * IntSession.getLevel()), IntSession.getTypeTraining(), IntSession.getName(),
						 * dateS, IntSession.getLevel());
						 */

						switch (type) {
						case "Renforcement":
							for (int i = 1; i <= nbre_serie; i++) {
								IntSession.getSerie().setText("n° " + i);
								IntSession.getPanelPrincipal().repaint();

								for (String mapentry : Training
										.training(IntSession.getTypeTraining(), IntSession.getLevel()).keySet()) {
									this.corde_a_sauter();
									System.out.println("Exercice: " + mapentry + " - "
											+ Training.training(type, IntSession.getLevel()).get(mapentry)
											+ " Répétitions.");
									this.promptEnterKey();
								}
								if (i < nbre_serie) {
									this.corde_a_sauter();
									System.out.println("PAUSE de 3min");
									this.pause(180);
								}
							}
							this.corde_a_sauter();

							break;
						case "Musculation":
							IntSession.setTypeTraining("Musculation");
							IntSession.getPanelPrincipal().repaint();
							for (int i = 1; i <= nbre_serie; i++) {
								IntSession.getSerie().setText("n° " + i);
							}
							break;
						case "Gainage":
							IntSession.setTypeTraining("Gainage");
							IntSession.getPanelPrincipal().repaint();
							for (int i = 1; i <= nbre_serie; i++) {
								IntSession.getSerie().setText("n° " + i);
							}

							break;
						}
						System.out.println("Session TERMINEE");
						System.out.println(" ");
						// Prise de l'instant de fin de l'entrainement
						Timestamp timestamp_2 = new Timestamp(System.currentTimeMillis());
						// Conversion de la durée de l'entrainement.
						long diff = timestamp_2.getTime() - timestamp_1.getTime();
						int seconds = (int) (diff / 1000) % 60;
						int minutes = (int) ((diff / (1000 * 60)) % 60);
						int hours = (int) ((diff / (1000 * 60 * 60)) % 24);
						// Affichage de la durée de l'entrainement
						System.out
								.println("Durée de l'entrainement: " + minutes + " minutes " + seconds + " secondes.");
						System.out.println(" ");
						System.out.println("#####################################");
						System.out.println(" ");
						// Switch selon le choix entre renforcement et gainage
						switch (type) {
						case "Renforcement":
							// Ajout training dans la BDD
							// Training.ajout_training(IntSession.getName(), date, type, nbre_serie,
							// duree_corde, level, diff);
							break;
						case "Musculation":
							// Ajout training dans la BDD
							// Training.ajout_autre(IntSession.getName(), date, type, nbre_serie,
							// duree_pause, level, diff);
							break;
						case "Gainage":
							// Ajout training dans la BDD
							// Training.ajout_training(IntSession.getName(), date, type, nbre_serie,
							// duree_corde, level, diff);
							break;
						}
					}
				}
			}

			catch (InterruptedException f) {
				System.out.println("ne fonctionne pas");
				f.printStackTrace();
			}
		}
	}

	/**
	 * Methode d'attente d'appui sur la touche ENTRER
	 * 
	 */
	public void promptEnterKey() {
		System.out.println(" ");
		System.out.println(" Appuyer sur \"ENTRER\" pour continuer");
		System.out.println("#####################################");
		System.out.println(" ");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methode d'affichage de l'exercice corde à sauter
	 * 
	 * @throws InterruptedException
	 */
	public void corde_a_sauter() throws InterruptedException {
		IntSession.getExercice().setText("Corde à sauter");
		IntSession.getPanelPrincipal().repaint();
		for (int i = duree_corde; i > 0; i--) {
			IntSession.getTimeCurrent().setText("" + i);
			IntSession.getPanelPrincipal().repaint();
			Thread.sleep(1000);
			if (i == 5) {
				this.bip();
			}
		}
	}

	/**
	 * Methode pour creer une pause
	 * 
	 * @param time Temps en secondes.
	 * 
	 * @throws InterruptedException
	 */
	public void pause(int time) throws InterruptedException {
		for (int i = time; i > 0; i--) {
			System.out.println(i);
			Thread.sleep(1000);
			if (i == 5) {
				this.bip();
			}
		}
	}

	/**
	 * Methode pour jouer le bip sonore
	 * 
	 */
	public void bip() {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(bip));
			clip.start();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * Methode pour lancer le demarrage
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void demarrage() throws InterruptedException {
		System.out.print("Démarrage dans 5 secondes: ");

		for (int i = 5; i > 0; i--) {
			if (i == 4) {
				this.bip();
			}
			System.out.print(i);
			Thread.sleep(1000);
		}
	}

	/**
	 * Methode pour lancer le processus avec un temps de corde a sauter
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void process_CordeASauter() throws InterruptedException {
		// Choix durée corde à sauter
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Choisissez votre temps de corde à sauter: (en secondes)");
		duree_corde = new Scanner(System.in).nextInt();
		System.out.println(" ");
		// Choix du nombre de série
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Nombre de série à effectuer: ");
		nbre_serie = new Scanner(System.in).nextInt();
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("          Installez vous... ");
		System.out.println("                et          ");

		this.promptEnterKey();

		this.demarrage();

		// Prise de l'instant de demarrage de l'entrainement
		timestamp_1 = new Timestamp(System.currentTimeMillis());
	}

	/**
	 * Methode pour lancer le processus avec un temps de pause
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void process_AvecPause() throws InterruptedException {
		// Choix durée du temps de pause
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Choisissez votre temps de pause: (en secondes)");
		duree_pause = new Scanner(System.in).nextInt();
		System.out.println(" ");
		// Choix du nombre de série
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Nombre de série à effectuer: ");
		nbre_serie = new Scanner(System.in).nextInt();
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("          Installez vous... ");
		System.out.println("                et          ");

		this.promptEnterKey();

		this.demarrage();

		// Prise de l'instant de demarrage de l'entrainement
		timestamp_1 = new Timestamp(System.currentTimeMillis());
	}
}
