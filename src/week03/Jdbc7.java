package week03;

import java.sql.*;
import javax.swing.*;
import java.awt.*;

import week02.DBConn;

public class Jdbc7 extends JFrame {
	Connection conn = DBConn.getDBConn();
	PreparedStatement pstmt;
	
    // 컴포넌트 선언
    private JTextField idField, nameField, gradeField, deptField;
    private JLabel idLabel, nameLabel, gradeLabel, deptLabel;
    private JButton submitButton;

    public Jdbc7() {
        // JFrame 설정
        setTitle("학생 정보 입력");
        setSize(300, 200);
        setLocationRelativeTo(null); // 창을 화면 중앙에 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5)); // 그리드 레이아웃 사용

        // 컴포넌트 초기화
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("이름:");
        gradeLabel = new JLabel("학년:");
        deptLabel = new JLabel("학과:");
        
        idField = new JTextField();
        nameField = new JTextField();
        gradeField = new JTextField();
        deptField = new JTextField();

        submitButton = new JButton("입력");
        submitButton.addActionListener(event -> {
			try {
				insertAction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

        // 컴포넌트를 프레임에 추가
        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(gradeLabel);
        add(gradeField);
        add(deptLabel);
        add(deptField);
        add(new JLabel("")); // 버튼을 오른쪽에 배치하기 위해 빈 레이블 추가
        add(submitButton);
        
        
    }

    private void insertAction() throws SQLException {
        // 각 필드에서 텍스트 가져오기
        String id = idField.getText();
        String name = nameField.getText();
        String grade = gradeField.getText();
        String dept = deptField.getText();

        // 입력된 데이터를 콘솔에 출력
        System.out.println("ID: " + id);
        System.out.println("이름: " + name);
        System.out.println("학년: " + grade);
        System.out.println("학과: " + dept);
        
        // 필드에서 가져온 데이터로 DB에 입력
        String insertQuery = "INSERT INTO student VALUES(?, ?, ?, ?);";
        try {
        	conn.setAutoCommit(false);
        	pstmt = conn.prepareStatement(insertQuery);
        	pstmt.setString(1, id);
        	pstmt.setString(2, name);
        	pstmt.setString(3, grade);
        	pstmt.setString(4, dept);
        	pstmt.executeUpdate();
        	pstmt.close();
        	
        	conn.commit(); // 작업이 완료되면 커밋 수행
        } catch(SQLException e) {
        	conn.rollback(); // 트랜잭션 진행 중 오류 발생 시 롤백 수행
        } finally {
        	conn.setAutoCommit(true);
        	conn.close(); // DB 연결 종료
        }
    }

    public static void main(String[] args) {
	    	Jdbc7 frame = new Jdbc7();
        frame.setVisible(true);
    }
}
