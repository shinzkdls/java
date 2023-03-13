package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest2 {

	public static void main(String[] args) {
		// Driver Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return;
		}
		System.out.println("Driver Loading 성공.");
		// Connect
		String id = "bank";
		String pwd = "111111";
		String url = "jdbc:oracle:thin:@172.16.20.58:1521:XE";
		String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;

		// Statement 생성 - SQL

		// SQL 전송
		try {
			con = DriverManager.getConnection(url, id, pwd);
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, "id24");
			pstmt.setString(2, "psd10");
			pstmt.setString(3, "홍길동");
			pstmt.setInt(4, 50);
			int result = pstmt.executeUpdate(); // 작성한 쿼리를 업데이트한다 => 정상이면 1리턴 비정상이면 0리턴
			System.out.println(result);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close(); // ----------------------반드시 finally문을 통해 종료
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("close 실패");
				e.printStackTrace();
			}
			System.out.println("close 성공");
		}
		// 결과 받기

	}

}
