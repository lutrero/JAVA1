package controller;

import java.awt.Graphics2D;

import model.Model;

import view.View;

public interface Controller {

	public void tryPaintBoxex(Graphics2D g);

	public void tryPaintBar(Graphics2D g);

	public void tryPaintBullet(Graphics2D g);
	
	public void setView(View v);
	
	public void setModel(Model m);

	public boolean verticalCollision();

	public boolean lateralCollision();
}
