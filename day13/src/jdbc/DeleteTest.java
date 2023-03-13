package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {

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
		String deleteSql = "DELETE FROM cust WHERE id =?";

		// Statement 생성 - SQL

		// SQL 전송
		try (Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement pstmt = con.prepareStatement(deleteSql);) {
			pstmt.setString(1, "id24");
			int result = pstmt.executeUpdate(); // 작성한 쿼리를 업데이트한다 => 정상이면 1리턴 비정상이면 0리턴
			System.out.println(result);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
