package figuras;

/**
 * @author Luis Trevi�o
 * 
 * Clase que representa un circulo mediate una elipse, implementa el interfaz Figura.
 */


//import figuras.elipse.Elipse;
import basicas.Punto;

public class Circulo extends FiguraAbstracta {
	
//	private Elipse circulo;
	private double radio;
	private Punto centro;
	
	public Circulo(){
		super(0);
//		circulo = new Elipse(new Punto(0, 0),new Punto(0, 0),2);
		centro = new Punto();
		radio = 1;
	}
	
	public Circulo(Punto centro, double radio){
		super(0);
		if (centro == null) throw new NullPointerException("el centro no puede ser null");
//		circulo = new Elipse(centro,centro,2*radio);
		this.centro = centro;
		this.radio = radio;
	}
	
	public Circulo(Circulo c){
		super(0);
//		circulo = new Elipse(c.getCirculo());
		radio = c.radio;
		centro = new Punto(c.centro);
	}
	
	public  double getRadio(){
//		return circulo.getCuerda()/2;
		return radio;
	}
	
//	protected Elipse getCirculo(){
//		return circulo;
//	}
	
	@Override
	public double area(){
//		return circulo.area();
	return Math.PI *radio*radio;
	}

	@Override
	public Circulo rotar(double angulo) {
//		circulo.rotar(angulo);
		super.angulo += angulo;
		return this;
	}

	@Override
	public Circulo mover(double dX, double dY) {
//		circulo.mover(dX, dY);
		centro.mover(dX, dY);
		return this;
	}

	@Override
	public Circulo escalar(double factor) {
//		circulo.escalar(factor);
		radio *= factor;
		return this;
	}

	@Override
	public boolean estaContenido(Punto p) {
		if ( p == null ) return false;
//		return circulo.estaContenido(p);
		return centro.distancia(p) <= radio;
	}

	@Override
	public boolean estaEnPerimetro(Punto p) {
		if ( p == null ) return false;
//		return circulo.estaEnPerimetro(p);
		double dis = centro.distancia(p);
		return dis < radio + tolerancia && dis > radio - tolerancia;
	}
	
	@Override
	public Circulo mover(Punto p) {
//		circulo.mover(p);
		centro.mover(p);
		return this;
	}

	@Override
	public Rectangulo figuraQueEnvuelve() {
//		return circulo.rectanguloExterior();
		return new Rectangulo(new Punto(centro.getX() - radio, centro.getY()-radio), radio+radio, radio+radio, super.angulo);
	}

	@Override
	public Punto getOrigen() {
//		return circulo.getFoco1();
		return centro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
		long temp;
		temp = Double.doubleToLongBits(radio);
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
		Circulo other = (Circulo) obj;
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		if (Double.doubleToLongBits(radio) != Double
				.doubleToLongBits(other.radio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", centro=" + centro + "]";
	}
	

	
	
}
