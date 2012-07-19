package controller;


import java.awt.Graphics2D;

import stuff.Bala;
import stuff.Bola;

import model.Model;

public interface Controller {

	public void setModel(Model model);

	public void tryPaintAll(Graphics2D g);

	public void setBar(int x, int y);

	public void addBola(Bola bola);

	public void addBala(Bala bala);

	public int getBarMinX();

	public int getBarMaxX();

	public int getBarY();

	public void startMoving();

	public void liveUp();

	public void bigBall();

}
