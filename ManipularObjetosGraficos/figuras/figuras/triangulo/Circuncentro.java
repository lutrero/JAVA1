package figuras.triangulo;

/**
 * @author Luis Treviño
 * 
 * Clase que encapsula el metodo de obtener el circuncentro del triangulo
 */

import basicas.CompararDouble;
import basicas.Punto;

public final class Circuncentro{
	
	static Punto obtenerCircuncentro(Triangulo t){
		double x, y;
		
		Punto medioAB = new Punto( (t.getB().getX() + t.getA().getX()) / 2,  (t.getB().getY() + t.getA().getY()) / 2);
		double pendienteAB = (t.getB().getY() - t.getA().getY()) / (t.getB().getX() - t.getA().getX());
		Punto medioAC = new Punto((t.getC().getX() + t.getA().getX()) / 2, (t.getC().getY() + t.getA().getY()) / 2);
		double pendienteAC = (t.getC().getY() - t.getA().getY()) / (t.getC().getX() - t.getA().getX());
		
		if (CompararDouble.iguales(t.getA().getX(), t.getB().getX(), 20)){
			y = (t.getB().getY() + t.getA().getY()) / 2;
			if (CompararDouble.iguales(t.getA().getY(), t.getC().getY(), 20)){
				x = (t.getC().getX() + t.getA().getX()) / 2;
			}else{
				x = (y - medioAC.getY()) / (-1/pendienteAC) + medioAC.getX(); 
			}
		}else if(CompararDouble.iguales(t.getA().getX(), t.getC().getX(), 20)){
			y = (t.getC().getY() + t.getA().getY()) / 2;
			if (CompararDouble.iguales(t.getA().getY(), t.getB().getY(), 20)){
				x = (t.getB().getX() + t.getA().getX()) / 2;
			}else{
				x = (y - medioAB.getY()) / (-1/pendienteAB) + medioAB.getX(); 
			}
		}else{
			if (CompararDouble.iguales(t.getA().getY(), t.getC().getY(), 20)){
				x = (t.getC().getX() - t.getA().getX())/2 + t.getA().getX();
				y = (-1 / pendienteAB) * (x - medioAB.getX()) + medioAB.getY();
			}else{
				if (CompararDouble.iguales(t.getA().getY(), t.getB().getY(), 20)){
					x = (t.getB().getX() - t.getA().getX())/2 + t.getA().getX();
					y = (-1 / pendienteAC) * (x - medioAC.getX()) + medioAC.getY();
				}else{
					double determinante = (1 / pendienteAB) - (1 / pendienteAC);
					double independienteAB = medioAB.getY() + ((1 / pendienteAB) * medioAB.getX());
					double independienteAC = medioAC.getY() + ((1 / pendienteAC) * medioAC.getX());
					x = (independienteAB - independienteAC) / determinante;
					y = (((1 / pendienteAB) * independienteAC) - ((1 / pendienteAC) * independienteAB)) / determinante; 
				}
			}
		}
		return new Punto(x, y);
	}

}
