package model;

import java.awt.Graphics2D;

import stuff.Bullet;
import view.View;

public interface Model {
	
public void addBullet();
	
	public void addBullet(Bullet b);
	
	public void addBullet(float x , float y);
	
	public void addBullet(float x , float y, float vx, float vy);
	
	public int getnBullets();

	public void setView(View v);
	
	public void generateBoxes();

	public void tryPaintBoxes(Graphics2D g);

	public void tryPaintBar(Graphics2D g);

	public void tryPaintBullets(Graphics2D g);

	public void gameCicle();

	public void startM();
}
