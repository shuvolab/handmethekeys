package com.engine.mediator.data;

public class User {

	private int ID;
	private String username;
	private String password;
	
	public User(){
		setID(-1);
		setUsername("");
		setPassword("");
	}
	
	public User(int id, String uname, String pwd){
		this.setID(id);
		this.setUsername(uname);
		this.setPassword(pwd);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
