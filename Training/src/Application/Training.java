package Application;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Methodes liées aux entrainements selectionnés
 * 
 * @author Wilhelm1er
 */

public class Training {

	private Map<String, Integer> listRenfo = new LinkedHashMap<String, Integer>();
	private Map<String, Integer> listGainage = new LinkedHashMap<String, Integer>();
	private Map<String, Integer> listMuscu = new LinkedHashMap<String, Integer>();

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
			listRenfo.put("Bras tendu coude", 10);
			listRenfo.put("Tractions", 5);
			listRenfo.put("Abdo rameur", 15);
			listRenfo.put("Mountain Climbers", 15);
			listRenfo.put("Pompes", 5);
			break;
		case 2:
			listRenfo.put("Bras tendu coude", 12);
			listRenfo.put("Tractions", 7);
			listRenfo.put("Abdo rameur", 20);
			listRenfo.put("Mountain Climbers", 18);
			listRenfo.put("Pompes", 7);
			break;
		case 3:
			listRenfo.put("Bras tendu coude", 20);
			listRenfo.put("Tractions", 15);
			listRenfo.put("Abdo rameur", 25);
			listRenfo.put("Mountain Climbers", 25);
			listRenfo.put("Pompes", 15);
			break;
		case 4:
			listRenfo.put("Bras tendu coude", 25);
			listRenfo.put("Tractions", 20);
			listRenfo.put("Abdo rameur", 30);
			listRenfo.put("Mountain Climbers", 30);
			listRenfo.put("Pompes", 20);
			break;
		}
		return listRenfo;
	}
	
	/**
	 * Affichage du choix de l'exercice de renforcement choisi
	 */
	public String renforcement_ToString() {
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Session: ");
		System.out.println(" ");
		for (String s : listRenfo.keySet()) {
			return "- " + s + ", " + listRenfo.get(s)+ " Répétitions.";
		}
		return null;
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
			listMuscu.put("Dips", 5);
			listMuscu.put("Pompes pieds surélevés", 10);
			listMuscu.put("Pompes", 10);
			listMuscu.put("Tractions", 10);
			break;
		case 2:
			listMuscu.put("Dips", 10);
			listMuscu.put("Pompes pieds surélevés", 15);
			listMuscu.put("Pompes", 15);
			listMuscu.put("Tractions", 15);
			break;
		}
		return listMuscu;
		}

	/**
	 * Affichage du choix de l'exercice de musculation choisi
	 */
	public void musculation_ToString() {
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Session: ");
		System.out.println(" ");
		for (String s : listMuscu.keySet()) {
			System.out.println("- " + s + ", " + listMuscu.get(s)+ " Répétitions.");
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
			listGainage.put("La Planche", 60);
			listGainage.put("Superman", 60);
			listGainage.put("La Planche Latérale Gauche", 45);
			listGainage.put("La Planche Latérale Droite", 45);
			listGainage.put("La Planche Dos", 60);
			break;
		case 2:
			listGainage.put("La Planche", 60);
			listGainage.put("La Planche Latérale Gauche avec torsion", 30);
			listGainage.put("La Planche Latérale Droite avec torsion", 30);
			listGainage.put("La Planche 1 bras 1 jambe levée gauche", 30);
			listGainage.put("La Planche 1 bras 1 jambe levée droit", 30);
			break;
		}
		return listGainage;
	}

	/**
	 * Affichage du choix de l'exercice de gainage choisi
	 */
	public void Gainage_ToString() {
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Session: ");
		System.out.println(" ");
		for (String s : listGainage.keySet()) {
			System.out.println("- " + s + ", " + listGainage.get(s) + " secondes.");
		}
	}
}