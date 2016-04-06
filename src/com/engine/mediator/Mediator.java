package com.engine.mediator;

import com.engine.mediator.data.User;

public class Mediator {

	private User user;
	
	public Mediator(){
		setUser(new User());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
