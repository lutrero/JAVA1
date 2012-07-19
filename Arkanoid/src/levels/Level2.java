package levels;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import obstaculos.Obstaculos;
import premios.BigBall;
import premios.LiveUp;
import premios.MachineGun;
import premios.TriBall;
import stuff.Bloque;

public class Level2 implements Levels{
	

	private List<List<Bloque>> bloques;
	private List<Obstaculos> obs;

	
	
	
	public Level2() {
		super();
		bloques = new LinkedList<List<Bloque>>();
		obs = null;
	}

	
	
	@Override
	public List<List<Bloque>> getBlocks() {
		return bloques;
	}

	@Override
	public List<List<Bloque>> generateBlocks() {
		for (int i = 1 ; i < 50 ; i++){
			bloques.add(new LinkedList<Bloque>());
			for ( int j = 4 ; j < 10 ; j++){
				if ( j != 7 && i != 25 && j != 6 && i != 26){
					if ( j == 8 && ( i == 15 || i == 40))
						bloques.get(i-1).add(new Bloque("block1.png", i*10, j*10, 10, 10, 3, new BigBall("bigball.png", 150f)));
					else if (j == 4 && i == 24)
						bloques.get(i-1).add(new Bloque("block1.png", i*10, j*10, 10, 10, 3, new LiveUp("liveup.png", 150f)));
					else if (j == 9 && (i == 32 || i == 33 || i == 34) )
						bloques.get(i-1).add(new Bloque("block1.png", i*10, j*10, 10, 10, 3, new MachineGun("Machinegun.png", 150f)));
					else if (j == 8 && i == 4)
						bloques.get(i-1).add(new Bloque("block1.png", i*10, j*10, 10, 10, 3, new TriBall("3ball.png", 150f)));
					else
						bloques.get(i-1).add(new Bloque("block1.png", i*10, j*10, 10, 10, 3, null));
				}
			}
		}
		return bloques;
	}

	@Override
	public List<Obstaculos> getObstaculos() {
		return obs;
	}



	@Override
	public Image getImage() {
		return new ImageIcon(getClass().getResource("/images/neb2.jpg")).getImage();
	}



}
