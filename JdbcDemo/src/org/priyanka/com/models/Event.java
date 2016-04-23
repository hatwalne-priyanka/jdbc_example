package org.priyanka.com.models;

import java.util.Date;

public class Event {
	private int id;
	private String name;
	private String description;
	private String vdo_url;
	private String place;
	private Boolean flyer;
	private Date event_time;
	private EventType type;

	public Event() {

	}

	public Event(int id, String name, String description, String vdo_url, String place,
			Boolean flyer, Date event_time, EventType type) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.vdo_url = vdo_url;
		this.place = place;
		this.flyer = flyer;
		this.event_time = event_time;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getVdo_url() {
		return vdo_url;
	}

	public String getPlace() {
		return place;
	}

	public Boolean getFlyer() {
		return flyer;
	}

	public Date getEvent_time() {
		return event_time;
	}

	public EventType getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setVdo_url(String vdo_url) {
		this.vdo_url = vdo_url;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setFlyer(Boolean flyer) {
		this.flyer = flyer;
	}

	public void setEvent_time(Date event_time) {
		this.event_time = event_time;
	}

	public void setType(EventType type) {
		this.type = type;
	}

}
