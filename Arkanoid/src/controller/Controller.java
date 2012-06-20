package controller;

import java.awt.Graphics2D;

import model.Model;

public interface Controller {
	
	
	public void setModel(Model m);

	void tryPaintBoxex(Graphics2D g);

	void tryPaintBar(Graphics2D g);

	void tryPaintBullets(Graphics2D g);

	public void startM();

}
