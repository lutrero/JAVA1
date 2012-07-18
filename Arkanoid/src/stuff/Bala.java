package stuff;

public class Bala extends Circular implements Fisica {

	private float vy;
	private boolean viva;
	

	public Bala() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bala(String name, int centroX, int centroY, int radio) {
		super(name, centroX, centroY, radio);
		vy = 250f;
		viva = true;
	}

	public boolean isViva() {
		return viva;
	}

	public void setViva(boolean viva) {
		this.viva = viva;
	}

	@Override
	public void fisica(float dt) {
		super.incrementaY((int)(vy * dt));
		if (getMinY() <= 0) viva = false;
	}

	@Override
	public void startM() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stopM() {
		// TODO Auto-generated method stub

	}

}
