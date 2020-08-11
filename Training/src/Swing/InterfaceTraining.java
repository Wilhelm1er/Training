package Swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Listeners.InterfaceTrainingActionListener;

public class InterfaceTraining {
	
	private JComboBox<String> comboNiveau = new JComboBox<String>();
	private JPanel panelCenterTRaining = new JPanel();
	private String typeTraining;
	private JPanel ContentPane = new JPanel();

	private JTextArea descriptionTraining = new JTextArea(20, 30);

	private JLabel labelCorde = new JLabel("Temps de corde: ");
	private JTextField inputCorde = new JTextField("45", 10);
	private JLabel labelPause = new JLabel("Temps de pause: ");
	private JTextField inputPause = new JTextField("30", 10);
	private JLabel labelSerie = new JLabel("Nombre de série: ");
	private JTextField inputSerie = new JTextField("1", 10);
	private JLabel niveau = new JLabel("");
	private int dureeCorde = 45;
	private int dureePause = 30;
	private int nbreSerie = 1;
	private JLabel demarrer = new JLabel("Lancer session:");
	private JButton demarrerButton = new JButton("Démarrer");

	public JPanel interfaceTraining(String type) {
	
		ContentPane.removeAll();

		JPanel panelNorth = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelSouth = new JPanel();

		panelWest.setLayout(new GridLayout(20, 1));

		ContentPane.add(panelNorth, BorderLayout.NORTH);
		ContentPane.add(panelWest, BorderLayout.WEST);
		ContentPane.add(panelSouth, BorderLayout.SOUTH);

		panelCenterTRaining.add(descriptionTraining);
		ContentPane.add(panelCenterTRaining, BorderLayout.EAST);

		JLabel labelTraining = new JLabel(typeTraining);
		panelNorth.add(labelTraining);

		panelSouth.add(demarrer);
		panelSouth.add(demarrerButton);

		inputCorde.setHorizontalAlignment(JTextField.CENTER);
		inputPause.setHorizontalAlignment(JTextField.CENTER);
		inputSerie.setHorizontalAlignment(JTextField.CENTER);

		panelWest.add(comboNiveau);

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
			String[] liste = { "Choix", "Numéro 1", "Numéro 2" };
			for (int i = 0; i < liste.length; i++) {
				comboNiveau.addItem(liste[i]);
			}
			comboNiveau.setSelectedItem("Choix");
			panelWest.add(labelPause);
			panelWest.add(inputPause);
			panelWest.add(labelSerie);
			panelWest.add(inputSerie);
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

		ContentPane.revalidate();

		//
// BUG AFFICHAGE JTEXTAREA
		//

		demarrerButton.addActionListener(new InterfaceTrainingActionListener(this));
		comboNiveau.addActionListener(new InterfaceTrainingActionListener(this));

		return ContentPane;
	}

	public JComboBox<String> getComboNiveau() {
		return comboNiveau;
	}

	public JButton getDemarrerButton() {
		return demarrerButton;
	}

	public void processTraining(int time) {
		JLabel timer = new JLabel();

		panelCenterTRaining.add(timer);
		for (int i = 0; i < time; i--) {
			time--;
			timer.setText(String.valueOf(time));

			ContentPane.revalidate();
		}
	}

	public JPanel getPanelCenterTRaining() {
		return panelCenterTRaining;
	}

	public int getDureeCorde() {
		return dureeCorde;
	}

	public int setDureeCorde() {
		dureeCorde = Integer.parseInt(inputCorde.getText());
		return dureeCorde;
	}

	public int getDureePause() {
		return dureeCorde;
	}

	public int setDureePause() {
		dureePause = Integer.parseInt(inputPause.getText());
		return dureePause;
	}

	public int getNbreSerie() {
		return nbreSerie;
	}

	public String getTypeTraining() {
		return typeTraining;
	}

	public JTextArea getDescriptionTraining() {
		return descriptionTraining;
	}

	public int setNbreSerie() {
		nbreSerie = Integer.parseInt(inputSerie.getText());
		return nbreSerie;
	}
}
