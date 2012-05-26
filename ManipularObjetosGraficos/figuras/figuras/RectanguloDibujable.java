package figuras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import basicas.Punto;

import figuras.interfaces.FiguraDibujable;

public class RectanguloDibujable extends Rectangulo implements FiguraDibujable {

	
	public RectanguloDibujable(){
		super();
	}
	
	public RectanguloDibujable(Punto origen, double ancho, double alto, double angulo){
		super(origen, ancho, alto, angulo);
	}
	
	public RectanguloDibujable(Rectangulo r){
		super(r);
	}
	
	@Override
	public void dibuja(Graphics2D g) {
		if (g == null) throw new NullPointerException();
		Punto [] puntos = obtenerPuntos();
		if (! g.getColor().equals(Color.WHITE))
			g.setColor(Color.GREEN);
		g.draw(new Line2D.Double(puntos[0].getX(), puntos[0].getY(), puntos[1].getX(), puntos[1].getY()));
		g.draw(new Line2D.Double(puntos[0].getX(), puntos[0].getY(), puntos[2].getX(), puntos[2].getY()));
		g.draw(new Line2D.Double(puntos[1].getX(), puntos[1].getY(), puntos[3].getX(), puntos[3].getY()));
		g.draw(new Line2D.Double(puntos[3].getX(), puntos[3].getY(), puntos[2].getX(), puntos[2].getY()));
		g.setColor(Color.BLACK);
	}

	@Override
	public void dibujaEnvoltura(Graphics2D g) {
		new CirculoDibujable(figuraQueEnvuelve()).dibuja(g);
	}

}
