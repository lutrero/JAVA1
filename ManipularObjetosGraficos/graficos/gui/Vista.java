package gui;


import java.awt.Container;


import basicas.Punto;

public interface Vista {
	
	public void setControlador(Controlador t);
	public void setModelo(Modelo m);
	public void repintar();
	
	public Container getContenedor();
//	public double getRotacion();
//	public Integer getPosicionX();
//	public Integer getPosicionY();
//	public double getEscalado();
	public void setSliders(Punto p);
	

}
