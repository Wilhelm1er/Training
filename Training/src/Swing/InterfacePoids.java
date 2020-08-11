package Swing;

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

import Listeners.InterfacePoidsActionListener;
import bdd.Poids;

public class InterfacePoids {
	private InterfacePrincipal IntGraphique = new InterfacePrincipal();
	private JPanel ContentPane = new JPanel();
	private Poids poids = new Poids();
	
	private JPanel panelCenter = new JPanel();
	private JPanel panelNorth = new JPanel();
	
	private JButton ajoutPoids = new JButton("Enregistrer");
	private JButton dataPoidsButton = new JButton("Données");
	private JTextField textePoids = new JTextField(10);
	
	private Date date = new Date();
	private java.sql.Date dateS = new java.sql.Date(date.getTime());
	
	public JPanel interfacePoids() {
		ContentPane.removeAll();
		
		ContentPane.add(panelNorth, BorderLayout.NORTH);
		ContentPane.add(panelCenter, BorderLayout.CENTER);

		panelNorth.add(dataPoidsButton);
		
		String[] colonne = new String[] { "Date", "Poids" };
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(colonne, 0);

		model.setColumnIdentifiers(colonne);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(550, 300));

		JLabel labelPoids = new JLabel("Entrer votre poids: ");
		
		ajoutPoids.addActionListener(new InterfacePoidsActionListener(this));
		dataPoidsButton.addActionListener(new InterfacePoidsActionListener(this));
		
		panelNorth.add(labelPoids);
		panelNorth.add(textePoids);
		panelNorth.add(ajoutPoids);

		for (String d : poids.user_Selected(IntGraphique.getName()).keySet()) {
			model.addRow(new Object[ ] { d, poids.user_Selected(IntGraphique.getName()).get(d) });

		}
		table.setModel(model);
		
		ContentPane.revalidate();

		return ContentPane;
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
	public JPanel getContentPane() {
		return ContentPane;
	}

}
