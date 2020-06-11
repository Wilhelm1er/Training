import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * Methode d'affichage en fonction de l'entrainement selectionné
 * 
 * @author Wilhelm1er
 */
public class Timer {
	

	public Timer(Map<String, Integer> List, String type) throws InterruptedException {
		switch (type) {
		case "Renforcement":

			System.out.println("Choisissez votre temps de corde à sauter: ");
			int Duree_corde = new Scanner(System.in).nextInt();
			System.out.println("Vous avez choisi de faire: " + Duree_corde + " secondes de corde à sauter");
			
			System.out.println("Mettez vous en place");
			
			this.promptEnterKey();
			
			System.out.print("Démarrage dans: ");

			for (int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}

			System.out.println("Go: ");
			
			System.out.println("CORDE A SAUTER");
			for (int i = Duree_corde; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			
			System.out.println("Prochain exercice: ");
		
			for (String mapentry : List.keySet()) {
				System.out.println("Exercice: " + mapentry);
			}

			break;

		case "Gainage":

			System.out.println("Mettez vous en place");
			System.out.print("Démarrage dans: ");

			for (int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}

			System.out.println("Go: ");

			for (String mapentry : List.keySet()) {
				System.out.println("Exercice: " + mapentry);
			}

			break;
		}
	}
	public void promptEnterKey(){
	    System.out.println("Press \"ENTER\" to continue...");
	    try {
	        System.in.read();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
}