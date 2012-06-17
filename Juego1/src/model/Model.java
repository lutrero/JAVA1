package model;

import java.awt.Graphics2D;

import view.View;
import controller.Controller;

public interface Model {
	
	public void setView(View v);
	
	public void tryPaintBoxes(Graphics2D g);
	
	public void tryPaintBullet(Graphics2D g);
	
	public void tryPaintBar(Graphics2D g);

	public void updateState();

}
