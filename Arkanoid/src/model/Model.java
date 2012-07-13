package model;


import java.awt.Graphics2D;
import java.util.List;

import controller.Controller;

import obstaculos.Obstaculos;

import premios.Premio;

import stuff.Bala;
import stuff.Bloque;
import stuff.Bola;
import view.View;

public interface Model {

	public void setView(View view);
	
	public void setController(Controller c);

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
