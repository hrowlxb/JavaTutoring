package week02;

import java.sql.*;

public class Jdbc2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbUrl = "jdbc:mysql://localhost:3306/studentdb";
			String dbUser = "root";
			String dbPw = "tottenham528";
			
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
			
			Statement stmt = conn.createStatement();
			
			String query = "INSERT INTO student VALUES(20201111, '윤도훈', 1, '컴소')";
			int result = stmt.executeUpdate(query);
			
			System.out.println("성공!" + result);
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}

}
