package org.priyanka.com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.priyanka.com.models.EventType;

//Owner: Priyanka Hatwalne
//Date: 03/20/2016
//Description: This a class has implementations CURD operations for event_type table

public class EventTypeService {

	public EventTypeService() {

	}
   // method to get event type by ID
	// returns object of type EventType
	public EventType getEventType(Connection myConn, int id) throws SQLException {
		Statement stmt;
		EventType eventType = null;
		stmt = myConn.createStatement();
		ResultSet result = stmt.executeQuery("select * from event_types where id = " + id);
		result.last();
		int size = result.getRow();
		System.out.println("Size: " + size);
		if (size != 1) {
			throw new RuntimeException(
					"Expected to return one record but got " + size + " records");
		}
		//result.first();
		eventType = new EventType(result.getInt("id"), result.getString("name"));
		return eventType;
	}

	// method to add a event type.
	// returns number of rows affected
	public int addEventType(Connection myConn, EventType eventType) throws SQLException {
		Statement stmt = myConn.createStatement();
		String sql = "insert into event_types (name) values ('" + eventType.getName() + "')";
		return stmt.executeUpdate(sql);
	}

	//method to update Event Type
	// returns number of rows affected
	public int updateEventType(Connection myConn, EventType eventType) throws SQLException {
		Statement stmt = myConn.createStatement();
		String sql = "update event_types  set name ='" + eventType.getName() + "' where id = "
				+ eventType.getId();
		return stmt.executeUpdate(sql);
	}

	// method to delete event type
	// returns number of rows affected
	public int deleteEventTypes(Connection myConn, EventType eventType) throws SQLException {
		Statement stmt = myConn.createStatement();
		String sql = "delete from event_types where id = " + eventType.getId();
		return stmt.executeUpdate(sql);
	}

	//method to get all event types
	// returns list of object of type EventType
	public List<EventType> getAllEventTypes(Connection myConn) throws SQLException {
		List<EventType> eventTypes = new ArrayList<EventType>();
		Statement stmt;
		stmt = myConn.createStatement();

		ResultSet result = stmt.executeQuery("select * from event_types  ");
		while (result.next()) {
			EventType eventType = new EventType(result.getInt("id"), result.getString("name"));
			eventTypes.add(eventType);
		}
		return eventTypes;
	}
}
