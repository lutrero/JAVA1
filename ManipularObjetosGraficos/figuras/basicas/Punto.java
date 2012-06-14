package basicas;

/**
 * 
 * @author Luis Trevi�o
 * Clase que representa un punto en dos dimensiones con doble precision.
 *
 */


public class Punto{
	
	private double x;
	private double y;
	
	
	public Punto() {
		super();
		x = y = 0;
	}
	
	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Punto(Punto p){
		super();
		if (p == null)
			throw new NullPointerException("El punto es null.");
		x = p.x;
		y = p.y;	
	}
	
	public static double anguloTresPuntos(Punto vertice, Punto p1, Punto p2){
		if (vertice == null || p1 == null || p2 == null) throw new NullPointerException();
		return new VectorPunto(vertice,p1).angulo(new VectorPunto(vertice, p2));	
	}
	
	public Punto getPunto(double distancia, double angulo){
		double dY = Math.sin(angulo)*distancia;
		double dX = Math.cos(angulo)*distancia;
		return new Punto(this).mover(dX, dY);
	}

	
	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}
	
	public double distancia(Punto p) {
		if (p == null) throw new NullPointerException("El punto no puede ser null");
		else
			return (Math.sqrt((p.x - x) * (p.x - x) + (p.y - y) * (p.y - y)));
	}
	
	public Punto mover(double dX, double dY) {
		x += dX;
		y += dY;
		return this;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Punto other = (Punto) obj;	
		if (! CompararDouble.iguales(x, other.x, 7))
			return false;
		if (! CompararDouble.iguales(y, other.y, 7))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public int compareX(Punto p){
		if (p == null) throw new NullPointerException("El punto es null.");
		double aux = p.x - x;
		if (aux < 0) return 1;
		if (aux == 0) return 0;
		return -1;
	}
	
	public int compareY(Punto p){
		if (p == null) throw new NullPointerException("El punto es null.");
		double aux = p.y - y;
		if (aux < 0) return 1;
		if (aux == 0) return 0;
		return -1;
	}

	public void mover(Punto p) {
		x = p.x;
		y = p.y;
		
	}
}
