package kr.co.witlab.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlUtil {

	public static Connection getConnection() {
		try {
			// 1. 드라이버 객체 메모리 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. Connection 획득
			String id = "root";
			String pw = "defacto8*";
			String url = "jdbc:mysql://localhost:3306/test"; // DB명 : test
			return DriverManager.getConnection(url, id, pw);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Connection 해제
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {	// ResultSet 해제
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}

		try {	// Statement 해제
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}

		try {	// Connection 해제
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

	// Connection 해제
	public static void close(Statement stmt, Connection conn) {
		try {	// Statement 해제
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}

		try {	// Connection 해제
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

}
