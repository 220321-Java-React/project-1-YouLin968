package com.revature.models;

public class User {

	private int ers_users_id;
	private String users_first_name;
	private String users_last_name;
	private Role role;

	
	public User() {
		super();
	}


	public User(int ers_users_id, String users_first_name, String users_last_name, Role role) {
		super();
		this.ers_users_id = ers_users_id;
		this.users_first_name = users_first_name;
		this.users_last_name = users_last_name;
		this.role = role;
	}


	public User(String users_first_name, String users_last_name, Role role) {
		super();
		this.users_first_name = users_first_name;
		this.users_last_name = users_last_name;
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [ers_users_id=" + ers_users_id + ", users_first_name=" + users_first_name + ", users_last_name="
				+ users_last_name + ", role=" + role + "]";
	}


	public int getErs_users_id() {
		return ers_users_id;
	}


	public void setErs_users_id(int ers_users_id) {
		this.ers_users_id = ers_users_id;
	}


	public String getUsers_first_name() {
		return users_first_name;
	}


	public void setUsers_first_name(String users_first_name) {
		this.users_first_name = users_first_name;
	}


	public String getUsers_last_name() {
		return users_last_name;
	}


	public void setUsers_last_name(String users_last_name) {
		this.users_last_name = users_last_name;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
