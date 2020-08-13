package InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import Application.Training;
import Listeners.SessionActionListener;

public class InterfaceSession {
	private JFrame frameSession = new JFrame("Session en cours");
	private JPanel panelPrincipal = new JPanel();
	private JPanel panelNorth = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JLabel labelExercice = new JLabel("Exercice: ");
	private JLabel exercice = new JLabel(" ");
	private JLabel labelCurrent = new JLabel(" ");
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
	private int duree_corde ;
	private int duree_pause;
	private int nbre_serie;	
	private long diff;

	private File bip = new File("resources/buzzer1.wav");
	private Timestamp timestamp_1 = new Timestamp(System.currentTimeMillis());
	private Map<String, Integer> List = new LinkedHashMap<String, Integer>();
	private Training Training = new Training();
	private Date date = new Date();
	private java.sql.Date dateS = new java.sql.Date(date.getTime());

	/**
	 * Frame d'affichage de l'interface session
	 *
	 */
	public void session() {
		//frameSession.getContentPane().removeAll();
		panelPrincipal.setLayout(new BorderLayout());
		frameSession.setSize(400, 300);
		frameSession.setLocationRelativeTo(null);
		frameSession.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	public void sessionTraining()
			throws InterruptedException {

			switch (typeTraining) {
			case "Renforcement":
				// Temps de debut d'entrainement
				timestamp_1 = new Timestamp(System.currentTimeMillis());
				
				for (int i = 1; i <= nbre_serie; i++) {
					serie.setText(i+" / "+nbre_serie);
					panelPrincipal.repaint();

					for (String mapentry : List.keySet()) {
						this.corde_a_sauter();
						timeCurrent.setText("");
						exercice.setText(mapentry);
						panelPrincipal.repaint();
						labelCurrent.setText("Répétitions: "+Training.training(typeTraining, level).get(mapentry));
						panelPrincipal.repaint();
						
						this.promptEnterKey();
					}
					if (i < nbre_serie) {
						this.corde_a_sauter();
						System.out.println("PAUSE de 3min");
						this.pause(180);
					}
				}
				this.corde_a_sauter();

				break;
			case "Musculation":
				typeTraining="Musculation";
				panelPrincipal.repaint();
				for (int i = 1; i <= nbre_serie; i++) {
					serie.setText(i+" / "+nbre_serie);
					panelPrincipal.repaint();
				}
				break;
			case "Gainage":
				typeTraining="Gainage";
				panelPrincipal.repaint();
				for (int i = 1; i <= nbre_serie; i++) {
					serie.setText(i+" / "+nbre_serie);
					panelPrincipal.repaint();
				}

				break;
			}
		}

/**
* Methode d'attente d'appui sur la touche ENTRER
* 
*/
public void promptEnterKey() {
System.out.println(" ");
System.out.println(" Appuyer sur \"ENTRER\" pour continuer");
System.out.println("#####################################");
System.out.println(" ");
try {
System.in.read();
} catch (IOException e) {
e.printStackTrace();
}
}

	/**
	 * Methode d'affichage de l'exercice corde à sauter
	 * 
	 * @throws InterruptedException
	 */
	public void corde_a_sauter() throws InterruptedException {
		exercice.setText("Corde à sauter");
		panelPrincipal.repaint();
		for (int i = duree_corde; i > 0; i--) {
			labelCurrent.setText("Temps restant");
			timeCurrent.setText("" + i);
			panelPrincipal.repaint();
			Thread.sleep(1000);
			if (i == 5) {
				this.bip();
			}
		}
	}		
	/**
	 * Methode pour creer une pause
	 * 
	 * @param time Temps en secondes.
	 * 
	 * @throws InterruptedException
	 */
	public void pause(int time) throws InterruptedException {
		exercice.setText("Pause");
		panelPrincipal.repaint();
		for (int i = time; i > 0; i--) {
			labelCurrent.setText("Temps restant");
			timeCurrent.setText("" + i);
			panelPrincipal.repaint();
			Thread.sleep(1000);
			if (i == 5) {
				this.bip();
			}
		}
	}

	/**
	 * Methode pour jouer le bip sonore
	 * 
	 */
	public void bip() {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(bip));
			clip.start();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public Map<String, Integer> getList() {
		return List;
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
	public int getDuree_corde() {
		return duree_corde;
	}

	public void setDuree_corde(int duree_corde) {
		this.duree_corde = duree_corde;
	}

	public int getNbre_serie() {
		return nbre_serie;
	}
	public void setNbre_serie(int nbre_serie) {
		this.nbre_serie = nbre_serie;
	}
	public int getDuree_pause() {
		return duree_pause;
	}

	public void setDuree_pause(int duree_pause) {
		this.duree_pause = duree_pause;
	}
	public void setList(Map<String, Integer> list) {
		List = list;
	}
	public Timestamp getTimestamp_1() {
		return timestamp_1;
	}
	public void setTimestamp_1(Timestamp timestamp_1) {
		this.timestamp_1 = timestamp_1;
	}
	public long getDiff() {
		return diff;
	}
	public void setDiff(long diff) {
		this.diff = diff;
	}
}