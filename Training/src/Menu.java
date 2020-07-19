import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import bdd.ChallengeBdd;
import bdd.Poids;
import bdd.TrainingBdd;
import bdd.Utilisateur;

public class Menu {

	Utilisateur user = new Utilisateur();
	TrainingBdd training = new TrainingBdd();
	ChallengeBdd challengeBdd=new ChallengeBdd();
	Poids poids = new Poids();
	private String name = "";
	DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	java.sql.Date dateS = new java.sql.Date(date.getTime());

	/**
	 * Appel du menu de selection de l'utilisateur, ou de la creation d'un nouvel
	 * utilisateur Interrogation de la bdd
	 */
	public void menu_user() throws InterruptedException {
		System.out.println("Liste des utilisateurs existant: ");
		user.selectAll();
		System.out.println(" ");

		System.out.print("Veuillez entrer votre nom: ");
		name = new Scanner(System.in).nextLine();
		// user.create_User(name);
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
			challengeBdd.affichageChallenge(name);
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
		
		this.enregistrementPoids();
		System.out.println("1 - Renforcement");
		System.out.println("2 - Musculation");
		System.out.println("3 - Gainage");
		System.out.println("4 - Challenge");

		int choice_exercice = new Scanner(System.in).nextInt();
		System.out.println("#####################################");
		System.out.println(" ");

		if (choice_exercice == 1) {
			Training Renfo = new Training();
			int level = Renfo.renforcement_Selection();
			Timer Timer_Renfo = new Timer(Renfo.renforcement(level), "Renforcement", name, dateS, level);
		}
		if (choice_exercice == 2) {
			Training Muscu = new Training();
			int level = Muscu.musculation_Selection();
			Timer Timer_Renfo = new Timer(Muscu.musculation(level), "Musculation", name, dateS, level);
		}
		if (choice_exercice == 3) {
			Training Gain = new Training();
			int level = Gain.gainage_Selection();
			Timer Timer_Gainage = new Timer(Gain.gainage(level), "Gainage", name, dateS, level);
		}
		if (choice_exercice == 4) {
			this.menu_challenge();
		}
	}
	
	/**
	 * Appel du menu de selection du challenge
	 */

	public void menu_challenge() throws InterruptedException {
		System.out.println("1 - FBI");
		System.out.println("2 - Pompiers");

		int choice_challenge = new Scanner(System.in).nextInt();
		System.out.println("#####################################");
		System.out.println(" ");

		if (choice_challenge == 1) {
			String challengeName = "FBI";
			Challenge challenge = new Challenge();
			challenge.fbi(name, dateS, challengeName);
		}
		if (choice_challenge == 2) {
			String challengeName = "Pompiers";
			Challenge challenge = new Challenge();
			challenge.pompiers(name, dateS, challengeName);
		}
	}
	/**
	 * Choix enregistrement poids
	 */

	public void enregistrementPoids() throws InterruptedException {
		
		System.out.println("Enregistrer votre poids? o/n");
		String rep = new Scanner(System.in).nextLine();
		if (rep.equals("o")) {
			System.out.print("Veuillez entrer votre poids: ");

			// Ajout du poids
			String p = new Scanner(System.in).nextLine();
			double pds = Double.parseDouble(p);
			poids.ajout(name, pds, dateS);
		}	
		if (rep.equals("n")) {
			
		}
	}
}
