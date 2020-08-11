package Application;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Gestion des challenges
 * 
 */

public class Challenge {

	private BaseDeDonnées.ChallengeBdd challenge = new BaseDeDonnées.ChallengeBdd();
	private Timestamp timestamp_1 = new Timestamp(System.currentTimeMillis());
	private String termine = "";
	private File file;
	private int time;

	/**
	 * Methode pour lancer le challenge
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void startChallenge(String name, Date date, String type) throws InterruptedException {

		if (type == "FBI") {
			file = new File("resources/Thunderstruck.wav");
			// durée du challenge
			time = 292;
		}
		if (type == "Pompiers") {
			file = new File("resources/BringSallyUp.wav");
			time = 211;
		}
		// Prise de l'instant de demarrage de l'entrainement
		timestamp_1 = new Timestamp(System.currentTimeMillis());
		System.out.println(" ");
		System.out.println("#####################################");
		System.out.println("          CHALLENGE                  ");
		System.out.println("          " + type + "              ");
		System.out.println("#####################################");
		System.out.println(" ");

		//this.promptEnterKey();

		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
			System.out.println("          En cours   ...   ");
			this.promptEnterKey();
			clip.stop();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		// Prise de l'instant de fin de l'entrainement
		Timestamp timestamp_2 = new Timestamp(System.currentTimeMillis());

		System.out.println("Session TERMINEE");
		System.out.println(" ");

		// Conversion de la durée de l'entrainement.
		long diff = timestamp_2.getTime() - timestamp_1.getTime();

		int seconds = (int) (diff / 1000) ;

		if (seconds >= time) {
			System.out.println("Félicitation " + name);
			termine = "OUI";
		}
		if (seconds < time) {
			int seconds2 = (int) (diff / 1000) % 60;
			int minutes = (int) ((diff / (1000 * 60)) % 60);
			int hours = (int) ((diff / (1000 * 60 * 60)) % 24);
			System.out.println("Dommage " + name);
			System.out.println("Vous avez tenu: " + minutes + " minutes " + seconds2 + " secondes.");
			termine = "NON";
		}
		// Ajout dans la BDD
		challenge.ajout(name, date, type, diff, termine);

		System.out.println(" ");
		System.out.println("#####################################");
		System.out.println(" ");


	}

	/**
	 * Methode pour afficher la durée restante
	 * 
	 * @param int en secondes.
	 */
	public void timer(int time) throws InterruptedException {
		for (int i = time; i > 0; i--) {
			System.out.println(i);
			Thread.sleep(1000);
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
}
