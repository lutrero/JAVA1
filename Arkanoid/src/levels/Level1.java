package levels;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import obstaculos.Obstaculos;
import premios.MachineGun;
import premios.TriBall;

import stuff.Bloque;

public class Level1 implements Levels {
	

	private List<List<Bloque>> bloques;
	private List<Obstaculos> obs;
	
	
	
	
	public Level1() {
		super();
		bloques = new ArrayList<List<Bloque>>();
		obs = null;
	}

	

	@Override
	public List<List<Bloque>> getBlocks() {
		return bloques;
	}
	

	@Override
	public List<List<Bloque>> generateBlocks() {
		for(int i = 2; i < 16; i++){
			bloques.add(new ArrayList<Bloque>());
			for (int j = 4; j <= 8; j++){
				if(j == 10 || j == 4){
					if (i == 10 || i == 6)
						bloques.get(i-2).add(new Bloque("block1.png", i*30, j*20, 30, 20, 1, new MachineGun("Machinegun.png", 150f)));
					else if (i == 10 || i == 12)
						bloques.get(i-2).add(new Bloque("block1.png", i*30, j*20, 30, 20, 1, new TriBall("3ball.png", 150f)));
					else
						bloques.get(i-2).add(new Bloque("block1.png", i*30, j*20, 30, 20, 1, null));
				}else if ( j == 8)
					bloques.get(i-2).add(new Bloque("Nebulosa.jpg", i*30, j*20, 30, 20, 2, null));
				else
					bloques.get(i-2).add(new Bloque("block1.png", i*30, j*20, 30, 20, 3, null));
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
		return new ImageIcon(getClass().getResource("/images/Nebulosa.jpg")).getImage();
	}

}
