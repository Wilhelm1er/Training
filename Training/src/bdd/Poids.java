package bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Poids {
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
	 * ajout poids
	 *
	 * @param name
	 * @param poids
	 * @param date
	 */
	public void ajout(String name, Double poids, Date date) {

		PreparedStatement pStmnt = null;

		try {
			Connection conn = this.connect();

			String preQueryStatement = "INSERT INTO Poids(user_id,Poids,Date) VALUES((SELECT user_id from Utilisateur WHERE name = ?),?,?)";
			pStmnt = conn.prepareStatement(preQueryStatement);

			pStmnt.setString(1, name);
			pStmnt.setDouble(2, poids);
			pStmnt.setDate(3, date);
			pStmnt.executeUpdate();
			pStmnt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Affichage contenu table poids pour un utilisateur
	 * 
	 * @param name
	 */
	public ArrayList<String> user_Selected(String name) {

		ArrayList<String> poids = new ArrayList<String>();
		String result="";
		
		String sql2 = "SELECT Poids, Date FROM Poids WHERE user_id=(SELECT user_id from Utilisateur WHERE name = ?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			while (rs.next()) {
				String str = rs.getString("date");
				SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
				Date date = new Date(Long.parseLong(str));
				
				result=sf.format(date) + "\t" + rs.getDouble("Poids") + "kg";
				poids.add(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return poids;
	}
}