import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;

/**
 * Application de Training, Version Java de l'appli produite par Ghost en Python
 * 3
 * 
 * @author Wilhelm1er
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Map<String, Integer> List_Renfo = new HashMap<String, Integer>();

		System.out.println("#####################################");
		System.out.println("     TRAINING made in Java  v1.0     ");
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.println("Que souhaitez vous faire: ");

		System.out.println("1 - Renforcement: ");
		System.out.println("2 - Musculation: ");
		System.out.println("3 - Gainage: ");

		int choice_exercice = new Scanner(System.in).nextInt();
		System.out.println("#####################################");
		System.out.println(" ");

		if (choice_exercice == 1) {
			Entrainements Renfo = new Entrainements();
			int level = Renfo.renforcement_Selection();
			Timer Timer_Renfo = new Timer(Renfo.renforcement(level), "Renforcement");
		}
		if (choice_exercice == 2) {
			Entrainements Muscu = new Entrainements();
			int level = Muscu.musculation_Selection();
			Timer Timer_Renfo = new Timer(Muscu.musculation(level), "Musculation");
		}
		if (choice_exercice == 3) {
			Entrainements Gain = new Entrainements();
			int level = Gain.gainage_Selection();
			Timer Timer_Gainage = new Timer(Gain.gainage(level), "Gainage");
		}
		
		System.out.print("Session TERMINEE");
	}
}