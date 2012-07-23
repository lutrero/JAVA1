package stuff;

import java.awt.Image;

import premios.Premio;

public class Bloque extends Rectangular{
	
	private int toques;
	private Premio premio;
	
	
	public Bloque() {
		super();
		toques = 0;
		premio = null;
	}
	public Bloque(String name, int centroX, int centroY, int ancho, int alto, int toques, Premio premio) {
		super(name, centroX, centroY, ancho, alto);
		this.toques = toques;
		this.premio = premio;
	}
	
	@Override
	public Image getIcon(){
		if (toques == 1){
			super.setIcon("block1.png");
		}else if(toques == 2){
			super.setIcon("block2.png");
		}else if (toques == 3){
			super.setIcon("block3.png");
		}else if (toques == 100){
			super.setIcon("metalblock1.png");
		}else{
			
		}
		return super.getIcon();
			
	}
	
	
	public int getToques() {
		return toques;
	}
	
	public void setToques(int toques) {
		this.toques = toques;
	}
	
	public Premio getPremio() {
		return premio;
	}
	
	public void setPremio(Premio premio) {
		this.premio = premio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((premio == null) ? 0 : premio.hashCode());
		result = prime * result + toques;
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
		Bloque other = (Bloque) obj;
		if (premio == null) {
			if (other.premio != null)
				return false;
		} else if (!premio.equals(other.premio))
			return false;
		if (toques != other.toques)
			return false;
		return true;
	}
	public void reboteBola(Bola b) {
		// TODO Auto-generated method stub
		boolean aux = true;
//		if(contains(b.getCentroX(), b.getMinY()) || contains(b.getCentroX(), b.getMaxY()) || contains(b.getMaxX(), b.getCentroY()) || contains(b.getMinX(), b.getCentroY()))
		if(b.getCentroY() >= getMaxY() && b.getMinY() <= getMaxY()
		&& contains(b.getCentroX(), b.getMinY()) ){
			toques--;
			if ( b.getVy() < 0)
				b.invertVy();
		}else if (b.getCentroY() <= getMinY() && b.getMaxY() >= getMinY()
				&& contains(b.getCentroX(), b.getMaxY())){
			toques--;
			if (b.getVy() > 0)
				b.invertVy();
		}else if (contains(b.getCentroX(), b.getMinY()) || contains(b.getCentroX(), b.getMaxY())){b.invertVy(); toques--; aux = false;}
		if( b.getCentroX() <= getMinX() && b.getMaxX() >= getMinX() 
				&& contains(b.getMaxX(), b.getCentroY())){
			toques--;
			if (b.getVx() > 0)
				b.invertVx();
		}else if(b.getCentroX() >= getMaxX() && b.getMinX() >= getMaxX() 
				&& contains(b.getMinX(), b.getCentroY())){
			toques--;
			if(b.getVx() < 0 )
				b.invertVx();
		}else if ( contains(b.getMaxX(), b.getCentroY()) || contains(b.getMinX(), b.getCentroY())){b.invertVx(); if (aux) toques--; }
	}
	
}
