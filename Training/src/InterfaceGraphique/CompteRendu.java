package InterfaceGraphique;

import java.awt.GridLayout;
import java.sql.Timestamp;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CompteRendu {
	private JFrame frameCR = new JFrame("Compte rendu");
	private JPanel panelPrincipal = new JPanel();
	private String typeTraining = new String(" ");
	private String name = new String(" ");
	private String level = new String(" ");
	private JLabel labelName = new JLabel(" ");
	private JLabel labelLevel = new JLabel(" ");
	private JLabel labeltypeTraining = new JLabel(" ");
	private JLabel labelTempsTotal = new JLabel(" ");

	private Timestamp timestamp_1;
	private int time;
	private String termine = " ";

	private long tempsTotal;

	public void CompteRendu() {

		int sec = (int) (tempsTotal / 1000) % 60;
		int min = (int) ((tempsTotal / (1000 * 60)) % 60);
		int h = (int) ((tempsTotal / (1000 * 60 * 60)) % 24);

		panelPrincipal.setLayout(new GridLayout(4, 2));
		frameCR.setSize(400, 300);
		frameCR.setLocationRelativeTo(null);
		frameCR.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frameCR.setVisible(true);
		frameCR.revalidate();

		panelPrincipal.add(labelName);
		panelPrincipal.add(labeltypeTraining);
		panelPrincipal.add(labelLevel);
		panelPrincipal.add(labelTempsTotal);

		if (typeTraining.equals("Challenge")) {
			// Prise de l'instant de fin de l'entrainement
			Timestamp timestamp_2 = new Timestamp(System.currentTimeMillis());

			// Conversion de la durée de l'entrainement.
			long diff = timestamp_2.getTime() - timestamp_1.getTime();

			int seconds = (int) (diff / 1000);

			if (seconds >= time) {
				labelName.setText("Félicitation " + name + " vous avez terminé");
				labeltypeTraining.setText("le challenge  " + level);
				labelTempsTotal.setText("Temps réalisé: " + h + ":" + min + ":" + sec);
			}
			if (seconds < time) {
				int seconds2 = (int) (diff / 1000) % 60;
				int minutes = (int) ((diff / (1000 * 60)) % 60);
				int hours = (int) ((diff / (1000 * 60 * 60)) % 24);
				labelName.setText("Dommage " + name + " vous n'avez pas terminé");
				labeltypeTraining.setText("le challenge  " + level);
				labelTempsTotal.setText("Vous avez tenu: " + hours + ":" + minutes + ":" + seconds2);
			}
		} else {
			labelName.setText("Bravo " + name + ", vous avez réalisé");
			labelLevel.setText("au niveau " + level);
			labeltypeTraining.setText("un training de type: " + typeTraining);
			labelTempsTotal.setText("Temps réalisé: " + h + ":" + min + ":" + sec);
		}

		frameCR.add(panelPrincipal);

		panelPrincipal.repaint();

		// frameCR.pack();
		frameCR.revalidate();
	}

	public JLabel getLabelTypeTraining() {
		return labeltypeTraining;
	}

	public void setTypeTraining(JLabel typeTraining) {
		this.labeltypeTraining = typeTraining;
	}

	public long getTempsTotal() {
		return tempsTotal;
	}

	public void setTempsTotal(long tempsTotal) {
		this.tempsTotal = tempsTotal;
	}

	public JLabel getLabelTempsTotal() {
		return labelTempsTotal;
	}

	public void setLabelTempsTotal(JLabel labelTempsTotal) {
		this.labelTempsTotal = labelTempsTotal;
	}

	public String getTypeTraining() {
		return typeTraining;
	}

	public void setTypeTraining(String typeTraining) {
		this.typeTraining = typeTraining;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Timestamp getTimestamp_1() {
		return timestamp_1;
	}

	public void setTimestamp_1(Timestamp timestamp_1) {
		this.timestamp_1 = timestamp_1;
	}

	/**
	 * Test de l'interface Compte rendu
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				CompteRendu cr = new CompteRendu();
				cr.CompteRendu();
			}
		});
	}
}
