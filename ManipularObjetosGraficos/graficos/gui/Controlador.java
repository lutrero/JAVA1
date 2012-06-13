package gui;

import java.awt.Graphics2D;

import basicas.Punto;

public interface Controlador {
	
	public static final int RECTANGULO = 1;
	public static final int CIRCULO = 2;
	public static final int TRIANGULO = 3;
	public static final int ELIPSE = 4;
	
	public void setModelo(Modelo m);
	public void setVista(Vista v);
	public void solicitaMover(Punto p);
	public void solicitaMover(double dx, double dy);
	public void solicitaEscalar(double d, double r);
	public void solicitaRotar(double a, double r);
	public void solicitarSeleccionar(Punto p);
	public void solicitaBorrar();
	public void solicitaNueva(int tipo);
	public void solicitaActulizarPosicion(Punto p);
	public void solicitaDibujar(Seleccion s, Graphics2D g);

	
	//funcio que saque datos de vista cuando se le solicite y se los pase a modelo. 

}
