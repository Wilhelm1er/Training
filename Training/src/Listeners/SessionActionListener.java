package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import Application.Challenge;
import Application.Training;
import InterfaceGraphique.CompteRendu;
import InterfaceGraphique.InterfaceSession;
import InterfaceGraphique.InterfaceTraining;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class SessionActionListener implements ActionListener {
	private InterfaceSession IntSession = new InterfaceSession();
	private CompteRendu cR = new CompteRendu();
	private Challenge challenge = new Challenge();
	private Date date = new Date();
	private java.sql.Date dateS = new java.sql.Date(date.getTime());
	private InterfaceTraining IntTraining = new InterfaceTraining();
	private String level = "";

	/**
	 * Listeners des boutons de l'interface de session de training
	 * 
	 * @param interfaceSession Référence a l'interface de session de training
	 */
	public SessionActionListener(InterfaceSession interfaceSession) {
		this.IntSession = interfaceSession;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == IntSession.getContinuerButton()) {
			IntSession.setNext(true);

		} else if (e.getSource() == IntSession.getTerminerButton()) {
			cR.setLevel(IntSession.getLevel());
			cR.setName(IntSession.getName());
			cR.setTempsTotal(IntSession.getTempsTotal());
			cR.setTypeTraining(IntSession.getTypeTraining());
			cR.CompteRendu();
			IntSession.getFrame().dispose();
			

		} else if (e.getSource() == IntSession.getDemarrerButton()) {
			
		
					IntSession.getWorker1().execute();
			

		}
	}
}
