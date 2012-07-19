package premios;

import controller.Controller;

public class LiveUp extends Premio{

	
	public LiveUp(String name, float vy) {
		super(name, vy);
	}

	@Override
	public void presentCached(Controller controller){
		super.presentCached(controller);
		super.setKill(true);
		controller.liveUp();
	}
}
