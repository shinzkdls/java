package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllTest {

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
		String selectSql = "SELECT * FROM cust";

		// Statement 생성 - SQL

		// SQL 전송

		try (Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement pstmt = con.prepareStatement(selectSql);) {
			try (ResultSet rset = pstmt.executeQuery()) {
				while (rset.next()) { // 다음칸으로 갈수있을때까지 와일문을 실행해라 라는 뜻
					String db_id = rset.getString("id");
					String db_pwd = rset.getString("pwd");
					String db_name = rset.getString("name");
					int db_age = rset.getInt("age");
					System.out.println(db_id + " " + db_name + " " + db_age);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
