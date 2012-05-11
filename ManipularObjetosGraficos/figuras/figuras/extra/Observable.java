package figuras.extra;

import java.awt.Graphics2D;

import basicas.Punto;

public interface Observable {
	
	public static final int ROTAR = 1;
	public static final int ESCALAR = 2;
	public static final int MOVER = 3;

	public void addObservador(Observador o, int tipo);
	
	public void delObservador(Observador o, int tipo);
	
	public void notificarObservadores();
	
	public void rotar(double ang);
	
	public void escalar(double f);
	
	public Punto getOrigen();
	
	public void dibuja(Graphics2D g);
	public void dibujaEnvoltura(Graphics2D g);
	
	public void mover(double x, double y);
	public void mover(Punto p);
	
	public String [] getData();
}
