package org.priyanka.com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.priyanka.com.models.User;
import org.priyanka.com.models.UserType;

public class UserService {

	public UserService(){
		
	} 
	
	public int addUser(Connection myConn, String type, User user) throws SQLException{
		UserTypeService uts = new  UserTypeService();
		UserType userType = uts.getUserTypeByName(myConn, type);			
			Statement stmt = myConn.createStatement();
			String sql = "insert into users (username, firstname, lastname, user_type_id) " + "values "
					+ "('" + user.getUserName() + "', '" + user.getFirstName() + "', '" + user.getLastName() + 
					"', " + userType.getId() + ")";
			
			return stmt.executeUpdate(sql);
	
	}
	
	public int updateUser(Connection myConn, String type, User user) throws SQLException{
		UserTypeService uts = new  UserTypeService();
		UserType userType = uts.getUserTypeByName(myConn, type);

			Statement stmt = myConn.createStatement();
			String sql = "update users set username = '" + user.getUserName() 
					+ "', firstname = '" + user.getFirstName()
					+ "', lastname= '" + user.getLastName()
					+ "',  user_type_id = "  + userType.getId() + " where id = " + user.getId();
			
			return stmt.executeUpdate(sql);
	}
	
	
	public List<User> getAllUsers(Connection myConn) throws SQLException{
		List<User> users = new ArrayList<User>();
		Statement stmt;
		
			stmt = myConn.createStatement();
			
			ResultSet result = stmt.executeQuery("select users.id , firstname, lastname,username, name, user_type_id "
					+ " from users, user_types where users.user_type_id = user_types.id");
			while(result.next()){
				UserType userType = new UserType(result.getInt("user_type_id"), result.getString("name"));
				User user =  new User(result.getInt("id"), result.getString("firstname"),
								result.getString("lastname"), result.getString("username"), userType);
				users.add(user);
			}
			
		
		return users;
		
	}
	
	
	
	
	public User getUser(Connection myConn, int id) throws SQLException{		
		Statement stmt;	
		User user = null;
		
			stmt = myConn.createStatement();
			
			ResultSet result = stmt.executeQuery("select users.id , firstname, lastname,username, name, user_type_id  "
					+ "from users, user_types "
					+ "where users.user_type_id = user_types.id and  users.id = " + id);
			result.last();
			int size = result.getRow();
			if(size != 1) {
				throw new RuntimeException("Expected to return one record but got " + size + " records");
			}
			result.first();
			UserType userType = new UserType(result.getInt("user_type_id"), result.getString("name"));
		    user = new User(result.getInt("id"), result.getString("firstname"),
					result.getString("lastname"), result.getString("username"), userType);
			
			
		
		return user;
		
	}
}
