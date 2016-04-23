package com.engine;

import com.engine.mediator.Mediator;

import com.gui.SignInPage;

public class Driver {
	
	public Driver(){
		Mediator mediator = new Mediator();
		SignInPage.start(mediator);
	}
	
}
