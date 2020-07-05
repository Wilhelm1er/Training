import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Methodes liées aux entrainements selectionnés
 * 
 * @author Wilhelm1er
 */

public class Entrainements {

	private Map<String, Integer> List_1 = new LinkedHashMap<String, Integer>();
	private Map<String, Integer> List_2 = new LinkedHashMap<String, Integer>();
	private Map<String, Integer> List_3 = new LinkedHashMap<String, Integer>();

	// Renforcement
	/**
	 * Selection du niveau de difficulté du mode Renforcement
	 * @return level
	 */
	public int renforcement_Selection() {
		int level=0;
		Boolean Choix_2 = false;
		do {
			System.out.println("Selectionner votre niveau: ");
			System.out.println("1 - Débutant: ");
			System.out.println("2 - Intermédiaire: ");
			System.out.println("3 - Confirmé: ");
			System.out.println("4 - Elite: ");
			int choice = new Scanner(System.in).nextInt();
			level=choice;
			if (choice < 1 && choice > 4) {
				System.out.println("Niveau choisi inexistant");
			}
			if (choice >= 1 && choice <= 4) {
				this.renforcement(choice);
				this.renforcement_ToString();
				System.out.println(" ");
				System.out.println("#####################################");
				System.out.println(" ");
				System.out.println("Pouvons nous commencer l'entrainement? o/n");
				String rep = new Scanner(System.in).nextLine();
				if (rep.equals("o")) {
					Choix_2 = true;
				}
			}
		} while (Choix_2 == false);
		return level;
	}

	/**
	 * Creation de la liste de l'exercice de renforcement musculaire suivant le
	 * niveau de difficulté selectionné
	 * 
	 * @param level Niveau de difficulté selectionné
	 * @return List_1 Liste générée correspondant au niveau de l'entrainement de renforcement
	 *         selectionné
	 */
	public Map<String, Integer> renforcement(int level) {
		switch (level) {
		case 1:
			List_1.put("Bras tendu coude", 10);
			List_1.put("Tractions", 5);
			List_1.put("Abdo rameur", 15);
			List_1.put("Mountain Climbers", 15);
			List_1.put("Pompes", 5);
			break;
		case 2:
			List_1.put("Bras tendu coude", 12);
			List_1.put("Tractions", 7);
			List_1.put("Abdo rameur", 20);
			List_1.put("Mountain Climbers", 18);
			List_1.put("Pompes", 7);
			break;
		case 3:
			List_1.put("Bras tendu coude", 20);
			List_1.put("Tractions", 15);
			List_1.put("Abdo rameur", 25);
			List_1.put("Mountain Climbers", 25);
			List_1.put("Pompes", 15);
			break;
		case 4:
			List_1.put("Bras tendu coude", 25);
			List_1.put("Tractions", 20);
			List_1.put("Abdo rameur", 30);
			List_1.put("Mountain Climbers", 30);
			List_1.put("Pompes", 20);
			break;
		}
		return List_1;
	}
	
	/**
	 * Affichage du choix de l'exercice de renforcement choisi
	 */
	public void renforcement_ToString() {
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Session: ");
		System.out.println(" ");
		for (String s : List_1.keySet()) {
			System.out.println("- " + s + ", " + List_1.get(s)+ " Répétitions.");
		}
	}
	
	// Musculation
	
	/**
	 * Selection du niveau de difficulté du mode Musculation
	 * @return level
	 */
	
	public int musculation_Selection() {
		int level=0;
		Boolean Choix_3 = false;
		do {
			System.out.println("Selectionner votre niveau: ");
			
			System.out.println("Niveau 1: ");
			System.out.println("Niveau 2: ");
			int choice = new Scanner(System.in).nextInt();
			level=choice;
			if (choice < 1 && choice > 2) {
				System.out.println("Niveau choisi inexistant");
			}
			if (choice >= 1 && choice <= 2) {
				this.musculation(choice);
				this.musculation_ToString();
				System.out.println(" ");
				System.out.println("#####################################");
				System.out.println(" ");
				System.out.println("Pouvons nous commencer l'entrainement? o/n");
				String rep = new Scanner(System.in).nextLine();
				if (rep.equals("o")) {
					Choix_3 = true;
				}
			}
		} while (Choix_3 == false);
		return level;
	}
	/**
	 * Creation de la liste de l'exercice de musculation suivant le
	 * niveau de difficulté selectionné
	 * 
	 * @param level Niveau de difficulté selectionné
	 * @return List_3 Liste générée correspondant au niveau l'entrainement de musculation
	 *         selectionné
	 */
	
	public Map<String, Integer> musculation(int level) {
		switch (level) {
		case 1:
			List_3.put("Dips", 5);
			List_3.put("Pompes pieds surélevés", 10);
			List_3.put("Pompes", 10);
			List_3.put("Tractions", 10);
			break;
		case 2:
			List_3.put("Dips", 10);
			List_3.put("Pompes pieds surélevés", 15);
			List_3.put("Pompes", 15);
			List_3.put("Tractions", 15);
			break;
		}
		return List_3;
		}

	/**
	 * Affichage du choix de l'exercice de musculation choisi
	 */
	public void musculation_ToString() {
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Session: ");
		System.out.println(" ");
		for (String s : List_3.keySet()) {
			System.out.println("- " + s + ", " + List_3.get(s)+ " Répétitions.");
		}
	}

	// Gainage
	
	/**
	 * Selection du niveau de difficulté du mode Gainage
	 * @return level
	 */
	public int gainage_Selection() {
		int level=0;
		Boolean Choix_4 = false;
		do {
			System.out.println("Selectionner votre niveau: ");
			System.out.println("1 - Routine 1: ");
			System.out.println("2 - Routine 2: ");
			int choice = new Scanner(System.in).nextInt();
			level=choice;
			if (choice < 1 && choice > 2) {
				System.out.println("Niveau choisi inexistant");
			}
			if (choice >= 1 && choice <= 2) {
				this.gainage(choice);
				this.Gainage_ToString();
				System.out.println(" ");
				System.out.println("#####################################");
				System.out.println(" ");
				System.out.println("Pouvons nous commencer l'entrainement? o/n");
				String rep = new Scanner(System.in).nextLine();
				if (rep.equals("o")) {
					Choix_4 = true;
				}
			}
		} while (Choix_4 == false);
		return level;
	}

	/**
	 * Creation de la liste de l'exercice de gainage suivant le niveau de difficulté
	 * selectionné
	 * 
	 * @param level Niveau de difficulté selectionné
	 * @return List_2 Liste générée correspondant à l'exercice de gainage
	 *         selectionné
	 */
	public Map<String, Integer> gainage(int level) {
		switch (level) {
		case 1:
			List_2.put("La Planche", 60);
			List_2.put("Superman", 60);
			List_2.put("La Planche Latérale Gauche", 45);
			List_2.put("La Planche Latérale Droite", 45);
			List_2.put("La Planche Dos", 60);
			break;
		case 2:
			List_2.put("La Planche", 60);
			List_2.put("La Planche Latérale Gauche avec torsion", 30);
			List_2.put("La Planche Latérale Droite avec torsion", 30);
			List_2.put("La Planche 1 bras 1 jambe levée gauche", 30);
			List_2.put("La Planche 1 bras 1 jambe levée droit", 30);
			break;
		}
		return List_2;
	}

	/**
	 * Affichage du choix de l'exercice de gainage choisi
	 */
	public void Gainage_ToString() {
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Session: ");
		System.out.println(" ");
		for (String s : List_2.keySet()) {
			System.out.println("- " + s + ", " + List_2.get(s) + " secondes.");
		}
	}
}