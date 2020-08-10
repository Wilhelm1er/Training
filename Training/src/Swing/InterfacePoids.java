package Swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterfacePoids {
	panelData.removeAll();
	panelNorthChoix.removeAll();
	window.getContentPane().removeAll();

	JButton dataPoidsButton = new JButton("Données");
	panelNorthChoix.add(dataPoidsButton);

	window.setLayout(new BorderLayout());
	window.add(panelNorthChoix, BorderLayout.NORTH);
	window.add(panelData, BorderLayout.CENTER);

	String[] colonne = new String[] { "Date", "Poids" };
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel(colonne, 0);

	model.setColumnIdentifiers(colonne);

	JScrollPane scroll = new JScrollPane(table);
	scroll.setPreferredSize(new Dimension(550, 300));

	JLabel labelPoids = new JLabel("Entrer votre poids: ");
	JTextField textePoids = new JTextField(10);
	JButton ajoutPoids = new JButton("Enregistrer");

	ajoutPoids.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Ajout du poids
			String p = textePoids.getText();
			try {
				double pds = Double.parseDouble(p);
				poids.ajout(name, pds, dateS);
				interfacePoids();
				window.revalidate();
			} catch (NumberFormatException f) {
				System.out.println(f);
			}

		}

	});
	dataPoidsButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelData.removeAll();
			panelData.add(scroll);
			panelData.repaint();
			window.add(panelData, BorderLayout.CENTER);
			window.revalidate();
		}
	});

	panelNorthChoix.add(labelPoids);
	panelNorthChoix.add(textePoids);
	panelNorthChoix.add(ajoutPoids);

	for (String d : poids.user_Selected(name).keySet()) {
		model.addRow(new Object[] { d, poids.user_Selected(name).get(d) });

	}
	table.setModel(model);
}
