package InterfaceGraphique;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */

public class InterfaceProfil {
	private JPanel panelProfil = new JPanel();
	private JPanel panelNorthChoix = new JPanel();
	
	private String name;
	private JLabel labelName=new JLabel(" ");

	/**
	 * Panel d'affichage de l'interface relative au profil utilisateurs
	 *
	 * @return panel de l'interface relative au profil utilisateurs
	 */
	public JPanel interfaceProfil() {

		panelProfil.removeAll();

		panelProfil.setLayout(new BorderLayout());
		panelProfil.add(panelNorthChoix, BorderLayout.NORTH);
		
		labelName.setText("Nom: "+name);
		
		panelNorthChoix.add(labelName);
	
		panelProfil.revalidate();
		
		return panelProfil;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JPanel getPanelProfil() {
		return panelProfil;
	}
}
