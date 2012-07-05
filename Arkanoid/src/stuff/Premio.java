package stuff;

import java.awt.Image;

public abstract class Premio extends PreImage implements Fisica{
	
	private static final int LADO = 30;

	private int x, y;
	private float vx, vy;

	public Premio() {
		super();
		x = y = 0;
	}

	public Premio(Image icon) {
		super(icon);
		x = y = 0;
		vx = vy = 0;
	}

	public Premio(String name, int x, int y) {
		super(name);
		this.x = x;
		this.y = y;
	}
	
	public Premio(String name, int x, int y, int vy) {
		super(name);
		this.x = x;
		this.y = y;
		this.vx = 1;
		this.vy = vy;
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
	
	@Override
	public void fisica(float dt){
		x += vx * dt;
        y += vy * dt;
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