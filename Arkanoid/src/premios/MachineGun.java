package premios;

import stuff.Bala;
import controller.Controller;

public class MachineGun extends Premio{
	
	private boolean alternate;
	private int count;

	public MachineGun() {
		super();
		alternate = true;
		count = 0;
	}

	public MachineGun(String name, float vy) {
		super(name, vy);
		alternate = true;
		count = 0;
	}
	
	@Override
	public void presentCached(Controller c) {
		super.presentCached(c);
		
	}
	
	private void alternate(){
		if (alternate) alternate = false;
		else alternate = true;
	}
	
	@Override
	public void doAction(Controller controller){
		super.doAction(controller);
		if (super.getStartTime() != 0)
		if(count == 5){
		if (alternate)
			controller.addBala(new Bala("bala.png", controller.getBarMinX(), controller.getBarY(), 4));
		else
			controller.addBala(new Bala("bala.png", controller.getBarMaxX(), controller.getBarY(), 4));
		alternate();
		count = 0;
		}else count++;
	}
}
