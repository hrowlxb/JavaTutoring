package week02;

import java.sql.*;

public class Jdbc3 {

	public static void main(String[] args) throws SQLException {
		Connection conn = DBConn.getDBConn();
		
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM student";
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("학번: " + rs.getInt("id"));
			System.out.println("이름: " + rs.getString("name"));
			System.out.println("학년: " + rs.getInt("grade") + "학년");
			System.out.println("학과: " + rs.getString(4));
			System.out.println();
		}
		
		rs.close();
		conn.close();
	}

}
