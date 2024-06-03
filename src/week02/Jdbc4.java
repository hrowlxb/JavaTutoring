package week02;

import java.sql.*;

public class Jdbc4 {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = DBConn.getDBConn();
		Statement stmt = conn.createStatement();
		ResultSet rs;
		
		String insertQuery = "INSERT INTO student VALUES(20202222, '김철수', 3, '컴정')";
		stmt.executeUpdate(insertQuery);
		
		String selectQuery = "select * from student";
		rs = stmt.executeQuery(selectQuery);
		
		while(rs.next()) {
			System.out.println("학번: " + rs.getInt("id"));
			System.out.println("이름: " + rs.getString("name"));
			System.out.println("학년: " + rs.getInt("grade") + "학년");
			System.out.println("학과: " + rs.getString(4));
			System.out.println();
		}
		
		String updateQuery = "UPDATE student SET grade = 1, name = '손흥민' WHERE id = 20202222";
		stmt.executeUpdate(updateQuery);
		
		String selectQuery2 = "select * from student";
		rs = stmt.executeQuery(selectQuery2);
		
		while(rs.next()) {
			System.out.println("학번: " + rs.getInt("id"));
			System.out.println("이름: " + rs.getString("name"));
			System.out.println("학년: " + rs.getInt("grade") + "학년");
			System.out.println("학과: " + rs.getString(4));
			System.out.println();
		}
		
		String deleteQuery = "DELETE FROM student WHERE id = 20202222";
		int deleteRs = stmt.executeUpdate(deleteQuery);
		
		System.out.println("삭제 결과 : " + deleteRs);
		
		stmt.close();
		conn.close();
	}
}