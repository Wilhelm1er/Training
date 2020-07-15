package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class Training {
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
	
	  public void ajout_training(String name,Date date,String entrainement, int serie, int rope,int level, long time) { 
		  String sql ="INSERT INTO Training(user_id,date,entrainement,serie,tps_rope,level,temps) VALUES(?,?,?,?,?,?,?)";
	  
	  try (Connection conn = this.connect(); 
			  PreparedStatement pstmt =conn.prepareStatement(sql)) { 
		  pstmt.setString(1,name); 
		  pstmt.setDate(2,date); 
		  pstmt.setString(3, entrainement);
		  pstmt.setInt(4, serie);
		  pstmt.setInt(5,rope);
		  pstmt.setInt(6,level);
		  pstmt.setLong(7,time);
	  pstmt.executeUpdate(); 
	  pstmt.close();
	  } 
	  catch
	  (SQLException e) { System.out.println(e.getMessage()); } }
	 

}
