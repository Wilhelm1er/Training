package InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import BaseDeDonnees.ChallengeBdd;
import BaseDeDonnees.TrainingBdd;

/**
 * Interface relative aux rapports d'activités réalisées
 * 
 * @author Wilhelm1er
 */

public class InterfaceRapports {
	private InterfacePrincipale IntPrincipale = new InterfacePrincipale();
	private TrainingBdd trainingBdd = new TrainingBdd();
	private ChallengeBdd challengeBdd = new ChallengeBdd();

	private JPanel panelRapports = new JPanel();
	//private JPanel panelNorthChoix = new JPanel();
	
	private JButton trainingButton = new JButton("Training");
	private JButton challengeButton = new JButton("Challenge");

	private JTable tableTraining = new JTable();
	private JScrollPane scrollTraining = new JScrollPane(tableTraining);
	private JTable tableChallenge = new JTable();
	private JScrollPane scrollChallenge = new JScrollPane(tableChallenge);
	private String name;

	/**
	 * Panel d'affichage de l'interface relative aux Rapports
	 *
	 * @return panel de l'interface relative aux Rapports
	 */
	public JPanel interfaceRapports() {

		panelRapports.removeAll();

		//panelRapports.setLayout(new BorderLayout());
		//panelRapports.add(panelNorthChoix, BorderLayout.NORTH);

		//panelNorthChoix.add(trainingButton);
		//panelNorthChoix.add(challengeButton);

		String[] colTraining = new String[] { "Date", "type", "Série", "Level", "Corde/Pause", "Temps" };

		DefaultTableModel modelTraining = new DefaultTableModel(colTraining, 0);

		modelTraining.setColumnIdentifiers(colTraining);

		scrollTraining.setPreferredSize(new Dimension(500, 200));

		DefaultTableCellRenderer custom = new DefaultTableCellRenderer();
		custom.setHorizontalAlignment(SwingConstants.CENTER); // centre les données de ton tableau
		/*
		 * for (List<String> d : trainingBdd.affichageTraining(name)) {
		 * System.out.println(d); }
		 */
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

		String[] colChallenge = new String[] { "Date", "Challenge", "Temps", "Terminé" };

		DefaultTableModel modelChallenge = new DefaultTableModel(colChallenge, 0);

		modelChallenge.setColumnIdentifiers(colChallenge);

		scrollChallenge.setPreferredSize(new Dimension(500, 200));

		for (List<String> d : challengeBdd.affichageChallenge(name)) {
			modelChallenge.addRow(new Object[] { d.get(0), d.get(1), d.get(2), d.get(3) });
		}
		tableChallenge.setModel(modelChallenge);
		panelRapports.add(scrollTraining);
		panelRapports.add(scrollChallenge);
		
		panelRapports.revalidate();
		
		return panelRapports;
	}

	public JButton getTrainingButton() {
		return trainingButton;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JButton getChallengeButton() {
		return challengeButton;
	}

	public JPanel getPanelRapports() {
		return panelRapports;
	}

	public JScrollPane getScrollTraining() {
		return scrollTraining;
	}

	public JScrollPane getScrollChallenge() {
		return scrollChallenge;
	}
	/**
	 * Test de l'interface Session
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				InterfaceRapports intR = new InterfaceRapports();
				JFrame s = new JFrame();
				s.setSize(600, 500);
				s.setLocationRelativeTo(null);
				s.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				s.setVisible(true);
				s.add(intR.interfaceRapports());
			}
		});
	}
}
