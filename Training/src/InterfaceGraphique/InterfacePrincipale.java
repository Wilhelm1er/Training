package InterfaceGraphique;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Listeners.MenuActionListener;

/**
 * Interface principale
 * 
 * @author Wilhelm1er
 */
public class InterfacePrincipale {

	private JFrame intPrincipale = new JFrame("Training App");
	private Menu menu = new Menu();
	
	private String name;

	/**
	 * Frame d'affichage de l'interface principale
	 *
	 */
	public void interfacePrincipale() {
		intPrincipale.getContentPane().removeAll();
		menu.setMenuUser(name);
		intPrincipale.setJMenuBar(menu.menu());

		intPrincipale.setSize(600, 500);
		intPrincipale.setLocationRelativeTo(null);
		intPrincipale.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		intPrincipale.setVisible(true);

		intPrincipale.revalidate();

		menu.getQuitter().addActionListener(new MenuActionListener(this));
		menu.getLogout().addActionListener(new MenuActionListener(this));
		menu.getRenforcement().addActionListener(new MenuActionListener(this));
		menu.getMusculation().addActionListener(new MenuActionListener(this));
		menu.getGainage().addActionListener(new MenuActionListener(this));
		menu.getChallenge().addActionListener(new MenuActionListener(this));
		menu.getPoids().addActionListener(new MenuActionListener(this));
		menu.getRapports().addActionListener(new MenuActionListener(this));
	}

	public JFrame getFrame() {
		return intPrincipale;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}