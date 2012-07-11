package premios;

import java.awt.Image;

import stuff.Bola;
import stuff.Fisica;
import stuff.PreImage;
import stuff.Rectangular;

public abstract class Premio extends PreImage implements Fisica{
	
	private static final int LADO = 30;

	private int x, y;
	private float vx, vy;
	private Bola bola;

	public Premio() {
		super();
		x = y = 0;
		bola = null;
	}

	public Premio(Image icon) {
		super(icon);
		x = y = 0;
		vx = vy = 0;
		bola = null;
	}

	public Premio(String name, int x, int y) {
		super(name);
		this.x = x;
		this.y = y;
		bola = null;
	}
	
	public Premio(String name,float vy, Bola b) {
		super(name);
		this.x = b.getCentroX();
		this.y = b.getCentroY();
		this.vx = 0;
		this.vy = vy;
		bola = b;
	}
	
	public Bola getBola() {
		return bola;
	}

	public void setBola(Bola bola) {
		this.bola = bola;
	}

	public int getMaxX(){
		return x + LADO;
	}
	
	public int getMinX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getMaxY() {
		return y;
	}
	
	public int getMinY(){
		return y - LADO;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean intersects(Rectangular r){
		if (((r.getMaxX() - getMinX()) < (LADO/2 + r.getAncho()/2) && (r.getMaxY() - getMinY()) < (LADO/2 + r.getAlto()/2)) ||
				((getMaxX() - r.getMinX()) < (LADO/2 + r.getAncho()/2) && (getMaxY() - r.getMinY() < (LADO/2 + r.getAlto()/2))))
			return true;
		return false;
	}
	
	@Override
	public void fisica(float dt){
		x += vx * dt;
        y += vy * dt;
	}
	
	@Override
	public void startM() {
		vx = 0;
		vy = 150f;
	}


	@Override
	public void stopM() {
		vx = vy = 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + x;
		result = prime * result + y;
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
		Premio other = (Premio) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}	
}
