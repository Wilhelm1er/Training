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

	Menu menu = new Menu();
	bdd.ChallengeBdd challenge = new bdd.ChallengeBdd();
	private Timestamp timestamp_1 = new Timestamp(System.currentTimeMillis());
	String termine="";

	/**
	 * Challenge FBI
	 * 
	 */
	public void fbi(String name, Date date, String type) throws InterruptedException {

		File acdc = new File("resources/Thunderstruck.wav");
		// durée du challenge
		int time = 292;

		System.out.println(" ");
		System.out.println("#####################################");
		System.out.println("          CHALLENGE FBI              ");
		System.out.println("#####################################");
		System.out.println(" ");

		System.out.println("      Dès que vous êtes prêt");
		this.promptEnterKey();

		// Prise de l'instant de demarrage de l'entrainement
		timestamp_1 = new Timestamp(System.currentTimeMillis());

		this.jouer(acdc);
		
		System.out.println("Session TERMINEE");
		System.out.println(" ");

		// Prise de l'instant de fin de l'entrainement
		Timestamp timestamp_2 = new Timestamp(System.currentTimeMillis());
		// Conversion de la durée de l'entrainement.
		long diff = timestamp_2.getTime() - timestamp_1.getTime();
		int seconds = (int) (diff / 1000) % 60;
		
		if(seconds>=time) {
			System.out.println(diff);
			System.out.println("Félicitation "+name);
			termine="OUI";
		}
		if(seconds<time) {
			int seconds2 = (int) (diff / 1000) % 60;
			int minutes = (int) ((diff / (1000 * 60)) % 60);
			int hours = (int) ((diff / (1000 * 60 * 60)) % 24);
			System.out.println("Dommage "+name);
			System.out.println("Vous avez tenu: "+ minutes + " minutes " + seconds2 + " secondes.");
			termine="NON";
		}
		System.out.println(" ");
		System.out.println("#####################################");
		System.out.println(" ");

		// Ajout dans la BDD
		challenge.ajout(name, date, type,diff,termine);

		menu.menu_general();
	}

	/**
	 * Challenge Pompiers
	 * 
	 */
	public void pompiers(String name, Date date, String type) throws InterruptedException {

		File bsu = new File("resources/BringSallyUp.wav");
		// durée du challenge
		int time = 211;

		System.out.println(" ");
		System.out.println("#####################################");
		System.out.println("          CHALLENGE Pompiers         ");
		System.out.println("            Bip chaque 30s           ");
		System.out.println("#####################################");
		System.out.println(" ");

		System.out.println("      Dès que vous êtes prêt         ");
		this.promptEnterKey();
		
		// Prise de l'instant de demarrage de l'entrainement
		timestamp_1 = new Timestamp(System.currentTimeMillis());

		this.jouer(bsu);
		
		System.out.println("Session TERMINEE");
		System.out.println(" ");

		// Prise de l'instant de fin de l'entrainement
		Timestamp timestamp_2 = new Timestamp(System.currentTimeMillis());
		// Conversion de la durée de l'entrainement.
		long diff = timestamp_2.getTime() - timestamp_1.getTime();
		int seconds = (int) (diff / 1000) % 60;
		
		if(seconds>=time) {
			System.out.println(diff);
			System.out.println("Félicitation "+name);
			termine="OUI";
		}
		if(seconds<time) {
			int seconds2 = (int) (diff / 1000) % 60;
			int minutes = (int) ((diff / (1000 * 60)) % 60);
			int hours = (int) ((diff / (1000 * 60 * 60)) % 24);
			System.out.println("Dommage "+name);
			System.out.println("Vous avez tenu: "+ minutes + " minutes " + seconds2 + " secondes.");
			termine="NON";
		}
		System.out.println(" ");
		System.out.println("#####################################");
		System.out.println(" ");

		// Ajout dans la BDD
		challenge.ajout(name, date, type,diff,termine);

		menu.menu_general();
	}

	/**
	 * Methode pour jouer la musique du challenge
	 * 
	 */
	public void jouer(File file) {
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
