import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Description
 * Methode liées aux entrainements selectionnés
 * 
 * @author Wilhelm1er
 */

public class Entrainements {
	
	private Map<String, Integer> List_1 = new HashMap<String, Integer>();
	private Map<String, Integer> List_2 = new HashMap<String, Integer>();
	
	/**
	 * Selection du niveau de difficulté du mode Renforcement
	 */
	public void Renforcement_selection() {
	Boolean Choix_2 = false;
	do{
		System.out.println("Selectionner votre session: ");
		System.out.println("1 - Débutant: ");
		System.out.println("2 - Intermédiaire: ");
		System.out.println("3 - Confirmé: ");
		System.out.println("4 - Elite: ");
		int choice = new Scanner(System.in).nextInt();
		this.Renforcement(choice);
		this.choix_Renforcement();
		System.out.println("Pouvons nous commencer l'entrainement? o/n");
		String rep = new Scanner(System.in).nextLine();
		if (rep.equals("o")) {
			Choix_2 = true;
		}
	}while (Choix_2 == false);
	}
	
	/**
	 * Creation  de la liste de l'exercice de renforcement musculaire
	 * suivant le niveau de difficulté selectionné
	 * 
	 * @param level
	 * 			Niveau de difficulté selectionné
	 * @return List_1
	 * 			Liste générée correspondant à l'exercice de renforcement selectionné
	 */
	public Map<String, Integer> Renforcement(int level) {
		switch (level) {
		case 1:
			List_1.put("Abdo rameur", 15);
			List_1.put("Bras tendu coude", 10);
			List_1.put("Tractions", 5);
			List_1.put("Mountain Climbers", 15);
			List_1.put("Pompes", 5);
			break;
		case 2:
			List_1.put("Abdo rameur", 20);
			List_1.put("Bras tendu coude", 12);
			List_1.put("Tractions", 7);
			List_1.put("Mountain Climbers", 18);
			List_1.put("Pompes", 7);
			break;
		case 3:
			List_1.put("Abdo rameur", 25);
			List_1.put("Bras tendu coude", 20);
			List_1.put("Tractions", 15);
			List_1.put("Mountain Climbers", 25);
			List_1.put("Pompes", 15);
			break;
		case 4:
			List_1.put("Abdo rameur", 30);
			List_1.put("Bras tendu coude", 25);
			List_1.put("Tractions", 20);
			List_1.put("Mountain Climbers", 30);
			List_1.put("Pompes", 20);
			break;
		}
		return List_1;
	}
	/**
	 * Selection du niveau de difficulté du mode Gainage
	 */
	public void Gainage_selection() {
	Boolean Choix_3 = false;
	do{
		System.out.println("Selectionner votre session: ");
		System.out.println("1 - Routine 1: ");
		System.out.println("2 - Routine 2: ");
		int choice = new Scanner(System.in).nextInt();
		this.Gainage(choice);
		this.choix_Gainage();
		System.out.println("Pouvons nous commencer l'entrainement? o/n");
		String rep = new Scanner(System.in).nextLine();
		if (rep.equals("o")) {
			Choix_3 = true;
		}
	}while (Choix_3 == false);
	}
	/**
	 * Creation  de la liste de l'exercice de gainage
	 * suivant le niveau de difficulté selectionné
	 * 
	 * @param level
	 * 			Niveau de difficulté selectionné
	 * @return List_2
	 * 			Liste générée correspondant à l'exercice de gainage selectionné
	 */
	public  Map<String, Integer> Gainage(int level) {
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
		return List_1;	
	} 		
	/**
	 * Affichage du choix de l'exercice de renforcement choisi
	 */
	public void choix_Renforcement() {
		System.out.println("Session: ");
		for (String s : List_1.keySet()) {
			System.out.println("Exercices: " + s + " Répétitions: " + List_1.get(s));
		}
	}
	/**
	 * Affichage du choix de l'exercice de gainage choisi
	 */
	public void choix_Gainage() {
		System.out.println("Session: ");
		for (String s : List_2.keySet()) {
			System.out.println("Exercices: " + s + " Répétitions: " + List_2.get(s)+ " secondes.");
		}
	}
}