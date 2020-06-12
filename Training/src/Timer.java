import java.io.IOException;
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

		// Choix durée corde à sauter
		System.out.println("Choisissez votre temps de corde à sauter: ");
		Duree_corde = new Scanner(System.in).nextInt();
		System.out.println("Vous avez choisi de faire: " + Duree_corde + " secondes de corde à sauter");
		// Choix du nombre de série
		System.out.println("Combien de série: ");
		nbre_serie = new Scanner(System.in).nextInt();

		System.out.println("Mettez vous en place");

		this.promptEnterKey();

		System.out.print("Démarrage dans: ");

		for (int i = 5; i > 0; i--) {
			System.out.println(i);
			Thread.sleep(1000);
		}

		System.out.println("GOOOOO:");

		switch (type) {
		case "Renforcement":
			for (int i = 1; i <= nbre_serie; i++) {
				System.out.println("SERIE NUMERO: " + i);
				for (String mapentry : List.keySet()) {
					this.corde_a_sauter();
					System.out.println("Exercice: " + mapentry);
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
				System.out.println("SERIE NUMERO: " + i);
				for (String mapentry : List.keySet()) {
					this.corde_a_sauter();
					System.out.println("Exercice: " + mapentry);
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
		}
		this.corde_a_sauter();
	}

	/**
	 * Methode d'attente d'appui sur la touche ENTRER
	 * 
	 */
	public void promptEnterKey() {
		System.out.println("Press \"ENTER\" to continue...");
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