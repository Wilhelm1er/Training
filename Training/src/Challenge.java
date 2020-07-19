import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Gestion des challenges
 * 
 */

public class Challenge {

	Menu menu = new Menu();
	bdd.ChallengeBdd challenge = new bdd.ChallengeBdd();

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

		this.promptEnterKey();

		this.jouer(acdc);
		this.timer(time);

		System.out.println("Session TERMINEE");
		System.out.println(" ");

		// Ajout dans la BDD
		challenge.ajout(name, date, type);
		
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

		this.promptEnterKey();

		this.jouer(bsu);
		this.timer(time);

		System.out.println("Session TERMINEE");
		System.out.println(" ");

		// Ajout dans la BDD
		challenge.ajout(name, date, type);
		
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
