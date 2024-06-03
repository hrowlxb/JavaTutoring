package week03;

import java.sql.*;
import java.util.Scanner;

import week02.DBConn;

public class Jdbc5 {

	public static void main(String[] args) throws SQLException {
		Connection conn = DBConn.getDBConn();
		Statement stmt = conn.createStatement();
		ResultSet rs;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("id를 입력하세요: ");
		int id = scanner.nextInt();
		
		System.out.print("이름을 입력하세요: ");
		String name = scanner.next();
		
		System.out.print("학년을 입력하세요: ");
		int grade = scanner.nextInt();
		
		System.out.print("학과를 입력하세요: ");
		String dept = scanner.next();
		
		String insertQuery = "INSERT INTO student(id, name, grade, dept) "
				+ "VALUES(" + id + ", '" + name + "', " + grade + ", '" + dept + "');";		
		stmt.executeUpdate(insertQuery);
		
		String selectQuery = "SELECT * FROM student WHERE id = " + id;
		rs = stmt.executeQuery(selectQuery);
		
		while (rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
		}
		
		String deleteQuery = "DELETE FROM student WHERE id = " + id;
		stmt.executeUpdate(deleteQuery);
		
		scanner.close();
		rs.close();
		stmt.close();
		conn.close();
	}

}