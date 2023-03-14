package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kbstar.dto.Item;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class ItemDaoImpl implements DAO<String, String, Item> {

	public ItemDaoImpl() { // 객체가 생성되는 시점에 드라이버 로딩
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

	@Override
	public void insert(Item v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemInsertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getPrice());
			pstmt.setDouble(4, v.getRate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemDeleteSql);) {
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
	public void update(Item v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemUpdateSql);) {
			pstmt.setString(1, v.getName());
			pstmt.setInt(2, v.getPrice());
			pstmt.setDouble(3, v.getRate());
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
	public Item select(String k) throws Exception {
		Item item = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemSelectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next();// 한칸 다음칸으로 이동시켜야됨 !!!!!!!!!!!!!!!!!!!!
				String db_id = rset.getString("id");
				String db_name = rset.getString("name");
				int db_price = rset.getInt("price");
				double db_rate = rset.getDouble("rate");
				Date db_date = rset.getDate("regdate");
				item = new Item(db_id, db_name, db_price, db_rate, db_date);
			} catch (Exception e) {
				// 데이터 존재하지않을때 예외 발생 위치
				throw e;
			}
		} catch (Exception e1) {
			// 네트워크 연결되지않았을때 예외 발생 위치
			throw e1;
		}
		return item;
	}

	@Override
	public List<Item> selectAll() throws Exception {
		List<Item> list = new ArrayList<Item>();
		// =====================List와 같은 인터페이스는 null로 초기화 할 수 없음
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemSelectAllSql);) {
			try (ResultSet rset = pstmt.executeQuery()) {
				while (rset.next()) {
					String db_id = rset.getString("id");
					String db_name = rset.getString("name");
					int db_price = rset.getInt("price");
					double db_rate = rset.getDouble("rate");
					Date db_date = rset.getDate("regdate");
					list.add(new Item(db_id, db_name, db_price, db_rate, db_date));
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
	public List<Item> search(String K) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
