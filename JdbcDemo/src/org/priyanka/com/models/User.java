package org.priyanka.com.models;

public class User {
	private int id;
	private String FirstName;
	private String LastName;
	private String UserName;
	private UserType UserType;

	public User() {

	}

	public User(int id, String firstName, String lastName, String userName, UserType userType) {

		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		UserType = userType;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public UserType getUserType() {
		return UserType;
	}

	public void setUserType(UserType userType) {
		UserType = userType;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public UserType getType() {
		return UserType;
	}

	public void setType(UserType type) {
		UserType = type;
	}

}
