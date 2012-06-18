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
	
	public void accelX();
	
	public void deccelX();
	
	public void accelY();
	
	public void deccelY();
	
	public void invertVx();
	
	public void invertVy();
	
	public float getVx();
	
	public float getVy();
	
	public void startM();
	
	public void stopM() ;

	public void cicloPrincipalJuego() throws Exception;

	void setFisicsX(float x);

	void setFisicsY(float y);

}
