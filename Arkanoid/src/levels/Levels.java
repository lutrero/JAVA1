package levels;

import java.util.List;

import stuff.Bloque;

public interface Levels {
	
	public int getNBlocks();
	
	public List<List<Bloque>> getBlocks();
	
	public List<List<Bloque>> generateBlocks();
	
	public void downBlock();

}
