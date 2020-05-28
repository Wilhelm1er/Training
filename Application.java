import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws InterruptedException {
	
		Training T=new Training();
	
		Boolean Choix = false;
		do{
			System.out.println("Selectionner votre session: ");
			System.out.println("1 - Débutant: ");
			System.out.println("2 - Intermédiaire: ");
			System.out.println("3 - Confirmé: ");
			System.out.println("4 - Elite: ");
			int choice = new Scanner(System.in).nextInt();
			T.Training(choice);
			T.choix();
			System.out.println("Pouvons nous commencer l'entrainement? o/n");
			String rep = new Scanner(System.in).nextLine();
			if (rep.equals("o")) {
				Choix = true;
			}
		}while (Choix == false);
		
		System.out.println("Mettez vous en place");
		System.out.print("Démarrage dans: ");
		for(int i=5;i>0;i--) {
			System.out.println(i);
			Thread.sleep(1000);
		}
		System.out.print("Go: ");
		
		
	}
}
