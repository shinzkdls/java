package com.kbstar.frame;

public class Sql {
	// Cust DML
	public static String deleteSql = "DELETE FROM cust WHERE id =?";
	public static String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
	public static String updateSql = "UPDATE cust SET pwd=?, name=?, age=? WHERE id=?";
	public static String selectSql = "SELECT * FROM cust WHERE id = ?";
	public static String selectAllSql = "SELECT * FROM cust";

	// Item DML
	public static String itemDeleteSql = "DELETE FROM item WHERE id =?";
	public static String itemInsertSql = "INSERT INTO item VALUES(?,?,?,?,SYSDATE)";
	public static String itemUpdateSql = "UPDATE item SET name = ?, price=?, rate=? WHERE id=?";
	public static String itemSelectSql = "SELECT * FROM item WHERE id = ?";
	public static String itemSelectAllSql = "SELECT * FROM item";

	// Cart DML
	public static String cartDeleteSql = "DELETE FROM cart WHERE id =?";
	public static String cartInsertSql = "INSERT INTO cart VALUES(?,?,?,?,SYSDATE)";
	public static String cartUpdateSql = "UPDATE cart SET item_id = ?, cnt=? WHERE id=?";
	public static String cartSelectSql = "SELECT * FROM cart WHERE id = ?";
	public static String cartSelectAllSql = "SELECT * FROM cart";
	public static String myCartSelectAllSql = "SELECT * FROM cart WHERE USER_ID = ?";
}
