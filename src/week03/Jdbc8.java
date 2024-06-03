package week03;

import java.sql.*;

import week02.DBConn;

public class Jdbc8 {

	public static void main(String[] args) throws SQLException {
		Connection conn = DBConn.getDBConn();
		PreparedStatement pstmt;
		ResultSet rs;

		// 삭제 이전 검증
		String check = "SELECT 1 FROM student WHERE id = 1";
		pstmt = conn.prepareStatement(check);
		rs = pstmt.executeQuery();
		
		// 만약 ResultSet에 담긴 값이 있을 경우 삭제 수행
		if (rs.next()) {
			String deleteQuery = "DELETE FROM student WHERE id = 1";
			pstmt = conn.prepareStatement(deleteQuery);
			pstmt.executeUpdate();
			System.out.println("* 정상적으로 삭제됨 ^^*");
		} else {
			System.out.println("* 삭제할 데이터 없음!!");
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}
}