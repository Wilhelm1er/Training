package Swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class InterfaceRapports {
	panelData.removeAll();
	JPanel panelNorthChoix = new JPanel();
	JButton trainingButton = new JButton("Training");
	JButton challengeButton = new JButton("Challenge");

	window.getContentPane().removeAll();

	window.setLayout(new BorderLayout());
	window.add(panelNorthChoix, BorderLayout.NORTH);

	// panelWest.setLayout(new GridLayout(20,1));

	panelNorthChoix.add(trainingButton);
	panelNorthChoix.add(challengeButton);

	challengeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelData.removeAll();
			panelData.add(scrollChallenge);
			panelData.repaint();
			window.add(panelData, BorderLayout.CENTER);
			window.revalidate();
		}
	});
	trainingButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelData.removeAll();
			panelData.add(scrollTraining);
			panelData.repaint();
			window.add(panelData, BorderLayout.CENTER);
			window.revalidate();
		}
	});

	String[] colTraining = new String[] { "Date", "type", "Série", "Level", "Corde/Pause", "Temps" };
	JTable tableTraining = new JTable();

	DefaultTableModel modelTraining = new DefaultTableModel(colTraining, 0);

	modelTraining.setColumnIdentifiers(colTraining);

	scrollTraining = new JScrollPane(tableTraining);
	scrollTraining.setPreferredSize(new Dimension(500, 300));

	// panel.add(scrollTraining);

	DefaultTableCellRenderer custom = new DefaultTableCellRenderer();
	custom.setHorizontalAlignment(JLabel.CENTER); // centre les données de ton tableau

	for (List<String> d : trainingBdd.affichageTraining(name)) {
		modelTraining.addRow(new Object[] { d.get(0), d.get(1), d.get(2), d.get(3), d.get(4), d.get(5) });

	}
	tableTraining.setModel(modelTraining);

	TableColumn rope = tableTraining.getColumnModel().getColumn(4);
	rope.setCellRenderer(custom);
	rope.setPreferredWidth(40);
	TableColumn serie = tableTraining.getColumnModel().getColumn(2);
	serie.setCellRenderer(custom);
	serie.setPreferredWidth(30);
	TableColumn level = tableTraining.getColumnModel().getColumn(3);
	level.setCellRenderer(custom);
	level.setPreferredWidth(80);

	// panel.add(scrollTraining);

	String[] colChallenge = new String[] { "Date", "Challenge", "Temps", "Terminé" };
	JTable tableChallenge = new JTable();

	DefaultTableModel modelChallenge = new DefaultTableModel(colChallenge, 0);

	modelChallenge.setColumnIdentifiers(colChallenge);

	scrollChallenge = new JScrollPane(tableChallenge);
	scrollChallenge.setPreferredSize(new Dimension(500, 300));

	for (List<String> d : challengeBdd.affichageChallenge(name)) {
		modelChallenge.addRow(new Object[] { d.get(0), d.get(1), d.get(2), d.get(3) });
	}
	tableChallenge.setModel(modelChallenge);

}
