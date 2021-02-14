package com.mindtree.passport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.passport.DBUtil.DBUtil;
import com.mindtree.passport.entity.Passport;
import com.mindtree.passport.entity.Person;
import com.mindtree.passport.exception.DAOException.DAOException;

public class DAOService implements DAO {
	static DBUtil db = new DBUtil();

	@Override
	public Person storePersonDB(String personId, String personName, String birthPlace, int age) throws DAOException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection con = db.getConnectionSQL();

		try {
			stmt = con.createStatement();
		} catch (Exception e) {
			throw new DAOException(e);
		}

		String sql = String.format("insert into person values('%s','%s','%s', %d)", personId, personName, birthPlace,
				age);

		try {
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}

		db.closeConnection(stmt);

		db.closeConnection(con);
		Person p = new Person(personId, personName, birthPlace, age);

		return p;
	}

	@Override
	public Passport storePassportDB(String personId, String passNum, String passId) throws DAOException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection con = db.getConnectionSQL();

		try {
			stmt = con.createStatement();
		} catch (Exception e) {
			throw new DAOException(e);
		}

		String sql = String.format("insert into passport values('%s','%s', '%s')", personId, passNum, passId);

		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}

		db.closeConnection(stmt);

		db.closeConnection(con);
		Passport p = new Passport(passId, passNum);

		return p;
	}

	@Override
	public boolean displayPersondetailsDB(String personId) throws DAOException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM person where person.personId= '" + personId + "' ";
		String sql2 = "SELECT * FROM passport where passport.personId= '" + personId + "' ";
		Statement stmt = null;
		Connection con = db.getConnectionSQL();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}

		boolean empty = false;

		try {
			while (rs.next()) {
				empty = true;
				System.out
						.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}

		try {
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new DAOException(e1);
		}
		try {
			while (rs.next()) {
				System.out.println(rs.getString(2) + " " + rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}

		db.closeConnection(stmt);

		db.closeConnection(stmt);

		db.closeConnection(con);

		return empty;

	}

	@Override
	public boolean displaySortonPlaceDB() throws DAOException {
		// TODO Auto-generated method stub
		String sql = "SELECT person.personId, person.personName,person.birthPlace,person.age, passport.passId, passport.passNum FROM person "
				+ "INNER JOIN passport ON person.personId=passport.personId ORDER By birthPlace ";
		Statement stmt = null;
		Connection con = db.getConnectionSQL();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}

		boolean empty = false;

		try {
			while (rs.next()) {
				empty = true;
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4)
						+ " " + rs.getString(5) + " " + rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}

		db.closeConnection(stmt);

		db.closeConnection(stmt);

		db.closeConnection(con);

		return empty;

	}

	@Override
	public boolean checkPersonDB(String personId) throws DAOException {
		// TODO Auto-generated method stub
		String sql = "SELECT person.personId from person where personId= '" + personId + "' ";
		Statement stmt = null;
		Connection con = db.getConnectionSQL();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}

		boolean empty = false;

		try {
			while (rs.next()) {
				empty = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}

		db.closeConnection(stmt);

		db.closeConnection(stmt);

		db.closeConnection(con);

		return empty;
	}

}
