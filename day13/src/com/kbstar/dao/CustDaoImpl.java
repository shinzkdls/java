package com.kbstar.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kbstar.dto.Cust;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class CustDaoImpl implements DAO<String, String, Cust> {

	public CustDaoImpl() { // 객체가 생성되는 시점에 드라이버 로딩
		// Driver Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return;
		}
		System.out.println("Driver Loading 성공.");
	}

	public Connection getConnection() throws Exception {
		Connection con = null;
		// Connect
		Properties props = new Properties();
		String fileName = "db_info.txt";
		FileInputStream in = new FileInputStream(fileName);
		props.load(in);
		String id = props.getProperty("DB_ID");
		String pwd = props.getProperty("DB_PWD");
		String url = props.getProperty("DB_URL");
		con = DriverManager.getConnection(url, id, pwd);
		return con;
	}

	@Override
	public void insert(Cust v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.insertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.setInt(4, v.getAge());
			int result = pstmt.executeUpdate(); // 작성한 쿼리를 업데이트한다 => 정상이면 1리턴 비정상이면 0리턴
			// System.out.println(result);
		} catch (SQLException e1) {
			throw e1;
		}
	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.deleteSql);) {
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate(); // 작성한 쿼리를 업데이트한다 => 정상이면 1리턴 비정상이면 0리턴
			if (result == 0) {
				throw new Exception("ID 없음");
			}
		} catch (Exception e1) {
			throw e1;
		}
	}

	@Override
	public void update(Cust v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.updateSql);) {
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getAge());
			pstmt.setString(4, v.getId());
			int result = pstmt.executeUpdate(); // 작성한 쿼리를 업데이트한다 => 정상이면 1리턴 비정상이면 0리턴
			if (result == 0) {
				throw new Exception("ID 없음");
			}
		} catch (Exception e1) {
			throw e1;
		}
	}

	@Override
	public Cust select(String k) throws Exception {
		Cust cust = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectSql);) {
			pstmt.setString(1, "id29");
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next(); // 한칸 다음칸으로 이동시켜야됨 !!!!!!!!!!!!!!!!!!!!
				String db_id = rset.getString("id");
				String db_pwd = rset.getString("pwd");
				String db_name = rset.getString("name");
				int db_age = rset.getInt("age");
				cust = new Cust(db_id, db_pwd, db_name, db_age);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return cust;
	}

	@Override
	public List<Cust> selectAll() throws Exception {
		List<Cust> list = new ArrayList<Cust>();
		// =====================List와 같은 인터페이스는 null로 초기화 할 수 없음
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectAllSql);) {
			try (ResultSet rset = pstmt.executeQuery()) {
				while (rset.next()) {
					String db_id = rset.getString("id");
					String db_pwd = rset.getString("pwd");
					String db_name = rset.getString("name");
					int db_age = rset.getInt("age");
					list.add(new Cust(db_id, db_pwd, db_name, db_age));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Cust> search(String K) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
