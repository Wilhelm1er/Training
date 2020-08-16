package InterfaceGraphique;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompteRendu {
	private JFrame frameCR = new JFrame("Compte rendu");
	private JPanel panelPrincipal = new JPanel();
	private String typeTraining = new String(" ");
	private String name = new String(" ");
	private String level = new String(" ");
	private JLabel labelName=new JLabel(" ");
	private JLabel labelLevel=new JLabel(" ");
	private JLabel labeltypeTraining = new JLabel(" ");
	private JLabel labelTempsTotal = new JLabel(" ");

	private long tempsTotal;

	public void CompteRendu() {
		
		int sec = (int) (tempsTotal / 1000) % 60;
		int min = (int) ((tempsTotal / (1000 * 60)) % 60);
		int h = (int) ((tempsTotal / (1000 * 60 * 60)) % 24);
		
		panelPrincipal.setLayout(new GridLayout(4, 2));
		frameCR.setSize(400, 300);
		frameCR.setLocationRelativeTo(null);
		frameCR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCR.setVisible(true);
		frameCR.revalidate();
		
		panelPrincipal.add(labelName);
		panelPrincipal.add(labeltypeTraining);
		panelPrincipal.add(labelLevel);
		panelPrincipal.add(labelTempsTotal);
		
		frameCR.add(panelPrincipal);
		
		labelName.setText("Bravo "+name + ", vous avez réalisé");
		labelLevel.setText("au niveau " +level);
		labeltypeTraining.setText("un training de type: " + typeTraining);
		labelTempsTotal.setText("Temps réalisé: "+h+":"+min+":"+sec);
		
		panelPrincipal.repaint();
		
		//frameCR.pack();
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
