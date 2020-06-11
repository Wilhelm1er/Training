import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Application de Training, 
 * Version Java de l'appli produite par Ghost en Python 3
 * 
 * @author Wilhelm1er
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Map<String, Integer> List_Renfo = new HashMap<String, Integer>();

		System.out.println("BONJOUR");
		System.out.println("Que souhaitez vous faire: ");

		System.out.println("1 - Training: ");
		System.out.println("2 - Gainage: ");

		int choice_exercice = new Scanner(System.in).nextInt();

		if (choice_exercice == 1) {
			Entrainements Renfo = new Entrainements();
			Renfo.Renforcement_selection();
			Timer Timer_Renfo = new Timer(List_Renfo, "Renforcement");
		}
		if (choice_exercice == 2) {
			Entrainements Gain = new Entrainements();
			Gain.Gainage_selection();
			Timer Timer_Gainage = new Timer(List_Renfo, "Gainage");
		}
	}
}