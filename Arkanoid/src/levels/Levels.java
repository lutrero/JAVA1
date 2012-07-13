package levels;

import java.util.List;

import obstaculos.Obstaculos;

import stuff.Bloque;

public interface Levels {
	
	public int getNBlocks();
	
	public List<List<Bloque>> getBlocks();
	
	public List<List<Bloque>> generateBlocks();
	
	public List<Obstaculos> getObstaculos();
	
	public void downBlock();

}
