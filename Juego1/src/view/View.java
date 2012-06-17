package view;

import java.awt.Component;

import controller.Controller;

public interface View {

	public void setController(Controller c);

	public float getFisicsY();

	public float getFisicsX();

	public double getBarX();

	public double getBarY();

	public Component getComponent();
	
	public void invertVx();
	
	public void invertVy();
	
	public float getVx();
	
	public float getVy();

	public void cicloPrincipalJuego() throws Exception;

}
