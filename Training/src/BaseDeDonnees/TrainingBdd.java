package BaseDeDonnees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class TrainingBdd {
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
	 * Enregistrement d'un entrainement
	 *
	 * @param name         Nom de l'utilisateur
	 * @param date         Date du jour
	 * @param entrainement Training effectué
	 * @param serie        Série effectué
	 * @param rope         Temps de corde à sauter
	 * @param level        Intensité de l'entrainement
	 * @param time         Temps de l'entrainement
	 */

	public void ajout_training(String name, Date date, String entrainement, int serie, int rope, String level,
			long time) {
		String sql = "INSERT INTO Training(user_id,date,entrainement,serie,tps_rope,level,temps) VALUES((SELECT user_id from Utilisateur WHERE name = ?),?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setDate(2, date);
			pstmt.setString(3, entrainement);
			pstmt.setInt(4, serie);
			pstmt.setInt(5, rope);
			pstmt.setString(6, level);
			pstmt.setLong(7, time);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Enregistrement d'un entrainement musculation
	 *
	 * @param name         Nom de l'utilisateur
	 * @param date         Date du jour
	 * @param entrainement Training réalisé
	 * @param serie        Série réalisé
	 * @param pause        Temps de pause
	 * @param level        Intensité de l'entrainement
	 * @param time         Temps de l'entrainement réalisé
	 */

	public void ajout_muscu(String name, Date date, String entrainement, int serie, int pause, String level,
			long time) {
		String sql = "INSERT INTO Training(user_id,date,entrainement,serie,tps_pause,level,temps) VALUES((SELECT user_id from Utilisateur WHERE name = ?),?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setDate(2, date);
			pstmt.setString(3, entrainement);
			pstmt.setInt(4, serie);
			pstmt.setInt(5, pause);
			pstmt.setString(6, level);
			pstmt.setLong(7, time);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Enregistrement d'un entrainement gainage
	 *
	 * @param name         Nom de l'utilisateur
	 * @param date         Date du jour
	 * @param entrainement Training réalisé
	 * @param serie        Série réalisé
	 * @param pause        Temps de pause
	 * @param level        Intensité de l'entrainement
	 * @param time         Temps de l'entrainement réalisé
	 */

	public void ajout_gainage(String name, Date date, String entrainement, int serie, String level, long time) {
		String sql = "INSERT INTO Training(user_id,date,entrainement,serie,level,temps) VALUES((SELECT user_id from Utilisateur WHERE name = ?),?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setDate(2, date);
			pstmt.setString(3, entrainement);
			pstmt.setInt(4, serie);
			pstmt.setString(5, level);
			pstmt.setLong(6, time);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Affichage contenu des derniers trainings pour un utilisateur
	 * 
	 * @param name Nom de l'utilisateur
	 * 
	 * @return ArrayList Liste des entrainements réalisé par l'utilisateur
	 */
	public ArrayList<List<String>> affichageTraining(String name) {

		String sql2 = "SELECT date, entrainement, serie, level, tps_rope, temps,tps_pause FROM Training WHERE user_id=(SELECT user_id from Utilisateur WHERE name = ?)";

		ArrayList<List<String>> training = new ArrayList<List<String>>();

		// String result="";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			while (rs.next()) {
				List<String> listTraining = new ArrayList<String>();

				String str = rs.getString("date");
				SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
				Date date = new Date(Long.parseLong(str));

				int seconds = (int) (rs.getLong("temps") / 1000) % 60;
				int minutes = (int) ((rs.getLong("temps") / (1000 * 60)) % 60);
				int hours = (int) ((rs.getLong("temps") / (1000 * 60 * 60)) % 24);

				listTraining.add(sf.format(date));
				listTraining.add(rs.getString("entrainement"));
				listTraining.add(String.valueOf(rs.getInt("serie")));
				listTraining.add(rs.getString("level"));

				if (rs.getInt("tps_rope") != 0) {
					listTraining.add(String.valueOf(rs.getInt("tps_rope")));
				}
				if (rs.getInt("tps_pause") != 0) {
					listTraining.add(String.valueOf(rs.getInt("tps_pause")));
				}
				listTraining.add(minutes + "min " + seconds+"sec");

				training.add(listTraining);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return training;
	}
}