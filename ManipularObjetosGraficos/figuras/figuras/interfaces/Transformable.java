package figuras.interfaces;

import basicas.Punto;

public interface Transformable {

	public void rotar(double ang);
	
	public void escalar(double f);
	
	public Punto getOrigen();
	
	public void mover(double x, double y);
	
	public void mover(Punto p);
}
