package com.mindtree.passport.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.passport.exception.DAOException.DBUtilException;

public class DBUtil {
	public Connection getConnectionSQL() throws DBUtilException {
		String url = "jdbc:mysql://localhost:3306/passport";
		String userName = "root";
		String password = "12345678";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DBUtilException(e);
		}
		return con;
	}

	public void closeConnection(Connection con) throws DBUtilException {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			throw new DBUtilException(e);
		}

	}

	public void closeConnection(Statement st) throws DBUtilException {
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			throw new DBUtilException(e);
		}

	}

}
