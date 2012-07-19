package stuff;

public class Bola extends Circular implements Fisica, Accelerates{
	
	private float vx, vy;
	private boolean viva;
	private static int ANCHOFRAME, ALTOFRAME;

	public Bola() {
		super("", 250, 100, 5);
		vx = vy = 0;
		viva = true;
		ANCHOFRAME = ALTOFRAME = 500;
	}


	public Bola(String name, int centroX, int centroY, int radio, int anchoFrame, int altoFrame) {
		super(name, centroX, centroY, radio);
		vx = 0f;
		vy = 0;
		viva = true;
		ALTOFRAME = altoFrame;
		ANCHOFRAME = anchoFrame;
		
	}
	
	
	
	public Bola(String name, int centroX, int centroY, int radio, int anchoFrame, int altoFrame, float vx, float vy) {
		super(name, centroX, centroY, radio);
		this.vx = vx;
		this.vy = vy;
		this.viva = true;
	}


	public boolean isAlive(){
		return viva;
	}
	
	public void killBall(){
		viva = false;
		vx = vy = 0;
	}
	
	public void invertVx(){
		vx = -vx;
	}
	
	public void invertVy(){
		vy = -vy;
	}
	
	@Override
	public void fisica(float dt){
		super.incrementaX( (int) (vx * dt));
		super.incrementaY((int)(vy * dt));
		 if (vx < 0 && getCentroX() <= getRadio() || vx > 0 && getCentroX() + getRadio() >= ANCHOFRAME)
	            vx = -vx;
	     if (vy < 0 && getCentroY() < getRadio() || vy > 0 && getCentroY() + getRadio() >= ALTOFRAME)
	            vy = -vy;
	}

	
	
	public float getVx() {
		return vx;
	}


	public void setVx(float vx) {
		this.vx = vx;
	}


	public float getVy() {
		return vy;
	}


	public void setVy(float vy) {
		this.vy = vy;
	}


	public int getANCHOFRAME() {
		return ANCHOFRAME;
	}


	public void setANCHOFRAME(int aNCHOFRAME) {
		ANCHOFRAME = aNCHOFRAME;
	}


	public int getALTOFRAME() {
		return ALTOFRAME;
	}


	public void setALTOFRAME(int aLTOFRAME) {
		ALTOFRAME = aLTOFRAME;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(vx);
		result = prime * result + Float.floatToIntBits(vy);
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
		Bola other = (Bola) obj;
		if (Float.floatToIntBits(vx) != Float.floatToIntBits(other.vx))
			return false;
		if (Float.floatToIntBits(vy) != Float.floatToIntBits(other.vy))
			return false;
		return true;
	}


	@Override
	public void accelX() {
		if (vx < 0 && vx > -250)
			vx -= 10f;
		else if(vx > 0 && vx < 250)
			vx += 10f;
	}


	@Override
	public void accelY() {
		if (vy < 50 && vy > 400)
			vy -= 20f;
		else if(vy > 0 && vy < 400)
			vy += 20f;
		else vy += 20f;
	}


	@Override
	public void deccelX() {
		if (vx < 0)
			vx += 10f;
		else if( vx < 310)
			vx -= 10f;
	}


	@Override
	public void deccelY() {
		if (vy < 50 && vy > 400)
			vy += 20f;
		else if(vy > 0 && vy < 400)
			vy -= 20f;
		else vy -= 20f;
	}


	@Override
	public void startM() {
		vx = 100f;
		vy = -300f;
	}


	@Override
	public void stopM() {
		vx = vy = 0;
	}
	
	
	
}
