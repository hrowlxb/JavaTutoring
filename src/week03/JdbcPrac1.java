package week03;

import java.sql.*;
import java.util.Scanner;

import week02.DBConn;

public class JdbcPrac1 {

	public static void main(String[] args) throws SQLException {
		Connection conn = DBConn.getDBConn();
		PreparedStatement pstmt;
		Scanner scanner = new Scanner(System.in);
		ResultSet rs;
		
		System.out.println("검색하려는 이름을 입력하세요: ");
		// 이름 입력받기
		String name = scanner.next();
		// 쿼리 작성
		String selectQuery = "SELECT * FROM student WHERE name = ? ORDER BY id DESC";
		pstmt = conn.prepareStatement(selectQuery);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery();
		// 쿼리 실행
		while (rs.next()) {
			System.out.println("ID = " + rs.getString(1));
			System.out.println("NAME = " + rs.getString(2));
			System.out.println("GRADE = " + rs.getString(3));
			System.out.println("DEPT = " + rs.getString(4));
			System.out.println("");
		}
		// 조회
		
		scanner.close();
		pstmt.close();
		conn.close();
	}
}