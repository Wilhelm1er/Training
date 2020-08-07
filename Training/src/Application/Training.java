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

	/**
	 * Creation de la liste de l'exercice de renforcement musculaire suivant le
	 * niveau de difficulté selectionné
	 * 
	 * @param level Niveau de difficulté selectionné
	 * @return List_1 Liste générée correspondant au niveau de l'entrainement de
	 *         renforcement selectionné
	 */
	public Map<String, Integer> training(String type,String level) {
		
		if (type.equals("Renforcement")) {
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
		if (type.equals("Musculation")) {
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
		if (type.equals("Gainage")) {
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
	 * Affichage du choix de l'exercice choisi
	 */
	public String affichageTraining(String level) {
		StringBuilder str = new StringBuilder();

		switch (level) {
		case "Choix":
			str.append("Choisissez un niveau");
			break;
		case "Débutant":
			str.append("Matériels:");
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Corde à sauter");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("Bras tendu coude: 10");
			str.append("\n");
			str.append("Tractions: 5");
			str.append("\n");
			str.append("Abdo rameur: 15");
			str.append("\n");
			str.append("Mountain Climbers: 15");
			str.append("\n");
			str.append("Pompes: 5");
			str.append("\n");
			str.append("\n");
			
			break;
		case "Intermédiaire":
			str.append("Matériels:");
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Corde à sauter");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("Bras tendu coude: 12");
			str.append("\n");
			str.append("Tractions: 7");
			str.append("\n");
			str.append("Abdo rameur: 20");
			str.append("\n");
			str.append("Mountain Climbers: 18");
			str.append("\n");
			str.append("Pompes: 7");
			str.append("\n");
			break;
		case "Confirmé":
			str.append("Matériels:");
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Corde à sauter");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("Bras tendu coude: 20");
			str.append("\n");
			str.append("Tractions: 15");
			str.append("\n");
			str.append("Abdo rameur: 25");
			str.append("\n");
			str.append("Mountain Climbers: 25");
			str.append("\n");
			str.append("Pompes: 15");
			str.append("\n");
			break;
		case "Elite":
			str.append("Matériels:");
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Corde à sauter");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("Bras tendu coude: 25");
			str.append("\n");
			str.append("Tractions: 20");
			str.append("\n");
			str.append("Abdo rameur: 30");
			str.append("\n");
			str.append("Mountain Climbers: 30");
			str.append("\n");
			str.append("Pompes: 20");
			str.append("\n");
			break;
		case "Numéro 1":
			str.append("Matériels:");
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Barre à dips");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("Dips: 5");
			str.append("\n");
			str.append("Pompes pieds surélevés: 10");
			str.append("\n");
			str.append("Pompes: 10");
			str.append("\n");
			str.append("Tractions: 10");
			str.append("\n");
			break;
		case "Numéro 2":
			str.append("Matériels:");
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Barre à dips");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("Dips: 10");
			str.append("\n");
			str.append("Pompes pieds surélevés: 15");
			str.append("\n");
			str.append("Pompes: 15");
			str.append("\n");
			str.append("Tractions: 15");
			str.append("\n");
			break;
		case "Routine 1":
			str.append("Matériels:");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("La Planche: 60s");
			str.append("\n");
			str.append("Superman: 60s");
			str.append("\n");
			str.append("La Planche Latérale Gauche: 45s");
			str.append("\n");
			str.append("La Planche Latérale Droite: 45s");
			str.append("\n");
			str.append("La Planche Dos: 60s");
			str.append("\n");
			break;
		case "Routine 2":
			str.append("Matériels:");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("La Planche: 60s");
			str.append("\n");
			str.append("La Planche Latérale Gauche avec torsion: 30s");
			str.append("\n");
			str.append("La Planche Latérale Droite avec torsion: 30s");
			str.append("\n");
			str.append("La Planche 1 bras 1 jambe levée gauche: 30s");
			str.append("\n");
			str.append("La Planche 1 bras 1 jambe levée droit: 30s");
			str.append("\n");
			break;
		case "FBI":
			str.append("Challenge FBI");
			str.append("\n");
			str.append("Durée 3 min 31");
			str.append("\n");
			break;
		case "Pompiers":
			str.append("Challenge Pompiers");
			str.append("\n");
			str.append("Durée 4 min 50");
			str.append("\n");
			break;
		default:
			str.append("Choisissez un niveau");
		}
		return str.toString();
	}
}