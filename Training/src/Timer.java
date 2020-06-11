import java.util.Map;
/**
 * Description
 * Methode d'affichage en fonction de l'entrainement selectionné
 * @author Wilhelm1er
 */
public class Timer {

	public Timer(Map<String, Integer> List,String type) throws InterruptedException {
		switch (type) {
		case "Renforcement":
			
			System.out.println("Mettez vous en place");
			System.out.print("Démarrage dans: ");
			
			for(int i=5;i>0;i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			
			System.out.println("Go: ");
			
			for (String mapentry : List.keySet()) {
			System.out.println("Exercice: "+mapentry);
			}
			
			break;
			
		case "Gainage":
			
			System.out.println("Mettez vous en place");
			System.out.print("Démarrage dans: ");
			
			for(int i=5;i>0;i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			
			System.out.println("Go: ");
			
			for (String mapentry : List.keySet()) {
			System.out.println("Exercice: "+mapentry);
			}
			
			break;
		}
	}
}