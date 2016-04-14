package com.engine.mediator.data;

public class Car {
	private int ID;
	private String make;
	private String model;
	private String year;
	private User owner;
	
	public Car() {
		setID(-1);
		setMake("");
		setModel("");
		setYear("");
		setOwner(new User());
	}
	
	public Car(int id, String mk, String md, String yr) {
		setID(id);
		setMake(mk);
		setModel(md);
		setYear(yr);
	}
	
	public int getID(){
		return ID;
	}
	
	public void setID(int id){
		ID=id;
	}
	
	public String getMake(){
		return make;
	}
	
	public void setMake(String mk){
		make=mk;
	}
	
	public String getModel(){
		return model;
	}
	
	public void setModel(String md){
		model=md;
	}
	
	public String getYear(){
		return year;
	}
	
	public void setYear(String yr){
		year=yr;
	}
	
	public User getOwner(){
		return owner;
	}
	
	public void setOwner(User user){
		owner=user;
	}
	
	public String toString(){
		String car = "Make: "+make+" Model: "+model+" Year: "+year;
		return car;
	}
}
