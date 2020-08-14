package InterfaceGraphique;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompteRendu {
	private JFrame frameCR = new JFrame("Compte rendu");
	private JPanel panelPrincipal = new JPanel();
	private JLabel typeTraining = new JLabel();
	private JLabel labelTempsTotal = new JLabel();

	private long tempsTotal;
	int sec = (int) (tempsTotal / 1000) % 60;
	int min = (int) ((tempsTotal / (1000 * 60)) % 60);
	int h = (int) ((tempsTotal / (1000 * 60 * 60)) % 24);
	

	public void CompteRendu() {
		panelPrincipal.setLayout(new BorderLayout());
		frameCR.setSize(400, 300);
		frameCR.setLocationRelativeTo(null);
		frameCR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCR.setVisible(true);
		
		labelTempsTotal.setText(h+":"+min+":"+sec);
		panelPrincipal.add(typeTraining);
		panelPrincipal.add(labelTempsTotal);
		
		panelPrincipal.repaint();
		
		frameCR.add(panelPrincipal);
		frameCR.pack();
		frameCR.revalidate();
	}
	
	
	public JLabel getTypeTraining() {
		return typeTraining;
	}

	public void setTypeTraining(JLabel typeTraining) {
		this.typeTraining = typeTraining;
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



}
