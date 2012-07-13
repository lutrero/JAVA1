package premios;

import controller.Controller;

public class MachineGun extends Premio{

	public MachineGun() {
		super();
	}

	public MachineGun(String name, float vy) {
		super(name, vy);
	}
	
	@Override
	public void presentCached(Controller c) {
		super.presentCached(c);
		
	}
}
