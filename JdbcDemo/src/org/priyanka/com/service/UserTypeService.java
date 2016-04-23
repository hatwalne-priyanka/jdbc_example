package org.priyanka.com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Owner: Priyanka Hatwalne
//Date: 03/20/2016
//Description: This a class has implementations CURD operations for User_types table 

import org.priyanka.com.models.UserType;

public class UserTypeService {

	public UserTypeService() {

	}
	//method to get  user types by id
	// returns object of usertype class.
	public UserType getUserType(Connection myConn, int id) throws SQLException {
		Statement stmt;
		UserType userType = null;

		stmt = myConn.createStatement();

		ResultSet result = stmt.executeQuery("select * from user_types where id = " + id);
		result.last();
		int size = result.getRow();

		if (size != 1) {
			throw new RuntimeException(
					"Expected to return one record but got " + size + " records");
		}
		//result.first();

		userType = new UserType(result.getInt("id"), result.getString("name"));

		return userType;
	}

	////method to get user types by name
	// returns object of usertype class.
	public UserType getUserTypeByName(Connection myConn, String name) throws SQLException {
		Statement stmt;
		UserType userType = null;

		stmt = myConn.createStatement();
		String sql = "select * from user_types where name = '" + name + "'";

		ResultSet result = stmt.executeQuery(sql);
		result.last();
		int size = result.getRow();

		if (size != 1) {
			throw new RuntimeException(
					"Expected to return one record but got " + size + " records");
		}
		result.first();

		userType = new UserType(result.getInt("id"), result.getString("name"));
		return userType;
	}

	//method to add user types
	// returns number of rows affected
	public int addUserType(Connection myConn, UserType userType) throws SQLException {

		Statement stmt = myConn.createStatement();
		String sql = "insert into user_types (name) values ('" + userType.getName() + "')";
		return stmt.executeUpdate(sql);

	}

	//method to update user types 
	// returns number of rows affected
	public int updateUserType(Connection myConn, UserType userType) throws SQLException {

		Statement stmt = myConn.createStatement();
		String sql = "update user_types  set name ='" + userType.getName() + "' where id = "
				+ userType.getId();
		return stmt.executeUpdate(sql);

	}

	// method to delete user types  
	// returns number of rows affected
	public int deleteUserTypes(Connection myConn, UserType userType) throws SQLException {

		Statement stmt = myConn.createStatement();
		String sql = "delete from user_types where id = " + userType.getId();
		return stmt.executeUpdate(sql);

	}

	//method to get all user types
	// returns list of  object of type usertype
	public List<UserType> getAllUserTypes(Connection myConn) throws SQLException {
		List<UserType> userTypes = new ArrayList<UserType>();
		Statement stmt;

		stmt = myConn.createStatement();

		ResultSet result = stmt.executeQuery("select * from user_types  ");
		while (result.next()) {
			UserType userType = new UserType(result.getInt("id"), result.getString("name"));
			userTypes.add(userType);
		}

		return userTypes;
	}
}
