package week03;

import java.sql.*;
import java.util.Scanner;

import week02.DBConn;

public class Jdbc6 {

	public static void main(String[] args) throws SQLException {
		Connection conn = DBConn.getDBConn();
		PreparedStatement pstmt; // <- PreparedStatement
		ResultSet rs;
		Scanner scanner = new Scanner(System.in);
		
		// PreparedStatement 방식으로 동적인 쿼리 작성하기
		System.out.print("id를 입력하세요: ");
		int id = scanner.nextInt();
		
		System.out.print("이름을 입력하세요: ");
		String name = scanner.next();
		
		System.out.print("학년을 입력하세요: ");
		int grade = scanner.nextInt();
		
		System.out.print("학과를 입력하세요: ");
		String dept = scanner.next();
		
		String insertQuery = "INSERT INTO student(id, name, grade, dept) VALUES(?, ?, ?, ?);";
		pstmt = conn.prepareStatement(insertQuery);
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, grade);
		pstmt.setString(4, dept);
		
		pstmt.executeUpdate();
		
		String selectQuery = "SELECT * FROM student WHERE id = ?";
		pstmt = conn.prepareStatement(selectQuery);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
		}
		
		String deleteQuery = "DELETE FROM student WHERE id = ?";
		pstmt = conn.prepareStatement(deleteQuery);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		
		scanner.close();
		rs.close();
		pstmt.close();
		conn.close();
	}

}