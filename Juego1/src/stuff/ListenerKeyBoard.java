package stuff;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ListenerKeyBoard extends KeyAdapter{

	
	public ListenerKeyBoard() {
		super();
	}

	@Override
	public void keyReleased(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent k) {
		System.out.println(k.getKeyCode());
	}
}
