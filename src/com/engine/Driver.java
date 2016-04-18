package com.engine;

import com.engine.mediator.Mediator;
import com.gui.SIGNIN;

public class Driver {
	
	public Driver(){
		Mediator mediator = new Mediator();
		new SIGNIN(mediator).start(mediator);
	}
	
}
