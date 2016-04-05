package com.engine;

import com.engine.mediator.Mediator;
import com.gui.Window;

public class Driver {
	
	public Driver(){
		Mediator mediator = new Mediator();
		new Window(mediator).start(mediator);
	}
	
}
