package model;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



import stuff.Boxes;
import stuff.Bullet;
import view.View;

public class ModelImp implements Model {
	
	private static final Rectangle2D deadZone = new Rectangle2D.Float(0, 499, 500, 1);
	
	private List<List<Boxes>> boxes;
	private List<Bullet> bullets;
	private RoundRectangle2D bar;
	private View view;
	private ListenerKeyBoard l;
	private int nBullets;
//	private Ellipse2D bullet;
	
	
	public ModelImp() {
		super();
		boxes = new ArrayList<List<Boxes>>();
		bar = new RoundRectangle2D.Float(225, 390, 50, 10, 10, 10);
//		bullet = new Ellipse2D.Float(245, 380, 10, 10);
		bullets = new LinkedList<Bullet>();
		view = null;
		l = new ListenerKeyBoard();
		nBullets = 0;
		generateBoxes();
	}
	
	public void generateBoxes(){
		for(int i = 0; i <= 50; i++){
			boxes.add(new ArrayList<Boxes>());
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

	@Override
	public void setView(View v) {
		view = v;
	}

	@Override
	public void tryPaintBoxes(Graphics2D g) {
		for(List<Boxes> l : boxes)
			for(Boxes b : l)
				if(b.getTouches() != 0){
					if(b.getTouches() == 1)
//						g.setColor(Color.BLUE);
					g.setPaint(new GradientPaint((float)b.getBox().getX(),(float) b.getBox().getY(), Color.GRAY,(float) b.getBox().getCenterX(),(float) b.getBox().getY(), Color.blue, true));
					else if(b.getTouches() == 2)
//						g.setColor(Color.RED);
						g.setPaint(new GradientPaint((float)b.getBox().getX(),(float) b.getBox().getY(), Color.RED,(float) b.getBox().getCenterX(),(float) b.getBox().getY(), Color.ORANGE, true));
					else if (b.getTouches() == 3)
//						g.setColor(Color.GRAY);
						g.setPaint(new GradientPaint((float)b.getBox().getX(),(float) b.getBox().getY(), Color.white,(float) b.getBox().getCenterX(),(float) b.getBox().getY(), Color.GRAY, true));
					g.fill(b.getBox());
					g.setColor(Color.BLACK);
					g.draw(b.getBox());
				}
	}

	@Override
	public void tryPaintBullet(Graphics2D g) {
//		bullet.setFrame(view.getFisicsX(), view.getFisicsY(), 10, 10);
//		g.setPaint(new GradientPaint((float)bullet.getX(),(float) bullet.getY(), Color.GREEN,(float) bullet.getCenterX(),(float) bullet.getY(), Color.YELLOW, true));
//		g.fill(bullet);
		for (Bullet b : bullets)
			b.paintBullet(g);
	}

	@Override
	public void tryPaintBar(Graphics2D g) {
		bar.setFrame(view.getBarX(), view.getBarY(), 50, 10);
//		bar.setFrame(l.x, 490, 50, 10);
		g.setPaint(new GradientPaint((float)bar.getX(),(float) bar.getY(), Color.RED,(float) bar.getCenterX(),(float) bar.getY(), Color.WHITE, true));
		g.fill(bar);
	}

	@Override
	public void phisics(float dt) {
		for (Bullet b : bullets)
			b.fisica(dt);
	}

	@Override
	public void updateState() throws InterruptedException {
		for(Bullet b : bullets)
			if (b.getBullet().intersects(deadZone)){
				bullets.remove(b);
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
//		if (bullet.intersects(deadZone)){
//				view.setFisicsY(480);
//				view.stopM();
//		}else{
//			if (bullet.intersects(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight())){
//				if(view.getVy() > 0)
//					view.invertVy();
//				if(bullet.getMaxX() < bar.getCenterX()){
//					if(view.getVx() > 0){
//						view.deccelX();
//						if(bullet.getMinX() < bar.getMinX())
//							view.invertVx();
//					}else
//						view.accelX();
//				}else if(bullet.getMinX() > bar.getCenterX()){
//					if (view.getVx() < 0){
//						view.deccelX();
//						if(bullet.getMaxX() > bar.getMaxX())
//							view.invertVx();
//					}else
//						view.accelX();
//				}else if(bullet.getCenterX() == bar.getCenterX()){
//					view.deccelX();
//				}
//		}
		}
		for(List<Boxes> l : boxes)
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
			}
				
					
	}

	@Override
	public void addBullet() {
		nBullets++;
		bullets.add(new Bullet(250,480, 100, -300));
	}

	@Override
	public void addBullet(Bullet b) {
		nBullets++;
		bullets.add(b);
	}
	
	@Override
	public void addBullet(float x, float y) {
		nBullets++;
		bullets.add(new Bullet(x, y, 100, -300));
	}
	
	@Override
	public void addBullet(float x, float y, float vx, float vy) {
		nBullets++;
		bullets.add(new Bullet(x, y, vx, vy));
	}
	
	//	@Override
//	public void defaultBulletPos() {
//		b.setFrame(0, 480, 10, 10);
//	}

	public int getnBullets() {
		return nBullets;
	}

	@Override
	public KeyListener getKeyListener() {
		return l;
	}

//	@Override
//	public boolean verticalCollision() {
//		for(List<Boxes> l : boxes)
//			for(Boxes b : l)
//				if(b.getTouches() != 0 && bullet.intersects(b.getBox())){
//					b.setTouches(b.getTouches() - 1);
//					return true;
//				}
//		return bullet.intersects(new Rectangle2D.Float((float) bar.getX(),(float) bar.getY(), (float)bar.getWidth(),(float) bar.getHeight()));
//	}
//
//	@Override
//	public boolean lateralCollision() {
//		for(List<Boxes> l : boxes)
//			for(Boxes b : l)
//				if(b.getTouches() != 0 && bullet.contains(b.getBox().getCenterX(), b.getBox().getCenterY())){
//					b.setTouches(b.getTouches() - 1);
//					return true;
//				}
//		return bullet.intersects(new Rectangle2D.Float((float) bar.getX(),(float) bar.getY(), (float)bar.getWidth(),(float) bar.getHeight()));
//	}
	
		

	
	private class ListenerKeyBoard extends KeyAdapter{

		int x;
		ListenerKeyBoard() {
			super();
			x = 240;
		}

		
		@Override
		public void keyPressed(KeyEvent k) {
//			System.out.println(x);
//			System.out.println(k.getKeyCode());
			final KeyEvent ke = k;
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					if(ke.getKeyCode() == 38)
						view.startM();
					if(x >= 0 && x <= 460){
						if(ke.getKeyCode() == 39){
							if (x < 450)
								x += 15;
							else if (x < 460)
								x += 5;
						}else if(ke.getKeyCode() ==37)
							if (x > 10)
								x -= 15;
							else if ( x > 0)
								x -= 5;
					}
				}
			});
			t.run();
//			if(k.getKeyCode() == 38)
//				view.startM();
//			if(x >= 0 && x <= 460){
//				if(k.getKeyCode() == 39){
//					if(x < 450)
//						for(int i = 0; i < 20; i++)
//							x ++;
//					else if (x < 460)
//						for(int i = 0; i < 10; i++)
//							x ++;
//						
//				}else if(k.getKeyCode() ==37)
//					if (x > 10)
//						for(int i = 0; i < 20; i++)
//							x --;
//					else if (x > 0)
//						for(int i = 0; i < 10; i++)
//							x --;
//			}
		}
	}




}
