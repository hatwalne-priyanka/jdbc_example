package org.priyanka.com.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.priyanka.com.models.EventType;
import org.priyanka.com.models.User;
import org.priyanka.com.models.UserType;
import org.priyanka.com.service.EventTypeService;
import org.priyanka.com.service.UserService;
import org.priyanka.com.service.UserTypeService;

//	Owner: Priyanka Hatwalne
//	Date: 03/20/2016
//  Description: A Driver class to test the backend functionality.

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseConnection conn = null;

		try {
			conn = new DatabaseConnection();
			conn.getMyConn().setAutoCommit(false);
			UserTypeService uts = new UserTypeService();
			// UserType ut1 = new UserType(123, "abc");
			// int return_val = uts.addUserType(conn.getMyConn(), ut1);
			// System.out.println("Return Value " + return_val);
			UserType utyp = uts.getUserType(conn.getMyConn(), 1);
			// System.out.println("id: " + utyp.getId() + " Name: " +
			// utyp.getName());
			// utyp.setName("fan");
			// int return_val = uts.updateUserType(conn.getMyConn(), utyp);
			// System.out.println("Return Value " + return_val);
			// int return_val = uts.deleteUserTypes(conn.getMyConn(), utyp);
			// System.out.println("Return Value " + return_val);
			// List <UserType> userTypes =
			// uts.getAllUserTypes(conn.getMyConn());

			// for (int i = 0; i < userTypes.size(); i++) {
			// UserType ut = userTypes.get(i);
			// System.out.println("id: " + ut.getId() + " Name: " +
			// ut.getName());
			// }

			// EventTypeService ets = new EventTypeService();
			// EventType e1 = new EventType(123, "abc");
			// int return_val = ets.addEventType(conn.getMyConn(), e1);
			// System.out.println("Return Value " + return_val);
			// EventType utyp = ets.getEventType(conn.getMyConn(), 3);
			// System.out.println("id: " + utyp.getId() + " Name: " +
			// utyp.getName());

			// utyp.setName("Work Shop");
			// return_val = ets.updateEventType(conn.getMyConn(), utyp);
			// return_val = ets.deleteEventTypes(conn.getMyConn(),utyp);
			// System.out.println("Return Value " + return_val);

			// List <EventType> eventTypes =
			// ets.getAllEventTypes(conn.getMyConn());

			// for (int i = 0; i < eventTypes.size(); i++) {
			// EventType ut = eventTypes.get(i);
			// System.out.println("id: " + ut.getId() + " Name: " +
			// ut.getName());
			// }

			UserService us = new UserService();
			// User usr = new User(123, "Shruti","Sethi", "shru",utyp);
			// int return_val = us.addUser(conn.getMyConn(),
			// utyp.getName(),usr);
			// System.out.println("Return Value " + return_val);

			User user = us.getUser(conn.getMyConn(), 1);
			System.out.println("id: " + user.getId() + " Name: " + user.getFirstName() + " "
					+ user.getLastName() + " user name: " + user.getUserName() + " user type: "
					+ user.getUserType().getName());

			user.setLastName("Hatwalne-Bodhankar");
			us.updateUser(conn.getMyConn(), "admin", user);

			List<User> users = us.getAllUsers(conn.getMyConn());

			for (int i = 0; i < users.size(); i++) {
				user = users.get(i);
				System.out.println("id: " + user.getId() + " Name: " + user.getFirstName() + " "
						+ user.getLastName() + " user name: " + user.getUserName() + " user type: "
						+ user.getUserType().getName());
			}
			conn.getMyConn().commit();
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			try {
				conn.getMyConn().rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} catch (IOException e2) {
			System.out.println(e2.getMessage());
		} catch (Exception e) {
			System.out.println(e);
			try {
				conn.getMyConn().rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}

		}
		finally{
			if (conn.getMyConn() != null){
	    		try {
					conn.getMyConn().close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
