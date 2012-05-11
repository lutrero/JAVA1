package basicas;

/**
 * 
 * @author Luis Treviño
 * 
 * Clase que representa un vector en dos dimensiones sobre un punto.
 *
 */

public class VectorPunto {
	
	private Punto vector;
	
	public VectorPunto(){
		super();
		vector = new Punto();
	}

	public VectorPunto(double x, double y){
		super();
		vector = new Punto(x, y);
	}
	
	public VectorPunto(Punto p1, Punto p2){
		super();
		
		if (p1 == null || p2 == null)
			throw new NullPointerException();
		vector = new Punto(p2.getX() - p1.getX(), p2.getY() - p1.getY());
	}
	
	public double getX(){
		return vector.getX();
	}
	
	public double getY(){
		return vector.getY();
	}
	
	public double modulo(){
		double x = vector.getX();
		double y = vector.getY();
		return Math.sqrt(x*x + y*y);
	}
	
	public double productoEscalar(VectorPunto v){
		if (v == null) return Double.NaN;
		else return vector.getX()*v.getX() + vector.getY()*v.getY();
		
	}
	
	public static double sentidoProductoVectorial(Punto p1, Punto p2, Punto p3){
		if ( p1 == null || p2 == null || p3 == null) return Double.NaN;
		else return (p1.getX() - p3.getX())*(p2.getY() - p3.getY())-(p1.getY() - p3.getY())*(p2.getX() - p3.getX());
	}
	
	public double angulo(VectorPunto v){
		if ( v == null ) return Double.NaN;
		if ((this.modulo() * v.modulo()) == 0) 
			return 0;
		else
			return Math.acos(this.productoEscalar(v) / (this.modulo()*v.modulo()));
	}
}