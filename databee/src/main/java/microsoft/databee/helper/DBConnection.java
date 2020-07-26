package microsoft.databee.helper;

/**
 * @author hakuchip
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBConnection {

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet resultSet = null;
	// private static PreparedStatement pstmt = null;

	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(InputHelper.ds.getConnectionString());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}

	public static Map<Integer, String> getDictionary(String tableName) {
		Map<Integer, String> dictResult = new HashMap<Integer, String>();
		int count = 0;
		try {
			stmt = con.createStatement();
			String sqlQuery = "select * from " + tableName;
			System.out.println("Dictionary query : " + sqlQuery);
			resultSet = stmt.executeQuery(sqlQuery);
			while (resultSet.next()) {
				count++;
				dictResult.put(count, resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dictResult;
	}

	public static Map<Integer, String> getColDictionary(String tableName, String filter, String column) {
		Map<Integer, String> dictResult = new HashMap<Integer, String>();
		int count = 0;
		try {
			stmt = con.createStatement();
			String sqlQuery = "select * from " + tableName + " where " + filter;
			// System.out.println("Dictionary query : "+ sqlQuery);
			resultSet = stmt.executeQuery(sqlQuery);
			while (resultSet.next()) {
				count++;
				dictResult.put(count, resultSet.getString(column));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dictResult;
	}

	public static Map<Integer, String> getDictionary(String tableName, String filter, String columnLabel) {
		Map<Integer, String> dictResult = new HashMap<Integer, String>();
		int count = 0;
		try {
			stmt = con.createStatement();
			String sqlQuery = "select * from " + tableName + " where " + filter;
			// System.out.println("Dictionary query : "+ sqlQuery);
			resultSet = stmt.executeQuery(sqlQuery);
			while (resultSet.next()) {
				count++;
				dictResult.put(count, resultSet.getString(columnLabel));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dictResult;
	}
}
