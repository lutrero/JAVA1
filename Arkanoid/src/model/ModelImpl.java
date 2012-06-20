package model;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import javax.swing.SwingUtilities;

import stuff.Boxes;
import stuff.Bullet;
import view.View;

public class ModelImpl implements Model {

	private static final Rectangle2D deadZone = new Rectangle2D.Float(0, 499, 500, 1);
	
	private Vector<Vector<Boxes>> boxes;
	private Vector<Bullet> bullets;
	private RoundRectangle2D bar;
	private View view;
	private int nBullets, lifes;
	
	
	public ModelImpl(){
		super();
		boxes = new Vector<Vector<Boxes>>();
		generateBoxes();
		bullets = new Vector<Bullet>();
		view = null;
		nBullets = 0;
		lifes = 10;
		bar = new RoundRectangle2D.Float(225, 390, 50, 10, 10, 10);
	}
	
	public void generateBoxes(){
		for(int i = 0; i <= 50; i++){
			boxes.add(new Vector<Boxes>());
			for (int j = 0; j <= 10; j++){
				if(j == 10 || j == 0)
					boxes.get(i).add(new Boxes(new Rectangle2D.Float(i*10, j*10, 10, 10), 2));
				else if ( j == 5)
					boxes.get(i).add(new Boxes(new Rectangle2D.Float(i*10, j*10, 10, 10), 3));
				else
					boxes.get(i).add(new Boxes(new Rectangle2D.Float(i*10, j*10, 10, 10), 1));
			}
		}
	}
	
	public synchronized void gameCicle(){
		 long tiempoViejo = System.nanoTime();
	        while (true) {
	            long tiempoNuevo = System.nanoTime();
	            float dt = (tiempoNuevo - tiempoViejo) / 1000000000f;
	            tiempoViejo = tiempoNuevo;
	            controles();
	            fisica(dt);
	            dibuja();
	        }
	}

	private void dibuja() {
		try {
			SwingUtilities.invokeAndWait(view.getGameZone());
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void fisica(float dt) {
		synchronized (bullets) {
		for(Bullet b : bullets)
			b.fisica(dt);
		}
	}

	private void controles() {
		for(Bullet b : bullets)
			if (b.getBullet().intersects(deadZone)){
				nBullets--;
				if(nBullets == 0) lifes--;
				b.stopM();
			}else{
				if (b.getBullet().intersects(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight())){
					if(b.getVy() > 0)
						b.invertVy();
					if(b.getBullet().getMaxX() < bar.getCenterX()){
						if(b.getVx() > 0){
							b.deccelX();
							if(b.getBullet().getMinX() < bar.getMinX())
								b.invertVx();
						}else
							b.accelX();
					}else if(b.getBullet().getMinX() > bar.getCenterX()){
						if (b.getVx() < 0){
							b.deccelX();
							if(b.getBullet().getMaxX() > bar.getMaxX())
								b.invertVx();
						}else
							b.accelX();
					}else if(b.getBullet().getCenterX() == bar.getCenterX()){
						b.deccelX();
					}
				}
		}
		synchronized (bullets) {
		for(Vector<Boxes> l : boxes)
			for(Boxes b : l)
				for(Bullet bu : bullets){
					if(bu.getBullet().contains(b.getBox().getCenterX(), b.getBox().getMaxY()) && b.getTouches() != 0){
						b.setTouches(b.getTouches() - 1);
						if ( bu.getVy() < 0)
							bu.invertVy();
					}else if ( bu.getBullet().contains(b.getBox().getCenterX(), b.getBox().getMinY()) && b.getTouches() != 0){
						b.setTouches(b.getTouches() - 1);
						if (bu.getVy() > 0)
							bu.invertVy();
					}else if( bu.getBullet().contains(b.getBox().getMinX(), b.getBox().getCenterY()) && b.getTouches() != 0){
						b.setTouches(b.getTouches() - 1);
						if (bu.getVx() > 0)
							bu.invertVx();
					}else if( bu.getBullet().contains(b.getBox().getMaxX(), b.getBox().getCenterY()) && b.getTouches() != 0){
						b.setTouches(b.getTouches() - 1);
						if(bu.getVx() < 0 )
							bu.invertVx();
				}
		}}
	}

	@Override
	public void addBullet() {
		if(bullets.size() - nBullets > 20)
			checkBulletVector();
		nBullets++;
		bullets.add(new Bullet(250,480, 100, -300));
		System.out.println(bullets.size());
	}

	private void checkBulletVector() {
		Vector<Bullet> aux = bullets;
		Vector<Bullet> aux2 = new Vector<Bullet>();
		for(Bullet b : aux)
			if(b.isOn())
				aux2.add(b);
		bullets = aux2;
	}

	@Override
	public void addBullet(Bullet b) {
		if(bullets.size() - nBullets > 20)
			checkBulletVector();
		nBullets++;
		bullets.add(b);
	}

	@Override
	public void addBullet(float x, float y) {
		if(bullets.size() - nBullets > 20)
			checkBulletVector();
		nBullets++;
		bullets.add(new Bullet(x, y, 100, -300));
	}

	@Override
	public void addBullet(float x, float y, float vx, float vy) {
		if(bullets.size() - nBullets > 20)
			checkBulletVector();
		nBullets++;
		bullets.add(new Bullet(x, y, vx, vy));
	}

	@Override
	public int getnBullets() {
		return nBullets;
	}

	@Override
	public void setView(View v) {
		view = v;
	}

	@Override
	public void tryPaintBoxes(Graphics2D g) {
		for(Vector<Boxes> l : boxes)
			for(Boxes b : l)
				if(b.getTouches() != 0){
					if(b.getTouches() == 1)
					g.setPaint(new GradientPaint((float)b.getBox().getX(),(float) b.getBox().getY(), Color.GRAY,(float) b.getBox().getCenterX(),(float) b.getBox().getY(), Color.blue, true));
					else if(b.getTouches() == 2)
						g.setPaint(new GradientPaint((float)b.getBox().getX(),(float) b.getBox().getY(), Color.RED,(float) b.getBox().getCenterX(),(float) b.getBox().getY(), Color.ORANGE, true));
					else if (b.getTouches() == 3)
						g.setPaint(new GradientPaint((float)b.getBox().getX(),(float) b.getBox().getY(), Color.white,(float) b.getBox().getCenterX(),(float) b.getBox().getY(), Color.GRAY, true));
					g.fill(b.getBox());
					g.setColor(Color.BLACK);
					g.draw(b.getBox());
				}
	}

	@Override
	public void tryPaintBar(Graphics2D g) {
		bar.setFrame(view.getBarX(), view.getBarY(), 50, 10);
		g.setPaint(new GradientPaint((float)bar.getX(),(float) bar.getY(), Color.RED,(float) bar.getCenterX(),(float) bar.getY(), Color.WHITE, true));
		g.fill(bar);
	}

	@Override
	public void tryPaintBullets(Graphics2D g) {
		for (Bullet b : bullets)
			if(b.isOn())
				b.paintBullet(g);
	}

	@Override
	public void startM() {
		addBullet();
	}
}
