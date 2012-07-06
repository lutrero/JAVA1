package stuff;

public class Bar extends Rectangular{
	
	private int anchoExt;

	public Bar() {
		super();
		anchoExt = 0;
	}

	public Bar(String name, int centroX, int centroY, int ancho, int alto) {
		super(name, centroX, centroY, ancho, alto);
		anchoExt =  5;
	}

	public int getAnchoExt() {
		return anchoExt;
	}

	public void setAnchoExt(int anchoExt) {
		this.anchoExt = anchoExt;
	}
	
	
}
