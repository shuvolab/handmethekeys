package com.engine.mediator.data;

public class Car {
	private int ID, zip;
	private String make;
	private int ID;
	private String brand;
	private String model;
	private String year;
	private User owner;
	
	
	public Car() {
		setID(-1);
		setBrand("");
		setModel("");
		setYear("");
		setOwner(new User());
	}
	

	public Car(int id, String mk, String md, String yr, int zip, User user) {
		setID(id);
		setBrand(br);
		setModel(md);
		setYear(yr);
		setZip(zip);
		setOwner(user);
	}
	
	public int getID(){
		return ID;
	}
	
	public void setID(int id){
		ID=id;
	}
	
	public String getMake(){
		return brand;
	}
	
	public void setBrand(String br){
		brand=br;
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
		String car = "Make: "+brand+" Model: "+model+" Year: "+year;
		return car;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
}
