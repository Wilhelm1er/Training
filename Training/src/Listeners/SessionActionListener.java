package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import InterfaceGraphique.CompteRendu;
import InterfaceGraphique.InterfaceSession;

/**
 * Interface relative au Poids
 * 
 * @author Wilhelm1er
 */
public class SessionActionListener implements ActionListener {
	private InterfaceSession IntSession = new InterfaceSession();
	private CompteRendu cR = new CompteRendu();

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
			cR.setTime(IntSession.getTime());
			cR.setTimestamp_1(IntSession.getTimestamp_1());
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
