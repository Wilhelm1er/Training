package Application;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Swing.Navigateur;
import Swing.Principal;

/**
 * Application de Training, Version Java de l'appli produite par Ghost en Python
 * 3
 * 
 * @author Wilhelm1er
 */

public class Main {

	public static void main(String[] args) throws InterruptedException{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	         @Override
	         public void run() {
	            //new Principal().principal();  
	        	 new Navigateur().Navigateur();
	         }
	      });
		
		//Recuperation date du jour
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		java.sql.Date dateS = new java.sql.Date(date.getTime());
		
		System.out.println(" ");
		System.out.println("#####################################");
		System.out.println(" ");
		
	}
}