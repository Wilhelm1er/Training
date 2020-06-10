import java.util.HashMap;
import java.util.Map;

public class Training {
	
	private Map<String, Integer> List = new HashMap<String, Integer>();
	
	public Map<String, Integer> Training(int level) {
		switch (level) {
		case 1:
			List.put("Abdo rameur", 15);
			List.put("Bras tendu coude", 10);
			List.put("Tractions", 5);
			List.put("Mountain Climbers", 15);
			List.put("Pompes", 5);
			break;
		case 2:
			List.put("Abdo rameur", 20);
			List.put("Bras tendu coude", 12);
			List.put("Tractions", 7);
			List.put("Mountain Climbers", 18);
			List.put("Pompes", 7);
			break;
		case 3:
			List.put("Abdo rameur", 25);
			List.put("Bras tendu coude", 20);
			List.put("Tractions", 15);
			List.put("Mountain Climbers", 25);
			List.put("Pompes", 15);
			break;
		case 4:
			List.put("Abdo rameur", 30);
			List.put("Bras tendu coude", 25);
			List.put("Tractions", 20);
			List.put("Mountain Climbers", 30);
			List.put("Pompes", 20);
			break;
		}
		return List;
	}

	public void choix() {
		System.out.println("Session: ");
		for (String s : List.keySet()) {
			System.out.println("Exercices: " + s + " Répétitions: " + List.get(s));
		}
	}
}