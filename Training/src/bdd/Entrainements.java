package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Entrainements {
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
	 * Enregistrement d'un entrainement
	 *
	 * @param name
	 * @param capacity
	 */
	public void ajout_entrainement(String entrainement) {
		String sql = "INSERT INTO Training(user_id,date,entrainement,serie,tps_rope,level,temps) VALUES(?)";

		Connection conn = null;
	    PreparedStatement pStmnt = null;
	    
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

}
