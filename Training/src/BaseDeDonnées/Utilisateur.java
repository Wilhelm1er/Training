package BaseDeDonnées;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Utilisateur {
	/**
	 * Connect to the test.db database
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
	 * Creation d'un utilisateur
	 *
	 * @param name
	 * @param capacity
	 */
	public boolean create_User(String name, String mdp) {
		Connection conn = null;
		PreparedStatement pStmnt = null;
		ResultSet rs = null;

		try {
			conn = this.connect();
			String preQueryStatement = "SELECT * FROM Utilisateur WHERE name = ?";
			pStmnt = conn.prepareStatement(preQueryStatement);
			pStmnt.setString(1, name);

			rs = pStmnt.executeQuery();
			if (!rs.next()) {
				String insertStatement = "INSERT INTO Utilisateur(name,mdp) VALUES(?,?)";
				pStmnt = conn.prepareStatement(insertStatement);
				pStmnt.setString(1, name);
				pStmnt.setString(2, mdp);
				pStmnt.executeUpdate();
				System.out.println("Nouvel utilisateur ajouté");
				return true;

			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
				rs.close();
				pStmnt.close();
			} catch (SQLException e) {
			}
		}
		return false;
	}

	/**
	 * Connexion d'un utilisateur
	 *
	 * @param name
	 * @param capacity
	 */
	public boolean connexion_User(String name, String mdp) {
		Connection conn = null;
		PreparedStatement pStmnt = null;
		ResultSet rs = null;

		try {
			conn = this.connect();
			String preQueryStatement = "SELECT * FROM Utilisateur WHERE name= ? AND mdp= ?";
			pStmnt = conn.prepareStatement(preQueryStatement);
			pStmnt.setString(1, name);
			pStmnt.setString(2, mdp);

			rs = pStmnt.executeQuery();
			if (rs.next()) {

				return true;
			} else {

				return false;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
				rs.close();
				pStmnt.close();
			} catch (SQLException e) {
			}
		}
		return false;
	}

	/**
	 * Affichage contenu table utilisateur
	 */
	public ArrayList<String> selectAll() {
		
		ArrayList<String> user = new ArrayList<String>();
		String result="";
		
		String sql = "SELECT name FROM Utilisateur";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				result=rs.getString("name") + "\t";
				user.add(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
}
