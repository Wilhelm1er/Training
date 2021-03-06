package BaseDeDonnees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class PoidsBdd {
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
	 * ajout poids
	 *
	 * @param name  Nom de l'utilisateur
	 * @param poids Poids entré par l'utilisateur
	 * @param date  Date du jour
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
	 * @param name Nom de l'utilisateur
	 * 
	 * @return Map Contenu des entrées poids pour l'utilisateur donné
	 */
	public Map<String, Double> user_Selected(String name) {

		Map<String, Double> poids = new LinkedHashMap<String, Double>();
		String result;
		Double mesure;

		String sql2 = "SELECT Poids, Date FROM Poids WHERE user_id=(SELECT user_id from Utilisateur WHERE name = ?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			while (rs.next()) {
				String str = rs.getString("date");
				SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
				Date date = new Date(Long.parseLong(str));

				result = sf.format(date);
				mesure = rs.getDouble("Poids");

				poids.put(result, mesure);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return poids;
	}
}