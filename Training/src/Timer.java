import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Methode d'affichage en fonction de l'entrainement selectionné
 * 
 * @author Wilhelm1er
 */
public class Timer {

	private int Duree_corde;
	private int Duree_pause;
	private int nbre_serie;
	File file = new File("buzzer1.wav");
	private Timestamp timestamp_1 = new Timestamp(System.currentTimeMillis());

	public Timer(Map<String, Integer> List, String type) throws InterruptedException {
		// Session de base

		// Switch selon le choix entre renforcement et gainage
		switch (type) {
		case "Renforcement":
			this.process_CordeASauter();
			for (int i = 1; i <= nbre_serie; i++) {
				if (i > 1) {
					this.promptEnterKey();
				}
				System.out.println(" ");
				System.out.println("#####################################");
				System.out.println("          SERIE NUMERO: " + i);
				System.out.println("#####################################");
				System.out.println(" ");
				for (String mapentry : List.keySet()) {
					this.corde_a_sauter();
					System.out.println("Exercice: " + mapentry + " - " + List.get(mapentry) + " Répétitions.");
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
			this.process_AvecPause();
			for (int i = 1; i <= nbre_serie; i++) {
				if (i > 1) {
					this.promptEnterKey();
				}
				System.out.println(" ");
				System.out.println("#####################################");
				System.out.println("          SERIE NUMERO: " + i);
				System.out.println("#####################################");
				System.out.println(" ");
				for (String mapentry : List.keySet()) {
					System.out.println("Exercice: " + mapentry + " - " + List.get(mapentry) + " Répétitions.");
					this.promptEnterKey();
					this.pause(Duree_pause);
					this.bip();
				}
				if (i < nbre_serie) {
					System.out.println("PAUSE de 3min");
					this.pause(180);
				}
			}
			break;
		case "Gainage":
			this.process_CordeASauter();
			for (int i = 1; i <= nbre_serie; i++) {
				if (i > 1) {
					this.promptEnterKey();
				}
				System.out.println(" ");
				System.out.println("#####################################");
				System.out.println("          SERIE NUMERO: " + i);
				System.out.println("#####################################");
				System.out.println(" ");
				for (String mapentry : List.keySet()) {
					this.corde_a_sauter();
					System.out.println("Exercice: " + mapentry + " - " + List.get(mapentry) + " Secondes.");
					this.pause(List.get(mapentry));
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
		System.out.println("Durée de l'entrainement: " + minutes + " minutes " + seconds + " secondes.");
		System.out.println(" ");
		System.out.println("#####################################");
		System.out.println(" ");
		Menu menu=new Menu();
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
	 */
	public void corde_a_sauter() throws InterruptedException {
		System.out.println("CORDE A SAUTER");
		for (int i = Duree_corde; i > 0; i--) {
			System.out.println(i);
			Thread.sleep(1000);
			if (i == 5) {
				this.bip();
			}
		}

	}

	/**
	 * Methode pour creer une pause
	 * 
	 * @param int en secondes.
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
			clip.open(AudioSystem.getAudioInputStream(file));
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
		Duree_corde = new Scanner(System.in).nextInt();
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
		Duree_pause = new Scanner(System.in).nextInt();
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