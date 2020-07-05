package bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Poids {
	/**
	 * Connect to the test.db database
	 *
	 * @return the Connection object
	 */
	private Connection connect() {
		String url = "jdbc:sqlite:entrainements.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * ajout poids
	 *
	 * @param name
	 * @param poids
	 * @param date
	 */
	public void ajout(String name, Double poids, Date date) {
		String sql = "INSERT INTO Poids(user_id,Poids,Date) VALUES(?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setDouble(2, poids);
			pstmt.setDate(3, date);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Affichage contenu table poids pour un utilisateur
	 */
	public void user_Selected(String name) {
		int user_id=0;
		String sql = "SELECT user_id FROM Utilisateur WHERE name=?";

		try (Connection conn = this.connect();
			PreparedStatement pstmt  = conn.prepareStatement(sql)){
			pstmt.setString(2, name);
			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			while (rs.next()) {
				user_id=rs.getInt("user_id");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
		String sql2 = "SELECT Poids, Date FROM Poids WHERE user_id=?";

		try (Connection conn = this.connect();
				PreparedStatement pstmt  = conn.prepareStatement(sql2)){
				pstmt.setInt(1, user_id);
				ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getInt("user_id") + "\t" + rs.getString("date") + "\t"+
                        rs.getDouble("Poids"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
