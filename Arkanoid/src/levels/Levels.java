package levels;

import java.awt.Image;
import java.util.List;

import obstaculos.Obstaculos;

import stuff.Bloque;

public interface Levels {
	
	
	public List<List<Bloque>> getBlocks();
	
	public List<List<Bloque>> generateBlocks();
	
	public List<Obstaculos> getObstaculos();

	public Image getImage();

}
