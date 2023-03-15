package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class TransactionDaoImpl implements DAO<String, String, TransactionDTO> {

	public TransactionDaoImpl() { // 객체가 생성되는 시점에 드라이버 로딩
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
	public void insert(TransactionDTO v) throws Exception {
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(Sql.transactionInsertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getAccNo());
			pstmt.setDouble(3, v.getBalance());
			pstmt.setString(4, v.getType());
			pstmt.setString(5, v.getDescription());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(String k) throws Exception {

	}

	@Override
	public void update(TransactionDTO v) throws Exception {

	}

	@Override
	public TransactionDTO select(String k) throws Exception {
		TransactionDTO trn = null;
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(Sql.transactionSelectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next();
				String id = rset.getString("id");
				Date regdate = rset.getDate("regdate");
				String accno = rset.getString("accno");
				double balance = rset.getDouble("balance");
				String type = rset.getString("type");
				String description = rset.getString("description");
				trn = new TransactionDTO(id, id, accno, balance, type, description);
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
		return trn;
	}

	@Override
	public List<TransactionDTO> selectAll() throws Exception {
		List<TransactionDTO> list = new ArrayList<TransactionDTO>();
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(Sql.transactionSelectAllSql)) {
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					String id = rset.getString("id");
					Date regdate = rset.getDate("regdate");
					String accno = rset.getString("accno");
					double balance = rset.getDouble("balance");
					String type = rset.getString("type");
					String description = rset.getString("description");
					list.add(new TransactionDTO(id, id, accno, balance, type, description));
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
	public List<TransactionDTO> search(String K) throws Exception {
		List<TransactionDTO> list = new ArrayList<TransactionDTO>();
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(Sql.myTransactionSelectAllSql)) {
			pstmt.setString(1, K);
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					String id = rset.getString("id");
					Date regdate = rset.getDate("regdate");
					String accno = rset.getString("accno");
					double balance = rset.getDouble("balance");
					String type = rset.getString("type");
					String description = rset.getString("description");
					list.add(new TransactionDTO(id, id, accno, balance, type, description));
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
