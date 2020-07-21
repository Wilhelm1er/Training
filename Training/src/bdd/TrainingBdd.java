package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class TrainingBdd {
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
	 * Enregistrement d'un entrainement
	 *
	 * @param name
	 * @param capacity
	 */

	public void ajout_training(String name, Date date, String entrainement, int serie, int rope, int level, long time) {
		String sql = "INSERT INTO Training(user_id,date,entrainement,serie,tps_rope,level,temps) VALUES((SELECT user_id from Utilisateur WHERE name = ?),?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setDate(2, date);
			pstmt.setString(3, entrainement);
			pstmt.setInt(4, serie);
			pstmt.setInt(5, rope);
			pstmt.setInt(6, level);
			pstmt.setLong(7, time);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Enregistrement d'un entrainement musculation ou gainage
	 *
	 * @param name
	 * @param capacity
	 */

	public void ajout_autre(String name, Date date, String entrainement, int serie, int pause, int level, long time) {
		String sql = "INSERT INTO Training(user_id,date,entrainement,serie,tps_pause,level,temps) VALUES((SELECT user_id from Utilisateur WHERE name = ?),?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setDate(2, date);
			pstmt.setString(3, entrainement);
			pstmt.setInt(4, serie);
			pstmt.setInt(5, pause);
			pstmt.setInt(6, level);
			pstmt.setLong(7, time);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Affichage contenu des derniers trainings pour un utilisateur
	 * 
	 * @param name
	 */
	public ArrayList<String> training_Selected(String name) {

		String sql2 = "SELECT date, entrainement, serie, level, tps_rope, temps,tps_pause FROM Training WHERE user_id=(SELECT user_id from Utilisateur WHERE name = ?)";

		ArrayList<String> training = new ArrayList<String>();
		String result="";
		
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			while (rs.next()) {
				String str = rs.getString("date");
				SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
				Date date = new Date(Long.parseLong(str));
				
				int seconds = (int) (rs.getLong("temps") / 1000) % 60;
				int minutes = (int) ((rs.getLong("temps") / (1000 * 60)) % 60);
				int hours = (int) ((rs.getLong("temps") / (1000 * 60 * 60)) % 24);
				
				result=sf.format(date) + " - " + rs.getString("entrainement") + " - "+ rs.getInt("serie")+
						" série(s) - Level: "+rs.getInt("level");
				if(rs.getInt("tps_rope")!=0) {
					result=result+" - Corde: "+rs.getInt("tps_rope")+"s ";
						}
				if(rs.getInt("tps_pause")!=0) {
					result=result+" - Pause: "+rs.getInt("tps_pause")+ "s ";
					}
				result=result+"- Temps: " + minutes + " minutes " + seconds + " secondes.";
				training.add(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return training;
	}
}