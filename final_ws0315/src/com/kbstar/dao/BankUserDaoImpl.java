package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dto.BankUserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class BankUserDaoImpl implements DAO<String, String, BankUserDTO> {

	public BankUserDaoImpl() { // 객체가 생성되는 시점에 드라이버 로딩
		// Driver Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return;
		}
		// System.out.println("Driver Loading 성공.");
	}

	@Override
	public void insert(BankUserDTO v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.insertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.setString(4, v.getEmail());
			pstmt.setString(5, v.getContact());
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
	public void update(BankUserDTO v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.updateSql);) {
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getEmail());
			pstmt.setString(4, v.getContact());
			pstmt.setString(5, v.getId());
			int result = pstmt.executeUpdate(); // 작성한 쿼리를 업데이트한다 => 정상이면 1리턴 비정상이면 0리턴
			if (result == 0) {
				throw new Exception("ID 없음");
			}
		} catch (Exception e1) {
			throw e1;
		}
	}

	@Override
	public BankUserDTO select(String k) throws Exception {
		BankUserDTO bankUser = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next();// 한칸 다음칸으로 이동시켜야됨 !!!!!!!!!!!!!!!!!!!!
				String db_id = rset.getString("id");
				String db_pwd = rset.getString("pwd");
				String db_name = rset.getString("name");
				String db_email = rset.getString("email");
				String db_contact = rset.getString("contact");
				bankUser = new BankUserDTO(db_id, db_pwd, db_name, db_email, db_contact);
			} catch (Exception e) {
				// 데이터 존재하지않을때 예외 발생 위치
				throw e;
			}
		} catch (Exception e1) {
			// 네트워크 연결되지않았을때 예외 발생 위치
			throw e1;
		}
		return bankUser;
	}

	@Override
	public List<BankUserDTO> selectAll() throws Exception {
		List<BankUserDTO> list = new ArrayList<BankUserDTO>();
		// =====================List와 같은 인터페이스는 null로 초기화 할 수 없음
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectAllSql);) {
			try (ResultSet rset = pstmt.executeQuery()) {
				while (rset.next()) {
					String db_id = rset.getString("id");
					String db_pwd = rset.getString("pwd");
					String db_name = rset.getString("name");
					String db_email = rset.getString("email");
					String db_contact = rset.getString("contact");
					list.add(new BankUserDTO(db_id, db_pwd, db_name, db_email, db_contact));
				}
			} catch (Exception e) {
				throw e; // 데이터 존재하지않을때 예외 발생 위치 => 발생하지않음 List가 null로 정상 리턴됨
			}

		} catch (Exception e1) {
			throw e1; // 네트워크 연결되지않았을때 예외 발생 위치
		}
		return list;
	}

	@Override
	public List<BankUserDTO> search(String K) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
