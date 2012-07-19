package premios;

import controller.Controller;

public class BigBall extends Premio{

	
	
	

	public BigBall(String name, float vy) {
		super(name, vy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void presentCached(Controller controller){
		super.presentCached(controller);
		super.setKill(true);
		controller.bigBall();
	}
}
