package BaseDeDonnées;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ChallengeBdd {
	/**
	 * Connect to the entrainements.db database
	 *
	 * @return Connection à la base de données
	 */
	private Connection connect() {
		String url = "jdbc:sqlite:resources/entrainements.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * Enregistrement d'un challenge
	 *
	 * @param name    Nom de l'utilisateur
	 * @param date    Date du jour
	 * @param type    Challenge selectionné
	 * @param time    Durée du challenge réalisé
	 * @param termine Si le challenge a été terminé
	 * 
	 */

	public void ajout(String name, Date date, String type, long time, String termine) {
		String sql = "INSERT INTO Challenge(user_id,date,type,temps,termine) VALUES((SELECT user_id from Utilisateur WHERE name = ?),?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setDate(2, date);
			pstmt.setString(3, type);
			pstmt.setLong(4, time);
			pstmt.setString(5, termine);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Affichage contenu des challenges effectués par l'utilisateur
	 * 
	 * @param name Nom de l'utilisateur
	 * 
	 * @return ArrayList Contenant la liste des challenges réalisés par
	 *         l'utilisateur
	 */
	public ArrayList<List<String>> affichageChallenge(String name) {

		ArrayList<List<String>> challenge = new ArrayList<List<String>>();
		String result = "";

		String sql2 = "SELECT date, type, temps, termine FROM Challenge WHERE user_id=(SELECT user_id from Utilisateur WHERE name = ?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			while (rs.next()) {
				List<String> listChallenge = new ArrayList<String>();
				String str = rs.getString("date");
				SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
				Date date = new Date(Long.parseLong(str));

				int seconds = (int) (rs.getLong("temps") / 1000) % 60;
				int minutes = (int) ((rs.getLong("temps") / (1000 * 60)) % 60);
				int hours = (int) ((rs.getLong("temps") / (1000 * 60 * 60)) % 24);

				listChallenge.add(sf.format(date));
				listChallenge.add(rs.getString("type"));
				listChallenge.add(minutes + " min " + seconds + " sec");
				listChallenge.add(rs.getString("termine"));

				challenge.add(listChallenge);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return challenge;
	}
}
