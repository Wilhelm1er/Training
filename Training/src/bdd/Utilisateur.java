package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilisateur {
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
	 * Creation d'un utilisateur
	 *
	 * @param name
	 * @param capacity
	 */
	public void create_User(String name) {
		String sql = "INSERT INTO Utilisateur(name) VALUES(?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Affichage contenu table utilisateur
	 */
	public void selectAll() {
		String sql = "SELECT user_id, name FROM Utilisateur";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getInt("user_id") + "\t" + rs.getString("name") + "\t");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
