package stuff;

import java.awt.geom.Rectangle2D;

public class Boxes {
	
	private Rectangle2D box;
	private int touches;
	
	
	public Boxes() {
		super();
		box = new Rectangle2D.Float();
		touches = 1;
	}


	public Boxes(Rectangle2D box, int touches) {
		super();
		this.box = box;
		this.touches = touches;
	}


	public Rectangle2D getBox() {
		return box;
	}


	public void setBox(Rectangle2D box) {
		this.box = box;
	}


	public int getTouches() {
		return touches;
	}


	public void setTouches(int touches) {
		this.touches = touches;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((box == null) ? 0 : box.hashCode());
		result = prime * result + touches;
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
		Boxes other = (Boxes) obj;
		if (box == null) {
			if (other.box != null)
				return false;
		} else if (!box.equals(other.box))
			return false;
		if (touches != other.touches)
			return false;
		return true;
	}
	
	
	
	

}
