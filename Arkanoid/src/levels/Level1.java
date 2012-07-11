package levels;

import java.util.ArrayList;
import java.util.List;

import obstaculos.Obstaculos;

import stuff.Bloque;

public class Level1 implements Levels {
	
	private int nBloques;
	private List<List<Bloque>> bloques;
	private List<Obstaculos> obs;
	
	
	
	
	public Level1() {
		super();
		nBloques = 300;
		bloques = new ArrayList<List<Bloque>>();
	}

	@Override
	public int getNBlocks() {
		return nBloques;
	}

	@Override
	public List<List<Bloque>> getBlocks() {
		return bloques;
	}

	@Override
	public List<List<Bloque>> generateBlocks() {
		for(int i = 1; i <= 50; i++){
			bloques.add(new ArrayList<Bloque>());
			for (int j = 1; j <= 6; j++){
				if(j == 10 || j == 1)
					bloques.get(i-1).add(new Bloque("block1.png", i*10, j*10, 10, 10, 1, null));
				else if ( j == 5)
					bloques.get(i-1).add(new Bloque("Nebulosa.jpg", i*10, j*10, 10, 10, 2, null));
				else
					bloques.get(i-1).add(new Bloque("block1.png", i*10, j*10, 10, 10, 1, null));
			}
		}
		
		
		return bloques;
	}
	
	@Override
	public void downBlock() {
		nBloques--;
	}

}
