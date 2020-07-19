package bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ChallengeBdd {
	/**
	 * Connect to the entrainements.db database
	 *
	 * @return the Connection object
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
	 * @param name
	 * @param capacity
	 */

	public void ajout(String name, Date date, String type) {
		String sql = "INSERT INTO Challenge(user_id,date,type) VALUES((SELECT user_id from Utilisateur WHERE name = ?),?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setDate(2, date);
			pstmt.setString(3, type);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Affichage contenu des challenges effectués par l'utilisateur
	 * 
	 * @param name
	 */
	public void affichageChallenge(String name) {

		String sql2 = "SELECT date, type FROM Challenge WHERE user_id=(SELECT user_id from Utilisateur WHERE name = ?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			while (rs.next()) {
				String str = rs.getString("date");
				SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
				Date date = new Date(Long.parseLong(str));

				System.out.println(sf.format(date) + " - Challenge: " + rs.getString("type"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
