import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import bdd.Poids;
import bdd.Training;
import bdd.Utilisateur;

public class Menu {

	Utilisateur user = new Utilisateur();
	Training training =new Training();
	Poids poids = new Poids();
	private String name = "";
	DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	java.sql.Date dateS = new java.sql.Date(date.getTime());

	/**
	 * Appel du menu de selection de l'utilisateur, ou de la creation d'un nouvel utilisateur
	 * Interrogation de la bdd
	 */
	public void menu_user() throws InterruptedException {
		System.out.println("Liste des utilisateurs existant: ");
		user.selectAll();
		System.out.println(" ");

		System.out.print("Veuillez entrer votre nom: ");
		name = new Scanner(System.in).nextLine();
		user.create_User(name);
		System.out.println(" ");
		System.out.println("Bienvenue " + name);
		System.out.println(" ");

		this.menu_general();
	}

	/**
	 * Appel du menu general
	 * 
	 */
	public void menu_general() throws InterruptedException {
		System.out.println("Que souhaitez vous faire: ");
		System.out.println("1 - Faire un entrainement ");
		System.out.println("2 - Consulter mes derniers entrainements ");
		System.out.println("3 - Consulter ma courbe de poids ");
		System.out.println("4 - Quitter ");
		int choice_menu = new Scanner(System.in).nextInt();
		System.out.println("#####################################");
		System.out.println(" ");

		// Entrainements
		if (choice_menu == 1) {
			this.menu_entrainement();
		}
		// DERNIERS ENTRAINEMENTS
		if (choice_menu == 2) {
			training.training_Selected(name);
			System.out.println(" ");
			System.out.println("#####################################");
			System.out.println(" ");
			this.menu_general();
		}
		// CONSULTATION POIDS
		if (choice_menu == 3) {
			poids.user_Selected(name);
			System.out.println(" ");
			System.out.println("#####################################");
			System.out.println(" ");
			this.menu_general();
		}
		// QUITTER
		if (choice_menu == 4) {
			System.out.println("Au revoir! ");
			System.exit(0);
		}
	}
	/**
	 * Appel du menu de selection de l'entrainement
	 */

	public void menu_entrainement() throws InterruptedException {
		System.out.print("Veuillez entrer votre poids: ");
		
		// Ajout du poids
		String p = new Scanner(System.in).nextLine();
		double pds = Double.parseDouble(p);
		poids.ajout(name, pds, dateS);
		
		System.out.println("1 - Renforcement: ");
		System.out.println("2 - Musculation: ");
		System.out.println("3 - Gainage: ");

		int choice_exercice = new Scanner(System.in).nextInt();
		System.out.println("#####################################");
		System.out.println(" ");

		if (choice_exercice == 1) {
			Entrainements Renfo = new Entrainements();
			int level = Renfo.renforcement_Selection();
			Timer Timer_Renfo = new Timer(Renfo.renforcement(level), "Renforcement",name,dateS,level);
		}
		if (choice_exercice == 2) {
			Entrainements Muscu = new Entrainements();
			int level = Muscu.musculation_Selection();
			Timer Timer_Renfo = new Timer(Muscu.musculation(level), "Musculation",name,dateS,level);
		}
		if (choice_exercice == 3) {
			Entrainements Gain = new Entrainements();
			int level = Gain.gainage_Selection();
			Timer Timer_Gainage = new Timer(Gain.gainage(level), "Gainage",name,dateS,level);
		}
	}
}
