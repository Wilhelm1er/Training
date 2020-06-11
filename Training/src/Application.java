import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Description
 *
 * Application de Training, 
 * Version Java de l'appli produite par Ghost en Python 3
 * 
 * @author Wilhelm1er
 */

public class Application {
	
	public static void main(String[] args) throws InterruptedException {
		
		Map<String, Integer> List_Renfo = new HashMap<String, Integer>();
		
		System.out.println("BONJOUR");
		System.out.println("Que souhaitez vous faire: ");
		
		System.out.println("1 - Training: ");
		System.out.println("2 - Gainage: ");
		int choice_exercice = new Scanner(System.in).nextInt();
		
		if(choice_exercice==1) {
				Entrainements Renfo=new Entrainements();
				
				Boolean Choix_2 = false;
				do{
					System.out.println("Selectionner votre session: ");
					System.out.println("1 - Débutant: ");
					System.out.println("2 - Intermédiaire: ");
					System.out.println("3 - Confirmé: ");
					System.out.println("4 - Elite: ");
					int choice = new Scanner(System.in).nextInt();
					Renfo.Renforcement(choice);
					//Creation Map de l'exercice selectionne
					List_Renfo = new HashMap<String, Integer>(Renfo.Renforcement(choice));
					
					Renfo.choix_Renforcement();
					System.out.println("Pouvons nous commencer l'entrainement? o/n");
					String rep = new Scanner(System.in).nextLine();
					if (rep.equals("o")) {
						Choix_2 = true;
					}
				}while (Choix_2 == false);
				
				Timer Timer_Renfo=new Timer(List_Renfo,"Renforcement");
				
			}

		if(choice_exercice==2) {
				Entrainements Gain=new Entrainements();
				
				Boolean Choix_3 = false;
				do{
					System.out.println("Selectionner votre session: ");
					System.out.println("1 - Routine 1: ");
					System.out.println("2 - Routine 2: ");
					int choice = new Scanner(System.in).nextInt();
					Gain.Gainage(choice);
					Gain.choix_Gainage();
					System.out.println("Pouvons nous commencer l'entrainement? o/n");
					String rep = new Scanner(System.in).nextLine();
					if (rep.equals("o")) {
						Choix_3 = true;
					}
				}while (Choix_3 == false);	
				
				Timer Timer_Gainage=new Timer(List_Renfo,"Gainage");
			}
	}
}