package org.priyanka.com.models;

public class EventType {
	private int id;
	private String name;
	
	public EventType(int id, String name) {		
		this.id = id;
		this.name = name;
	}
	
	public EventType(){
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
