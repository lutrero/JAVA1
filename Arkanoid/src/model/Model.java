package model;


import java.awt.Graphics2D;
import java.util.List;

import stuff.Bala;
import stuff.Bloque;
import stuff.Bola;
import stuff.Obstaculos;
import stuff.Premio;
import view.View;

public interface Model {

	public void setView(View view);

	public void gameCicle();
	
	public void  addBola();
	
	public void addBola(Bola b);
	
	public void nextLevel();
	
	public void addPremio(Premio p);
	
	public void addBala(Bala b);
	
	public void setBloques(List<List<Bloque>> bloques);
	
	public void setObs(List<Obstaculos> obs);
	
	public void paintAll(Graphics2D g);

	public void setBarPos(int x, int y);

	public int getPuntuacion();
	
	
}
