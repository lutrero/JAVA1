package gui;

import figuras.Figura;

import java.awt.Graphics2D;
import java.util.Vector;

import basicas.Punto;

public interface Modelo {

	public void setVista(Vista v);
	public void setRotacion(double angulo, double ref);
	public void setPosicion(Punto p);
	public void setPosicion(double dx, double dy);
	public void setEscalado(double factor, double ref);
	public void actualizaPosicion(Punto p);
	public void addFigura(Figura f);
	public void dibujar(Seleccion s, Graphics2D g);
	public Seleccion getSeleccion();
	public Vector<Seleccion> getVectorFiguras();
	public Seleccion seleccionar(Punto p);
	public void borrar();
	
	
	
}
