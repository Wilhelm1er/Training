import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Application de Training, Version Java de l'appli produite par Ghost en Python
 * 3
 * 
 * @author Wilhelm1er
 */

public class Main {

	public static void main(String[] args) throws InterruptedException{
		
		Menu menu=new Menu();
		
		//Recuperation date du jour
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		java.sql.Date dateS = new java.sql.Date(date.getTime());
		//System.out.println(format.format(date));
		
		System.out.println("#####################################");
		System.out.println("     TRAINING made in Java  v1.0     ");
		System.out.println("#####################################");
		System.out.println(" ");
		menu.menu_user();
		// Affichage utilisateur enregistre
		
		System.out.println(" ");
		System.out.println("#####################################");
		System.out.println(" ");
	
		//poids.ajout(name, poids, dateS);
		
	}
}