package InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BaseDeDonnées.PoidsBdd;
import Listeners.PoidsActionListener;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */

public class InterfacePoids {
	private InterfacePrincipale intPrincipale = new InterfacePrincipale();
	private PoidsBdd poids = new PoidsBdd();

	private JPanel panelPoids = new JPanel();
	private JPanel panelCenter = new JPanel();

	private JButton ajoutPoids = new JButton("Enregistrer");
	private JButton dataPoidsButton = new JButton("Données");
	private JTextField textePoids = new JTextField(10);
	private JTable table = new JTable();
	private JScrollPane scroll = new JScrollPane(table);

	private Date date = new Date();
	private java.sql.Date dateS = new java.sql.Date(date.getTime());

	private String name;

	/**
	 * Panel d'affichage de l'interface relative au Poids
	 *
	 * @return panel de l'interface relative au Poids
	 * 
	 */
	public JPanel interfacePoids() {

		panelPoids.removeAll();

		JPanel panelNorth = new JPanel();

		panelPoids.setLayout(new BorderLayout());

		panelPoids.add(panelNorth, BorderLayout.NORTH);
		panelPoids.add(panelCenter, BorderLayout.CENTER);

		//panelNorth.add(dataPoidsButton);

		String[] colonne = new String[] { "Date", "Poids" };

		DefaultTableModel model = new DefaultTableModel(colonne, 0);

		model.setColumnIdentifiers(colonne);

		scroll.setPreferredSize(new Dimension(400, 300));

		JLabel labelPoids = new JLabel("Entrer votre poids: ");

		ajoutPoids.addActionListener(new PoidsActionListener(this));
		dataPoidsButton.addActionListener(new PoidsActionListener(this));

		panelNorth.add(labelPoids);
		panelNorth.add(textePoids);
		panelNorth.add(ajoutPoids);

		for (String d : poids.user_Selected(name).keySet()) {
			model.addRow(new Object[] { d, poids.user_Selected(name).get(d) });

		}
		table.setModel(model);

		panelCenter.add(scroll);
		panelPoids.revalidate();

		return panelPoids;
	}

	public JButton getAjoutPoids() {
		return ajoutPoids;
	}

	public JButton getDataPoidsButton() {
		return dataPoidsButton;
	}

	public JTextField getTextePoids() {
		return textePoids;
	}

	public java.sql.Date getDateS() {
		return dateS;
	}

	public JPanel getPanelPoids() {
		return panelPoids;
	}

	public JPanel getPanelCenter() {
		return panelCenter;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
