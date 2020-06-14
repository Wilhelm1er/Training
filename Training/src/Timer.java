import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Scanner;

/**
 * Methode d'affichage en fonction de l'entrainement selectionné
 * 
 * @author Wilhelm1er
 */
public class Timer {

	int Duree_corde;
	int Duree_pause;
	int nbre_serie;
	Timestamp timestamp_1 = new Timestamp(System.currentTimeMillis());

	public Timer(Map<String, Integer> List, String type) throws InterruptedException {
		// Session de base

		// Switch selon le choix entre renforcement et gainage
		switch (type) {
		case "Renforcement":
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

			System.out.print("Démarrage dans 5 secondes: ");

			for (int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			// Prise de l'instant de demarrage de l'entrainement
			timestamp_1 = new Timestamp(System.currentTimeMillis());

			for (int i = 1; i <= nbre_serie; i++) {
				System.out.println(" ");
				System.out.println("#####################################");
				System.out.println("          SERIE NUMERO: " + i);
				System.out.println("#####################################");
				System.out.println(" ");
				for (String mapentry : List.keySet()) {
					this.corde_a_sauter();
					System.out.println("Exercice suivant: " + mapentry + " - " + List.get(mapentry) + " Répétitions.");
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

			System.out.print("Démarrage dans 5 secondes: ");

			for (int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			// Prise de l'instant de demarrage de l'entrainement
			timestamp_1 = new Timestamp(System.currentTimeMillis());

			for (int i = 1; i <= nbre_serie; i++) {
				System.out.println(" ");
				System.out.println("#####################################");
				System.out.println("          SERIE NUMERO: " + i);
				System.out.println("#####################################");
				System.out.println(" ");
				for (String mapentry : List.keySet()) {
					System.out.println("Exercice: " + mapentry + " - " + List.get(mapentry) + " Répétitions.");
					this.promptEnterKey();
					this.pause(Duree_pause);
				}
				if (i < nbre_serie) {
					System.out.println("PAUSE de 3min");
					this.pause(180);
				}
			}
			break;
		case "Gainage":
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

			System.out.print("Démarrage dans 5 secondes: ");

			for (int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			// Prise de l'instant de demarrage de l'entrainement
			timestamp_1 = new Timestamp(System.currentTimeMillis());

			for (int i = 1; i <= nbre_serie; i++) {
				System.out.println(" ");
				System.out.println("#####################################");
				System.out.println("          SERIE NUMERO: " + i);
				System.out.println("#####################################");
				System.out.println(" ");
				for (String mapentry : List.keySet()) {
					this.corde_a_sauter();
					System.out.println("Exercice: " + mapentry + " - " + List.get(mapentry) + " Secondes.");
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
		// Prise de l'instant de fin de l'entrainement
		Timestamp timestamp_2 = new Timestamp(System.currentTimeMillis());
		// Conversion de la durée de l'entrainement.
		long diff = timestamp_2.getTime() - timestamp_1.getTime();
		int seconds = (int) (diff / 1000) % 60 ;
		int minutes = (int) ((diff / (1000*60)) % 60);
		int hours   = (int) ((diff / (1000*60*60)) % 24);
		// Affichage de la durée de l'entrainement
		System.out.println("Durée de l'entrainement: " + minutes + " minutes " + seconds + " secondes.");
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
		}
	}
}