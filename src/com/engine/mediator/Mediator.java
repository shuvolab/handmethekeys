package com.engine.mediator;

import com.engine.mediator.data.*;

import java.util.ArrayList;

public class Mediator {

	private User user;
	private ArrayList<Car> carList;
	
	public Mediator(){
		setUser(new User());
		setCarList(new ArrayList<Car>());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public ArrayList<Car> getCarList(){
		return carList;
	}
	
	public void setCarList(ArrayList<Car> cars){
		carList=cars;
	}
	
}
