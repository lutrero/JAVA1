package figuras;

/**
 * @author Luis Treviño
 * 
 * Interfaz figura representa todas la figuras en 2 dimensiones
 * 
 */

import java.awt.Graphics2D;
import basicas.Punto;



public interface Figura {

//	static final int CIRCULO = 1;
//	static final int RECTANGULO = 2;
//	static final int TRIANGULO = 3;
//	static final int ELIPSE = 4;
	
	//  Rota la figura angulo radianes.
	public Figura rotar(double angulo);
	
	// Desplaza la figura dX y dY unidades
	public Figura mover(double dX, double dY);
	
	//Desplaza la figura ahsta el punto p 
	public Figura mover(Punto p);
	
	//Escala la figura factor veces
	public Figura escalar(double factor);
	
	//True si el punto esta dentro de la figura sino false
	public boolean estaContenido(Punto p);
	
	// True si el punto esta cerca del perimetro de la figura con una tolerancia.
	public boolean estaEnPerimetro(Punto p);
	
	//Punto de referencia de la figura
	public Punto getOrigen();
	
	//Circulo o rectangulo que envuelve a la figura
	public Figura figuraQueEnvuelve();
	
	//Dibuja la figura en un Graphics2D g
	public void dibuja(Graphics2D g);
	
	//Devuelve el area de la figura.
	public double area();
}
