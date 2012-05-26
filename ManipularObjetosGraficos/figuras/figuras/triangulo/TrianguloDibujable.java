package figuras.triangulo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import basicas.Punto;

import figuras.CirculoDibujable;
import figuras.interfaces.FiguraDibujable;

public class TrianguloDibujable extends Triangulo implements FiguraDibujable {

	public TrianguloDibujable(){
		super();
	}
	
	public TrianguloDibujable(Punto a, Punto b, Punto c){
		super(a,b,c);
	}
	
	public TrianguloDibujable(Triangulo t){
		super(t);
	}
	
	@Override
	public void dibuja(Graphics2D g) {
		if (g == null) throw new NullPointerException();
		g.setColor(Color.MAGENTA);
		g.draw(new Line2D.Double(getA().getX(), getA().getY(), getB().getX(), getB().getY()));
		g.draw(new Line2D.Double(getB().getX(), getB().getY(), getC().getX(), getC().getY()));
		g.draw(new Line2D.Double(getA().getX(), getA().getY(), getC().getX(), getC().getY()));
		g.setColor(Color.BLACK);
	}

	@Override
	public void dibujaEnvoltura(Graphics2D g) {
		new CirculoDibujable(figuraQueEnvuelve()).dibuja(g);
	}

}
