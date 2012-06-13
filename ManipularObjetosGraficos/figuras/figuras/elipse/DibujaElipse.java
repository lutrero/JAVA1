package figuras.elipse;

/**
 * @author Luis trevi�o
 * Clase que encapsula el metodo dibujar elipse de la clase elipse.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;

import basicas.Punto;
import figuras.Rectangulo;

public final class DibujaElipse {
	
	static void dibujarElipse(Elipse e, Graphics2D g){
		Rectangulo r = e.rectanguloExterior();
		Punto p2 = new Punto((e.getFoco1().getX() - e.getFoco2().getX()) *
				(((e.getCuerda() - e.getFoco1().distancia(e.getFoco2())) / 2) /
						e.getFoco1().distancia(e.getFoco2()) ) + e.getFoco1().getX() ,
				(e.getFoco1().getY() - e.getFoco2().getY()) *
				(((e.getCuerda() - e.getFoco1().distancia(e.getFoco2())) / 2) /
						e.getFoco1().distancia(e.getFoco2()) ) + e.getFoco1().getY());
		Punto p3 = new Punto((e.getFoco2().getX() - e.getFoco1().getX()) *
				(((e.getCuerda() - e.getFoco1().distancia(e.getFoco2())) / 2) / e.getFoco1().distancia(e.getFoco2()) ) + e.getFoco2().getX(),
				(e.getFoco2().getY() - e.getFoco1().getY()) * (((e.getCuerda() -
						e.getFoco1().distancia(e.getFoco2())) / 2) / e.getFoco1().distancia(e.getFoco2())) + e.getFoco2().getY());
		Punto pCtrl1 = p2.getPunto(r.getAlto()*2/3, r.getAngulo()+Math.PI/2 );
		Punto pCtrl2 = p3.getPunto(r.getAlto()*2/3, r.getAngulo()+Math.PI/2 );
		CubicCurve2D s2 = new CubicCurve2D.Double(p2.getX(), p2.getY(), pCtrl1.getX(), pCtrl1.getY(),
				pCtrl2.getX(), pCtrl2.getY(), p3.getX(), p3.getY());
		Punto pCtrl3 = p2.getPunto(r.getAlto()*2/3, r.getAngulo()+3*Math.PI/2 );
		Punto pCtrl4 = p3.getPunto(r.getAlto()*2/3, r.getAngulo()+3*Math.PI/2 );
		CubicCurve2D s3 = new CubicCurve2D.Double(p2.getX(), p2.getY(), pCtrl3.getX(), pCtrl3.getY(),
				pCtrl4.getX(), pCtrl4.getY(), p3.getX(), p3.getY());
		g.setPaint(Color.RED);
		g.draw(s2);
//		g.setPaint(Color.BLUE);
		g.draw(s3); 
		g.setPaint(Color.BLACK);
	}

}
