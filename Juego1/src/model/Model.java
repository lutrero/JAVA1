package model;

import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import stuff.Bullet;
import view.View;

public interface Model {
	
	public void setView(View v);
	
	public void tryPaintBoxes(Graphics2D g);
	
	public void tryPaintBullet(Graphics2D g);
	
	public void tryPaintBar(Graphics2D g);

	public void updateState() throws InterruptedException;

//	public void defaultBulletPos();

	public KeyListener getKeyListener();
	
	public void generateBoxes();

	public void phisics(float dt);

	public void addBullet();
	
	public void addBullet(Bullet b);
	
	public void addBullet(float x , float y);
	
	public void addBullet(float x , float y, float vx, float vy);
	
	public int getnBullets();
}
