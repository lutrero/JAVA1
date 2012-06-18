package stuff;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ListenerKeyBoard extends KeyAdapter{

	private int x;
	public ListenerKeyBoard() {
		super();
		x = 250;
	}

	
	@Override
	public void keyPressed(KeyEvent k) {
		System.out.println(k.getKeyCode());
		if(x > 25 && x < 475){
			if(k.getKeyCode() == 39){
				x++;
			}else if(k.getKeyCode() ==37);
				x--;
		}
	}
}
