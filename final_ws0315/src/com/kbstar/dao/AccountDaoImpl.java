package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class AccountDaoImpl implements DAO<String, String, AccountDTO> {

	public AccountDaoImpl() { // 객체가 생성되는 시점에 드라이버 로딩
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
	public void insert(AccountDTO v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accountInsertSql);) {
			pstmt.setString(1, v.getAccNo());
			pstmt.setDouble(2, v.getBalance());
			pstmt.setString(3, v.getHolder());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accountDeleteSql);) {
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate(); // 작성한 쿼리를 업데이트한다 => 정상이면 1리턴 비정상이면 0리턴
			if (result == 0) {
				throw new Exception("계좌 없음");
			}
		} catch (Exception e1) {
			throw e1;
		}
	}

	@Override
	public void update(AccountDTO v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accountUpdateSql);) {
			pstmt.setDouble(1, v.getBalance());
			pstmt.setString(2, v.getAccNo());
			int result = pstmt.executeUpdate(); // 작성한 쿼리를 업데이트한다 => 정상이면 1리턴 비정상이면 0리턴
			if (result == 0) {
				throw new Exception("계좌 없음");
			}
		} catch (Exception e1) {
			throw e1;
		}
	}

	@Override
	public AccountDTO select(String k) throws Exception {
		AccountDTO acc = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accountSelectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next();
				String accno = rset.getString("accno");
				double balance = rset.getDouble("balance");
				String holder = rset.getString("holder");
				acc = new AccountDTO(accno, balance, holder);
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
		return acc;
	}

	@Override
	public List<AccountDTO> selectAll() throws Exception {
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(Sql.accountSelectAllSql)) {
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					String accno = rset.getString("accno");
					double balance = rset.getDouble("balance");
					String holder = rset.getString("holder");
					list.add(new AccountDTO(accno, balance, holder));
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public List<AccountDTO> search(String K) throws Exception {
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(Sql.myAccountSelectAllSql)) {
			pstmt.setString(1, K);
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					String accno = rset.getString("accno");
					double balance = rset.getDouble("balance");
					String holder = rset.getString("holder");
					list.add(new AccountDTO(accno, balance, holder));
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

}
