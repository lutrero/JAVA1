package stuff;

public class Bola extends Circular implements Fisica, Accelerates{
	
	private float vx, vy;
	private static int ANCHOFRAME, ALTOFRAME;

	public Bola() {
		super();
		vx = vy = 0;
		ANCHOFRAME = ALTOFRAME = 0;
	}


	public Bola(String name, int centroX, int centroY, int radio, int anchoFrame, int altoFrame) {
		super(name, centroX, centroY, radio);
		vx = 100f;
		vy = 300f;
		ALTOFRAME = altoFrame;
		ANCHOFRAME = anchoFrame;
		
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
		if (vx < 0 && vx > 400)
			vx -= 20f;
		else if(vx > 0 && vx < 400)
			vx += 20f;
		else vx +=20f;
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
		if (vx < 0 && vx > 400)
			vx += 20f;
		else if(vx > 0 && vx < 400)
			vx -= 20f;
		else vx -= 20f;
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void stopM() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
