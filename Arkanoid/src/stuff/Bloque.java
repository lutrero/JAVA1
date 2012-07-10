package stuff;

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
		if(b.contains(getCentroX(), getMaxY())){
			toques--;
			if ( b.getVy() < 0)
				b.invertVy();
		}else if ( b.contains(getCentroX(), getMinY())){
			toques--;
			if (b.getVy() > 0)
				b.invertVy();
		}else if( b.contains(getMinX(), getCentroY()) ){
			toques--;
			if (b.getVx() > 0)
				b.invertVx();
		}else if( b.contains(getMaxX(), getCentroY())){
			toques--;
			if(b.getVx() < 0 )
				b.invertVx();
		}
	}
	
}
