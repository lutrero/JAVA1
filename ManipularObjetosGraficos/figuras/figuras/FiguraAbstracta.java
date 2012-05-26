package figuras;

import figuras.interfaces.Figura;

/**
 * 
 * @author Luis Trevi�o
 *
 *Clase abstracta que mantiene los atributos comunes a todas la figuras en este caso el angulo.
 */

public abstract class FiguraAbstracta implements Figura{

	protected double angulo;
	protected static final double tolerancia = 0.2;

	public FiguraAbstracta() {
		super();
		angulo = 0;
	}

	public FiguraAbstracta(double angulo) {
		super();
		this.angulo = angulo;
	}
	
	public double getAngulo(){
		return angulo;
	}
}
