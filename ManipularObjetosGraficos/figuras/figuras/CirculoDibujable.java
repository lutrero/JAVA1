package figuras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import basicas.Punto;

import figuras.interfaces.FiguraDibujable;

public class CirculoDibujable extends Circulo implements FiguraDibujable {
	
	
	public CirculoDibujable(){
		super();
	}
	
	public CirculoDibujable(Punto centro, double radio){
		super(centro, radio);
	}
	
	public CirculoDibujable(Circulo c){
		super(c);
	}

	
	@Override
	public void dibuja(Graphics2D g) {
		if (g == null) throw new NullPointerException();
		double diametro  = getCirculo().getCuerda();
		Shape s = new Ellipse2D.Double(getCirculo().getOrigen().getX() - diametro/2, getCirculo().getOrigen().getY() - diametro/2, diametro, diametro);
		if (! g.getColor().equals(Color.WHITE))
			g.setColor(Color.YELLOW);
		g.draw(s);	
		g.setColor(Color.BLACK);
	}

	@Override
	public void dibujaEnvoltura(Graphics2D g) {
		new RectanguloDibujable(figuraQueEnvuelve()).dibuja(g);
	}

}
