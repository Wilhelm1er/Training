import java.util.Scanner;

public class Menu {
	
	public Menu() throws InterruptedException{
		
	System.out.println("Que souhaitez vous faire: ");

	System.out.println("1 - Faire un entrainement ");
	System.out.println("2 - Consulter mes derniers entrainements ");
	System.out.println("3 - Consulter ma courbe de poids ");
	System.out.println("4 - Quitter ");
	int choice_menu = new Scanner(System.in).nextInt();
	System.out.println("#####################################");
	System.out.println(" ");
	
	if (choice_menu == 1) {
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
	}
	if (choice_menu == 2) {
		System.out.println("En construction...");
		System.out.println(" ");
		System.out.println("#####################################");
		System.out.println(" ");
		Menu menu=new Menu();
	}
	if (choice_menu == 3) {
		System.out.println("En construction...");
		System.out.println(" ");
		System.out.println("#####################################");
		System.out.println(" ");
		Menu menu=new Menu();
		}
	if (choice_menu == 4) {
		System.out.println("Au revoir! ");
		System.exit(0);
		}
	}
}
