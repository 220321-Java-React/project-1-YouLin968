package com.revature.models;

public class User {

	private int ers_users_id;
	private String ers_first_name;
	private String ers_last_name;
	private Role role;

	
	public User() {
		super();
	}


	public User(int ers_users_id, String ers_first_name, String ers_last_name, Role role) {
		super();
		this.ers_users_id = ers_users_id;
		this.ers_first_name = ers_first_name;
		this.ers_last_name = ers_last_name;
		this.role = role;
	}


	public User(String ers_first_name, String ers_last_name, Role role) {
		super();
		this.ers_first_name = ers_first_name;
		this.ers_last_name = ers_last_name;
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [ers_users_id=" + ers_users_id + ", ers_first_name=" + ers_first_name + ", ers_last_name="
				+ ers_last_name + ", role=" + role + "]";
	}


	public int getErs_users_id() {
		return ers_users_id;
	}


	public void setErs_users_id(int ers_users_id) {
		this.ers_users_id = ers_users_id;
	}


	public String getErs_first_name() {
		return ers_first_name;
	}


	public void setErs_first_name(String ers_first_name) {
		this.ers_first_name = ers_first_name;
	}


	public String getErs_last_name() {
		return ers_last_name;
	}


	public void setErs_last_name(String ers_last_name) {
		this.ers_last_name = ers_last_name;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
