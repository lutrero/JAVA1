package stuff;

import java.awt.Image;

public abstract class Circular extends PreImage{
	

	private int centroX;
	private int centroY;
	private int radio;
	
	
	public Circular() {
		super();
		centroX = centroY = radio = 0;
	}

	public Circular(Image icon) {
		super(icon);
		centroX = centroY = radio = 0;
	}
	
	
	public Circular(String name) {
		super(name);
		centroX = centroY = radio = 0;
	}

	public Circular(String name, int centroX, int centroY, int radio) {
		super(name);
		this.centroX = centroX;
		this.centroY = centroY;
		this.radio = radio;
	}


	public int getCentroX() {
		return centroX;
	}


	public void setCentroX(int centroX) {
		this.centroX = centroX;
	}


	public int getCentroY() {
		return centroY;
	}


	public void setCentroY(int centroY) {
		this.centroY = centroY;
	}


	public int getRadio() {
		return radio;
	}


	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public void incrementaX(int inc){
		centroX += inc;
	}
	
	public void incrementaY(int inc){
		centroY += inc;
	}
	
	public int getMaxX(){
		return centroX + radio;
	}
	
	public int getMaxY(){
		return centroY + radio;
	}
	
	public int getMinX(){
		return centroX - radio;
	}
	
	public int getMinY(){
		return centroY - radio;
	}
	
	public boolean intersects(Circular c){
		return new Punto(centroX, centroY).distancia(new Punto(c.centroX, c.centroY)) < (radio + c.radio);
	}

	public boolean intersects(Rectangular r){
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + centroX;
		result = prime * result + centroY;
		result = prime * result + radio;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circular other = (Circular) obj;
		if (centroX != other.centroX)
			return false;
		if (centroY != other.centroY)
			return false;
		if (radio != other.radio)
			return false;
		return true;
	}

	
}
