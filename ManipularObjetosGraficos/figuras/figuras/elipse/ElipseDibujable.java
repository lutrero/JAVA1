package figuras.elipse;

import java.awt.Graphics2D;

import basicas.Punto;

import figuras.RectanguloDibujable;
import figuras.interfaces.FiguraDibujable;

public class ElipseDibujable extends Elipse implements FiguraDibujable {
	
	public ElipseDibujable(){
		super();
	}
	
	public ElipseDibujable(Punto f1, Punto f2, double cuerda){
		super(f1,f2,cuerda);
	}
	
	public ElipseDibujable(Elipse e){
		super(e);
	}

	@Override
	public void dibuja(Graphics2D g) {
		DibujaElipse.dibujarElipse(this, g);
	}

	@Override
	public void dibujaEnvoltura(Graphics2D g) {
		new RectanguloDibujable(figuraQueEnvuelve()).dibuja(g);
	}

}
