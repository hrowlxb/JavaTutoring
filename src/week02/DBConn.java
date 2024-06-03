package week02;

import java.sql.*;

public class DBConn {

	public static Connection getDBConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbUrl = "jdbc:mysql://localhost:3306/studentdb";
			String dbUser = "root";
			String dbPw = "tottenham528";
			
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
			System.out.println("DB 연결 성공!\n");
			
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			return null;
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
			return null;
		}
	}

}
