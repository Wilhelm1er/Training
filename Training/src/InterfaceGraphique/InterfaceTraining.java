package InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Listeners.TrainingActionListener;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class InterfaceTraining {
	private JPanel panelTraining = new JPanel();
	private JPanel panelCenterTRaining = new JPanel();

	private String typeTraining;
	private JTextArea descriptionTraining = new JTextArea(20, 30);

	private JLabel labelCorde = new JLabel("Temps de corde: ");
	private JTextField inputCorde = new JTextField("45", 10);
	private JLabel labelPause = new JLabel("Temps de pause: ");
	private JTextField inputPause = new JTextField("30", 10);
	private JLabel labelSerie = new JLabel("Nombre de série: ");
	private JTextField inputSerie = new JTextField("1", 10);

	private JComboBox<String> comboNiveau = new JComboBox<String>();
	private JLabel niveau = new JLabel("");

	private int nbreSerie;
	private JLabel labelOk = new JLabel("Lancer session:");
	private JButton okButton = new JButton("OK");
	private String name;

	/**
	 * Panel d'affichage de l'interface relative aux Trainings
	 *
	 * @param type entrainement selectionné
	 * @return panel de l'interface relative aux Trainings
	 */
	public JPanel interfaceTraining(String type) {
		typeTraining = type;
		panelTraining.removeAll();

		panelTraining.setLayout(new BorderLayout());
		JPanel panelNorth = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelSouth = new JPanel();

		if (type == "Renforcement") {
			panelWest.remove(niveau);
			comboNiveau.removeAllItems();
			String[] liste = { "Choix", "Débutant", "Intermédiaire", "Confirmé", "Elite" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			comboNiveau.setSelectedItem("Choix");
			panelWest.add(labelCorde);
			panelWest.add(inputCorde);
			panelWest.add(labelSerie);
			panelWest.add(inputSerie);
			niveau.setText("Niveau: ");
			panelWest.add(niveau);

		}
		if (type == "Musculation") {
			panelWest.remove(niveau);
			comboNiveau.removeAllItems();
			String[] liste = { "Choix", "Numéro 1", "Numéro 2", "Numéro 3" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			comboNiveau.setSelectedItem("Choix");
			panelWest.add(labelPause);
			panelWest.add(inputPause);
			niveau.setText("Numéro: ");
			panelWest.add(niveau);

		}
		if (type == "Gainage") {
			panelWest.remove(niveau);
			comboNiveau.removeAllItems();
			String[] liste = { "Choix", "Routine 1", "Routine 2" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			comboNiveau.setSelectedItem("Choix");
			panelWest.add(labelSerie);
			panelWest.add(inputSerie);
			niveau.setText("Routine: ");
			panelWest.add(niveau);

		}
		if (type == "Challenge") {
			panelWest.remove(niveau);
			comboNiveau.removeAllItems();
			String[] liste = { "Choix", "FBI", "Pompiers" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			niveau.setText("Challenge: ");
			panelWest.add(niveau);

		}

		panelWest.setLayout(new GridLayout(10, 1));

		panelTraining.add(panelNorth, BorderLayout.NORTH);
		panelTraining.add(panelWest, BorderLayout.WEST);
		panelTraining.add(panelSouth, BorderLayout.SOUTH);
		panelTraining.add(panelCenterTRaining, BorderLayout.CENTER);

		panelCenterTRaining.add(descriptionTraining);

		JLabel labelTraining = new JLabel(type);
		panelNorth.add(labelTraining);

		panelSouth.add(labelOk);
		panelSouth.add(okButton);

		inputCorde.setHorizontalAlignment(SwingConstants.CENTER);
		inputPause.setHorizontalAlignment(SwingConstants.CENTER);
		inputSerie.setHorizontalAlignment(SwingConstants.CENTER);

		panelWest.add(comboNiveau);

		panelTraining.repaint();

		okButton.addActionListener(new TrainingActionListener(this));
		comboNiveau.addActionListener(new TrainingActionListener(this));

		return panelTraining;
	}

	public JComboBox<String> getComboNiveau() {
		return comboNiveau;
	}

	public String getComboNiveauItem() {
		return (String) comboNiveau.getSelectedItem();
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JPanel getPanelCenterTRaining() {
		return panelCenterTRaining;
	}

	public int getDureeCorde() {
		return Integer.parseInt(inputCorde.getText());
	}

	public int getDureePause() {
		return Integer.parseInt(inputPause.getText());
	}

	public int getNbreSerie() {
		return Integer.parseInt(inputSerie.getText());
	}

	public String getTypeTraining() {
		return this.typeTraining;
	}

	public JTextArea getDescriptionTraining() {
		return descriptionTraining;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int setNbreSerie() {
		nbreSerie = Integer.parseInt(inputSerie.getText());
		return nbreSerie;
	}
}
