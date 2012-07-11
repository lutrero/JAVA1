package stuff;

public class Bar extends Rectangular{
	
	private int anchoExt;

	public Bar() {
		super();
		anchoExt = 0;
	}

	public Bar(String name, int centroX, int centroY, int ancho, int alto) {
		super(name, centroX, centroY, ancho, alto);
		anchoExt =  8;
	}

	public int getAnchoExt() {
		return anchoExt;
	}

	public void setAnchoExt(int anchoExt) {
		this.anchoExt = anchoExt;
	}
	
	public void resize(boolean big){
		if (big ){
			if ( getAncho() < 100){
				anchoExt += 8;
				setAncho(getAncho() + 16);
			}
		}else{
			anchoExt = 8;
			setAncho(50);
		}
	}

	public void propulsionBola(Bola b) {
		if (b.getVy() > 0)
			b.invertVy();
		if (b.contains(getCentroX(), getMinY())){
			if ( b.getVx() < 0)
				b.setVx(-100f);
			else
				b.setVx(100f);
			b.setVy(-275f);
		}else if (b.contains(getMinX(), getMinY())){
			b.setVx(-300f);
			b.setVy(-150f);
		}else if (b.contains(getMinX() + anchoExt, getMinY()) || b.getCentroX() < (getMinX() + anchoExt)){
			b.setVx(-250f);
			b.setVy(-200f);
		}else if (getCentroX() > b.getCentroX()){
//			for ( int i = (getMinX() + anchoExt); i < getCentroX() ; i++){
				if ( b.getVx() > 0){
					b.deccelX();
					b.invertVx();
				}else
					b.deccelX();
//			}
			b.setVy(-275f);
		}else if (getMaxX() - anchoExt > b.getCentroX()){
//			for ( int i = getCentroX(); i < (getMaxX() - anchoExt) ; i++)
				if(b.getVx() < 0){
					b.deccelX();
					b.invertVx();
				}else
					b.deccelX();
			b.setVy(-275f);
		}else if (b.contains(getMaxX(), getMinY())){
			b.setVx(300f);
			b.setVy(-150f);
		}
			else if (b.contains(getMaxX() - anchoExt, getMinY()) || b.getCentroX() > (getMaxX() - anchoExt)){
			b.setVx(250f);
			b.setVy(-200f);
		}
	}
}
