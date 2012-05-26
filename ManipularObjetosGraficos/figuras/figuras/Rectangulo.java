package figuras;



import figuras.elipse.Elipse;
import figuras.triangulo.Triangulo;


import basicas.CompararDouble;
import basicas.Punto;

/**
 * 
 * @author Luis Trevi�o Romojaro
 * Clase que representa un rectangulo rotable y dibujable, esta representada por uno de sus vertices,
 * el ancho, el alto y su angulo de rotacion implementa el interfaz Figura.
 *
 */
public class Rectangulo extends FiguraAbstracta{
	
	private Punto origen; 		//Vertice de referencia.
	private double ancho; 		//Ancho del rectangulo.
	private double alto;		//Alto del rectangulo
	
	
	
	public Rectangulo() {
		super(0);
		origen = new Punto();
		alto = ancho = 1;
	}

	public Rectangulo(Punto origen, double ancho, double alto, double angulo) {
		super(angulo);
		if ( origen == null ) throw new NullPointerException();
		if (alto < 0 || ancho < 0)
			throw new IllegalStateException("Menor que cero??");
		this.origen = origen;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public Rectangulo(Rectangulo r){
		super(r.getAngulo());
		origen = r.getOrigen();
		ancho = r.getAncho();
		alto = r.getAlto();
	}

	public Punto getOrigen() {
		return origen;
	}

	public double getAncho() {
		return ancho;
	}

	public double getAlto() {
		return alto;
	}

	public double getAngulo() {
		return angulo;
	}

	public static double getTolerancia() {
		return tolerancia;
	}
	
	@Override
	public Rectangulo mover(double dX, double dY) {
		origen.mover(dX, dY);
		return null;
	}

	@Override
	public Rectangulo escalar(double factor) {
		if (factor < 0) factor = 1 / (-factor);
		ancho *= factor;
		alto *= factor;
		return this;
	}

	@Override
	public boolean estaContenido(Punto p) {
		if ( p == null) return false;
		Punto [] puntos = obtenerPuntos();
		Triangulo t1 = new Triangulo(puntos[0], puntos[1], puntos[2]);
		Triangulo t2 = new Triangulo(puntos[3], puntos[1], puntos[2]);
		return t1.estaContenido(p) || t2.estaContenido(p);
	}

	@Override
	public boolean estaEnPerimetro(Punto p) {
		if ( p == null) return false;
		Punto [] puntos = obtenerPuntos();
		Elipse e1 = new Elipse(puntos[0],puntos[1],tolerancia + puntos[0].distancia(puntos[1]));
		Elipse e2 = new Elipse(puntos[0],puntos[2],tolerancia + puntos[0].distancia(puntos[2]));
		Elipse e3 = new Elipse(puntos[1],puntos[3],tolerancia + puntos[1].distancia(puntos[3]));
		Elipse e4 = new Elipse(puntos[2],puntos[3],tolerancia + puntos[2].distancia(puntos[3]));
		return e1.estaContenido(p) || e2.estaContenido(p) || e3.estaContenido(p)||e4.estaContenido(p);
	}

	@Override
	public Rectangulo rotar(double angulo) {
		Punto p = origen.getPunto(ancho/2, this.angulo);
		p = p.getPunto(alto/2, super.angulo + Math.PI/2);
		super.angulo += angulo;
		p = p.getPunto(alto/2, this.angulo + 3*Math.PI/2);
		origen = p.getPunto(ancho/2, this.angulo + Math.PI);
		if (CompararDouble.iguales(super.angulo / (2*Math.PI), 1, 8)) super.angulo -= 2*Math.PI;
		return this;
	}
	
	@Override
	public double area(){
		return ancho * alto;
	}

	@Override
	public Rectangulo mover(Punto p) {
		origen = p;
		return this;
	}

	@Override
	public Circulo figuraQueEnvuelve() {
		Punto p = origen.getPunto(ancho/2, angulo);
		p = p.getPunto(alto/2, angulo + Math.toRadians(90));
		return new Circulo(p, origen.distancia(p));
	}

	
	@Override
	public String toString() {
		return "[origen=" + origen + ", ancho=" + ancho + ", alto="
				+ alto + ", angulo=" + angulo + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(alto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ancho);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(angulo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((origen == null) ? 0 : origen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Rectangulo other = (Rectangulo) obj;
		if (! CompararDouble.iguales(alto, other.alto, 7))     return false;
		if (! CompararDouble.iguales(ancho, other.ancho, 7))   return false;
		if (! CompararDouble.iguales(angulo, other.angulo, 7)) return false;
		if (origen == null) {
			if (other.origen != null) return false;
		} else if (!origen.equals(other.origen)) return false;
		return true;
	}
	
	protected Punto[] obtenerPuntos(){
		Punto [] puntos = new Punto[4];
		puntos[0] = origen;
		puntos[1] = origen.getPunto(ancho, angulo);
		puntos[2] = origen.getPunto(alto, angulo + Math.PI/2);
		puntos[3] = puntos[1].getPunto(alto, angulo + Math.PI/2);
		return puntos;
	}
}
