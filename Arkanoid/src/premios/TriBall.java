package premios;

import controller.Controller;
import stuff.Bola;

public class TriBall extends Premio{

	public TriBall() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TriBall(String name, float vy) {
		super(name, vy);
	}

	@Override
	public void presentCached(Controller c) {
		super.presentCached(c);
		super.setKill(true);
		c.addBola(new Bola("bullet.png", getBola().getCentroX(), getBola().getCentroY(), getBola().getRadio(), getBola().getANCHOFRAME(), getBola().getALTOFRAME(), 200f, -150f));
		c.addBola(new Bola("bullet.png", getBola().getCentroX(), getBola().getCentroY(), getBola().getRadio(), getBola().getANCHOFRAME(), getBola().getALTOFRAME(), 150f, -300f));
		c.addBola(new Bola("bullet.png", getBola().getCentroX(), getBola().getCentroY(), getBola().getRadio(), getBola().getANCHOFRAME(), getBola().getALTOFRAME(), -200f, 100f));
	}	

}
