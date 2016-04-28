package com.engine.mediator;

import com.engine.mediator.data.*;

import java.util.ArrayList;

public class Mediator {

    private User user;
    private ArrayList<Car> carList;
    private String startDate;
    private String endDate;

    public Mediator() {
        setUser(new User());
        setCarList(new ArrayList<Car>());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public void setCarList(ArrayList<Car> cars) {
        carList = cars;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String date) {
        startDate = date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String date) {
        endDate = date;
    }
}
