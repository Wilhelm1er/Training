import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("BONJOUR");
		System.out.println("Que souhaitez vous faire: ");
		
		System.out.println("1 - Training: ");
		System.out.println("2 - Gainage: ");
		int choice_exercice = new Scanner(System.in).nextInt();
		
		if(choice_exercice==1) {
				Training Renfo=new Training();
				
				Boolean Choix_2 = false;
				do{
					System.out.println("Selectionner votre session: ");
					System.out.println("1 - Débutant: ");
					System.out.println("2 - Intermédiaire: ");
					System.out.println("3 - Confirmé: ");
					System.out.println("4 - Elite: ");
					int choice = new Scanner(System.in).nextInt();
					Renfo.Renforcement(choice);
					Renfo.choix_Renforcement();
					System.out.println("Pouvons nous commencer l'entrainement? o/n");
					String rep = new Scanner(System.in).nextLine();
					if (rep.equals("o")) {
						Choix_2 = true;
					}
				}while (Choix_2 == false);
				}
				
		if(choice_exercice==2) {
				Training Gain=new Training();
				
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
				
		}
		
		System.out.println("Mettez vous en place");
		System.out.print("Démarrage dans: ");
		for(int i=5;i>0;i--) {
			System.out.println(i);
			Thread.sleep(1000);
		}
		System.out.println("Go: ");

	}
}