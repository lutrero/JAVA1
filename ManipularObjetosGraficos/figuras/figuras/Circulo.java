package figuras;

/**
 * @author Luis Treviño
 * 
 * Clase que representa un circulo mediate una elipse, implementa el interfaz Figura.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import figuras.elipse.Elipse;

import basicas.Punto;

public class Circulo implements Figura {
	
	private Elipse circulo;

	public Circulo(){
		super();
		circulo = new Elipse(new Punto(0, 0),new Punto(0, 0),2);
	}
	
	public Circulo(Punto centro, double radio){
		super();
		if (centro == null) throw new NullPointerException("el centro no puede ser null");
		circulo = new Elipse(centro,centro,2*radio);
	}
	
	public  double getRadio(){
		return circulo.getCuerda()/2;
	}
	
	@Override
	public double area(){
		return circulo.area();
	}

	@Override
	public Circulo rotar(double angulo) {
		circulo.rotar(angulo);
		return this;
	}

	@Override
	public Circulo mover(double dX, double dY) {
		circulo.mover(dX, dY);
		return this;
	}

	@Override
	public Circulo escalar(double factor) {
		circulo.escalar(factor);
		return this;
	}

	@Override
	public boolean estaContenido(Punto p) {
		if ( p == null ) return false;
		return circulo.estaContenido(p);
	}

	@Override
	public boolean estaEnPerimetro(Punto p) {
		if ( p == null ) return false;
		return circulo.estaEnPerimetro(p);
	}
	
	@Override
	public Circulo mover(Punto p) {
		circulo.mover(p);
		return this;
	}

	@Override
	public Rectangulo figuraQueEnvuelve() {
		return circulo.rectanguloExterior();
	}

	@Override
	public Punto getOrigen() {
		return circulo.getOrigen();
	}

	@Override
	public void dibuja(Graphics2D g) {
		if (g == null) throw new NullPointerException();
		double diametro  = circulo.getCuerda();
		Shape s = new Ellipse2D.Double(circulo.getOrigen().getX() - diametro/2, circulo.getOrigen().getY() - diametro/2, diametro, diametro);
		if (! g.getColor().equals(Color.WHITE))
			g.setColor(Color.YELLOW);
		g.draw(s);	
		g.setColor(Color.BLACK);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((circulo == null) ? 0 : circulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		if (circulo == null) {
			if (other.circulo != null)
				return false;
		} else if (!circulo.equals(other.circulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[centro = " + circulo.getOrigen().toString() + ", radio = " + circulo.getCuerda()/2 + "]";
	}
}
