package Application;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import Swing.Principal;

/**
 * Methodes liées aux entrainements selectionnés
 * 
 * @author Wilhelm1er
 */

public class Training {

	private Map<String, Integer> listTraining = new LinkedHashMap<String, Integer>();

	Principal principal = new Principal();
	String typeTraining = principal.getTypeTraining();
	// Renforcement

	/**
	 * Creation de la liste de l'exercice de renforcement musculaire suivant le
	 * niveau de difficulté selectionné
	 * 
	 * @param level Niveau de difficulté selectionné
	 * @return List_1 Liste générée correspondant au niveau de l'entrainement de
	 *         renforcement selectionné
	 */
	public Map<String, Integer> training(String level) {
		typeTraining = principal.getTypeTraining();
		System.out.println("seconde type: "+typeTraining);
		if (typeTraining.equals("Renforcement")) {
			switch (level) {
			case "Débutant":
				listTraining.put("Bras tendu coude", 10);
				listTraining.put("Tractions", 5);
				listTraining.put("Abdo rameur", 15);
				listTraining.put("Mountain Climbers", 15);
				listTraining.put("Pompes", 5);
				break;
			case "Intermédiaire":
				listTraining.put("Bras tendu coude", 12);
				listTraining.put("Tractions", 7);
				listTraining.put("Abdo rameur", 20);
				listTraining.put("Mountain Climbers", 18);
				listTraining.put("Pompes", 7);
				break;
			case "Confirmé":
				listTraining.put("Bras tendu coude", 20);
				listTraining.put("Tractions", 15);
				listTraining.put("Abdo rameur", 25);
				listTraining.put("Mountain Climbers", 25);
				listTraining.put("Pompes", 15);
				break;
			case "Elite":
				listTraining.put("Bras tendu coude", 25);
				listTraining.put("Tractions", 20);
				listTraining.put("Abdo rameur", 30);
				listTraining.put("Mountain Climbers", 30);
				listTraining.put("Pompes", 20);
				break;
			}}
		if (typeTraining.equals("Musculation")) {
			switch (level) {
			case "Niveau 1":
				listTraining.put("Dips", 5);
				listTraining.put("Pompes pieds surélevés", 10);
				listTraining.put("Pompes", 10);
				listTraining.put("Tractions", 10);
				break;
			case "Niveau 2":
				listTraining.put("Dips", 10);
				listTraining.put("Pompes pieds surélevés", 15);
				listTraining.put("Pompes", 15);
				listTraining.put("Tractions", 15);
				break;
			}}
		if (typeTraining.equals("Gainage")) {
			switch (level) {
			case "Routine 1":
				listTraining.put("La Planche", 60);
				listTraining.put("Superman", 60);
				listTraining.put("La Planche Latérale Gauche", 45);
				listTraining.put("La Planche Latérale Droite", 45);
				listTraining.put("La Planche Dos", 60);
				break;
			case "Routine 2":
				listTraining.put("La Planche", 60);
				listTraining.put("La Planche Latérale Gauche avec torsion", 30);
				listTraining.put("La Planche Latérale Droite avec torsion", 30);
				listTraining.put("La Planche 1 bras 1 jambe levée gauche", 30);
				listTraining.put("La Planche 1 bras 1 jambe levée droit", 30);
				break;
			}}
		
		return listTraining;
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
			return "- " + s + ", " + listRenfo.get(s) + " Répétitions.";
		}
		return null;
	}

	// Musculation

	/**
	 * Affichage du choix de l'exercice de musculation choisi
	 */
	public void musculation_ToString() {
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Session: ");
		System.out.println(" ");
		for (String s : listMuscu.keySet()) {
			System.out.println("- " + s + ", " + listMuscu.get(s) + " Répétitions.");
		}
	}

	// Gainage

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