import java.util.Scanner;

/**
 * Application de Training, Version Java de l'appli produite par Ghost en Python
 * 3
 * 
 * @author Wilhelm1er
 */

public class Main {

	public static void main(String[] args) throws InterruptedException{

		System.out.println("#####################################");
		System.out.println("     TRAINING made in Java  v1.0     ");
		System.out.println("#####################################");
		System.out.println(" ");
		System.out.print("Veuillez entrer votre nom: ");
		String name = new Scanner(System.in).nextLine();
		System.out.println(" ");
		System.out.println("Bienvenue "+name);
		System.out.println(" ");
		
		Menu menu=new Menu();
	}
}