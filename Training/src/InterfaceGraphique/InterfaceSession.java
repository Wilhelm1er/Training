package InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Listeners.SessionActionListener;

public class InterfaceSession {
	private JFrame frameSession = new JFrame("Session en cours");
	private JPanel panelPrincipal = new JPanel();
	private JPanel panelNorth = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JLabel labelExercice = new JLabel("Exercice: ");
	private JLabel exercice = new JLabel("");
	private JLabel labelCurrent = new JLabel("Décompte: ");
	private JLabel timeCurrent = new JLabel("00:00");
	private JLabel labelSession = new JLabel("Temps total: ");
	private JLabel timeSession = new JLabel("00:00");
	private String typeTraining = new String(" ");
	private JLabel labelTypeTraining = new JLabel(typeTraining);
	private JLabel serie = new JLabel(" ");
	private JLabel labelSerie = new JLabel("Série: ");
	private JButton demarrerButton = new JButton("Démarrer");
	private JButton arreterButton = new JButton("Arrêter");
	private JButton pauseButton = new JButton("Pause");
	private String name;
	private String level;

	/**
	 * Frame d'affichage de l'interface session
	 *
	 */
	public void session() {
		//frameSession.getContentPane().removeAll();
		panelPrincipal.setLayout(new BorderLayout());
		frameSession.setSize(400, 300);
		frameSession.setLocationRelativeTo(null);
		frameSession.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSession.setVisible(true);
		frameSession.revalidate();
		
		panelPrincipal.add(panelNorth, BorderLayout.NORTH);
		panelPrincipal.add(panelCenter, BorderLayout.CENTER);
		panelPrincipal.add(panelSouth, BorderLayout.SOUTH);
		
		panelNorth.add(labelTypeTraining);
		
		panelCenter.setLayout(new GridLayout(2, 5));
		
		panelCenter.add(labelSession);
		panelCenter.add(timeSession);
		panelCenter.add(labelSerie);
		panelCenter.add(serie);
		panelCenter.add(labelExercice);
		panelCenter.add(exercice);
		panelCenter.add(labelCurrent);
		panelCenter.add(timeCurrent);
		
		panelSouth.add(demarrerButton);
		panelSouth.add(pauseButton);
		panelSouth.add(arreterButton);
		
		panelPrincipal.repaint();
		
		arreterButton.addActionListener(new SessionActionListener(this));
		demarrerButton.addActionListener(new SessionActionListener(this));
		
		frameSession.add(panelPrincipal);
		frameSession.revalidate();
		
	}

	public JLabel getExercice() {
		return exercice;
	}

	public void setExercice(JLabel exercice) {
		this.exercice = exercice;
	}

	public JButton getArreterButton() {
		return arreterButton;
	}

	public void setArreterButton(JButton stopButton) {
		this.arreterButton = stopButton;
	}
	public JButton getDemarrerButton() {
		return demarrerButton;
	}

	public void setDemarrerButton(JButton demarrerButton) {
		this.demarrerButton = demarrerButton;
	}

	public JButton getPauseButton() {
		return pauseButton;
	}

	public void setPauseButton(JButton pause) {
		pauseButton = pause;
	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public JLabel getSerie() {
		return serie;
	}

	public void setSerie(JLabel serie) {
		this.serie = serie;
	}

	public String getTypeTraining() {
		return typeTraining;
	}
	public JLabel getLabelTypeTraining() {
		return labelTypeTraining;
	}

	public void setTypeTraining(String typeTraining) {
		this.typeTraining = typeTraining;
	}

	public JLabel getTimeCurrent() {
		return timeCurrent;
	}

	public void setTimeCurrent(JLabel timeCurrent) {
		this.timeCurrent = timeCurrent;
	}

	public JLabel getTimeSession() {
		return timeSession;
	}

	public void setTimeSession(JLabel timeSession) {
		this.timeSession = timeSession;
	}

	public JFrame getFrame() {
		return frameSession;
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
	 * Test de l'interface Session
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				InterfaceSession s = new InterfaceSession();
				s.session();
			}
		});
	}
}