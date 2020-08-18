package Application;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Méthodes liées aux entrainements selectionnés
 * 
 * @author Wilhelm1er
 */

public class Training {

	private Map<String, Integer> listTraining = new LinkedHashMap<String, Integer>();

	/**
	 * Creation de la liste de l'entrainement suivant le niveau de difficulté
	 * selectionné
	 * 
	 * @param level Niveau de difficulté selectionné
	 * @param type  Entrainement selectionné
	 * 
	 * @return listTraining Liste générée correspondant à l'entrainement et son
	 *         niveau de difficulté
	 */
	public Map<String, Integer> training(String type, String level) {

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
			}
		}
		if (type.equals("Musculation")) {
			switch (level) {
			case "Numéro 1":
				listTraining.put("Dips", 5);
				listTraining.put("Pompes pieds surélevés", 5);
				listTraining.put("Pompes", 5);
				listTraining.put("Tractions", 5);
				break;
			case "Numéro 2":
				listTraining.put("Dips", 7);
				listTraining.put("Pompes pieds surélevés", 10);
				listTraining.put("Pompes", 10);
				listTraining.put("Tractions", 7);
				break;
			case "Numéro 3":
				listTraining.put("Dips", 10);
				listTraining.put("Pompes pieds surélevés", 15);
				listTraining.put("Pompes", 15);
				listTraining.put("Tractions", 10);
				break;
			}
		}
		if (type.equals("Gainage")) {
			switch (level) {
			case "Routine 1":
				listTraining.put("Planche bras tendu 1", 60);
				listTraining.put("Planche coude 1", 30);
				listTraining.put("Planche un pied levé /30s", 60);
				listTraining.put("Coté Gauche/Droite", 60);
				listTraining.put("Planche bras tendu 2", 30);
				listTraining.put("Planche coude 2", 60);
				break;
			case "Routine 2":
				listTraining.put("Planche bras tendu 1", 90);
				listTraining.put("Planche coude 1", 90);
				listTraining.put("Planche un pied levé /45s", 90);
				listTraining.put("Coté Gauche/Droite", 90);
				listTraining.put("Planche bras tendu 2", 60);
				listTraining.put("Planche coude 2", 90);
				break;
			}
		}

		return listTraining;
	}

	/**
	 * Affichage en fonction de l'intensité d'entrainement choisi
	 * 
	 * @param level Niveau d'intensité
	 * 
	 * @return String Texte récapitulatif des exercices et du matériel nécessaire
	 * 
	 */
	public String affichageTraining(String level) {
		StringBuilder str = new StringBuilder();
		if (level == null) {
			level = "Choix";
		}
		switch (level) {
		case "Choix":
			str.append("Choisissez un niveau");
			break;
		case "Débutant":
			str.append("Matériels:");
			str.append("\n");
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Corde à sauter");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
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

			break;
		case "Intermédiaire":
			str.append("Matériels:");
			str.append("\n");
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Corde à sauter");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
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
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Corde à sauter");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
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
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Corde à sauter");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
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
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Barre à dips");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("\n");
			str.append(" - 6x 5 Dips");
			str.append("\n");
			str.append(" - 6x 5 Pompes pieds surélevés");
			str.append("\n");
			str.append(" - 6x 5 Pompes");
			str.append("\n");
			str.append(" - 6x 7 Tractions");
			str.append("\n");
			break;
		case "Numéro 2":
			str.append("Matériels:");
			str.append("\n");
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Barre à dips");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("\n");
			str.append(" - 6x 7 Dips");
			str.append("\n");
			str.append(" - 6x 10 Pompes pieds surélevés");
			str.append("\n");
			str.append(" - 6x 10 Pompes");
			str.append("\n");
			str.append(" - 6x 7 Tractions");
			str.append("\n");
			break;
		case "Numéro 3":
			str.append("Matériels:");
			str.append("\n");
			str.append("\n");
			str.append("Barre de traction");
			str.append("\n");
			str.append("Barre à dips");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("\n");
			str.append(" - 6x 10 Dips");
			str.append("\n");
			str.append(" - 6x 15 Pompes pieds surélevés");
			str.append("\n");
			str.append(" - 6x 15 Pompes");
			str.append("\n");
			str.append(" - 6x 10 Tractions");
			str.append("\n");
			break;
		case "Routine 1":
			str.append("Matériels:");
			str.append("\n");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("\n");
			str.append("Planche bras tendu: 60s");
			str.append("\n");
			str.append("Planche coude: 60s");
			str.append("\n");
			str.append("Planche un pied levé /30s: 60s");
			str.append("\n");
			str.append("Coté Gauche/Droite /30sec: 60s");
			str.append("\n");
			str.append("Planche bras tendu: 30s");
			str.append("\n");
			str.append("Planche coude: 60s");
			str.append("\n");
			break;
		case "Routine 2":
			str.append("Matériels:");
			str.append("\n");
			str.append("\n");
			str.append("Tapis");
			str.append("\n");
			str.append("\n");
			str.append("Exercices:");
			str.append("\n");
			str.append("\n");
			str.append("Planche bras tendu: 1min30");
			str.append("\n");
			str.append("Planche coude: 1min30");
			str.append("\n");
			str.append("Planche un pied levé /45s: 1min30");
			str.append("\n");
			str.append("Coté Gauche/Droite /45sec: 1min30");
			str.append("\n");
			str.append("Planche bras tendu: 45s");
			str.append("\n");
			str.append("Planche coude: 1min30");
			str.append("\n");
			break;
		case "FBI":
			str.append("Challenge FBI");
			str.append("\n");
			str.append("Durée 4 min 50");
			str.append("\n");
			break;
		case "Pompiers":
			str.append("Challenge Pompiers");
			str.append("\n");
			str.append("Durée 3 min 31");
			str.append("\n");
			break;
		default:
			str.append("Choisissez un niveau");
		}
		return str.toString();
	}
}