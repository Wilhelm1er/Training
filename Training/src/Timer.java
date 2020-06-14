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
	int nbre_serie;

	public Timer(Map<String, Integer> List, String type) throws InterruptedException {
		// Session de base
		// Choix durée corde à sauter
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Choisissez votre temps de corde à sauter: (en secondes)");
		Duree_corde = new Scanner(System.in).nextInt();
		//System.out.println("Vous avez choisi de faire: " + Duree_corde + " secondes de corde à sauter");
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
		Timestamp timestamp_1 = new Timestamp(System.currentTimeMillis());
		
		// Switch selon le choix entre renforcement et gainage
		switch (type) {
		case "Renforcement":
			for (int i = 1; i <= nbre_serie; i++) {
				System.out.println(" ");
				System.out.println("#####################################");
				System.out.println("          SERIE NUMERO: " + i);
				System.out.println("#####################################");
				System.out.println(" ");
				for (String mapentry : List.keySet()) {
					this.corde_a_sauter();
					System.out.println("Exercice suivant: " + mapentry+ " - "+List.get(mapentry)+ " Répétitions.");
					this.promptEnterKey();
				}
				if (i < nbre_serie) {
					this.corde_a_sauter();
					System.out.println("PAUSE de 3min");
					for (int k = 8; k > 0; k--) {
						System.out.println(k);
						Thread.sleep(1000);
					}
				}
			}
			break;

		case "Gainage":
			for (int i = 1; i <= nbre_serie; i++) {
				System.out.println(" ");
				System.out.println("#####################################");
				System.out.println("          SERIE NUMERO: " + i);
				System.out.println("#####################################");
				System.out.println(" ");
				for (String mapentry : List.keySet()) {
					this.corde_a_sauter();
					System.out.println("Exercice: " + mapentry+ " - "+List.get(mapentry)+ " Secondes.");
					this.promptEnterKey();
				}
				if (i < nbre_serie) {
					this.corde_a_sauter();
					System.out.println("PAUSE de 3min");
					for (int k = 180; k > 0; k--) {
						System.out.println(k);
						Thread.sleep(1000);
					}
				}
			}
			break;
		}
		this.corde_a_sauter();
		// Prise de l'instant de fin de l'entrainement
		Timestamp timestamp_2 = new Timestamp(System.currentTimeMillis());
		// Conversion de la durée de l'entrainement.
		long diff = timestamp_2.getTime() - timestamp_1.getTime();
		long diffSeconds = diff / 1000;
		long diffMinutes = diff / (60 * 1000);
		long diffHours = diff / (60 * 60 * 1000);
		// Affichage de la durée de l'entrainement
		System.out.println("Durée de l'entrainement: "+diffMinutes+" minutes "+diffSeconds+" secondes.");
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
}