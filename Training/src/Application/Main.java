package Application;

import InterfaceGraphique.Login;

/**
 * Application de Training, Version Java de l'appli produite par Ghost en Python
 * 3
 * 
 * @author Wilhelm1er
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Login().login();
			}
		});
	}
}