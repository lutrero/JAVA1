package view;

import java.awt.Component;

import controller.Controller;

public interface View {

	Runnable getGameZone();
	
	public void setController(Controller c);
	
	public double getBarX();

	public double getBarY();

	Component getComponent();

}
