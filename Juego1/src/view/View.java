package view;

import java.awt.Component;

import controller.Controller;

public interface View {

	public abstract void setController(Controller c);

	public abstract float getFisicsY();

	public abstract float getFisicsX();

	public abstract double getBarX();

	public abstract double getBarY();

	public abstract Component getComponent();

	public abstract void cicloPrincipalJuego() throws Exception;

}
