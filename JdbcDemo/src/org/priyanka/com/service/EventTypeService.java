package org.priyanka.com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.priyanka.com.models.EventType;


public class EventTypeService {

	public EventTypeService(){
		
	}
	
	public EventType getEventType(Connection myConn, int id) throws SQLException{
		Statement stmt;
		EventType eventType = null;
		
			stmt = myConn.createStatement();
			
			ResultSet result = stmt.executeQuery("select * from event_types where id = " + id);
			result.last();
			int size = result.getRow();
			System.out.println("Size: " + size);
			if(size != 1) {
				throw new RuntimeException("Expected to return one record but got " + size + " records");
			}
			result.first();
			
			eventType =  new EventType(result.getInt("id"), result.getString("name"));
			
		
		
		return eventType;
	}

	public int addEventType(Connection myConn, EventType eventType) throws SQLException{ 
			Statement stmt = myConn.createStatement();
			String sql = "insert into event_types (name) values ('" + eventType.getName() + "')";
			return stmt.executeUpdate(sql);	
	}
    
	public int updateEventType(Connection myConn, EventType eventType) throws SQLException{ 
			Statement stmt = myConn.createStatement();
			String sql = "update event_types  set name ='" + eventType.getName() + "' where id = " + eventType.getId();
			return stmt.executeUpdate(sql);		
	}

	public int deleteEventTypes(Connection myConn, EventType eventType) throws SQLException{
			Statement stmt = myConn.createStatement();
			String sql = "delete from event_types where id = " + eventType.getId();
			return stmt.executeUpdate(sql);
	}
	
	public List<EventType> getAllEventTypes(Connection myConn) throws SQLException{
		List<EventType> eventTypes = new ArrayList<EventType>();
		Statement stmt;
			stmt = myConn.createStatement();
			
			ResultSet result = stmt.executeQuery("select * from event_types  ");
			while(result.next()){
				EventType eventType =  new EventType(result.getInt("id"), result.getString("name"));
				eventTypes.add(eventType);
			}
		return eventTypes;
	}
}
